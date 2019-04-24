package com.imsystem.controller.goods;  
import java.io.*;  
import java.util.Date;
import java.util.UUID;
import java.awt.*;  
import java.awt.image.*;  
import javax.imageio.ImageIO;  
import com.sun.image.codec.jpeg.*;  
/**
 * 图片压缩工具类
 * @author Shimmer
 *
 */
public class ImgCompress {

	private Image img;  
    private int width;  
    private int height;  
 
    /**
     * MultipartFile 转 file
     * @param ins
     * @param file
     */
    public static void inputStreamToFile(InputStream ins, File file) {
	    try {
	        OutputStream os = new FileOutputStream(file);
	        int bytesRead = 0;
	        byte[] buffer = new byte[8192];
	        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
	            os.write(buffer, 0, bytesRead);
	        }
	        os.close();
	        ins.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
    
    /** 
     * 构造函数 
     */  
    public ImgCompress(File file) throws IOException {  
        img = ImageIO.read(file);      // 构造Image对象  
        width = img.getWidth(null);    // 得到源图宽  
        height = img.getHeight(null);  // 得到源图长  
    }  
    /** 
     * 按照宽度还是高度进行压缩 
     * @param w int 最大宽度 
     * @param h int 最大高度 
     */  
    public byte [] resizeFix(int w, int h) throws IOException {  
        if (width / height > w / h) {  
            return resizeByWidth(w);  
        } else {  
        	return resizeByHeight(h);  
        }  
    }  
    /** 
     * 以宽度为基准，等比例放缩图片 
     * @param w int 新宽度 
     */  
    public byte [] resizeByWidth(int w) throws IOException {  
        int h = (int) (height * w / width);  
        return resize(w, h);  
    }  
    /** 
     * 以高度为基准，等比例缩放图片 
     * @param h int 新高度 
     */  
    public byte [] resizeByHeight(int h) throws IOException {  
        int w = (int) (width * h / height);  
        return resize(w, h);  
    }  
    /** 
     * 强制压缩/放大图片到固定的大小 
     * @param w int 新宽度 
     * @param h int 新高度 
     */  
    public byte [] resize(int w, int h) throws IOException {  
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢  
        BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );   
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图  
        String uuid = UUID.randomUUID().toString();
        File destFile = new File("D:\\img\\"+uuid+".jpg");  
        FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流  
        // 可以正常实现bmp、png、gif转jpg  
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
        encoder.encode(image); // JPEG编码  
        
        //创建一个字节流   读取
    	InputStream inputStream = new FileInputStream(destFile); 
    	//把本地文件 转化成byte[] 
    	ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
    	byte[] buffer = new byte[1024]; 
    	int len = 0; 
    	while( (len=inputStream.read(buffer)) != -1 ){ 
    	outStream.write(buffer, 0, len); 
    	} 
    	byte [] data = outStream.toByteArray();//转化成byte[] 网络上都是 byte [] data = new byte[inputStream.available()];这种方法不可取 
    	//关闭流 
    	outStream.close(); 
    	inputStream.close();
        out.close();
        return data;
        
    }  
	
}
