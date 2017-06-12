package com.test.comcast.servicesimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
		
		// get ad for a given partnet_id AND status is active
		AdCampaign adExisting = iRepository.getCampaignByStatus(adCampaign.getPartner_id(), true);
		
		if(null != adExisting){
			Date currDate = new Date();
			long diff = currDate.getTime() -  adExisting.getCreate_date().getTime();
			long noOfDaysPassed = diff / (1000 * 60 * 60 * 24);
	
			if(noOfDaysPassed > adExisting.getDuration()){
				
				adExisting.setStatus(false);
				
				adCampaign.setStatus(true);
				adCampaign.setCreate_date(currDate);
				return iRepository.save(adCampaign);
			}
			else
				return adExisting;
		}else
		{
			Date currDate = new Date();
			adCampaign.setStatus(true);
			adCampaign.setCreate_date(currDate);
			return iRepository.save(adCampaign);
		}
			

		 
	}

	@Override
	public AdCampaign getCampaign(String partner_id) {
		
		AdCampaign adExisting = iRepository.getCampaignByStatus(partner_id, true);
		
		if(null != adExisting){
			Date currDate = new Date();
			long diff = currDate.getTime() -  adExisting.getCreate_date().getTime();
			long noOfDaysPassed = diff / (1000 * 60 * 60 * 24);
	
			if(noOfDaysPassed > adExisting.getDuration()){

				return null; // no active
			}
			else
				return adExisting;
		}
		
		return null;
	}

	@Override
	public List<AdCampaign> getAll() {
		
		return iRepository.findAll();
	}

}
