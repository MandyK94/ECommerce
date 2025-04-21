<h1>Microservices E-Commerce Platform </h1>
<p>A blueprint for the system</p>

<h2>Business Requirements</h2>
<li>User registration & authentication.</li>
<li>Product catalog & search.</li>
<li>Shopping cart & checkout.</li>
<li>Order processing & payments.</li>
<li>Shipping & notifications.</li>
<li>Reviews & recommendations.</li>

<h2>Microservices breakdown</h2>
<table>
  <tr>
    <th>Service</th>
    <th>Responsibility</th>
    <th>Database</th>
    <th>Protocol</th>
  </tr>
  <tr>
    <td>1. User Service</td>
    <td>Auth, profiles, roles.</td>
    <td>PostgreSQL</td>
    <td>REST/JWT</td>
  </tr>
  <tr>
    <td>2. Product Service</td>
    <td>Product catalog, categories, inventory.</td>
    <td>MongoDB</td>
    <td>REST/gRPC</td>
  </tr>
  <tr>
    <td>3. Cart Service</td>
    <td>Shopping cart management.</td>
    <td>Redis</td>
    <td>REST</td>
  </tr>
  <tr>
    <td>4. Order Service</td>
    <td>Order creation, status tracking.</td>
    <td>PostgreSQL</td>
    <td>REST+Kafka</td>
  </tr>
  <tr>
    <td>5. Paymet Service</td>
    <td>Payments (Stripe/PayPal integration).</td>
    <td>PostgreSQL</td>
    <td>REST</td>
  </tr>
  <tr>
    <td>6. Shipping Service</td>
    <td>Shipping cost calculation, tracking.</td>
    <td>PostgreSQL</td>
    <td>REST</td>
  </tr>
  <tr>
    <td>7. Notification Service</td>
    <td>Emails/SMS (order confirmations).</td>
    <td>MongoDB</td>
    <td>Kafka</td>
  </tr>
  <tr>
    <td>8. Search Service</td>
    <td>Elasticsearch-powered product search.</td>
    <td>Elasticsearch</td>
    <td>REST</td>
  </tr>
</table>

<hr>
<h2>User Service</h2>
<p>This service handles user profile, authentication, and role management.</p>
<h3>Responsibilities</h3>
<li>User registration & login (JWT authentication)</li>
<li>Profile management (CRUD operations)</li>
<li>Role-based access control (RBAC)</li>
<li>Password hashing & security</li>

<h2>API endpoints</h2>

<table>
  <tr>
    <th>Endpoint</th>	
    <th>Method</th>	
    <th>Description</th>	
    <th>Auth Required</th>
  </tr>
  <tr>
    <td>/api/auth/register</td>
    <td>POST</td>
    <td>Register new user</td>
    <td>No</td>
  </tr>
  
  <tr>
    <td>/api/auth/login</td>
    <td>POST</td>
    <td>Login (returns JWT)</td>
    <td>No</td>
  </tr>
  
  <tr>
    <td>/api/users/me</td>
    <td>GET</td>
    <td>Get current user profile</td>
    <td>YES</td>
  </tr>
  
  <tr>
    <td>/api/users/{id}</td>
    <td>PUT</td>
    <td>Update user details</td>
    <td>Yes (owner/admin)</td>
  </tr>
  
  <tr>
    <td>/api/admin/users</td>
    <td>GET</td>
    <td>List all users (admin only)</td>
    <td>Yes (admin)</td>
  </tr>
</table>

<hr>
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
