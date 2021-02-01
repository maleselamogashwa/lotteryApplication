package com.LotteryApp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void LotteryNumbers(){

     int[] winningNumbers = {1, 2, 3, 4, 5};
     for (int i=0; i<winningNumbers.length; i++){
         Random ballSet1 = new Random();
         winningNumbers[i] = 1 + ballSet1.nextInt(50 - 1); // "Array Transversal" - to perform the specified operation
     }
     Collections.shuffle(Arrays.asList(winningNumbers)); //Creates unique random numbers within the array
     Random bonusBallSet1 = new Random();
     int bonusBall = bonusBallSet1.nextInt(20);

     System.out.println(Arrays.toString(winningNumbers) + " " + bonusBall );


    }

    public static void PlayerNumbers(){
        System.out.println("Enter your numbers: ");

        int[] playerNumbers;
        playerNumbers = new int[5];
        for (int i=0; i<playerNumbers.length; i++) {
            Scanner sc = new Scanner(System.in);
            playerNumbers[i] = sc.nextInt();
        }

        Scanner playerBonus = new Scanner(System.in);
        System.out.print("Bonus Ball: ");
        int playerBonusBall = playerBonus.nextInt();

        //Check for duplicate numbers
        for(int i=0; i<playerNumbers.length; i++){
            for(int j=i+1; j<playerNumbers.length; j++){
                if(playerNumbers[i] == playerNumbers[j]){
                    System.out.println("The number" + " " + playerNumbers[j] + " " + "is duplicated. Would you like to change the number? 1. Yes 2. No");
                    Scanner duplicateScanner = new Scanner(System.in);
                    int changeDuplicateOption = duplicateScanner.nextInt();
                    if(changeDuplicateOption == 1){
                        Scanner duplicateChangeScanner = new Scanner(System.in);
                        System.out.println("Enter replacement number: ");
                        int duplicateNumber = duplicateChangeScanner.nextInt();
                        playerNumbers[j] = duplicateNumber;
                    } else {
                        PlayerNumbers();
                    }
                }
            }
        }

        //Check that the Players number set does not contain 0 or numbers > 50

        for(int i=0; i<playerNumbers.length; i++){
            if(playerNumbers[i] > 50){
                System.out.println("You have entered a number greater than 50. 1. Change number 2. Rebet");
                Scanner rebetScanner = new Scanner(System.in);
                int rebetNumber = rebetScanner.nextInt();
                if(rebetNumber == 1){
                    System.out.println("Enter your number: ");
                    rebetNumber = rebetScanner.nextInt();
                    playerNumbers[i] = rebetNumber;

                } else{
                    PlayerNumbers();
                }
            }
        }

        //Check if Bonus Ball is within specified bounds
        if(playerBonusBall>20 || playerBonusBall == 0){
            System.out.println("Bonus ball cannot be 0 or greater than 20");
            System.out.println("Your previous number set was:" + " " + Arrays.toString(playerNumbers) + " " + "would you like to replay the numbers? ");
            System.out.println("Yes:1 No:2");

            Scanner replayScanner = new Scanner(System.in);
            int replayPlayerNumbers = replayScanner.nextInt();

            if (replayPlayerNumbers == 1){
                System.out.print("Bonus Ball: ");
                playerBonusBall = playerBonus.nextInt();

                if(playerBonusBall>20 || playerBonusBall==0){
                    System.out.println("Bonus ball not within bounds. Place your bet again");
                    PlayerNumbers();
                }
                System.out.println(Arrays.toString(playerNumbers) + " " + playerBonusBall);

            } else{
                PlayerNumbers(); //Method is recursive
            }

        } else{
            System.out.println(Arrays.toString(playerNumbers) + " " + playerBonusBall);
        }


    }

    public static void main(String[] args) {
        PlayerNumbers();
        LotteryNumbers();

    }
}
