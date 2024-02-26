CREATE TABLE USERS
(
   id INT PRIMARY KEY,
   user_name VARCHAR(255) NOT NULL,
   first_name VARCHAR(255) NOT NULL,
   city VARCHAR(255) NOT NULL,
   state VARCHAR(255) NOT NULL,
   zip_code VARCHAR(255) NOT NULL,
   peanut_allergies BIT,
   egg_allergies BIT,
   dairy_allergies BIT
);

CREATE TABLE RESTAURANT

(
   id INT PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   zip_code VARCHAR(255) NOT NULL,
   peanut_score INT,
   peanut_review_amount INT,
   egg_score INT,
   egg_review_amount INT,
   dairy_score INT,
   dairy_review_amount INT,
   overall_score INT
);

CREATE TABLE DINING_REVIEW
(
  id INT PRIMARY KEY,
  submitter_name VARCHAR(255),
  restaurant_id INT,
  peanut_score INT,
  egg_score INT,
  dairy_score INT,
  comment VARCHAR(255),
  review_status VARCHAR(255)
);