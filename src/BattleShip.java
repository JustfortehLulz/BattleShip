import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class BattleShip
{
    private static final int EMPTY = 0;
    private static final int SHIP = 1;
    private static final int HIT = -1;
    private static final int MISS = -2;

    private static final int Carrier = 6;
    private static final int Battleship = 5;
    private static final int Destroyer = 4;
    private static final int Frigate = 3;
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
                else if(board[row][col] == BattleShip.Carrier)
                {
                    System.out.print("| " + "C" + " ");
                }
                else if(board[row][col] == BattleShip.Battleship)
                {
                    System.out.print("| " + "B" + " ");
                }
                else if(board[row][col] == BattleShip.Destroyer)
                {
                    System.out.print("| " + "D" + " ");
                }
                else if(board[row][col] == BattleShip.Frigate)
                {
                    System.out.print("| " + "F" + " ");
                }
                else if(board[row][col] == BattleShip.PatrolBoat)
                {
                    System.out.print("| " + "P" + " ");
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
        String[] ships = {"Carrier","Battleship","Destroyer","Frigate","Patrol Boat"};
        String[] lengths = {"(6 unit lengths)","(5 unit lengths)","(4 unit lengths)","(3 unit lengths)","(2 unit lengths)"};
        //int i = 0;
        for(int i = 0;i < ships.length;i++)
        {

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
        // what if no input value
        String dir = direction.substring(0,1).toUpperCase() + direction.substring(1).toLowerCase();
        if(ship.equals("Carrier"))
        {
            if(dir.equals("Right"))
            {
                int val = Character.compare('E',letter);
                //System.out.println("RVALUE: " + val);
                // negative means invalid move
                // 0 or positive means valid move
                if(val >= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Carrier;i++)
                    {
                        if (board[row][col + i] == BattleShip.Carrier || board[row][col + i] == BattleShip.Battleship || board[row][col + i] == BattleShip.Destroyer
                                || board[row][col+i] == BattleShip.Frigate || board[row][col + i] == BattleShip.PatrolBoat)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Left"))
            {
                int val = Character.compare('F',letter);
                //System.out.println("LVALUE: " + val);
                //positive means invalid move
                // 0 or negative means valid move
                if(val <= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Carrier;i++)
                    {
                        if(board[row][col-i] == BattleShip.Carrier || board[row][col-i] == BattleShip.Battleship || board[row][col-i] == BattleShip.Destroyer
                                || board[row][col-i] == BattleShip.Frigate || board[row][col-i] == BattleShip.PatrolBoat)
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
                if(row >= 5)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Carrier;i++)
                    {
                        if(board[row-i][col] == BattleShip.Carrier || board[row-i][col] == BattleShip.Battleship || board[row-i][col] == BattleShip.Destroyer
                                || board[row-i][col] == BattleShip.Frigate ||board[row-i][col] == BattleShip.PatrolBoat)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }

                }
            }
            else if(dir.equals("Down"))
            {
                if(row <= 4)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Carrier;i++)
                    {
                        if(board[row+i][col] == BattleShip.Carrier || board[row+i][col] == BattleShip.Battleship || board[row+i][col] == BattleShip.Destroyer
                                || board[row+i][col] == BattleShip.Frigate ||board[row+i][col] == BattleShip.PatrolBoat)
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
                int val = Character.compare('F',letter);
                if(val >= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Battleship;i++)
                    {
                        if (board[row][col + i] == BattleShip.Carrier || board[row][col + i] == BattleShip.Battleship || board[row][col + i] == BattleShip.Destroyer
                                || board[row][col + i] == BattleShip.Frigate ||board[row][col + i] == BattleShip.PatrolBoat)
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
                //System.out.println("VALUE: " + val);
                //positive means invalid move
                // 0 or negative means valid move
                if(val <= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Battleship;i++)
                    {
                        if(board[row][col-i] == BattleShip.Carrier || board[row][col-i] == BattleShip.Battleship || board[row][col-i] == BattleShip.Destroyer
                                || board[row][col-i] == BattleShip.Frigate || board[row][col-i] == BattleShip.PatrolBoat)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
            else if(dir.equals("Up"))
            {
                if(row >= 4)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Battleship;i++)
                    {
                        if(board[row-i][col] == BattleShip.Carrier || board[row-i][col] == BattleShip.Battleship || board[row-i][col] == BattleShip.Destroyer
                                || board[row-i][col] == BattleShip.Frigate || board[row-i][col] == BattleShip.PatrolBoat)
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
                    for(int i = 0;i<BattleShip.Battleship;i++)
                    {
                        if(board[row+i][col] == BattleShip.Carrier || board[row+i][col] == BattleShip.Battleship || board[row+i][col] == BattleShip.Destroyer
                                || board[row+i][col] == BattleShip.Frigate || board[row+i][col] == BattleShip.PatrolBoat)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
        }
        else if(ship.equals("Destroyer"))
        {
            if(dir.equals("Right"))
            {
                int val = Character.compare('G',letter);
                if(val >= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Destroyer;i++)
                    {
                        if (board[row][col + i] == BattleShip.Carrier || board[row][col + i] == BattleShip.Battleship || board[row][col + i] == BattleShip.Destroyer
                                || board[row][col + i] == BattleShip.Frigate || board[row][col + i] == BattleShip.PatrolBoat)
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
                //System.out.println("VALUE: " + val);
                //positive means invalid move
                // 0 or negative means valid move
                if(val <= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Destroyer;i++)
                    {
                        if(board[row][col-i] == BattleShip.Carrier || board[row][col-i] == BattleShip.Battleship || board[row][col-i] == BattleShip.Destroyer
                                || board[row][col-i] == BattleShip.Frigate || board[row][col-i] == BattleShip.PatrolBoat)
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
                    for(int i = 0;i<BattleShip.Destroyer;i++)
                    {
                        if(board[row-i][col] == BattleShip.Carrier || board[row-i][col] == BattleShip.Battleship || board[row-i][col] == BattleShip.Destroyer
                                || board[row-i][col] == BattleShip.Frigate || board[row-i][col] == BattleShip.PatrolBoat)
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
                    for(int i = 0;i<BattleShip.Destroyer;i++)
                    {
                        if(board[row+i][col] == BattleShip.Carrier || board[row+i][col] == BattleShip.Battleship || board[row+i][col] == BattleShip.Destroyer
                                || board[row+i][col] == BattleShip.Frigate || board[row+i][col] == BattleShip.PatrolBoat)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
        }
        else if(ship.equals("Frigate"))
        {
            if(dir.equals("Right"))
            {
                int val = Character.compare('H',letter);
                if(val >= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Frigate;i++)
                    {
                        if (board[row][col + i] == BattleShip.Carrier || board[row][col + i] == BattleShip.Battleship || board[row][col + i] == BattleShip.Destroyer
                                || board[row][col + i] == BattleShip.Frigate || board[row][col + i] == BattleShip.PatrolBoat)
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
                if(val <= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.Frigate;i++)
                    {
                        if(board[row][col-i] == BattleShip.Carrier || board[row][col-i] == BattleShip.Battleship || board[row][col-i] == BattleShip.Destroyer
                                || board[row][col-i] == BattleShip.Frigate || board[row][col-i] == BattleShip.PatrolBoat)
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
                    for(int i = 0;i<BattleShip.Frigate;i++)
                    {
                        if(board[row-i][col] == BattleShip.Carrier || board[row-i][col] == BattleShip.Battleship || board[row-i][col] == BattleShip.Destroyer
                                || board[row-i][col] == BattleShip.Frigate || board[row-i][col] == BattleShip.PatrolBoat)
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
                    for(int i = 0;i<BattleShip.Frigate;i++)
                    {
                        if(board[row+i][col] == BattleShip.Carrier || board[row+i][col] == BattleShip.Battleship || board[row+i][col] == BattleShip.Destroyer
                                || board[row+i][col] == BattleShip.Frigate || board[row+i][col] == BattleShip.PatrolBoat)
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
                        if (board[row][col + i] == BattleShip.Carrier || board[row][col + i] == BattleShip.Battleship || board[row][col + i] == BattleShip.Destroyer
                                || board[row][col + i] == BattleShip.Frigate || board[row][col + i] == BattleShip.PatrolBoat)
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
                //System.out.println("VALUE: " + val);
                //positive means invalid move
                // 0 or negative means valid move
                if(val <= 0)
                {
                    isLegalMove = true;
                    for(int i = 0;i<BattleShip.PatrolBoat;i++)
                    {
                        if(board[row][col-i] == BattleShip.Carrier || board[row][col-i] == BattleShip.Battleship || board[row][col-i] == BattleShip.Destroyer
                                || board[row][col-i] == BattleShip.Frigate || board[row][col-i] == BattleShip.PatrolBoat)
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
                        if(board[row-i][col] == BattleShip.Carrier || board[row-i][col] == BattleShip.Battleship || board[row-i][col] == BattleShip.Destroyer
                                || board[row-i][col] == BattleShip.Frigate || board[row-i][col] == BattleShip.PatrolBoat)
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
                        if(board[row+i][col] == BattleShip.Carrier || board[row+i][col] == BattleShip.Battleship || board[row+i][col] == BattleShip.Destroyer
                                || board[row+i][col] == BattleShip.Frigate || board[row+i][col] == BattleShip.PatrolBoat)
                        {
                            isLegalMove = false;
                            break;
                        }
                    }
                }
            }
        }
        //System.out.println(isLegalMove);
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
        else if(ship.equals("Destroyer"))
        {
            boat = BattleShip.Destroyer;
        }
        else if(ship.equals("Frigate"))
        {
            boat = BattleShip.Frigate;
        }
        else if(ship.equals("Patrol Boat"))
        {
            boat = BattleShip.PatrolBoat;
        }
        if(letter == 'A')
        {
            board[row][0] = boat;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][0] = boat;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][0] = boat;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][i] = boat;
                }
            }
            // no left illegal
        }
        else if(letter == 'B')
        {
            board[row][1] = boat;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][1] = boat;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][1] = boat;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][1+i] = boat;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][1-i] = boat;
                }
            }
        }
        else if(letter == 'C')
        {
            board[row][2] = boat;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][2] = boat;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][2] = boat;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][2+i] = boat;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][2-i] = boat;
                }
            }
        }
        else if(letter == 'D')
        {
            board[row][3] = boat;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][3] = boat;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][3] = boat;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][3+i] = boat;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][3-i] = boat;
                }
            }
        }
        else if(letter == 'E')
        {
            board[row][4] = boat;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][4] = boat;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][4] = boat;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][4+i] = boat;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][4-i] = boat;
                }
            }
        }
        else if(letter == 'F')
        {
            board[row][5] = boat;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][5] = boat;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][5] = boat;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][5+i] = boat;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][5-i] = boat;
                }
            }
        }
        else if(letter == 'G')
        {
            board[row][6] = boat;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][6] = boat;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][6] = boat;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][6+i] = boat;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][6-i] = boat;
                }
            }
        }
        else if(letter == 'H')
        {
            board[row][7] = boat;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][7] = boat;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][7] = boat;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][7+i] = boat;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][7-i] = boat;
                }
            }
        }
        else if(letter == 'I')
        {
            board[row][8] = boat;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][8] = boat;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][8] = boat;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][8+i] = boat;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][8-i] = boat;
                }
            }
        }
        else if(letter == 'J')
        {
            board[row][9] = boat;
            if(dir.equals("Up"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row-i][9] = boat;
                }
            }
            else if(dir.equals("Down"))
            {
                for(int i = 1;i< boat;i++)
                {
                    board[row+i][9] = boat;
                }
            }
            else if(dir.equals("Right"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][9+i] = boat;
                }
            }
            else if(dir.equals("Left"))
            {
                for (int i = 1; i < boat; i++)
                {
                    board[row][9-i] = boat;
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
        // check if the ship is tehre before
        boolean carrierAlive;
        boolean battleShipAlive;
        boolean destroyerAlive;
        boolean frigateAlive;
        boolean pBAlive;
        carrierAlive = shipCheck(ownBoard,BattleShip.Carrier);
        battleShipAlive = shipCheck(ownBoard,BattleShip.Battleship);
        destroyerAlive = shipCheck(ownBoard,BattleShip.Destroyer);
        frigateAlive = shipCheck(ownBoard,BattleShip.Frigate);
        pBAlive = shipCheck(ownBoard,BattleShip.PatrolBoat);
        if(letter == 'A')
        {
            if(ownBoard[row][0] == BattleShip.Carrier || ownBoard[row][0] == BattleShip.Battleship || ownBoard[row][0] == BattleShip.Destroyer || ownBoard[row][0] == BattleShip.PatrolBoat)
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
            if(ownBoard[row][1] == BattleShip.Carrier || ownBoard[row][1] == BattleShip.Battleship || ownBoard[row][1] == BattleShip.Destroyer || ownBoard[row][1] == BattleShip.PatrolBoat)
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
            if(ownBoard[row][2] == BattleShip.Carrier || ownBoard[row][2] == BattleShip.Battleship || ownBoard[row][2] == BattleShip.Destroyer || ownBoard[row][2] == BattleShip.PatrolBoat)
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
            if(ownBoard[row][3] == BattleShip.Carrier || ownBoard[row][3] == BattleShip.Battleship || ownBoard[row][3] == BattleShip.Destroyer || ownBoard[row][3] == BattleShip.PatrolBoat)
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
            if(ownBoard[row][4] == BattleShip.Carrier || ownBoard[row][4] == BattleShip.Battleship || ownBoard[row][4] == BattleShip.Destroyer || ownBoard[row][4] == BattleShip.PatrolBoat)
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
            if(ownBoard[row][5] == BattleShip.Carrier || ownBoard[row][5] == BattleShip.Battleship || ownBoard[row][5] == BattleShip.Destroyer || ownBoard[row][5] == BattleShip.PatrolBoat)
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
            if(ownBoard[row][6] == BattleShip.Carrier || ownBoard[row][6] == BattleShip.Battleship || ownBoard[row][6] == BattleShip.Destroyer || ownBoard[row][6] == BattleShip.PatrolBoat)
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
            if(ownBoard[row][7] == BattleShip.Carrier || ownBoard[row][7] == BattleShip.Battleship || ownBoard[row][7] == BattleShip.Destroyer || ownBoard[row][7] == BattleShip.PatrolBoat)
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
            if(ownBoard[row][8] == BattleShip.Carrier || ownBoard[row][8] == BattleShip.Battleship || ownBoard[row][8] == BattleShip.Destroyer || ownBoard[row][8] == BattleShip.PatrolBoat)
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
            if(ownBoard[row][9] == BattleShip.Carrier || ownBoard[row][9] == BattleShip.Battleship || ownBoard[row][9] == BattleShip.Destroyer || ownBoard[row][9] == BattleShip.PatrolBoat)
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
        // check ships after shot
        if(carrierAlive)
        {
            carrierAlive = shipCheck(ownBoard,BattleShip.Carrier);
            if(!carrierAlive)
            {
                System.out.println("Enemy Carrier Destroyed");
            }
        }
        if(battleShipAlive)
        {
            battleShipAlive = shipCheck(ownBoard,BattleShip.Battleship);
            if(!battleShipAlive)
            {
                System.out.println("Enemy Battleship Destroyed");
            }
        }
        if(destroyerAlive)
        {
            destroyerAlive = shipCheck(ownBoard,BattleShip.Destroyer);
            if(!destroyerAlive)
            {
                System.out.println("Enemy Destroyer Destroyed");
            }
        }
        if(frigateAlive)
        {
            frigateAlive = shipCheck(ownBoard,BattleShip.Frigate);
            if(!frigateAlive)
            {
                System.out.println("Enemy Frigate Destroyed");
            }
        }
        if(pBAlive)
        {
            pBAlive = shipCheck(ownBoard,BattleShip.PatrolBoat);
            if(!pBAlive)
            {
                System.out.println("Enemy Patrol Boat Destroyed");
            }
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
            turn++;
        }
        if(turn % 2 == 0)
        {
            System.out.println("Player 1 Wins!");
        }
        else if(turn % 2 == 1)
        {
            System.out.println("Player 2 Wins!");
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
                if(board[row][col] == BattleShip.Carrier || board[row][col] == BattleShip.Battleship || board[row][col] == BattleShip.Destroyer || board[row][col] == BattleShip.PatrolBoat)
                {
                    gameFinish = false;
                    break;
                }
            }
        }
        return gameFinish;
    }

    public static int[][] randomBoard(int[][] board)
    {
        int[] num = {'0','1','2','3','4','5','6','7','8','9'};
        char[] letter = {'A','B','C','D','E','F','G','H','I','J'};
        String[] direction = {"Up","Down","Right","Left"};
        String[] ships = {"Carrier","Battleship","Destroyer","Frigate","Patrol Boat"};
        Random generator = new Random();
        boolean legalMove = false;
        String loc = null;
        String dir = null;
        for (String ship : ships) {
            while(!legalMove)
            {
                StringBuilder sb = new StringBuilder();
                int row = generator.nextInt(num.length);
                char col = letter[generator.nextInt(letter.length)];
                sb.append(col);
                sb.append(row);
                loc = sb.toString();
                dir = direction[generator.nextInt(direction.length)];
                legalMove = checkLegalMove(board, ship, loc, dir);
            }
            board = insertPiece(board,ship,loc,dir);
            legalMove = false;
        }
        return board;
    }

    public static boolean shipCheck(int[][] board,int ship)
    {
        boolean isShipAlive = false;
        for(int row = 0; row < 10;row++)
        {
            for(int col = 0; col < 10;col++)
            {
                if(board[row][col] == ship)
                {
                    isShipAlive = true;
                    break;
                }
            }
        }
        return isShipAlive;
    }


    public static void main(String[] args)
    {
        // main loop with player input
//        BattleShip p1 = new BattleShip();
//        p1.board = setUpBoard(p1.board);
//        System.out.println("Player 1 Board");
//        printBoard(p1.board);
//        System.out.println("Player 1 Shooting Board");
//        printBoard(p1.shootingBoard);
//
//        BattleShip p2 = new BattleShip();
//        p2.board = setUpBoard(p2.board);
//        System.out.println("Player 2 Board");
//        printBoard(p2.board);
//        System.out.println("Player 2 Shooting Board");
//        printBoard(p2.shootingBoard);
//
//        gameLoop(p1,p2);
        //////////////////////////////

        // main loop random board
        BattleShip p1 = new BattleShip();
        p1.board = randomBoard(p1.board);
        printBoard(p1.board);
        printBoard(p1.shootingBoard);

        BattleShip p2 = new BattleShip();
        p2.board = randomBoard(p2.board);
        printBoard(p2.board);
        printBoard(p2.shootingBoard);

        gameLoop(p1,p2);
    }
}
