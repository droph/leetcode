package arrays_and_strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTest {

    private static Stream<Arguments> provideTestParams() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, List.of(0, 1)),
                Arguments.of(new int[]{2, 7, 6, 3, 10}, 13, List.of(1, 2)),
                Arguments.of(new int[]{3, 2, 4}, 6, List.of(1, 2)),
                Arguments.of(new int[]{3, 3}, 6, List.of(0, 1)),
                Arguments.of(new int[]{3, 4}, 6, List.of()),
                Arguments.of(new int[]{3}, 6, List.of()),
                Arguments.of(new int[]{}, 6, List.of()),
                Arguments.of(null, 6, List.of())
        );
    }

    @MethodSource("provideTestParams")
    @ParameterizedTest
    public void shouldReturnResultAccordingToParams(int[] nums,
                                                    int target,
                                                    List<Integer> expectedResult) {
        assertThat(TwoSum.calculate(nums, target))
                .containsExactlyElementsOf(expectedResult);
    }
}