package com.example.im20.repository;

import com.example.im20.entity.PronunciationTraining;
import com.example.im20.entity.Manage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PronunciationTrainingRepository extends JpaRepository<PronunciationTraining, Integer> {
    List<PronunciationTraining> findByManage(Manage manage);
}
