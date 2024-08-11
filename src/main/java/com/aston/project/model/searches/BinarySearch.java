package com.aston.project.model.searches;

import java.util.Comparator;

public class BinarySearch {
    public <T> int search(T[] arr, T key, Comparator<T> comparator) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int resultOfCompare = comparator.compare(arr[mid], key);
            if (resultOfCompare == 0) {
                return mid;
            } else if (resultOfCompare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
