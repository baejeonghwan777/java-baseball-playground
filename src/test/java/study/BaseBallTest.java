package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static study.InputView.validNumber;

public class BaseBallTest {
    CheckBall checkBall;
    final int INIT_NUMBER = 0;
    final int BALL = 0;
    final int STRIKE = 1;

    @BeforeEach
    void setUp() {
        checkBall = new CheckBall();
    }

    @DisplayName("사용자가 3글자의 정상적인 숫자를 입력했을 때 정상 여부를 판별한다.")
    @Test
    public void inputTestValid() {
        String input = "123"; // give
        assertThat(validNumber(input)).isEqualTo(true); // when, then
    }

    @DisplayName("사용자가 숫자 이외의 문자를 입력했을 때 정상 여부를 판별한다. 해당 경우 다시 입력하라는 메시지를 띄운다.")
    @Test
    public void inputTestInValid() {
        String input = "abc"; // give
        assertThat(validNumber(input)).isEqualTo(false); // when, then
    }

    @DisplayName("사용자가 숫자를 너무 짧게 입력했을 때 정상 여부를 판별한다. 해당 경우 다시 입력하라는 메시지를 띄운다.")
    @Test
    public void inputTestShort() {
        String input = "67"; // give
        assertThat(validNumber(input)).isEqualTo(false); // when, then
    }

    @DisplayName("사용자가 숫자를 너무 길게 입력했을 때 정상 여부를 판별한다. 해당 경우 다시 입력하라는 메시지를 띄운다.")
    @Test
    public void inputTestLong() {
        String input = "202411299"; // give
        assertThat(validNumber(input)).isEqualTo(false); // when, then
    }

    @DisplayName("string 문자열을 정수형 배열로 파싱 가능한지 확인한다.")
    @Test
    public void parseTest() {
        String input = "123";
        int[] output = {1,2,3}; // give
        assertThat(InputView.parseNumbers(input)).isEqualTo(output); // when, then
    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 숫자가 맞았지만 위치가 다른 경우에 대해 출력한다.")
    @Test
    public void ballTest() {
        int[] inputs = {3,5,1};
        int[] outputs = {1,3,5};
        int[] info = {INIT_NUMBER, INIT_NUMBER}; // give

        checkBall.checkScore(inputs, outputs, info); // when

        assertThat(info[BALL]).isEqualTo(3);
        assertThat(info[STRIKE]).isEqualTo(0); // then
    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 숫자가 맞았고 위치도 같은 경우에 대해 출력한다.")
    @Test
    public void strikeTest() {
        int[] inputs = {1,3,5};
        int[] outputs = {1,3,5};
        int[] info = {INIT_NUMBER, INIT_NUMBER}; // give

        checkBall.checkScore(inputs, outputs, info); // when

        assertThat(info[BALL]).isEqualTo(0);
        assertThat(info[STRIKE]).isEqualTo(3); // then
    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 숫자가 797과 같을 때 사용자가 797을 입력한 경우 '7'97과 79'7'을 비교한다.")
    @Test
    public void strikeComplexTest() {
        int[] inputs = {7,9,7};
        int[] outputs = {7,9,7};
        int[] info = {INIT_NUMBER, INIT_NUMBER}; // give

        checkBall.checkScore(inputs, outputs, info); // when

        assertThat(info[BALL]).isEqualTo(0);
        assertThat(info[STRIKE]).isEqualTo(3); // then
    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 숫자와 위치가 모두 같거나 위치만 다른 경우가 복합적인 경우에 대해 출력한다.")
    @Test
    public void ballStrikeTest() {
        int[] inputs = {1,3,5};
        int[] outputs = {5,3,1};
        int[] info = {INIT_NUMBER, INIT_NUMBER}; // give

        checkBall.checkScore(inputs, outputs, info); // when

        assertThat(info[BALL]).isEqualTo(2);
        assertThat(info[STRIKE]).isEqualTo(1); // then
    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 맞는 숫자가 단 하나도 없는 경우에 대해 출력한다.")
    @Test
    public void nothingTest() {
        int[] inputs = {1,3,5};
        int[] outputs = {2,4,6};
        int[] info = {INIT_NUMBER, INIT_NUMBER}; // give

        checkBall.checkScore(inputs, outputs, info); // when

        assertThat(info[BALL]).isEqualTo(0);
        assertThat(info[STRIKE]).isEqualTo(0); // then
    }

}
