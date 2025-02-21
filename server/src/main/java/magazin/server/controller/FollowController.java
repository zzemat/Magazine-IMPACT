package magazin.server.controller;

import magazin.server.entity.Follow;
import magazin.server.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/v1/api/follows")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/create")
    public ResponseEntity<Follow> createFollow(@Valid @RequestBody Follow follow) {
        Follow createdFollow = followService.createFollow(follow);
        return ResponseEntity.ok(createdFollow);
    }

    @DeleteMapping("/{userSrcId}/{userTrgId}")
    public ResponseEntity<Void> deleteFollow(@PathVariable Long userSrcId, @PathVariable Long userTrgId) {
        followService.deleteFollow(userSrcId, userTrgId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/followers/{userId}")
    public List<Follow> getFollowers(@PathVariable Long userId) {
        return followService.getFollowers(userId);
    }

    @GetMapping("/following/{userId}")
    public List<Follow> getFollowing(@PathVariable Long userId) {
        return followService.getFollowing(userId);
    }
}
