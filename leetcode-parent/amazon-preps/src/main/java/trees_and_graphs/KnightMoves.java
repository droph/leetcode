package trees_and_graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KnightMoves {
    public int minKnightMoves(int x, int y) {
        var visited = new HashSet<String>();

        var combinations = List.of(List.of(2,1), List.of(2,-1), List.of(-2,1), List.of(-2,-1),List.of(1,2),List.of(-1,2),List.of(1,-2),List.of(-1,-2));

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(0, 0, 0));
        visited.add("" + 0 + "-" + 0);
        while(!queue.isEmpty()){
            var position = queue.poll();
            var currY = position.get(0);
            var currX = position.get(1);
            System.out.println("Checking Y " + currY + " and X " + currX);
            var currSteps = position.get(2);
            if(currY == y && currX == x){
                return currSteps;
            }
            for(List<Integer> combination : combinations){
                var yToGo = currY + combination.get(0);
                if((y >= 0 && yToGo < y + 4) || (y < 0 && yToGo > y - 4)){
                    var xToGo = currX + combination.get(1);
                    if((x >= 0 && xToGo < x + 4) || (x < 0 && xToGo > x - 4)) {
                        var visitedKey = "" + yToGo + "-" + xToGo;
                        if(!visited.contains(visitedKey)){
                            visited.add(visitedKey);
                            queue.offer(List.of(yToGo, xToGo, currSteps + 1));
                        }
                    }
                }
            }

        }
        return -1;
    }
}
