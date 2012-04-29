package g1.MoonPie.clientServer;

public class EncryptPassword {
	
	public static String getSuperSecrectPassword(String value){
		byte[] bytes = value.getBytes();
		String defaultPassword = "ffffffffffffffffffffffffffffffff";
		try{
			java.security.MessageDigest sha1 = java.security.MessageDigest.getInstance("SHA1");
			sha1.update(bytes, 0, bytes.length);
			byte password[] = sha1.digest();
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < password.length; i++) {
				String hex = Integer.toHexString(password[i]);
				
				if(hex.length() == 1){
					sb.append("0" + hex);
				}else if(hex.length() == 2){
					sb.append(hex);
				}else{
					// if negative, this would be something like "ffffffc0"
					sb.append(hex.charAt(6));
					sb.append(hex.charAt(7));
				}
				
			}
			return sb.toString();

		} catch(Exception e){
			return defaultPassword;
		}
	}
}
