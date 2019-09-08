import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XiaoMiSolution {
    static int solution(int[] prices, int budget) {
        int res = 0;
        Arrays.sort(prices);
        if( budget < prices[0]){
            return -1;
        }

            for (int i = prices.length-1; i >= 0 ; i--) {
                res = res + budget/prices[i];
                budget = budget % prices[i];
                if(budget < prices[0]){
                    break;
                }
            }
            return res;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
