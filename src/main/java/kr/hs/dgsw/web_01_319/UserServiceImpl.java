package kr.hs.dgsw.web_01_319;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> userList;

    public UserServiceImpl() {
        userList = new ArrayList<>();
        userList.add(new User("user1", "user111@dgsw","Tunagiri"));
        userList.add(new User("user2", "user222@dgsw","Lunagiri"));
        userList.add(new User("user3", "user333@dgsw","Lucina"));
    }

    @Override
    public List<User> list() {
        return this.userList;
    }

    @Override
    public User view(String id) {
        return this.userList.stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public User find1(String name){
        Iterator<User> userIterator = this.userList.iterator();
        while (userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getName().equals(name)){
                return user;
            }

        }
        return null;
    }
    public User find2(String name){
        for(User user:this.userList){
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }
    public User find3(String name){
        User found = this.userList.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
        return found;
    }//제일빠른 스트림! 제일많은 메모리!

    @Override
    public boolean add(User user) {
        boolean hasGot =CheeckOverlap(user);
        if(!hasGot)
            return this.userList.add(user);
        return false;
    }

    public boolean CheeckOverlap(User guser){

        for (User user:this.userList) {
            if(guser.getId().equals(user.getId())||
                    guser.getName().equals(user.getName())||
                    guser.getEmail().equals(user.getEmail())){
                return true;
            }
        }
        return false;
    }



    @Override
    public User update(User user) {
        User found = this.view(user.getId());
        if(found!=null){
            found.setEmail(user.getEmail());
            found.setId(user.getId());
            found.setName(user.getName());
        }
        return found;
    }

    @Override
    public boolean delete(String id) {
        User found = this.view(id);
        return this.userList.remove(found);

    }
}
