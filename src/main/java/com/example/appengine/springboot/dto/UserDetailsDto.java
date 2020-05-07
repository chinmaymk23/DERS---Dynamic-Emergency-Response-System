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
    private int mobility;
    private int terminalIllness;
    private int pregnancy;
    private int breathingProblem;
    private String others;
    private int phoneNumber;
    private int urgencyScore;
    private int inProgress;
    private int rescued;
    private int needRescue;
    private double lat;
    private double lan;

    public int getUrgencyScore() {
        return urgencyScore;
    }

    public void setUrgencyScore(int urgencyScore) {
        this.urgencyScore = urgencyScore;
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

    public int getInProgress() {
        return inProgress;
    }

    public void setInProgress(int inProgress) {
        this.inProgress = inProgress;
    }

    public int getRescued() {
        return rescued;
    }

    public void setRescued(int rescued) {
        this.rescued = rescued;
    }

    public int getNeedRescue() {
        return needRescue;
    }

    public void setNeedRescue(int needRescue) {
        this.needRescue = needRescue;
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

    public int isMobility() {
        return mobility;
    }

    public void setMobility(int mobility) {
        this.mobility = mobility;
    }

    public int isTerminalIllness() {
        return terminalIllness;
    }

    public void setTerminalIllness(int terminalIllness) {
        this.terminalIllness = terminalIllness;
    }

    public int isPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(int pregnancy) {
        this.pregnancy = pregnancy;
    }

    public int isBreathingProblem() {
        return breathingProblem;
    }

    public void setBreathingProblem(int breathingProblem) {
        this.breathingProblem = breathingProblem;
    }

    public String isOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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
                ", mobility=" + mobility +
                ", terminalIllness=" + terminalIllness +
                ", pregnancy=" + pregnancy +
                ", breathingProblem=" + breathingProblem +
                ", others='" + others + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", urgencyScore=" + urgencyScore +
                ", inProgress=" + inProgress +
                ", rescued=" + rescued +
                ", needRescue=" + needRescue +
                ", lat=" + lat +
                ", lan=" + lan +
                '}';
    }
}