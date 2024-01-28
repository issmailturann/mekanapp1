CREATE SCHEMA IF NOT EXISTS util_sch AUTHORIZATION mekanapp_user;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.user_details
(
    id                                uuid DEFAULT uuid_generate_v4(),
    user_id                           uuid NOT NULL,
    biography                         VARCHAR NOT NULL,
    phone_number                      VARCHAR NOT NULL,
    date_of_birth                     DATE NOT NULL,
    gender                            VARCHAR NOT NULL,
    pleasures_and_hobbies             VARCHAR NOT NULL,
    preferred_places                  VARCHAR NOT NULL,
    user_created_date                 TIMESTAMP NOT NULL,
    user_updated_date                 TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES util_sch.users(id),
    CONSTRAINT users_user_id_key UNIQUE (user_id),
    CONSTRAINT users_phone_number_key UNIQUE (phone_number)
);
