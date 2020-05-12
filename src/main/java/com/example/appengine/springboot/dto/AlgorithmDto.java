package com.example.appengine.springboot.dto;

public class AlgorithmDto {
    float maleFactor;
    float femaleFactor;
    float minIncomeFactor;
    float maxIncomeFactor;
    float middleIncomeFactor;
    float minAge;
    float maxAge;
    float minAgeFactor;
    float maxAgeFactor;
    float middleAgeFactor;
    float pregnancyFactor;
    float terminalIllness1Factor;
    float terminalIllness2Factor;
    float terminalIllness3Factor;
    float terminalIllness4Factor;
    float mobilityOption1Factor;
    float mobilityOption2Factor;
    float mobilityOption3Factor;
    float breathingProblem1Factor;
    float breathingProblem2Factor;
    float breathingProblem3Factor;
    float breathingProblem4Factor;
    float minBmi;
    float maxBmi;
    float minBmiFactor;
    float maxBmiFactor;
    float middleBmiFactor;
    int algoId;
    long minIncome;
    long maxIncome;
    double disasterLat;     // Disaster latitude
    double disasterLan;      // Disaster longitude

    @Override
    public String toString() {
        return "AlgorithmDto{" +
                "algoId=" + algoId +
                "maleFactor=" + maleFactor +
                ", femaleFactor=" + femaleFactor +
                ", minIncome=" + minIncome +
                ", maxIncome=" + maxIncome +
                ", minIncomeFactor=" + minIncomeFactor +
                ", maxIncomeFactor=" + maxIncomeFactor +
                ", middleIncomeFactor=" + middleIncomeFactor +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", minAgeFactor=" + minAgeFactor +
                ", maxAgeFactor=" + maxAgeFactor +
                ", middleAgeFactor=" + middleAgeFactor +
                ", pregnancyFactor=" + pregnancyFactor +
                ", terminalIllness1Factor=" + terminalIllness1Factor +
                ", terminalIllness2Factor=" + terminalIllness2Factor +
                ", terminalIllness3Factor=" + terminalIllness3Factor +
                ", terminalIllness4Factor=" + terminalIllness4Factor +
                ", mobilityOption1Factor=" + mobilityOption1Factor +
                ", mobilityOption2Factor=" + mobilityOption2Factor +
                ", mobilityOption3Factor=" + mobilityOption3Factor +
                ", breathingProblem1Factor=" + breathingProblem1Factor +
                ", breathingProblem2Factor=" + breathingProblem2Factor +
                ", breathingProblem3Factor=" + breathingProblem3Factor +
                ", breathingProblem4Factor=" + breathingProblem4Factor +
                ", minBmi=" + minBmi +
                ", maxBmi=" + maxBmi +
                ", minBmiFactor=" + minBmiFactor +
                ", maxBmiFactor=" + maxBmiFactor +
                ", middleBmiFactor=" + middleBmiFactor +
                ", disasterLat=" + disasterLat +
                ", disasterLan=" + disasterLan +
                '}';
    }

    public int getAlgoId() {
        return algoId;
    }

    public void setAlgoId(int algoId) {
        this.algoId = algoId;
    }

    public float getTerminalIllness1Factor() {
        return terminalIllness1Factor;
    }

    public void setTerminalIllness1Factor(float terminalIllness1Factor) {
        this.terminalIllness1Factor = terminalIllness1Factor;
    }

    public float getTerminalIllness2Factor() {
        return terminalIllness2Factor;
    }

    public void setTerminalIllness2Factor(float terminalIllness2Factor) {
        this.terminalIllness2Factor = terminalIllness2Factor;
    }

    public float getTerminalIllness3Factor() {
        return terminalIllness3Factor;
    }

    public void setTerminalIllness3Factor(float terminalIllness3Factor) {
        this.terminalIllness3Factor = terminalIllness3Factor;
    }

    public float getTerminalIllness4Factor() {
        return terminalIllness4Factor;
    }

    public void setTerminalIllness4Factor(float terminalIllness4Factor) {
        this.terminalIllness4Factor = terminalIllness4Factor;
    }

    public float getBreathingProblem1Factor() {
        return breathingProblem1Factor;
    }

    public void setBreathingProblem1Factor(float breathingProblem1Factor) {
        this.breathingProblem1Factor = breathingProblem1Factor;
    }

    public float getBreathingProblem2Factor() {
        return breathingProblem2Factor;
    }

    public void setBreathingProblem2Factor(float breathingProblem2Factor) {
        this.breathingProblem2Factor = breathingProblem2Factor;
    }

    public float getBreathingProblem3Factor() {
        return breathingProblem3Factor;
    }

    public void setBreathingProblem3Factor(float breathingProblem3Factor) {
        this.breathingProblem3Factor = breathingProblem3Factor;
    }

