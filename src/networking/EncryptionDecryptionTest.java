package networking;

import org.apache.commons.codec.binary.Base64;

public class EncryptionDecryptionTest {
	private static String encryptionStringvalue="arasu378";
	private static String decryptionStringvalue="YXJhc3UzNzg=";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//encryptionTest(encryptionStringvalue);
		DecryptionTest(decryptionStringvalue);
		}
	public static String encryptionTest(String value){
		String returnvalue=null;
		byte[] encodedBytes = Base64.encodeBase64(value.getBytes());
		System.out.println("encoded_String_value :  " + new String(encodedBytes));
		returnvalue=new String(encodedBytes);
		return returnvalue;
		
	}
	public static String DecryptionTest(String value){
		String returnvalue=null;
		  byte[] decodedBytes = Base64.decodeBase64(value);
			System.out.println("decoded_String_value : " + new String(decodedBytes));
			 returnvalue=new String(decodedBytes);
			 return returnvalue;
	}

}
