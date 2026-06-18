# BloodLink

A blood donation platform connecting donors with recipients in real time.

## Tech Stack

- **Frontend:** Android (Java, XML)
- **Backend:** Spring Boot (Java)
- **Database:** MySQL
- **Auth:** JWT (JSON Web Tokens)

## Features

- Role-based login (Donor / Recipient)
- Blood request posting by recipients
- Donor search by blood group and city
- In-app notifications for matched donors
- Donation history tracking

## Project Structure

bloodlink/
├── frontend/       # Android app
├── backend/        # Spring Boot REST API
└── db/             # Database schema (schema.sql)

## Database Setup

1. Create a MySQL database named `bloodlink`
2. Run `db/schema.sql` to create all tables

## Backend Setup

1. Navigate to `backend/`
2. Configure `application.properties` with your MySQL credentials
3. Run the Spring Boot app

## Android Setup

1. Open `frontend/` in Android Studio
2. Update the base URL in Retrofit config to point to your backend
3. Run on emulator or device

## Status

🚧 In development