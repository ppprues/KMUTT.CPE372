/**
 * Game.java
 *
 * This class represents a game in the Scrabble game.
 * Currently this class is incomplete. All it can do is
 * selecting the first player to play.
 *
 * Created by Pongnut Jittipanyakul (Prues) ID: 58070503419
 *
 * 15 October 2017
 */

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Game
{
    /* all player in one game */
    protected ArrayList<Player> players = new ArrayList<Player>();

    /**
     * Check how many tiles that have this score of all players.
     * @param players   all players in one game
     * @param target    target's score to find
     * @return number of tiles that score same as target
     */
    private int isEqualScore(ArrayList<Player> players, int target)
    {
        int sameCount = 0;
        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).getHighest().getTileValue() == target)
            {
                sameCount++;
            }
        }
        return sameCount;
    }

    /**
     * Asks for a string and returns it as the value of the function
     * @param   prompt    String to print, telling which coordinate
     * @return The string the user entered (maximum 100 chars long)
     */
    public static String getString(String prompt)
    {
        String inputString;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.println(prompt);
        try
        {
            readBytes = System.in.read(buffer, 0, 200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        inputString = new String(buffer);
        int pos = inputString.indexOf("\n");
        if (pos > 0)
        {
            inputString = inputString.substring(0, pos);
        }
        return inputString;
    }

    /**
     * Asks for an integer and returns it as the value of the function
     * @param   prompt    String to print, telling which coordinate
     * @return value entered. If not an integer, prints an error message
     * and returns -999
     */
    public static int getInteger(String prompt)
    {
        int value = -999;
        String inputString;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.println(prompt);
        try
        {
            readBytes = System.in.read(buffer, 0, 200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        inputString = new String(buffer);
        try
        {
            int pos = inputString.indexOf("\n");
            if (pos > 0)
            {
                inputString = inputString.substring(0, pos);
            }
            value = Integer.parseInt(inputString);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Bad number entered");
        }
        return value;
    }

    /**
     * Calculate the number of player to play first.
     * Get integer between 2 and 4 which is the number of players.
     * @param  playerCount  the number of players
     * @return the number of player who got the highest tile score
     */
    public int newGame(int playerCount)
    {
        int highestPlayer = 0;

        if (playerCount < 2)
        {
            System.out.println("Error - Too few players requested");
            return highestPlayer;
        }

        else if (playerCount > 4)
        {
            System.out.println("Error - Too many players requested");
            return highestPlayer;
        }

        TileManager.initialize();
        TileCollection initTiles = new TileCollection(0, playerCount); /* for finding the highest tile of all players */

        /* Create all new players and draw 1 tile */
        for (int i = 0; i < playerCount; i++)
        {
            String playerName = getString("==> Enter Player " + (i + 1) + "'s name ");
            Player player = new Player(playerName);
            if (player.selectTiles(1))
            {
                System.out.println(player.getName() + " selected " + player.getHighest());
                players.add(player);
                initTiles.addTile(player.getHighest());
            }
            else
            {
                System.out.println("Error - " + player.getName() + " can't selected tile");
                highestPlayer = 0;
                players.clear();
                break;
            }
        }

        /* Find the highest score tile of all players */
        int highestScore = initTiles.getHighest().getTileValue();
        System.out.println("\nHighest tile score of all players = " + highestScore + "\n");

        /* If some players get the highest tile more than 1,
           that player returns a tile and draw the new one until only one player */
        while (isEqualScore(players, highestScore) > 1)
        {
            initTiles.clear(); /* clear all tiles of all players */
            System.out.println("\nMore than 1 player got highest tile score");

            /* Find all players that got the highest tile */
            for (int i = 0; i < players.size(); i++)
            {
                Player currentPlayer = players.get(i);
                if (currentPlayer.getHighest().getTileValue() == highestScore)
                {
                    TileManager.addTile(currentPlayer.getHighest()); /* add the tile to the pool */
                    currentPlayer.clearTiles(); /* clear tile from player */
                    currentPlayer.selectTiles(1); /* select new tile from the pool */
                    initTiles.addTile(currentPlayer.getHighest()); /* add the tile to all tiles of all players */
                    System.out.println("Redraw tile - " + currentPlayer.getName() + " selected " + currentPlayer.getHighest());
                }
            }
            highestScore = initTiles.getHighest().getTileValue();
            System.out.println("New highest tile score of all player = " + highestScore + "\n");
        }

        /* Find the first player to play and return a tile to the pool */
        for (int i = 0; i < playerCount; i++)
        {
            if (players.get(i).getHighest().getTileValue() == highestScore)
            {
                TileManager.addTile(players.get(i).getHighest());
                players.get(i).clearTiles();
                highestPlayer = i + 1;
            }
            else
            {
                TileManager.addTile(players.get(i).getHighest());
                players.get(i).clearTiles();
            }
        }

        Board.initialize();
        Board.getBoardImage();

        /* Open board image */
        String pathImage = "ScrabbleBoard.jpg";
        if (Desktop.isDesktopSupported())
        {
            try
            {
                Desktop.getDesktop().browse(new URI(pathImage));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (URISyntaxException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            Runtime runtime = Runtime.getRuntime();
            try
            {
                runtime.exec(pathImage);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return highestPlayer;
    }

    /**
     * Main function for testing newGame()
     */
    public static void main(String args[])
    {
        Game game = new Game();
        int totalPlayer = getInteger("==> Enter the number of players");
        System.out.println("First player to play is: " + game.players.get(game.newGame(totalPlayer) - 1).getName());
    }
}