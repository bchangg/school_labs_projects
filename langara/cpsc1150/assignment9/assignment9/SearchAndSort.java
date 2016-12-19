public class SearchAndSort{

   public static int numComparisons;

   public static void main(String[] args){
       // this is a bunch of tests taken from the string we have in Lab9 to test my functions
       
    //    String[] sequence = Lab9.getArray(Lab9.s[0]);
       //
    //    for(int i = 0; i < sequence.length; i++) {
    //        System.out.println(sequence[i]);
    //    }
    //    System.out.println();
       //
    //    System.out.println("Index= " + linearSearch(sequence, Lab9.toFind[0]));
    //    System.out.println("Number of comparisons: " + numComparisons);
    //    System.out.println();
       //
    //    selectionSort(sequence);
       //
    //    for(int i = 0; i < sequence.length; i++) {
    //        System.out.println(sequence[i]);
    //    }
    //    System.out.println();
       //
    //    System.out.println("Index= " + linearSearch(sequence, Lab9.toFind[0]));
    //    System.out.println("Number of comparisons: " + numComparisons);
   }

   public static int linearSearch(String[] arr, String key){
       numComparisons = 0;
       for(int index = 0; index < arr.length; index++) {
           numComparisons++;
           if(arr[index].compareTo(key) == 0) {
               numComparisons++;
               return index;
           }
       }
       return -1;
   }

   public static int binarySearch(String[] arr, String key){
       numComparisons = 0;
       int high = arr.length-1, low = 0, mid = (high + low)/2;

       while(high > low) {
           numComparisons++;
           if(arr[mid].compareTo(key) == 0) {
               numComparisons++;
               return mid;
           } else if(arr[mid].compareTo(key) > 0) {
               numComparisons++;
               high = mid - 1;
               mid = (high + low)/2;
           } else if(arr[mid].compareTo(key) < 0) {
               numComparisons++;
               low = mid + 1;
               mid = (high + low)/2;
           }
       }
       return -1;
   }

   //sort the given array arr using selection sort, swapping the next least element with the next element
   public static void selectionSort(String[] arr){
       numComparisons = 0;
       String currentMin;
       for(int current = 0; current < arr.length; current++) {
           numComparisons++;
           for(int checking = current+1; checking < arr.length; checking++) {
               numComparisons++;
               if(arr[checking].compareTo(arr[current]) < 0) {
                   numComparisons++;
                   swap(arr, checking, current);
               }
           }
       }
   }


   public static void swap(String[] arr, int i, int j){
       String temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
   }
}
