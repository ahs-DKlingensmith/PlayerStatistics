
import java.io.*;
import java.util.*;

public class MainMethod {

    public static void main(String[] args) throws IOException {

        //Establish scanners for user input and file reading
        File getRoster = new File("Z:\\Programming IV\\Java\\Don't Tell Mr. Mulroy\\src\\points.txt");
        Scanner readTextFile = new Scanner(getRoster);
        Scanner keyboard = new Scanner(System.in);

        //Establish SortRoster object and array list to hold player information
        ArrayList<PlayerStatistics> initialList = new ArrayList(7);

        //Get the contents of the file and set to PlayerStatistics objects
        for (int x = 0; x < 7; x++) {

            String newName = readTextFile.nextLine();
            String newBaskets = readTextFile.nextLine();
            String newFoulShots = readTextFile.nextLine();
            String newTotalPoints = readTextFile.nextLine();

            initialList.add(x, new PlayerStatistics(newName,
                    Integer.valueOf(newBaskets),
                    Integer.valueOf(newFoulShots),
                    Integer.valueOf(newTotalPoints)));

        }

        readTextFile.close();

        //Sort the players by the indicated statistic
        
//        System.out.println("By which statistic do you want to sort the roster? "
//                + "Enter the corresponding number.");
//        System.out.println("1. Alphabetical order");
//        System.out.println("2. Most baskets");
//        System.out.println("3. Most foul shots");
//        System.out.println("4. Most total points");
//
//        int getSorting = 0;
//        getSorting = keyboard.nextInt();
//
//        while (getSorting < 0 || getSorting > 4) {
//
//            System.out.println("Please enter the number corresponding "
//                    + "to one of the four sorting methods.");
//            getSorting = keyboard.nextInt();
//
//        }
//
//        SortRoster rosterSorter = new SortRoster();
//
//        switch (getSorting) {
//
//            case 1:
//                rosterSorter.sortName(initialList);
//            case 2:
//                rosterSorter.sortBaskets(initialList);
//            case 3:
//                rosterSorter.sortFoulShots(initialList);
//            case 4:
//                rosterSorter.sortTotalPoints(initialList);
//            default:
//                System.out.println("If you see this message, then you "
//                        + "screwed up the code above, boyo.");
//
//        }
        
        //Get the name of the player and the statistic the user wishes 
        //to update, and the new value for that statistic
        boolean continueChanging = true;
        String enteredName = "";

        while (continueChanging) {

            //Get name of player
            System.out.println("\nEnter the name of the player "
                    + "whose statistics you wish to alter.");
            boolean correctName = false;

            while (!correctName) {

                enteredName = keyboard.nextLine();

                for (int x = 0; x < initialList.size(); x++) {

                    if (enteredName.equals(initialList.get(x).getName())) {
                        correctName = true;
                        continueChanging = false;
                    }

                }

                if (!correctName) {
                    System.out.println("That name is not "
                            + "found on the roster. Enter another name.");
                }

            }

            //Get statistic to be updated
            System.out.println("Enter the statistic that you want to alter.");
            System.out.println("1. Number of baskets");
            System.out.println("2. Number of foul shots");

            int getStatistic = 0;

            while (getStatistic < 1 || getStatistic > 2) {

                getStatistic = keyboard.nextInt();

                if (getStatistic < 1 || getStatistic > 2) {

                    System.out.println("Please enter the number "
                            + "corresponding to one of the listed statistics.");

                }

            }

            int updatedStatistic = -1;

            //Change the corresponding statistic
            switch (getStatistic) {

                case 1:

                    System.out.println("Enter the updated number of baskets.");

                    while (updatedStatistic < 0) {

                        updatedStatistic = keyboard.nextInt();

                        if (updatedStatistic < 0) {
                            System.out.println("Please enter a valid number.");
                        }

                    }

                    for (int x = 0; x < initialList.size(); x++) {

                        if (enteredName.equals(initialList.get(x).getName())) {
                            initialList.get(x).setBaskets(updatedStatistic);
                            initialList.get(x).updateTotalPoints();
                            System.out.println("The number of baskets has been updated.");
                        }

                    }

                    break;

                case 2:

                    System.out.println("Enter the updated number of foul shots.");

                    while (updatedStatistic < 0) {

                        updatedStatistic = keyboard.nextInt();

                        if (updatedStatistic < 0) {

                            System.out.println("Please enter a valid number.");

                        }

                    }

                    for (int x = 0; x < initialList.size(); x++) {

                        if (enteredName.equals(initialList.get(x).getName())) {
                            initialList.get(x).setFoulShots(updatedStatistic);
                            initialList.get(x).updateTotalPoints();
                            System.out.println("The number of foul shots has been updated.");
                        }
                    }

                    break;

                default:

                    System.out.println("If you see this, you messed up, Dylan.");

            }

            //Ask user if they wish to continue changing stats
            System.out.println("Do you wish to continue changing stats? (Y/N)");

            char continueChangingChar = 'A';
            String continueChangingString = "";

            while (!(continueChangingChar == 'Y' || continueChangingChar == 'N')) {

                continueChangingString = keyboard.next();
                continueChangingString = continueChangingString.toUpperCase();
                continueChangingChar = continueChangingString.charAt(0);

                if (continueChangingChar == 'N') {
                    continueChanging = false;
                }

                if (!(continueChangingChar == 'Y' || continueChangingChar == 'N')) {
                    System.out.println("Please enter a valid answer.");
                }

            }

        }

        //Establish new file for bar graph and file writer
        File barGraph = new File("Z:\\Programming IV\\Java\\Don't Tell Mr. Mulroy\\src\\barGraph.txt");

        PrintWriter writeFile = new PrintWriter(barGraph);

        //Print bar graph of each player's total points
        String asterisk = "*";

        for (int x = 0; x < initialList.size(); x++) {

            writeFile.println(initialList.get(x).getName() + " ");

            for (int y = 0; y < initialList.get(x).getTotalPoints(); y++) {

                writeFile.print(asterisk);

            }

            writeFile.println();

        }

        //Find the name of the player with the most baskets and most foul shots
        int mostBasketsPlayer = 0;
        int mostBaskets = 0;

        for (int x = 0; x < initialList.size(); x++) {

            if (initialList.get(x).getBaskets() > mostBaskets) {

                mostBasketsPlayer = x;
                mostBaskets = initialList.get(mostBasketsPlayer).getBaskets();

            }

        }

        writeFile.println("The player with the most baskets is "
                + initialList.get(mostBasketsPlayer).getName() + " with "
                + initialList.get(mostBasketsPlayer).getBaskets() + " baskets.");

        int mostFoulShotsPlayer = 0;
        int mostFoulShots = 0;

        for (int x = 0; x < initialList.size(); x++) {

            if (initialList.get(x).getFoulShots() > mostFoulShots) {

                mostFoulShotsPlayer = x;
                mostFoulShots = initialList.get(mostFoulShotsPlayer).getFoulShots();

            }

        }

        writeFile.println("The player with the most foul shots is "
                + initialList.get(mostFoulShotsPlayer).getName() + " with "
                + initialList.get(mostFoulShotsPlayer).getFoulShots() + " foul shots.");

        writeFile.close();

    }

}
