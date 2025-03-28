package magazin.server.controller;

import magazin.server.entity.Post;
import magazin.server.repository.PostRepository;
import magazin.server.requests.PostSearchRequest;
import magazin.server.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/search/post")
public class PostSearchController {

    @Autowired
    PostRepository postRepository;

    @PostMapping("/")
    public ResponseEntity<List<Post>> search(@RequestBody PostSearchRequest request) {
        // note : this probably can be refactored in the future
        Optional<List<Post>> posts;
        if (request.getTags() == null || request.getTags().isEmpty()) {
            posts = postRepository.findAllByTitle(request.getTitle());
        } else {
            posts = postRepository.findAllByTitleAndTags(request.getTitle(), request.getTags());
        }
        return posts.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
