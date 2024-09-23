package backend.helpinghand.services;

import backend.helpinghand.dtos.DTOUser;
import backend.helpinghand.entities.User;

public interface UserService {
    public User addUser(DTOUser dtoUser);
}
