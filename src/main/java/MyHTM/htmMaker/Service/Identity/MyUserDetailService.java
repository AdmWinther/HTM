package MyHTM.htmMaker.Service.Identity;

import MyHTM.htmMaker.Model.Identity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    private MyUserService myUserService;

    @Autowired
    public MyUserDetailService(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> myUser = myUserService.findUserByEmailAddress(username);
        if(myUser.isPresent()) {
            MyUser userObject = myUser.get();
            UserDetails userDetails = User.builder()
                    .username(userObject.getEmailAddress())
                    .password(userObject.getPassword())
                    .roles(userObject.getRole())
                    .build();
            return userDetails;
        } else {
            throw new UsernameNotFoundException("User"+username+" not found");
        }
    }
}
