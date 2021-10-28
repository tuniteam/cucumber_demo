package com.expertsdutest.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.expertsdutest.demo.model.User;

public class LoginService {
	public List<User> users = new ArrayList<>();

	public LoginService() {
		users.add(new User("Fares", "Mallouli", "fares.mallouli@expertsdutest.com", "qwerty"));
		users.add(new User("Bassem", "Abid", "bassem.abid@expertsdutest.com", "abcdef"));
		users.add(new User("Oussema", "Chaari", "oussema.chaari@expertsdutest.com", "azerty"));
	}

	public String login(String email, String password) {
		Optional<User> user = users.stream().filter((User usr) -> usr.getEmail().equals(email)).findFirst();
		if (user.isPresent() == false) {
			return "Email doesn't exist";
		}
		if (!user.get().getPassword().equals(password)) {
			return "Incorrect password used";
		}
		return "Welcome " + user.get().getFirstName() + " !";
	}

}
