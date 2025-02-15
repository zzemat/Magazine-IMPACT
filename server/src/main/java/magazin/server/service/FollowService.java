package magazin.server.service;

import magazin.server.entity.Follow;

import java.util.List;

public interface FollowService {
    Follow createFollow(Follow follow);
    void deleteFollow(Long userSrcId, Long userTrgId);
    List<Follow> getFollowers(Long userId);
    List<Follow> getFollowing(Long userId);
}