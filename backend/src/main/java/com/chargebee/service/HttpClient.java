package com.chargebee.service;

import org.springframework.stereotype.Service;
import java.net.*;
import com.chargebee.model.Job;
import java.util.*;
import java.lang.*;
import java.io.*;
import okhttp3.*;

@Service
class HttpClient{

	public void post(Job job) throws Exception{
		URL url = new URL("http://localhost:8080/job");
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{ \t\"companyname\"  : \"ABC\", \t\"jobdescription\" : \"Software Engineer\", \t\"offeredSalary\"  : \"100000000\" }");
		Request request = new Request.Builder()
		  .url(url)
		  .post(body)
		  .addHeader("Accept", "application/json")
		  .addHeader("Content-Type", "application/json")
		  .build();

		Response response = client.newCall(request).execute();
		}
}


