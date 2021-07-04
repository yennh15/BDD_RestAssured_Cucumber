package PojoPayload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperCustom {
	private static ObjectMapper objectMapper; 
	public static <T> String ObjectMapper(T object) throws JsonProcessingException {
		objectMapper = new ObjectMapper();
		return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object); 
	}
}
