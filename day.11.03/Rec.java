//计算阶乘,对于数据类型进行评估，如果计算60的阶乘显然无法计算。
public class Rec{
	public static int computer(int x){
		if(x == 1){
			return 1;
		}else{
		    return x * computer(x - 1);
		}
	}
	
	public static void main(String [] args){
		int num = computer(5);
		System.out.print(num);
	}
	
}
//NPE   错误肯定是有一个地方使用了null来调用方法。
public class Rec{
	public static void main(String [] args){
		int [] a ={1,2,3,4,5};//静态初始化
		int [] a = new int[]{1,2,3,4,5};//静态初始化
		
		
		//匿名数组
		System.out.println(new int[]{1,2,3}.length);
		
		
		
		int [] arr = new int [8];//动态初始化
		for(int i = 0;i < arr.length;++i){
			arr[i] = i;
			System.out.print(arr[i]);
		}
		String [] arr1 = new String [8];
		
	}
}








