package tzy.qword.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.sun.org.glassfish.gmbal.ParameterNames;

import tzy.qword.bean.DataBaseConfigure;
import tzy.qword.bean.Libraries;
import tzy.qword.bean.Library;

@Controller
public class QwordController {

	@ResponseBody
	@RequestMapping(value="/getLibraries",method = RequestMethod.GET, produces = {"text/plain;charset=UTF-8"})
	public String getLibraries(HttpServletRequest request){
		
		String root =request.getSession().getServletContext().getRealPath("/");
		File file =new File(root + "\\WEB-INF\\word_librares\\");
		File[] files = file.listFiles();
		List<Library> libraries = new ArrayList<>(files.length);
		Library library ;
		for(File fl : files){
			
			library = new Library();
			library.setCreatedTime(fl.lastModified());
			String lName = fl.getName();
			int dot = lName.lastIndexOf(".");
			lName = lName.substring(0,dot);
			library.setLibraryName(lName);
			library.setIntrodu(getIntro(lName));
			libraries.add(library);
		}
		
		Libraries libs = new Libraries();
		libs.setLibraries(libraries);
		Gson gson = new Gson();
		String result = gson.toJson(libs);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getlibraryTable")
	public File getLibraryFile(HttpServletRequest request){
		String lname = request.getParameter("library_name");
		String root =request.getSession().getServletContext().getRealPath("/");
		File file =new File(root + "\\WEB-INF\\word_librares\\" + lname + ".txt");
		return file;
	}
	
	public String getIntro(String lname){
		if(DataBaseConfigure.DATA_BASE_CET4.equals(lname)){
			return "四级单词词汇";
		}
		
		if(DataBaseConfigure.DATA_BASE_CET4.equals(lname)){
			return "六级单词词汇";
		}
		
		if(DataBaseConfigure.DATA_BASE_TOEFL.equals(lname)){
			return "托福单词词汇";
		}
		
		if(DataBaseConfigure.DATA_BASE_IELTS.equals(lname)){
			return "雅思单词词汇";
		}
		
		if(DataBaseConfigure.DATA_BASE_CET4.equals(lname)){
			return null;
		}
		
		if(DataBaseConfigure.DATA_BASE_CET4.equals(lname)){
			return null;
		}
		
		if(DataBaseConfigure.DATA_BASE_CET4.equals(lname)){
			return null;
		}
		
		if(DataBaseConfigure.DATA_BASE_CET4.equals(lname)){
			return null;
		}
		
		if(DataBaseConfigure.DATA_BASE_CET4.equals(lname)){
			return null;
		}
		
		return "未知词汇本";
	}
	
}
