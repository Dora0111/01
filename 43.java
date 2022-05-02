class Solution {
    public int search(int[] arr, int target) {
        int len = arr.length, l = 0, r = len -1;
        while(r > 0 && arr[0] == arr[r]) r--;//恢复二段性
        //1.二分找到旋转点
        while(l < r){
            int mid = l + r + 1 >> 1;
            if (arr[mid] >= arr[0]) l = mid;
            else r = mid - 1;
        }
        //2.进入有序段（左或右）再次进行二分查找 targer
        if (target >= arr[0]) l = 0;
        else{
            l++;
            r = len - 1;
        }
        while(l < r){
            int mid = l + r >> 1;
            if (arr[mid] >= target) r = mid;//左边界用 right
            else l = mid + 1;
        }
        return arr[r] == target ? r : -1;
    }
}
