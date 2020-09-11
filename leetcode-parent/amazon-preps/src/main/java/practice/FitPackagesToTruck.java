package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Find two products that fit exactly into truck. Truck has to reserve exactly 30 space units.
 * 1. Pickup two packages
 * 2. You can not pick up one package twice.
 * 3. If you have multiple pairs, select pair with the largest package.
 * 4. There are at least two packages available.
 */
public class FitPackagesToTruck {
    public static List<Integer> getIdsOfPackages(int truckSpace, List<Integer> packagesSpace) {
        var sortedPackages = new HashMap<Integer, Integer>();
        for (int i = 0; i < packagesSpace.size(); i++) {
            sortedPackages.put(packagesSpace.get(i), i);
        }
        List<Integer> pair = new ArrayList<>();
        var maxPairWeight = 0;
        for (int i = 0; i < packagesSpace.size(); i++) {
            var packToCheck = truckSpace - 30 - packagesSpace.get(i);
            var secondIdx = sortedPackages.get(packToCheck);
            if (secondIdx != null && i != secondIdx) {
                var maxPackageInCurrPair = Math.max(packToCheck, packagesSpace.get(i));
                if (maxPackageInCurrPair > maxPairWeight){
                    maxPairWeight = maxPackageInCurrPair;
                    pair = List.of(i, secondIdx);
                }
            }
        }
        return pair;
    }
}
