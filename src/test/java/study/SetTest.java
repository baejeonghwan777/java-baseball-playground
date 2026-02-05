package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("숫자 집합의 사이즈를 체크한다.")
    void checkSize() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("1,2,3 값이 존재하는지 알아내기 위해 한꺼번에 검증한다. 즉 중복되는 코드를 방지한다.")
    void contains(int args) {
        assertThat(numbers.contains(args)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("1,2,3 혹은 4,5 둘중 어떤 값이 들어오냐에 따라 부울 값을 다르게 지정하고 결과를 확인한다.")
    void certificate(int args, boolean expected) {
        assertThat(numbers.contains(args)).isEqualTo(expected);
    }
}
