package com.example.gsonExample;

import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest extends BaseGsonTestClass {

	@Test
	public void testRoundTrip() {
		var user = new User("name", 30);

		String json = gson.toJson(user);
		System.out.println("Serialized json Object: " + json);

		var deserializedUser = gson.fromJson(json, User.class);
		System.out.println("Deserialized object: " + deserializedUser);

		assertEquals(user, deserializedUser);
	}

	@Test
	public void testListOfUsers() {
		List<User> users = List.of(new User("Alice", 30), new User("Anna", 32));

		String json = gson.toJson(users);
		System.out.println("Serialized json Object: " + json);

		List<User> deserializedUsers = gson.fromJson(json, new TypeToken<List<User>>() {
		}.getType());

		assertEquals(users, deserializedUsers);
	}

}