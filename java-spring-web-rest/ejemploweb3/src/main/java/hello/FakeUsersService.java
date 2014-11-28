package hello;

import org.springframework.stereotype.Component;

@Component
public class FakeUsersService implements UsersService {

	public int getNumUsers(){
		return 5;
	}	
}
