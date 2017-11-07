package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hanxiaodi on 17/9/7.
 */
public class AccountGilde
{
	private String hostBank;

	private String bizType;

	private String outTradeCode;

	private Date accountDate;


	private String instOrderNo;

	private String amount;

	private String extension;

	private String compareBatchNo;

	private Date compareDate;

	private String compareFlag;

	private String productCode;

	private String paymentCode;

	private String hisFlag;


	public String getHostBank()
	{
		return hostBank;
	}

	public void setHostBank(String hostBank)
	{
		this.hostBank = hostBank;
	}

	public String getBizType()
	{
		return bizType;
	}

	public void setBizType(String bizType)
	{
		this.bizType = bizType;
	}

	public String getOutTradeCode()
	{
		return outTradeCode;
	}

	public void setOutTradeCode(String outTradeCode)
	{
		this.outTradeCode = outTradeCode;
	}

	public Date getAccountDate()
	{
		return accountDate;
	}

	public void setAccountDate(Date accountDate)
	{
		this.accountDate = accountDate;
	}

	public String getInstOrderNo()
	{
		return instOrderNo;
	}

	public void setInstOrderNo(String instOrderNo)
	{
		this.instOrderNo = instOrderNo;
	}

	public String getAmount()
	{
		return amount;
	}

	public void setAmount(String amount)
	{
		this.amount = amount;
	}

	public String getExtension()
	{
		return extension;
	}

	public void setExtension(String extension)
	{
		this.extension = extension;
	}

	public String getCompareBatchNo()
	{
		return compareBatchNo;
	}

	public void setCompareBatchNo(String compareBatchNo)
	{
		this.compareBatchNo = compareBatchNo;
	}

	public Date getCompareDate()
	{
		return compareDate;
	}

	public void setCompareDate(Date compareDate)
	{
		this.compareDate = compareDate;
	}

	public String getCompareFlag()
	{
		return compareFlag;
	}

	public void setCompareFlag(String compareFlag)
	{
		this.compareFlag = compareFlag;
	}

	public String getProductCode()
	{
		return productCode;
	}

	public void setProductCode(String productCode)
	{
		this.productCode = productCode;
	}

	public String getPaymentCode()
	{
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode)
	{
		this.paymentCode = paymentCode;
	}

	public String getHisFlag()
	{
		return hisFlag;
	}

	public void setHisFlag(String hisFlag)
	{
		this.hisFlag = hisFlag;
	}

	public static  List getAccountGildeFromFile(String filepath){
		File file = new File(filepath);
		AccountGilde accountGilde = new AccountGilde();
		List details =new ArrayList();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String s= null;
			while((s = reader.readLine())!=null){
				String[] ss =s.split("\\|");
				accountGilde.setInstOrderNo(ss[0]);
				accountGilde.setHostBank("TBBANK");
				accountGilde.setAmount(ss[4]);
				accountGilde.setBizType(ss[2]);
				accountGilde.setOutTradeCode("");
				accountGilde.setPaymentCode("");
				accountGilde.setProductCode("");
				details.add(accountGilde);

			}
		}catch (Exception e){
			e.printStackTrace();
		}

		return details;

	}




}
