package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.modal.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

}
