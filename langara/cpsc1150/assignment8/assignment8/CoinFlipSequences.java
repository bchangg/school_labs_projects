import java.util.Scanner;

public class CoinFlipSequences {
    public static void main(String[] args) {
        System.out.println("Hello. This program will find the longest burst length in sequences of coin flips.");

        //declare new scanner
        Scanner sc = new Scanner(System.in);

        //declare and initiate the variables for number of experiments and number of flips per experiment
        int numExp = 0;
        numExp = getNewNumExp(numExp, sc);
        int numFlips = 0;
        numFlips = getNewNumFlip(numFlips, sc);

        //declare, build, and print the first row of the matrix
        String titleRow = String.format("%1$4s %2$10s %3$5s", "Exp.", "Longest Burst", "Flips");
        System.out.println(titleRow);

        //declare variables to be used in the matrix
        int sumLongest = 0;
        int currentLongest = 0;
        int[] longestArray = new int[numFlips];
        //build and print each row of the matrix
        for(int row = 0; row < numExp; row++) {
            String flipSequence = RandomGames.coinFlips(numFlips); //generate a string of random coin flips
            currentLongest = checkBurst(flipSequence); //get the longest chain of H/T
            sumLongest += currentLongest; //add that to the total

            String currentRow = String.format("%1$4d %2$13d %3$" + (numFlips) + "s", (row + 1), currentLongest, flipSequence); //build the string for the current row
            System.out.println(currentRow); //print the string
        }
        int averageLongest = sumLongest/numExp; //divide the total by the number of experiments to get the average of all the longest
        System.out.println("The average longest burst has length " + averageLongest + "."); //print the average

        sc.close();
    }

    public static int getNewNumExp(int num, Scanner sc) { //this function will take return a number for the number of experiments from the user
        while(num <= 0) {
            System.out.println("\nPlease enter the number of experiments to conduct:\n(Make sure the number is positive!)");
            num = sc.nextInt();
        }
        return num;
    }

    public static int getNewNumFlip(int num, Scanner sc) { //this function will take return a number for the number of flips per experiment from the user
        while(num <= 0) {
            System.out.println("Please enter the number of coin flips per experiment:\n(Remember to make this number positive as well!)");
            num = sc.nextInt();
        }
        return num;
    }

    public static int checkBurst(String sequence) { //this function will take in a string sequence and return the longest chain of same characters
        //initiate two variables to store the current longest, and the total longest
        int current = 1, longest = 1;
        for(int i = 1; i < sequence.length(); i++) {
            if(sequence.charAt(i-1) == sequence.charAt(i)) { //if two characters are the same in a row, add one to current
                current++;
                if(longest < current) { //if the current is more than the longest we have in memory, add 1 to the longest
                    longest++;
                }
            } else { //this mean the chain has been broken, so reset current to 1
                current = 1;
            }
        }
        return longest; //return the longest chain of same characters
    }
}
