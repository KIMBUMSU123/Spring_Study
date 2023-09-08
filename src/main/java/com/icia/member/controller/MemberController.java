package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        boolean result = memberService.save(memberDTO);
        if(result){
            return "memberLogin";
        }else {
            return "memberSave";
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "memberLogin";
    }

}
