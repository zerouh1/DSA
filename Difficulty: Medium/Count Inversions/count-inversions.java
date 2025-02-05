//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
         int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }
    static int mergeSort(int arr[], int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            count += mergeSort(arr, left, mid);     // Count inversions in left half
            count += mergeSort(arr, mid + 1, right); // Count inversions in right half
            count += merge(arr, left, mid, right);  // Merge two halves and count cross inversions
        }
        return count;
    }

    // Merge function to count cross inversions
    static int merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        // Copying data into temp arrays
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left, swaps = 0;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (n1 - i); // Counting inversions
            }
        }

        // Copy remaining elements of leftArr[], if any
        while (i < n1)
            arr[k++] = leftArr[i++];

        // Copy remaining elements of rightArr[], if any
        while (j < n2)
            arr[k++] = rightArr[j++];

        return swaps;
    }
}