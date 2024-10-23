/**
 * Player class represents the player in the game
 */
public class Player {
    private String name;
    private int score;
    private boolean playing;

    /**
     * Construction for creating a new object with some attributes of player
     *
     * @param name The name of the player
     * @param score The score of the player
     * @param playing a boolean value that indicates whether the player is currently playing
     */
    public Player(String name, int score,boolean playing) {
        this.name = name;
        this.score = score;
        this.playing = playing;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public boolean isPlaying() {
        return playing;
    }
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
}
