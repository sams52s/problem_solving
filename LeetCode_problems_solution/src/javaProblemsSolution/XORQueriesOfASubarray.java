package javaProblemsSolution;

public class XORQueriesOfASubarray {

        public int[] xorQueries(int[] arr, int[][] queries) {
            for(int i = 1; i < arr.length; i++){
                arr[i] ^= arr[i-1];
            }
            int[] res=new int[queries.length];
            for(int i =0; i < queries.length; i++){
                int total = queries[i][0], remove = queries[i][1];
                res[i] = total > 0 ? arr[remove] ^ arr[total - 1] : arr[remove];
            }
            return res;
        }

}
