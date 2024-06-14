package com.example.im20.repository;

import com.example.im20.entity.Manage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ManageRepository extends JpaRepository<Manage, Integer> {

    @Query("SELECT m FROM Manage m WHERE m.user.userId = :userId AND DATE(m.manageDate) = DATE(:manageDate)")
    Optional<Manage> findByUserIdAndManageDate(Integer userId, Date manageDate);
}
