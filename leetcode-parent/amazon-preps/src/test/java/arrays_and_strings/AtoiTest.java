package arrays_and_strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class AtoiTest {
    private static Stream<Arguments> provideTestParams() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("+1", 1),
                Arguments.of("   -42", -42),
                Arguments.of("  0000000000012345678", 12345678),
                Arguments.of("4193 with words", 4193),
                Arguments.of("words and 987", 0),
                Arguments.of("", 0),
                Arguments.of("   ", 0),
                Arguments.of("-91283472332", Integer.MIN_VALUE),
                Arguments.of("-2147483649", Integer.MIN_VALUE),
                Arguments.of("2147483649", Integer.MAX_VALUE),
                Arguments.of("91283472332123", Integer.MAX_VALUE)
        );
    }

    @MethodSource("provideTestParams")
    @ParameterizedTest
    public void shouldReturnResultAccordingToParams(String string,
                                                    int result) {
        assertThat(Atoi.calculateMyAtoi(string))
                .isEqualTo(result);
    }
}