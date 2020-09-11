package practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Delivery {
    public static int minimunDistance(int numRows, int numColumns, List<List<Integer>> area) {
        var visited = new boolean[area.size()][area.get(0).size()];
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(0, 0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            var colRow = queue.poll();
            var col = colRow.get(0);
            var row = colRow.get(1);
            var distance = colRow.get(2);

            var cellValue = area.get(col).get(row);
            if (cellValue == 9) {
                return distance;
            }
            if (cellValue == 1) {
                if (col > 0 && !visited[col - 1][row]) {
                    queue.offer(List.of(col - 1, row, distance + 1)); // left
                    visited[col - 1][row] = true;
                }
                if (col < area.size() - 1 && !visited[col + 1][row]) {
                    queue.offer(List.of(col + 1, row, distance + 1)); // right
                    visited[col + 1][row] = true;
                }
                if (row > 0 && !visited[col][row - 1]) {
                    queue.offer(List.of(col, row - 1, distance + 1)); // up
                    visited[col][row - 1] = true;
                }
                if (row < area.get(col).size() - 1 && !visited[col][row + 1]) {
                    queue.offer(List.of(col, row + 1, distance + 1)); // down
                    visited[col][row + 1] = true;
                }
            }
        }
        return -1;
    }
}
