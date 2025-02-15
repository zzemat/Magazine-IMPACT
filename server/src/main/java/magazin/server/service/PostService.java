package magazin.server.service;

import magazin.server.entity.Post;
import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post getPostById(Long id);
    List<Post> getAllPosts();
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
}