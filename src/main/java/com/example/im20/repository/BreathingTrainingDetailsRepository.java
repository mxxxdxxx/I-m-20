package com.example.im20.repository;

import com.example.im20.entity.BreathingTrainingDetails;
import com.example.im20.entity.BreathingTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreathingTrainingDetailsRepository extends JpaRepository<BreathingTrainingDetails, Integer> {
    List<BreathingTrainingDetails> findByBtSummary(BreathingTraining btSummary);
}
