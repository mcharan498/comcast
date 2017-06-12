package com.test.comcast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.comcast.model.AdCampaign;

public interface IRepository extends JpaRepository<AdCampaign,String>{

	@Query("SELECT p FROM AdCampaign p WHERE p.status = :status and p.partner_id = :partner_id")
	public AdCampaign getCampaignByStatus( @Param("partner_id") String partner_id, @Param("status") boolean status);
}
