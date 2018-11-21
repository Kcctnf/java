//面向对象的第二大特征：继承。继承的主要作用在于，在已有基础上继续进行功能的扩充。
//对类进行扩充和重用
class Person{
	private String name;
	private int age;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;		
	}
	public void setAge(int age){
	this.age = age;	
	}
}
class Student extends Person{
	private String school; //扩充的新属性
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
}
public class Test2{
	public static void main(String[] args){
		Student student = new Student();
		student.setName("steven");
		student.setAge(18);
		student.setSchool("西工院");
		System.out.println("姓名：" + student.getName() + "年龄：" + student.getAge() + 
		  "学校；" + student.getSchool());
	}
}











