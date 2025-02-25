package co.edu.uniquindio.ingesis.restfull.services;

import co.edu.uniquindio.ingesis.restfull.domain.User;
import co.edu.uniquindio.ingesis.restfull.dtos.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.restfull.dtos.UserResponse;
import co.edu.uniquindio.ingesis.restfull.mappers.UserMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

//    @Inject
    final UserMapper userMapper;

    @Transactional
    public UserResponse createUser(UserRegistrationRequest request) {
        // Lógica para crear un usuario

        User user = userMapper.parseOf(request);
        user.persist();

        return userMapper.toUserResponse(user);
    }
}