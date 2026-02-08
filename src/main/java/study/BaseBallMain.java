package study;

public class BaseBallMain {
    public static void main(String[] args) {
        Ball ball = new Ball(new int[]{0, 0},true,0);
        CheckBall baseballGame = new CheckBall(ball);
        baseballGame.gameLoop();
    }
}
