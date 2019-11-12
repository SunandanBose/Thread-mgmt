package com.chargebee.controller;

import com.chargebee.model.Job;
import com.chargebee.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.IntStream;
import java.util.concurrent.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping(value = "/job")
    private String createNewBlog(@RequestBody Job job) throws Exception{
       return jobService.createJob(job);
    }
    
    @PostMapping(value = "/calljob")
    private void createNewBlog() throws Exception{
      int limit = 1000;
    	ExecutorService executorService = Executors.newFixedThreadPool(limit/10);
      for (int i = 0; i < limit*10; i++) {
        executorService.execute(new Runnable() {
            public void run() {
              jobService.callcreateJob();
                System.out.println("Asynchronous task ");
            }
        });   
      }
      executorService.shutdown();
    }
}
