package Study.DBTest.JpaRepositoryTest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerRepository playerRepository;

    @GetMapping("")
    public String home(Model model, @RequestParam(required = false, defaultValue = "1") int page,
                                    @RequestParam(required = false, defaultValue = "0") int AgeGe,
                                    @RequestParam(required = false, defaultValue = "999") int AgeLe,
                                    @RequestParam(required = false, defaultValue = "BRONZE") Rank RankGe,
                                    @RequestParam(required = false, defaultValue = "DIAMOND") Rank RankLe,
                                    @RequestParam(required = false, defaultValue = "No") SortTypes SortType) {


        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        if(SortType == SortTypes.AgeAsc) { pageRequest = PageRequest.of(page - 1, 10, Sort.Direction.ASC, "age"); }
        else if(SortType == SortTypes.AgeDesc) { pageRequest = PageRequest.of(page - 1, 10, Sort.Direction.DESC, "age"); }
        else if(SortType == SortTypes.RankAsc) { pageRequest = PageRequest.of(page - 1, 10, Sort.Direction.ASC, "rank"); }
        else if(SortType == SortTypes.RankDesc) { pageRequest = PageRequest.of(page - 1, 10, Sort.Direction.DESC, "rank"); }


        Page<Player> result = playerRepository.
                findByAgeGreaterThanEqualAndAgeLessThanEqualAndRankGreaterThanEqualAndRankLessThanEqual(
                        AgeGe, AgeLe, RankGe, RankLe, pageRequest);

        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("hasNextPage", result.hasNext());
        model.addAttribute("hasPreviousPage", result.hasPrevious());
        model.addAttribute("playerList", result.getContent());

        model.addAttribute("AgeGe", AgeGe);
        model.addAttribute("AgeLe", AgeLe);
        model.addAttribute("RankGe", RankGe);
        model.addAttribute("RankLe", RankLe);
        model.addAttribute("SortType", SortType);
        model.addAttribute("page", page);

        model.addAttribute("addPlayer", new Player());
        model.addAttribute("removePlayer", new Player());
        model.addAttribute("updatePlayer", new Player());
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("sortTypes", SortTypes.values());
        model.addAttribute("ranks", Rank.values());
        return "player/home";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Player addPlayer, Model model){
        if(playerRepository.findByName(addPlayer.getName()) == null) {
            playerRepository.save(addPlayer);
            model.addAttribute("msg", "선수 추가 완료!");
            model.addAttribute("url", "/player");
            return "player/message";
        } else {
            model.addAttribute("msg", "선수 이름 중복!");
            model.addAttribute("url", "/player");
            return "player/message";
        }
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute Player removePlayer, Model model){
        if(playerRepository.findByName(removePlayer.getName()) != null) {
            Player player = playerRepository.findByName(removePlayer.getName());
            playerRepository.delete(player);
            model.addAttribute("msg", "선수 제거 완료!");
            model.addAttribute("url", "/player");
            return "player/message";
        } else {
            model.addAttribute("msg", "해당 선수 없음!");
            model.addAttribute("url", "/player");
            return "player/message";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Player updatePlayer, Model model){
        if(!playerRepository.findById(updatePlayer.getId()).isEmpty()) {
            Player player = playerRepository.findById(updatePlayer.getId()).get();
            player.setName(updatePlayer.getName());
            player.setAge(updatePlayer.getAge());
            player.setRank(updatePlayer.getRank());
            playerRepository.save(player);
            model.addAttribute("msg", "선수 수정 완료!");
            model.addAttribute("url", "/player");
            return "player/message";
        } else {
            model.addAttribute("msg", "해당 선수 없음!");
            model.addAttribute("url", "/player");
            return "player/message";
        }
    }

    @PostMapping("/search")
    public String search(@ModelAttribute SearchForm form, Model model) throws IOException {

        if(form.getAgeGe() == null) { form.setAgeGe(0); }
        if(form.getAgeLe() == null) { form.setAgeLe(999); }
        if(form.getRankGe() == null) { form.setRankGe(Rank.BRONZE); }
        if(form.getRankLe() == null) { form.setRankLe(Rank.DIAMOND); }

        if(form.getAgeGe() > form.getAgeLe()) {
            model.addAttribute("msg", "검색 조건 에러!");
            model.addAttribute("url", "/player");
            return "player/message";
        }
        if(form.getRankGe().compareTo(form.getRankLe()) == 1) {
            model.addAttribute("msg", "검색 조건 에러!");
            model.addAttribute("url", "/player");
            return "player/message";
        }

        return "redirect:/player?page=1&AgeGe="+form.getAgeGe()+"&AgeLe="+form.getAgeLe()+
                "&RankGe="+form.getRankGe()+"&RankLe="+form.getRankLe()+"&SortType="+form.getSortType();
     }

    @PostConstruct
    public void init() {
        String[] nameList = new String[]{"Tom", "Harry", "John", "Kane", "Peter", "Alice", "Jack", "Julia", "Jane", "Lucas",
                                    "Alex", "Bruno", "Charles", "Evan", "Felix", "Henry", "Ian", "James", "Sunny", "Sophia",
                                    "Risa", "Olivia", "Mary"};
        int[] ageList = new int[] {17, 20, 23, 21, 16, 15, 25, 28, 18, 18, 19, 20, 22, 23, 18, 17, 16, 23, 27, 30, 29, 21, 24};
        Rank[] rankList = new Rank[] {Rank.BRONZE, Rank.SILVER, Rank.DIAMOND, Rank.GOLD, Rank.BRONZE, Rank.SILVER, Rank.PLATINUM,
                                    Rank.SILVER, Rank.PLATINUM, Rank.GOLD, Rank.BRONZE, Rank.BRONZE, Rank.DIAMOND, Rank.PLATINUM,
                                    Rank.SILVER, Rank.BRONZE, Rank.GOLD, Rank.SILVER, Rank.DIAMOND, Rank.PLATINUM, Rank.BRONZE,
                                    Rank.BRONZE, Rank.SILVER};
        Player[] players = new Player[30];
        for(int i = 0 ; i < 23 ; i ++) {
            players[i] = new Player();
            players[i].setName(nameList[i]);
            players[i].setAge(ageList[i]);
            players[i].setRank(rankList[i]);
            playerRepository.save(players[i]);
        }

    }
}
