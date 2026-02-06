package study;

public class CheckBall {
    int score = 0;
    static int MAX_SCORE = 3;
    static int MAX_NUMBER = 3;

    public int checkScore(int[] inputs, int[] outputs) {
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < MAX_NUMBER; i++) {
            for(int j = 0; j < MAX_NUMBER; j++) { // 분리 예정
                int[] info = {0, 0}; // output parameter를 받아 ball, strike에 저장할 정수형 배열 선언(depth 2 조건 제한에 의한다.)
                compareNumber(inputs[i], outputs[i], info, i, j);
                ball = info[0];
                strike = info[1];
            }
        }
        if(ball > 0) System.out.print(ball + "볼 ");
        if(strike > 0) System.out.println(strike + "스트라이크");
        return strike;
    }

    public void compareNumber(int input, int output, int[] info, int inputIndex, int outputIndex) {
        if(input == output) {
            if(inputIndex == outputIndex) info[0]++;
            if(inputIndex != outputIndex) info[1]++;
        }
    }

    public void gamePlay() {
        while(true) {
            if(score != MAX_SCORE) {
                int[] inputs = InputView.inputNumber();
                int[] outputs = ResultView.outputNumber();
                score = Math.max(checkScore(inputs, outputs),score);
            }
            if(score == MAX_SCORE) {
                int flag = InputView.checkReset();
                if(flag == 1) break;
                if(flag != 2) System.out.println("숫자를 다시 입력해주세요.");
            }
        }
    }
}
