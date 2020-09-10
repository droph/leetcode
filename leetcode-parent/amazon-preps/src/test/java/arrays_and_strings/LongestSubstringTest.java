package arrays_and_strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstringTest {
    private static Stream<Arguments> provideTestParams() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("idvedf", 4),
                Arguments.of("", 0)
        );
    }

    @MethodSource("provideTestParams")
    @ParameterizedTest
    public void shouldReturnResultAccordingToParams(String string,
                                                    int count) {
        assertThat(LongestSubstring.lengthOfLongestSubstring(string))
                .isEqualTo(count);
    }
}