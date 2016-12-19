public class Quiz10 {
    public static void main(String[] args) {
        int[][] test1True = {
            {0,1,0,0,0},
            {1,0,0,0,0},
            {0,0,0,1,0},
            {0,0,1,0,0},
            {0,0,0,0,1}
        };

        int[][] test2False = {
            {1,2},
            {2,1}
        };

        int[][] test3False = {
            {1,0,0},
            {0,1,0}
        };

        int[][] test4False = {
            {1,0},
            {1,0}
        };

        int[][] test5True = {
            {1,0},
            {0,1}
        };

        System.out.println(isPerm(test1True));
        System.out.println(isPerm(test2False));
        System.out.println(isPerm(test3False));
        System.out.println(isPerm(test4False));
        System.out.println(isPerm(test5True));

    }

    public static boolean isPerm(int[][] arr) {
        boolean[] colHasOne = new boolean[arr[0].length];

        for(int i = 0; i < colHasOne.length; i++) {
            colHasOne[i] = false;
        }

        for(int row = 0; row < arr.length; row++) {
            if(arr[row].length != arr.length) {
                return false;
            }
            for(int col = 0; col < arr[row].length; col++) {
                if(colHasOne[col] == true && arr[row][col] != 0) {
                    return false;
                }
                if(arr[row][col] != 1 && arr[row][col] != 0) {
                    return false;
                }
                if(arr[row][col] == 1) {
                    colHasOne[col] = true;
                }
            }
        }
        return true;
    }
}
