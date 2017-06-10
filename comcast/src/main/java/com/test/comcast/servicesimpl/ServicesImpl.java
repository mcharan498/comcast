package com.test.comcast.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.test.comcast.model.AdCampaign;
import com.test.comcast.repository.IRepository;
import com.test.comcast.services.IServices;
@Service
public class ServicesImpl implements IServices{

	
	@Autowired
	IRepository iRepository;
	
	@Override
	public AdCampaign addCampaign(AdCampaign adCampaign) {
		
		return iRepository.save(adCampaign);
	}

	@Override
	public AdCampaign getCampaign(String partner_id) {
		
		AdCampaign adCampaign=iRepository.getOne(partner_id);
		return adCampaign;
	}

	@Override
	public List<AdCampaign> getAll() {
		
		return iRepository.findAll();
	}

}
