package io.icyhins.easy;

/**
 * @author Silver.Kan
 * @date 2018/7/22
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,0};
        int m = 1;

        int[] nums2 = new int[]{1};
        int n = 1;

        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        mergeSortedArray.merge(nums1,m,nums2,n);


    }

    /**
     * 解题思路，
     *  双指针比较，放到 result 数组中
     *  空间 O(m+n) 时间 O(mn)
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // side case
        if(m==0){
            for(int i=0;i<m+n;i++){
                nums1[i]=nums2[i];
            }
            return;
        }else if(n==0){
            return;
        }
        //临时数组保存nums1
        int[] temp1 = new int[m];
        for(int i=0; i<m; i++){
            temp1[i] = nums1[i];
        }


        // 双指针
        int p1=0,p2=0;

        // reuslt 数组
        int i = 0;

        // 遍历 nums1 nums2 数组
        while(p1 < m && p2 < n){
            if( temp1[p1] <= nums2[p2]){
                nums1[i] = temp1[p1];
                i++;p1++;
            }else {
                nums1[i] = nums2[p2];
                i++;p2++;
            }
        }

        // 结尾部分
        while(p1 < m){
            nums1[i] = temp1[p1];
            i++;p1++;
        }

        while(p2 < n){
            nums1[i] = nums2[p2];
            i++;p2++;
        }


    }

    /**
     * 大神 annafan 3行代码方案
     * 从后面填充， 避免临时数组保存A[]
     *
     *
     * */
    public void merge2(int A[], int m, int B[], int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
        while (j>-1)         A[k--]=B[j--];
    }
}
