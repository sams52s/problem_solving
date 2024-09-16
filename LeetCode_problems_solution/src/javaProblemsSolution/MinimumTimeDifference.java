package javaProblemsSolution;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
        public int findMinDifference(List<String> timePoints) {
            int[] minutes = new int[timePoints.size()];
            for (int i = 0; i < timePoints.size(); i++) {
                String[] split = timePoints.get(i).split(":");
                int hourInMinute = Integer.parseInt(split[0]) * 60;
                int minute = Integer.parseInt(split[1]);
                minutes[i] = hourInMinute + minute;
            }
            Arrays.sort(minutes);
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < minutes.length - 1; i++) {
                ans = Math.min(ans, minutes[i + 1] - minutes[i]);
            }
            return Math.min(
                    ans,
                    24 * 60 - minutes[minutes.length - 1] + minutes[0]
            );
        }
    }
