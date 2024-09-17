package javaProblemsSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 +" "+ s2;
        String[] words = s.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        ArrayList<String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> mp: map.entrySet()){
            if(mp.getValue()==1){
                ans.add(mp.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }
}
