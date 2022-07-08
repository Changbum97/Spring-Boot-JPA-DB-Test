package Study.DBTest.Paging;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/paging")
public class PagingController {

    private final PageRepository pageRepository;

    @ResponseBody
    @GetMapping("/add")
    public String addContent(@RequestParam String title, String writer) {
        Content content = new Content();
        content.setTitle(title);
        content.setWriter(writer);
        Content saveContent = pageRepository.save(content);
        Long id = saveContent.getId();
        return id + "글 작성 완료";
    }

    @ResponseBody
    @GetMapping("/edit")
    public String editContent(@RequestParam Long id, String title, String writer) {
        Content content = new Content();
        content.setId(id);
        content.setTitle(title);
        content.setWriter(writer);
        pageRepository.save(content);
        return "글 수정 완료";
    }


    @ResponseBody
    @GetMapping("/contents")
    public Page<Content> contentList(@RequestParam int page) {
        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        return pageRepository.findAll(pageRequest);
    }

    @ResponseBody
    @GetMapping("/findw")
    public Content findByWriter(@RequestParam String writer) {
        return pageRepository.findByWriter(writer);
    }

    @ResponseBody
    @GetMapping("/findwt")
    public Content findByWriterAndTitle(@RequestParam String writer, String title) {
        return pageRepository.findByWriterAndTitle(writer, title);
    }

    @ResponseBody
    @GetMapping("/findwc")
    public List<Content> findByWriterContain(@RequestParam String wcontain) {
        return pageRepository.findByWriterContains(wcontain);
    }


    @ResponseBody
    @GetMapping("/delete")
    public String deleteContent(@RequestParam Long id) {
        pageRepository.deleteById(id);
        return "글 삭제 완료";
    }

    @PostConstruct
    public void init() {
        Content[] contents = new Content[30];
        for(int i = 1 ; i <= 25 ; i ++) {
            contents[i] = new Content();
            contents[i].setTitle("제목 " + i);
            contents[i].setWriter("작성자 " + i);
            pageRepository.save(contents[i]);
        }
    }
}
