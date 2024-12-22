public class Multiplayer_UC7 {
    private int player1_position, player2_position, die_roll = 0;
    int current_player = 1;

    public Multiplayer_UC7() {
        this.player1_position = 0;
        this.player2_position = 0;
    }

    //    UC-1      -->     Displaying Initial player position
    public void diplay() {
        System.out.println("Initial Position of Player1 is: " + player1_position);
        System.out.println("Initial Position of Player2 is: " + player2_position);
    }

    //    UC-2      -->     Rolling the Dice
    public int roll_the_dice() {
        die_roll++;
        return (int) Math.floor(Math.random() * 6) + 1;
    }

    //    UC-3      -->     Looking for options {0: No play, 1: Ladder(Move forward), 2: Snake(Move Backward)}
    public int set_player_position(int position) {
        int num = (int) Math.floor(Math.random() * 3);

        int roll = roll_the_dice();
//        UC-6      -->     No. of times Dice is rolled
        System.out.println(die_roll + " times dice is rolled with number on die is " + roll);


        switch (num) {
            case 0:
                System.out.println("Player will stay at the same position");
                break;
            case 1:
//                UC-5      -->     Restricting user from going beyond 100
                if (position + roll <= 100)
                    position += roll;
                System.out.println(" + ");
                position = set_player_position(position);
                break;

            case 2:
                position -= roll;
                System.out.println(" - ");
                if (position < 0)    position = 0;
                break;
        }
        return position;
    }


    //        UC-4      -->     Repeat Until player reaches at position 100
    public void until_player_win() {
        while (player1_position < 100 && player2_position < 100) {
            System.out.println("\nPlayer " + current_player + "'s turn");

            if (current_player == 1) {
                player1_position = set_player_position(player1_position);
//                if (player1_position >= 100)    player1_position = 100;
                System.out.println("Player 1's position: " + player1_position);
                current_player = 2;
                if (player1_position == 100)    break;
            } else {
                player2_position = set_player_position(player2_position);
//                if (player2_position >= 100)    player2_position = 100;
                System.out.println("Player 2's position: " + player2_position);
                if (player2_position == 100)    break;
                current_player = 1;
            }

        }
        if (player1_position == 100) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Snake And Ladder Game");
        Multiplayer_UC7 game = new Multiplayer_UC7();

//        UC-1
        game.diplay();

//        UC-2
//        System.out.println("Number got on rolling the dice is: " + game.roll_the_dice());

//        UC-3
//        game.set_player_position();


//        UC-4
        System.out.println("Before until player_win\n");
        game.until_player_win();
        System.out.println("\nAfter until player_win");

    }

}

