CREATE TABLE users (
    id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    account VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(255),
	address VARCHAR(255),
	permission_type VARCHAR(255) NOT NULL,
	create_date timestamp NOT NULL,
	update_date timestamp,
	constraint User_pk primary key (id),
	constraint User_uk1 unique (account)
);

CREATE TABLE issue (
    id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    type VARCHAR(255),
	create_date timestamp,
	update_date timestamp,
	constraint Issue_pk primary key (id),
	constraint Issue_uk1 unique (type)
);

CREATE TABLE detail_question (
    id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    question VARCHAR(255) NOT NULL,
    answer VARCHAR(255),
	create_date timestamp NOT NULL,
	update_date timestamp,
	constraint DetailQuestion_pk primary key (id)
);

CREATE TABLE detail_bug (
    id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    processing_stage VARCHAR(255) NOT NULL,
    diect_cause VARCHAR(255),
	root_cause VARCHAR(255),
	description VARCHAR(255) NOT NULL,
	cause_analysis VARCHAR(255),
	corrective_action VARCHAR(255),
	create_date timestamp NOT NULL,
	update_date timestamp,
	constraint DetailBug_pk primary key (id)
);

CREATE TABLE detail (
    id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    issue_id int NOT NULL,
    position_id int NOT NULL,
    assignee int NOT NULL,
	name VARCHAR(255) NOT NULL,
	summary VARCHAR(255) NOT NULL,
	file_name VARCHAR(255),
	affachment VARCHAR(255),
	reporter VARCHAR(255) NOT NULL,
	create_date timestamp NOT NULL,
	due_date timestamp,
	constraint Detail_pk primary key (id),
	constraint Detail_uk1 unique (position_id)
);

CREATE TABLE comment (
    id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    detail_id INT NOT NULL,
    comment VARCHAR(255),
	create_date timestamp,
	constraint Comment_pk primary key (id)
);