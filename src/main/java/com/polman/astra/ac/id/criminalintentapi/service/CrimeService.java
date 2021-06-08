package com.polman.astra.ac.id.criminalintentapi.service;

import com.polman.astra.ac.id.criminalintentapi.repository.CrimeJpaRepository;
import com.polman.astra.ac.id.criminalintentapi.vo.Crime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeService {
    @Autowired
    @Qualifier("CrimeJpaRepository")
    CrimeJpaRepository mCrimeJpaRepository;

    public Crime getCrime(String id) {

        return mCrimeJpaRepository.getCrimeById(id);
    }

    public List<Crime> getCrimes() {

        return mCrimeJpaRepository.findAllByOrderByIdAsc();
    }

    public boolean saveCrime(Crime crime) {
        System.out.println(crime);
        Crime result = mCrimeJpaRepository.save(crime);
        return true;
    }

    public boolean updateCrime(Crime crime) {
        Crime result = mCrimeJpaRepository.getCrimeById(crime.getId());

        if (result == null) {
            return false;
        }

        result.setTitle(crime.getTitle());
        result.setDate(crime.getDate());
        result.setSolved(crime.isSolved());
        result.setSuspect(crime.getSuspect());
        result.setSuspectNumber(crime.getSuspectNumber());

        mCrimeJpaRepository.save(result);
        return true;
    }

    public boolean deleteCrime(String id) {
        Crime result = mCrimeJpaRepository.getCrimeById(id);

        if (result == null) {
            return false;
        }

        mCrimeJpaRepository.delete(result);
        return true;
    }
}
