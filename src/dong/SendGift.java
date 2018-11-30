package dong;

/**
 * Autor : dong
 * Time:2018/11/30
 */
interface SendGifts{
     void send();
}
class BoyFriendSendGift implements SendGifts{
    private String BoyFriendName;
    private String GirlFriendName;

    public BoyFriendSendGift(String BoyFriendName,String GirlFriendName){
        this.BoyFriendName = BoyFriendName;
        this.GirlFriendName = GirlFriendName;
    }
    public void send(){
        System.out.println(this.BoyFriendName + "赠送给" + this.GirlFriendName);
    }
}
//代理类
class CourierSendGift implements SendGifts{
    private final BoyFriendSendGift target;
    public CourierSendGift(BoyFriendSendGift target){
        this.target = target;
    }
    public void send(){
        System.out.println("快递员打电话");
        this.target.send();
        System.out.println("客户签收");
    }
}



public class SendGift {
    public static void main(String[] args) {
        BoyFriendSendGift target = new BoyFriendSendGift("zhansan","lisi");
        CourierSendGift proxyObject = new CourierSendGift(target);
        proxyObject.send();

    }
}
