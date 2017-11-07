package TestDepositoryBank;

import java.sql.*;

/**
 * Created by hanxiaodi on 17/8/15.
 */
public class ConnectDataBase {
	Connection conn = null;
///	Statement statement = null;
	PreparedStatement pre = null;
	ResultSet result = null;

	private static String USERNAME = "ADMUSER";
	private static String PASSWORD = "LYryhzD20ddG7A";
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@ 10.65.193.11:1521:whpay";

	public static void main(String[] args){
		ConnectDataBase connectDataBase = new ConnectDataBase();
		String trueStatus =connectDataBase.readDate();
		Boolean c = IsFinish(trueStatus);
		System.out.print(c);

	}





	public  Connection connectDB() {

		try
		{
			Class.forName(DRIVER);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		try
		{
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}


	public String readDate(){
		String a =null;
		conn = connectDB();
		String sql = "select * from weihuiadm.tb_host_statement t where t.host_bank='HBHRB' and t.statement_id='20170807000003302' ";
		try
		{
			pre =conn.prepareStatement(sql);
			result =pre.executeQuery();
			while(result.next()){
			a = result.getString("status");
			System.out.println(a);}
		}

		catch (SQLException e)
		{
			e.printStackTrace();
		}

        return a;
	}

	public static Boolean IsFinish(String n){
		if(n.compareTo("SS") ==1){
			return true;
		}
		return false;
	}

	public void CloseDateBase(){
		if(result != null){
			try
			{
				result.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		if(pre !=null){
			try
			{
				pre.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		if(conn!=null){
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}


