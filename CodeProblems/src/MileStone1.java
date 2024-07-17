import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MileStone1 {
    public static void main(String[] args) {
        int maxTravelDist1 = 7000;
        int[][] forwardRouteList1 = {{1, 2000}, {2, 4000}, {3, 6000}};
        int[][] returnRouteList1 = {{1, 2000}};

        int maxTravelDist2 = 10000;
        int[][] forwardRouteList2 = {{1, 3000}, {2, 5000}, {3, 7000}, {4, 10000}};
        int[][] returnRouteList2 = {{1, 2000}, {2, 3000}, {3, 4000}, {4, 5000}};

        printOptimalPairs(findOptimalPairs(maxTravelDist1, forwardRouteList1, returnRouteList1));
        printOptimalPairs(findOptimalPairs(maxTravelDist2, forwardRouteList2, returnRouteList2));
    }

    public static List<int[]> findOptimalPairs(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
        Arrays.sort(forwardRouteList, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(returnRouteList, (a, b) -> Integer.compare(a[1], b[1]));

        List<int[]> result = new ArrayList<>();
        int maxDist = -1;

        int i = 0;
        int j = returnRouteList.length - 1;

        while (i < forwardRouteList.length && j >= 0) {
            int currentDist = forwardRouteList[i][1] + returnRouteList[j][1];

            if (currentDist > maxTravelDist) {
                j--;
            } else {
                if (currentDist >= maxDist) {
                    if (currentDist > maxDist) {
                        result.clear();
                        maxDist = currentDist;
                    }
                    result.add(new int[]{forwardRouteList[i][0], returnRouteList[j][0]});

                    // Check for previous elements with the same distance in returnRouteList
                    while (j - 1 >= 0 && returnRouteList[j][1] == returnRouteList[j - 1][1]) {
                        result.add(new int[]{forwardRouteList[i][0], returnRouteList[--j][0]});
                    }
                }
                i++;
            }
        }

        return result;
    }

    public static void printOptimalPairs(List<int[]> pairs) {
        for (int[] pair : pairs) {
            System.out.print(Arrays.toString(pair) + " ");
        }
        System.out.println();
    }
}

