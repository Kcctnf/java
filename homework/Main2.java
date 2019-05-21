package homework;

/**
 * Author : dong
 * Time:2019/5/21
 */
public class Main2 {
    public static int findKth(int[] a, int n, int k) {
        return findKth(a,0,n - 1,k);
    }
    public static int findKth(int[] a,int low,int high,int k){
        int part = partation(a,low,high);

        if(k == part - low + 1){
            return a[part];
        }else if(k > part - low + 1){
            return findKth(a,part + 1,high,k - part + low -1);
        }else{
            return findKth(a,low,part - 1,k);
        }
    }
    public static int partation(int[] a,int low,int high){
        int key = a[low];
        while(low < high){
            while(low < high && a[high] <= key){
                high--;
            }
            a[low] = a[high];
            while(low < high && a[high] >= key){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }

    public static void main(String[] args) {

        int[] a = {3,5,7,3,1};
        int b = findKth(a,5,3);
        System.out.println(b);
    }

}
