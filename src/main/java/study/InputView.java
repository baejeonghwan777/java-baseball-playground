package study;

import java.util.Scanner;

import static study.CheckBall.*;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int[] inputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        while (!validNumber(input)) {
            System.out.print("숫자를 다시 입력해 주세요. : ");
            input = scanner.nextLine();
        }
        return parseNumbers(input);
    }

    public static boolean validNumber(String input) {
        if(input.length() != MAX_NUMBER) {
            return false; // 숫자의 길이가 다른 경우에 다시 입력을 요구하기 위한 예외 처리이다.
        }
        try {
            Integer.parseInt(input); // 문자가 아닌 경우에 다시 입력을 요구하기 위한 예외 처리이다.
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int[] parseNumbers(String input) {
        String[] strInputs = input.split("");
        int[] intInputs = {INIT_NUMBER,INIT_NUMBER,INIT_NUMBER};
        for(int i = 0; i < MAX_NUMBER; i++) {
            intInputs[i] = Integer.parseInt(strInputs[i]);
        }
        return intInputs;
    }

    public static boolean checkReset() {
        System.out.println(MAX_SCORE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int flag = scanner.nextInt();
        scanner.nextLine();
        if(flag == 1) {
            score = 0;
            initalizer = true;
            return true;
        }
        if(flag == 2) return true;
        System.out.println("숫자를 다시 입력하세요.");
        return false;
    }
}
