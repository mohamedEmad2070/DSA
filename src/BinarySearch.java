public class BinarySearch {
    static int binarySearch(int arr[], int key) {
        int first = 0;
        int last = arr.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                first = mid + 1;
                mid = (first + last) / 2;
            } else if (arr[mid] > key) {
                last = mid - 1;
                mid = (first + last) / 2;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 3, 4, 5, 6, 8, 9, 10, 11};
        System.out.println(binarySearch(arr,9));

    }
}
