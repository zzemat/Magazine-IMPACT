package magazin.server.repository;

import magazin.server.entity.Follow;
import magazin.server.entity.Follow.FollowId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, FollowId> {

    void deleteByIdUserSrcIdAndIdUserTrgId(Long userSrcId, Long userTrgId);

    List<Follow> findByIdUserSrcId(Long userSrcId);

    List<Follow> findByIdUserTrgId(Long userTrgId);
}
