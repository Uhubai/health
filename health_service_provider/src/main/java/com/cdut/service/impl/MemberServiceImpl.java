package com.cdut.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cdut.dao.MemberDao;
import com.cdut.service.CheckItemService;
import com.cdut.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;
    //根据月份查询会员数量
    @Override
    public List<Integer> findMemberCountByMonth(List<String> months) {
        List<Integer> memberCount = new ArrayList<>();
        for (String month : months) {
            month = month + ".28";
            Integer count = memberDao.findMemberCountBeforeDate(month);
            memberCount.add(count);
        }
        return memberCount;
    }
}
