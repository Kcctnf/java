class Person{
    public void print(){
    System.out.println("1.我是爸爸！");
    }
}
class Student extends Person{
    public void print(){
        System.out.println("2.我是儿子！");
	}
	public void fun(){
		System.out.println("只有儿子有");
	}
}
public class Test3{
    public static void main(String[] args) {
		Student stu = new Student();
		stu.print();
    /*//向下转型
	Person per = new Student(); //向上转型
    per.print();
	Student stu = (Student)per;
	stu.fun();*/
    }
}