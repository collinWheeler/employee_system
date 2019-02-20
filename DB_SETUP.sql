CREATE DATABASE PERSONNEL;
CREATE USER 'springuser'@'%' IDENTIFIED BY 'SuperSecurePassword';
GRANT ALL ON PERSONNEL.* to 'springuser'@'%';