-- Bu satır, "uuid-ossp" eklentisini etkinleştirir
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Bu satır, "util_sch" şemasını oluşturur (eğer henüz oluşturulmamışsa)
CREATE SCHEMA IF NOT EXISTS util_sch AUTHORIZATION mekanapp_user;

ALTER TABLE util_sch.users
ADD CONSTRAINT users_username_key UNIQUE (username);