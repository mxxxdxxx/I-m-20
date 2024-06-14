package com.example.im20.repository;

import com.example.im20.entity.BreathingTraining;
import com.example.im20.entity.Manage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreathingTrainingRepository extends JpaRepository<BreathingTraining, Integer> {
    List<BreathingTraining> findByManage(Manage manage);
}
