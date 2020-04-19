package cn.second.lhj.util;

import java.net.URLDecoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecondFileUpload {
	
	@RequestMapping("/second/toUpload")
	public String toUpload()throws Exception{
		return "admin/FileUpload";
	}
}
