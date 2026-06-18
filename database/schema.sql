create table Users(
user_id INT auto_increment PRIMARY KEY,
full_name VARCHAR(100) NOT NULL,
email VARCHAR(100) unique not null,
pass_hash VARCHAR(255) not null,
phone_number VARCHAR(15) not null,
blood_group ENUM('O+','O-','A+','A-','B+','B-','AB+','AB-') not null,
role ENUM('DONOR','RECIPIENT','ADMIN') not null,
city VARCHAR(50),
state VARCHAR(50),
created_at TIMESTAMP DEFAULT current_timestamp
);






CREATE TABLE blood_requests(
	req_id INT auto_increment PRIMARY KEY,
    recipient_id INT NOT NULL,
    blood_group ENUM('O+','O-','A+','A-','B+','B-','AB+','AB-') not null,
    units_req INT not null,
    hospital_name VARCHAR(100) not null,
    city VARCHAR(100) not null,
    urgency ENUM('LOW','MEDIUM','HIGH','CRITICAL') not null,
    status ENUM('OPEN','FULFILLED','CANCELLED') default 'OPEN',
    created_at timestamp default current_timestamp,
    FOREIGN KEY(recipient_id) references users(user_id)
);


CREATE TABLE donation_history(
donation_id INT AUTO_INCREMENT PRIMARY KEY,
donor_id INT NOT NULL,
recipient_id INT NOT NULL,
req_id INT NOT NULL,
donation_date DATE NOT NULL,
foreign key(donor_id) references users(user_id),
foreign key(recipient_id) references users(user_id),
foreign key(req_id) references blood_requests(req_id)
);


CREATE TABLE in_app_alerts(
notification_id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
title varchar(100) NOT NULL,
message text not null,
is_read boolean default false,
created_at timestamp default current_timestamp,
foreign key (user_id)references users(user_id)
);


create table refresh_tokens(
token_id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
token varchar(255) unique not null,
expiry_date datetime not null,
foreign key (user_id) references users(user_id)
);