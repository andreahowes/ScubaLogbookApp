[![Build Status](https://travis-ci.org/ashcreek/mexico_dive_app.svg?branch=securityandhtmlimprovements)](https://travis-ci.org/ashcreek/mexico_dive_app)

# Dive App

A Java application for logging and keep track of the scuba diving information!

The application is accessable through a web page and all user info is stored in a MySQL database.

## Getting Started

You can get started by cloning the project to your local machine:
```
$ git clone https://github.com/ashcreek/mexico_dive_app.git
```

### Prerequisites

In order to execute this program you will need to install the following:
* Java JDK
* MySQL
* Gradle

### Installing
To get the development environment up and running, you will first need to create the database.

This can be achieved by either importing the database schema, or manually using the terminal.

#### Setting up database using terminal

In your terminal login to your MySQL as a user with the appropriate permissions.

Then enter the following command to create your database.
```
CREATE DATABASE diveapp;
```
Then use this new database
```
USE diveapp;
```

You will need to use the file at: (/database/database_initial_creation.sql) to create the following tables in this database.

## Built With

* [Gradle](https://gradle.org/) - Dependency Management

## Author

* **Andrea Howes** - *Initial work* - [GitHub](https://github.com/ashcreek)
