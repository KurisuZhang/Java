import java.util.HashMap;
import java.util.Map;

public class RouterProblem {

    public static int getServedBuildings(int[] buildingCount, int[] routerLocation, int[] routerRange) {
        int n = buildingCount.length;
        Map<Integer, Integer> coverageMap = new HashMap<>();

        // counter the range
        for (int j = 0; j < routerLocation.length; j++) {
            int start = Math.max(0, routerLocation[j] - routerRange[j] - 1);
            int end = Math.min(n - 1, routerLocation[j] + routerRange[j] - 1);

            for (int k = start; k <= end; k++) {
                coverageMap.put(k, coverageMap.getOrDefault(k, 0) + 1);
            }
        }

        // Count the number of served buildings
        int servedBuildings = 0;
        for (int i = 0; i < n; i++) {
            int coverage = coverageMap.getOrDefault(i, 0);
            System.out.print("Building: " + (i+1) + "   ");
            System.out.print("Router count:  " + coverage +  "   ");
            System.out.print("Tenant count:  " + buildingCount[i] + "   ");

            if (coverage >= buildingCount[i]) {
                System.out.println("Server:  yes");
                servedBuildings++;
            }else{
                System.out.println("Server:  no");
            }
            
        }

        return servedBuildings;
    }

    public static void main(String[] args) {
        int[] buildingCount = {1, 2, 1, 2, 2};
        int[] routerLocation = {3, 1};
        int[] routerRange = {1, 2};

        int result = getServedBuildings(buildingCount, routerLocation, routerRange);
        System.out.println("result: " + result);
    }
}
