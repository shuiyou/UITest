import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by hanxiaodi on 17/5/26.
 */
public class readProperties {


    public static void main(String[] args)throws IOException{
        Properties properties = new Properties();
        FileInputStream in =new FileInputStream(new File("/Users/hanxiaodi/UITest/src/main/resources/a.properties"));
        properties.load(in);

        String a = properties.getProperty("name");
        System.out.println(a);
        System.out.println(System.getProperty("user.dir"));
    }
}
