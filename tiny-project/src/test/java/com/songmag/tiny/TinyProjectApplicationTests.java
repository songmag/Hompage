package com.songmag.tiny;

import com.songmag.tiny.Repository.dao.UserDAO;
import com.songmag.tiny.service.google.GoogleToken;
import com.songmag.tiny.service.google.OauthGoogle;
import com.songmag.tiny.util.jwt.KeyUtil;
import com.songmag.tiny.util.jwt.RsaJwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes= TinyProjectApplication.class)
@RunWith(SpringRunner.class)
class TinyProjectApplicationTests {

	@Autowired
	UserDAO userDAO;
	@Autowired
	OauthGoogle oauthGoogle;

	/*
	@Test
	void signInUser() throws Exception{
		Optional<UserSession> user = userDAO.authUser(new UserDTO("test_1@test.test", "qwer1234!",false));
		Optional<UserSession> admin = userDAO.authUser(new UserDTO("AdminTest_1@test.test","qwer1234!",true));
		UserSession session = user.orElseGet(UserSession::new);
		UserSession adminSession = admin.orElseGet(UserSession::new);
		System.out.println(session.toString());
		System.out.println(adminSession.toString());
	}
	@Test
	@Transactional(rollbackFor=TransactionalException.class)
	void signUpUser(){
		UserAddDTO dto = new UserAddDTO();
		dto.setName("TEST_30");
		dto.setAddress("TEST");
		dto.setAddressNum("24920293");
		dto.setPassword("qwer1234!");
		dto.setPhoneNumber("1020394028");
		dto.setUserId("TEST_30@test.test");
		userDAO.addUserId(dto);
		userDAO.addUserInfo(dto);
	}
	*/
	/*
	@Test
	void jwtHSTest(){
		try {
			System.out.println(oauthGoogle.getJwtToken("test","test1234"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis()/1000L);
		System.out.println(System.currentTimeMillis()/1000L+(3600));
	}
	 */

