/* This class uses search and sort methods defined in SearchAndSort.java
in order to compare the Linear Search and Binary Search algorithms.
Author: Adina Goldberg
For: Lab 9, CPSC 1150-005/006, 2016 Spring, Langara College
*/

import java.util.Scanner;
public class Lab9{
   //keys to search for:
   static String[] toFind = {"the", "a", "was"};
   //famous first lines from various novels:
   static String[] s = {
      "The sun shone, having no alternative, on the nothing new.", //Murphy, Samuel Beckett
      "When Dick Gibson was a little boy he was not Dick Gibson.", //The Dick Gibson Show, Stanley Elkin
      "Happy families are all alike; every unhappy family is unhappy in its own way.", //Anna Karenina, Leo Tolstoy
      "It was a bright cold day in April, and the clocks were striking thirteen.", //1984, George Orwell
      "I had the story, bit by bit, from various people, and, as generally happens " +
         "in such cases, each time it was a different story.", //Ethan Frome, Edith Wharton
      "If you really want to hear about it, the first thing you'll probably want " +
         "to know is where I was born, and what my lousy childhood was like, " +
         "and how my parents were occupied and all before they had me, and all " +
         "that David Copperfield kind of crap, but I don't feel like going into " +
         "it, if you want to know the truth.", //The Catcher in the Rye, J.D. Salinger
      "Far out in the uncharted backwaters of the unfashionable end of " +
         "the western spiral arm of the Galaxy lies a small unregarded " +
         "yellow sun. " +
         "Orbiting this at a distance of roughly ninety-two million miles " +
         "is an utterly insignificant little blue green planet whose ape- " +
         "descended life forms are so amazingly primitive that they still " +
         "think digital watches are a pretty neat idea. " +
         "This planet has - or rather had - a problem, which was this: most " +
         "of the people living on it were unhappy for pretty much of the time. " +
         "Many solutions were suggested for this problem, but most of these " +
         "were largely concerned with the movements of small green pieces " +
         "of paper, which is odd because on the whole it wasn't the small " +
         "green pieces of paper that were unhappy. " +
         "And so the problem remained; lots of the people were mean, and " +
         "most of them were miserable, even the ones with digital watches. " +
         "Many were increasingly of the opinion that they'd all made a big " +
         "mistake in coming down from the trees in the first place. And " +
         "some suggested that even the trees had been a bad move, and that no " +
         "one should ever have left the oceans. " +
         "Then, one Thursday, nearly two thousand years after one man " +
         "had been nailed to a tree for saying how great it would be to be " +
         "nice to people for a change, a girl sitting on her own in a " +
         "small cafe in Rickmansworth England suddenly realized what it was that " +
         "had been going wrong all this time, and she finally knew how the " +
         "world could be made a good and happy place. This time it was " +
         "right, it would work, and no one would have to get nailed to " +
         "anything. " +
         "Sadly, however, before she could get to a telephone to tell anyone " +
         "about it, a terribly stupid catastrophe occurred, and the idea " +
         "was lost forever. " +
         "This is not her story. " +
         "But it is the story of that terrible stupid catastrophe and some " +
         "of its consequences. " +
         "It is also the story of a book. A book called The Hitch Hiker's " +
         "Guide to the Galaxy - not an Earth book, never published on " +
         "Earth, and until the terrible catastrophe occurred, never seen or even " +
         "heard of by any Earthman. " +
         "Nevertheless, a wholly remarkable book. " +
         "It is, perhaps, the most remarkable book ever to come out " +
         "of the great publishing houses of Ursa Minor - of which no " +
         "Earthman had ever heard either. " +
         "Not only is it a wholly remarkable book, it is also a highly " +
         "successful one - more popular than the Celestial Home Care " +
         "Omnibus, better selling than Fifty More Things to do in Zero " +
         "Gravity, and more controversial than Oolon Colluphid's trilogy of " +
         "philosophical blockbusters: Where God Went Wrong, Some More of " +
         "God's Greatest Mistakes and Who is this God Person Anyway? " +
         "And in many of the more relaxed civilizations on the Outer Eastern  " +
         "Rim of the Galaxy, the Hitch Hiker's Guide has already supplanted " +
         "the great Encyclopedia Galactica as the standard repository of " +
         "all knowledge and wisdom, for though it has many omissions and " +
         "contains much that is apocryphal, or at least wildly inaccurate, " +
         "it scores over the older, more pedestrian work in two important " +
         "respects. " +
         "First, it is slightly cheaper; and secondly it has the words " +
         "Don't Panic inscribed in large friendly letters on its cover. " +
         "But the story of this terrible, stupid Thursday, the story of its " +
         "extraordinary consequences, and the story of how these " +
         "consequences are inextricably intertwined with this remarkable " +
         "book begins very simply. " +
         "It begins with a house." //Hitchhiker's Guide to the Galaxy, Douglas Adams
   };

   /* main method */
   public static void main(String[] args){
      int linearComp1, linearComp2, binaryComp;
      int numWords;

      //loop through each key
      for(int j = 0; j < toFind.length; j++){

         //print header for table
         System.out.printf("%-15s %-15s %-15s %-15s\n", "Key: " + toFind[j], "Comparisons", "", "");
         System.out.printf("%-15s %-15s %-15s %-15s\n", "Num. words", "Linear (unstd.)", "Linear (std.)", "Binary (std.)");
         System.out.printf("%-15s %-15s %-15s %-15s\n", "---------------", "---------------", "---------------", "---------------");

         //loop through each famous first sentence
         for(int i = 0; i < s.length; i++){

            //preprocess sentence to turn it into an array of words
            String[] theList = getArray(s[i]);
            numWords = theList.length;

            //linear search on unsorted list
            SearchAndSort.linearSearch(theList, toFind[j]);
            linearComp1 = SearchAndSort.numComparisons;

            //linear search on sorted list
            SearchAndSort.selectionSort(theList);
            SearchAndSort.linearSearch(theList, toFind[j]);
            linearComp2 = SearchAndSort.numComparisons;

            //binary search on sorted list
            SearchAndSort.binarySearch(theList, toFind[j]);
            binaryComp = SearchAndSort.numComparisons;

            //prints comparison
            System.out.printf("%-15d %-15d %-15d %-15d\n", numWords, linearComp1, linearComp2, binaryComp);
         }
         System.out.println();
      }
   }

   //stores each word from sentence into an array of Strings, and returns the array
   public static String[] getArray(String sentence){
      sentence = removePunctuation(sentence);

      //getting number of words in sentence
      Scanner sc = new Scanner(sentence);
      int numWords = 0;
      while(sc.hasNext()){
         numWords++;
         sc.next();
      }
      sc.close();

      //transferring each word into an array
      String[] arr = new String[numWords];
      Scanner sc2 = new Scanner(sentence);
      for(int i = 0; i < numWords; i++){
         arr[i] = sc2.next();
      }
      sc2.close();
      return arr;
   }

   //returns the String sentence with all non-word characters removed
   public static String removePunctuation(String sentence){
      String newSent = "";
      int charType;
      char currentChar;
      for(int i = 0; i < sentence.length(); i++){
         currentChar = sentence.charAt(i);
         if(Character.isWhitespace(currentChar) || Character.isLetterOrDigit(currentChar) ||
               currentChar == '\'')
            newSent += currentChar;
      }
      return newSent;
   }

}
