class Person{
	static { 
    //定义在非主类中的静态块
    System.out.println("3.Person类的静态块");
    }
	{ 
    //定义在类中，不加任何修饰符，构造块
    System.out.println("1.Person类的构造块");
    }
	public Person(){
    System.out.println("2.Person类的构造方法");
    }
}
public class Test{
	public static void main(String[] args) {
    System.out.println("--start--");
    new Person();
    new Person();
    System.out.println("--end--");
    }
}

/*public class Test{
	//静态块优先于主方法执行，代码块在构造方法前边执行。
	//静态块优先于构造块执行。
    //无论产生多少实例化对象，静态块都只执行一次。
	static{
		System.out.println("Test的静态块");
	}
	{
		System.out.println("Test的构造块");
	}
	public Test(){
		System.out.println("Test的构造方法");
	}
	public static void main(String[] args){
		System.out.println("----satrt----");
		new Test();
		new Test();
		System.out.println("----end----");
	}
}*/