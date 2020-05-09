package com.example.appengine.springboot.dao;

import com.example.appengine.springboot.Algorithm;
import com.example.appengine.springboot.ConnectionPoolContextListener;
import com.example.appengine.springboot.dto.AlgorithmDto;
import com.example.appengine.springboot.dto.UserDetailsDto;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class UserDetailsDao {

//    Algorithm algo = new Algorithm();
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

    String createAlgorithmQuery = "CREATE TABLE algorithm (\n" +
            "  maleFactor float NULL DEFAULT \"0\",\n" +
            "  femaleFactor float NULL DEFAULT \"0\",\n" +
            "  minIncome int NULL DEFAULT \"0\",\n" +
            "  maxIncome int NULL DEFAULT \"0\",\n" +
            "  minIncomeFactor float NULL DEFAULT \"0\",\n" +
            "  maxIncomeFactor float NULL DEFAULT \"0\",\n" +
            "  middleIncomeFactor float NULL DEFAULT \"0\",\n" +
            "  minAge float NULL DEFAULT \"0\",\n" +
            "  maxAge float NULL DEFAULT \"0\",\n" +
            "  minAgeFactor float NULL DEFAULT \"0\",\n" +
            "  maxAgeFactor float NULL DEFAULT \"0\",\n" +
            "  middleAgeFactor float NULL DEFAULT \"0\",\n" +
            "  terminalIllnessFactor float NULL DEFAULT \"0\",\n" +
            "  mobilityOption1Factor float NULL DEFAULT \"0\",\n" +
            "  mobilityOption2Factor float NULL DEFAULT \"0\",\n" +
            "  mobilityOption3Factor float NULL DEFAULT \"0\",\n" +
            "  breathingProblemFactor float NULL DEFAULT \"0\",\n" +
            "  pregnancyFactor float NULL DEFAULT \"0\",\n" +
            "  minBmi float NULL DEFAULT \"0\",\n" +
            "  maxBmi float NULL DEFAULT \"0\",\n" +
            "  minBmiFactor float NULL DEFAULT \"0\",\n" +
            "  maxBmiFactor float NULL DEFAULT \"0\",\n" +
            "  middleBmiFactor float NULL DEFAULT \"0\",\n" +
            "  disasterLat double NULL DEFAULT \"0\",\n" +
            "  disasterLan double NULL DEFAULT \"0\",\n" +
            "  algoId int NULL \"1\"" +
            ");";

    String createALgoQ = "CREATE TABLE algorithm\n" +
            "(\n" +
            "algoId int NULL DEFAULT \"1\",\n" +
            "maleFactor float NULL DEFAULT \"1\",\n" +
            "femaleFactor float NULL DEFAULT \"1\",\n" +
            "minIncomeFactor float NULL DEFAULT \"1\",\n" +
            "maxIncomeFactor float NULL DEFAULT \"1\",\n" +
            "middleIncomeFactor float NULL DEFAULT \"1\",\n" +
            "minAge float NULL DEFAULT \"1\",\n" +
            "maxAge float NULL DEFAULT \"1\",\n" +
            "minAgeFactor float NULL DEFAULT \"1\",\n" +
            "maxAgeFactor float NULL DEFAULT \"1\",\n" +
            "middleAgeFactor float NULL DEFAULT \"1\",\n" +
            "pregnancyFactor float NULL DEFAULT \"1\",\n" +
            "terminalIllness1Factor float NULL DEFAULT \"1\",\n" +
            "terminalIllness2Factor float NULL DEFAULT \"1\",\n" +
            "terminalIllness3Factor float NULL DEFAULT \"1\",\n" +
            "terminalIllness4Factor float NULL DEFAULT \"1\",\n" +
            "mobilityOption1Factor float NULL DEFAULT \"1\",\n" +
            "mobilityOption2Factor float NULL DEFAULT \"1\",\n" +
            "mobilityOption3Factor float NULL DEFAULT \"1\",\n" +
            "breathingProblem1Factor float NULL DEFAULT \"1\",\n" +
            "breathingProblem2Factor float NULL DEFAULT \"1\",\n" +
            "breathingProblem3Factor float NULL DEFAULT \"1\",\n" +
            "breathingProblem4Factor float NULL DEFAULT \"1\",\n" +
            "minBmi float NULL DEFAULT \"1\",\n" +
            "maxBmi float NULL DEFAULT \"1\",\n" +
            "minBmiFactor float NULL DEFAULT \"1\",\n" +
            "maxBmiFactor float NULL DEFAULT \"1\",\n" +
            "middleBmiFactor float NULL DEFAULT \"1\",\n" +
            "maxIncome int NULL DEFAULT \"1\",\n" +
            "disasterLan double NULL DEFAULT \"1\",\n" +
            "minIncome int NULL DEFAULT \"1\",\n" +
            "disasterLat double NULL DEFAULT \"1\");";

    String insertQuery = "INSERT INTO algorithm( maleFactor,\n" +
            "     femaleFactor,\n" +
            "     minIncomeFactor,\n" +
            "     maxIncomeFactor,\n" +
            "     middleIncomeFactor,\n" +
            "     minAge,\n" +
            "     maxAge,\n" +
            "     minAgeFactor,\n" +
            "     maxAgeFactor,\n" +
            "     middleAgeFactor,\n" +
            "     pregnancyFactor,\n" +
            "     terminalIllness1Factor,\n" +
            "     terminalIllness2Factor,\n" +
            "     terminalIllness3Factor,\n" +
            "     terminalIllness4Factor,\n" +
            "     mobilityOption1Factor,\n" +
            "     mobilityOption2Factor,\n" +
            "     mobilityOption3Factor,\n" +
            "     breathingProblem1Factor,\n" +
            "     breathingProblem2Factor,\n" +
            "     breathingProblem3Factor,\n" +
            "     breathingProblem4Factor,\n" +
            "     minBmi,\n" +
            "     maxBmi,\n" +
            "     minBmiFactor,\n" +
            "     maxBmiFactor,\n" +
            "     middleBmiFactor,\n" +
            "    algoId,\n" +
            "    minIncome,\n" +
            "    maxIncome,\n" +
            "    disasterLat,\n" +
            "    disasterLan) " +
            "values (1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);";

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

    public void executeCreateQueries(String query){
        Connection conn = returnConnection();
        System.out.println(query);
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

//            urgencyScore+=algo.addLocationScore(lat, lan);

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
            String query = insertQuery;//"DELETE FROM userinfo;";
            System.out.println(insertQuery);
            System.out.println(query);
            Statement st = conn.prepareStatement(query);
            int x = st.executeUpdate(query);
            if (x > 0)
                System.out.println("Successfully deleted");
            else
                System.out.println("delete Failed");

//            query = "SELECT * FROM userinfo";
//            executeSelectQueries(query);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured at deleteRecords "+ex);
        }
    }

    public void updateAlgo(AlgorithmDto dto) {
//        executeCreateQueries(createALgoQ);
//        deleteRecords();
//        deleteRecords();
        Connection conn = returnConnection();
        try {
            String query = "UPDATE algorithm a SET a.maleFactor="+dto.getMaleFactor()+",\n" +
                    "a.femaleFactor="+dto.getFemaleFactor()+",\n" +
                    "a.maxIncomeFactor="+dto.getMaxIncomeFactor()+",\n" +
                    "a.middleIncomeFactor="+dto.getMiddleIncomeFactor()+",\n" +
                    "a.minAge="+dto.getMinAge()+",\n" +
                    "a.maxAge="+dto.getMaxAge()+",\n" +
                    "a.minAgeFactor="+dto.getMinAgeFactor()+",\n" +
                    "a.maxAgeFactor="+dto.getMaxAgeFactor()+",\n" +
                    "a.middleAgeFactor="+dto.getMiddleAgeFactor()+",\n" +
                    "a.pregnancyFactor="+dto.getPregnancyFactor()+",\n" +
                    "a.terminalIllness1Factor="+dto.getTerminalIllness1Factor()+",\n" +
                    "a.terminalIllness2Factor="+dto.getTerminalIllness2Factor()+",\n" +
                    "a.terminalIllness3Factor="+dto.getTerminalIllness3Factor()+",\n" +
                    "a.terminalIllness4Factor="+dto.getTerminalIllness4Factor()+",\n" +
                    "a.mobilityOption1Factor="+dto.getMobilityOption1Factor()+",\n" +
                    "a.mobilityOption2Factor="+dto.getMobilityOption2Factor()+",\n" +
                    "a.mobilityOption3Factor="+dto.getMobilityOption3Factor()+",\n" +
                    "a.breathingProblem1Factor="+dto.getBreathingProblem1Factor()+",\n" +
                    "a.breathingProblem2Factor="+dto.getBreathingProblem2Factor()+",\n" +
                    "a.breathingProblem3Factor="+dto.getBreathingProblem3Factor()+",\n" +
                    "a.breathingProblem4Factor="+dto.getBreathingProblem4Factor()+",\n" +
                    "a.minBmi="+dto.getMinBmi()+",\n" +
                    "a.maxBmi="+dto.getMaxBmi()+",\n" +
                    "a.minBmiFactor="+dto.getMinBmiFactor()+",\n" +
                    "a.maxBmiFactor="+dto.getMaxBmiFactor()+",\n" +
                    "a.middleBmiFactor="+dto.getMiddleBmiFactor()+",\n" +
                    "a.minIncome="+dto.getMinIncome()+",\n" +
                    "a.maxIncome="+dto.getMaxIncome()+",\n" +
                    "a.disasterLat="+dto.getDisasterLat()+",\n" +
                    "a.disasterLan="+dto.getDisasterLan()+" WHERE a.algoId=1;";
            System.out.println(query);
            Statement st = conn.prepareStatement(query);
            int x = st.executeUpdate(query);
            if (x > 0)
                System.out.println("Successfully updated");
            else
                System.out.println("update Failed");

            executeSelectQueries("SELECT * from algorithm");
        }
        catch(SQLException e){
            System.out.println("Exception in updateAlgo "+e);
        }
    }

    public AlgorithmDto getAlgo() {
        Connection conn = returnConnection();
        AlgorithmDto dto = new AlgorithmDto();
        try {
            String query = "SELECT * from algorithm";
            Statement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                dto.setMaleFactor(rs.getFloat("maleFactor"));
                dto.setFemaleFactor(rs.getFloat("femaleFactor"));
                dto.setMinIncomeFactor(rs.getFloat("minIncomeFactor"));
                dto.setMaxIncomeFactor(rs.getFloat("maxIncomeFactor"));
                dto.setMiddleIncomeFactor(rs.getFloat("middleIncomeFactor"));
                dto.setMinAge(rs.getFloat("minAge"));
                dto.setMaxAge(rs.getFloat("maxAge"));
                dto.setMinAgeFactor(rs.getFloat("minAgeFactor"));
                dto.setMaxAgeFactor(rs.getFloat("maxAgeFactor"));
                dto.setMiddleAgeFactor(rs.getFloat("middleAgeFactor"));
                dto.setPregnancyFactor(rs.getFloat("pregnancyFactor"));
                dto.setTerminalIllness1Factor(rs.getFloat("terminalIllness1Factor"));
                dto.setTerminalIllness2Factor(rs.getFloat("terminalIllness2Factor"));
                dto.setTerminalIllness3Factor(rs.getFloat("terminalIllness3Factor"));
                dto.setTerminalIllness4Factor(rs.getFloat("terminalIllness4Factor"));
                dto.setMobilityOption1Factor(rs.getFloat("mobilityOption1Factor"));
                dto.setMobilityOption2Factor(rs.getFloat("mobilityOption2Factor"));
                dto.setMobilityOption3Factor(rs.getFloat("mobilityOption3Factor"));
                dto.setBreathingProblem1Factor(rs.getFloat("breathingProblem1Factor"));
                dto.setBreathingProblem2Factor(rs.getFloat("breathingProblem2Factor"));
                dto.setBreathingProblem3Factor(rs.getFloat("breathingProblem3Factor"));
                dto.setBreathingProblem4Factor(rs.getFloat("breathingProblem4Factor"));
                dto.setMinBmi(rs.getFloat("minBmi"));
                dto.setMaxBmi(rs.getFloat("maxBmi"));
                dto.setMinBmiFactor(rs.getFloat("minBmiFactor"));
                dto.setMaxBmiFactor(rs.getFloat("maxBmiFactor"));
                dto.setMiddleBmiFactor(rs.getFloat("middleBmiFactor"));
                dto.setMinIncome(rs.getInt("minIncome"));
                dto.setMaxIncome(rs.getInt("maxIncome"));
                dto.setDisasterLat(rs.getDouble("disasterLat"));
                dto.setDisasterLan(rs.getDouble("disasterLan"));
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Exception occured inside getAlgo "+ex);
        }
        System.out.println(dto);
        return dto;
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