package magazin.server.service.serviceImpl;

import magazin.server.entity.Post;
import magazin.server.service.PostService;
import magazin.server.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Optional<Post> existingPost = postRepository.findById(id);
        //use mappers to update the existingPost !!!!!!!!!!!!! author: @Idir0u
        if (existingPost.isPresent()) {
            // Set the ID to the updatedPost and save it
            post.setId(id);
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}