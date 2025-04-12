package net.petstore.service;

import net.petstore.model.User;
import net.petstore.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public void createUser(User body) {
        //  save the user to the database
        net.petstore.domain.User userDTO = modelMapper.map(body,  net.petstore.domain.User.class);
        userRepository.save(userDTO);


    }


    public void deleteUser( String username) {
        //  find the user by username and delete it

        net.petstore.domain.User user = userRepository.findByUsername(username);
        userRepository.delete(user);

    }

  

    public void updateUser( String username,User body) {
        //  find the user by username and update it
        net.petstore.domain.User user = userRepository.findByUsername(username);
        user.setFirstName(body.getFirstName());
        user.setLastName(body.getLastName());
        user.setEmail(body.getEmail());
        user.setPassword(body.getPassword());
        userRepository.save(user);

    }

    public String loginUser( String username,  String password) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public void logoutUser() {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

}
