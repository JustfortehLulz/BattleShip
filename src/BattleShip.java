import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BattleShip
{
    private static final int EMPTY = 0;
    private static final int SHIP = 1;
    private static final int HIT = 2;
    private static final int MISS = 3;
    private static final int Carrier = 5;
    private static final int Battleship = 4;
    private static final int Destroyer = 3;
    private static final int PatrolBoat = 2;
    int[][] board = new int[10][10];
    int[][] shootingBoard = new int[10][10];
    static Scanner obj = new Scanner(System.in);



    public static void printBoard(int[][] board)
    {
        System.out.println("    A   B   C   D   E   F   G   H   I   J");
        System.out.println("  -----------------------------------------");
        for(int row = 0; row < 10; row++)
        {
            System.out.print(row + " ");
            for(int col = 0; col < 10; col++)
            {
                if(board[row][col] == BattleShip.EMPTY)
                {
                    System.out.print("| " + " " + " ");
                }
                else if(board[row][col] == BattleShip.SHIP)
                {
                    System.out.print("| " + "S" + " ");
                }
                else if(board[row][col] == BattleShip.HIT)
                {
                    System.out.print("| " + "X" + " ");
                }
                else if(board[row][col] == BattleShip.MISS)
                {
                    System.out.print("| " + "O" + " ");
                }
                //System.out.print("| " + board[row][col] + " ");
            }
            System.out.print("|");
            System.out.println();
            System.out.println("  -----------------------------------------");
        }
    }

    public static int[][] setUpBoard(int[][] board)
    {

        String posString = "";
        String direction = "";
        boolean legalMove = false;
        String[] ships = {"Carrier","Battleship","Destroyer","Submarine","Patrol Boat"};
        String[] lengths = {"(5 unit lengths)","(4 unit lengths)","(3 unit lengths)","(3 unit lengths)","(2 unit lengths)"};
        //int i = 0;
        for(int i = 0;i < ships.length;i++)
        {
            //System.out.println("Enter the intial position of the " + ships[i] +lengths[i]+ ": ");
            //posString = obj.nextLine();
            //char[] pos = posString.toCharArray();
            //System.out.println("Enter the direction of the " + ships[i] +lengths[i]+ "(Right/Left/Up/Down): ");
            //direction = obj.nextLine();
            //System.out.println(pos[0] + " " + pos[1] +" "+ direction);
            //while loop checklegalmoves function
            while(!legalMove)
            {
                System.out.println("Enter the intial position of the " + ships[i] +lengths[i]+ ": ");
                posString = obj.nextLine();
                System.out.println("Enter the direction of the " + ships[i] +lengths[i]+ "(Right/Left/Up/Down): ");
                direction = obj.nextLine();
                legalMove = checkLegalMove(board,ships[i],posString,direction);
                if(!legalMove)
                {
                    System.out.println("That is not a legal move..");
                }
            }
            // means the move given was valid
            // place ship into the 2d array
            board = insertPiece(board,ships[i],posString,direction);
            legalMove = false;
            //legalMove = checkLegalMove(ships[i],posString,direction);
            //System.out.println(legalMove);
        }

        return board;
    }

    public static boolean checkLegalMove(int[][] board,String ship,String position,String direction)
    {
        boolean isLegalMove = false;
        char[] pos = position.toCharArray();
        char letter = Character.toUpperCase(pos[0]);
        char[] letterCol = {'A','B','C','D','E','F','G','H','I','J'};
        int col = new String(letterCol).indexOf(letter);
        int row = Character.getNumericValue(pos[1]);
        System.out.println("Ship: " + ship + " " + "Position: " + position + " " + "Direction: " + direction);
        //System.out.println("Letter: " + letter);
        // what if no input value
        String dir = direction.substring(0,1).toUpperCase() + direction.substring(1).toLowerCase();
        //System.out.println(dir);
        if(ship.equals("Carrier"))
        {
            if(dir.equals("Right"))
            {
                int val = Character.compare('F',letter);
                //System.out.println("RVALUE: " + val);
                // negative means invalid move
                // 0 or positive means valid move
                if(val >= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Carrier;i++)
                    {
                        if (board[row][col + i] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Left"))
            {
                int val = Character.compare('E',letter);
                //System.out.println("LVALUE: " + val);
                //positive means invalid move
                // 0 or negative means valid move
                if(val <= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Carrier;i++)
                    {
                        if(board[row][col-i] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Up"))
            {
                //System.out.println("ROW: " + row);
                if(row >= 4)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Carrier;i++)
                    {
                        if(board[row-i][col] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }

                }
            }
            else if(dir.equals("Down"))
            {
                if(row <= 5)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Carrier;i++)
                    {
                        if(board[row+i][col] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
        }
        else if (ship.equals("Battleship"))
        {
            if(dir.equals("Right"))
            {
                int val = Character.compare('G',letter);
                if(val >= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Battleship;i++)
                    {
                        if (board[row][col + i] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Left"))
            {
                int val = Character.compare('D',letter);
                System.out.println("VALUE: " + val);
                //positive means invalid move
                // 0 or negative means valid move
                if(val <= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Battleship;i++)
                    {
                        if(board[row][col-i] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Up"))
            {
                if(row >= 3)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Battleship;i++)
                    {
                        if(board[row-i][col] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Down"))
            {
                if(row <= 6)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Battleship;i++)
                    {
                        if(board[row+i][col] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
        }
        else if(ship.equals("Destroyer")  || ship.equals("Submarine"))
        {
            if(dir.equals("Right"))
            {
                int val = Character.compare('H',letter);
                if(val >= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Destroyer;i++)
                    {
                        if (board[row][col + i] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Left"))
            {
                int val = Character.compare('C',letter);
                System.out.println("VALUE: " + val);
                //positive means invalid move
                // 0 or negative means valid move
                if(val <= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Destroyer;i++)
                    {
                        if(board[row][col-i] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Up"))
            {
                if(row >= 2)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Destroyer;i++)
                    {
                        if(board[row-i][col] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Down"))
            {
                if(row <= 7)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Destroyer;i++)
                    {
                        if(board[row+i][col] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
        }
        else if(ship.equals("Patrol Boat"))
        {
            if(dir.equals("Right"))
            {
                int val = Character.compare('I',letter);
                if(val >= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.PatrolBoat;i++)
                    {
                        if (board[row][col + i] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Left"))
            {
                int val = Character.compare('B',letter);
                System.out.println("VALUE: " + val);
                //positive means invalid move
                // 0 or negative means valid move
                if(val <= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.PatrolBoat;i++)
                    {
                        if(board[row][col-i] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Up"))
            {
                if(row >= 1)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.PatrolBoat;i++)
                    {
                        if(board[row-i][col] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Down"))
            {
                if(row <= 8)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.PatrolBoat;i++)
                    {
                        if(board[row+i][col] == BattleShip.SHIP)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(isLegalMove);
        return isLegalMove;
    }


    public static int[][] insertPiece(int[][] board,String ship,String position,String direction)
    {
        char[] pos = position.toCharArray();
        char letter = Character.toUpperCase(pos[0]);
        int row = Character.getNumericValue(pos[1]);
        String dir = direction.substring(0,1).toUpperCase() + direction.substring(1).toLowerCase();
        int boat = 0;
        if(ship.equals("Carrier"))
        {
            boat = BattleShip.Carrier;
        }
        else if(ship.equals("Battleship"))
        {
            boat = BattleShip.Battleship;
        }
        else if(ship.equals("Destroyer") || ship.equals("Submarine"))
        {
            boat = BattleShip.Destroyer;
        }
        else if(ship.equals("Patrol Boat"))
        {
            boat = BattleShip.PatrolBoat;
        }
        if(letter == 'A')
        {
            board[row][0] = BattleShip.SHIP;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][0] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][0] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][i] = BattleShip.SHIP;
                }
            }
            // no left illegal
        }
        else if(letter == 'B')
        {
            board[row][1] = BattleShip.SHIP;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][1] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][1] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][1+i] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][1-i] = BattleShip.SHIP;
                }
            }
        }
        else if(letter == 'C')
        {
            board[row][2] = BattleShip.SHIP;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][2] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][2] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][2+i] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][2-i] = BattleShip.SHIP;
                }
            }
        }
        else if(letter == 'D')
        {
            board[row][3] = BattleShip.SHIP;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][3] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][3] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][3+i] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][3-i] = BattleShip.SHIP;
                }
            }
        }
        else if(letter == 'E')
        {
            board[row][4] = BattleShip.SHIP;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][4] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][4] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][4+i] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][4-i] = BattleShip.SHIP;
                }
            }
        }
        else if(letter == 'F')
        {
            board[row][5] = BattleShip.SHIP;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][5] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][5] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][5+i] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][5-i] = BattleShip.SHIP;
                }
            }
        }
        else if(letter == 'G')
        {
            board[row][6] = BattleShip.SHIP;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][6] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][6] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][6+i] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][6-i] = BattleShip.SHIP;
                }
            }
        }
        else if(letter == 'H')
        {
            board[row][7] = BattleShip.SHIP;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][7] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][7] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][7+i] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][7-i] = BattleShip.SHIP;
                }
            }
        }
        else if(letter == 'I')
        {
            board[row][8] = BattleShip.SHIP;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][8] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][8] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][8+i] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][8-i] = BattleShip.SHIP;
                }
            }
        }
        else if(letter == 'J')
        {
            board[row][9] = BattleShip.SHIP;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][9] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][9] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][9+i] = BattleShip.SHIP;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][9-i] = BattleShip.SHIP;
                }
            }
        }
        return board;
    }

    public static Map<String,int[][]> updateBoard(int turn,String location,int[][] shootingBoard,int[][] ownBoard)
    {
        Map<String, int[][]> map = new HashMap<>();
        char[] pos = location.toCharArray();
        char letter = Character.toUpperCase(pos[0]);
        int row = Character.getNumericValue(pos[1]);
        if(letter == 'A')
        {
            if(ownBoard[row][0] == BattleShip.SHIP)
            {
                System.out.println("HIT");
                shootingBoard[row][0] = BattleShip.HIT;
                ownBoard[row][0] = BattleShip.HIT;
            }
            else
            {
                System.out.println("MISS");
                shootingBoard[row][0] = BattleShip.MISS;
            }
        }
        else if(letter == 'B')
        {
            if(ownBoard[row][1] == BattleShip.SHIP)
            {
                System.out.println("HIT");
                shootingBoard[row][1] = BattleShip.HIT;
                ownBoard[row][1] = BattleShip.HIT;
            }
            else
            {
                System.out.println("MISS");
                shootingBoard[row][1] = BattleShip.MISS;
            }
        }
        else if(letter == 'C')
        {
            if(ownBoard[row][2] == BattleShip.SHIP)
            {
                System.out.println("HIT");
                shootingBoard[row][2] = BattleShip.HIT;
                ownBoard[row][2] = BattleShip.HIT;
            }
            else
            {
                System.out.println("MISS");
                shootingBoard[row][2] = BattleShip.MISS;
            }
        }
        else if(letter == 'D')
        {
            if(ownBoard[row][3] == BattleShip.SHIP)
            {
                System.out.println("HIT");
                shootingBoard[row][3] = BattleShip.HIT;
                ownBoard[row][3] = BattleShip.HIT;
            }
            else
            {
                System.out.println("MISS");
                shootingBoard[row][3] = BattleShip.MISS;
            }
        }
        else if(letter == 'E')
        {
            if(ownBoard[row][4] == BattleShip.SHIP)
            {
                System.out.println("HIT");
                shootingBoard[row][4] = BattleShip.HIT;
                ownBoard[row][4] = BattleShip.HIT;
            }
            else
            {
                System.out.println("MISS");
                shootingBoard[row][4] = BattleShip.MISS;
            }
        }
        else if(letter == 'F')
        {
            if(ownBoard[row][5] == BattleShip.SHIP)
            {
                System.out.println("HIT");
                shootingBoard[row][5] = BattleShip.HIT;
                ownBoard[row][5] = BattleShip.HIT;
            }
            else
            {
                System.out.println("MISS");
                shootingBoard[row][5] = BattleShip.MISS;
            }
        }
        else if(letter == 'G')
        {
            if(ownBoard[row][6] == BattleShip.SHIP)
            {
                System.out.println("HIT");
                shootingBoard[row][6] = BattleShip.HIT;
                ownBoard[row][6] = BattleShip.HIT;
            }
            else
            {
                System.out.println("MISS");
                shootingBoard[row][6] = BattleShip.MISS;
            }
        }
        else if(letter == 'H')
        {
            if(ownBoard[row][7] == BattleShip.SHIP)
            {
                System.out.println("HIT");
                shootingBoard[row][7] = BattleShip.HIT;
                ownBoard[row][7] = BattleShip.HIT;
            }
            else
            {
                System.out.println("MISS");
                shootingBoard[row][7] = BattleShip.MISS;
            }
        }
        else if(letter == 'I')
        {
            if(ownBoard[row][8] == BattleShip.SHIP)
            {
                System.out.println("HIT");
                shootingBoard[row][8] = BattleShip.HIT;
                ownBoard[row][8] = BattleShip.HIT;
            }
            else
            {
                System.out.println("MISS");
                shootingBoard[row][8] = BattleShip.MISS;
            }
        }
        else if(letter == 'J')
        {
            if(ownBoard[row][9] == BattleShip.SHIP)
            {
                System.out.println("HIT");
                shootingBoard[row][9] = BattleShip.HIT;
                ownBoard[row][9] = BattleShip.HIT;
            }
            else
            {
                System.out.println("MISS");
                shootingBoard[row][9] = BattleShip.MISS;
            }
        }
        if(turn % 2 == 0)
        {
            map.put("P1",shootingBoard);
            map.put("P2",ownBoard);
        }
        else
        {
            map.put("P2",shootingBoard);
            map.put("P1",ownBoard);
        }
        return map;
    }

    public static void gameLoop(BattleShip p1, BattleShip p2)
    {
        int turn = 0;
        boolean gameEnd = false;
        /////////////////////////// looop
        while(!gameEnd)
        {
            //even player 1 turn
            if(turn % 2 == 0)
            {
                String loc;
                System.out.println("Player 1: Which location will you shoot? ");
                loc = obj.nextLine();
                updateBoard(turn,loc,p1.shootingBoard,p2.board);
                printBoard(p1.shootingBoard);
                gameEnd = gameFinished(p2.board);
            }
            //odd player 2 turn
            else if(turn % 2 == 1)
            {
                String loc;
                System.out.println("Player 2: Which location will you shoot? ");
                loc = obj.nextLine();
                updateBoard(turn,loc,p2.shootingBoard,p1.board);
                printBoard(p2.shootingBoard);
                gameEnd = gameFinished(p1.board);
            }
            //looooooooooooooooooooooooop
            turn++;
        }
        obj.close();

    }

    public static boolean gameFinished(int[][] board)
    {
        boolean gameFinish = true;
        for(int row = 0;row < 10; row++)
        {
            for(int col = 0;col < 10;col++)
            {
                if(board[row][col] == BattleShip.SHIP)
                {
                    gameFinish = false;
                    break;
                }
            }
        }
        return gameFinish;
    }


    public static void main(String[] args)
    {
        //boolean wtf;
        BattleShip p1 = new BattleShip();
        p1.board = setUpBoard(p1.board);
        System.out.println("Player 1 Board");
        printBoard(p1.board);
        System.out.println("Player 1 Shooting Board");
        printBoard(p1.shootingBoard);

        BattleShip p2 = new BattleShip();
        p2.board = setUpBoard(p2.board);
        System.out.println("Player 2 Board");
        printBoard(p2.board);
        System.out.println("Player 2 Shooting Board");
        printBoard(p2.shootingBoard);

        gameLoop(p1,p2);

        /// run in a while loop checking for end game state
//        Scanner mainObj = new Scanner(System.in);
//        String loc;
//        int turn = 0;
//        System.out.println("Player 1: Which location will you shoot? ");
//        loc = mainObj.nextLine();
//
//        updateBoard(turn,loc,p1.shootingBoard,p2.board);
//        wtf = gameFinished(p2.board);
//        mainObj.close();
//        printBoard(p1.shootingBoard);
//        printBoard(p2.board);
//        System.out.println(wtf);
        //gameFinished();
    }
}
