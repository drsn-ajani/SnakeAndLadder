public class SnakeAndLadder {
    private int player_position;

    public SnakeAndLadder() {
        this.player_position = 0;
    }

//    UC-1      -->     Displaying Initial player position
    public void diplay() {
        System.out.println("Initial Position of Player is: " + player_position);
    }

//    UC-2      -->     Rolling the Dice
    public int roll_the_dice() {
        return (int) Math.floor(Math.random() * 6) + 1;
    }

//    UC-3      -->     Looking for options {0: No play, 1: Ladder(Move forward), 2: Snake(Move Backward)}
    public void set_player_position() {
        int num = (int) Math.floor(Math.random() * 3);

        int roll = roll_the_dice();


        switch (num) {
            case 0:
                System.out.println("Player will stay at the same position");
                break;
            case 1:
                player_position += roll;
                if (player_position >= 100)    player_position = 100;
                System.out.println("Player will move in Forward Dir with " + roll + " steps\tWill reach at " + player_position);
                break;

            case 2:
                player_position -= roll;
                if (player_position < 0)    player_position = 0;
                System.out.println("Player will move in Backward Dir with " + roll + " steps\tWill reach at " + player_position);
                break;

        }
    }


//        UC-4      -->     Repeat Until player reaches at position 100
        public void until_player_win() {
            while (player_position < 100) {
                set_player_position();
//                System.out.println(player_position + "\t");
            }
            if (player_position == 100) {
                System.out.println("Player Reached at the WINNING POSITION..!!");
            }
        }

    public static void main(String[] args) {
        System.out.println("Welcome to Snake And Ladder Game");
        SnakeAndLadder game = new SnakeAndLadder();

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
