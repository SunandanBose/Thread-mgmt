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
       Thread.sleep(10000);
       return jobService.createJob(job);
    }
    @SuppressWarnings({"unchecked","deprecation"})
    @PostMapping(value = "/calljob")
    private void createNewBlog() throws Exception{
    	// IntStream range2 = IntStream.rangeClosed(1, 10000000);
     //    range2.parallel().forEach(i -> jobService.callcreateJob());
    	final int parallelism = 100;
		ForkJoinPool forkJoinPool = null;
		try {
		    forkJoinPool = new ForkJoinPool(parallelism);
		    forkJoinPool.submit(() ->
		    {// Parallel task here, for example
		        IntStream range2 = IntStream.rangeClosed(1, 10000000);
      			range2.parallel().forEach(i -> jobService.callcreateJob());
  			});
		} catch (Exception e){
		    throw new RuntimeException(e);
		} finally {
		    if (forkJoinPool != null) {
		        forkJoinPool.shutdown();
			}
		}
        return;
    }
}
