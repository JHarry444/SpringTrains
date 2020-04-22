package com.qa.demo.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.data.domain.Train;
import com.qa.demo.data.domain.TrainYard;

@Repository
public interface TrainYardRepo extends JpaRepository<TrainYard, Long> {

}
