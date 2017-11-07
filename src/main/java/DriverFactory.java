import java.util.Properties;

import org.openqa.selenium.WebDriver;

/**
 * Created by hanxiaodi on 17/7/23.
 */
public class DriverFactory {
  private  String firefoxdriver;
  private  String chromedrive;
  private  String currentdir =System.getProperty("user.dir"); //获取当前项目目录
  private  String OSType = System.getProperty("os.name"); //获取当前操作系统
  private  Properties p;
  static WebDriver driver =null;
  public static DriverFactory driverFactory;

  public enum BrowserType{
    firefox,chrome,ie,edge,safari
  }

      /**
           *
           * @Title:
           * @Description: 得到唯一对象
           * @return
           * @return
           * @author: Han
           * @throws:
           * @date 17/7/26 下午4:29
           * @version: V1.0
           */
  public static void main(String [] args){

  }
}