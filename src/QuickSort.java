public class QuickSort {
    static int partitioning(int arr[], int l, int h) {
        int pivot = arr[l];
        int left = l + 1;
        int right = h;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        int temp = arr[l];
        arr[l] = arr[right];
        arr[right] = temp;
        return right;
    }
    static void quickSort(int arr[],int l,int h){
        if (l<h){
            int piv = partitioning(arr, l, h);
            quickSort(arr,l,piv);
            quickSort(arr,piv+1,h);
        }
    }

    public static void main(String[] args) {
        int arr[]= {5,2,3,7,8,0,9,1,4};
       quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}
