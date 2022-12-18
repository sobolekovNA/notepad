package com.example.notepad.services;

import com.example.notepad.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();
    private long id = 0;

    {
        users.add(new User(++id, "test123", "123"));
        users.add(new User(++id, "test321", "321"));
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) return user;
        }
        return null;
    }

    public boolean validateUser(String name, String password) {
        for (User user : users) {
            if ((user.getName().equals(name)) && user.getPassword().equals(password)) return true;
        }
        return false;
    }
}
