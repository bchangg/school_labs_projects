import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;

public class CombinationFinder {
    static File results = new File("results.txt");

    public static void main(String[] args) throws IOException {
        int x=5, y=10, z;
        // if(!results.exists()) {
        //     results.createNewFile();
        //     PrintWriter pw = new PrintWriter(results);
            // for(x = 123; x <= 999; x++) {
                // for(y = 123; y <= 999; y++) {
                    z = x + y;
                    if(noRepeats(x,y,z) && hasThreeDigits(z)) {
                        pw.println(x + " + " + y + " = " + z);
                    }
                // }
            // }
        // }
    }

    public static boolean hasThreeDigits(int number) {
        if(Integer.toString(number).length() <= 3) {
            System.out.println("entered");
            return true;
        }
        return false;
    }

    public static boolean noRepeats(int first, int second, int result) {
        String combined = Integer.toString(first) + Integer.toString(second) + Integer.toString(result);
        System.out.println(combined);
        // for(int current = 1; current < 10; current++) {
        //     int count = 0;
        //     String currentString = current + "";
        //     for(int index = 0; index < combined.length(); index++) {
        //         if(combined.charAt(index) == currentString.charAt(0)) {
        //             count++;
        //         }
        //     }
        //     if(count > 1) {
        //         return false;
        //     }
        // }
        return true;
    }
}
