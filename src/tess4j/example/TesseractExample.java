package tess4j.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractExample {
	
	public static void main(String[] args) {
		File imageFile = null;
		try {
			URL url = new URL("http://second.km.fccs.com/sale/phonePng.do?phone=2c7bababa0c0ca7c62d982cdc999b3e7");
			imageFile = new File("tmp.png");
			if (imageFile.exists()) {
				imageFile.delete();
				imageFile.createNewFile();
			}else {
				imageFile.createNewFile();
			}
			FileUtils.copyURLToFile(url, imageFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ITesseract instance = new Tesseract();
		
		if (imageFile.exists()) {
			String result;
			try {
				result = instance.doOCR(imageFile);
				result = result.replace(" ", "");
				System.out.println(result);
			} catch (TesseractException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			
		}
	}
	
	/** 
     * 读取文件 
     * @param sourcePath 文件所在的网络路径 
     */  
    public void readHtmlFile(String sourcePath){  
        String line;  
        int lineNum=0;  
        BufferedReader reader=null;  
        try{  
            URL url = new URL(sourcePath);  
            reader = new BufferedReader(new InputStreamReader(url.openStream()));  
            while ((line = reader.readLine()) != null){  
                lineNum++;  
                System.out.println(line);  
            }  
        }  
        catch (Exception ie){  
            ie.printStackTrace();  
        }finally{  
            try{  
                if(reader != null)  
                    reader.close();  
            }catch (Exception e){  
                e.printStackTrace();  
            }  
        }  
    }

}
