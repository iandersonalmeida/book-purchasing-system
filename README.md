# Book Purchasing System - Web Application Project
This project aims to develop a web application that addresses microservices architecture, expanding knowledge and practical experience in the fields of the software development cycle, frameworks, programming, testing and deployment.

- [General info](#general-info)
- [Technologies Used](#technologies-used)
- [Project Management](#project-management)
- [Domain-Driven Design (DDD) & Architecture](#domain-driven-design-ddd--architecture)
- [Incremental Development Lifecycle](#incremental-development-lifecycle)
- [Project Status](#project-status)
- [Inspiration](#inspiration)

## General info
The project is an application that addresses the idea of microservices, which describes components of a system that are independent or "loosely coupled". Each component has a defined responsibility and the resources it needs to function. For the development of the application's microservices, Spring Boot, MySQL for database management, the Postman tool for building HTTP requests and React/Next for the user interface are currently being used.

## Technologies Used
* Backend: Java, Spring Boot, MySQL, REST API
* Frontend: React / Next.js
* Version Control: Git + GitHub

## Project Management

I manage the development of this project using **GitHub Projects** (Scrum style):

[View Project Board](https://github.com/users/iandersonalmeida/projects/16)

## Domain-Driven Design (DDD) & Architecture
This project embraces an **evolutionary and incremental architecture** driven by Domain-Driven Design (DDD). Instead of defining a massive, rigid microservices structure upfront, the architecture emerges  as each **Bounded Context** is independently explored and developed.

Currently, the system is focused on isolating and perfecting a single subdomain.

### Bounded Context: Catalog
Through strategic modeling, the Catalog Context was defined as a dedicated solution for the Catalog subdomain.

* **Catalog Domain Model (UML):**  
  ![Catalog UML Model](..docs/domain-model-for-catalog-context.PNG.png)

* Within the Catalog Context, we have the concept of a Book as our domain object. This domain object must have a unique identity over time, even if there are changes in its state, as well as type safety; therefore, we treat this object as an Entity.
* The unique identity of the Book entity ensures that one book can be distinguished from another. To avoid problems when the identity is used elsewhere, we define the identity as a BookId Value Object. Since Title and Author are currently just attributes to assist in book searches within this context, we can leave them as strings.
* We also define Price as a Value Object to ensure that this object will always have a valid state and remain immutable.
* Since the Catalog at this point in development should only serve to display search results, we define it as a Domain Service.
* To assist the Domain Service, we apply the Repository pattern to model a conceptual container of books.


### API Documentation 
Interactive API documentation is available via Swagger UI. You can explore all endpoints, parameters, request/response examples, and schemas at the link below:
[View Swagger API Documentation](https://iandersonalmeida.github.io/book-purchasing-system/)

  
## Project Status
The project is currently under development.

## Inspiration
This project was inspired by the following books and official documentation sources:

- Spring Microservices in Action
- React in Action
- Spring Framework Documentation
- Spring Boot Documentation
- React Documentation
- Next.js Documentation




