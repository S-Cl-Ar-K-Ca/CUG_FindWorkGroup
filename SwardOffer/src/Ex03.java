/*
* 剑指offer第三题，有序二维数组的查找
* */
public class Ex03 {
    public static boolean findNumbei(int arr[],int rows,int columns,int number){
        boolean res = false;
        if(arr!=null && rows > 0 && columns > 0){
            int row = 0;
            int column = columns-1;
            while (row < rows && column >= 0){
                if(arr[row*columns+columns] == number){
                    res = true;
                    break;
                }else if(number < arr[row*columns+columns]){
                    column--;
                }else {
                    row++;
                }
            }
        }
        return res;
    }

    public static boolean findNumberV2(int arr[],int rows,int columns,int number){
        boolean res = false;
        if( arr!=null && rows>0 && columns>0){
            int row = 0;
            int column = columns-1;
            while (row < rows && column>=0){
                if(arr[row*columns+column] == number){
                    res = true;
                    break;
                }else if(number > arr[row*columns+column]){
                    row++;
                }else {
                    column--;
                }
            }
        }
        return res;
    }
}
