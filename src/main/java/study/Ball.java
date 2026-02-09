package study;

public class Ball {
    private int ball;
    private int strike;

    public Ball(int ball, int strike) {
        if (ball >= 0 && ball <= 1) this.ball = ball;
        if (ball < 0 || ball > 1) this.ball = 0;
        if (strike >= 0 && strike <= 1) this.strike = strike;
        if (strike < 0 || strike > 1) this.strike = 0;
    }

    public void activateBall() {
        if (ball >= 0 && ball <= 1) this.ball++;
    }

    public void activateStrike() {
        if (strike >= 0 && strike <= 1) this.strike++;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
