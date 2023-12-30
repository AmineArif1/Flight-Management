# Flight Management System

## Overview

The Flight Management System is a web application developed using the Spring MVC and Spring Boot frameworks. This system aims to facilitate the management of flights, passengers, and related information for an airline.

## Features

- **Flight Management:**
  - Add, edit, and delete flights.
  - View details of individual flights, including departure and arrival information.
  
- **Passenger Management:**
  - Manage passenger information, including booking details.
  - Assign or change seats for passengers.

- **User Authentication:**
  - Secure login for administrators and staff members.
  - Role-based access control to restrict functionalities based on user roles.

- **Reporting:**
  - Generate reports on flight schedules, passenger lists, and other relevant data.

## Tech Stack

- **Spring Boot:**
  - For building and deploying the application.
  - Simplifies the configuration and development of Spring applications.

- **Spring MVC:**
  - Provides a model-view-controller architecture for building flexible and loosely coupled web applications.
  - Handles web requests and manages the flow of data between the model, view, and controller components.

- **Thymeleaf:**
  - A modern server-side Java template engine for web and standalone environments.
  - Used for server-side rendering of views in the Spring MVC framework.

- **Hibernate:**
  - An ORM (Object-Relational Mapping) framework for Java.
  - Handles the mapping between Java objects and the database.

- **MySQL:**
  - Database management system for storing flight, passenger, and user data.

- **Spring Security:**
  - Ensures secure user authentication and authorization.

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/flight-management-system.git
   cd flight-management-system
