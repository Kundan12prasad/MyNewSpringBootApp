package com.practice.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.PlanEntity;
import com.practice.service.ExcelService;

@RestController
@RequestMapping("/api/excel")
public class ExcelRestController {
	
	  @Autowired
	  private  ExcelService fileService;
	  
	  @GetMapping(value="/view", produces="application/json")
	  public List<PlanEntity> viewAllData()	  
	  { 
		  List<PlanEntity> data = fileService.getData();		  
		  return data;
		  
	  }	  
	  
	  @GetMapping(value="/download")
	  public ResponseEntity<Resource> getFile() 
	  {
	    String filename = "Plan_Details.xlsx";
	    InputStreamResource file = new InputStreamResource(fileService.load());
	    
	       return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	            .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	            .body(file);
	      }
	

}
