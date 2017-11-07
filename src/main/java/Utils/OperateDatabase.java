package Utils;


import com.weihui.common.util.DateUtil;

import java.sql.Connection;
import java.sql.Statement;
import java.util.*;

/**
 * Created by hanxiaodi on 17/9/7.
 */
public class OperateDatabase
{
	private String h ="10.65.193.11:1521";
	private String d ="whpay";
	private String n ="ADMUSER";

	public static void main(String[] args){
		AccountGilde ac = new AccountGilde();
		OperateDatabase od = new OperateDatabase();
		ac.setHostBank("TestBank");
		ac.setBizType("I");
		ac.setOutTradeCode("TOU001");
		ac.setInstOrderNo("INST111111222223333");
		ac.setAccountDate(new Date());
		ac.setAmount("1.00");
		ac.setProductCode("2001");
		ac.setPaymentCode("123");
		List a = new ArrayList();
		a.add(ac);
		od.insertAccountGilde(a);



	}

	public void insertAccountGilde(List a){

		Iterator iter = a.iterator();
		while(iter.hasNext()){
			AccountGilde record =(AccountGilde)iter.next();
			String sql = "insert into TB_HOST_ACCOUNT_GLIDE (GLIDE_ID, HOST_BANK, BIZ_TYPE,"
					+ "OUT_TRADE_CODE, ACCOUNT_DATE, INST_ORDER_NO, "
					+ "AMOUNT, EXTENSION, COMPARE_BATCH_NO, "
					+ "COMPARE_DATE, COMPARE_FLAG, PRODUCT_CODE, "
					+ "PAYMENT_CODE, GMT_CREATE, GMT_MODIFIED, "
					+ "HIS_FLAG)"
					+ " values (weihuiadm.SEQ_HOST_ACCOUNT_GLIDE.nextval,'"
					+ record.getHostBank()
					+ "','"
					+ record.getBizType()
					+ "','"
					+ record.getOutTradeCode()
					+ "',to_date("
					+ DateUtil.format(record.getAccountDate(), DateUtil.shortFormat)
					+ ",'"
					+ DateUtil.shortFormat
					+ "'),'"
					+ record.getInstOrderNo()
					+ "',"
					+ ""
					+ record.getAmount().toString()
					+ ", null ,null, "
					+ "null,'I','"
					+ record.getProductCode()
					+ "',"
					+ "'"
					+ record.getPaymentCode()
					+ "', sysdate, sysdate, "
					+ "'N')";
			System.out.println(sql);

			try
			{   DbEnviorment db = new DbEnviorment();
				//Statement stmt = db.Connect(h,d,n);
				//stmt.executeUpdate(sql);
			}catch (Throwable e){
				e.printStackTrace();
			}
		}

	}
}
