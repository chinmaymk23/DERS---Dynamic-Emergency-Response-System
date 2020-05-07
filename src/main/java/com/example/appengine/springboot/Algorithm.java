package com.example.appengine.springboot;

import com.example.appengine.springboot.dto.UserDetailsDto;

public class Algorithm {

    public static int calculateUrgencyScore(UserDetailsDto userDetailsDto) {
        int urgencyScore = 0;

//        Age conditions
        if (userDetailsDto.getAge() >= 60)
            urgencyScore += 3;
        else if (userDetailsDto.getAge() <= 15)
            urgencyScore += 2;
        else
            urgencyScore += 1;

//        Annual income conditions
        if (userDetailsDto.getAnnualIncome() < 25000)
            urgencyScore += 3;
        else if (userDetailsDto.getAnnualIncome() >= 25000 && userDetailsDto.getAnnualIncome() < 100000)
            urgencyScore += 2;
        else
            urgencyScore += 1;

//        Gender conditions
//        if (userDetailsDto.getGender().equals('Female'))
//            urgencyScore += 1;

//        Medical conditions
        if (userDetailsDto.isMobility() == 1)
            urgencyScore += 3;
        if (userDetailsDto.isTerminalIllness() == 1)
            urgencyScore += 3;
        if (userDetailsDto.isPregnancy() == 1)
            urgencyScore += 3;


        if (userDetailsDto.isBreathingProblem() == 1)
            urgencyScore += 2;

//        BMI score test
        urgencyScore = checkBMI(userDetailsDto.getHeight(), userDetailsDto.getWeight(), urgencyScore);
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

}
