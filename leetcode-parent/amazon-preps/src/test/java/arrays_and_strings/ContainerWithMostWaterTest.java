package arrays_and_strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerWithMostWaterTest {
    private static Stream<Arguments> provideTestParams() {
        return Stream.of(
                Arguments.of(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                Arguments.of(new int[]{2, 3}, 2),
                Arguments.of(new int[]{2, 3, 3}, 4),
                Arguments.of(new int[]{}, 0)
        );
    }

    @MethodSource("provideTestParams")
    @ParameterizedTest
    public void shouldReturnResultAccordingToParams(int[] values,
                                                    int result) {
        assertThat(ContainerWithMostWater.maxArea(values))
                .isEqualTo(result);
    }
}