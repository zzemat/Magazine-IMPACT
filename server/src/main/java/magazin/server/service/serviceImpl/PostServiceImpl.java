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
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Optional<Post> existingPost = postRepository.findById(id);
        if (existingPost.isPresent()) {
            Post updatedPost = existingPost.get();
            // use model mapper to map post to updatedPost. author : @Idir0u
            updatedPost.setTitle(post.getTitle());
            updatedPost.setText(post.getText());
            updatedPost.setTags(post.getTags());
            updatedPost.setPublished(post.getPublished());
            updatedPost.setPublishedAt(post.getPublishedAt());
            updatedPost.setBannerImg(post.getBannerImg());
            updatedPost.setUserId(post.getUserId());
            updatedPost.setComments(post.getComments());
            updatedPost.setReactions(post.getReactions());

            // Update other fields as necessary
            return postRepository.save(updatedPost);
        } else {
            return null;
        }
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}