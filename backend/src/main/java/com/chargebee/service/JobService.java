package com.chargebee.service;

import com.chargebee.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class JobService {

	@Autowired
	HttpClient httpClient;

    public String createJob(Job job){
        System.out.println("Created Successfully");
        return "Created Successfully!!!";
    }

    public void callcreateJob() {
    	try{
         httpClient.post(new Job(13242323, "abdsfsdfsdsdfsdfc", "adsadassdfdsfsdfsdfsdfsdfsd"));
         return;
     	}catch(Exception e){

     	}
    }

}
