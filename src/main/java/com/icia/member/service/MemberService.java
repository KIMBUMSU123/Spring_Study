package com.icia.member.service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    public boolean login(MemberDTO memberDTO) {
        // 이메일, 비밀번호 두 값 모두 일치하는 db 조회결과를 가져옴
        // 이메일로 db에서 조회해서 서비스에 비밀번호를 서로 비교하여 일치하면 로그인 성공
        MemberDTO dto = memberRepository.login(memberDTO);
        if(dto !=null){
            return true;
        }else{
            return false;
        }
    }

    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }
}


