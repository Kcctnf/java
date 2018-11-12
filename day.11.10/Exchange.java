public class Exchange{
	public static void change(int a,int b){
		int c;
		c = a;
		a = b;
		b = c;
		System.out.println(a);
		System.out.println(b);
	}
	public static void main(String[] args){
		int a = 5;
		int b = 4;
		change(a,b);
	}
}
