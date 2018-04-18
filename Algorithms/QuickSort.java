public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7,9,3,5,6,4,7,9,10,14};

		quicksort(arr, 0, 9);

        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void quicksort(int[] arr, int left, int right) {
        int idx = partition(arr, left, right);
        if(left < idx -1) {
            quicksort(arr, left, idx-1);
        }
        if(idx<right) {
            quicksort(arr, idx, right);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp;
        int pivot = arr[(right+left)/2];

        while(l<=r) {
            while(arr[l] < pivot) {
                l++;
            }
            while(arr[r] > pivot) {
                r--;
            }

            if(l<=r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
        return l;
    }
}
