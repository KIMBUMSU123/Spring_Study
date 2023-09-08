package com.icia.member.service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/save")
    public String saveForm(){
        return "memberSave";
    }

    public boolean save(MemberDTO memberDTO) {
        int result = memberRepository.save(memberDTO);
        if(result >0){
            return true;
        }else {
            return false;
        }
    }
}


