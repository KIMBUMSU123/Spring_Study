package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO){    //@ModelAttribute는 HTTP Body 내용과 HTTP 파라미터의 값들을 Getter, Setter, 생성자를  통해 주입하기 위해 사용한다.
        boolean result = memberService.save(memberDTO);
        if(result){
            return "memberLogin";
        }else {
            return "memberSave";
        }
    }

    @GetMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model){ //HttpSession:사용자를 식별하거나, 해당 사용자에 대한 정보를 저장하는 방법을 제공한다
                                                                                                //Model 객체는 Controller 에서 생성된 데이터를 담아 Views 로 전달할 때 사용하는 객체이다.
        boolean loginResult = memberService.login(memberDTO);
        if(loginResult){
            //로그인 성공시 사용자의 이메일을 세션에 저장
            session.setAttribute("loginEmail",memberDTO.getMemberEmail());
            // Model에 이메일을 저장
            model.addAttribute("email",memberDTO.getMemberEmail());
            return "memberLogin";
        }else{
        return "memberLogin";
        }
    }
    @GetMapping("/members")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "memberList";
    }
}
