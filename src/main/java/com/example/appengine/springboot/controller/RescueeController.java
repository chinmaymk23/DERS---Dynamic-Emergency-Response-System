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
import com.example.appengine.springboot.dto.UserDetailsDto;
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

    @GetMapping("/")
    public String hello() {
        return "Welcome to RescueMe 2";
    }

    @GetMapping("/seeTable")
    public String seeTable() {
        return userDetailsService.seeTable();
    }

    @GetMapping("/seeAlgo")
    public String seeAlgo() {
        return userDetailsService.seeAlgo();
    }

    @GetMapping("/deleteTable")
    public void deleteTable() {
        userDetailsService.deleteTable();
    }

    @PostMapping("/updateAlgo")
    public void updateAlgo(AlgorithmDto dto) {
        System.out.println("algo controller");
        System.out.println(dto);
        userDetailsService.updateAlgo(dto);
    }

    @PostMapping("/saveUserDetails")
    public void saveUserDetails(UserDetailsDto userDetailsDto) {
        System.out.println("Inside controller");
        System.out.println((userDetailsDto));
        userDetailsService.saveUserDetails(userDetailsDto);
    }

    @PostMapping("/mockApi")
    public String needRescue(String uniqueId) {
        System.out.println("Inside needRescue controller "+uniqueId);
        return uniqueId;
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
