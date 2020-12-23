package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Contest;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Long>{

}
