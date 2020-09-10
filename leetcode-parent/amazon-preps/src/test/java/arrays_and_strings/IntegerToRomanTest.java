package arrays_and_strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerToRomanTest {
    private static Stream<Arguments> provideTestParams() {
        return Stream.of(
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(9, "IX"),
                Arguments.of(58, "LVIII"),
                Arguments.of(501, "DI"),
                Arguments.of(1994, "MCMXCIV"),
                Arguments.of(4444, "MMMMCDXLIV"),
                Arguments.of(2683, "MMDCLXXXIII"),
                Arguments.of(4998, "MMMMCMXCVIII"),
                Arguments.of(4999, "MMMMCMXCIX")

        );
    }

    @MethodSource("provideTestParams")
    @ParameterizedTest
    public void shouldReturnResultAccordingToParams(int values,
                                                    String result) {
        assertThat(IntegerToRoman.intToRoman(values))
                .isEqualTo(result);
    }

}