# Product Management System API Docs - Spring Boot

## Project Structure

```
product-tracking/
├── src/
│   ├── main/
│   │   ├── java/com/products/tracking/products-tracking
│   │   │   ├── controller/ProductController.java
│   │   │   ├── dto/ProductDto.java
│   │   │   ├── model/Product.java
│   │   │   ├── repository/ProductRepository.java
│   │   │   ├── service/ProductService.java
│   │   │   └── ProductTrackingApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   └── test/ (test files)
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Spring Boot 3.5.0 or higher

## Installation

### Clone the Repository

```bash
  git clone https://github.com/jathinlalam/product-tracking.git
  cd product-api
```

### Build the Project

```bash
  mvn clean install
```

### Run the Application

```bash
  mvn spring-boot:run
```

## API Endpoints

### Product Endpoints

#### Create Product

```bash
  curl -X POST http://localhost:8080/api/products \
-H "Content-Type: application/json" \
-d '{
    "name": "Laptop",
    "description": "High performance laptop",
    "price": 999.99
}'
```

#### Get All Products

```bash
  curl -X GET http://localhost:8080/api/products
```

#### Get Product by ID

```bash
  curl -X GET http://localhost:8080/api/products/{id}
```

#### Update Product

```bash
  curl -X PUT http://localhost:8080/api/products/{id} \
-H "Content-Type: application/json" \
-d '{
    "name": "Updated Laptop",
    "description": "Even higher performance",
    "price": 1099.99
}'
```

#### Delete Product

```bash
  curl -X DELETE http://localhost:8080/api/products/{id}
```

#### Technologies Used

- Spring Boot
- Spring Data JPA
- H2 Database (for development)
- Maven
