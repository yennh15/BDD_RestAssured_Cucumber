package PojoPayload;

import java.util.List;

public class ObjectManager {
public static CreateRepoPOJO createRepoPOJO; 
public static AuthorizationRequest authorizationRequest; 
public static ListOfBookForUser listOfBookForUser; 
public static RemoveBookRequest removeBookRequest; 

public static CreateRepoPOJO getCreateRepoPOJOObject(String name, String description) { 
	return createRepoPOJO = new CreateRepoPOJO(name,description);
}

public static AuthorizationRequest getAuthorizationRequest(String userName, String password) { 
	return authorizationRequest = new AuthorizationRequest(userName,password);
}

public static ListOfBookForUser getListOfBookForUserPOJOObject(String userId, List<CollectionOfIsbns> collectionOfIsbns) { 
	return listOfBookForUser = new ListOfBookForUser(userId,collectionOfIsbns);
}
public static RemoveBookRequest getRemoveBookRequest(String isbn,String userId) { 
	return removeBookRequest = new RemoveBookRequest(isbn,userId);
}
}
