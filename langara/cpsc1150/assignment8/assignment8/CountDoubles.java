import java.util.Scanner;

public class CountDoubles {
    public static void main(String[] args) {
        System.out.println("Hello. This program finds the number of double rolls in sequences of dice rolls."); //print the welcome message

        Scanner sc = new Scanner(System.in); //declare new scanner to get user input

        //declare and initialize the variables for number of experiments and number of rolls per experiment
        int numExp = 0;
        numExp = CoinFlipSequences.getNewNumExp(numExp, sc);
        int numRolls = 0;
        numRolls = getNewNumRolls(numRolls, sc);

        for(int exp = 1; exp <= numExp; exp++) { //print out each experiment
            //declare and instantiate two new die arrays, and also convert them to strings, stored in separate variables
                //first die
            int[] die1 = new int[numRolls];
            die1 = RandomGames.dieRolls(numRolls);
            String die1String = RandomGames.toString(die1);
                //second die
            int[] die2 = new int[numRolls];
            die2 = RandomGames.dieRolls(numRolls);
            String die2String = RandomGames.toString(die2);

            int numDoubles = checkDouble(die1, die2); //get the number of doubles in the two arrays

            //print out the experiment number, number of doubles in the two rolls, and the two rolls
            System.out.printf("\nExperiment %d: Num. doubles = %d\n", exp, count);
            System.out.println("Die 1: " + die1String);
            System.out.println("Die 2: " + die2String);
        }
        sc.close();
    }

    public static int getNewNumRolls(int num, Scanner sc) { //this function will get a non-negative integer from the user to be used as the number of rolls
        while(num <= 0) {
            System.out.println("Please enter the number of rolls per experiment:\n(Make sure the number is positive!)");
            num = sc.nextInt();
        }
        return num;
    }

    public static int checkDouble(int[] die1, int[] die2) { //this function will check how many double rolls are in two arrays of die rolls and return it to the calling funciton
        int count = 0;
        for(int index = 0; index < die1.length; index++) {
            if(die1[index] == die2[index]) { //if the values at the two indexes are the same, add 1 to count
                count++;
            }
        }
        return count;
    }
}
