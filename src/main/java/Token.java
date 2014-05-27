import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Token extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String TOKEN="abcd5678";
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//微信加密签名
		String signature=request.getParameter("signature");
		//时间戳
		String timestamp=request.getParameter("timestamp");
		//随机数
		String nonce=request.getParameter("nonce");
		//随机字符串
		String echostr=request.getParameter("echostr");
		//排序
		
		System.out.println("signature==========="+signature);
		System.out.println("timestamp============" + timestamp);
		System.out.println("nonce=================="+nonce);
		System.out.println("echostr========================"+echostr);
		String[] str={TOKEN,timestamp,nonce};
		Arrays.sort(str);
		//拼接字符串
		String bigStr=str[0]+str[1]+str[2];
		//SHA1加密
		System.out.println("bigStr----------------"+bigStr);
		
		String digest=Token.Encode(bigStr);
		
		System.out.println("digest-----------------"+digest);
		//验证通过返回：echostr
		if(digest.equals(signature))
		{
			response.getWriter().print(echostr);
		}
	}
	//SHA1加密
	public static String Encode(String value) {
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		byte[] result = mDigest.digest(value.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
