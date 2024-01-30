# Clean Architecture Android Project

Welcome to the Clean Architecture Android Project! This repository serves as a demonstration of how to implement clean architecture principles in an Android application. Clean architecture promotes separation of concerns and maintainability by organizing code into distinct layers with clear dependencies.

## Table of Contents
- [Introduction](#introduction)
- [Architecture Overview](#architecture-overview)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Getting Started](#getting-started)


## Introduction

This Android project aims to showcase the implementation of clean architecture principles, inspired by the principles outlined by Robert C. Martin (Uncle Bob). The goal is to create a scalable, maintainable, and testable codebase by adhering to a clear separation of concerns.

## Architecture Overview

The project follows the clean architecture pattern, which consists of three main layers:

1. **Presentation Layer (app module):** This layer is responsible for UI-related tasks. It includes activities, fragments, and view models. The presentation layer is designed to be independent of the business and data layers.

2. **Domain Layer (domain module):** The domain layer contains the business logic and use cases. It defines the entities, use cases, and business rules. This layer is independent of the presentation and data layers.

3. **Data Layer (data module):** The data layer is responsible for data retrieval and storage. It includes repositories, data sources, and network-related tasks. The data layer is independent of the presentation and domain layers.

This separation ensures that each layer is independent and can be tested in isolation. Dependencies flow inward, allowing for easy substitution of components, and making the codebase flexible and maintainable.

## Project Structure

The project is structured into 2 main modules:

- **app:** This module contains the presentation layer, including activities, fragments, and view models.

- **core:** This module contains the domain layer, including entities, use cases, data layer, including repositories, data sources and business rules.

## Dependencies

The project uses the following libraries:

- **AndroidX:** AndroidX libraries are used for UI components and other Android-related functionalities.

- **Kotlin Coroutines:** Used for handling asynchronous tasks.

- **Hilt:** Dependency injection library for providing clean and modular code.

- **Retrofit:** HTTP client for making network requests.

- **Room:** SQLite database library for local data storage.

- **ViewModel:** Part of the Android Architecture Components for managing UI-related data.

## Getting Started

To run this project, you need Android Studio installed on your machine. Clone the repository and open it in Android Studio. Build and run the app on an emulator or physical device.

