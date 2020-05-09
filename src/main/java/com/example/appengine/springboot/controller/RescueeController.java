/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.springboot.controller;

// [START gae_java11_helloworld]

import com.example.appengine.springboot.dto.AlgorithmDto;
import com.example.appengine.springboot.dto.RescueInformationDto;
import com.example.appengine.springboot.dto.UserDetailsDto;
import com.example.appengine.springboot.service.RescueRequestService;
import com.example.appengine.springboot.service.UserDetailsService;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class RescueeController {

    UserDetailsService userDetailsService = new UserDetailsService();
    RescueRequestService rescueRequestService;

    @GetMapping("/")
    public String hello() {
        return "Welcome to RescueMe";
    }

    @GetMapping("/seeTable")
    public String seeTable() {
        return userDetailsService.seeTable();
    }

    @GetMapping("/deleteTable")
    public void deleteTable() {
        userDetailsService.deleteTable();
    }

    @PostMapping("/updateAlgo")
    public void updateAlgo(AlgorithmDto dto) {
        userDetailsService.updateAlgo(dto);
    }

    @PostMapping("/saveUserDetails")
    public void saveUserDetails(UserDetailsDto userDetailsDto) {
        userDetailsService.saveUserDetails(userDetailsDto);
    }

    @PostMapping("/mockApi")
    public void needRescue(String uniqueId) {
        System.out.println("Inside needRescue controller "+uniqueId);
    }

    @PostMapping("/needRescue")
    public void needRescue(String uniqueId, double lat, double lan) {
        System.out.println("Inside needRescue controller");
        System.out.println(uniqueId+" "+lat+" "+lan);
        userDetailsService.needRescue(uniqueId, lat, lan);
    }

    @GetMapping("/getRescueesInformation")
    public ArrayList<UserDetailsDto> getRescueesInformation() {
        System.out.println("Inside getRescueesInformation controller");
        return userDetailsService.getRescueesInformation();
    }

    @PostMapping("/updateRescueStatus")
    public void updateRescueStatus(String uniqueId, int rescueStatus) {
        userDetailsService.updateRescueStatus(uniqueId, rescueStatus);
    }
}
// [END gae_java11_helloworld]
