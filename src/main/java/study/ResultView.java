package study;

public class ResultView {
    public static int[] outputNumber() {
        int[] output = {0,0,0};
        for(int i = 0; i < 3; i++) {
            output[i] = (int) (Math.random() * 9) + 1;
        }
        return output;
    }
}
