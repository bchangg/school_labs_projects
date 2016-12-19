public class RandomGames {
    public static double[] randomArray(int length, double low, double high) {
        double[] randomArray = new double[length];

        for(int index = 0; index < length; index++) {
            double randomNum = low + Math.random() * ((high - low));
            randomArray[index] = randomNum;
        }
        return randomArray;
    }

    public static int[] randomArray(int length, int low, int high) {
        int[] randomArray = new int[length];

        for(int index = 0; index < length; index++) {
            int randomNum = low + (int)(Math.random() * high);
            randomArray[index] = randomNum;
        }
        return randomArray;
    }

    public static String coinFlips(int numFlips) {
        int[] randomArray = new int[numFlips];
        randomArray = randomArray(numFlips,0,100);
        String output = "";

        for(int index = 0; index < numFlips; index++) {
            if(randomArray[index] <= 50) {
                output += "H";
            } else {
                output += "T";
            }
        }
        return output;
    }

    public static int[] dieRolls(int numRolls) {
        int[] randomRolls = new int[numRolls];
        randomRolls = randomArray(numRolls, 1, 6);
        return randomRolls;
    }

    public static String toString(int[] theArray) {
        String output = "" + theArray[0];
        for(int i = 1; i < theArray.length; i++) {
            output += ", " + theArray[i];
        }
        return output;
    }
}
