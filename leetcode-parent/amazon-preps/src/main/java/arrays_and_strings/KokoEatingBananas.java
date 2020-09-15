package arrays_and_strings;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {

        Arrays.sort(piles);
        if(piles.length == H){
            return piles[H - 1];
        }
        var minSpeed = 1;
        var maxSpeed = piles[piles.length - 1];

        while(maxSpeed > minSpeed){
            var midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
            if(!possibleToEatAll(piles, H, midSpeed)){
                minSpeed = midSpeed + 1;
            } else {
                maxSpeed = midSpeed;
            }
        }
        return minSpeed;
    }

    private boolean possibleToEatAll(int[] piles, int H, int speed) {
        var totalTime = 0;
        for(int pile : piles){
            totalTime += (pile / speed) + (pile % speed == 0 ? 0 : 1);
        }
        return totalTime <= H;
    }

    public static void main(String[] args) {
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }
}
