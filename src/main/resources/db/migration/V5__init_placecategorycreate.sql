CREATE SCHEMA IF NOT EXISTS util_sch AUTHORIZATION mekanapp_user;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.place_categories
(
    id                                 uuid DEFAULT uuid_generate_v4(),
    category_name                      VARCHAR NOT NULL,
    status                             VARCHAR,
    PRIMARY KEY (id),
    CONSTRAINT category_name_key UNIQUE (category_name)
);
