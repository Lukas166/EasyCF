# Easy CashFlow

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/aKmm7SYe)

A comprehensive financial management application that enables users to analyze and understand their money usage effectively through data visualization such as graphs, charts, and periodic financial reports. This application aims to help users identify spending patterns so they can manage their finances better.

## About

This is a final project (Java GUI) for the Object-Oriented Programming Class at Teknik Informatika Universitas Padjadjaran. The application provides a user-friendly interface for personal financial management with advanced analytics capabilities.

[Challenge Guidelines](challenge-guideline.md)

## Features

- **User Authentication**: Secure registration and login system with encrypted passwords
- **Expense Tracking**: Record and categorize daily expenses with detailed descriptions
- **Data Visualization**: Interactive bar charts showing spending patterns over time
- **Financial Analytics**: Weekly and monthly spending analysis with trend visualization
- **Category Management**: Organize expenses into categories (Food & Drinks, Shopping, Others, etc.)
- **Spending Limits**: Set and monitor personal spending limits
- **Transaction History**: Complete history of all financial transactions
- **Profile Management**: Manage user profile and financial preferences

## Prerequisites

Before running the application, ensure you have the following installed:

- **Java Development Kit (JDK) 8 or higher**
- **MySQL Server** (for database management)
- **NetBeans IDE** (recommended for development)
- **MySQL Connector/J** (JDBC driver for MySQL)

## Database Setup

1. **Install MySQL Server** on your system
2. **Create the database** by importing the SQL file:
   ```sql
   mysql -u root -p < db_easycf.sql
   ```
3. **Configure database connection** in `src/dbConnection/Connector.java`:
   ```java
   private String db = "jdbc:mysql://localhost/db_easycf";
   private String user = "root";  // Your MySQL username
   private String password = "";  // Your MySQL password
   ```

## Running The App

### Option 1: Using NetBeans IDE
1. **Open NetBeans IDE**
2. **Open Project** → Navigate to `Proyek PBO` folder
3. **Build the project** (F11) to compile all classes
4. **Run the main class** by executing one of the UI classes:
   - For Login: Right-click `ui/login.java` → Run File
   - For Registration: Right-click `ui/register.java` → Run File
   - For Dashboard: Right-click `ui/dashboard.java` → Run File

### Option 2: Using Command Line
1. **Navigate to the project directory**:
   ```bash
   cd "Proyek PBO"
   ```
2. **Compile the project**:
   ```bash
   javac -cp ".:lib/*" src/**/*.java -d build/classes
   ```
3. **Run the application**:
   ```bash
   java -cp "build/classes:lib/*" ui.login
   ```

### First Time Setup
1. **Start with Registration**: Create a new user account
2. **Login**: Use your credentials to access the dashboard
3. **Set spending limit**: Configure your monthly spending limit
4. **Add expenses**: Start tracking your financial transactions

## Usage Guide

### Getting Started
1. **Launch the application** using one of the methods described in "Running The App"
2. **Register a new account** if you're a first-time user
3. **Login** with your credentials

### Managing Expenses
1. **Adding New Expenses**:
   - Click the "Input" button from the dashboard
   - Fill in expense details (title, description, category, amount, date)
   - Submit to save the transaction

2. **Viewing Expense History**:
   - Access the "Riwayat" (History) section
   - Browse through your transaction history
   - Filter by date or category

3. **Analyzing Spending Patterns**:
   - Use the dashboard's bar chart to view weekly spending
   - Navigate between months using arrow buttons
   - Compare spending across different time periods

### Profile Management
- **Update Profile**: Modify your name, email, and spending limits
- **Change Password**: Update your account security
- **Set Spending Limits**: Configure monthly budget limits

## Troubleshooting

### Common Issues

#### Database Connection Problems
- **Issue**: Application cannot connect to database
- **Solution**: 
  - Verify MySQL server is running
  - Check database credentials in `Connector.java`
  - Ensure `db_easycf` database exists

#### Build Errors
- **Issue**: Compilation fails in NetBeans
- **Solution**:
  - Verify JDK version compatibility
  - Check all required libraries are included
  - Clean and rebuild the project

