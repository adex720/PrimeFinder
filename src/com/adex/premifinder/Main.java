package com.adex.premifinder;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {


        // write your code here

        for (int i = 0; i < 1000; i++) {
            getPrimes(1000);
        }
    }

    public static LinkedList<Integer> getPrimes(int goal) {

        long timeStart = System.nanoTime();

        boolean[] numbers = new boolean[goal + 1];
        LinkedList<Integer> primes = new LinkedList<>();


        for (int number = 3; number <= goal; number += 2) {
            if (!numbers[number]) {
                primes.add(number);

                for (int powderNumber = number; powderNumber <= goal; powderNumber *= number) {
                    if (powderNumber >= goal) {
                        break;
                    }

                    for (int prime : primes) {
                        for (int powderPrime = prime; powderPrime <= goal; powderPrime *= prime) {
                            int total = powderNumber * powderPrime;
                            if (total >= goal) {
                                break;
                            }

                            for (int secondPrime : primes) {
                                for (int secondPowderPrime = secondPrime; secondPowderPrime <= goal; secondPowderPrime *= secondPrime) {
                                    total *= secondPowderPrime;
                                    if (total >= goal || total < 0) {
                                        break;
                                    }

                                    numbers[total] = true;
                                }
                            }

                        }
                    }

                }

            }
        }

        //numbers[2] = true;
        primes.add(2);


        long timeEnd = System.nanoTime();

        System.out.println("Time elapsed: " + (timeEnd - timeStart) + "ns");

        return primes;
    }

}
