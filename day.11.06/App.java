public class App{
	//如果没有创建构造方法，Java自动定义一个
	//如果自己构造，Java就不自己构造
	
	
	
	
	//getter   可以访问到Person属性
	//setter    可以在这个类中重新对Person中对象赋值
	
	public static void main(String [] args){
		//对象一
		Person person = new Person("jack",21);
		//仅仅能够从Person里边访问属性，但不能重新赋值。
		System.out.println(person.getSecret());
	}
}