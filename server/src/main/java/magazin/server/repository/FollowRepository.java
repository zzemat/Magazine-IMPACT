package magazin.server.repository;

import magazin.server.entity.Follow;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    void deleteByUserSrcIdAndUserTrgId(Long userSrcId, Long userTrgId);
    List<Follow> findByUserSrcId(Long userSrcId);
    List<Follow> findByUserTrgId(Long userTrgId);
}
