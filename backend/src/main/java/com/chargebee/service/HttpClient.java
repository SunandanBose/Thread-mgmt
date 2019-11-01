package com.chargebee.service;

import org.springframework.stereotype.Service;
import java.net.*;
import com.chargebee.model.Job;
import java.util.*;
import java.lang.*;
import java.io.*;
@Service
class HttpClient{

	public void post(Job job) throws Exception{
		URL url = new URL("http://localhost:8080/job");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		Map<String, String> parameters = new HashMap<>();
		parameters.put("companyname", job.companyname);
		parameters.put("offeredsalary", job.offeredSalary);
		parameters.put("jobdescription", job.companyname+job.offeredSalary); 
		con.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		out.flush();
		out.close();
		int status = con.getResponseCode();
	}
}


