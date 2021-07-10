import java.util.ArrayList;
import java.util.Scanner;

public class Playground {
    static ArrayList<Player> playerArray = new ArrayList<Player>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            promptForMenu();

            char choice = scanner.next().toLowerCase().charAt(0);
            System.out.println();

            switch (choice) {
                case 'a':
                    addPlayer();
                    break;

                case 'v':
                    displayPlayerDetails();
                    break;

                case 'b':
                    findTheBestTwoPlayers("batsman");
                    break;

                case 'c':
                    findTheBestTwoPlayers("bowler");
                    break;

                case 'd':
                    findTheBestPlayer("keeper");
                    break;

                case 'q':
                    System.out.println("Exiting...");
                    isRunning = false;
            }
        }
    }


    public static void promptForMenu() {

        System.out.print("""
                
                Press A for add player
                Press V for view players
                Press B to display two best batsmans
                Press C to display two best bowlers
                Press D to display the best keeper
                Press Q to exit
                Enter your choice now ....""");
    }


    public static void addPlayer() {
        String name;
        int age;
        String type;
        ArrayList<Integer> performance = new ArrayList<Integer>();

        System.out.print("Enter player name: ");
        name = scanner.next();

        System.out.print("Enter player age: ");
        age = scanner.nextInt();

        System.out.print("Enter player type: ");
        type = scanner.next().toLowerCase();

        for (int i=0; i<15; i++) {
            System.out.print("Enter player score " + (i+1) + ": ");
            performance.add(scanner.nextInt());
        }

        Player p = new Player(name, age, type, performance);
        playerArray.add(p);
    }


    public static void findTheBestTwoPlayers(String playerType) {
        double bestPlayer1Avg = 0;
        double bestPlayer2Avg = 0;

        String bestPlayer1Name = "";
        String bestPlayer2Name = "";

        for (Player player:playerArray) {
            if (player.getType().equals(playerType)) {

                if (player.getAverage() > bestPlayer1Avg) {
                    bestPlayer2Avg = bestPlayer1Avg;
                    bestPlayer2Name = bestPlayer1Name;

                    bestPlayer1Avg = player.getAverage();
                    bestPlayer1Name = player.getName();
                }
                else if (player.getAverage() > bestPlayer2Avg){
                    bestPlayer2Avg = player.getAverage();
                    bestPlayer2Name = player.getName();
                }

            }
        }

        System.out.println(bestPlayer1Name);
        System.out.println(bestPlayer2Name);
    }


    public static void displayPlayerDetails() {
        for (Player player:playerArray) {
            player.getPlayerDetails();
        }
    }


    public static void findTheBestPlayer(String playerType) {
        double bestPlayerAvg = 0;
        String bestPlayerName = "";

        for (Player player:playerArray) {
            if (player.getType().equals(playerType)) {

                if (player.getAverage() > bestPlayerAvg) {
                    bestPlayerAvg = player.getAverage();
                    bestPlayerName = player.getName();
                }
            }
        }

        System.out.println(bestPlayerName);
    }
}
