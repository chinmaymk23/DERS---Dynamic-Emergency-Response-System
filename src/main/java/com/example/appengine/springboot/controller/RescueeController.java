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

import com.example.appengine.springboot.ConnectionPoolContextListener;
import com.example.appengine.springboot.dto.RescueInformationDto;
import com.example.appengine.springboot.dto.UserDetailsDto;
import com.example.appengine.springboot.service.RescueRequestService;
import com.example.appengine.springboot.service.UserDetailsService;
import com.example.appengine.springboot.Algorithm;
import com.example.appengine.springboot.Vote;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.jdbc.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class RescueeController {

    UserDetailsService userDetailsService = new UserDetailsService();
    RescueRequestService rescueRequestService;
//    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String hello() {
        return "Welcome to RescueMe";
    }

    @PostMapping("/saveUserDetails")
    public void saveUserDetails(UserDetailsDto userDetailsDto) {
        System.out.println("At controller saveUserDetails");
        userDetailsService.saveUserDetails(userDetailsDto);
    }

    @PostMapping("/needRescue")
    public void getRescueRequest(int uniqueId, String currentLocation) {
        rescueRequestService.getRescueRequest(uniqueId, currentLocation);
    }

    @GetMapping("/getRescueesInformation")
    public ArrayList<RescueInformationDto> getRescueesInformation() {
        return rescueRequestService.getRescueesInformation();
    }

    public void connectToDataBase(){
        ConnectionPoolContextListener connObject = new ConnectionPoolContextListener();
        DataSource pool = connObject.createConnectionPool();
        int tabCount;
        int spaceCount;
        List<Vote> recentVotes = new ArrayList<>();
        try (Connection conn = pool.getConnection()) {
            // PreparedStatements are compiled by the database immediately and executed at a later date.
            // Most databases cache previously compiled queries, which improves efficiency.
            PreparedStatement createTableStatement = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS votes ( "
                            + "vote_id SERIAL NOT NULL, time_cast timestamp NOT NULL, candidate CHAR(6) NOT NULL,"
                            + " PRIMARY KEY (vote_id) );"
            );
            createTableStatement.execute();
            System.out.println("createTable executed");

            PreparedStatement voteStmt =  conn.prepareStatement(
                    "SELECT candidate, time_cast FROM votes ORDER BY time_cast DESC LIMIT 5");
            // Execute the statement
            ResultSet voteResults = voteStmt.executeQuery();
            // Convert a ResultSet into Vote objects
            while (voteResults.next()) {
                String candidate = voteResults.getString(1);
                Timestamp timeCast = voteResults.getTimestamp(2);
                recentVotes.add(new Vote(candidate, timeCast));
            }

            for(Vote v: recentVotes){
                System.out.println(v);
            }

            // PreparedStatements can also be executed multiple times with different arguments. This can
            // improve efficiency, and project a query from being vulnerable to an SQL injection.
            PreparedStatement voteCountStmt = conn.prepareStatement(
                    "SELECT COUNT(vote_id) FROM votes WHERE candidate=?");

            voteCountStmt.setString(1, "TABS");
            ResultSet tabResult = voteCountStmt.executeQuery();
            tabResult.next(); // Move to the first result
            tabCount = tabResult.getInt(1);

            voteCountStmt.setString(1, "SPACES");
            ResultSet spaceResult = voteCountStmt.executeQuery();
            spaceResult.next(); // Move to the first result
            spaceCount = spaceResult.getInt(1);
            System.out.println(spaceCount);


        } catch (SQLException ex) {
            // If something goes wrong, the application needs to react appropriately. This might mean
            // getting a new connection and executing the query again, or it might mean redirecting the
            // user to a different page to let them know something went wrong.
//            throw new SQLException("Unable to successfully connect to the database. Please check the "
//                    + "steps in the README and try again.", ex);
            System.out.println("Exception occured "+ex);
        }
    }

}
// [END gae_java11_helloworld]
