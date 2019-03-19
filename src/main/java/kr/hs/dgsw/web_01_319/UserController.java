package kr.hs.dgsw.web_01_319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    private  UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public List<User> list(){
        return this.userService.list();
    }

    @GetMapping("/user/{name}")
    public User view(@PathVariable String name){
        return this.userService.view(name);
    }

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user){
        return this.userService.add(user);
    }

    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user){
       return this.userService.update(user);
    }

    @DeleteMapping("/user/{name}")
    @ResponseBody
    public boolean delete(@PathVariable String name){
       return this.userService.delete(name);
    }
    //GET(read) POST(insert) PUT(update) DELETE(delete)
    //CRUD Create Read Update Delete
    //SQL  insert select update delete

}
