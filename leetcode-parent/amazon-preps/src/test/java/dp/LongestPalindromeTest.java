package dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindromeTest {
    private static Stream<Arguments> provideTestParams() {
        return Stream.of(
                Arguments.of("babad", "aba"),
                Arguments.of("cbbd", "bb"),
                Arguments.of("cbed", "d"),
                Arguments.of("ololopreerp", "preerp")
        );
    }

    @MethodSource("provideTestParams")
    @ParameterizedTest
    public void shouldReturnResultAccordingToParams(String string,
                                                    String result) {
        assertThat(LongestPalindrome.longestPalindrome(string))
                .isEqualTo(result);
    }
}