#### Login Issues
- **Issue**: Cannot login with valid credentials
- **Solution**:
  - Verify user exists in database
  - Check password encryption consistency
  - Ensure database connection is stable

## Contributing

This project is part of an academic assignment. For educational purposes:

1. **Fork the repository**
2. **Create a feature branch** for your changes
3. **Make your modifications** with clear commit messages
4. **Test thoroughly** before submitting
5. **Submit a pull request** with detailed description

## Development Team

| NPM          | Name                 | Role |
| ------------ | -------------------- | ---- |
| 140810230011 | Lukas Austin         | Project Lead & UI Design |
| 140810230045 | Devin Suryadi        | Backend Development & Database |
| 140810230057 | Orlando Bloem Sutono | System Architecture & Testing |

## Development History

### Sprint Planning - (02/11/2024)
- [Sprint Planning Documentation](changelog/sprint-planning.md)
- Determined Product Backlog and Sprint 1 planning
- Assigned initial tasks to team members

### Sprint 1 - (31/10/2024 - 06/11/2024)
- [Sprint 1 Details](changelog/sprint-1.md)
- Moved some Sprint 1 tasks to Sprint 2 due to scope adjustment
- Completed initial research and design phases

### Sprint 2 - (07/11/2024 - 13/11/2024)
- [Sprint 2 Details](changelog/sprint-2.md)
- Completed core development tasks
- Implemented database structure and basic UI

### Sprint 3 - (14/11/2024 - 21/11/2024)
- [Sprint 3 Details](changelog/sprint-3.md)
- Enhanced user interface and added features
- Completed testing and bug fixes

### Sprint 4 - (21/11/2024 - 27/11/2024)
- [Sprint 4 Details](changelog/sprint-4.md)
- Final polishing and documentation
- Project completion and submission preparation

## License

This project is developed for educational purposes as part of the Object-Oriented Programming course at Teknik Informatika Universitas Padjadjaran. All rights reserved to the development team and the university.

## Acknowledgments

- **Teknik Informatika Universitas Padjadjaran** for providing the learning environment
- **Object-Oriented Programming Course** instructors for guidance and support
- **MySQL Community** for the database management system
- **Oracle/NetBeans** for the integrated development environment

## Architecture Overview

The application follows the Model-View-Controller (MVC) pattern with clear separation of concerns:

### Data Layer (`src/Data/`)
- **Users.java**: Base class for user management with financial data analysis methods
- **Biodata.java**: Extended user class containing profile information and spending limits
- **Pengeluaran.java**: Expense data model with category and amount information
- **Encrypt.java**: Password encryption and decryption utilities
- **BarChart.java**: Data visualization component for generating financial charts

### View Layer (`src/ui/`)
- **login.java**: User authentication interface
- **register.java**: New user registration form
- **dashboard.java**: Main application interface with charts and financial overview
- **input.java**: Expense input form with category selection
- **profile.java**: User profile management interface
- **riwayat.java**: Transaction history and expense tracking view

### Database Connection Layer (`src/dbConnection/`)
- **Connector.java**: Database connection management and query execution
- **UserFunctions.java**: User authentication, registration, and validation functions
- **Test.java**: Database connectivity testing utilities

## Key Classes and Their Functions

### Core Classes

#### `Users.java`
- **Purpose**: Base class for user management and financial calculations
- **Key Methods**:
  - `getDataPengeluaran()`: Retrieves user's expense data from database
  - `getDataPengeluaranPerBulan()`: Calculates monthly spending totals
  - `getDataPengeluaranPerMinggu()`: Calculates weekly spending within date range
  - `getDataPerTanggal()`: Returns weekly spending data for chart visualization

#### `Biodata.java` (extends Users)
- **Purpose**: Extended user class with profile information
- **Key Features**:
  - User profile management (name, email, spending limit)
  - Account deletion functionality
  - Spending limit tracking and updates

#### `Pengeluaran.java`
- **Purpose**: Expense data model
- **Attributes**: Title, description, category, amount, date
- **Categories**: "Makanan & Minuman", "Belanja", "Lainnya", "Aksesoris", "Perabotan", "Buku"

