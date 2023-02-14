# noinspection SqlNoDataSourceInspectionForFile

CREATE DATABASE backend CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use backend;

CREATE TABLE product (
  product_id BIGINT AUTO_INCREMENT
, description VARCHAR (100) NOT NULL
, price DOUBLE
, CONSTRAINT  pkProduct PRIMARY KEY  (product_id)
);


