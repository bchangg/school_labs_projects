/* This program demonstrates how to read from an existing text file
   within a Java program.
 */

//~ can just put: import java.io.*;
//~ instead of the next two lines
import java.io.File; //need this to use File objects
import java.io.IOException; //need this to throw an IOException
import java.util.Scanner;

public class ReadFromFile{
/* In this course, whenever a method performs file input/output
   (or calls a method that does) just add "throws IOException"
   to the end of the method header. It is not a good habit, but it will
   suffice for this course. In more advanced courses, you will learn how to
   handle exceptions instead of just throwing them. */
   public static void main(String[] args) throws IOException {

      String fileName, line, name, address;
      int commaIndex;

      //gets a filename from the user, and stores it in the String fileName
      Scanner sc = new Scanner(System.in);
      System.out.println("Please type the name (no extension) of a .txt file to read from:");
      fileName = sc.next();
      sc.close();

      File testFile = new File(fileName + ".txt"); //creates a new File object called testFile
      //note that the above line of code doesn't actually create a file on your computer
      if(!testFile.exists()){ // if the file doesn't exist on your computer
         System.out.println("The file " + fileName + ".txt doesn't exist."); //warn the user
         System.exit(1); //exit the program with exit code 1 (abnormal end of program)
      }

      //creating a Scanner of a file, and scanning the first line of the file
      Scanner fileSc = new Scanner(testFile); // fileSc is now a Scanner of testFile (you're used to System.in going here!)
      line = fileSc.nextLine(); // can use the usual Scanner methods
      fileSc.close(); // DO NOT FORGET TO CLOSE YOUR FILE SCANNER, when you are done using it

      System.out.println("The first line of the file is: ");
      System.out.println(line); // prints the line copied from the file

      commaIndex = line.indexOf(','); //finds the first comma in the line
      if(commaIndex > 0)
         name = line.substring(0,commaIndex); //gets the text before the first comma
      else
         name = line;
      System.out.println("The text before the first comma is: " + name);

      //There are many other types of processing you can do!
      //One good way to process .txt files with several types of information is
      //to get the next line in a loop (while the next line exists).
      //Once you have the line stored in a String, you can process that String to extract information.

      fileSc = new Scanner(testFile);
      System.out.println("\nThe names and addresses stored are:");
      System.out.printf("%-20s %-30s\n", "Name", "Address");
      while(fileSc.hasNextLine()){
         line = fileSc.nextLine();
         commaIndex = line.indexOf(',');
         if(commaIndex > 0)
            name = line.substring(0,commaIndex); //gets the text before the first comma
         else
            name = line;
         address = line.substring(commaIndex + 1).trim();
         System.out.printf("%-20s %-30s\n", name, address);
      }
      fileSc.close();

      //On the other hand, if you know you just had a file of integers separated by spaces and newlines,
      //you can just keep invoking nextInt() on the file Scanner until there are no more ints to read.

   }

}
