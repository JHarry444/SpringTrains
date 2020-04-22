package com.qa.demo.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.data.domain.Train;

@Repository
public interface TrainRepo extends JpaRepository<Train, Long> {

}
