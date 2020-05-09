package com.example.appengine.springboot;

import com.example.appengine.springboot.dao.UserDetailsDao;
import com.example.appengine.springboot.dto.AlgorithmDto;
import com.example.appengine.springboot.dto.UserDetailsDto;

public class Algorithm {

    UserDetailsDao dao = new UserDetailsDao();

    public int calculateUrgencyScore(UserDetailsDto dto) {
        AlgorithmDto algo = dao.getAlgo();
        System.out.println(algo);
        int urgencyScore = 0;

//        Age conditions
        if (dto.getAge() >= algo.getMaxAge())
            urgencyScore += algo.getMaxAgeFactor();
        else if (dto.getAge() <= algo.getMinAge())
            urgencyScore += algo.getMinAgeFactor();
        else
            urgencyScore += algo.getMiddleAgeFactor();

//        Annual income conditions
        if (dto.getAnnualIncome() < algo.getMinIncome())
            urgencyScore += algo.getMinAgeFactor();
        else if (dto.getAnnualIncome() >= algo.getMinIncome() && dto.getAnnualIncome() < algo.getMaxIncome())
            urgencyScore += algo.getMiddleIncomeFactor();
        else
            urgencyScore += algo.getMaxIncomeFactor();

//        Gender conditions
        if (dto.getGender().equals("Male"))
            urgencyScore += algo.getMaleFactor();
        else if (dto.getGender().equals("Female"))
            urgencyScore += algo.getFemaleFactor();

//        Medical conditions
        if (dto.getTerminalIllness() == "Heart Condition")
            urgencyScore += algo.getTerminalIllness1Factor();
        if (dto.getTerminalIllness() == "Liver/Kindey disease")
            urgencyScore += algo.getTerminalIllness2Factor();
        if (dto.getTerminalIllness() == "Heart Condition")
            urgencyScore += algo.getTerminalIllness3Factor();
        if (dto.getTerminalIllness() == "Heart Condition")
            urgencyScore += algo.getTerminalIllness4Factor();

        if (dto.getPregnancy().equalsIgnoreCase("yes"))
            urgencyScore += algo.getPregnancyFactor();

        if (dto.getMobility() == "Heart Condition")
            urgencyScore += algo.getMobilityOption1Factor();
        if (dto.getMobility() == "Liver/Kindey disease")
            urgencyScore += algo.getMobilityOption2Factor();
        if (dto.getMobility() == "Heart Condition")
            urgencyScore += algo.getMobilityOption3Factor();

        if (dto.getBreathingProblem() == "Heart Condition")
            urgencyScore += algo.getBreathingProblem1Factor();
        if (dto.getBreathingProblem() == "Liver/Kindey disease")
            urgencyScore += algo.getBreathingProblem2Factor();
        if (dto.getBreathingProblem() == "Heart Condition")
            urgencyScore += algo.getBreathingProblem3Factor();
        if (dto.getBreathingProblem() == "Heart Condition")
            urgencyScore += algo.getBreathingProblem4Factor();

//        BMI score test
        urgencyScore = checkBMI(dto.getHeight(), dto.getWeight(), urgencyScore, algo);
        System.out.println("urgencyScore - " + urgencyScore);

        return urgencyScore;
    }

    public static int checkBMI(int height, int weight, int urgencyScore, AlgorithmDto algo) {
        double bmi = (703 * weight / Math.pow(height, 2));

        if (bmi < algo.getMinBmi())
            urgencyScore += algo.getMinBmiFactor();
        else if (bmi > algo.getMaxBmi())
            urgencyScore += algo.getMaxBmiFactor();
        else
            urgencyScore += algo.getMiddleBmiFactor();

        return urgencyScore;
    }

    public int addLocationScore(double lat, double lan) {
        AlgorithmDto dto = dao.getAlgo();
        return 0;
    }
}
