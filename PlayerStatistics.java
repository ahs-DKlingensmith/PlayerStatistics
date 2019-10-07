/*
* Stats class
 */

public class PlayerStatistics {

    //Establish attributes
    private String name;
    private int baskets;
    private int foulShots;
    private int totalPoints;

    //The PlayerStatistics constructor accepts parameters for the name, baskets, 
    //and foul shots, and calculates total points
    public PlayerStatistics(String n, int b, int fs, int tp) {

        name = n;
        baskets = b;
        foulShots = fs;
        totalPoints = tp;

    }

    //The set methods accept the parameter and change the corresponding attribute
    public void setBaskets(int b) {

        baskets = b;

    }

    public void setFoulShots(int fs) {

        foulShots = fs;

    }

    //The get methods return the player's corresponding statistic
    public String getName() {

        return name;

    }

    public int getBaskets() {

        return baskets;

    }

    public int getFoulShots() {

        return foulShots;

    }

    public int getTotalPoints() {

        return totalPoints;

    }

    //The updateTotalPoints method fixes the total points according 
    //to any recent baskets or foul shots changes
    public void updateTotalPoints() {

        totalPoints = (baskets * 2) + foulShots;

    }

}
