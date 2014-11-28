package hello;

import org.springframework.stereotype.Component;

@Component
public class DBUsersService implements UsersService {

	public int getNumUsers(){
		//Connect to a Database...
		return 8;
	}	
}
