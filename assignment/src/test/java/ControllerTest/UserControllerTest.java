package ControllerTest;

import com.uxpsystems.assignment.controller.UserController;
import com.uxpsystems.assignment.entity.User;
import com.uxpsystems.assignment.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserController.class)
public class UserControllerTest {

    @Autowired
    UserController userController;

    @MockBean
    UserService userService;

    @Test
    public void loadAllUsersTest(){
        when(userService.getAllUser()).thenReturn(
                Stream.of(new User(123L,"Danny","password","Activated"),
                        new User(321L,"Bansal","wqrst","Activated"))
                        .collect(Collectors.toList())
        );

        assertEquals(2,userController.loadAllUsers().size());
    }

    @Test
    public void findByIDTest(){
        final Long uid=897448L;
        final User user= new User(897448L, "Rohit", "QWERTT", "Activated");

        when(userService.findUserByID(uid)).thenReturn(
                Optional.of(user));
        final Optional<User> expected=userController.findByID(uid);
        assertThat(expected).isNotNull();
    }

    @Test
    public void createUserTest(){
        User user= new User();
        user.setId(67655L);
        user.setUserName("Prashant");
        user.setPassword("AWQDRk78");
        user.setStatus("Activated");
        assertEquals(userService.addUser(user),userController.createUser(user));
    }

    @Test
    public void updateUserTest(){

        final User user= new User(767676L, "Aadya", "WI782ny", "Activated");

        when(userService.updateUser(user)).thenReturn(user);
        assertEquals(user,userController.updateUser(user));
    }

    @Test
    public void deleteUserTest(){
        final Long uid=56322L;
        userController.deleteUser(uid);
        verify(userService,times(1)).deleteUserById(uid);

    }
}
