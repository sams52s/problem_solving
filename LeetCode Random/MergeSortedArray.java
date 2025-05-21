import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

   private void merge(int[] nums1, int m, int[] nums2, int n) {
     int j =0;
        for(int i=m;i<nums1.length;i++){
            nums1[i]=nums2[j];
            j++;
        }
        Arrays.sort(nums1);
   }
}
