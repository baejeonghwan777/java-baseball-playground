package study;

public class Ball {
    int score;
    boolean initializer;
    int[] info;

    public Ball(int[] info, boolean initializer, int score) {
        this.info = info;
        this.initializer = initializer;
        this.score = score;
    }
}
