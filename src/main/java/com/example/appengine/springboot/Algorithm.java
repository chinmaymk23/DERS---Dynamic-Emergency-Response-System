package com.example.appengine.springboot;

import com.example.appengine.springboot.dto.UserDetailsDto;

public class Algorithm {

    int mode;
    String affectedGender;
    long minIncome;
    long maxIncome;
    int minAge;
    int maxAge;
    String isPregnancy;
    int minBmi;
    int maxBmi;
    double disasterLat;     // Disaster latitude
    double diasterLan;      // Disaster longitude

    public static int calculateUrgencyScore(UserDetailsDto dto) {
        int urgencyScore = 0;

//        Age conditions
        if (dto.getAge() >= 60)
            urgencyScore += 3;
        else if (dto.getAge() <= 15)
            urgencyScore += 2;
        else
            urgencyScore += 1;

//        Annual income conditions
        if (dto.getAnnualIncome() < 25000)
            urgencyScore += 3;
        else if (dto.getAnnualIncome() >= 25000 && dto.getAnnualIncome() < 100000)
            urgencyScore += 2;
        else
            urgencyScore += 1;

//        Gender conditions
//        if (dto.getGender().equals('Female'))
//            urgencyScore += 1;

//        Medical conditions
//        if (dto.isMobility() == 1)
//            urgencyScore += 3;
//        if (dto.isTerminalIllness() == 1)
//            urgencyScore += 3;
//        if (dto.isPregnancy() == 1)
//            urgencyScore += 3;
//
//
//        if (dto.isBreathingProblem() == 1)
//            urgencyScore += 2;

//        BMI score test
        urgencyScore = checkBMI(dto.getHeight(), dto.getWeight(), urgencyScore);
        System.out.println("urgencyScore - " + urgencyScore);

        return urgencyScore;
    }

    public static int checkBMI(int height, int weight, int urgencyScore) {
        double bmi = (703 * weight / Math.pow(height, 2));

        if (bmi < 18)
            urgencyScore += 2;
        else if (bmi > 30)
            urgencyScore += 3;
        else
            urgencyScore += 1;

        return urgencyScore;
    }

    public int addLocationScore(double lat, double lan) {
        return 1000;
    }
}
