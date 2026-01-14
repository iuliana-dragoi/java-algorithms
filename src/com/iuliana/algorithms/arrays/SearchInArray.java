package com.iuliana.algorithms.arrays;

public class SearchInArray {

    // Linear search O(n) - check every element until you find the key.
    public static int serach(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary search O(log n) - split array in half to each step.
    public static int binarySearch(int[] arr, int target) {
        // {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if(arr[mid] == target) return mid;

            // Check which half is sorted
            if(arr[left] <= arr[mid]) { // left is sorted
                if(arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else { // right is sorted
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }


    static void main() {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target = 3;

        int index1 = serach(arr, target);
        int index2 = binarySearch(arr, target);
        System.out.println(index1 + " " + index2);
    }
}
