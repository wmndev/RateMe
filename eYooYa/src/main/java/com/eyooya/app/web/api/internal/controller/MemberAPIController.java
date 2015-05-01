package com.eyooya.app.web.api.internal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eyooya.app.platform.db.model.member.BasicMember;
import com.eyooya.app.platform.db.service.CommonOperationsService;

@RestController
@RequestMapping("api/i/v1/member")
public class MemberAPIController {
	
	@Autowired
	private CommonOperationsService<BasicMember> memberService;
	
	@RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
	public BasicMember getMemberById(@PathVariable("id") String id){
		if (id != null){
			return memberService.findById(Long.parseLong(id));
		}
		return null;
	}
	
	
	@RequestMapping(value = "",
            method = RequestMethod.GET)
	public BasicMember getMemberByProperties(@RequestParam(value="category", required=false) int category,
			@RequestParam(value="top", required=false) int top
			){
//		if (id != null){
//			return memberService.findById(Long.parseLong(id));
//		}
		return null;
	}
	

}
