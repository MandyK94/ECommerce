<h1>Microservices E-Commerce Platform </h1>

Curl commands:<br>
curl -X POST http://localhost:8080/api/auth/register \   <br>
-H "Content-Type: application/json" \    <br>
-d '{"username":"testuser","password":"testpass"}'   <br>

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


install maven: <br>
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)" <br>
brew install maven <br>

start spring boot: <br>
mvn spring-boot:run <br>

Ppstgres start and stop: <br>
brew services start postgresql <br>
brew services restart postgresql@14 <br>
