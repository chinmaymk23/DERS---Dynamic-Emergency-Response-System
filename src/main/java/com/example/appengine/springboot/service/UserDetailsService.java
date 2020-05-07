package com.example.appengine.springboot.service;

import com.example.appengine.springboot.Vote;
import com.example.appengine.springboot.dto.UserDetailsDto;
import com.example.appengine.springboot.dao.UserDetailsDao;
import org.springframework.stereotype.Service;
import com.example.appengine.springboot.ConnectionPoolContextListener;

import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsService{

    UserDetailsDao userDetailsDao = new UserDetailsDao();

    public void saveUserDetails(UserDetailsDto userDetailsDto) {
        userDetailsDto.setUrgencyScore(calculateUrgencyScore(userDetailsDto));
        userDetailsDao.saveUserDetails(userDetailsDto);
    }

    private int calculateUrgencyScore(UserDetailsDto userDetailsDto) {
        int urgencyScore = 0;

//        Age conditions
        if (userDetailsDto.getAge() >= 60)
            urgencyScore += 3;
        else if (userDetailsDto.getAge() <= 15)
            urgencyScore += 2;
        else
            urgencyScore += 1;

//        Annual income conditions
        if (userDetailsDto.getAnnualIncome() < 25000)
            urgencyScore += 3;
        else if (userDetailsDto.getAnnualIncome() >= 25000 && userDetailsDto.getAnnualIncome() < 100000)
            urgencyScore += 2;
        else
            urgencyScore += 1;

//        Gender conditions
//        if (userDetailsDto.getGender().equals('Female'))
//            urgencyScore += 1;

//        Medical conditions
        if (userDetailsDto.isMobility() == 1)
            urgencyScore += 3;
        if (userDetailsDto.isTerminalIllness() == 1)
            urgencyScore += 3;
        if (userDetailsDto.isPregnancy() == 1)
            urgencyScore += 3;


        if (userDetailsDto.isBreathingProblem() == 1)
            urgencyScore += 2;

//        BMI score test
        urgencyScore = checkBMI(userDetailsDto.getHeight(), userDetailsDto.getWeight(), urgencyScore);
        System.out.println("urgencyScore - " + urgencyScore);

        return urgencyScore;
    }

    private int checkBMI(int height, int weight, int urgencyScore) {
        double bmi = (703 * weight / Math.pow(height, 2));

        if (bmi < 18)
            urgencyScore += 2;
        else if (bmi > 30)
            urgencyScore += 3;
        else
            urgencyScore += 1;

        return urgencyScore;
    }
}
