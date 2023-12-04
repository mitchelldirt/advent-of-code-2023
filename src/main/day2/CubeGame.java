package main.day2;

public class CubeGame {
    static int sumOfPosibleGameIds(String input) {
        int sum = 0;

        String[] inputs = input.split("\\n");

        for (String line: inputs) {
            Game[] hands = createGames(line);
            boolean isPlayable = true;
            for (Game hand: hands) {
                if (hand == null) continue;
                isPlayable = gameIsPlayable(hand);

                if (!isPlayable) break;
            }
            if (isPlayable) {
                sum += hands[0].getId();
            }
        }

        return sum;
    }

    private static Game[] createGames(String input) {
        Game[] games = new Game[10];
        int gameIndex =  0;

        // parse the string to create the game
        // Game 39: 7 blue, 6 red, 2 green; 6 blue, 1 red; 7 blue, 1 red

        String[] gameString = input.split(":");
        int id = Integer.parseInt(gameString[0].split(" ")[1]);
        String[] hands = gameString[1].split(";");

        for (String hand: hands) {
            Game currentGame = new Game();
            currentGame.setId(id);

            String[] grabs = hand.split(",");

            for (String grab : grabs) {
                String[] currentGrab = grab.trim().split(" ");
                int qtyPulled = Integer.parseInt(currentGrab[0]);

                switch (currentGrab[1]) {
                    case "red":
                        currentGame.setRed(qtyPulled);
                        break;
                    case "green":
                        currentGame.setGreen(qtyPulled);
                        break;
                    case "blue":
                        currentGame.setBlue(qtyPulled);
                        break;
                    default:
                        break;
                }
            }
            games[gameIndex] = currentGame;
            gameIndex++;
        }


        return games;
    }

    private static boolean gameIsPlayable(Game game) {
        return game.getRed() <= 12 && game.getGreen() <= 13 && game.getBlue() <= 14;
    }
}

class Game {
    private int id;
    private int red;
    private int green;
    private int blue;

    public Game() {
        this.id = 0;
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    public int getId() {
        return id;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRed(int red) {
        this.red += red;
    }

    public void setGreen(int green) {
        this.green += green;
    }

    public void setBlue(int blue) {
        this.blue += blue;
    }
}
