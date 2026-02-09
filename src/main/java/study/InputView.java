package study;

import java.util.Scanner;

public class InputView {
    final static int MAX_SCORE = 3;
    final static int MAX_NUMBER = 3;
    final static int INIT_NUMBER = 0;
    static Scanner scanner = new Scanner(System.in);

    public static int[] inputNumber() {
        System.out.print("숫자를 입력해 주세요. : ");
        String input = scanner.nextLine();
        while (!validNumber(input)) {
            System.out.print("숫자를 다시 입력해 주세요. : ");
            input = scanner.nextLine();
        }
        return parseNumbers(input);
    }

    public static boolean validNumber(String input) {
        if(input.length() != MAX_NUMBER || input.contains("0")) {
            return false; // 숫자의 길이가 다른 경우에 다시 입력을 요구하기 위한 예외 처리이다.
        }
        try {
            return checkNumber(parseNumbers(input)); // 문자가 아닌 경우에 다시 입력을 요구하기 위한 예외 처리이다.
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkNumber(int[] intInputs) {
        for(int i = 1; i < MAX_NUMBER; i++) {
            if(!duplicationCheck(intInputs, i)) return false;
        }
        return true;
    }

    public static boolean duplicationCheck(int[] output, int index) {
        for(int j = 0; j < index; j++) {
            if(output[j] == output[index]) return false;
        }
        return true;
    }

    public static int[] parseNumbers(String input) {
        String[] strInputs = input.split("");
        int[] intInputs = {INIT_NUMBER,INIT_NUMBER,INIT_NUMBER};
        for(int i = 0; i < MAX_NUMBER; i++) {
            intInputs[i] = Integer.parseInt(strInputs[i]);
        }
        return intInputs;
    }

    public static int checkFlag() {
        System.out.println(MAX_SCORE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int flag = scanner.nextInt();
        scanner.nextLine();
        return flag;
    }
}
