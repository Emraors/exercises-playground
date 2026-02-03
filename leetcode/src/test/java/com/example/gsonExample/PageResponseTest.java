package com.example.gsonExample;

import org.junit.jupiter.api.Test;

public class PageResponseTest extends BaseGsonTestClass {

	@Test
	public void testPageResponse() {

		String json = "{\n" +
				"  \"data\": [\n" +
				"    {\"id\":\"t1\",\"amount\":100},\n" +
				"    {\"id\":\"t2\",\"amount\":200}\n" +
				"  ],\n" +
				"  \"page\":1,\n" +
				"  \"total_pages\":5\n" +
				"}";

		PageResponse response = gson.fromJson(json, PageResponse.class);

		System.out.println("Response deserialized: " + response);
	}
}
