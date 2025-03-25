package miniproject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//패스워드 MD5 암호화 생성
public class m_md5 {
	
	public String md5_code(String pw) {
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(pw.getBytes());
			//암호화 알고리즘
			for(byte alg : md.digest()) {
				sb.append(String.format("%x", alg));
			}
			
		} catch (Exception e) {
			sb.append("null");
		}
		
		return sb.toString();
	}
}