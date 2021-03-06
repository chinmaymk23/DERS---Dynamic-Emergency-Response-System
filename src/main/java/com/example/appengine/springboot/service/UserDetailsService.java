package com.example.appengine.springboot.service;

import com.example.appengine.springboot.dto.AlgorithmDto;
import com.example.appengine.springboot.dto.UserDetailsDto;
import com.example.appengine.springboot.dao.UserDetailsDao;
import com.example.appengine.springboot.Algorithm;

import java.util.ArrayList;

public class UserDetailsService{

    UserDetailsDao userDetailsDao = new UserDetailsDao();

    Algorithm algo = new Algorithm();

    public void saveUserDetails(UserDetailsDto userDetailsDto) {
        userDetailsDto.setUrgencyScore(algo.calculateUrgencyScore(userDetailsDto));
        userDetailsDao.saveUserDetails(userDetailsDto);
    }

    public void needRescue(String uniqueId, double lat, double lan) {
        System.out.println("Inside needRescue service");
//        int urgencyScore = userDetailsDao.getUrgencyScore(uniqueId);
        userDetailsDao.needRescue(uniqueId, lat, lan);
    }

    public String seeTable() {
        String selectQuery = "SELECT * FROM userinfo;";
        return userDetailsDao.executeSelectQueries(selectQuery);
    }

    public void updateRescueStatus(String uniqueId, int rescueStatus) {
        userDetailsDao.updateRescueStatus(uniqueId, rescueStatus);
    }

    public ArrayList<UserDetailsDto> getRescueesInformation() {
        String selectQuery = "SELECT * FROM userinfo WHERE rescueStatus = 3 ORDER BY urgencyScore DESC;";
        return userDetailsDao.getRescueesInformation(selectQuery);
    }

    public void deleteTable() {
        userDetailsDao.deleteRecords();
    }

    public void updateAlgo(AlgorithmDto dto) {
        System.out.println("algo service");
        System.out.println(dto);
        userDetailsDao.updateAlgo(dto);
    }

    public String seeAlgo() {
        String selectQuery = "SELECT * FROM algorithm;";
        return userDetailsDao.executeSelectQueries(selectQuery);
    }
}
