package study;

public class CheckBall {
    Ball ball;
    final static int MAX_SCORE = 3;
    final static int MAX_NUMBER = 3;
    final static int INIT_NUMBER = 0;
    final static int BALL = 0;
    final static int STRIKE = 1;

    public CheckBall(Ball ball) {
        this.ball = ball;
    }

    public int checkScoreInput(int[] inputs, int[] outputs) {
        ball.info = new int[]{INIT_NUMBER, INIT_NUMBER};
        for(int i = 0; i < MAX_NUMBER; i++) {
            checkScoreOutput(inputs, outputs, i);
        }
        return ball.info[STRIKE];
    }

    public void checkScoreOutput(int[] inputs, int[] outputs, int inputIndex) {
        for(int j = 0; j < MAX_NUMBER; j++) {
            if(compareNumber(inputs, outputs, inputIndex, j)) break;
        }
    }

    public boolean compareNumber(int[] inputs, int[] outputs, int inputIndex, int outputIndex) {
        if(inputs[inputIndex] == outputs[outputIndex] && inputIndex == outputIndex) {
            ball.info[STRIKE]++;
            return true;
        }
        if(inputs[inputIndex] == outputs[outputIndex]) {
            ball.info[BALL]++;
            return true;
        }
        return false;
    }

    public void printInfo(int[] info) {
        if(info[BALL] > 0) System.out.print(info[BALL] + "볼 ");
        if(info[STRIKE] > 0) System.out.print(info[STRIKE] + "스트라이크");
        if(info[BALL] <= 0 && info[STRIKE] <= 0) System.out.print("낫싱 : 세 숫자 모두 틀립니다.");
        System.out.println();
    }

    public boolean checkReset() {
        int flag = InputView.checkFlag();
        if(flag == 1) {
            ball = new Ball(new int[]{0, 0}, true, 0);
            return true;
        }
        if(flag == 2) return true;
        System.out.println("숫자를 다시 입력하세요.");
        return false;
    }

    public void gameLoop() {
        while(gameOperate());
    }

    public boolean gameOperate() {
        int[] outputs = {INIT_NUMBER, INIT_NUMBER, INIT_NUMBER};
        if(ball.initializer) {
            outputs = ResultView.outputNumber();
            ball.initializer = false;
        }
        while(!gamePlay(outputs));
        while(!checkReset());
        return ball.initializer;
    }

    public boolean gamePlay(int[] outputs) {
        if(ball.score == MAX_SCORE) {
            return true;
        }
        int[] inputs = InputView.inputNumber();
        ball.score = Math.max(checkScoreInput(inputs, outputs), ball.score);
        printInfo(ball.info);
        return false;
    }
}
