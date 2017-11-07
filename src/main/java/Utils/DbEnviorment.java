package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hanxiaodi on 17/9/6.
 */
public class DbEnviorment
{
	public static Connection con;
	public static Statement statement;
	static String host;
	static String database;
	static String username;
	static String pwd;


	public  Statement Connect(String host,String database, String name,String password){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}

		OraclePasswd opasswd = new OraclePasswd();
		DbEnviorment.host =host;
		DbEnviorment.database =database;
		DbEnviorment.username = name;
		DbEnviorment.pwd =opasswd.getPasswd(DbEnviorment.username);
		if(host.compareTo(DbEnviorment.host)!=1 || database.compareTo(DbEnviorment.database)!=1 ||username.compareTo(DbEnviorment.username)!=1){
			String url ="jdbc:oracle:thin:@"+host+":"+database;
			try{
				con = DriverManager.getConnection(url,username,password);
				Statement stmt = con.createStatement();
			}catch (SQLException e2){
				e2.printStackTrace();
			}
		}else
		{
			String url = "jdbc:oracle:thin:@" + DbEnviorment.host + ":" + DbEnviorment.database;
			try{
				con = DriverManager.getConnection(url,DbEnviorment.username,DbEnviorment.pwd);
				Statement stmt = con.createStatement();
			}catch (SQLException e2){
				e2.printStackTrace();
			}
		}


		return statement;



	}
}
