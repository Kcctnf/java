//在进行继承的时候，子类会继承父类的所有结构。（包含私有属性、构造方法、普通方法）但是这个时
//候需要注意的是，所有的非私有操作属于显示继承（可以直接调用），所有的私有操作属于隐式继承
//（通过其他形式调用，例如setter或getter）
class Person{
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	} 
}
class Student extends Person{
	public void fun(){
		System.out.println(getName());
	}
}
public class Test4{
	public static void main(String[] args){
		Student student = new Student();
		student.setName("jack");
		System.out.println(student.getName());
		student.fun();
	}
}
//1. 继承的语法以及继承的目的（扩展已有类的功能，使代码重用）
//2. 子类对象的实例化流程：不管如何操作，一定要先实例化父类对象。
//3. 不允许多重继承，只允许多层继承。






