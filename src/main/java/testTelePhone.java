/**
 * Created by hanxiaodi on 17/7/17.
 */
public class testTelePhone {
    public static void main(String [] args){
        telePhone phone1 = new telePhone();
        telePhone phone2 = new telePhone();
        phone1.setSize("large");
        phone1.setCPU("x86");
        phone1.setCoachsize(1000);
        phone2.setSize("large");
        phone2.setCPU("x86");
        phone2.setCoachsize(2000);

        if(phone1.equals(phone2)){
            System.out.println("相等");
        }else{
            System.out.println("不相等");
        }
    }
}
