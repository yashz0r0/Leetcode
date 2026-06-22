// Last updated: 23/06/2026, 00:00:42
import java.util.*;

class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;

        // Pair cost and capacity
        int[][] machines = new int[n][2];
        for (int i = 0; i < n; i++) {
            machines[i][0] = costs[i];
            machines[i][1] = capacity[i];
        }

        // Sort by cost
        Arrays.sort(machines, Comparator.comparingInt(a -> a[0]));

        // Prefix max of capacity
        int[] prefMax = new int[n];
        prefMax[0] = machines[0][1];
        for (int i = 1; i < n; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], machines[i][1]);
        }

        int ans = 0;

        // Case 1: single machine
        for (int i = 0; i < n; i++) {
            if (machines[i][0] < budget) {
                ans = Math.max(ans, machines[i][1]);
            }
        }

       
        for (int i = 1; i < n; i++) {
            int remaining = budget - machines[i][0];
            if (remaining <= 0) continue;

            int j = binarySearch(machines, i - 1, remaining);
            if (j >= 0) {
                ans = Math.max(ans, machines[i][1] + prefMax[j]);
            }
        }

        return ans;
    }

    private int binarySearch(int[][] machines, int hi, int target) {
        int lo = 0, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (machines[mid][0] < target) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
