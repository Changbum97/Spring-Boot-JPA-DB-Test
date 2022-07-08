package Study.DBTest.dbCRUD.controller;

import Study.DBTest.dbCRUD.domain.User;
import Study.DBTest.dbCRUD.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/create")
    public String create(@RequestParam String name, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userService.save(user);
        return "create complete";
    }

    @GetMapping("/update")
    public String update(@RequestParam Long id, String name, int age) {
        userService.update(id, name, age);
        return "update complete";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        userService.remove(id);
        return "delete complete";
    }

    @GetMapping("/read")
    public String read(@RequestParam @Nullable Long id, String name) {
        if(id != null) {
            return userService.find(id).toString();
        } else {
            System.out.println("=============" + name);
            return userService.findByName(name).toString();
        }
    }

    @GetMapping("/readAll")
    public String readAll() {
        return userService.findAll().toString();
    }

    /*
    http://localhost:8080/create?name=안창범&age=26
    http://localhost:8080/update?id=1&name=changbum&age=27
    http://localhost:8080/delete?id=1
    http://localhost:8080/read?id=1
    http://localhost:8080/readAll
     */
}
