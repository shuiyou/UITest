import org.apache.commons.codec.binary.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Created by hanxiaodi on 17/8/28.
 */
public class RSAEncrypt
{
	public static void main(String[] args){

	}
	public static void jdkRSA(){
		//初始化密钥
		try
		{
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(512);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			RSAPublicKey rsaPublicKey =(RSAPublicKey)keyPair.getPublic();
			RSAPrivateKey rsaPrivateKey =(RSAPrivateKey)keyPair.getPrivate();
			System.out.println("public key:"+ Base64.encodeBase64String(rsaPublicKey.getEncoded()));
			System.out.println("private key"+Base64.encodeBase64String(rsaPrivateKey.getEncoded()));
			
		}catch (Exception e){
			e.printStackTrace();
		}



}
}
