package study;

import java.util.ArrayList;
import java.util.List;

public class BaseBallMain {
    public static void main(String[] args) {
        List<Ball> ballList = new ArrayList<>();
        CheckBall baseballGame = new CheckBall(new Balls(ballList, 3));
        baseballGame.gameLoop();
    }
}
