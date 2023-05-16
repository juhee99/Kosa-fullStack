package com.example.springedu.controller;

import com.example.springedu.domain.TeamDTO;
import com.example.springedu.domain.TeamMemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyTeamController {

    @RequestMapping(value = "/team",produces = "application/json; charset=utf-8")
    @ResponseBody
    public TeamDTO myTeamInfo(){

        TeamDTO team = new TeamDTO();

        team.setTeamName("T-ko");

        List<TeamMemberVO> teamMember = new ArrayList<TeamMemberVO>(4);
        teamMember.add(new TeamMemberVO("김민성","또라이","마파두부 덮밥"));
        teamMember.add(new TeamMemberVO("김대엽","열정대엽","치킨"));
        teamMember.add(new TeamMemberVO("홍승희","핑크공쥬","과자 다 좋아해요"));
        teamMember.add(new TeamMemberVO("박주희","노란콩","치킨"));

        team.setTeamMember(teamMember);
        return team;
    }
}
