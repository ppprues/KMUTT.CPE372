public class Game
{
    public int newGame(int playerCount)
    {
        return 0;
    }

    public void showBoard()
    {

    }

    public void takeTurn(int playerNumber)
    {

    }

    public void showPlayerTiles(int playerNumber)
    {

    }

    public boolean challenge(Player challenger, Player challenged, Word word)
    {
        return true;
    }

    public Player getWinner()
    {
        Player winner = new Player("Winner");
        return winner;
    }

    public static void main(String args[])
    {
        Board board = new Board();
        board.getBoardImage();
    }
}
