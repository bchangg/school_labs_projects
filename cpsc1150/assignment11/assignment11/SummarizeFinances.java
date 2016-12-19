/** Program Name: SummarizeFinances
** Name and ID: Brian Chang - 100291105 Zahmayne Lindsay - 100266149
** Date: November 30, 2016
** Lab: 11
** Course: CPSC 1150
**/
// import all the packages that we'll be using in this program
import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class SummarizeFinances {//this program reads the files within the Finances directory and makes a summary from its files
    // declare global variables that are accessible to all the functions in the class
    static File financesFolder = new File("Finances/"); //using the File class as a folder
    static File[] fileList = financesFolder.listFiles(); //store all the files in the folder into an array of Files

    public static void main(String[] args) throws IOException {
        File summaryFolder = new File("Summary/"); //create a new folder in the current folder
        File summary2013 = new File("Summary/2013_summary.txt"); //create a File object that points to a non-existent yet file inside the Summary folder
        File summary2014 = new File("Summary/2014_summary.txt");
        File summary2015 = new File("Summary/2015_summary.txt");

    	//format titles of the individual summary tables
        if(summaryFolder.mkdir()) {
            PrintWriter summ2013Writer = new PrintWriter(summary2013);
            PrintWriter summ2014Writer = new PrintWriter(summary2014);
            PrintWriter summ2015Writer = new PrintWriter(summary2015);
            summ2013Writer.printf("%-15s %s\n", "Month", "Net Earning/Spending");
            summ2013Writer.println("====================================");

            summ2014Writer.printf("%-15s %s\n", "Month", "Net Earning/Spending");
            summ2014Writer.println("====================================");

            summ2015Writer.printf("%-15s %s\n", "Month", "Net Earning/Spending");
            summ2015Writer.println("====================================");

        	//formats table info(left align months, right align earnings
        	for(File current : fileList) {
                if(Integer.parseInt(getFileYear(current.getName())) == 2013) {
                    if(calculateMonthlySpending(current) > 0) {
                        summ2013Writer.printf("%-15s +$%.2f\n", getFileMonth(current.getName()), calculateMonthlySpending(current));
                    } else {
                        summ2013Writer.printf("%-15s -$%.2f\n", getFileMonth(current.getName()), calculateMonthlySpending(current));
                    }
                } else if(Integer.parseInt(getFileYear(current.getName())) == 2014) {
                    if(calculateMonthlySpending(current) > 0) {
                        summ2014Writer.printf("%-15s +$%.2f\n", getFileMonth(current.getName()), calculateMonthlySpending(current));
                    } else {
                        summ2014Writer.printf("%-15s -$%.2f\n", getFileMonth(current.getName()), calculateMonthlySpending(current));
                    }
                } else if(Integer.parseInt(getFileYear(current.getName())) == 2015) {
                    if(calculateMonthlySpending(current) > 0) {
                        summ2015Writer.printf("%-15s +$%.2f\n", getFileMonth(current.getName()), calculateMonthlySpending(current));
                    } else {
                        summ2015Writer.printf("%-15s -$%.2f\n", getFileMonth(current.getName()), calculateMonthlySpending(current));
                    }
                }
            }
            summ2013Writer.close();
            summ2014Writer.close();
            summ2015Writer.close();//end PrintWriter
        }
    }//end main

    public static String getFileYear(String fileName) {
        Pattern yyyy = Pattern.compile("[0-9]{4}"); //look for 4 integers between 0-9 in a row
        Matcher fileNameMatcher = yyyy.matcher(fileName);
        if(fileNameMatcher.find()) {
            return fileNameMatcher.group(); //return the group of tokens that we found to match the pattern
        }
        return "no year";
    }

    //this function uses a Scanner delimiter to break the fileName string at the "-", and it gets the month by grabbing the next int
    public static String getFileMonth(String fileName) {
        Scanner sc = new Scanner(fileName);
        sc.useDelimiter("-");
        int month = sc.nextInt();
        switch(month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        sc.close();
        return "no month";
    } //end getFileMonth

    //method will return how much was spent/earned in the month of the file given to it
    public static double calculateMonthlySpending(File file) throws IOException {
        Scanner sc = new Scanner(file);
        sc.nextLine(); //skip the first line
        double sum = 0;
        while(sc.hasNextLine()) {
            //essentially here we're  looking for a specific pattern that will only match for something that looks like -$1234.56, or +$1234.56, could have more or less to the left of the .
            //after we find it, we snip out the "$" by using replace "$" with ""
            //then we can turn that string into an double by using Double.parseDouble(), and finally we can add that to a variable called sum to find out the total of the transactions
            String currentLine = sc.nextLine();
            Pattern transaction = Pattern.compile("..\\d+\\.\\d+$");
            Matcher fileMatcher = transaction.matcher(currentLine);
            if(fileMatcher.find()) {
                String currentTransaction = fileMatcher.group();
                currentTransaction = currentTransaction.replace("$", "");
                sum += Double.parseDouble(currentTransaction);
            }
        }
        return sum;
    } //end calculateMonthlySpending

} //end class
