package cn.second.lhj.stuinfo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.second.lhj.stuinfo.service.StuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api
@RequestMapping("/api/wx")
public class WXAPI {

	
	@Autowired
	private StuInfoService stuInfoServ;
	
    //根据小程序端信息请求openID绑定用户
    @ApiOperation(value="根据小程序端信息请求openID绑定用户")
	@RequestMapping("/getOpenId")
  	public String getOpenId(@RequestParam("code")String code) throws Exception{
    	String msg = stuInfoServ.getOpenId(code).toJSONString();
    	System.out.println(msg); 
  		return msg;
  	}
}
