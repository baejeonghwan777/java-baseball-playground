package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void seperate() {
        String[] number = "1,2".split(",");
        assertThat(number).contains("1","2");
    }

    @Test
    void seperate2() {
        String[] number = "1".split(",");
        assertThat(number).containsExactly("1");
    }

    @Test
    void remove() {
        String number = "(1,2)".substring(1,4);
        assertThat(number).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 추출 테스트")
    void extract() {
        int num = 2;
        String str = "abc";
        if(num < 0 || num >= str.length()) {
            throw new IndexOutOfBoundsException();
        } else if(num >= 0 && num < str.length()) {
            char actual = str.charAt(num);
        }
    }

}
