import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Entry point for the Cave Game.
// Handles game setup, rounds, combat, rewards, and status display.
public class Main {
    public static Scanner scanner = new Scanner(System.in); // Creates a universal scanner object

    public static String getInput(String[] textList) {
        String action = "";

        while (!(action.equals("1") || action.equals("2") || action.equals("3"))) { // Loops until input is 1, 2, or 3
            for (int i=0; i<textList.length; i++) { // Prints all text prompts in list
                System.out.println(textList[i]);
            }

            System.out.print("> ");
            action = scanner.nextLine(); // Gets user input

            if (!(action.equals("1") || action.equals("2") || action.equals("3"))) { // Checks input and provides error message if necessary
                System.out.println("Enter a valid input");
            }
        }

        return action;
    }

    public static void main(String[] args) {

        // ----- Game Setup -----
        System.out.print("How many players enter the cave? ");
        int playerCount = Integer.parseInt(scanner.nextLine());

        // Create players with starting HP
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player(20));
        }

        int round = 1;
        boolean gameRunning = true;
        int totalGoblinsKilled = 0;
        String[] promptsList = new String[4]; // Creates a prompt list object with 4 slots

        // Flavor text depending on party size
        if (playerCount > 1) {
            System.out.println("\nThe party enters the cave...");
        } else {
            System.out.println("\nYou enter the cave...");
        }

        // ===== MAIN GAME LOOP =====
        while (gameRunning) {

            System.out.println("\n===== ROUND " + round + " =====");

            // Small regeneration after the first round
            if (round > 1) {
                players.forEach(p -> p.heal(1));
                System.out.println("The party regains a bit of strength (+1 HP each).");
            }

            // ----- Spawn Enemies -----
            Enemy.resetIds();

            int minGoblins = Math.max(1, round / 2);
            int maxGoblins = round + 1;
            int goblinCount =
                (int)(Math.random() * (maxGoblins - minGoblins + 1)) + minGoblins;

            // Goblin attack power scales with rounds
            int maxAttackPower = 3 + round;

            List<Enemy> goblins = new ArrayList<>();
            for (int i = 0; i < goblinCount; i++) {
                goblins.add(new Enemy(10, maxAttackPower));
            }

            System.out.println(
                goblinCount == 1
                    ? "\nA goblin emerges from the darkness!"
                    : "\n" + goblinCount + " goblins emerge from the darkness!"
            );

            printStatus(players, goblins);

            // ===== COMBAT LOOP =====
            while (!players.isEmpty() && !goblins.isEmpty()) {

                // ----- Player Turns -----
                for (int p = 0; p < players.size() && !goblins.isEmpty(); p++) {
                    Player player = players.get(p);
                    player.startTurn();

                    // Sets the prompt list to list of combat choices
                    promptsList[0] = "\nPlayer " + player.getId() + ", choose an action:";
                    promptsList[1] = "1) Attack";
                    promptsList[2] = "2) Defend";
                    promptsList[3] = "3) Use Healing Potion";

                    String choice = getInput(promptsList); // Calls the dedicated function instead of directly scanning input

                    switch (choice) {
                        case "1":
                            int damage = player.attack();
                            int targetIndex = (int)(Math.random() * goblins.size());
                            Enemy target = goblins.get(targetIndex);

                            target.takeDamage(damage);
                            System.out.println(
                                "Player " + player.getId() +
                                " hits Goblin " + target.getId() +
                                " for " + damage + " damage!"
                            );

                            if (!target.isAlive()) {
                                System.out.println("Goblin slain!");
                                goblins.remove(targetIndex);
                                totalGoblinsKilled++;
                            }
                            break;

                        case "2":
                            player.defend();
                            System.out.println("Player " + player.getId() + " prepares to block.");
                            break;

                        case "3":
                            player.usePotion();
                            break;

                        // Removed default case
                    }
                }

                // ----- Goblin Turns -----
                for (int g = 0; g < goblins.size() && !players.isEmpty(); g++) {
                    Enemy goblin = goblins.get(g);

                    int targetIndex = (int)(Math.random() * players.size());
                    Player target = players.get(targetIndex);

                    int dmg = goblin.attack();
                    target.takeDamage(dmg);

                    System.out.println(
                        "Goblin " + goblin.getId() +
                        " hits Player " + target.getId() +
                        " for " + dmg + " damage!"
                    );

                    // Immediately remove defeated players
                    if (!target.isAlive()) {
                        System.out.println("Player " + target.getId() + " has been eliminated!");
                        players.remove(targetIndex);
                    }
                }

                if (!players.isEmpty() && !goblins.isEmpty()) {
                    printStatus(players, goblins);
                }

                if (goblins.isEmpty()) {
                    System.out.println("\nAll goblins have been slain!");
                }
            }

            // ===== ROUND END =====
            if (players.isEmpty()) {
                System.out.println("You fall in round " + round + "...");
                break;
            }

            System.out.println("You survive round " + round + "!");
            System.out.println("\n--- Survivors ---");
            players.forEach(p ->
                System.out.println("Player " + p.getId() + " HP: " + p.getHp())
            );

            // ----- Rewards -----
            // Sets the prompt list to list of reward choices
            promptsList[0] = "\nChoose a reward:";
            promptsList[1] = "1) Heal all players (+2 HP)";
            promptsList[2] = "2) Gain 1 healing potion per player";
            promptsList[3] = "3) Upgrade weapons (+1 damage)";

            String rewardChoice = getInput(promptsList); // Calls the dedicated function instead of directly scanning input

            switch (rewardChoice) {
                case "1":
                    players.forEach(p -> p.heal(2));
                    System.out.println("The party feels rejuvenated!");
                    break;

                case "2":
                    players.forEach(Player::addPotion);
                    System.out.println("Each player receives a healing potion!");
                    break;

                case "3":
                    players.forEach(p -> {
                        p.upgradeWeapon(1);
                        System.out.println(
                            "Player " + p.getId() + " upgraded weapon! " + p.getWeaponInfo()
                        );
                    });
                    break;

                // Removed default case
            }

            round++;
        }

        // ----- Game Summary -----
        System.out.println("\nGame Over");
        System.out.println(
            "You reached round " + round +
            " and slew " + totalGoblinsKilled + " goblins."
        );

        scanner.close();
    }

    // Displays current HP, potions, and enemy status
    private static void printStatus(List<Player> players, List<Enemy> goblins) {

        System.out.println("\n--- Party Status ---");
        for (Player p : players) {
            System.out.println(
                "Player " + p.getId() +
                " HP: " + p.getHp() +
                " | Potions: " + p.getPotions()
            );
        }

        if (goblins.isEmpty()) {
            System.out.println("\n--- All Enemies Defeated ---");
            return;
        }

        System.out.println("\n--- Goblin Status ---");
        for (Enemy g : goblins) {
            System.out.println(
                "Goblin " + g.getId() +
                " HP: " + g.getHp() +
                " | Attack Power: " + g.getAttackDamage()
            );
        }
    }
}
