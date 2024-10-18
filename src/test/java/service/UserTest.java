package service;

import org.example.domaine.Role;
import org.example.domaine.User;
import org.example.errors.EmailExistException;
import org.example.errors.EmailFormatInvalid;
import org.example.errors.UserIsEmptyException;
import org.example.errors.UserIsNullException;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.stream.Stream;

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
    public void testSaveNull(){
        assertThrows(UserIsNullException.class, () -> userService.saveUser(null));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void testSaveEmptyName(){
        assertThrows(UserIsEmptyException.class, () -> userService.saveUser(new User()));
        verify(userRepository, never()).save(any(User.class));
    }

    static Stream<User> userGenerateOld() {
        return Stream.of(
                new User("zak","zakk@gmail.com","zasas",Role.USER)
        );
    }

    @ParameterizedTest
    @MethodSource("userGenerateOld")
    public void testSaveNewUserByEmailAlreadyExist(User user){
        when(userService.findUserByEmail(user.getEmail())).thenReturn(user);

        assertThrows(EmailExistException.class, () ->
                userService.saveUser(user)
        );
    }






















}
