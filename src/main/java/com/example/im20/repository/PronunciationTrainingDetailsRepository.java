package com.example.im20.repository;

import com.example.im20.entity.PronunciationTraining;
import com.example.im20.entity.PronunciationTrainingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PronunciationTrainingDetailsRepository extends JpaRepository<PronunciationTrainingDetails, Integer> {
    List<PronunciationTrainingDetails> findByPronunciationTraining(PronunciationTraining pronunciationTraining);
}