import java.util.Scanner;

public class ConnectFour {
    static String[][] board = new String[6][7]; //this will hold the positions of the chips
    static String[][] gameFrame = new String[6][7]; //this will hold the frame of the game, or the | that make up the game
    static int[] columnFill = {0,0,0,0,0,0,0}; //this will keep track of how many elements are in each column

    static int currentRow = 5; //this will keep track of the current row that we're filling in

    static int colChoice; //this is the user's choice for which column he/she wants to drop a chip into

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gameIntroduction();
        initializeGameFrame();
        initilizeBoard();
        while(true) {
            currentRow = 5;
            printGameCurrentState();
            getNewYellowChoice(sc);
            //FILL YELLOW LOGIC
            if(isEmpty(board, currentRow, colChoice)) {
                fillBoardAtPos(board, currentRow, colChoice, "Y");
            } else {
                while(!isEmpty(board, currentRow, colChoice) && currentRow > 0) {
                    currentRow--;
                }
                while(columnFill[colChoice] == 6) {
                    printGameCurrentState();
                    System.out.println("This column is full. Please select another column!");
                    getNewYellowChoice(sc);
                    currentRow = 5 - columnFill[colChoice];
                }
                fillBoardAtPos(board, currentRow, colChoice, "Y");
            }
            columnFill[colChoice]++;
            //CHECK IF YELLOW HAS WON
            if(checkWin("Y", board, currentRow)) {
                printGameCurrentState();
                System.out.println("GAME OVER, YELLOW IS THE WINNER!!");
                sc.close();
                return;
            }

            currentRow = 5;
            printGameCurrentState();
            getNewRedChoice(sc);
            //FILL RED LOGIC
            if(isEmpty(board, currentRow, colChoice)) {
                fillBoardAtPos(board, currentRow, colChoice, "R");
            } else {
                while(!isEmpty(board, currentRow, colChoice) && currentRow > 0) {
                    currentRow--;
                }
                while(columnFill[colChoice] == 6) {
                    printGameCurrentState();
                    System.out.println("This column is full. Please select another column!");
                    getNewRedChoice(sc);
                    currentRow = 5 - columnFill[colChoice];
                }
                fillBoardAtPos(board, currentRow, colChoice, "R");
            }
            columnFill[colChoice]++;
            //CHECK IF RED HAS WON
            if(checkWin("R", board, currentRow)) {
                printGameCurrentState();
                System.out.println("GAME OVER, RED IS THE WINNER!!");
                sc.close();
                return;
            }
        }
    }

    //initialize the game frame, as in fill in every single spot in the array to "|"
    public static void initializeGameFrame() {
        for(int row = 0; row < gameFrame.length; row++) {
            for(int col = 0; col < gameFrame[row].length; col++) {
                gameFrame[row][col] = "|";
            }
        }
    }

    //initialize the board, or fill everything in the board array to "", an empty string
    public static void initilizeBoard() {
        for(int row = 0; row < gameFrame.length; row++) {
            for(int col = 0; col < gameFrame[row].length; col++) {
                board[row][col] = "";
            }
        }
    }

    //print the current state of the game
    public static void printGameCurrentState() {
        for(int row = 0; row < gameFrame.length; row++) {
            for(int col = 0; col < gameFrame[row].length; col++) {
                System.out.print(gameFrame[row][col]);
                System.out.printf("%1s", board[row][col]);
            }
            System.out.println("|");
        }
    }

    //prints out an introduction to the game, and its rules
    public static void gameIntroduction() {
        System.out.println("This is a game of Connect Four.\n\nHow to play:\nFlip a coin. Whoever calls heads plays first as Yellow, and the other plays\nsecond as Red.\nEnter a number (1-7) for the column you wish to drop\na chip in. Your chip will be represented as Y for Yellow, and R for Red.\nWhoever first lines up 4 chips in a row wins.\nGood luck!");
    }

    //gets a new col choice for the yellow player
    public static void getNewYellowChoice(Scanner sc) {
        boolean hasIntValue = false;
        while(!hasIntValue) {
            System.out.println("\nPlease select a column (1-7) to drop a Yellow chip into:");
            String input = sc.next();
            try {
                colChoice = Integer.parseInt(input);
                if(colChoice >= 1 && colChoice <= 7) {
                    colChoice -= 1;
                    hasIntValue = true;
                } else {
                    System.out.println(colChoice);
                    System.out.println("Sorry, you have entered an invalid entry.");
                }
            } catch (Exception e) {
                System.out.println("Sorry, you have entered an invalid entry.");
            }
        }
    }

    //get a new column choice for the red player
    public static void getNewRedChoice(Scanner sc) {
        boolean hasIntValue = false;
        while(!hasIntValue) {
            System.out.println("\nPlease select a column (1-7) to drop a Red chip into:");
            String input = sc.next();
            try {
                colChoice = Integer.parseInt(input);
                if(colChoice >= 1 && colChoice <= 7) {
                    colChoice -= 1;
                    hasIntValue = true;
                } else {
                    System.out.println("Sorry, you have entered an invalid entry.");
                }
            } catch (Exception e) {
                printGameCurrentState();
                System.out.println("Sorry, you have entered an invalid entry.");
            }
        }
    }

    //fills the board at position row:row. and column:col if arr[row][col] is empty
    public static void fillBoardAtPos(String[][] arr, int row, int col, String colour) {
        if(isEmpty(arr, row, col)) {
            arr[row][col] = colour;
        }
    }

    //checks if arr[row][col] is empty
    public static boolean isEmpty(String[][] arr, int row, int col) {
        if(arr[row][col] == "" || arr[row][col].length() == 0) {
            return true;
        }
        return false;
    }

    //checks if one of the players has won
    public static boolean checkWin(String colour, String[][] board, int row) {
        //HORIZONTAL CHECK ON CURRENT ROW
        int longest = 0;
        for(int i = 0; i < board[row].length; i++) {
            if(board[row][i] == colour) {
                longest++;
            } else {
                longest = 0;
            }
            if(longest == 4) {
                return true;
            }
        }

        //VERTICAL CHECK ON CURRENT COLUMN
        longest = 0;
        for(int i = 0; i < board.length; i++) {
            if(board[i][colChoice] == colour) {
                longest++;
            } else {
                longest = 0;
            }
            if(longest == 4) {
                return true;
            }
        }

        //DIAGONAL CHECK LEFT TO RIGHT UP
        for(int diagonalUpRow = 3; diagonalUpRow < board.length; diagonalUpRow++) {
            int currRow = diagonalUpRow;
            String currentDiagonal = "";
            for(int col = 0; col <= diagonalUpRow; col++) {
                currentDiagonal += board[currRow][col];
                currRow--;
            }
            longest = findLongestChainNum(currentDiagonal);
            System.out.println(currentDiagonal);
            if(longest == 4) {
                return true;
            }
        }

        for(int diagonalUpCol = 1; diagonalUpCol < board[board.length-1].length-3; diagonalUpCol++) {
            int currRow = board.length-1;
            String currentDiagonal = "";
            for(int col = diagonalUpCol; currRow >= 0 && col < board[currRow].length; col++) {
                currentDiagonal += board[currRow][col];
                currRow--;
            }
            longest = findLongestChainNum(currentDiagonal);
            System.out.println(currentDiagonal);
            if(longest == 4) {
                return true;
            }
        }

        //DIAGONAL CHECK LEFT TO RIGHT DOWN
        return false;
    }

    //returns how many letters are in the longest chain of the given String
    public static int findLongestChainNum(String argument) {
        int count = 1;
        int currLongest = 1;
        for(int i = 0; i < argument.length() && i+1 < argument.length(); i++) {
            if(argument.charAt(i) == argument.charAt(i+1)) {
                System.out.println("entered");
                count++;
                // System.out.println(count);
            } else {
                currLongest = count;
                count = 1;
            }
        }
        System.out.println(currLongest);
        return currLongest;
    }
}
