package com.example.im20.service;

import com.example.im20.dto.PronunciationTrainingDTO;
import com.example.im20.dto.PronunciationTrainingDetailsDTO;
import com.example.im20.entity.Manage;
import com.example.im20.entity.PronunciationTraining;
import com.example.im20.entity.PronunciationTrainingDetails;
import com.example.im20.repository.ManageRepository;
import com.example.im20.repository.PronunciationTrainingDetailsRepository;
import com.example.im20.repository.PronunciationTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PronunciationTrainingService {

    @Autowired
    private PronunciationTrainingRepository pronunciationTrainingRepository;

    @Autowired
    private PronunciationTrainingDetailsRepository pronunciationTrainingDetailsRepository;

    @Autowired
    private ManageRepository manageRepository;

    @Transactional
    public PronunciationTrainingDTO savePronunciationTraining(PronunciationTrainingDTO dto) {
        Manage manage = manageRepository.findById(dto.getManageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));

        // Save PronunciationTraining
        PronunciationTraining pronunciationTraining = toEntity(dto, manage);
        PronunciationTraining savedTraining = pronunciationTrainingRepository.save(pronunciationTraining);

        // Save PronunciationTraining details
        List<PronunciationTrainingDetails> detailsList = dto.getDetails().stream()
                .map(detailDTO -> toDetailsEntity(detailDTO, savedTraining))
                .collect(Collectors.toList());
        pronunciationTrainingDetailsRepository.saveAll(detailsList);

        return toDTO(savedTraining, detailsList);
    }

    private PronunciationTraining toEntity(PronunciationTrainingDTO dto, Manage manage) {
        return PronunciationTraining.builder()
                .manage(manage)
                .ptAttempt(dto.getPtAttempt())
                .ptSuccessCnt(dto.getPtSuccessCnt())
                .build();
    }

    private PronunciationTrainingDetails toDetailsEntity(PronunciationTrainingDetailsDTO dto, PronunciationTraining training) {
        return PronunciationTrainingDetails.builder()
                .pronunciationTraining(training)
                .ptWord(dto.getPtWord())
                .ptText(dto.getPtText())
                .ptChildVoice(dto.getPtChildVoice())
                .ptTeacherVoice(dto.getPtTeacherVoice())
                .ptScore(dto.getPtScore())
                .ptFeedback(dto.getPtFeedback())
                .ptIndex(dto.getPtIndex())
                .build();
    }

    private PronunciationTrainingDTO toDTO(PronunciationTraining entity, List<PronunciationTrainingDetails> detailsList) {
        List<PronunciationTrainingDetailsDTO> detailsDTOs = detailsList.stream()
                .map(this::toDetailsDTO)
                .collect(Collectors.toList());

        return PronunciationTrainingDTO.builder()
                .pronunciationTrainingId(entity.getPronunciationTrainingId())
                .manageId(entity.getManage().getManageId())
                .ptAttempt(entity.getPtAttempt())
                .ptSuccessCnt(entity.getPtSuccessCnt())
                .details(detailsDTOs)
                .build();
    }

    private PronunciationTrainingDetailsDTO toDetailsDTO(PronunciationTrainingDetails entity) {
        return PronunciationTrainingDetailsDTO.builder()
                .detailId(entity.getPtDetailId())
                .pronunciationTrainingId(entity.getPronunciationTraining().getPronunciationTrainingId())
                .ptWord(entity.getPtWord())
                .ptText(entity.getPtText())
                .ptChildVoice(entity.getPtChildVoice())
                .ptTeacherVoice(entity.getPtTeacherVoice())
                .ptScore(entity.getPtScore())
                .ptFeedback(entity.getPtFeedback())
                .ptIndex(entity.getPtIndex())
                .build();
    }

    @Transactional(readOnly = true)
    public PronunciationTrainingDTO getPronunciationTrainingById(Integer id) {
        PronunciationTraining training = pronunciationTrainingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid PronunciationTraining ID"));

        List<PronunciationTrainingDetails> detailsList = pronunciationTrainingDetailsRepository.findByPronunciationTraining(training);
        return toDTO(training, detailsList);
    }
}


