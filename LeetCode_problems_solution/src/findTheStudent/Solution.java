package findTheStudent;

//1894.find the student that will replace the chalk
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int c : chalk) sum += c;
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return k > 0 ? chalk.length : -1;
    }
}

