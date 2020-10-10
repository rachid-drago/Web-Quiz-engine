package engine.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public class UserController {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public UserController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(path = "/api/register", consumes = "application/json")
    public ResponseEntity<User> saveUser(@Valid @RequestBody  User user) {
        userDetailsService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping(path = "/api/xyz")
    public ResponseEntity<User> getSmth() {
        User user=new User();
        user.setEmail("email");
        user.setPassword("pass");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
