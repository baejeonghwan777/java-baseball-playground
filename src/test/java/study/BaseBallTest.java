package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallTest {

    @DisplayName("사용자가 3글자의 정상적인 숫자를 입력했을 때 정상 여부를 판별한다.")
    @Test
    public void inputTestValid() {

    }

    @DisplayName("사용자가 숫자 이외의 문자를 입력했을 때 정상 여부를 판별한다. 해당 경우 다시 입력하라는 메시지를 띄운다.")
    @Test
    public void inputTestInValid() {

    }

    @DisplayName("사용자가 숫자를 너무 짧게 입력했을 때 정상 여부를 판별한다. 해당 경우 다시 입력하라는 메시지를 띄운다.")
    @Test
    public void inputTestShort() {

    }

    @DisplayName("사용자가 숫자를 너무 길게 입력했을 때 정상 여부를 판별한다. 해당 경우 다시 입력하라는 메시지를 띄운다.")
    @Test
    public void inputTestLong() {

    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 숫자가 맞았지만 위치가 다른 경우에 대해 출력한다.")
    @Test
    public void ballTest() {

    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 숫자가 맞았고 위치도 같은 경우에 대해 출력한다.")
    @Test
    public void strikeTest() {

    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 숫자와 위치가 모두 같거나 위치만 다른 경우가 복합적인 경우에 대해 출력한다.")
    @Test
    public void ballStrikeTest() {

    }

    @DisplayName("컴퓨터가 제시한 숫자와 사용자가 제시한 숫자를 비교한다. 맞는 숫자가 단 하나도 없는 경우에 대해 출력한다.")
    @Test
    public void nothingTest() {

    }

    @DisplayName("게임 승리 조건을 확인한다.")
    @Test
    public void winTest() {

    }

    @DisplayName("게임 재시작 여부를 판별한다. Yes일 때,")
    @Test
    public void resetYes() {

    }

    @DisplayName("게임 재시작 여부를 판별한다. No일 때,")
    @Test
    public void resetNo() {

    }
}
