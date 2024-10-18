package service;

import org.example.domaine.Role;
import org.example.domaine.User;
import org.example.errors.UserIsNullException;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setId(5L);
        user.setName("zakaria kh");
        user.setEmail("zakaria@gmail.com");
        user.setPassword("zaass@1234");
        user.setRole(Role.MANAGER);
        user.setTokenDelete(1);
        user.setTokenResingne(2);
//        doNothing().when(userRepository).save(user);

        userService.saveUser(user);
//        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testSaveNull(){
        assertThrows(UserIsNullException.class, () -> userService.saveUser(null));
        verify(userRepository, never()).save(any(User.class));
    }










}
