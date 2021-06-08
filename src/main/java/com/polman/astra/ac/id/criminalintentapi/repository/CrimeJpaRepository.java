package com.polman.astra.ac.id.criminalintentapi.repository;

import com.polman.astra.ac.id.criminalintentapi.vo.Crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Repository("CrimeJpaRepository")
public interface CrimeJpaRepository extends JpaRepository<Crime, Serializable> {
    Crime getCrimeById(String id);

    List<Crime> findAllByOrderByIdAsc();
}
