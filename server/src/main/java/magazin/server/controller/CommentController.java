package magazin.server.controller;

import magazin.server.entity.Comment;
import magazin.server.entity.User;
import magazin.server.service.CommentService;
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

    @Autowired
    public CommentController(CommentService commentService, UserService userService, JwtUtils jwtUtils) {
        this.commentService = commentService;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @GetMapping("/all")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        return (comment != null) ? ResponseEntity.ok(comment) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@Valid @RequestBody Comment comment) {
        Comment createdComment = commentService.createComment(comment);
        return ResponseEntity.ok(createdComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @Valid @RequestBody Comment comment) {
        Comment updatedComment = commentService.updateComment(id, comment);
        return (updatedComment != null) ? ResponseEntity.ok(updatedComment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader) {

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().build();
        }

        String token = authorizationHeader.substring(7);

        Long userId = jwtUtils.getUserIdFromToken(token);
        User userTemp = userService.getUserById(userId);
        Long userCommentId = commentService.getCommentById(id).getProfile().getUser().getId();
        if(userTemp.getId()==userCommentId) {
            commentService.deleteComment(id);
        }

        return ResponseEntity.noContent().build();
    }
}
