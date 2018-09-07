package Utils;

import java.sql.*;

/**
 * Created by hanxiaodi on 17/7/30.
 */
public class InsertDate {

	//设置批次处理数量
	int i =0;
	public int batchSize=2;
	DbEnviorment de = new DbEnviorment();
//	public Statement statement;
//	public ResultSet rs = null;
	public static Connection con;
	PreparedStatement pst =null;
	PreparedStatement hostbank =null;
	PreparedStatement hostaccount =null;


	public  void insertDesposite(){
		con=de.Connect( "10.65.193.11:1521", "whpay","DEPOSITUSER","2izYbTOKwfeamJ" );
		try
		{
			con.setAutoCommit( false );
			boolean autoCommit=con.getAutoCommit();
			//statement=con.createStatement();
			//构造预处理statement
			 pst = con.prepareStatement("insert into DEPOSIT.T_DEPOSIT_ORDER (TRADE_VOUCHER_NO, BIZ_PRODUCT_CODE, AMOUNT, ACCESS_CHANNEL, GMT_SUBMIT, TRADE_STATUS, GMT_CREATE, GMT_MODIFIED, DEPOSIT_SRC_VOUCHER_NO, PARTNER_ID, PARTNER_NAME, ERROR_CODE, ERROR_MESSAGE, MEMBER_ID, ACCOUNT_NO, ACCOUNT_TYPE, REMARK, EXT, GMT_PAY_EXPIRED, GMT_CLOSED, IDENTITY_ID, IDENTITY_TYPE, SUB_STATUS)\n"
					+ "values (?, '301001', '20', 'WEB', sysdate, 'S', sysdate, sysdate, ?, '200005493718', '华源', '', '', '100006176340', '200100200110000617634000001', 'BASIC', '', '{\"isSafeCardSupport\":\"Y\",\"outTradeCode\":\"1100DEPOSIT-TEST\"}', '27-7月 -18 10.59.09.803000 下午', '', '0708151726', 'UID', 'Paid')");
			for(int i = 0;i<batchSize;i++){
				pst.setObject( 1, String.format( "121538590802" + i));
				pst.setObject( 2,String.format( "20180802" + i));
				pst.addBatch();
				//每1000次提交一次
				if(i!=0&&i%batchSize==0){//可以设置不同的大小；如50，100，500，1000等等
					pst.executeBatch();
					System.out.print( "finished" );
					con.commit();
					pst.clearBatch();
				}
				if(i%batchSize!=0){
					pst.executeBatch();
					System.out.print( "finished" );
					con.commit();
					pst.clearBatch();
				}
			}
			pst.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

   //插入weihuai 账务明细 和 银行流水明细
   public  void insertweihui(){
	   con=de.Connect( "10.65.193.11:1521", "whpay","ADMUSER","LYryhzD20ddG7A" );
	   try
	   {
		   con.setAutoCommit( false );
		   boolean autoCommit=con.getAutoCommit();
		   //statement=con.createStatement();
		   //构造预处理statement
		   hostbank = con.prepareStatement("insert into weihuiadm.tb_host_account_glide values (?, 'HBHRB','O','',sysdate,?,'1.01','T','','','I','10030010','3001',sysdate,sysdate,'N','1','HRBANKDPT10102')");
		   hostaccount = con.prepareStatement("insert into WEIHUIADM.TB_HOST_BANK_GLIDE values(?,20180820000013231,'CITYBANK','O','OUT1001',sysdate,?,'1.01','T','','','','I',sysdate,sysdate,'N','HR-1')");
		   for(int i = 0;i<batchSize;i++){
			   hostbank.setObject( 1, String.format( "2018082000005415" + i));
			   hostbank.setObject( 2,String.format( "INST366584920180820001" + i));
			   hostbank.addBatch();
			   hostaccount.setObject( 1, String.format( "2018082000005415" + i));
			   hostaccount.setObject( 2,String.format( "INST366584920180820001" + i));
			   hostaccount.addBatch();

			   //每1000次提交一次
			   if(i!=0&&i%batchSize==0){//可以设置不同的大小；如50，100，500，1000等等
				   hostbank.executeBatch();
				   hostaccount.executeBatch();
				   System.out.print( "finished" );
				   con.commit();
				   hostbank.clearBatch();
				   hostaccount.clearBatch();
			   }
			   if(i%batchSize!=0){
				   hostbank.executeBatch();
				   hostaccount.executeBatch();
				   System.out.print( "finished" );
				   hostbank.clearBatch();
				   hostaccount.clearBatch();
			   }
		   }
		   hostbank.close();
		   hostaccount.close();
		   con.close();
	   }
	   catch (SQLException e)
	   {
		   e.printStackTrace();
	   }
   }


	

	public static void main(String[] args){
		InsertDate i = new InsertDate();
		//i.insertDesposite();
		i.insertweihui();
	}
}
