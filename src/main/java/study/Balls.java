package study;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls, int maxBall) {
        this.balls = new ArrayList<>(balls);
        initializeBalls(maxBall);
    }

    public void activateBalls(int index) {
        Ball ball = balls.get(index);
        ball.activateBall();
    }

    public void activateStrikes(int index) {
        Ball ball = balls.get(index);
        ball.activateStrike();
    }

    public int lookUpBall(int index) {
        Ball ball = balls.get(index);
        return ball.getBall();
    }

    public int lookUpStrike(int index) {
        Ball ball = balls.get(index);
        return ball.getStrike();
    }

    public void initializeBalls(int maxBall) {
        balls.clear();
        for (int i = 0; i <= maxBall; i++) {
            balls.add(new Ball(0, 0));
        }
    }
}
