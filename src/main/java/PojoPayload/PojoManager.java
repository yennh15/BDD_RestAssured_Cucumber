package PojoPayload;

public class PojoManager {
public static CreateRepoPOJO createRepoPOJO; 

public static CreateRepoPOJO getCreateRepoPOJOObject(String name, String description) { 
	return createRepoPOJO = new CreateRepoPOJO(name,description);
}
}
