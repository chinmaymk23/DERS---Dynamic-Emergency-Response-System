package com.example.appengine.springboot.dto;

import java.util.Objects;

public class RescueInformationDto {

    private String name;
    private int urgencyScore;
    private int currentLocation;
    private int phoneNumber;
    private String medicalConditions;
    private boolean inProgress;
    private boolean rescued;

    @Override
    public String toString() {
        return "RescueInformation{" +
                "name='" + name + '\'' +
                ", urgencyScore=" + urgencyScore +
                ", currentLocation=" + currentLocation +
                ", medicalConditions='" + medicalConditions + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", inProgress=" + inProgress +
                ", rescued=" + rescued +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUrgencyScore() {
        return urgencyScore;
    }

    public void setUrgencyScore(int urgencyScore) {
        this.urgencyScore = urgencyScore;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public boolean isRescued() {
        return rescued;
    }

    public void setRescued(boolean rescued) {
        this.rescued = rescued;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RescueInformationDto that = (RescueInformationDto) o;
        return urgencyScore == that.urgencyScore &&
                currentLocation == that.currentLocation &&
                phoneNumber == that.phoneNumber &&
                inProgress == that.inProgress &&
                rescued == that.rescued &&
                Objects.equals(name, that.name) &&
                Objects.equals(medicalConditions, that.medicalConditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, urgencyScore, currentLocation, phoneNumber, medicalConditions, inProgress, rescued);
    }
}
