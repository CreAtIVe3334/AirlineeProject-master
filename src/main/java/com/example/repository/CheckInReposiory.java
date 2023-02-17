package com.example.repository;

import com.example.entity.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInReposiory extends JpaRepository<Checkin,Integer> {
}
