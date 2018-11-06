public class Person{
	//封装之后在别的类无法访问，只能通过写方法来访问。
	private String gender;
	private String name;
	private int age;
	private String secret = "*****";
	
	//构造方法：方法名与类名一样   没有返回值
	public Person(){
		//试试不加这个，编译结果如何？
	}
	public Person(String name,int age){
		//当前这个对象
		this.name =name;
		this.age = age;
	}
	public Person(String name,int age,String gender){
		this(name,age);
		this.gender = gender;
	}
	
	
	//访问的方法
	String getSecret(){
		return secret + "!!";
	}
	
	String getName(){
		return name;
	}
	int getAge(){
		return age;
	}
	//setter
	
	
	String personInfo(){
		return "这个人叫" + name + "年龄" + age;
	}
	
	public static void main(String [] args){
		Person person = new Person();//创建对象。
		//对对象进行赋值。
		person.name = "jack";
		person.age = 25;
		System.out.println(person.personInfo());
		
		Person person2 = new Person("aclic",22);
		
		
		System.out.println(person.personInfo());
		System.out.println(person2.personInfo());
	}
	
}







