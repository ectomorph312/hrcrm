CREATE TABLE user_role
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    role_name varchar(255)
);

CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    is_active boolean NOT NULL,
    first_name varchar(255),
    last_name varchar(255),
    password varchar(255),
    username varchar(255) UNIQUE,
    role_id BIGINT REFERENCES user_role (id)
);

CREATE TABLE vacancies
(
    vacancy_id BIGSERIAL PRIMARY KEY NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    description varchar(2048),
    requirements varchar(255),
    title varchar(255),
    user_id BIGINT REFERENCES users (id)
);

CREATE TABLE candidates
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    degree varchar(255),
    department varchar(255),
    discord varchar(255),
    email varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    phone_number varchar(255),
    years_of_experience varchar(255),
    vacancy_id BIGINT REFERENCES vacancies (vacancy_id)
);

CREATE TABLE vacancy_competencies
(
    vacancy_id BIGINT REFERENCES vacancies (vacancy_id),
    competencies varchar(255)
);