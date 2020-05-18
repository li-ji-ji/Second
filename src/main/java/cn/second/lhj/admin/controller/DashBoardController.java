package cn.second.lhj.admin.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import cn.second.lhj.apply.service.ApplyService;
import cn.second.lhj.asso.service.CspActStuRelationService;
import cn.second.lhj.asso.service.CspAssoActivityService;
import cn.second.lhj.asso.service.CspAssoStuRelationService;

@Controller
@RequestMapping("/board")
public class DashBoardController {

	
	@Autowired
	private CspActStuRelationService asrService;
	
	@Autowired
	private CspAssoActivityService actService;
	
	@Autowired
	private ApplyService applyService;
	
	@Autowired
	private CspAssoStuRelationService ASRService;
	
	@RequestMapping("/toBoard")
	public String toBoard(Model model) throws Exception{
		model.addAttribute("getActJoin",JSON.toJSONString(asrService.getActJoin()));
		model.addAttribute("getActKind",JSON.toJSONString(actService.getActKind()));
		model.addAttribute("getApplyKind",JSON.toJSONString(applyService.getApplyKind()));
		model.addAttribute("getAssoStuJoin",JSON.toJSONString(ASRService.getAssoStuJoin()));
		return "admin/DashBoard";
	}
	
}
