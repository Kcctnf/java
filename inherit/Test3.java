//子类对象实例化之前先实例化父类对象。
//实际上相当于在自累的构造方法中隐含了一个super()。
//如果在父类自中没有提供构造方法，那么就要使用super()指明你要调用父类的构造方法。		
class Person{
	public Person(){
		System.out.println("父类的对象");
	}
}
class Student extends Person{
	public Student(){
		super();//在无参时写与不写一样 。
		System.out.println("子类的对象");
	}
}
public class Test3{
	public static void main(String[] args){
		new Student();
	}
}



