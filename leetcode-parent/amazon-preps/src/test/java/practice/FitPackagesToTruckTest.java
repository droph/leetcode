package practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FitPackagesToTruckTest {
    private static Stream<Arguments> provideTestParams() {
        return Stream.of(
                Arguments.of(90, new ArrayList<>(List.of(1, 10, 25, 35, 60)), new ArrayList<>(List.of(2, 3))),
                Arguments.of(90, new ArrayList<>(List.of(60, 0)), new ArrayList<>(List.of(0, 1))),
                Arguments.of(90, new ArrayList<>(List.of(1, 10, 25, 35, 15, 45, 55, 5)), new ArrayList<>(List.of(6, 7)))
        );
    }

    @MethodSource("provideTestParams")
    @ParameterizedTest
    public void shouldReturnResultAccordingToParams(int truckSpace,
                                                    List<Integer> packages,
                                                    List<Integer> result) {
        assertThat(FitPackagesToTruck.getIdsOfPackages(truckSpace, packages))
                .containsExactlyElementsOf(result);
    }
}