# Personal Information Manager

[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

Web app with **Spring** and **Angular** for Dorsum.

## Table of Contents
- [Background](#background)
- [Usage](#usage)

## Background

This application is built to manage personal information, offering full CRUD (Create, Read, Update, Delete) functionality.

#### Persons API Endpoints

- **GET** `/api/persons`  
  Retrieve a list of all persons with their details.

- **POST** `/api/persons`  
  Add a new person to the system.

- **GET** `/api/persons/{id}`  
  Retrieve detailed information about a specific person by their unique ID.

- **PUT** `/api/persons/{id}`  
  Update the information of an existing person by their ID.

- **DELETE** `/api/persons/{id}`  
  Remove a person from the system by their ID.

## Usage

### Local Development Setup

### Prerequisites

Before you can run the application locally, make sure you have the following installed:

- [Java SDK (JDK 17)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Visual Studio Code (VS Code)](https://code.visualstudio.com/)
- [Node.js and NPM](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
- [PostgreSQL](https://www.postgresql.org/download/)

### Setting Up the Database

Use Docker to set up a PostgreSQL database:

1. Make sure you have [Docker Desktop](https://www.docker.com/products/docker-desktop) installed and running.
2. Run the following command to start the PostgreSQL database using the `docker-compose.yml` file:

   ```bash
   docker-compose up -d

### Installing Dependencies

- **Backend (BE)**:  
  Open the project in IntelliJ IDEA and run Gradle to install all required dependencies.

- **Frontend (FE)**:  
  Open the project in VS Code, navigate to the project folder, and run the following command in the terminal:

  ```bash
  npm install

### Running the Application

- Backend by the main method from **src/main/java/com/example/PersonalInfoManager/PersonalInfoManagerApplication.java**
- Frontend by **ng serve** from terminal

### Local pages

- BE - http://localhost:8080
- FE - http://localhost:4200



