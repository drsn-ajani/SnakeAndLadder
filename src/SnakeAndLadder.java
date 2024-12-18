public class SnakeAndLadder {
    private int player_position;

    public SnakeAndLadder() {
        this.player_position = 0;
    }

//    UC-1
    public void diplay() {
        System.out.println("Initial Position of Player is: " + player_position);
    }

//    UC-2
    public int roll_the_dice() {
        return (int) Math.floor(Math.random() * 6) + 1;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Snake And Ladder Game");
        SnakeAndLadder game = new SnakeAndLadder();

//        UC-1
        game.diplay();

//        UC-2
        System.out.println("Number got on rolling the dice is: " + game.roll_the_dice());

    }

}
