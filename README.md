Billing Software Backend (Spring Boot)
📌 Project Overview

This project is a Billing Software Backend Application developed using Spring Boot.
It provides REST APIs to manage:

Products

Customers

Invoices (Billing System)

The system supports dynamic GST calculation, stock management, invoice generation, and billing history.

The project follows a proper Layered Architecture:

Controller → Service → Repository → Database


This architecture helps in keeping business logic, database logic, and API logic separate and clean.

⚙️ Tech Stack Used

Java 17+

Spring Boot

Spring Web

Maven

Postman (API Testing)

In-Memory Storage (HashMap)

📂 Project Structure
billing-software
│
├── controller
│   ├── ProductController.java
│   ├── CustomerController.java
│   ├── InvoiceController.java
│
├── service
│   ├── ProductService.java
│   ├── CustomerService.java
│   ├── InvoiceService.java
│
├── repository
│   ├── ProductRepository.java
│   ├── CustomerRepository.java
│   ├── InvoiceRepository.java
│
├── entity
│   ├── Product.java
│   ├── Customer.java
│   ├── Invoice.java
│   ├── InvoiceItem.java
│
├── dto
│   ├── InvoiceRequestDTO.java
│   ├── InvoiceResponseDTO.java
│
├── exception
│   ├── ResourceNotFoundException.java
│   ├── InsufficientStockException.java
│   ├── GlobalExceptionHandler.java
│
└── BillingSoftwareApplication.java

🧾 Features

✔ Product Management
✔ Customer Management
✔ Invoice Generation
✔ Dynamic GST Calculation
✔ Stock Validation
✔ Billing History
✔ Global Exception Handling

🔗 REST APIs List
🛒 Product APIs
Method	Endpoint	Description
POST	/products	Add new product
GET	/products	Get all products
GET	/products/{id}	Get product by ID
PUT	/products/{id}	Update product
DELETE	/products/{id}	Delete product
👤 Customer APIs
Method	Endpoint	Description
POST	/customers	Add customer
GET	/customers	Get all customers
GET	/customers/{id}	Get customer by ID
🧾 Invoice APIs
Method	Endpoint	Description
POST	/invoices	Generate invoice
GET	/invoices	Get all invoices
GET	/invoices/{id}	Get invoice by ID
GET	/invoices/customer/{customerId}	Get invoices by customer
📊 Business Rules Implemented

✔ Customer must exist before billing
✔ Product stock must be sufficient
✔ Stock is reduced after invoice generation
✔ GST is calculated dynamically per product
✔ Invoice number is auto-generated

🧪 Testing

All APIs are tested using Postman.

Validations tested:

Wrong product ID

Wrong customer ID

Insufficient stock

Empty invoice items

🚀 How to Run

Clone the repository

Open in IntelliJ / Eclipse

Run BillingSoftwareApplication.java

Server runs on:

http://localhost:8080


Test APIs using Postman

👩‍💻 Developer

Name: Sakshi
Role: Engineering Student
Project Type: Backend Billing System

💼 This project demonstrates strong understanding of:

Spring Boot fundamentals

REST API design

Layered Architecture

Business logic implementation
