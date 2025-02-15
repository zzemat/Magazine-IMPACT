package magazin.server.controller;

import magazin.server.entity.Follow;
import magazin.server.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follows")
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping
    public List<Follow> getAllFollows() {
        return followService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Follow> getFollowById(@PathVariable Long id) {
        return followService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Follow createFollow(@RequestBody Follow follow) {
        return followService.save(follow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Follow> updateFollow(@PathVariable Long id, @RequestBody Follow followDetails) {
        return followService.update(id, followDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollow(@PathVariable Long id) {
        if (followService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}