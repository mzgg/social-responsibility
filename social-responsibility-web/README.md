# social-responsibility
Pet Adoption Platform

<h3>What we need are in the software development process</h3>
  
  <h4>Presantion Layer</h4>
 -
  - Html
  - Bootstrap
  - PrimeFaces
  - Java Server Faces
  <h4>Business Layer</h4>
 -
  - Java SE
  - Spring Core
  - Spring Security
  - Restful Web Service 
  - Log4J
  - Junit
  <h4>Persistence Layer</h4>
 -
  - Jpa
  - Hibernate
  - Spring Data
  - DBUnit
  <h5>Application Server</h5>
 -
  - Tomcat 8
 -
  <h5>Database Systems</h5>
  
  -Oracle


CREATE TABLE member_role
(
    ROLE_ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ROLE VARCHAR(45)
);

INSERT INTO zahit.member_role (ROLE) VALUES ('ROLE_GUEST');


CREATE TABLE persistent_logins
(
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) PRIMARY KEY NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
