/*class Person{
	public void print(){
		System.out.println("I am father");
	}
}
class Student extends Person{
	public void print(){
		//使用super调用父类的同名方法。
		super.print();
		System.out.println("I am child");
	}
}
public class Test2{
	public static void main(String[] args){
	new Student().print();
    }
}*/


/*class Person{
	public String name = "爸爸";
	
}
class Student extends Person{
	public String name = "儿子";
	public void print(){
		System.out.println("super.name");
		System.out.println("this.name");
	}
}
public class Test2{
	public static void main(String[] args){
		new Student().print();
	}
}*/
class Person{
    public void print(){
    System.out.println("1.我是爸爸！");
    }
}
class Student extends Person{
    public void print1(){
    System.out.println("2.我是儿子！");
    }
}
public class Test2{
    public static void main(String[] args) {
    Person per = new Student(); //向上转型
    Person per1 = new Person();
	per.print();
    }
}












