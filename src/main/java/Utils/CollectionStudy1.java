package Utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hanxiaodi on 17/7/26.
 */
public class CollectionStudy1 {
    public static void main(String[] args){
        List<String> staff = new LinkedList<String>();
        staff.add("AMY");
        staff.add("BOY");
        staff.add("Caler");
        Iterator<String> iter = staff.iterator();
        String first = iter.next();
        String second = iter.next();
        iter.remove();
       // System.out.println(first);

        for(String element:staff){
            iter.hasNext();
            System.out.println(element);
        }

    }
}
