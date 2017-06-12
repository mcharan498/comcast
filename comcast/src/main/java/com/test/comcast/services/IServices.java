package com.test.comcast.services;

import java.util.List;

import com.test.comcast.model.AdCampaign;
public interface IServices {
	
	public AdCampaign  addCampaign(AdCampaign adCampaign);
	
	public AdCampaign getCampaign(String partner_id);
	
	public List<AdCampaign> getAll();
	

}
