/*
 * Copyright (c) 2015-2016, fangstar.com
 *
 * All rights reserved.
 */
package tess4j.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * 网络图片识别
 * @author yeahwa
 *
 */

public class IdentifyNetworkImage {
	public static String imagePngToNumber(String url,String tag){
		File imageFile = null;
		String result = null;
		try {
			//本地临时存储
			imageFile = new File(tag+".png");
			if (imageFile.exists()) {
				imageFile.delete();
				imageFile.createNewFile();
			}else {
				imageFile.createNewFile();
			}
			URL imageURL = new URL(url);
			FileUtils.copyURLToFile(imageURL, imageFile);
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		ITesseract instance = new Tesseract();
		if (imageFile.exists()) {
			try {
				result = instance.doOCR(imageFile);
				result = result.replace(" ", "").replace("\n", "");
			} catch (TesseractException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				return null;
			}
		}
		return result;
	}

}
