package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static study.InputView.validNumber;

public class BaseBallTest {
    CheckBall checkBall;
    Ball ball;
    final int BALL = 0;
    final int STRIKE = 1;

    @BeforeEach
    void setUp() {
        ball = new Ball(new int[]{0, 0}, true, 0);
        checkBall = new CheckBall(ball);
    }

    @DisplayName("객체를 생성하고 객체에 변수가 제대로 대입되었는지 판단한다.")
    @Test
    public void objectGenerateValid() {
        Ball balltest; // give
        balltest = new Ball(new int[]{1, 2}, true, 2); // when

        assertAll(
                () -> assertThat(balltest.info[BALL]).isEqualTo(1),
                () -> assertThat(balltest.info[STRIKE]).isEqualTo(2),
                () -> assertThat(balltest.initializer).isEqualTo(true),
                () -> assertThat(balltest.score).isEqualTo(2) // then
        );
    }

    @DisplayName("사용자가 3글자의 정상적인 숫자를 입력했을 때 정상 여부를 판별한다.")
    @Test
    public void inputTestValid() {
        String input = "123"; // give
        boolean result = validNumber(input); // when
        assertThat(result).isEqualTo(true); // then
    }

    @DisplayName("사용자가 숫자 이외의 문자를 입력했을 때 정상 여부를 판별한다. 해당 경우 다시 입력하라는 메시지를 띄운다.")
    @Test
    public void inputTestInValid() {
        String input = "abc"; // give
        boolean result = validNumber(input); // when
        assertThat(result).isEqualTo(false); // then
    }

    @DisplayName("사용자가 0을 포함하여 입력했을 때 정상 여부를 판별한다. 해당 경우 다시 입력하라는 메시지를 띄운다.")
    @Test
    public void inputTestInValidZero() {
        String input = "010"; // give
        boolean result = validNumber(input); // when
        assertThat(result).isEqualTo(false); // then
    }

    @DisplayName("사용자가 똑같은 숫자를 2개 이상 입력했을 때 정상 여부를 판별한다.")
    @Test
    public void inputTestInValidDuplicate() {
        String input = "313"; // give
        boolean result = validNumber(input); // when
        assertThat(result).isEqualTo(false); // then
    }

    @DisplayName("사용자가 숫자를 너무 짧게 입력했을 때 정상 여부를 판별한다. 해당 경우 다시 입력하라는 메시지를 띄운다.")
    @Test
    public void inputTestShort() {
        String input = "67"; // give
        boolean result = validNumber(input); // when
        assertThat(result).isEqualTo(false); // then
    }

    @DisplayName("사용자가 숫자를 너무 길게 입력했을 때 정상 여부를 판별한다. 해당 경우 다시 입력하라는 메시지를 띄운다.")
    @Test
    public void inputTestLong() {
        String input = "202411299"; // give
        boolean result = validNumber(input); // when
        assertThat(result).isEqualTo(false); // then
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
        int[] outputs = {1,3,5}; // give

        checkBall.checkScoreInput(inputs, outputs); // when

        assertAll(
                () -> assertThat(ball.info[BALL]).isEqualTo(3),
                () -> assertThat(ball.info[STRIKE]).isEqualTo(0) // then
        );
    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 숫자가 맞았고 위치도 같은 경우에 대해 출력한다.")
    @Test
    public void strikeTest() {
        int[] inputs = {1,3,5};
        int[] outputs = {1,3,5}; // give

        checkBall.checkScoreInput(inputs, outputs); // when

        assertAll(
                () -> assertThat(ball.info[BALL]).isEqualTo(0),
                () -> assertThat(ball.info[STRIKE]).isEqualTo(3) // then
        );
    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 숫자와 위치가 모두 같거나 위치만 다른 경우가 복합적인 경우에 대해 출력한다.")
    @Test
    public void ballStrikeTest() {
        int[] inputs = {1,3,5};
        int[] outputs = {5,3,1}; // give

        checkBall.checkScoreInput(inputs, outputs); // when

        assertAll(
                () -> assertThat(ball.info[BALL]).isEqualTo(2),
                () -> assertThat(ball.info[STRIKE]).isEqualTo(1) // then
        );
    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 맞는 숫자가 단 하나도 없는 경우에 대해 출력한다.")
    @Test
    public void nothingTest() {
        int[] inputs = {1,3,5};
        int[] outputs = {2,4,6}; // give

        checkBall.checkScoreInput(inputs, outputs); // when

        assertAll(
                () -> assertThat(ball.info[BALL]).isEqualTo(0),
                () -> assertThat(ball.info[STRIKE]).isEqualTo(0) // then
        );
    }

}
