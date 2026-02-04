package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.Transient;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTestTDDVer {
    /*
    기존 게산기는 정상적으로 작동하지만 scanner 객체를 생성해서 직접 입력받아 계산하는 문제인줄 알고 그렇게 실행했다가
    영상에서는 assert를 통해 하나씩 테스트 케이스를 검증하였기에 그것과 같은 방식으로 다시 만들어 봤습니다.
     */
    CalculatorTDDVer cal;

    @BeforeEach
    public void setUp() {
        cal = new CalculatorTDDVer();
    }

    @Test
    public void testSplitOneText() throws Exception {
        String[] result = cal.split("1");
        assertThat(result).isEqualTo(new String[]{"1"});
        result = cal.split("");
        assertThat(result).isEqualTo(new String[]{""});
        result = cal.split(" ");
        assertThat(result).isEqualTo(new String[]{});
        result = cal.split(null);
        assertThat(result).isEqualTo(new String[]{});
    }

    @Test
    public void testSplitSpace() throws Exception {
        String[] result = cal.split("1 + 2 + 3");
        assertThat(result).isEqualTo(new String[]{"1","+","2","+","3"});
    }

//    @Test
//    public void testSplitComma() throws Exception {
//        String[] result = cal.split("1,2,3");
//        assertThat(result).isEqualTo(new String[]{"1","2","3"});
//    }
//
//    @Test
//    public void testSplitBar() throws Exception {
//        String[] result = cal.split("1,2,3");
//        assertThat(result).isEqualTo(new String[]{"1","2","3"});
//    }

//    @Test
//    public void testToInt() throws Exception {
//        int[] result = cal.toInt(new String[]{"1","2"});
//        assertThat(result).isEqualTo(new int[]{1,2});
//
//        result = cal.toInt(new String[]{});
//        assertThat(result).isEqualTo(new int[]{});
//
//        result = cal.toInt(null);
//        assertThat(result).isEqualTo(new int[]{});
//    }

    @Test
    public void testToInt() throws Exception {
        Integer result = cal.toInt("1");
        assertThat(result).isEqualTo(1);

        result = cal.toInt(" ");
        assertThat(result).isEqualTo(null);

        result = cal.toInt(null);
        assertThat(result).isEqualTo(null);
    }

    @Test
    public void testAdd() throws Exception {
        Integer num = cal.add(1,2);
        assertThat(num).isEqualTo(3);

        num = cal.add(-1,-2);
        assertThat(num).isEqualTo(-3);

        num = cal.add(1898998998,1898998998); // 오버플로우 체크
        assertThat(num).isEqualTo(Integer.MAX_VALUE);

        num = cal.add(-1898998998,-1898998998); // 언더플로우 체크
        assertThat(num).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    public void testSub() throws Exception {
        Integer num = cal.subtract(1,-2);
        assertThat(num).isEqualTo(3);

        num = cal.subtract(-1,2);
        assertThat(num).isEqualTo(-3);

        num = cal.subtract(1898998998,-1898998998); // 오버플로우 체크
        assertThat(num).isEqualTo(Integer.MAX_VALUE);

        num = cal.subtract(-1898998998,1898998998); // 언더플로우 체크
        assertThat(num).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    public void testMultiply() throws Exception {
        Integer num = cal.multiply(1,-2);
        assertThat(num).isEqualTo(-2);

        num = cal.multiply(-1,2);
        assertThat(num).isEqualTo(-2);

        num = cal.multiply(1898998998,1898998998); // 오버플로우 체크
        assertThat(num).isEqualTo(Integer.MAX_VALUE);

        num = cal.multiply(1898998998,-1898998998); // 언더플로우 체크
        assertThat(num).isEqualTo(Integer.MIN_VALUE);
    }
    @Test
    public void testDivide() throws Exception {
        Integer num = cal.divide(15,3);
        assertThat(num).isEqualTo(5);

        num = cal.divide(-25,5);
        assertThat(num).isEqualTo(-5);

        num = cal.divide(Integer.MAX_VALUE,1); // 오버플로우 체크
        assertThat(num).isEqualTo(Integer.MAX_VALUE);

        num = cal.divide(Integer.MIN_VALUE,1); // 언더플로우 체크
        assertThat(num).isEqualTo(Integer.MIN_VALUE);

        num = cal.divide(5,0); // 0으로 나누기 체크
        assertThat(num).isEqualTo(null);
    }

    @Test
    public void testSelectCal() throws Exception {
        Integer num = cal.selectCal(new String[]{"1","+","2","+","3"});
        assertThat(num).isEqualTo(6);

        num = cal.selectCal(new String[]{"2","+","3","*","4","/","2"});
        assertThat(num).isEqualTo(10);

        num = cal.selectCal(new String[]{"1","&","2","#","3"});
        assertThat(num).isEqualTo(null);
    }

    @AfterEach
    public void tearDown() {
        cal = null;
    }
}
