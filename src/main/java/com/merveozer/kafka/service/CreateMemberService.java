package com.merveozer.kafka.service;

import com.merveozer.kafka.dao.MemberDao;
import com.merveozer.kafka.model.Member;
import com.merveozer.kafka.publisher.MemberEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMemberService {
    private MemberDao memberDao;
    private MemberEventPublisher memberEventPublisher;

    @Autowired
    public CreateMemberService(MemberDao memberDao, MemberEventPublisher memberEventPublisher) {
        this.memberDao = memberDao;
        this.memberEventPublisher = memberEventPublisher;
    }

    public Member create(Member member) throws Exception {
        try {
            this.memberDao.save(member);
            String message = "Member was added successfully " + member.getName();
            memberEventPublisher.publishEvent("member-create", message);
            return member;
        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}
