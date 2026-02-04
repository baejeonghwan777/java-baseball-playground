package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach // 메서드 실행 전 매번 초기화
    public void setUp() {
        cal = new Calculator();
    }

    @Test
    public void addTest() {
        assertEquals(7, cal.add(3,4));
    }

    @Test
    public void subTest() {
        assertEquals(7, cal.subtract(3,4));
    }

    @Test
    public void multiplyTest() {
        assertEquals(7, cal.multiply(3,4));
    }

    @Test
    public void divideTest() {
        assertEquals(7, cal.divide(3,4));
    }

    @AfterEach
    public void tearDown() {
        cal = null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        Calculator calculator = new Calculator();
        int result = 0;

        for(int i=0;i < values.length;i+=2) {
            if(i == 0) {
                result = Integer.parseInt(values[0]);
            } else if(i != 0) {
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
        }

        System.out.println(result);
    }
}
