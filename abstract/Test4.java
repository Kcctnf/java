//抽象类
abstract class Person{
	private String name;
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	//抽象方法不包含方法体
	public abstract void getPersonInfo();
}
class Student extends Person{
	public void getPersonInfo(){
		System.out.println("I am a student");
	}
}
public class Test4{
	public static void main(String[] args){
		Person per = new Student();//实例化对象，向上转型
		per.getPersonInfo();//被子类所覆写的方法
	}
}

