-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2024 at 03:44 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `car_service`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminID` varchar(6) NOT NULL,
  `AdminPass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `AdminPass`) VALUES
('A0001', 'abc123');

-- --------------------------------------------------------

--
-- Table structure for table `car_service`
--

CREATE TABLE `car_service` (
  `SlotID` int(11) NOT NULL,
  `ServiceID` int(11) NOT NULL,
  `CustID` int(11) NOT NULL,
  `CarName` varchar(20) NOT NULL,
  `CarModel` varchar(20) NOT NULL,
  `CarType` varchar(20) NOT NULL,
  `DateOfAppointment` date NOT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'PENDING',
  `Description` varchar(50) NOT NULL DEFAULT 'N/A',
  `StaffID` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `car_service`
--

INSERT INTO `car_service` (`SlotID`, `ServiceID`, `CustID`, `CarName`, `CarModel`, `CarType`, `DateOfAppointment`, `Status`, `Description`, `StaffID`) VALUES
(1, 1, 1, 'Saga', 'Proton', 'Sedan', '2024-01-21', 'Pending', 'Oil Change', 'S0001'),
(2, 2, 2, 'Sequoia', 'Toyota', 'SUV', '2024-01-23', 'Pending', 'Brake Inspection', 'S0002'),
(3, 3, 3, 'Hatchback', 'Honda', 'Hatchback', '2024-01-24', 'Pending', 'Air Filter Replacement', 'S0003'),
(4, 4, 4, 'Almera', 'Nissan', 'Sedan', '2024-01-25', 'Ongoing', 'Wheel Alignment', 'S0002'),
(5, 5, 5, 'GLC 300 4MATIC ', 'Mercedes', 'Coupe', '2024-01-26', 'Pending', 'Oil Change', 'S0001'),
(6, 6, 6, 'Monza SP2', 'Ferrari', 'Convertible', '2024-01-27', 'Pending', 'Transmission Service', 'S0003'),
(7, 7, 7, 'Ioniq 5', 'Hyundai', 'Hybrid', '2024-01-28', 'Pending', 'Battery Replacement', 'S0002'),
(8, 8, 8, 'X', 'Tesla', 'SUV', '2024-01-29', 'Pending', 'Charging System Check', 'S0001'),
(9, 9, 9, 'Fiesta', 'Ford', 'Sedan', '2024-01-30', 'Pending', 'Brake Pad Replacement', 'S0003'),
(10, 10, 10, 'Camry', 'Toyota', 'Sedan', '2024-01-23', 'Pending', 'Brake Replacement', 'S0002'),
(11, 11, 11, 'Civic', 'Honda', 'Sedan', '2024-01-24', 'Pending', 'Tire Rotation', 'S0003'),
(12, 12, 12, 'Accord', 'Honda', 'Sedan', '2024-01-25', 'Pending', 'Oil Change', 'S0001');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustID` int(11) NOT NULL,
  `CustPass` varchar(20) NOT NULL,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) NOT NULL,
  `ContactNo` varchar(10) NOT NULL,
  `EmailAddress` varchar(30) NOT NULL,
  `LoyaltyPointEarned` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustID`, `CustPass`, `FirstName`, `LastName`, `ContactNo`, `EmailAddress`, `LoyaltyPointEarned`) VALUES
