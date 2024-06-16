package s21_S;

public class Main{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = 0, n = nums1.length, m = nums2.length, len = n + m, j = 0, i = 0, nextnum = 0;
        for(int k = 0; k < len; k++){
            if(i < n && j < m)
                if(nums1[i] > nums2[j]){
                    nextnum = nums2[j];
                    j++;
                }else{
                    nextnum = nums1[i];
                    i++;
                }
            else if(i < n)
            {nextnum = nums1[i];
                i++;
            }
            else {
                nextnum = nums2[j];
                j++;
            }
            if(len % 2 != 0 && k == len / 2){
                return nextnum;
            }
            if(len%2 == 0 && (k == (len / 2) || k == (len / 2 - 1)))
                sum += nextnum;
            if(len%2 == 0 && k == (len / 2 + 1)) return sum * 1.0 / 2;
        }
        return 0;
    }
        public static void main(String[] args) {
        int[]a = {1,2};
        int[]b = {2,3};
            System.out.println(findMedianSortedArrays(a,b));

        }
    }