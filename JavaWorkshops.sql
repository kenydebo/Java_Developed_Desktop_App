ALTER TABLE `travelexperts`.`customers` 
ADD COLUMN `CustPassword` VARCHAR(25) NOT NULL COMMENT '' AFTER `AgentId`;

UPDATE customers SET CustPassword = 123 WHERE CustPassword <> 123;


CREATE TABLE IF NOT EXISTS Nations (
  NationCode CHAR(2) NOT NULL PRIMARY KEY,
  NationName CHAR(40) NOT NULL
);

INSERT INTO Nations VALUES ('CA', 'Canada');
INSERT INTO Nations VALUES ('US', 'United States');



CREATE TABLE IF NOT EXISTS States (
  StateId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  StateName CHAR(40) NOT NULL,
  StateCode CHAR(2) NOT NULL,
  NationCode CHAR(2) NOT NULL,
  FOREIGN KEY (NationCode) REFERENCES Nations(NationCode)
);
 
INSERT INTO States VALUES (NULL, 'Alberta', 'AB', 'CA');
INSERT INTO States VALUES (NULL, 'British Columbia', 'BC', 'CA');
INSERT INTO States VALUES (NULL, 'Manitoba', 'MB', 'CA');
INSERT INTO States VALUES (NULL, 'New Brunswick', 'NB', 'CA');
INSERT INTO States VALUES (NULL, 'Newfoundland and Labrador', 'NL', 'CA');
INSERT INTO States VALUES (NULL, 'Northwest Territories', 'NT', 'CA');
INSERT INTO States VALUES (NULL, 'Nova Scotia', 'NS', 'CA');
INSERT INTO States VALUES (NULL, 'Nunavut', 'NU', 'CA');
INSERT INTO States VALUES (NULL, 'Ontario', 'ON', 'CA');
INSERT INTO States VALUES (NULL, 'Prince Edward Island', 'PE', 'CA');
INSERT INTO States VALUES (NULL, 'Quebec', 'QC', 'CA');
INSERT INTO States VALUES (NULL, 'Saskatchewan', 'SK', 'CA');
INSERT INTO States VALUES (NULL, 'Yukon', 'YT', 'CA');

INSERT INTO States VALUES (NULL, 'Alaska', 'AK', 'US');
INSERT INTO States VALUES (NULL, 'Alaska', 'AK', 'US');
INSERT INTO States VALUES (NULL, 'Alabama', 'AL', 'US');
INSERT INTO States VALUES (NULL, 'Arizona', 'AZ', 'US');
INSERT INTO States VALUES (NULL, 'Arkansas', 'AR', 'US');
INSERT INTO States VALUES (NULL, 'California', 'CA', 'US');
INSERT INTO States VALUES (NULL, 'Colorado', 'CO', 'US');
INSERT INTO States VALUES (NULL, 'Connecticut', 'CT', 'US');
INSERT INTO States VALUES (NULL, 'Delaware', 'DE', 'US');
INSERT INTO States VALUES (NULL, 'District of Columbia', 'DC', 'US');
INSERT INTO States VALUES (NULL, 'Florida', 'FL', 'US');
INSERT INTO States VALUES (NULL, 'Georgia', 'GA', 'US');
INSERT INTO States VALUES (NULL, 'Hawaii', 'HI', 'US');
INSERT INTO States VALUES (NULL, 'Idaho', 'ID', 'US');
INSERT INTO States VALUES (NULL, 'Illinois', 'IL', 'US');
INSERT INTO States VALUES (NULL, 'Indiana', 'IN', 'US');
INSERT INTO States VALUES (NULL, 'Iowa', 'IA', 'US');
INSERT INTO States VALUES (NULL, 'Kansas', 'KS', 'US');
INSERT INTO States VALUES (NULL, 'Kentucky', 'KY', 'US');
INSERT INTO States VALUES (NULL, 'Louisiana', 'LA', 'US');
INSERT INTO States VALUES (NULL, 'Maine', 'ME', 'US');
INSERT INTO States VALUES (NULL, 'Maryland', 'MD', 'US');
INSERT INTO States VALUES (NULL, 'Massachusetts', 'MA', 'US');
INSERT INTO States VALUES (NULL, 'Michigan', 'MI', 'US');
INSERT INTO States VALUES (NULL, 'Minnesota', 'MN', 'US');
INSERT INTO States VALUES (NULL, 'Mississippi', 'MS', 'US');
INSERT INTO States VALUES (NULL, 'Missouri', 'MO', 'US');
INSERT INTO States VALUES (NULL, 'Montana', 'MT', 'US');
INSERT INTO States VALUES (NULL, 'Nebraska', 'NE', 'US');
INSERT INTO States VALUES (NULL, 'Nevada', 'NV', 'US');
INSERT INTO States VALUES (NULL, 'New Hampshire', 'NH', 'US');
INSERT INTO States VALUES (NULL, 'New Jersey', 'NJ', 'US');
INSERT INTO States VALUES (NULL, 'New Mexico', 'NM', 'US');
INSERT INTO States VALUES (NULL, 'New York', 'NY', 'US');
INSERT INTO States VALUES (NULL, 'North Carolina', 'NC', 'US');
INSERT INTO States VALUES (NULL, 'North Dakota', 'ND', 'US');
INSERT INTO States VALUES (NULL, 'Ohio', 'OH', 'US');
INSERT INTO States VALUES (NULL, 'Oklahoma', 'OK', 'US');
INSERT INTO States VALUES (NULL, 'Oregon', 'OR', 'US');
INSERT INTO States VALUES (NULL, 'Pennsylvania', 'PA', 'US');
INSERT INTO States VALUES (NULL, 'Rhode Island', 'RI', 'US');
INSERT INTO States VALUES (NULL, 'South Carolina', 'SC', 'US');
INSERT INTO States VALUES (NULL, 'South Dakota', 'SD', 'US');
INSERT INTO States VALUES (NULL, 'Tennessee', 'TN', 'US');
INSERT INTO States VALUES (NULL, 'Texas', 'TX', 'US');
INSERT INTO States VALUES (NULL, 'Utah', 'UT', 'US');
INSERT INTO States VALUES (NULL, 'Vermont', 'VT', 'US');
INSERT INTO States VALUES (NULL, 'Virgin Islands', 'VI', 'US');
INSERT INTO States VALUES (NULL, 'Virginia', 'VA', 'US');
INSERT INTO States VALUES (NULL, 'Washington', 'WA', 'US');
INSERT INTO States VALUES (NULL, 'West Virginia', 'WV', 'US');
INSERT INTO States VALUES (NULL, 'Wisconsin', 'WI', 'US');
INSERT INTO States VALUES (NULL, 'Wyoming', 'WY', 'US');
