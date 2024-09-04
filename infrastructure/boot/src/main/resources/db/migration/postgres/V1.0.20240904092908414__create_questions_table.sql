-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS questions_id_seq;

-- Create table 'questions' only if it doesn't exist
CREATE TABLE IF NOT EXISTS questions (
    id int8 NOT NULL DEFAULT nextval('questions_id_seq'::regclass),
    created_by varchar(255),
    created_date timestamp,
    last_modified_date timestamp,
    modified_by varchar(255),
    unique_id varchar(40) NOT NULL,
    question TEXT NOT NULL,
    axis varchar(1) NOT NULL,
    PRIMARY KEY (id)
);