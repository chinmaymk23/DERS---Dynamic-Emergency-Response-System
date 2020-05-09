package com.example.appengine.springboot.service;

import com.example.appengine.springboot.dto.RescueInformationDto;
import com.example.appengine.springboot.dto.UserDetailsDto;
import com.example.appengine.springboot.dao.UserDetailsDao;

import java.util.ArrayList;

public class RescueRequestService {

    UserDetailsDao userDetailsDao = new UserDetailsDao();

    public ArrayList<UserDetailsDto> getRescueesInformation() {
        System.out.println("Inside getRescueesInformation service");
        String selectQuery = "SELECT * FROM userinfo WHERE rescueStatus = 3;";
        return userDetailsDao.getRescueesInformation(selectQuery);
    }
}