    public float getBreathingProblem4Factor() {
        return breathingProblem4Factor;
    }

    public void setBreathingProblem4Factor(float breathingProblem4Factor) {
        this.breathingProblem4Factor = breathingProblem4Factor;
    }

    public double getDisasterLan() {
        return disasterLan;
    }

    public void setDisasterLan(double disasterLan) {
        this.disasterLan = disasterLan;
    }

    public float getMaleFactor() {
        return maleFactor;
    }

    public void setMaleFactor(float maleFactor) {
        this.maleFactor = maleFactor;
    }

    public float getFemaleFactor() {
        return femaleFactor;
    }

    public void setFemaleFactor(float femaleFactor) {
        this.femaleFactor = femaleFactor;
    }

    public long getMinIncome() {
        return minIncome;
    }

    public void setMinIncome(long minIncome) {
        this.minIncome = minIncome;
    }

    public long getMaxIncome() {
        return maxIncome;
    }

    public void setMaxIncome(long maxIncome) {
        this.maxIncome = maxIncome;
    }

    public float getMinIncomeFactor() {
        return minIncomeFactor;
    }

    public void setMinIncomeFactor(float minIncomeFactor) {
        this.minIncomeFactor = minIncomeFactor;
    }

    public float getMaxIncomeFactor() {
        return maxIncomeFactor;
    }

    public void setMaxIncomeFactor(float maxIncomeFactor) {
        this.maxIncomeFactor = maxIncomeFactor;
    }

    public float getMiddleIncomeFactor() {
        return middleIncomeFactor;
    }

    public void setMiddleIncomeFactor(float middleIncomeFactor) {
        this.middleIncomeFactor = middleIncomeFactor;
    }

    public float getMinAge() {
        return minAge;
    }

    public void setMinAge(float minAge) {
        this.minAge = minAge;
    }

    public float getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(float maxAge) {
        this.maxAge = maxAge;
    }

    public float getMinAgeFactor() {
        return minAgeFactor;
    }

    public void setMinAgeFactor(float minAgeFactor) {
        this.minAgeFactor = minAgeFactor;
    }

    public float getMaxAgeFactor() {
        return maxAgeFactor;
    }

    public void setMaxAgeFactor(float maxAgeFactor) {
        this.maxAgeFactor = maxAgeFactor;
    }

    public float getMiddleAgeFactor() {
        return middleAgeFactor;
    }

    public void setMiddleAgeFactor(float middleAgeFactor) {
        this.middleAgeFactor = middleAgeFactor;
    }

    public float getPregnancyFactor() {
        return pregnancyFactor;
    }

    public void setPregnancyFactor(float pregnancyFactor) {
        this.pregnancyFactor = pregnancyFactor;
    }

    public float getMobilityOption1Factor() {
        return mobilityOption1Factor;
    }

    public void setMobilityOption1Factor(float mobilityOption1Factor) {
        this.mobilityOption1Factor = mobilityOption1Factor;
    }

    public float getMobilityOption2Factor() {
        return mobilityOption2Factor;
    }

    public void setMobilityOption2Factor(float mobilityOption2Factor) {
        this.mobilityOption2Factor = mobilityOption2Factor;
    }

    public float getMobilityOption3Factor() {
        return mobilityOption3Factor;
    }

    public void setMobilityOption3Factor(float mobilityOption3Factor) {
        this.mobilityOption3Factor = mobilityOption3Factor;
    }

    public float getMinBmi() {
        return minBmi;
    }

    public void setMinBmi(float minBmi) {
        this.minBmi = minBmi;
    }

    public float getMaxBmi() {
        return maxBmi;
    }

    public void setMaxBmi(float maxBmi) {
        this.maxBmi = maxBmi;
    }

    public float getMinBmiFactor() {
        return minBmiFactor;
    }

    public void setMinBmiFactor(float minBmiFactor) {
        this.minBmiFactor = minBmiFactor;
    }

    public float getMaxBmiFactor() {
        return maxBmiFactor;
    }

    public void setMaxBmiFactor(float maxBmiFactor) {
        this.maxBmiFactor = maxBmiFactor;
    }

    public float getMiddleBmiFactor() {
        return middleBmiFactor;
    }

    public void setMiddleBmiFactor(float middleBmiFactor) {
        this.middleBmiFactor = middleBmiFactor;
    }

    public double getDisasterLat() {
        return disasterLat;
    }

    public void setDisasterLat(double disasterLat) {
        this.disasterLat = disasterLat;
    }

    public double getDiasterLan() {
        return disasterLan;
    }

    public void setDiasterLan(double disasterLan) {
        this.disasterLan = disasterLan;
    }
}
