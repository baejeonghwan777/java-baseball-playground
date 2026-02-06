package study;

public class CheckBall {
    static int score = 0;
    final static int MAX_SCORE = 3;
    final static int MAX_NUMBER = 3;
    final static int INIT_NUMBER = 0;
    final static int BALL = 0;
    final static int STRIKE = 1;
    static boolean initalizer = true;

    public int checkScoreInput(int[] inputs, int[] outputs, int[] info) {
        for(int i = 0; i < MAX_NUMBER; i++) {
            checkScoreOutput(inputs, outputs, info, i);
        }
        return info[STRIKE];
    }

    public void checkScoreOutput(int[] inputs, int[] outputs, int[] info, int inputIndex) {
        for(int j = 0; j < MAX_NUMBER; j++) {
            if(compareNumber(inputs, outputs, info, inputIndex, j)) break;
        }
    }

    public boolean compareNumber(int[] inputs, int[] outputs, int[] info, int inputIndex, int outputIndex) {
        if(inputs[inputIndex] == outputs[outputIndex] && inputIndex == outputIndex) {
            info[STRIKE]++;
            return true;
        }
        if(inputs[inputIndex] == outputs[outputIndex] && inputs[inputIndex] == outputs[inputIndex] && inputs[outputIndex] == outputs[outputIndex]) {
            info[STRIKE]++; // 비교하는 숫자의 두 위치에 존재하는 숫자가 같을 때 비교하는 과정이다.
            return true;
        }
        if(inputs[inputIndex] == outputs[outputIndex]) {
            info[BALL]++;
            return true;
        }
        return false;
    }

    public void printInfo(int[] info) {
        if(info[BALL] > 0) System.out.print(info[BALL] + "볼 ");
        if(info[STRIKE] > 0) System.out.print(info[STRIKE] + "스트라이크");
        if(info[BALL] <= 0 && info[STRIKE] <= 0) System.out.print("낫싱 : 세 숫자 모두 틀립니다.");;
        System.out.println();
    }

    public void gameLoop() {
        while(gameOperate());
    }

    public boolean gameOperate() {
        int[] outputs = {INIT_NUMBER, INIT_NUMBER, INIT_NUMBER};
        if(initalizer) {
            outputs = ResultView.outputNumber();
            initalizer = false;
        }
        while(!gamePlay(outputs));
        while(!InputView.checkReset());
        return initalizer;
    }

    public boolean gamePlay(int[] outputs) {
        if(score == MAX_SCORE) {
            return true;
        }
        int[] inputs = InputView.inputNumber();
        int[] info = {INIT_NUMBER, INIT_NUMBER};
        score = Math.max(checkScoreInput(inputs, outputs, info),score);
        printInfo(info);
        return false;
    }
}
