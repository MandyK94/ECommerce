A basic ecommerce platform where user can browse products, Add to cart / wishlist, Place orders, View order history, User registration & login (JWT or session)<br>
Also admin can Add/edit/remove products, Manage orders, View sales reports

Tech stack :<br>
Language: Java 17+<br>
Framework: Spring Boot<br>
Security: Spring Security + JWT //TODO<br>
Database: PostgreSQL<br>
ORM: Hibernate (JPA)<br>
API Docs: Swagger/OpenAPI // TODO<br>
Build Tool: Maven or Gradle<br>
Testing: JUnit + Mockito //TODO<br>


Architecture:<br>
Client (React)<br>
   |<br>
REST API (Spring Boot)<br>
   |<br>
Services (Business logic)<br>
   |<br>
Repositories (JPA)<br>
   |<br>
Database (PostgreSQL)<br>

Entities & Relationships:<br> 
User (1) ↔ (M) Order<br>
Order (1) ↔ (M) OrderItem<br>
Product (1) ↔ (M) OrderItem<br>
User (1) ↔ (M) CartItem<br>

API Endpoints Example:<br>
Method	Endpoint	Description<br>
POST	/auth/register	Register user<br>
POST	/auth/login	Login + JWT<br>
GET	/products	Get all products<br>
POST	/cart/add	Add product to cart<br>
POST	/order/checkout	Place an order<br>
GET	/admin/products	Admin view products<br>
POST	/admin/product	Add/edit product<br>

Basic packages info:<br>
DTOs: AuthRequest, AuthResponse<br>
Security config: Password encoder, security filter chain, and stateless session setup<br>
AuthController: Register and login endpoints<br>
Login logic: AuthManager verifies credentials (JWT token generation need to be plugged in) //TODO<br>


Curl commands:<br>
curl -X POST http://localhost:8080/api/auth/register \   <br>
-H "Content-Type: application/json" \    <br>
-d '{"username":"testuser","password":"testpass"}'   <br>

Browser:<br>
http://localhost:8080/api/products<br>


PostgreSQL install:<br>
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"<br>
brew install postgresql<br>
brew services start postgresql<br>



Create postgre db:<br>

createuser -s -P postgres <br>

psql -U postgres<br>
-- Create database <br>
CREATE DATABASE shop; <br>
-- List all DB <br>
\l <br>
-- Create a user<br>
CREATE USER shop_user WITH PASSWORD 'secret';<br>
-- Create a database<br>
CREATE DATABASE shop;<br>
-- Give your user access<br>
GRANT ALL PRIVILEGES ON DATABASE shop TO shop_user;<br>
-- log into shop database using shop_user account <br>
psql -U shop_user -d shop <br>

-- Create products table 
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL
);

-- Create users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    role VARCHAR(50) NOT NULL
);

-- Create orders table
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    total DECIMAL(10, 2) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create order_items table
CREATE TABLE order_items (
    id SERIAL PRIMARY KEY,
    order_id INT REFERENCES orders(id) ON DELETE CASCADE,
    product_id INT REFERENCES products(id) ON DELETE CASCADE,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);



\q <br>


install maven: <br>
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)" <br>
brew install maven <br>

start spring boot: <br>
mvn spring-boot:run <br>

Ppstgres start and stop: <br>
brew services start postgresql <br>
brew services restart postgresql@14 <br>
