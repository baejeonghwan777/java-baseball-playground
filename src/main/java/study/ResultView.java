package study;

public class ResultView {
    final static int MAX_NUMBER = 3;
    final static int INIT_NUMBER = 0;
    static final int RAND_MAX = 9;
    static final int RAND_MIN = 1;

    public static int[] outputNumber() {
        int[] output = {INIT_NUMBER,INIT_NUMBER,INIT_NUMBER};
        for(int i = 0; i < MAX_NUMBER; i++) {
            randNumber(output, i);
        }
        return output;
    }

    public static void randNumber(int[] output, int index) {
        do {
            output[index] = (int) (Math.random() * RAND_MAX) + RAND_MIN;
        } while(!duplicationCheck(output, index));
    }

    public static boolean duplicationCheck(int[] output, int index) {
        for(int j = 0; j < index; j++) {
            if(output[j] == output[index]) return false;
        }
        return true;
    }
}
