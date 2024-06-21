package com.gorai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gorai.model.OtherDetails;

@Repository
public interface OtherDetailsRepo extends JpaRepository<OtherDetails,Long>{

}
