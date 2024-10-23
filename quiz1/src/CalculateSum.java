/**
 * CalculateSum class calculates the sum of two given dices
 */

public class CalculateSum {

    private String dices;

    /**
     * Construction for create an object of CalculateSum class
     * @param dices Dices represent two dices in the format "x-y" where x and y representing the values of dices
     */
    public CalculateSum(String dices) {
        this.dices = dices;
    }

    /**
     * Calculates the sum of two dices
     *
     * @return Sum of the two dices
     */
    public int calculateSum(){
        return Integer.parseInt(dices.split("-")[0])  + Integer.parseInt(dices.split("-")[1]);
    }

    // getter and setter methods
    public String getDices() {
        return dices;
    }

    public void setDices(String dices) {
        this.dices = dices;
    }



}
