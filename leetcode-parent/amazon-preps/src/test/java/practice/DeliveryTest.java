package practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DeliveryTest {

    private static Stream<Arguments> provideTestParams() {
        return Stream.of(
                Arguments.of(3, 3,
                        new ArrayList<>(List.of(
                                List.of(1, 0, 0),
                                List.of(1, 0, 0),
                                List.of(1, 9, 1)
                        )), 3
                ),
                Arguments.of(3, 3,
                        new ArrayList<>(List.of(
                                List.of(1, 1, 1, 1, 1),
                                List.of(1, 0, 1, 1, 1),
                                List.of(1, 0, 9, 1, 1),
                                List.of(1, 1, 1, 1, 1),
                                List.of(1, 1, 1, 1, 1)
                        )), 4
                ),
                Arguments.of(3, 3,
                        new ArrayList<>(List.of(
                                List.of(1, 1, 1),
                                List.of(1, 1, 1),
                                List.of(1, 1, 9)
                        )), 4
                ),
                Arguments.of(2, 2,
                        new ArrayList<>(List.of(
                                List.of(9, 1),
                                List.of(1, 1)
                        )), 0
                ),
                Arguments.of(3, 3,
                        new ArrayList<>(List.of(
                                List.of(1, 9, 0),
                                List.of(1, 1, 0),
                                List.of(1, 0, 1)
                        )), 1
                ),
                Arguments.of(3, 3,
                        new ArrayList<>(List.of(
                                List.of(1, 1, 1),
                                List.of(1, 1, 9),
                                List.of(1, 1, 1)
                        )), 3
                ),
                Arguments.of(3, 3,
                        new ArrayList<>(List.of(
                                List.of(1, 1, 0),
                                List.of(1, 0, 9),
                                List.of(1, 1, 0)
                        )), -1
                ),
                Arguments.of(10, 10,
                        new ArrayList<>(List.of(
                                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 9)
                        )), 18
                ),
                Arguments.of(
                        1000, 1000,
                        getHugeList(1001, 1001), -1
                ),
                Arguments.of(
                        1000, 1000,
                        getHugeList(999, 999), 1998
                )
        );
    }

    private static List<List<Integer>> getHugeList(int colFor9, int rowFor9) {
        var collect = new ArrayList<List<Integer>>(1000);
        for (int i = 0; i < 1000; i++) {
            var list = new ArrayList<Integer>(1000);
            for (int j = 0; j < 1000; j++) {
                if (i == colFor9 && j == rowFor9) {
                    list.add(9);
                }
                list.add(1);
            }
            collect.add(list);
        }

        return collect;
    }

    @MethodSource("provideTestParams")
    @ParameterizedTest
    public void shouldReturnResultAccordingToParams(int numRows,
                                                    int numColumns,
                                                    List<List<Integer>> area,
                                                    int result) {
        assertThat(Delivery.minimunDistance(numRows, numColumns, area))
                .isEqualTo(result);
    }

}