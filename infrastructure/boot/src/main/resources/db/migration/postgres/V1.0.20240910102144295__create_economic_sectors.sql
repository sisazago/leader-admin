-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS economic_sectors_id_seq;

-- Create table 'economic_sectors' only if it doesn't exist
CREATE TABLE IF NOT EXISTS economic_sectors (
    id int8 NOT NULL DEFAULT nextval('economic_sectors_id_seq'::regclass),
    created_by varchar(255),
    created_date timestamp,
    last_modified_date timestamp,
    modified_by varchar(255),
    sector_name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);