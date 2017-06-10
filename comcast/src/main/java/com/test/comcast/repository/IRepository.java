package com.test.comcast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.comcast.model.AdCampaign;

public interface IRepository extends JpaRepository<AdCampaign,String>{

}
