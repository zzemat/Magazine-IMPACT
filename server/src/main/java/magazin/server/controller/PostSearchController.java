package magazin.server.controller;

import magazin.server.entity.Post;
import magazin.server.repository.PostRepository;
import magazin.server.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/search/post")
public class PostSearchController {

    @Autowired
    PostRepository postRepository;

    @PostMapping("/{title}")
    public ResponseEntity<List<Post>> search(@PathVariable String title) {
        Optional<List<Post>> posts = postRepository.findAllByTitle(title);
        return posts.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
