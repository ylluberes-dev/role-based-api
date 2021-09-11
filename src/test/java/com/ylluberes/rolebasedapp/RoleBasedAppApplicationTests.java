package com.ylluberes.rolebasedapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleBasedAppApplicationTests {

	@Autowired
	private PasswordEncoder enconder;

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldEncryptPasswordUsingBCryptPasswordEncoder () {
		final String password = enconder.encode("12345");
		System.out.println(password);
	}

}
