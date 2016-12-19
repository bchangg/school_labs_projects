/* This program demonstrates how to create and write to a text file
   within a Java program.
 */
 
//~ can just put: import java.io.*;
//~ instead of the next three lines
import java.io.File; //need this to create a File object
import java.io.IOException; //need this to throw an IOException
import java.io.PrintWriter; //need this to write to a file
import java.util.Scanner;

public class WriteToFile{
   //Don't forget "throws IOException". See ReadFromFile.java for explanation.
   public static void main(String[] args) throws IOException {
      
      Scanner sc = new Scanner(System.in);
      System.out.println("Please type a filename (no extension) for the text file to create:");
      String fileName = sc.next();
      sc.close();
      
      File testFile = new File(fileName + ".txt"); //creates File object
      if(testFile.exists()){ //if the file already exists in your computer, we don't want to overwrite it
         System.out.println("The file " + fileName + ".txt already exists."); //warn user
         System.exit(1); //exit with exit code signifying abnormal termination
      }
      
      PrintWriter testPW = new PrintWriter(testFile); // create a PrintWriter object (this can write to testFile)
      
      testPW.println("Hello world! We are printing to a text file!"); //use any of the usual print methods, but...
      testPW.println("This file is called " + fileName + "."); //instead of System.out, put the name of your PrintWriter
      
      testPW.close(); //DON'T FORGET TO CLOSE YOUR PRINTWRITER!!!
      
   }

}