(1, 'abc123', 'Adam', 'Hakim', '0133869280', 'adamhakim.email.com', 0),
(2, 'pass123', 'Sarah', 'Johnson', '0123456789', 'sarah.johnson@email.com', 20),
(3, 'secret456', 'Michael', 'Davis', '0198765432', 'michael.davis@email.com', 15),
(4, 'qwerty789', 'Emily', 'Smith', '0112233445', 'emily.smith@email.com', 25),
(5, 'passpass', 'Daniel', 'White', '0178899001', 'daniel.white@email.com', 30),
(6, 'secure123', 'Olivia', 'Brown', '0192837465', 'olivia.brown@email.com', 40),
(7, 'mypass123', 'William', 'Taylor', '0165474932', 'william.taylor@email.com', 18),
(8, 'mypass123', 'William', 'Taylor', '0165478932', 'william.taylor@email.com', 18),
(9, 'hello123', 'Sophia', 'Anderson', '0187652342', 'sophia.anderson@email.com', 22),
(10, 'passpass', 'Ethan', 'Miller', '0147852369', 'ethan.miller@email.com', 38),
(11, 'securepass', 'Isabella', 'Wilson', '0169673274', 'isabella.wilson@email.com', 29),
(12, 'mypassword', 'Liam', 'Davis', '0135789426', 'liam.davis@email.com', 33),
(13, 'password123', 'Emma', 'Johnson', '0123453789', 'emma.johnson@email.com', 25),
(14, 'securepass456', 'Aiden', 'Smith', '0199765432', 'aiden.smith@email.com', 15),
(15, 'qwerty7890', 'Olivia', 'Miller', '0142233445', 'olivia.miller@email.com', 30),
(16, 'mypassword', 'Noah', 'Brown', '0178499001', 'noah.brown@email.com', 40),
(17, 'hellopass', 'Sophia', 'Taylor', '0192847465', 'sophia.taylor@email.com', 20);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `InvoiceID` int(11) NOT NULL,
  `InvoiceDate` date NOT NULL DEFAULT curdate(),
  `NormalAmount` double(10,2) NOT NULL DEFAULT 0.00,
  `TotalAmount` double(10,2) NOT NULL DEFAULT 0.00,
  `PaymentStatus` varchar(12) NOT NULL DEFAULT 'PENDING',
  `Discount` double(10,2) NOT NULL DEFAULT 0.00,
  `StaffID` varchar(6) NOT NULL,
  `SlotID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`InvoiceID`, `InvoiceDate`, `NormalAmount`, `TotalAmount`, `PaymentStatus`, `Discount`, `StaffID`, `SlotID`) VALUES
(1100, '2024-01-23', 80.00, 70.00, 'PENDING', 10.00, 'S0001', 1),
(1101, '2024-01-23', 150.00, 140.00, 'PENDING', 10.00, 'S0002', 2),
(1102, '2024-01-23', 30.00, 25.00, 'PENDING', 5.00, 'S0003', 3),
(1103, '2024-01-23', 20.00, 18.00, 'PENDING', 2.00, 'S0002', 4),
(1104, '2024-01-23', 100.00, 92.00, 'PENDING', 18.00, 'S0001', 5),
(1105, '2024-01-23', 10000.00, 9750.00, 'PENDING', 250.00, 'S0003', 6),
(1106, '2024-01-23', 350.00, 330.00, 'PENDING', 20.00, 'S0002', 7),
(1107, '2024-01-23', 770.00, 750.00, 'PENDING', 20.00, 'S0001', 8),
(1108, '2024-01-23', 300.00, 265.00, 'PENDING', 35.00, 'S0003', 9),
(1109, '2024-01-23', 450.00, 450.00, 'PENDING', 0.00, 'S0002', 10),
(1110, '2024-01-23', 180.00, 175.00, 'PENDING', 5.00, 'S0003', 11),
(1111, '2024-01-23', 180.00, 180.00, 'PENDING', 0.00, 'S0001', 12);

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `ServiceID` int(11) NOT NULL,
  `ServiceType` varchar(20) NOT NULL,
  `Description` varchar(50) DEFAULT 'N/A',
  `Cost` double(10,2) NOT NULL DEFAULT 0.00,
  `LoyaltyPoint` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `StaffID` varchar(6) NOT NULL,
  `StaffPass` varchar(20) NOT NULL,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) NOT NULL,
  `ContactNo` varchar(10) NOT NULL,
  `Position` varchar(30) NOT NULL,
  `AdminID` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`StaffID`, `StaffPass`, `FirstName`, `LastName`, `ContactNo`, `Position`, `AdminID`) VALUES
('S0001', 'abc123', 'Danial', 'Hakim', '0133483570', 'Mechanic', 'A0001'),
('S0002', 'abc123', 'Muhammad', 'Arshad', '0128736189', 'Senior Mechanic', 'A0001'),
('S0003', 'abc123', 'Khalis', 'Zakwan', '0182337823', 'Mechanic', 'A0001');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `car_service`
--
ALTER TABLE `car_service`
  ADD PRIMARY KEY (`SlotID`,`ServiceID`,`CustID`),
  ADD KEY `StaffID` (`StaffID`),
  ADD KEY `ServiceID` (`ServiceID`),
  ADD KEY `CustID` (`CustID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustID`),
  ADD UNIQUE KEY `ContactNo` (`ContactNo`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`InvoiceID`),
  ADD KEY `SlotID` (`SlotID`),
  ADD KEY `StaffID` (`StaffID`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`ServiceID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`StaffID`),
  ADD UNIQUE KEY `ContactNo` (`ContactNo`),
  ADD KEY `AdminID` (`AdminID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `car_service`
--
ALTER TABLE `car_service`
  MODIFY `SlotID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5100;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `InvoiceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1112;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `ServiceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2210;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
