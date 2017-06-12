package com.test.comcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.test.comcast.model.AdCampaign;
import com.test.comcast.repository.IRepository;
import com.test.comcast.services.IServices;
import com.test.comcast.servicesimpl.ServicesImpl;

@RestController
public class MyRestController {

	@Autowired
	IServices iServices;
	
	@RequestMapping(value="/ad",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity print(@RequestBody AdCampaign adCampaign){

		AdCampaign adFromStore = iServices.addCampaign(adCampaign);
		
		if(adCampaign == adFromStore)
			return new ResponseEntity<AdCampaign>(adCampaign, HttpStatus.OK);
		else
			return new ResponseEntity<String>("Active AdCompaign is already there in the System. You cannot have more than one active AdCompaing.", HttpStatus.EXPECTATION_FAILED);
	}

	@RequestMapping(value="/listall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<AdCampaign>> getall(){

		return new ResponseEntity<List<AdCampaign>>(iServices.getAll(),HttpStatus.OK);

	}
		

	@RequestMapping(value="/ad/{partner_id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getcampaign(@PathVariable String partner_id){

		AdCampaign adActive  = iServices.getCampaign(partner_id);
		
		if(null != adActive)
			return new ResponseEntity<AdCampaign>(adActive,HttpStatus.OK);
		else
			return new ResponseEntity<String>("No Active AdCompaings Exists!!!",HttpStatus.OK);
		

	}

	
	
	
}
