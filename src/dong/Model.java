package dong;

/**
 * Autor : dong
 * Time:2018/11/29
 */
import sun.awt.geom.AreaOp;

import java.util.Scanner;
interface Computer{
    void printComputer();
}
class MacbookProComputer implements Computer{
    public void printComputer(){
        System.out.println("this is MacbookProComputer");
    }
}
class SurfaceBookComputer implements Computer{
    public void printComputer(){
        System.out.println("this is SurfaceBookComputer");
    }
}
class ComputerFactory{
    public static Computer getInstance(String type){
        Computer computer = null;
        if(type.equals("macbook")){
            computer=new MacbookProComputer();
        }else if(type.equals("surface")){
            computer = new SurfaceBookComputer();
        }
        return computer;
    }
}

public class Model {
    public void buyComputer(Computer computer){
        computer.printComputer();
    }
    public static void main(String[] args){
        Model model = new Model();
        Scanner scanner =new Scanner(System.in);
        System.out.println("你想要的电脑型号：");
        String type = scanner.nextLine();
        Computer computer = ComputerFactory.getInstance(type);
        model.buyComputer(computer);
    }

}




