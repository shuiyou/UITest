import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hanxiaodi on 17/6/23.
 */
public class imoocMD {

    private static String src ="immoc security md";



    public static void main(String[] args){

    }

    public static void jdkMD5(){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
