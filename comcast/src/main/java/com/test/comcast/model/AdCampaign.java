package com.test.comcast.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AdCampaign {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	int duration;
	String ad_content;
	String partner_id;
	Boolean status;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	Date create_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public AdCampaign() {

	}

	public AdCampaign(int id, int duration, String ad_content, String partner_id, Boolean status, Date create_date) {
		super();
		this.id = id;
		this.duration = duration;
		this.ad_content = ad_content;
		this.partner_id = partner_id;
		this.status = status;
		this.create_date = create_date;
	}

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

	@Override
	public String toString() {
		return "AdCampaign [id=" + id + ", duration=" + duration + ", ad_content=" + ad_content + ", partner_id="
				+ partner_id + ", status=" + status + ", create_date=" + create_date + "]";
	}
	
	
}
