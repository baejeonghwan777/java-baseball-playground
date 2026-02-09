package study;

public class CheckBall {
    final static int MAX_SCORE = 3;
    final static int MAX_NUMBER = 3;
    final static int INIT_NUMBER = 0;
    final static int BALL = 0;
    final static int STRIKE = 1;
    Balls balls;
    int score = 0;
    boolean initializer = true;

    public CheckBall(Balls balls) {
        this.balls = balls;
    }

    public int checkScoreInput(int[] inputs, int[] outputs, int[] info) {
        for (int i = 0; i < MAX_NUMBER; i++) {
            checkScoreOutput(inputs, outputs, i);
            info[BALL] += balls.lookUpBall(i);
            info[STRIKE] += balls.lookUpStrike(i);
        }
        return info[STRIKE];
    }

    public void checkScoreOutput(int[] inputs, int[] outputs, int inputIndex) {
        for (int j = 0; j < MAX_NUMBER; j++) {
            if (compareNumber(inputs, outputs, inputIndex, j)) break;
        }
    }

    public boolean compareNumber(int[] inputs, int[] outputs, int inputIndex, int outputIndex) {
        if (inputs[inputIndex] == outputs[outputIndex] && inputIndex == outputIndex) {
            balls.activateStrikes(inputIndex);
            return true;
        }
        if (inputs[inputIndex] == outputs[outputIndex]) {
            balls.activateBalls(inputIndex);
            return true;
        }
        return false;
    }

    public void printInfo(int[] info) {
        if (info[BALL] > 0) System.out.print(info[BALL] + "볼 ");
        if (info[STRIKE] > 0) System.out.print(info[STRIKE] + "스트라이크");
        if (info[BALL] <= 0 && info[STRIKE] <= 0) System.out.print("낫싱 : 세 숫자 모두 틀립니다.");
        System.out.println();
    }

    public boolean checkReset() {
        int flag = InputView.checkFlag();
        if (flag == 1) {
            score = 0;
            initializer = true;
            return true;
        }
        if (flag == 2) return true;
        System.out.println("숫자를 다시 입력하세요.");
        return false;
    }

    public void gameLoop() {
        while (gameOperate()) ;
    }

    public boolean gameOperate() {
        int[] outputs = {INIT_NUMBER, INIT_NUMBER, INIT_NUMBER};
        if (initializer) {
            outputs = ResultView.outputNumber();
            initializer = false;
        }
        while (!gamePlay(outputs)) ;
        while (!checkReset()) ;
        return initializer;
    }

    public boolean gamePlay(int[] outputs) {
        if (score == MAX_SCORE) {
            return true;
        }
        balls.initializeBalls(MAX_NUMBER);
        int[] inputs = InputView.inputNumber();
        int[] info = {INIT_NUMBER, INIT_NUMBER};
        score = Math.max(checkScoreInput(inputs, outputs, info), score);
        printInfo(info);
        return false;
    }
}
