package im20.repository;

import im20.entity.FluencyTraining;
import im20.entity.Manage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FluencyTrainingRepository extends JpaRepository<FluencyTraining, Integer> {
    List<FluencyTraining> findByManage(Manage manage);
}
