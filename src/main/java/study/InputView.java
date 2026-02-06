package study;

import java.util.Scanner;

import static study.CheckBall.MAX_SCORE;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int[] inputNumber() {
        System.out.println("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        validNumber(input);
        return parseNumbers(input);
    }

    public static void validNumber(String input) {
        while(true) {
            if(input.length() != 3) {
                System.out.println("숫자를 다시 입력해 주세요 : "); // 숫자의 길이가 다른 경우에 다시 입력을 요구하기 위한 예외 처리이다.
                continue;
            }
            try {
                Integer.parseInt(input); // 문자가 아닌 경우에 다시 입력을 요구하기 위한 예외 처리이다.
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 다시 입력해 주세요 : ");
            }
        }
    }

    public static int[] parseNumbers(String input) {
        String[] strInputs = input.split("");
        int[] intInputs = {0,0,0};
        for(int i = 0; i < 3; i++) {
            intInputs[i] = Integer.parseInt(strInputs[i]);
        }
        return intInputs;
    }

    public static int checkReset() {
        System.out.println(MAX_SCORE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt();
    }
}
