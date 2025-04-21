-- Create users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create roles table
CREATE TABLE roles(
	id SERIAL PRIMARY KEY,
	name VARCHAR(20) UNIQUE NOT NULL
);

-- Create table user roles
CREATE TABLE user_roles(
	user_id INTEGER REFERENCES users(id),
	role_id INTEGER REFERENCES roles(id),
	PRIMARY KEY (user_id, role_id)
);

-- Insert two roles in the db
INSERT INTO roles (name) VALUES ('ROLE_CUSTOMER'), ()'ROLE_ADMIN');