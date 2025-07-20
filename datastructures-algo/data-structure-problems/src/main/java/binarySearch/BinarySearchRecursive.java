package binarySearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinarySearchRecursive {
    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    private static int binarySearch(int[] arr, int target, int initialIndex, int length) {
        if (initialIndex > length) {
            return -1; // Target not found
        }
        int mid = initialIndex + (length - initialIndex) / 2;
        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, length); // Search in the right half
        } else {
            return binarySearch(arr, target, initialIndex, mid - 1); // Search in the left half
        }
    }
}
//
//    private static int binarySearch(int[] arr, int target, int left, int right) {
//        if (left > right) {
//            return -1; // Target not found
//        }
//
//        int mid = left + (right - left) / 2;
//
//        if (arr[mid] == target) {
//            return mid; // Target found
//        } else if (arr[mid] < target) {
//            return binarySearch(arr, target, mid + 1, right); // Search in the right half
//        } else {
//            return binarySearch(arr, target, left, mid - 1); // Search in the left half
//        }
//    }


