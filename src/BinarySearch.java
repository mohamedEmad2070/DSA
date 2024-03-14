public class BinarySearch {
    static int binarySearch(int arr[], int first, int last, int key) {
        if (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                return binarySearch(arr, first, mid - 1, key);
            } else {
                return binarySearch(arr, mid + 1, last, key);
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 3, 4, 5, 6, 8, 9, 10, 11};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 3));//2
    }
}
