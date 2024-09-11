CREATE SEQUENCE IF NOT EXISTS admin_users_id_seq;

CREATE TABLE IF NOT EXISTS admin_users (
    id int8 NOT NULL DEFAULT nextval('admin_users_id_seq'::regclass),
    created_by varchar(255),
    created_date timestamp,
    last_modified_date timestamp,
    modified_by varchar(255),
    account_nonexpired bool NOT NULL,
    account_nonlocked bool NOT NULL,
    credentials_expired_date timestamp,
    credentials_nonexpired bool NOT NULL,
    last_name varchar(120) NOT NULL,
    name varchar(120) NOT NULL,
    password varchar(80) NOT NULL,
    phone varchar(20),
    username varchar(280) NOT NULL,
    attempts int4,
    email varchar(255) NOT NULL,
    status varchar(20) NOT NULL,
    unique_id varchar(40) NOT NULL,
    PRIMARY KEY (id)
    );