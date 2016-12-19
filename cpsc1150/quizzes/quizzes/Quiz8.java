public class Quiz8 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};

        reverse(nums);

        for(int i = 0; i < 6; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void reverse(int[] theArray) {
        int[] reversed = new int[theArray.length];

        for(int i = 0; i < theArray.length; i++) {
            reversed[i] = theArray[theArray.length - i - 1];
        }

        for(int i = 0; i < theArray.length; i++) {
            theArray[i] = reversed[i];
        }
    }
}
