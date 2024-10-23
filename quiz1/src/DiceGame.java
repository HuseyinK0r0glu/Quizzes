import java.util.ArrayList;
import java.util.List;

/**
 * This DiceGame class simulates a dice game where players threw dices and get score based on the dices
 * Dice game continues until there is one player playing and it would be the winner
 */

public class DiceGame {

    /**
     * The Main method of the DiceGame class
     * It reads input data, verify the players and dices for the game and simulates it
     * @param args Command Line arguments. First argument is input file that contains number and names of players
     *             and dices. Second argument is for output file path results will be  written on that.
     */

    public static void main(String[] args) {

    // read input file and get the output file
    String[] inputFile = FileInput.readFile(args[0],true,true);
    String outputFileName = args[1];

    // initialize variables
    int numbersOfPlayers = Integer.parseInt(inputFile[0]);
    String namesOfPlayers = inputFile[1];
    List<Player> players = new ArrayList<>();
    List<String> dices = new ArrayList<>();

    // initialize dice
    for(int j=2;j<inputFile.length;j++){
        dices.add(inputFile[j]);
    }
    // initialize players
    for(int i=0;i<numbersOfPlayers;i++){
        players.add(new Player(namesOfPlayers.split(",")[i],0,true));
    }

    // play the game until there is only one player left
    boolean game = true;
    int value = 0;
    int eliminatedPlayers = 0;
    FindWinner findWinner = new FindWinner(numbersOfPlayers,players);

    while(game){
        for(int i=0;i<numbersOfPlayers;i++){
            if (players.get(i).isPlaying()) {
                Write write = new Write(players.get(i),dices,value,eliminatedPlayers,outputFileName);
                eliminatedPlayers = write.write();
                value++;
                // check if there is only one player playing
                if (eliminatedPlayers == numbersOfPlayers-1) {
                    Player winner = findWinner.findWinner();
                    write.writeTheWinner(winner);
                    game = false;
                    break;
                }
            }
        }
    }

    }
}