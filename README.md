A basic ecommerce platform where user can browse products, Add to cart / wishlist, Place orders, View order history, User registration & login (JWT or session)
Also admin can Add/edit/remove products, Manage orders, View sales reports

Tech stack :
Language: Java 17+
Framework: Spring Boot
Security: Spring Security + JWT
Database: PostgreSQL or MySQL
ORM: Hibernate (JPA)
API Docs: Swagger/OpenAPI
Build Tool: Maven or Gradle
Testing: JUnit + Mockito


Architecture:
Client (React)
   |
REST API (Spring Boot)
   |
Services (Business logic)
   |
Repositories (JPA)
   |
Database (PostgreSQL)

Entities & Relationships: 
User (1) ↔ (M) Order
Order (1) ↔ (M) OrderItem
Product (1) ↔ (M) OrderItem
User (1) ↔ (M) CartItem

API Endpoints Example:
Method	Endpoint	Description
POST	/auth/register	Register user
POST	/auth/login	Login + JWT
GET	/products	Get all products
POST	/cart/add	Add product to cart
POST	/order/checkout	Place an order
GET	/admin/products	Admin view products
POST	/admin/product	Add/edit product

Basic packages info:
DTOs: AuthRequest, AuthResponse
Security config: Password encoder, security filter chain, and stateless session setup
AuthController: Register and login endpoints
Login logic: AuthManager verifies credentials (JWT token generation need to be plugged in)


Curl commands:
curl -X POST http://localhost:8080/api/auth/register \
-H "Content-Type: application/json" \
-d '{"username":"testuser","password":"testpass"}'

Browser:
http://localhost:8080/api/products


PostgreSQL install:
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
brew install postgresql
brew services start postgresql

Create postgre db:
psql postgres
-- Create a user
CREATE USER shop_user WITH PASSWORD 'secret';
-- Create a database
CREATE DATABASE shope;
-- Give your user access
GRANT ALL PRIVILEGES ON DATABASE shop TO shop_user;
\q


install maven:
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
brew install maven

start spring boot:
mvn spring-boot:run
