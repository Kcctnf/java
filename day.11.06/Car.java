public class Car{
	
	private String brand;//品牌
	private int price;
	private String color;
	private int number;
	
//方法重载	
	public Car(){
		
	}
	public Car(String brand,int number){
		this.brand = "dazhong";
		this.number = 33431;
	}
	public Car(String brand,int number,String color){
		//this 这个调用要写在最开始。
		this(brand,number);
		this.color = "red";
	}
	public Car(String brand,int number,String color,int price){
		this(brand,number,color);
		this.price = 100000;
	}
	
	String CarInfo(){
		return "品牌:"+ brand + "价格:"+ price + "颜色:" + "red" + "车牌号:" + number;
	}
	
	
	public static void main(String [] args){
		Car car = new Car();
		car.brand = "DaZhong";
		System.out.println(car.CarInfo());
	}
	
	
}