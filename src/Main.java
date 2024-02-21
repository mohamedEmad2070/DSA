public class Main {
    static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // 60 40 50 30 10 20
            int minIdx = i;//60
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {//40<60 true
                    minIdx = j;

                }
            }
            //Swap
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {60, 40, 50, 30, 10,20};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");//10 20 30 40 50 60
        }
    }


}
