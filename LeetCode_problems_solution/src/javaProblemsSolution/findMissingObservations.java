class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = n;
        for(int roll : rolls){
            m += roll;
        }
        int r = (mean * (n+rolls.length)) - m;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        if(r > n*5 || r < 0){
            return new int[0];
        }
        int i =0;
        while(r > 0){
            int increment = Math.min(r, 6 - result[i]);
            result[i] += increment;
            r -= increment;
            if(result[i]==6){
                i++;
            }
        } 
        return result;
    }
}
