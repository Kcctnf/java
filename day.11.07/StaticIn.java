import static net.mindview.util.print.;
class Bow1{
	Bow1(int marker){
		print("Bow1("+ marker +")");
	}
	void f1(int marker){
		print("fi("+ marker +")");
	}
}
class Table{
	static Bow1 Bpw1a = new Bow1(1);
	Table(){
		print("Table()");
		Bow12.f1(1);
	}
	void f2(int marker){
		print("f2(" + marker +")");
	}
	static Bow1 Bow12 = new Bow1(2);
}
class Cupboard{
	Bow1 Bow13 = new Bow1(3);
	static Bow1 Bow14 = new Bow1(4);
	Cupboard(){
		print("Cupboard()");
		Bow14.f1(2);
	}
	void f3(int marker){
		print("f3("+ marker +")");
	}
	static Bow1 Bow15 = new Bow1(5);
}
public class StaticIn{
	public static void main(String [] args){
		print("Creating new Cupboard() int main");
		new Cupboard();
		print("Creating new Cupboard() int main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}
	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
}









