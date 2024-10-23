import java.util.List;

/**
 * Write class is responsible for writing the results of the game to the output file
 */
public class Write {
    private Player player;
    private List<String> dices;
    private int value;
    private int eliminatedPlayers;
    private String outputFileName;

    /**
     * Construction for creating a new object with given attributes
     *
     * @param player The player that is playing in the current round
     * @param dices List of dices
     * @param value The index of the current dice
     * @param eliminatedPlayers Number of players that are eliminated from the game
     * @param outputFileName The output file name to write the results of the game
     */
    public Write(Player player, List<String> dices, int value,int eliminatedPlayers,String outputFileName) {
        this.player = player;
        this.dices = dices;
        this.value = value;
        this.eliminatedPlayers = eliminatedPlayers;
        this.outputFileName = outputFileName;
    }
    CalculateSum calculateSum ;

    /**
     * This method writes the results of the game to the output file
     *
     * @return Number of eliminated players from the game
     */
    public int write(){
            if(dices.get(value).split("-")[0].equals("1") && dices.get(value).split("-")[1].equals("1")){
                // game over
                FileOutput.writeToFile(outputFileName,player.getName() + " threw " + dices.get(value) + ". Game over "
                        + player.getName() + "!" ,true,true);
                player.setPlaying(false);
                eliminatedPlayers++;
            }else if(dices.get(value).split("-")[0].equals("1") || dices.get(value).split("-")[1].equals("1")){
                //player neither gains nor loses any points
                FileOutput.writeToFile(outputFileName,player.getName() + " threw " + dices.get(value) + " and "
                        + player.getName() + "’s score is " + player.getScore() + ".",true,true);
            }else if(dices.get(value).split("-")[0].equals("0") && dices.get(value).split("-")[1].equals("0")){
                // pass
                FileOutput.writeToFile(outputFileName,player.getName() + " skipped the turn and " + player.getName()
                        + "’s score is " + player.getScore() + ".",true,true);
            }else{
                calculateSum = new CalculateSum(dices.get(value));
                int sum = calculateSum.calculateSum();
                player.setScore(player.getScore() + sum);
                FileOutput.writeToFile(outputFileName,player.getName() + " threw " + dices.get(value) + " and "
                        + player.getName() + "’s score is " + player.getScore() + ".",true,true);
            }
            return eliminatedPlayers;
        }

    /**
     * This method write the winner to the output file after there is only one player playing
     *
      * @param winner Player object representing the winner of the game
     */
    public void writeTheWinner(Player winner){
        FileOutput.writeToFile(outputFileName,winner.getName() + " is the winner of the game with the score of "
                + winner.getScore() + ". Congratulations " + winner.getName() + "!",true,false);
    }

    // getters and setters
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<String> getDices() {
        return dices;
    }

    public void setDices(List<String> dices) {
        this.dices = dices;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getEliminatedPlayers() {
        return eliminatedPlayers;
    }

    public void setEliminatedPlayers(int eliminatedPlayers) {
        this.eliminatedPlayers = eliminatedPlayers;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }
}
