package com.sales.book.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller

public class FileDownloadController {

	private static String CURR_IMAGE_REPO_PATH = "C:\\Users\\user\\Desktop\\shopping\\file_repo";

//	@RequestMapping("/download")
//	protected void download(@RequestParam("fileName") String fileName, @RequestParam("goods_id") String goods_id, HttpServletResponse response) throws Exception {
//		OutputStream out = response.getOutputStream();
//		
//		String filePath = "CURR_IMAGE_REPO_PATH" + "\\" + goods_id + "\\" + fileName;
//		File image = new File(filePath);
//		
//		response.setHeader("Cache-Control", "no-cache");
//		response.addHeader("Content-disposition", "attachment; fileName="+fileName);
//		
//		FileInputStream in = new FileInputStream(image);
//		byte[] buffer = new byte[1024*8];
//		
//		
//	}
	
	//로컬에 있는 이미지 파일 가져오기
	@RequestMapping("/thumbnails.do")
	protected void thumbnails(@RequestParam("goods_fileName") String goods_fileName, @RequestParam("goods_id") String goods_id, HttpServletResponse response) throws Exception {
			
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + goods_id + "\\" + goods_fileName;
		File image = new File(filePath);

		int lastIndex = goods_fileName.lastIndexOf(".");
		String imageFileName = goods_fileName.substring(0, lastIndex);
		if (image.exists()) {
			Thumbnails.of(image).size(121, 154).outputFormat("png").toOutputStream(out);
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}
}
