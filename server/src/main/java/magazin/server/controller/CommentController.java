package magazin.server.controller;

import magazin.server.DTO.CommentDTO;
import magazin.server.entity.Comment;
import magazin.server.entity.Post;
import magazin.server.entity.Profile;
import magazin.server.entity.User;
import magazin.server.repository.CommentRepository;
import magazin.server.repository.PostRepository;
import magazin.server.service.CommentService;
import magazin.server.service.PostService;
import magazin.server.service.UserService;
import magazin.server.service.serviceImpl.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/comments")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;

    private final JwtUtils jwtUtils;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostService postService;

    @Autowired
    public CommentController(CommentService commentService, UserService userService, JwtUtils jwtUtils, PostRepository postRepository, CommentRepository commentRepository, PostService postService) {
        this.commentService = commentService;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    // maybe check if the post exists
    @GetMapping("/post/{id}")
    public List<Comment> getAllComments(@PathVariable Long id) {
        return commentRepository.findAllByPostId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        return (comment != null) ? ResponseEntity.ok(comment) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody @Valid CommentDTO comment, @RequestHeader("Authorization") String authorizationHeader) {
        // checking that the post exists
        Optional<Post> post = postRepository.findById(comment.getPostId());
        System.out.println(comment);
        if (post.isEmpty()) {
            System.out.println("Post not found");
            return ResponseEntity.notFound().build();
        }

        // getting the user
        Profile userProfile = jwtUtils.getProfile(authorizationHeader);
        if (userProfile == null) {
            return ResponseEntity.status(403).build();
        }

        // creating the comment
        Comment createdComment = new Comment();
        createdComment.setProfile(userProfile);
        createdComment.setContent(comment.getContent());
        createdComment.setPost(post.get());
        commentRepository.save(createdComment);
        return ResponseEntity.ok(createdComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody @Valid CommentDTO comment, @RequestHeader("Authorization") String authorizationHeader) {
        // getting the user
        Profile userProfile = jwtUtils.getProfile(authorizationHeader);
        if (userProfile == null) {
            return ResponseEntity.status(403).build();
        }

        // getting the comment
        Optional<Comment> oldComment = commentRepository.findById(id);
        if (oldComment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // checking if the user owns the comment
        if (!oldComment.get().getProfile().getId().equals(userProfile.getId())) {
            return ResponseEntity.status(403).build();
        }

        // updating the comment
        Comment updatedComment = oldComment.get();
        updatedComment.setContent(comment.getContent());
        commentRepository.save(updatedComment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id, @RequestHeader("Authorization") String authorizationHeader) {

        // getting the user
        Profile userProfile = jwtUtils.getProfile(authorizationHeader);
        if (userProfile == null) {
            return ResponseEntity.status(403).build();
        }

        // getting the comment
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // checking if the user owns the comment
        if (!comment.get().getProfile().getId().equals(userProfile.getId())) {
            return ResponseEntity.status(403).build();
        }

        commentRepository.delete(comment.get());
        return ResponseEntity.noContent().build();
    }
}
