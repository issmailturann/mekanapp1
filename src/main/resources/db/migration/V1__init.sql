CREATE SCHEMA IF NOT EXISTS util_sch AUTHORIZATION mekanapp_user;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.users
(
    id                  uuid DEFAULT uuid_generate_v4(),
    first_name                VARCHAR NOT NULL,
    last_name                 VARCHAR NOT NULL,
    username                  VARCHAR NOT NULL,
    password                  VARCHAR NOT NULL,
    status              VARCHAR,
    PRIMARY KEY (id)
);