#### `UserFunctions.java`
- **Purpose**: Authentication and user management
- **Key Methods**:
  - `registerUser()`: User registration with validation
  - `loginUser()`: User authentication and session management
  - Input validation for username, password, and email

### UI Classes

#### `dashboard.java`
- **Purpose**: Main application interface
- **Features**:
  - Monthly expense visualization with bar charts
  - Navigation between months
  - Quick access to profile and input screens
  - Real-time spending data display

#### `input.java`
- **Purpose**: Expense input interface
- **Features**:
  - Category-based expense recording
  - Date selection and amount input
  - Form validation and database insertion


## Database Schema

The application uses a MySQL database with the following tables:

### `biodata` Table
Stores user profile information and spending preferences.

| Column | Type | Description |
|--------|------|-------------|
| `biodata_id` | INT(11) PRIMARY KEY | Unique identifier for user profile |
| `nama` | VARCHAR(30) | User's full name |
| `email` | VARCHAR(30) | User's email address |
| `limit_pengeluaran` | DECIMAL(10,2) | Monthly spending limit set by user |

### `users` Table
Handles user authentication and account management.

| Column | Type | Description |
|--------|------|-------------|
| `username` | VARCHAR(30) PRIMARY KEY | Unique username for login |
| `password` | VARCHAR(30) | Encrypted password |
| `biodata_id` | INT(11) FOREIGN KEY | References biodata.biodata_id |

### `pengeluaran` Table
Records all financial transactions and expense data.

| Column | Type | Description |
|--------|------|-------------|
| `pengeluaran_id` | INT(11) PRIMARY KEY AUTO_INCREMENT | Unique transaction identifier |
| `judul` | VARCHAR(30) | Expense title/name |
| `deskripsi` | TEXT | Detailed description of the expense |
| `tipe_pengeluaran` | VARCHAR(30) | Expense category |
| `uang_keluar` | DECIMAL(10,2) | Amount spent |
| `tanggal` | DATE | Transaction date |
| `username` | VARCHAR(30) FOREIGN KEY | References users.username |

### Expense Categories
The application supports the following expense categories:
- **Makanan & Minuman** (Food & Beverages)
- **Belanja** (Shopping)
- **Lainnya** (Others)
- **Aksesoris** (Accessories)
- **Perabotan** (Furniture)
- **Buku** (Books)


## Design Assumptions and Implementation Details

### Security Considerations
- **Password Encryption**: User passwords are encrypted using a custom encryption class before storage
- **SQL Injection Prevention**: Prepared statements are used for database queries where possible
- **Input Validation**: Username, email, and password validation on registration

### Data Visualization Strategy
- **Weekly Analysis**: Expenses are grouped into 4-week periods for monthly visualization
- **Chart Implementation**: Custom BarChart class provides interactive expense visualization
- **Real-time Updates**: Dashboard refreshes data when navigating between months

### User Experience Design
- **Intuitive Navigation**: Simple button-based navigation between application screens
- **Form Validation**: Real-time validation with user-friendly error messages
- **Responsive Layout**: Fixed-size interface optimized for desktop usage

### Financial Analysis Features
- **Spending Limits**: Users can set monthly spending limits with real-time tracking
- **Category Analysis**: Expenses are categorized for better spending pattern analysis
- **Historical Data**: Complete transaction history with date-based filtering
- **Trend Visualization**: Weekly spending patterns displayed through bar charts

### Technical Implementation
- **Database Connection**: Singleton pattern for database connection management
- **Object-Oriented Design**: Clear separation of data models, UI components, and business logic
- **Exception Handling**: Comprehensive error handling for database operations and user input
- **Session Management**: Current user session maintained throughout application usage

### Development Environment
- **IDE**: Developed using NetBeans IDE with form designer
- **Build System**: Ant-based build configuration for compilation and packaging
- **Database**: MySQL server for data persistence
- **Java Version**: Compatible with Java 8 and higher

### Known Limitations
- **Single User Session**: Application supports one active user session at a time
- **Desktop Only**: GUI designed specifically for desktop environments
- **Local Database**: Requires local MySQL installation for database operations
- **Fixed Categories**: Expense categories are predefined and not user-customizable
