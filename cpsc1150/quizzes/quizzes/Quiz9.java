public class Quiz9 {
    public static void main(String[] args) {
        int[] sequence = {4,7,5,9,2,6,5};
        int[] newSequence = trimArray(sequence, 3);

        for(int i = 0; i < newSequence.length; i++) {
            System.out.print(newSequence[i]);
        }

    }

    public static int[] trimArray(int[] nums, int k) {
        int[] returnArray = new int[nums.length-k];
        for(int i = 0; i < returnArray.length; i++) {
            returnArray[i] = nums[i];
        }
        return returnArray;
    }
}
