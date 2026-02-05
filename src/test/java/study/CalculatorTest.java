package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach // 메서드 실행 전 매번 초기화
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void addTest() {
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    public void subTest() {
        assertEquals(-1, calculator.subtract(3, 4));
    }

    @Test
    public void multiplyTest() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    public void divideTest() {
        assertEquals(3, calculator.divide(3, 1));
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }
}
