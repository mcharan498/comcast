Create Table AdCampaign(
	partner_id varchar(100)  not null,
	duration int not null,
	ad_content varchar(100) not null,
	primary key (partner_id)
);