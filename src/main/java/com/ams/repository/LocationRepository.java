package com.ams.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.modal.Location;

@Repository
@Transactional
public interface LocationRepository extends JpaRepository<Location,Long> {

}
