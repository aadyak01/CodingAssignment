package ServiceTest;

import com.uxpsystems.assignment.dao.UserDAO;
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
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserService.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserDAO userDAO;

    @Test
    public void getAllUserTest(){

        when(userDAO.findAll()).thenReturn(
                Stream.of(new User(123L,"Danny","password","Activated"),
                        new User(321L,"Bansal","wqrst","Activated"))
                .collect(Collectors.toList())
        );

        assertEquals(2,userService.getAllUser().size());
    }

    @Test
   public void findUserByIDTest(){
      final Long uid=123L;
      final User user= new User(123L, "Messi", "Football", "Activated");

        when(userDAO.findById(uid)).thenReturn(
                Optional.of(user));
        final Optional<User> expected=userService.findUserByID(uid);
        assertThat(expected).isNotNull();
    }

    @Test
    public void addUserTest(){
        User user= new User();
        user.setId(55555L);
        user.setUserName("Digvijay");
        user.setPassword("AWQDRk78");
        user.setStatus("De-Activated");
        userDAO.save(user);
        assertThat(user.getId().equals(55555L));
    }


    @Test
    public void updateUserTest(){

        final User user= new User(23452L, "Vaibhav", "Covid", "Activated");

        when(userDAO.save(user)).thenReturn(user);
        assertEquals(user,userService.updateUser(user));
    }

    @Test
    public void deleteUserByIdTest(){
        final Long uid=56322L;
        userService.deleteUserById(uid);
       verify(userDAO,times(1)).deleteById(uid);

    }
}
