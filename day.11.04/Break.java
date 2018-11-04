public class Break{
	public static void main(String [] args){
		boolean a = true;
		first:{
			second:{
				third:{
					System.out.println("before the break!");
					if(a) break second;
					System.out.println("this is execute!");
				}
				System.out.println("this is execute!");
			}
			System.out.println("this is after second block!");
		}
	}
}