//注意：当前使用的对象是哪个类new的。
//当你调用的方法已经被覆写时，调用的一定是覆写过的方法。
//public>protected>default>private这个是访问权限。

/*class Person{
	public void print(){
		System.out.println("这是Person类的方法");
	}
}
class Student extends Person{
	public void print(){
		System.out.println("这是Student类的方法");
	}
}
public class Test{
	public static void main(String[] args){
		Student student = new Student();
		student.print();
	}
}*/
class Person{
	public void fun(){
		this.print();
	}
	private void print(){
		//如果现在父类方法使用了private定义，那么就表示该方法只能被父类使用，子类无法使用。换言之，子类根
//本就不知道父类有这样的方法。
		System.out.println("Person类的print方法");
	}
}
class Student extends Person{
	//相当于这是一个新方法而已。
	public void print(){
		System.out.println("这是Studen的方法");
	}
}
public class Test{
	public static void main(String[] args){
		new Student().print();
		new Student().fun();
	}
}









