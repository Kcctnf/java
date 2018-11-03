 // public class Alg{
	// public static void main(String [] args){
		// int x = 1;
		// int y = 2;
		// int z = 5;
		// int m = x > y ? x : (y > z) ? y : z;
		
		// //短路运算,相当于是求与时，第一个是false  结果就是false
	// }
// }

// import java.io.IOException;
// public class Alg{
	// public static void main(String [] args) throws IOException{
		// //String pgname = args[0];
		
		// System.out.println("请输入一个字符：");
		// char c = (char)System.in.read();
		
	// }
// }
//乘法口诀表
// public class Alg{
	// public static void main(String [] args){
		// int row = 0;
		// int col = 0;
		// for(row = 1;row < 10;++row){
			// for(col = 1;col <= row;++col){
			// System.out.print(row + "*" + col + "=" + (row * col)+"\t"); 	
			// }
			// System.out.println();
		// }
	// }
// }  
public class Alg{
	public static void main(String [] args){
		int line = 10;
		for(int i = 0;i < line;++i){
			for(int j = 0;j < line - i;++j){
				System.out.print(" ");
			}
			for(int z = 0;z < i;++z){
				//System.out.print("* ");
				System.out.print("**");
			}
			System.out.println(" ");
		}
	}
}














