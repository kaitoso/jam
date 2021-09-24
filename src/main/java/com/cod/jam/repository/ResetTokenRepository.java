package com.cod.jam.repository;

import com.cod.jam.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetTokenRepository extends JpaRepository<ResetToken, Integer> {

        //from ResetToken where token = :?
        ResetToken findByToken(String token);
        }