	/*
	@Test
	void jwtRSTest() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		KeyUtil.KeyUtilBuilder builder = KeyUtil.getBuilder();
		String publicKey = "-----BEGIN PUBLIC KEY-----\\nMIIC/DCCAeSgAwIBAgIIW4K1pRxZEoYwDQYJKoZIhvcNAQEFBQAwIDEeMBwGA1UE\\nAxMVMTE0MjkxNTgzNTAxMzI1NzA3MDU1MCAXDTIwMTAyNTExMTU0MVoYDzk5OTkx\\nMjMxMjM1OTU5WjAgMR4wHAYDVQQDExUxMTQyOTE1ODM1MDEzMjU3MDcwNTUwggEi\\nMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCyfNzwr6gnhQiTwGNGHR9C6fCS\\na+1rKPLFw7adtRxJaT28kXosYQJWbis+KyyZHjJbvV+0p88BLmVKaoBK59Pf8fhS\\nG0lIY097O3d+LmF+HI7WAKADV5jBMvJJcjnRpgAHzK7nTcddVbHJhhifsDqZ8Ie5\\ncUITBpEXKqXVSLF85NXg+4TUP3IrYl5NQssFH9hspXG/mbClkBDOEIZEHksNcSZX\\ns2quOcLaNzOe6XpyGm4O1PyUM48xS6j8sKh+Xv+5bTEy3tuBfSygGEr5VJaZwSGO\\nugWtpO/hOWWR4Rcs/8w6RCZ/pxPawYcQXtuEKMiGEXJdgr/TE5msDVjQhuibAgMB\\nAAGjODA2MAwGA1UdEwEB/wQCMAAwDgYDVR0PAQH/BAQDAgeAMBYGA1UdJQEB/wQM\\nMAoGCCsGAQUFBwMCMA0GCSqGSIb3DQEBBQUAA4IBAQBVNXm7ulDYe9KyAcr35RUo\\nvzkBwfVzknefBx1byza3he5Y8PJh8ziHF/BZpO++ijqwmgYhfF3mM59L2tPugweZ\\nzAfXwZIc3eEcBWS44405Rr7w/TpCw0q7mTjDymFJ1p4aPMkw2JeJyvGrhExuAwT7\\nLIvWp1jBLs1L9zrLCFeJI+1gjcoGXwKn+JV4V1TVllPVu+Yfj22pvx7WZhk/lFgh\\nUXr2g+pZKrwfj6EqV1dOry1ZFGW9KDFdzf/SQ2jjCuCqvvQUGGm1SiFblIbzg5pM\\nfClB/eBKeUIhUTu1XNHBXJ6O3PBhJ54US6l5SeZgnQagX65OD0GkkI+JewROfiKI\\n-----END PUBLIC KEY-----\\n";
		String privateKey = "-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCyfNzwr6gnhQiT\\nwGNGHR9C6fCSa+1rKPLFw7adtRxJaT28kXosYQJWbis+KyyZHjJbvV+0p88BLmVK\\naoBK59Pf8fhSG0lIY097O3d+LmF+HI7WAKADV5jBMvJJcjnRpgAHzK7nTcddVbHJ\\nhhifsDqZ8Ie5cUITBpEXKqXVSLF85NXg+4TUP3IrYl5NQssFH9hspXG/mbClkBDO\\nEIZEHksNcSZXs2quOcLaNzOe6XpyGm4O1PyUM48xS6j8sKh+Xv+5bTEy3tuBfSyg\\nGEr5VJaZwSGOugWtpO/hOWWR4Rcs/8w6RCZ/pxPawYcQXtuEKMiGEXJdgr/TE5ms\\nDVjQhuibAgMBAAECggEAAV7ji6+gTzspP2xVE0cKh7G9b9GHW/EIK8wQdhzNcBXF\\npRkC5nNYfBVR8gaNL2cqy4AdS4k/61FY8shnXl2rDrIluN3qcVHPsg31kzunnXQI\\nlBrpreI5fenhE6lsnsyW0rFmMx2G9XcH1m5Jzcl3KqEiZwX/Wy19yaKW7fttUQ6X\\nh9oCWvBcBqtCemIVxJ+7nPEGcinRKSVwAD7FzWCQl/7WzhHtzZI9UmO7iJkIPvqw\\naNzpfsiUt93GMbxBeBDiDRnfBUae7fqu/W1Hl5yJi3HddFvB1WN9dSkelk6u6tse\\nxmzRIu9zo65To/lICJDSo1v9AhpiBRqOiyOU8rYx9QKBgQDf1IDhKsUZ6C7YDk1Z\\nrPYMNGey/Wn8aUERX75p9FNjQqQb+KwB80oGKyn3OAeQLq84S2diymyQu4IEi1ju\\nyLoiBVcqFE1FI3fCMP0MER94pTHBtztx5mT+A/Rl1tJM4rrQCObVnQvx6DwSLo9l\\no/px+SMYKI0BhxXl0VVMKgQHJQKBgQDMJA4hwK66FNLqjMfeWMjVOv8uFrBYNs35\\n6Yhtyp4+EKnf4ym5TA3UuSQNS5tubP4oZgmULZtGsG3pFFa+1JQMewODPmbBRTVj\\nJLt+br15EnKZ6ey/OSrilZCixFSeC2bi0kD4DR6VqGLuC8IsylpuiOHYKwoya6/i\\n+dM3/fUEvwKBgFBfcSvpfL8xxWhlslbKKcv2IWp/Xsh5TxkbBTfsuOjCrEUzBSjq\\nIKGYbEhOgUC/0sFnKieqQlOyURyqoPOVdmjy+/qrMZfrBXzgtGzZ1TAwOW6zChB7\\nR7aC2waangdnvucm2yTHcNubpb5to6Y+vJaifHyXSxLKXA2bHoLr72hVAoGBALzc\\nvpZLhVty2I9XH7J9wZBEvMEPDKcQTQ/hFu88fZo+IGuZ5ogf7MvZXZlPUcWf4KPP\\ngx0r9HQ51fXFc1upoC7LwDw0ByzXssS+vxgBrBnPD2eGHBnt8dcfOGjd6sstEUrX\\n6nOS77DV0HEbP9HghDmvOgKcDxsGtfrv1pH+yihRAoGBAMTdOAZrGPHo39Br3rRu\\n8rLaVeZjnoz8ZobhRRavy45n9tN7G7cCABt8B+qncwuu+gbKQHhepeDm95+NhgR/\\nuDGb19kK8+u8OYs47cy46x+9lONeXLSwnl9DIVsXdhsJeyIfhBUXDm9+QGSuvT3/\\nUXsLJJpTo3MCePwu7fzIiEoN\\n-----END PRIVATE KEY-----\\n";
		RsaJwtUtil util = new RsaJwtUtil(builder.createBuilder().setKeySet(publicKey,privateKey).build());
		Map<String,Object> object = new HashMap<String,Object>();
		object.put("userId","TEST");
		object.put("pwd","qwer1234~!");
		System.out.println(util.getJwt(object,"RS256"));
	}

	@Test
	void testAuth() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		RestTemplate template= new RestTemplate();
		String body ="urn:ietf:params:oauth:grant-type:jwt-bearer";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//MultiValueMap<String,String> header = new LinkedMultiValueMap<String,String>();
		//Map<String,String> value = new HashMap<String,String>();
		//value.put("Content-Type","application/x-www-form-urlencoded");
		//header.setAll(value);
		Map<String,String> bodyMap = new HashMap<String,String>();
		bodyMap.put("grant_type",body);
		bodyMap.put("assertion",oauthGoogle.getJwtToken());
		HttpEntity<?> entity = new HttpEntity<>(bodyMap,headers);
		ResponseEntity<GoogleToken> token  = template.postForEntity("https://oauth2.googleapis.com/token",entity, GoogleToken.class);
		GoogleToken gtocken = token.getBody();
		System.out.println(gtocken.getAccess_token());
		Map<String,String> body2 = new HashMap<String,String>();
		HttpEntity<?> entity2 = new HttpEntity<>(body2,headers);
		String rest = template.getForObject("https://www.googleapis.com/calendar/v3/users/me/calendarList?access_token="+gtocken.getAccess_token(),String.class,entity2);
		System.out.println(rest);
	}
	*/

}