/**
 * Created by hanxiaodi on 17/6/21.
 */
public class TestStringBuilder {
    public static void main(String[] args){
        StringBuilder builder = new StringBuilder();
        builder.append("ch");
        builder.append("str");
        int a = builder.length();
        int[] test ={17,18,5,6};
        String completedString = builder.toString();
        System.out.print(completedString+"length:"+a);
        for (int element:test
             ) {
            System.out.println(element);
        }
    }
}
