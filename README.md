# Roll the dice

This is all-in-one Spring Boot solution incorporating Database, backend-end and front-end layers, allowing to execute dice roll simulations, as well as querying past simulations and getting some statistical insights.

## Running application
- Run `./gradlew bootRun` in root directory
- Navigate to http://localhost:8080 in browser

## Technology stack
- Storage - in memory H2 database
- Data access layer - JPA + Spring Data
- Service layer - Spring Web for RESTful webservices
- UI - Angular

## Decisions made
1. In-memory H2 is chosen as the best option for quick prototyping of solution having storage layer. Not for Production use
1. Spring Data is chosen as it allows to minimize DAO layer implementation efforts and boilerplate, while retaining high flexibility and allowing to run custom SQL-queries
1. Spring Web is chosen to implement RESTful API - today's standard for APIs consumed by UIs and not only those.
1. Angular (+Bootstrap) - as per request - my Production experience is mostly with React and libs around it (Redux, Jest, Enzyme, ...)

## Shortcuts
1. No state management in UI - acceptable for current app complexity and didn't have time to learn Angular-world practices in this regards.
1. No routing in UI - could not find quick&easy answer on how to pass data to between routed components
1. No UI tests, except for those automatically generated
1. Limited amound of Java tests
