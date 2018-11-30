package dong;

/**
 * Autor : dong
 * Time:2018/11/29
 */
interface ISubject{
    public void buyComputer();
}
class RealSubject implements ISubject{
    public void buyComputer(){
        System.out.println("买一台外新人电脑");
    }
}
//代理类
class ProxySubject implements ISubject {
    private ISubject subject;

    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }
    public void produceComputer(){
        System.out.println("生产外星人电脑");
    }
    public void afterSale(){
        System.out.println("外星人电脑售后团队");
    }
    public void buyComputer(){
        this.produceComputer();//真是操作前的准备
        this.subject.buyComputer();//调用真是的业务
        this.afterSale();//操作后的收尾
    }
}
class Factory{
    public static ISubject getIntance(){
        return new ProxySubject(new RealSubject());
    }
}
public class Test {
    public static void main(String[] args) {
        ISubject subject = Factory.getIntance();
        subject.buyComputer();
    }

}
