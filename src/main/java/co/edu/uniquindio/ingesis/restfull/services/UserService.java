package co.edu.uniquindio.ingesis.restfull.services;

import co.edu.uniquindio.ingesis.restfull.dtos.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.restfull.dtos.UserResponse;

public interface UserService {
    UserResponse createUser(UserRegistrationRequest request);
}
