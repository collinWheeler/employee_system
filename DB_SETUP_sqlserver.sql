CREATE DATABASE PERSONNEL;
CREATE LOGIN MyLogin WITH PASSWORD = '123';
CREATE USER springuser for login MyLogin;
use PERSONNEL grant all on PERSONNEL.* to springuser;