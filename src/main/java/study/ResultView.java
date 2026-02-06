package study;

public class ResultView {
    static final int RAND_MAX = 9;
    static final int RAND_MIN = 1;

    public static int[] outputNumber() {
        int[] output = {0,0,0};
        for(int i = 0; i < 3; i++) {
            output[i] = (int) (Math.random() * RAND_MAX) + RAND_MIN;
        }
        return output;
    }
}
