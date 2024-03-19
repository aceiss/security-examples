DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (user_id VARCHAR,password VARCHAR,roles VARCHAR,scopes VARCHAR);
DROP TABLE IF EXISTS CLIENTS;
CREATE TABLE CLIENTS (client_id VARCHAR,client_secret VARCHAR,redirect_uri VARCHAR,scope VARCHAR,authorized_grant_types VARCHAR);
DROP TABLE IF EXISTS AUTHORIZATION_CODE;
CREATE TABLE AUTHORIZATION_CODE (code INT PRIMARY KEY AUTO_INCREMENT,client_id VARCHAR,user_id VARCHAR,approved_scopes VARCHAR,expiration_date DATE,redirect_uri VARCHAR);

INSERT INTO USERS (user_id, password, roles, scopes) VALUES ('appuser', 'appusersecret', 'USER', 'resource.read resource.write');
INSERT INTO USERS (user_id, password, roles, scopes) VALUES ('admin', 'password', 'USER', 'resource.read resource.write');
INSERT INTO USERS (user_id, password, roles, scopes) VALUES ('catmgr', 'password', 'USER', 'resource.read resource.catmgr');
INSERT INTO USERS (user_id, password, roles, scopes) VALUES ('user', 'password', 'USER', 'resource.read');

INSERT INTO CLIENTS (client_id, client_secret, redirect_uri,scope,authorized_grant_types) VALUES ('webappclient', 'webappclientsecret', 'http://localhost:9180/callback', 'resource.read resource.write resource.catmgr', 'authorization_code refresh_token');