//package com.example.im20.service;
//
//import com.example.im20.dto.PronunciationTrainingDTO;
//import com.example.im20.dto.PronunciationTrainingDetailsDTO;
//import com.example.im20.entity.PronunciationTraining;
//import com.example.im20.entity.PronunciationTrainingDetails;
//import com.example.im20.entity.Manage;
//import com.example.im20.repository.PronunciationTrainingRepository;
//import com.example.im20.repository.PronunciationTrainingDetailsRepository;
//import com.example.im20.repository.ManageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class PronunciationTrainingService {
//
//    @Autowired
//    private PronunciationTrainingRepository pronunciationTrainingRepository;
//
//    @Autowired
//    private PronunciationTrainingDetailsRepository pronunciationTrainingDetailsRepository;
//
//    @Autowired
//    private ManageRepository manageRepository;
//
//    @Transactional
//    public PronunciationTrainingDTO savePronunciationTraining(PronunciationTrainingDTO dto) {
//        Manage manage = manageRepository.findById(dto.getManageId())
//                .orElseThrow(() -> new IllegalArgumentException("Invalid manage ID"));
//
//        PronunciationTraining pronunciationTraining = toEntity(dto, manage);
//        PronunciationTraining savedPronunciationTraining = pronunciationTrainingRepository.save(pronunciationTraining);
//
//        List<PronunciationTrainingDetails> detailsList = dto.getDetails().stream()
//                .map(detailDTO -> toDetailsEntity(detailDTO, savedPronunciationTraining))
//                .collect(Collectors.toList());
//        pronunciationTrainingDetailsRepository.saveAll(detailsList);
//
//        return toDTO(savedPronunciationTraining, detailsList);
//    }
//
//    private PronunciationTraining toEntity(PronunciationTrainingDTO dto, Manage manage) {
//        return PronunciationTraining.builder()
//                .ptAttempt(dto.getPtAttempt())
//                .ptSuccessCnt(dto.getPtSuccessCnt())
//                .manage(manage)
//                .build();
//    }
//
//    private PronunciationTrainingDetails toDetailsEntity(PronunciationTrainingDetailsDTO dto, PronunciationTraining pronunciationTraining) {
//        return PronunciationTrainingDetails.builder()
//                .pronunciationTraining(pronunciationTraining)
//                .ptWord(dto.getPtWord())
//                .ptText(dto.getPtText())
//                .ptChildVoice(dto.getPtChildVoice())
//                .ptTeacherVoice(dto.getPtTeacherVoice())
//                .ptScore(dto.getPtScore())
//                .ptFeedback(dto.getPtFeedback())
//                .ptIndex(dto.getPtIndex())
//                .build();
//    }
//
//    private PronunciationTrainingDTO toDTO(PronunciationTraining entity, List<PronunciationTrainingDetails> detailsList) {
//        List<PronunciationTrainingDetailsDTO> detailsDTOs = detailsList.stream()
//                .map(this::toDetailsDTO)
//                .collect(Collectors.toList());
//
//        return PronunciationTrainingDTO.builder()
//                .pronunciationTrainingId(entity.getPronunciationTrainingId())
//                .ptAttempt(entity.getPtAttempt())
//                .ptSuccessCnt(entity.getPtSuccessCnt())
//                .manageId(entity.getManage().getManageId())
//                .details(detailsDTOs)
//                .build();
//    }
//
//    private PronunciationTrainingDetailsDTO toDetailsDTO(PronunciationTrainingDetails entity) {
//        return PronunciationTrainingDetailsDTO.builder()
//                .ptDetailId(entity.getPtDetailId())
//                .ptWord(entity.getPtWord())
//                .ptText(entity.getPtText())
//                .ptChildVoice(entity.getPtChildVoice())
//                .ptTeacherVoice(entity.getPtTeacherVoice())
//                .ptScore(entity.getPtScore())
//                .ptFeedback(entity.getPtFeedback())
//                .ptIndex(entity.getPtIndex())
//                .build();
//    }
//
//    @Transactional(readOnly = true)
//    public PronunciationTrainingDTO getPronunciationTrainingById(Integer id) {
//        PronunciationTraining pronunciationTraining = pronunciationTrainingRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid PronunciationTraining ID"));
//
//        List<PronunciationTrainingDetails> detailsList = pronunciationTrainingDetailsRepository.findByPronunciationTraining(pronunciationTraining);
//        return toDTO(pronunciationTraining, detailsList);
//    }
//}
