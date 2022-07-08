package Study.DBTest.db1toN.controller;

import Study.DBTest.db1toN.domain.Member;
import Study.DBTest.db1toN.domain.MemberForm;
import Study.DBTest.db1toN.domain.Team;
import Study.DBTest.db1toN.service.MemberService;
import Study.DBTest.db1toN.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final TeamService teamService;
    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("teamList", teamService.findAllTeams());
        model.addAttribute("form", new MemberForm());
        return "addMemberForm";
    }

    @PostMapping("/add")
    public String add(@Valid MemberForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "addMemberForm";
        }
        Member member = new Member();
        member.setName(form.getName());
        member.setAge(form.getAge());
        memberService.save(member, form.getTeamId());
        return "redirect:/member/add";
    }

    @ResponseBody
    @GetMapping("/list")
    public List<String> list(@RequestParam String teamname) {
        List<Member> members = memberService.findByTeamname(teamname);
        List<String> memberNames = new ArrayList<>();
        for(Member member : members) {
            memberNames.add(member.getName());
        }
        return memberNames;

    }

    @ResponseBody
    @GetMapping("/list2")
    public String list2(@RequestParam String membername) {
        Team team = teamService.findByMembername(membername);
        return team.getName();
    }

    @ResponseBody
    @GetMapping("/list3")
    public Team list3() {
        return teamService.findById(1L);
    }



    @ResponseBody
    @GetMapping("/remove")
    public String remove() {
        memberService.removeTeam(1L);
        return "ok";
    }
}