package com.songmag.tinyproject;

import com.songmag.tiny.TinyProjectApplication;
import com.songmag.tiny.Repository.dao.UserDAO;
import com.songmag.tiny.service.userService.dto.UserDTO;
import com.songmag.tiny.service.userService.dto.UserSession;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest(classes= TinyProjectApplication.class)
@RunWith(SpringRunner.class)
class TinyProjectApplicationTests {

	@Autowired
	UserDAO userDAO;

	@Test
	void contextLoads() throws Exception {
		Optional<UserSession> user = userDAO.authUser(new UserDTO("test_1@test.test", "qwer1234!",false));
		Optional<UserSession> admin = userDAO.authUser(new UserDTO("AdminTest_1@test.test","qwer1234!",true));
		UserSession session = user.orElseGet(UserSession::new);
		UserSession adminSession = admin.orElseGet(UserSession::new);
		System.out.println(session.toString());
		System.out.println(adminSession.toString());
	}
}