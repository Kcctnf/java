// class Box{
	// double width;
	// double height;
	// double depth;
// } 
// class BoxDemo{
	// public static void main(String [] args){
		// Box mybox1 = new Box();
		// Box mybox2 = new Box();
		// double vol;
		// mybox1.width = 100;
		// mybox1.height = 10;
		// mybox1.depth = 15;
		// mybox2.width = 2;
		// mybox2.height = 3;
		// mybox2.depth = 4;
		// vol = mybox1.width * mybox1.height * mybox1.depth;
		// System.out.println("vol is:" +vol);
		// vol = mybox2.width * mybox2.height * mybox2.depth;
		// System.out.println("vol is :" +vol);
	// }
// }
class Box{
	double width;
	double height;
	double depth;
	void volume(){
	System.out.print("volue is :");
	System.out.println(width * height * depth);
    }
} 

class BoxDemo{
	public static void main(String [] args){
		Box mybox1 = new Box();
		Box mybox2 = new Box();
		mybox1.width = 100;
		mybox1.height = 10;
		mybox1.depth = 15;
		mybox2.width = 2;
		mybox2.height = 3;
	    mybox2.depth = 4;
		mybox1.volume();
		mybox2.volume();
	}
}



















