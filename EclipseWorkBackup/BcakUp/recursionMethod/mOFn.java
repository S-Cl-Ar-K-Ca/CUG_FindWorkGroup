package recursionMethod;

public class mOFn {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int res[] = new int[3];
        selectMfromN(arr, 5, 3, res);
    }

    // 采用递归函数来解决组合问题
    public static void selectMfromN(int arr[], int n, int m, int res[]) {
        if (m == 0) {
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = n; i >= m; i--) {
            res[m - 1] = arr[i - 1];
            selectMfromN(arr, i - 1, m - 1, res);
        }
    }
}
