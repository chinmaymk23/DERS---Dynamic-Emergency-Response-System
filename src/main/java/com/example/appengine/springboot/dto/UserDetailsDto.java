package com.example.appengine.springboot.dto;

import java.util.Objects;

public class UserDetailsDto {
    private String name;
    private int age;
    private String uniqueId;
    private String address;
    private String gender;
    private long annualIncome;
    private int height;
    private int weight;
    private String mobility;
    private String terminalIllness;
    private String pregnancy;
    private String breathingProblem;
    private int phoneNumber;
    private int urgencyScore;
    private int rescueStatus;
    private double lat;
    private double lan;

    @Override
    public String toString() {
        return "UserDetailsDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", uniqueId='" + uniqueId + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", annualIncome=" + annualIncome +
                ", height=" + height +
                ", weight=" + weight +
                ", mobility='" + mobility + '\'' +
                ", terminalIllness='" + terminalIllness + '\'' +
                ", pregnancy='" + pregnancy + '\'' +
                ", breathingProblem='" + breathingProblem + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", urgencyScore=" + urgencyScore +
                ", rescueStatus=" + rescueStatus +
                ", lat=" + lat +
                ", lan=" + lan +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(long annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMobility() {
        return mobility;
    }

    public void setMobility(String mobility) {
        this.mobility = mobility;
    }

    public String getTerminalIllness() {
        return terminalIllness;
    }

    public void setTerminalIllness(String terminalIllness) {
        this.terminalIllness = terminalIllness;
    }

    public String getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(String pregnancy) {
        this.pregnancy = pregnancy;
    }

    public String getBreathingProblem() {
        return breathingProblem;
    }

    public void setBreathingProblem(String breathingProblem) {
        this.breathingProblem = breathingProblem;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUrgencyScore() {
        return urgencyScore;
    }

    public void setUrgencyScore(int urgencyScore) {
        this.urgencyScore = urgencyScore;
    }

    public int getRescueStatus() {
        return rescueStatus;
    }

    public void setRescueStatus(int rescueStatus) {
        this.rescueStatus = rescueStatus;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLan() {
        return lan;
    }

    public void setLan(double lan) {
        this.lan = lan;
    }
}