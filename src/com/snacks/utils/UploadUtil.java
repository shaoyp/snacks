package com.snacks.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadUtil {
	/**
	 * 上传文件
	 */
	public static String uploadImg(String model,File uploadFile, String uploadFileContentType){
		
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload/"+TimesUtil.dirFileByDay());
		
		File dir = new File(realpath);

		if (!dir.exists()) {

			dir.mkdir();

		}

		if (uploadFileContentType.equals("image/jpeg")) {

			uploadFileContentType = ".jpg";

		} else if (uploadFileContentType.equals("image/png")) {

			uploadFileContentType = ".png";

		} else if (uploadFileContentType.equals("image/gif")) {

			uploadFileContentType = ".gif";

		}       
		
		Random r = new Random();
		
		String uploadFileName = model + "-" +r.nextInt(10000)+ "-" +new Date().getTime() + uploadFileContentType;    
		
		try {
			
			FileUtils.copyFile(uploadFile, new File(dir, uploadFileName));
			
			return "/upload/"+TimesUtil.dirFileByDay() +"/"+uploadFileName;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static void main(String[] args) {
		String fileFolder = new SimpleDateFormat("yyyyMMdd").format(new Date());;
		System.out.println(fileFolder);
	}
}
