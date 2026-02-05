package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTestTDDVer {
    /*
    기존 게산기는 정상적으로 작동하지만 scanner 객체를 생성해서 직접 입력받아 계산하는 문제인줄 알고 그렇게 실행했다가
    영상에서는 assert를 통해 하나씩 테스트 케이스를 검증하였기에 그것과 같은 방식으로 다시 만들어 봤습니다.
     */ CalculatorTDDVer calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorTDDVer();
    }

    @Test
    public void testSplitOneText() throws Exception {
        String[] result = calculator.split("1");
        assertThat(result).isEqualTo(new String[]{"1"});
        result = calculator.split("");
        assertThat(result).isEqualTo(new String[]{""});
        result = calculator.split(" ");
        assertThat(result).isEqualTo(new String[]{});
        result = calculator.split(null);
        assertThat(result).isEqualTo(new String[]{});
    }

    @Test
    public void testSplitSpace() throws Exception {
        String[] result = calculator.split("1 + 2 + 3");
        assertThat(result).isEqualTo(new String[]{"1", "+", "2", "+", "3"});
    }

    @Test
    public void testToInt() throws Exception {
        Integer result = calculator.toInt("1");
        assertThat(result).isEqualTo(1);

        result = calculator.toInt(" ");
        assertThat(result).isEqualTo(null);

        result = calculator.toInt(null);
        assertThat(result).isEqualTo(null);
    }

    @Test
    public void testAdd() throws Exception {
        Integer num = calculator.add(1, 2);
        assertThat(num).isEqualTo(3);

        num = calculator.add(-1, -2);
        assertThat(num).isEqualTo(-3);

        num = calculator.add(1898998998, 1898998998); // 오버플로우 체크
        assertThat(num).isEqualTo(Integer.MAX_VALUE);

        num = calculator.add(-1898998998, -1898998998); // 언더플로우 체크
        assertThat(num).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    public void testSub() throws Exception {
        Integer num = calculator.subtract(1, -2);
        assertThat(num).isEqualTo(3);

        num = calculator.subtract(-1, 2);
        assertThat(num).isEqualTo(-3);

        num = calculator.subtract(1898998998, -1898998998); // 오버플로우 체크
        assertThat(num).isEqualTo(Integer.MAX_VALUE);

        num = calculator.subtract(-1898998998, 1898998998); // 언더플로우 체크
        assertThat(num).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    public void testMultiply() throws Exception {
        Integer num = calculator.multiply(1, -2);
        assertThat(num).isEqualTo(-2);

        num = calculator.multiply(-1, 2);
        assertThat(num).isEqualTo(-2);

        num = calculator.multiply(1898998998, 1898998998); // 오버플로우 체크
        assertThat(num).isEqualTo(Integer.MAX_VALUE);

        num = calculator.multiply(1898998998, -1898998998); // 언더플로우 체크
        assertThat(num).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    public void testDivide() throws Exception {
        Integer num = calculator.divide(15, 3);
        assertThat(num).isEqualTo(5);

        num = calculator.divide(-25, 5);
        assertThat(num).isEqualTo(-5);

        num = calculator.divide(Integer.MAX_VALUE, 1); // 오버플로우 체크
        assertThat(num).isEqualTo(Integer.MAX_VALUE);

        num = calculator.divide(Integer.MIN_VALUE, 1); // 언더플로우 체크
        assertThat(num).isEqualTo(Integer.MIN_VALUE);

        num = calculator.divide(5, 0); // 0으로 나누기 체크
        assertThat(num).isEqualTo(null);
    }

    @Test
    public void testSelectCal() throws Exception {
        Integer num = calculator.selectCal(new String[]{"1", "+", "2", "+", "3"});
        assertThat(num).isEqualTo(6);

        num = calculator.selectCal(new String[]{"2", "+", "3", "*", "4", "/", "2"});
        assertThat(num).isEqualTo(10);

        num = calculator.selectCal(new String[]{"1", "&", "2", "#", "3"});
        assertThat(num).isEqualTo(null);
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }
}
