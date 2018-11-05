//方法的重载
//每个方法的参数类型或数量不一样。
class OverloadDemo{
	void test(){
		System.out.println("No parameter.");
	}
	void test(int a){
		System.out.println("a: " + a);
	}
	void test(int a,int b){
		System.out.println("a and b: " + a + " " + b);
	}
	double test(double a){
		System.out.println("double a: " + a);
		return a * a;
	}
}
class Overload{
	public static void main(String [] args){
		OverloadDemo ob = new OverloadDemo();
		double result;
		ob.test();
		ob.test(10);
		ob.test(1,2);
		result = ob.test(13.3);
		System.out.println("Result of ob.test(13.3):" + result);
	}
}