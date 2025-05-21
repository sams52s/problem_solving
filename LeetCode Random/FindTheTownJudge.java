public class FindTheTownJudge {
    public static void main(String[] args) {
        FindTheTownJudge solution = new FindTheTownJudge();
        int[][] trust = {{1, 3}, {2, 3},{2,4}};
        System.out.println(solution.findJudge(4, trust)); // Output: -1
    }
    /**
     * In a town, there are n people labeled from 1 to n.
     * Runtime 2ms
     * Memory 53.80MB
     * @param n
     * @param trust
     * @return
     */
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for (int[] t : trust) {
            System.out.println(t[0] + " " + t[1]);
            outdegree[t[0]]++;
            indegree[t[1]]++;
            System.out.println("outdegree[" + t[0] + "] = " + outdegree[t[0]]);
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
