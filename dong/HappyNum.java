package com.dong;

/**
 * Autor : dong
 * Time:2018/12/5
 */
//不是快乐数的数称为不快乐数（unhappy number），所有不快乐数的数位平方和计算，
// 最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。
public class HappyNum {
    public static int isHappyNum(int num){
        int res = 0;
        if(num / 100 > 9 || num == 0){
            System.out.println("参数必须是十进制的三位数");
            return 0;
        }
        int unitsDight = num % 100 % 10;//个位数
        int tenDight= num % 100 / 10;//十位数
        int hundredDight = num / 100;//百位数
        int sum = unitsDight * unitsDight + tenDight * tenDight + hundredDight * hundredDight;
        if(sum==1){
            res=1;//确认是快乐数，返回1
        }else if(sum == 4){
            res =-1;//确认是不快乐树，返回-1
        }else{
            return isHappyNum(sum);
        }
        return res;
    }

    public static void main(String[] args){
        int res = isHappyNum(999);
        System.out.println(res);
    }
}

