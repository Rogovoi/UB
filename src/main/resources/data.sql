-- Table: users
CREATE TABLE users (
  id       SERIAL PRIMARY KEY,
  login VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR (255),
  surname VARCHAR (255),
  email VARCHAR (255),
  alias VARCHAR (255)
);

-- Table: roles
CREATE TABLE roles (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
);

-- Insert data

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');
