import java.util.List;

/**
 * FindWinner class finds the winner of the game
 */
public class FindWinner {
    private int numbersOfPlayers;
    private List<Player> players;

    /**
     * Construction for creating a new of object of FindWinner class with numberOfPlayers and players
     *
     * @param numbersOfPlayers The total number of players that play is this game
     * @param players A list players that are playing in this game
     */
    public FindWinner(int numbersOfPlayers, List<Player> players) {
        this.numbersOfPlayers = numbersOfPlayers;
        this.players = players;
    }

    /**
     * This method is for finding the winner of the game
     *
     * @return The winner is there is a winner or null
     */
    public Player findWinner(){
        // checks for every player's playing status
        for(int i=0;i<numbersOfPlayers;i++){
            if(players.get(i).isPlaying()){
                return players.get(i);
            }
        }
        return null;
    }


    // getters and setters
    public int getNumbersOfPlayers() {
        return numbersOfPlayers;
    }

    public void setNumbersOfPlayers(int numbersOfPlayers) {
        this.numbersOfPlayers = numbersOfPlayers;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
