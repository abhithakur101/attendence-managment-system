package com.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ams.modal.Sublocation;

@Repository
public interface SubLocRepository extends JpaRepository<Sublocation, Long> {
	
	@Query("select s from Sublocation s where s.locId=:locId")
	public List<Sublocation> getSubLocationByLocId(Long locId);
	

}
