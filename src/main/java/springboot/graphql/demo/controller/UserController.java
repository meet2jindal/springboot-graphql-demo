package springboot.graphql.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.graphql.demo.entity.Address;
import springboot.graphql.demo.entity.User;
import springboot.graphql.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    private User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @QueryMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @QueryMapping
    public User findById(@Argument Integer id) {
        return userService.findById(id).orElse(null);

    }

    @SchemaMapping
    public Address address(User user) {
        return user.getAddress();
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument Address address) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        return userService.saveUser(user);


    }

}
