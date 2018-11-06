//女朋友----类
public class GrilFriend{
	//String   int[]    都为引用类型
	private String gender = "女"；//null
	private int age;//0
	private int height;//0
	//能够做的事情-----行为
	public void movie(){
		
	}
	public void fire(){
		
	}
	public static void main(String [] args){
		//女  名字   24    170-->具体信息
		GrilFriend grilfriend = new GrilFriend();
		grilfriend.gender = "女"；
		grilfriend.age = 24;
		grilfriend.height = 70;
		
		//结构化 叫函数
		//面向对象  对象  方法调用
		
		grilfriend.movie();
		grilfriend.fire();
		
	}
}
