package org.example;
import MyNumbersModule.LongSequenceHolder;
import MyNumbersModule.MyNumbersPOA;
import org.omg.CORBA.ORB;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class NumbersImpl extends MyNumbersPOA {
    private HashSet<Integer> numberSet = new HashSet<Integer>();
    @Override
    public int[] getNumberSet() {

        return numberSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Override
    public void addRandomNumbers(int number) {

        numberSet = new HashSet<>();
        for(int i=0;i<number;i++)
        {
            int flag=0;
            int RandomNumber =0;
          do {
              flag=0;
              RandomNumber = ThreadLocalRandom.current().nextInt(-10, 10);
              if (numberSet.contains(RandomNumber)) flag++;
          }while (flag!=0);
            numberSet.add(RandomNumber);
        }
    }

    @Override
    public int[] getNegativeNumbers() {
        HashSet<Integer> negativeNumbers = new HashSet<>();
        for (int number : numberSet) {
            if (number < 0) {
                negativeNumbers.add(number);
            }
        }
        return negativeNumbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
