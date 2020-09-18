import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BattleShipTest {

//    @Test
//    void printBoard() {
//
//    }
//
//    @Test
//    void setUpBoard() {
//    }

    @Test
    void checkLegalMoveCarrierRightTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','a','b','c','d','e','f'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for (char c : letter) {
            for (char value : num) {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Carrier", str, "Right"));
            }
        }
    }

    @Test
    void checkLegalMoveCarrierRightFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'G','H','I','J','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for (char c : letter) {
            for (char value : num) {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Carrier", str, "Right"));
            }
        }
    }

    @Test
    void checkLegalMoveCarrierLeftTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'E','F','G','H','I','J','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for (char c : letter) {
            for (char value : num) {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Carrier", str, "Left"));
            }
        }
    }

    @Test
    void checkLegalMoveCarrierLeftFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','a','b','c','d'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for (char c : letter) {
            for (char value : num) {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Carrier", str, "Left"));
            }
        }
    }

    @Test
    void checkLegalMoveCarrierUpTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'4','5','6','7','8','9'};
        for (char c : letter) {
            for (char value : num) {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Carrier", str, "Up"));
            }
        }
    }

    @Test
    void checkLegalMoveCarrierUpFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Carrier", str, "Up"));
            }
        }
    }

    @Test
    void checkLegalMoveCarrierDownTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Carrier", str, "Down"));
            }
        }
    }

    @Test
    void checkLegalMoveCarrierDownFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Carrier", str, "Down"));
            }
        }
    }

    @Test
    void checkLegalMoveBattleShipRightTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','a','b','c','d','e','f','g'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Battleship", str, "Right"));
            }
        }
    }

    @Test
    void checkLegalMoveBattleShipRightFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'H','I','J','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Battleship", str, "Right"));
            }
        }
    }

    @Test
    void checkLegalMoveBattleShipLeftTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'D','E','F','G','H','I','J','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c:letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Battleship", str, "Left"));
            }
        }
    }

    @Test
    void checkLegalMoveBattleShipLeftFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','a','b','c'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Battleship", str, "Left"));
            }
        }
    }

    @Test
    void checkLegalMoveBattleShipUpTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Battleship", str, "Up"));
            }
        }
    }

    @Test
    void checkLegalMoveBattleShipUpFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Battleship", str, "Up"));
            }
        }
    }

    @Test
    void checkLegalMoveBattleShipDownTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Battleship", str, "Down"));
            }
        }
    }

    @Test
    void checkLegalMoveBattleShipDownFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Battleship", str, "Down"));
            }
        }
    }

    @Test
    void checkLegalMoveDestroyerRightTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','a','b','c','d','e','f','g','h'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Destroyer", str, "Right"));
            }
        }
    }

    @Test
    void checkLegalMoveDestroyerRightFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'I','J','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Destroyer", str, "Right"));
            }
        }
    }

    @Test
    void checkLegalMoveDestroyerLeftTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'C','D','E','F','G','H','I','J','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Destroyer", str, "Left"));
            }
        }
    }

    @Test
    void checkLegalMoveDestroyerLeftFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','a','b'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Destroyer", str, "Left"));
            }
        }
    }

    @Test
    void checkLegalMoveDestroyerUpTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Destroyer", str, "Up"));
            }
        }
    }

    @Test
    void checkLegalMoveDestroyerUpFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Destroyer", str, "Up"));
            }
        }
    }

    @Test
    void checkLegalMoveDestroyerDownTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Destroyer", str, "Down"));
            }
        }
    }

    @Test
    void checkLegalMoveDestroyerDownFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Destroyer", str, "Down"));
            }
        }
    }

    @Test
    void checkLegalMoveSubRightTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','a','b','c','d','e','f','g','h'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Submarine", str, "Right"));
            }
        }
    }

    @Test
    void checkLegalMoveSubRightFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'I','J','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Submarine", str, "Right"));
            }
        }
    }

    @Test
    void checkLegalMoveSubLeftTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'C','D','E','F','G','H','I','J','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Submarine", str, "Left"));
            }
        }
    }

    @Test
    void checkLegalMoveSubLeftFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','a','b'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Submarine", str, "Left"));
            }
        }
    }

    @Test
    void checkLegalMoveSubUpTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Submarine", str, "Up"));
            }
        }
    }

    @Test
    void checkLegalMoveSubUpFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Submarine", str, "Up"));
            }
        }
    }

    @Test
    void checkLegalMoveSubDownTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Submarine", str, "Down"));
            }
        }
    }

    @Test
    void checkLegalMoveSubDownFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Submarine", str, "Down"));
            }
        }
    }

    @Test
    void checkLegalMovePBRightTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','a','b','c','d','e','f','g','h','i'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Patrol Boat", str, "Right"));
            }
        }
    }

    @Test
    void checkLegalMovePBRightFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'J','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Patrol Boat", str, "Right"));
            }
        }
    }

    @Test
    void checkLegalMovePBLeftTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'B','C','D','E','F','G','H','I','J','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Patrol Boat", str, "Left"));
            }
        }
    }

    @Test
    void checkLegalMovePBLeftFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','a'};
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Patrol Boat", str, "Left"));
            }
        }
    }

    @Test
    void checkLegalMovePBUpTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'1','2','3','4','5','6','7','8','9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Patrol Boat", str, "Up"));
            }
        }
    }

    @Test
    void checkLegalMovePBUpFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Patrol Boat", str, "Up"));
            }
        }
    }

    @Test
    void checkLegalMovePBDownTrue()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'0','1','2','3','4','5','6','7','8'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertTrue(BattleShip.checkLegalMove(board,"Patrol Boat", str, "Down"));
            }
        }
    }

    @Test
    void checkLegalMovePBDownFalse()
    {
        int[][] board = new int[10][10];
        char[] letter = {'A','B','C','D','E','F','G','H','I','J','a','b','c','d','e','f','g','h','i','j'};
        char[] num = {'9'};
        for(char c: letter)
        {
            for(char value: num)
            {
                String str = String.valueOf(c) +
                        value;
                Assertions.assertFalse(BattleShip.checkLegalMove(board,"Patrol Boat", str, "Down"));
            }
        }
    }
    
}
