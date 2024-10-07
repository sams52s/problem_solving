package javaProblemsSolution.october;

import java.util.ArrayList;
import java.util.List;

public class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (!list.isEmpty()) {
                char last = list.get(list.size() - 1);
                if ((last == 'A' && c == 'B') || (last == 'C' && c == 'D')) {
                    list.remove(list.size() - 1);
                    continue;
                }
            }
            list.add(c);
        }
        return list.size();
    }
}
