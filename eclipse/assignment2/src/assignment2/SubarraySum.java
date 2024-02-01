package assignment2;

import java.util.HashMap;

public class SubarraySum {

    public static boolean subarraySum(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (map.containsKey(sum - k)) {
                int j = map.get(sum - k);
                System.out.println("Subarray from " + (j+1) + " to " + i);
                return true;
            }
            map.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, -1, 5, -4, 5, 6, 7, 8};
        int k = 0;
        if (subarraySum(a, k)) {
            System.out.println("Found subarray with sum " + k);
        } else {
            System.out.println("No subarray with sum " + k);
        }
    }
}
