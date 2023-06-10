package com.example.practicing.Repository;

import com.example.practicing.Entity.PracticeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PracticeRepository extends JpaRepository<PracticeDao, Long> {

}
