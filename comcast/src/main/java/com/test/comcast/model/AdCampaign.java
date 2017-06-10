package com.test.comcast.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdCampaign {

	int duration;
	String ad_content;
	
	public AdCampaign(){
		
	}
	public AdCampaign(int duration, String ad_content, String partner_id) {
		super();
		this.duration = duration;
		this.ad_content = ad_content;
		this.partner_id = partner_id;
	}

	@Id
	String partner_id;
	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAd_content() {
		return ad_content;
	}

	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
}
