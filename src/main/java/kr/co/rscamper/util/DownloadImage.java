package kr.co.rscamper.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/images")
public class DownloadImage extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("path");
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("");
		
		String defaultPath = "upload/images/default/default-user-bg.png";			
		
		File f = new File(uploadPath + path);
		if (!f.exists() || f.isDirectory()) {
			f = new File(uploadPath + defaultPath);
			path = defaultPath;
		};
		
		switch (path.split("\\.")[1]) {
			case "png" :
				response.setHeader("Content-Type", "image/png");
				break;
			case "gif" :
				response.setHeader("Content-Type", "image/gif");
				break;
			case "jpg" :
				response.setHeader("Content-Type", "image/jpg");
				break;
		};

		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);

		OutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);

		while (true) {
			int ch = bis.read();
			if (ch == -1)
				break;

			bos.write(ch);
		}

		bis.close();
		fis.close();
		bos.close();
		out.close();
	}
}
