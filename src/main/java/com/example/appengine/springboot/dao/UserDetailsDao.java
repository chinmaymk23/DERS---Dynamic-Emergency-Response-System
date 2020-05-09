package com.example.appengine.springboot.dao;

import com.example.appengine.springboot.Algorithm;
import com.example.appengine.springboot.ConnectionPoolContextListener;
import com.example.appengine.springboot.dto.UserDetailsDto;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class UserDetailsDao {

    Algorithm algo = new Algorithm();
    String createUserDataQuery = "CREATE TABLE userinfo (\n" +
            "  name varchar(50) NOT NULL DEFAULT \"username\",\n" +
            "  age int NOT NULL DEFAULT \"70\",\n" +
            "  uniqueId varchar(50) NOT NULL PRIMARY KEY,\n" +
            "  address varchar(50) NULL DEFAULT \"dummy_address\",\n" +
            "  gender varchar(50) NOT NULL DEFAULT \"Male\",\n" +
            "  annualIncome int NOT NULL DEFAULT \"10000\",\n" +
            "  height int NOT NULL DEFAULT \"171\",\n" +
            "  weight int NOT NULL DEFAULT \"200\",\n" +
            "  mobility varchar(50) NOT NULL DEFAULT \"Complete\",\n" +
            "  terminalIllness varchar(50) NOT NULL DEFAULT \"Yes\",\n" +
            "  pregnancy varchar(50) NOT NULL DEFAULT \"No\",\n" +
            "  breathingProblem varchar(50) NOT NULL DEFAULT \"Yes\",\n" +
            "  phoneNumber int NULL DEFAULT \"123456798\",\n" +
            "  urgencyScore int NULL DEFAULT \"0\",\n" +
            "  rescueStatus int NOT NULL DEFAULT \"2\",\n" +
            "  lat bigint NULL DEFAULT \"0\",\n" +
            "  lan bigint NULL DEFAULT \"0\"" +
            ")";

//    public void saveUserDetails(UserDetailsDto dto){
//        System.out.println("Inside dao");
//        insertUserDetails(dto);
//    }

    public void saveUserDetails(UserDetailsDto dto) {
        Connection conn = returnConnection();

        String insertQuery = "INSERT INTO userinfo(name, age, uniqueId, address" +
                ", gender, annualIncome, height, weight" +
                ", mobility, terminalIllness, pregnancy, breathingProblem" +
                ", phoneNumber, urgencyScore, rescueStatus, lat" +
                ", lan) " +
                "values ('" + dto.getName() + "','" + dto.getAge() + "','" + dto.getUniqueId() + "','" + dto.getAddress()
                + "','" + dto.getGender() + "','" + dto.getAnnualIncome() + "','" + dto.getHeight() + "','" + dto.getWeight()
                + "','" + dto.getMobility() + "','" + dto.getTerminalIllness() + "','" + dto.getPregnancy() + "','" + dto.getBreathingProblem()
                + "','" + dto.getPhoneNumber() + "','" + dto.getUrgencyScore() + "','" + 2 + "','" + 0 + "','" + 0 + "')";

        try {
            PreparedStatement preparedStmt = conn.prepareStatement(insertQuery);
            int x = preparedStmt.executeUpdate();
            if (x > 0)
                System.out.println("Successfully Inserted");
            else
                System.out.println("Insert Failed");

            String selectQuery = "SELECT * FROM userinfo;";
            executeSelectQueries(selectQuery);

            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured inside insertUserDetails " + ex);
        }
    }

    public String executeSelectQueries(String query){
        Connection conn = returnConnection();
        String result = new String();
        try {
            Statement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            result+="|";
            while (rs.next()) {
                for(int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + ":" + rs.getString(i) + " ");
                    result+=(rsmd.getColumnName(i)+":"+rs.getString(i)+" \n");
                }
                result+="|";
                System.out.println("-----------------------------------------------");
            }
//            ResultSetMetaData md = rs.getMetaData();
//            int col = md.getColumnCount();
//            System.out.println("Number of Column : "+ col);
//            System.out.println("Columns Name: ");
//            for (int i = 1; i <= col; i++){
//                String col_name = md.getColumnName(i);
//                System.out.println(col_name);
//            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured inside executeSelectQueries "+ex);
        }
        return result;
    }

    public void executeInsertQueries(String query){
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

    public void needRescue(String uniqueId, double lat, double lan) {
        System.out.println("Inside needRescue dao");
        Connection conn = returnConnection();
        try {
            String getIdQuery= "SELECT urgencyScore from userinfo WHERE uniqueId =\""+uniqueId+"\";";
            Statement sst = conn.prepareStatement(getIdQuery);
            ResultSet rs = sst.executeQuery(getIdQuery);
            int urgencyScore = 0;
            while (rs.next()) {
                urgencyScore = rs.getInt("urgencyScore");
            }

            urgencyScore+=algo.addLocationScore(lat, lan);

            String query = "UPDATE userinfo u SET u.lat = "+lat+", u.lan = "+lan+", u.urgencyScore="+urgencyScore+", u.rescueStatus = 3 WHERE u.uniqueId=\""+uniqueId+"\";";
            System.out.println(query);
            Statement st = conn.prepareStatement(query);
            int x = st.executeUpdate(query);
            if (x > 0)
                System.out.println("Successfully updated");
            else
                System.out.println("update Failed");

            String selectQuery = "SELECT urgencyScore,lat,lan FROM userinfo where uniqueId=\""+uniqueId+"\";";
            executeSelectQueries(selectQuery);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured at needRescue "+ex);
        }
    }

    public ArrayList<UserDetailsDto> getRescueesInformation(String query) {
        Connection conn = returnConnection();
        ArrayList<UserDetailsDto> list = new ArrayList<>();
        try {
            Statement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            UserDetailsDto dto;
            while (rs.next()) {
                dto = new UserDetailsDto();
                dto.setName(rs.getString("name"));
                dto.setUniqueId(rs.getString("uniqueId"));
                dto.setUrgencyScore(rs.getInt("urgencyScore"));
                dto.setBreathingProblem(rs.getString("breathingProblem"));
                dto.setMobility(rs.getString("mobility"));
                dto.setAddress(rs.getString("address"));
                dto.setLat(rs.getDouble("lat"));
                dto.setLan(rs.getDouble("lan"));
                dto.setGender(rs.getString("gender"));
                dto.setPregnancy(rs.getString("pregnancy"));
                dto.setTerminalIllness(rs.getString("terminalIllness"));
                dto.setPhoneNumber(rs.getInt("phoneNumber"));
                list.add(dto);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured inside getRescueesInformation "+ex);
        }
        for(UserDetailsDto dto: list){
            System.out.println(dto);
        }
        return list;
    }

    public void updateRescueStatus(String uniqueId, int rescueStatus) {
        Connection conn = returnConnection();
        try {
            String query = "UPDATE userinfo u SET u.rescueStatus = "+rescueStatus+" WHERE u.uniqueId=\""+uniqueId+"\";";
            System.out.println(query);
            Statement st = conn.prepareStatement(query);
            int x = st.executeUpdate(query);
            if (x > 0)
                System.out.println("Successfully updated");
            else
                System.out.println("update Failed");

            String selectQuery = "SELECT rescueStatus, name, uniqueId FROM userinfo where uniqueId = \""+uniqueId+"\";";
            executeSelectQueries(selectQuery);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured at updateRescueStatus "+ex);
        }
    }

    public void deleteRecords() {
        Connection conn = returnConnection();
        try {
//            String alterQuery = "ALTER TABLE userinfo MODIFY COLUMN lan DOUBLE;";
            String query = "DELETE FROM userinfo;";
            System.out.println(query);
            Statement st = conn.prepareStatement(query);
            int x = st.executeUpdate(query);
            if (x > 0)
                System.out.println("Successfully deleted");
            else
                System.out.println("delete Failed");

            query = "SELECT * FROM userinfo";
            executeSelectQueries(query);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured at deleteRecords "+ex);
        }
    }
}


/*
            name, age, uniqueId, gender, height, weight, mobility, terminalIllness, breathingProblem

    String createDummyTableQuery = "CREATE TABLE dummy_table\n" +
            "(name varchar(50) NOT NULL PRIMARY KEY,\n" +
            "age int NOT NULL DEFAULT \"50\",\n" +
            "bool varchar(50) NOT NULL DEFAULT true);";

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

    public void createTable(String query){
        ConnectionPoolContextListener connObject = new ConnectionPoolContextListener();
        DataSource pool = connObject.createConnectionPool();
        try (Connection conn = pool.getConnection()) {
            PreparedStatement createTableStatement = conn.prepareStatement(query);
            createTableStatement.execute();
            System.out.println("createTable executed");

            String selectQuery = "SELECT * FROM userinfo;";
            executeSelectQueries(selectQuery);
        } catch (SQLException ex) {
            System.out.println("Exception occured "+ex);
        }
    }
        */
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


//            String selectQuery = "SELECT name,age,uniqueId,address FROM userdata;";
//            Statement st = conn.prepareStatement(selectQuery);
//            ResultSet rs = st.executeQuery(selectQuery);
//            while (rs.next())
//            {
//                System.out.println("name : " + rs.getString(1));
//                System.out.println("age :" + rs.getInt(2));
//                System.out.println("uniqueId :" + rs.getString(3));
//                System.out.println("address :" + rs.getString(4));
//                System.out.println("gender : " + rs.getString(5));
//                System.out.println("age :" + rs.getInt(2));
//                System.out.println("uniqueId :" + rs.getString(3));
//                System.out.println("address :" + rs.getString(4));
//                System.out.println("name : " + rs.getString(1));
//                System.out.println("age :" + rs.getInt(2));
//                System.out.println("uniqueId :" + rs.getString(3));
//                System.out.println("address :" + rs.getString(4));
//                System.out.println("name : " + rs.getString(1));
//                System.out.println("age :" + rs.getInt(2));
//                System.out.println("uniqueId :" + rs.getString(3));
//                System.out.println("address :" + rs.getString(4));
//                System.out.println("name : " + rs.getString(1));
//                System.out.println("age :" + rs.getInt(2));
//            }