package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void seperate() {
        String[] number = "1,2".split(",");
        assertThat(number).contains("1", "2");
    }

    @Test
    void seperate2() {
        String[] number = "1".split(",");
        assertThat(number).containsExactly("1");
    }

    @Test
    void remove() {
        String number = "(1,2)".substring(1, 4);
        assertThat(number).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 원하는 하나의 문자를 추출해낸다. 정상적으로 추출이 성공하였는지 비교한다.")
    void extractNormal() {
        int index = 2;
        String value = "abc";
        char actual = value.charAt(index);
        assertThat(actual).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열에서 원하는 하나의 문자를 추출해낸다. 정상적으로 추출이 성공하지 못해 예외를 발생시킨다.")
    void extractOdd() {
        int index = 3;
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index); // 수정된 부분
    }

}
