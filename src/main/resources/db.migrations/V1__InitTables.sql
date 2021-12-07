CREATE TABLE IF NOT EXISTS portfolio (
  idportfolio UUID NOT NULL PRIMARY KEY ,
  description VARCHAR(255) DEFAULT NULL,
  experience_summary VARCHAR(255) DEFAULT NULL,
  id int(11) DEFAULT NULL,
  image_url VARCHAR(255) DEFAULT NULL,
  last_names VARCHAR(255) DEFAULT NULL,
  names varchar(255) DEFAULT NULL,
  tittle varchar(255) DEFAULT NULL,
  twitter_user_id VARCHAR(255) DEFAULT NULL,
  twitter_user_name VARCHAR(255) DEFAULT NULL,
  user_id VARCHAR(255) DEFAULT NULL
);
