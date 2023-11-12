package com.merveozer.kafka.controller;

import com.merveozer.kafka.model.Member;
import com.merveozer.kafka.service.CreateMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080")
public class MemberApi {
    private CreateMemberService createMemberService;
    @Autowired
    public MemberApi(CreateMemberService createMemberService) {
        this.createMemberService = createMemberService;
    }

    @PostMapping("member")
    public Member add(@RequestBody Member member) throws Exception{
        return this.createMemberService.create(member);
    }
}
