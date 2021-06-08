package com.polman.astra.ac.id.criminalintentapi.controller;

import com.polman.astra.ac.id.criminalintentapi.service.CrimeService;
import com.polman.astra.ac.id.criminalintentapi.vo.Crime;
import com.polman.astra.ac.id.criminalintentapi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RestController
public class CrimeController {
    @Autowired
    CrimeService mCrimeService;

    @GetMapping("/crime")
    public Crime getCrime(@RequestParam("id") String id) {
        return mCrimeService.getCrime(id);
    }

    @GetMapping("/crimes")
    public List<Crime> getCrimes() {
        return mCrimeService.getCrimes();
    }

    @PostMapping("/crime")
    public Object saveCrime(HttpServletResponse response, @RequestBody Crime crimeParam) {

        boolean isSuccess = mCrimeService.saveCrime(crimeParam);

        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            return new Result(500, "Fail");
        }
    }

    @PutMapping("/crime")
    public Object modifyCrime(HttpServletResponse response, @RequestBody Crime crimeParam) {
        boolean isSuccess = mCrimeService.updateCrime(crimeParam);

        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            return new Result(500, "Fail");
        }
    }

    @DeleteMapping("/crime")
    public Object deleteCrime(HttpServletResponse response, @RequestParam("id") String id) {
        boolean isSuccess = mCrimeService.deleteCrime(id);

        if (isSuccess) {
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }
}
