package unionfind;

public class BinarySearch {

    
    int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        
        while (low <= high) {
            int mid = low + (high-low)/2;
            
            if (key < arr[mid])
                high = mid-1;
            if (key > arr[mid])
                low = mid+1;
            else return mid;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {

    }
}
