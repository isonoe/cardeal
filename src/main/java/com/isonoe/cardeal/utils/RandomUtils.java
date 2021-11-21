package com.isonoe.cardeal.utils;

import com.isonoe.cardeal.aglib.AgPopulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    public static Integer getRandomNumberInRange(Integer lowNumber, Integer highNumber) {
        Random gerador = new Random();
        return gerador.nextInt((highNumber + 1) - lowNumber) + lowNumber;
    }

    public static List<Integer> getRandomNumbersOfRange(Integer lowNumber, Integer highNumber, Integer qtd) {
        return RandomUtils.getRandomNumbersOfRange(lowNumber, highNumber, qtd, false);
    }

    public static List<Integer> getRandomNumbersOfRange(Integer lowNumber, Integer highNumber, Integer qtd, boolean unique) {

        if (lowNumber >= highNumber) {
            return null;
        }

        ArrayList<Integer> pickListInteger = new ArrayList<>();

        for (int i = lowNumber; i < highNumber; i++) {
            pickListInteger.add(i);
        }

        ArrayList<Integer> integerArrayList = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            Integer rNum = RandomUtils.getRandomNumberInRange(0,
                    pickListInteger.size() - 1);
            integerArrayList.add(pickListInteger.get(rNum));
            if (unique) {
                pickListInteger.remove(rNum);
            }
        }

        return integerArrayList;
    }
}
