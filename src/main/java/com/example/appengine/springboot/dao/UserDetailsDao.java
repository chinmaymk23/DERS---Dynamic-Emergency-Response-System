package com.example.appengine.springboot.dao;

import com.example.appengine.springboot.ConnectionPoolContextListener;
import com.example.appengine.springboot.Vote;
import com.example.appengine.springboot.dto.UserDetailsDto;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsDao {

    public void saveUserDetails(UserDetailsDto dto){
        System.out.println("Inside dao");
        String insertUserDetails = "INSERT INTO userdata(name, age, uniqueId, address" +
                ", gender, annualIncome, height, weight" +
                ", mobility, terminalIllness, pregnancy, breathingProblem" +
                ", phoneNumber, urgencyScore, inProgress, rescued" +
                ", needRescue, others) " +
                "values ('"+dto.getName()+"','"+dto.getAge()+"','"+dto.getUniqueId()+"','"+dto.getAddress()
                +"','"+dto.getGender()+"','"+dto.getAnnualIncome()+"','"+dto.getHeight()+"','"+dto.getWeight()
                +"','"+dto.isMobility()+"','"+dto.isTerminalIllness()+"','"+dto.isPregnancy()+"','"+dto.isBreathingProblem()
                +"','"+dto.getPhoneNumber()+"','"+dto.getUrgencyScore()+"','"+dto.getInProgress()+"','"+dto.getRescued()
                +"','"+dto.getNeedRescue()+"','"+dto.isOthers()
                +"')";
//        System.out.println(insertUserDetails);

        String selectQuery = "SELECT * FROM userdata;";

//        executeCreateQueries(createDummyTableQuery);
//        executeInsertQueries(insertQuery);
        if(dto.getAddress().equals("insert"))
            insertUserDetails(dto, insertUserDetails);

//        String dropQuery = "ALTER TABLE userdata\n" +
//                "ADD COLUMN rescueStatus int NOT NULL DEFAULT \"2\" AFTER lan";
//        connectToDataBase(dropQuery);

        selectQuery = "SELECT * from userdata";
        executeSelectQueries(selectQuery);


//
//        selectQuery = "SHOW COLUMNS FROM userdata;";
//        executeSelectQueries(selectQuery);
    }

    public void insertUserDetails(UserDetailsDto dto, String insertQuery){
        Connection conn = returnConnection();
        try {
            // create the mysql insert preparedstatement
//            preparedStmt.setString (1, dto.getName());
//            preparedStmt.setInt (2, dto.getAge());
//            preparedStmt.setString   (3, dto.getUniqueId());
//            preparedStmt.setString(4, dto.getAddress());
//            preparedStmt.setString    (5, dto.getGender());
//
//            preparedStmt.setLong (6, dto.getAnnualIncome());
//            preparedStmt.setInt (7, dto.getHeight());
//            preparedStmt.setInt   (8, dto.getWeight());
//            preparedStmt.setInt(9, dto.isMobility());
//            preparedStmt.setInt    (10, dto.isTerminalIllness());
//
//            preparedStmt.setInt (11, dto.isPregnancy());
//            preparedStmt.setInt   (12, dto.isBreathingProblem());
//            preparedStmt.setInt(13, dto.getPhoneNumber());
//            preparedStmt.setInt    (14, dto.getUrgencyScore());
//
//            preparedStmt.setInt (15, dto.getInProgress());
//            preparedStmt.setInt   (16, dto.getRescued());
//            preparedStmt.setInt(17, dto.getNeedRescue());
//            preparedStmt.setString    (18, dto.isOthers());

            PreparedStatement preparedStmt = conn.prepareStatement(insertQuery);
            int x = preparedStmt.executeUpdate();
            if (x > 0)
                System.out.println("Successfully Inserted");
            else
                System.out.println("Insert Failed");

            String selectQuery = "SELECT name,age,uniqueId,address FROM userdata;";
            Statement st = conn.prepareStatement(selectQuery);
            ResultSet rs = st.executeQuery(selectQuery);
            while (rs.next())
            {
                System.out.println("name : " + rs.getString(1));
                System.out.println("age :" + rs.getInt(2));
                System.out.println("uniqueId :" + rs.getString(3));
                System.out.println("address :" + rs.getString(4));
                System.out.println("gender : " + rs.getString(5));
                System.out.println("age :" + rs.getInt(2));
                System.out.println("uniqueId :" + rs.getString(3));
                System.out.println("address :" + rs.getString(4));
                System.out.println("name : " + rs.getString(1));
                System.out.println("age :" + rs.getInt(2));
                System.out.println("uniqueId :" + rs.getString(3));
                System.out.println("address :" + rs.getString(4));
                System.out.println("name : " + rs.getString(1));
                System.out.println("age :" + rs.getInt(2));
                System.out.println("uniqueId :" + rs.getString(3));
                System.out.println("address :" + rs.getString(4));
                System.out.println("name : " + rs.getString(1));
                System.out.println("age :" + rs.getInt(2));
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured inside insertUserDetails "+ex);
        }
    }

    public void executeSelectQueries(String query){
        Connection conn = returnConnection();
        try {
            Statement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
//            ResultSetMetaData md = rs.getMetaData();
//            int col = md.getColumnCount();
//            System.out.println("Number of Column : "+ col);
//            System.out.println("Columns Name: ");
//            for (int i = 1; i <= col; i++){
//                String col_name = md.getColumnName(i);
//                System.out.println(col_name);
//            }
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for(int i = 1; i < columnsNumber; i++)
                    System.out.print(rsmd.getColumnName(i)+" "+rs.getString(i) + " ");
                System.out.println();
            }
//            while (rs.next())
//            {
//                System.out.println("name : " + rs.getString(1));
//                System.out.println("age :" + rs.getString(2));
//                System.out.println("uniqueId :" + rs.getString(3));
//                System.out.println("address :" + rs.getString(4));
//            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured inside executeSelectQueries "+ex);
        }
    }

    public void executeInsertQueries(String query){
        Connection conn = returnConnection();
        try {
            Statement st = conn.prepareStatement(query);
            int x = st.executeUpdate(query);
            if (x > 0)
                System.out.println("Successfully Inserted");
            else
                System.out.println("Insert Failed");

            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured "+ex);
        }
    }

    public void executeCreateQueries(String query){
        Connection conn = returnConnection();
        try {
            PreparedStatement createTableStatement = conn.prepareStatement(query);
            createTableStatement.execute();
            System.out.println("createTable executed");
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured "+ex);
        }
    }

    public Connection returnConnection(){
        try {
            ConnectionPoolContextListener connObject = new ConnectionPoolContextListener();
            DataSource pool = connObject.createConnectionPool();
            return pool.getConnection();
        }
        catch (Exception e){
            System.out.println("Exception caught at returnConnection "+e);
        }
        return null;
    }

    public void getTableInfo(){
        Connection conn = returnConnection();
        try {
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void connectToDataBase(String query){
        ConnectionPoolContextListener connObject = new ConnectionPoolContextListener();
        DataSource pool = connObject.createConnectionPool();
        try (Connection conn = pool.getConnection()) {
            // PreparedStatements are compiled by the database immediately and executed at a later date.
            // Most databases cache previously compiled queries, which improves efficiency.
            PreparedStatement createTableStatement = conn.prepareStatement(
                    query
            );

            createTableStatement.execute();
            System.out.println("createTable executed");
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
/*

    String createUserDataQuery = "CREATE TABLE userdata (\n" +
            "  name varchar(50) NOT NULL DEFAULT \"dummy\",\n" +
            "  age int NOT NULL DEFAULT \"70\",\n" +
            "  uniqueId varchar(50) NOT NULL PRIMARY KEY DEFAULT \"123\",\n" +
            "  address varchar(50) NULL DEFAULT \"dummy_string\",\n" +
            "  gender varchar(50) NOT NULL DEFAULT \"Male\",\n" +
            "  annualIncome int NOT NULL DEFAULT \"10000\",\n" +
            "  height int NOT NULL DEFAULT \"171\",\n" +
            "  weight int NOT NULL DEFAULT \"200\",\n" +
            "  mobility tinyint NOT NULL DEFAULT true,\n" +
            "  terminalIllness tinyint NOT NULL DEFAULT true,\n" +
            "  pregnancy tinyint NOT NULL DEFAULT true,\n" +
            "  breathingProblem tinyint NOT NULL DEFAULT false,\n" +
            "  phoneNumber int NULL DEFAULT \"123456798\",\n" +
            "  urgencyScore int NULL DEFAULT \"0\",\n" +
            "  inProgress tinyint NOT NULL DEFAULT false,\n" +
            "  rescued tinyint NOT NULL DEFAULT true,\n" +
            "  needRescue tinyint NOT NULL DEFAULT false,\n" +
            "  lat bigint NULL DEFAULT \"0\",\n" +
            "  lan bigint NULL DEFAULT \"0\",\n" +
            "  others varchar(50) NULL DEFAULT \"dummy_string\"\n" +
            ");\n";

            name, age, uniqueId, gender, height, weight, mobility, terminalIllness, breathingProblem

    String createDummyTableQuery = "CREATE TABLE dummy_table\n" +
            "(name varchar(50) NOT NULL PRIMARY KEY,\n" +
            "age int NOT NULL DEFAULT \"50\",\n" +
            "bool tinyint NOT NULL DEFAULT true);";

    String name = "Zavada";
    int age = 80;
    int bool = 1;

    String insertQuery = "insert into dummy_table values('" +name+ "', '" +age+
            "', '" +bool+ "')";

//            Statement st = conn.prepareStatement(query);

            String query = "INSERT INTO userdata (name, age) " +
//                    ", uniqueId, address, gender, annualIncome, height, weight, mobility, terminalIllness, pregnancy, breathingProblem, phoneNumber, urgencyScore, inProgress, rescued, needRescue, others) " +
                    " VALUES (?,?)" +
//                    ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" +
                    ";";
//                    "(:name, :age, :uniqueId, :address, :gender, :annualIncome, :height, :weight, :mobility, :terminalIllness, pregnancy, :breathingProblem, :phoneNumber, :urgencyScore, :inProgress, :rescued, :needRescue, :lat, :lan, :others)";

        */