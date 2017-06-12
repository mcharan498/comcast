Create Table AdCampaign(
	id integer IDENTITY PRIMARY KEY,
	partner_id varchar(100)  not null,
	duration int not null,
	ad_content varchar(100) not null,
	status boolean,
	create_date date
);