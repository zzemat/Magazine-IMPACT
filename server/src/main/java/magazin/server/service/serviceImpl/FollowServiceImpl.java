package magazin.server.service.serviceImpl;

import magazin.server.entity.Follow;
import magazin.server.repository.FollowRepository;
import magazin.server.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
        private FollowRepository followRepository;
        

    @Override
    public Follow createFollow(Follow follow) {
        return followRepository.save(follow);
    }

    @Override
    public void deleteFollow(Long userSrcId, Long userTrgId) {
        followRepository.deleteByUserSrcIdAndUserTrgId(userSrcId, userTrgId);
    }

    @Override
    public List<Follow> getFollowing(Long userSrcId) {
        return followRepository.findByUserSrcId(userSrcId);
    }

    @Override
    public List<Follow> getFollowers(Long userTrgId) {
        return followRepository.findByUserTrgId(userTrgId);
    }
}