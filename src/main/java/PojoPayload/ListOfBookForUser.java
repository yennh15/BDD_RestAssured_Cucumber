package PojoPayload;

import java.util.List;

public class ListOfBookForUser {
	public String userId;
	public List<CollectionOfIsbns> collectionOfIsbns;

	public ListOfBookForUser(String userId, List<CollectionOfIsbns> collectionOfIsbns) {
		super();
		this.userId = userId;
		this.collectionOfIsbns = collectionOfIsbns;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<CollectionOfIsbns> getCollectionOfIsbns() {
		return collectionOfIsbns;
	}

	public void setCollectionOfIsbns(List<CollectionOfIsbns> collectionOfIsbns) {
		this.collectionOfIsbns = collectionOfIsbns;
	}
}
