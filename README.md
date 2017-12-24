# Android architecture components with Kotlin and Dagger

A simple app to showcase android architecture components with Kotlin and Dagger

## App structure

* **database** package contains all db related classes
* **di** package contains all dagger modules and components
* **models** contain all data models that are used to de-serialzie service responses
* **repository** package holds all repository implementations
* **services** package holds interfaces that define what methods a service client should implement (retrofit client for example)
* **ui** package contains all UI related classes like activities and adapters

## Architecture components 

* **Room** as an ORM library and LiveData provider
* **ViewModels** as a view model pattern implementation
* **Pagin Library** as a bridge between adapter source and db


