package cn.tedu.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.util.ImageUtil;

@Controller
@Scope("prototype")
public class VerifyCodeAction {
	
	//1.可以自己使用response输出二进制数据.
	//2.也可以调用Struts2的result输出二进制数据.
	//  若采用这种方式,Struts2要求我们提供
	//  inputStream类型的数据,它会使用result
	//  输出这种类型的数据.
	private InputStream imgStream;
	
	public InputStream getImgStream() {
		return imgStream;
	}

	public void setImgStream(InputStream imgStream) {
		this.imgStream = imgStream;
	}

	public String execute() throws IOException {
		//生成验证码及图片
		Object[] objs = ImageUtil.createImage();
		//将验证码存入session
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("imgcode", objs[0]);//把验证码的数字传入session中了
		//将图片转为输入流,赋值给Bean属性,
		//由Result将此属性输出给浏览器.
		BufferedImage img = (BufferedImage) objs[1];
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(img, "png", os);
		imgStream = new ByteArrayInputStream(os.toByteArray());
		
		return "success";
	}

}











