/*
* SortRoster class
 */

import java.io.*;
import java.util.*;

public class SortRoster {

    //The sortName method accepts an array of playerStatistics and 
    //creates a new file that contains the data sorted alphabetically
    public void sortName(ArrayList<PlayerStatistics> playerStats) throws FileNotFoundException, IOException {

        File updatedList = new File("Z:\\Programming IV\\Java\\Don't Tell Mr. Mulroy\\points.txt");
      
        PrintWriter writeFile = new PrintWriter(updatedList);
        int firstAlphabeticalName = 0;

        while (playerStats.size() > 0) {

            for (int x = 0; x < playerStats.size(); x++) {

                for (int y = 0; y < playerStats.size(); y++) {

                    int compareName = playerStats.get(y).getName().compareTo(playerStats.get(firstAlphabeticalName).getName());
                    
                    if (compareName < 0 && firstAlphabeticalName != y) {

                        firstAlphabeticalName = y;
                        y = 0;

                    }

                }

            }

            writeFile.println(playerStats.get(firstAlphabeticalName).getName());
            writeFile.println(playerStats.get(firstAlphabeticalName).getBaskets());
            writeFile.println(playerStats.get(firstAlphabeticalName).getFoulShots());
            writeFile.println(playerStats.get(firstAlphabeticalName).getTotalPoints());

            playerStats.remove(firstAlphabeticalName);
            playerStats.trimToSize();

        }

        writeFile.close();

    }

    //The sortBaskets method accepts an array of playerStatistics and 
    //creates a new file that contains the data sorted from most baskets 
    //to least
    public void sortBaskets(ArrayList<PlayerStatistics> playerStats) throws FileNotFoundException, IOException {

        File updatedList = new File("Z:\\Programming IV\\Java\\Don't Tell Mr. Mulroy\\points.txt");
       
        PrintWriter writeFile = new PrintWriter(updatedList);
        int mostBasketsPlayer = 0;

        while (playerStats.size() > 0) {

            for (int x = 0; x < playerStats.size(); x++) {

                for (int y = 0; y < playerStats.size(); y++) {

                    if (playerStats.get(y).getBaskets() > playerStats.get(mostBasketsPlayer).getBaskets() && mostBasketsPlayer != y) {

                        mostBasketsPlayer = y;
                        y = 0;

                    }

                }

            }

            writeFile.println(playerStats.get(mostBasketsPlayer).getName());
            writeFile.println(playerStats.get(mostBasketsPlayer).getBaskets());
            writeFile.println(playerStats.get(mostBasketsPlayer).getFoulShots());
            writeFile.println(playerStats.get(mostBasketsPlayer).getTotalPoints());

            playerStats.remove(mostBasketsPlayer);
            playerStats.trimToSize();

        }

        writeFile.close();

    }

    //The sortFoulShots method accepts an array of playerStatistics and 
    //creates a new file that contains the data sorted from most foul shots 
    //to least
    public void sortFoulShots(ArrayList<PlayerStatistics> playerStats) throws FileNotFoundException, IOException {

        File updatedList = new File("Z:\\Programming IV\\Java\\Don't Tell Mr. Mulroy\\points.txt");
       
        PrintWriter writeFile = new PrintWriter(updatedList);
        int mostFoulShotsPlayer = 0;

        while (playerStats.size() > 0) {

            for (int x = 0; x < playerStats.size(); x++) {

                for (int y = 0; y < playerStats.size(); y++) {

                    if (playerStats.get(y).getBaskets() > playerStats.get(mostFoulShotsPlayer).getBaskets() && mostFoulShotsPlayer != y) {

                        mostFoulShotsPlayer = y;
                        y = 0;

                    }

                }

            }

            writeFile.println(playerStats.get(mostFoulShotsPlayer).getName());
            writeFile.println(playerStats.get(mostFoulShotsPlayer).getBaskets());
            writeFile.println(playerStats.get(mostFoulShotsPlayer).getFoulShots());
            writeFile.println(playerStats.get(mostFoulShotsPlayer).getTotalPoints());

            playerStats.remove(mostFoulShotsPlayer);
            playerStats.trimToSize();

        }

        writeFile.close();

    }

    //The sortTotalPoints method accepts an array of playerStatistics and 
    //creates a new file that contains the data sorted from most total points 
    //to least
    public void sortTotalPoints(ArrayList<PlayerStatistics> playerStats) throws FileNotFoundException, IOException {

        File updatedList = new File("Z:\\Programming IV\\Java\\Don't Tell Mr. Mulroy\\points.txt");
       
        PrintWriter writeFile = new PrintWriter(updatedList);
        int mostTotalPointsPlayer = 0;

        while (playerStats.size() > 0) {

            for (int x = 0; x < playerStats.size(); x++) {

                for (int y = 0; y < playerStats.size(); y++) {

                    if (playerStats.get(y).getBaskets() > playerStats.get(mostTotalPointsPlayer).getBaskets() && mostTotalPointsPlayer != y) {

                        mostTotalPointsPlayer = y;
                        y = 0;

                    }

                }

            }

            writeFile.println(playerStats.get(mostTotalPointsPlayer).getName());
            writeFile.println(playerStats.get(mostTotalPointsPlayer).getBaskets());
            writeFile.println(playerStats.get(mostTotalPointsPlayer).getFoulShots());
            writeFile.println(playerStats.get(mostTotalPointsPlayer).getTotalPoints());

            playerStats.remove(mostTotalPointsPlayer);
            playerStats.trimToSize();

        }

        writeFile.close();

    }

}
