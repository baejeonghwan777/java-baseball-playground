package study;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        Calculator calculator = new Calculator();
        final int FIRST_NUM = 0;

        int result = Integer.parseInt(values[FIRST_NUM]); // 첫번째 값 초기화

        for (int i = 2; i < values.length; i += 2) {
            int cal = Integer.parseInt(values[i]);
            switch (values[i - 1]) {
                case "+":
                    result = calculator.add(result, cal);
                    break;
                case "-":
                    result = calculator.subtract(result, cal);
                    break;
                case "*":
                    result = calculator.multiply(result, cal);
                    break;
                case "/":
                    result = calculator.divide(result, cal);
                    break;
            }
        }

        System.out.println(result);
    }
}
