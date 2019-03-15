
## [WIP] Project-Manager 
Project-Manager is a simple application for managing projects at company. You can create teams and add members to it. You can create, modify projects and assing teams to them. (basically something similar to Trello - [wiki](https://en.wikipedia.org/wiki/Project_management_software))

<b> We'll go from traditional layered architecture to hexagonal architecture A.K.A. Ports and Adapters architecture. </b>

#### Working with Project-Manager

`./gradlew bootRun` - to run application. <BR>
`./gradlew test` - to run unit tests. <BR>
`./gradlew integrationTest` - to run integration tests. <BR>
`./gradlew clean build test integrationTest`- one to rule them all 💍 <BR>
<BR>

## Implementation step-by-step

<BR>
  
### 1️⃣ `branch: step-1-team` <br>
🏠 **Architecture**: Layered Architecure <BR>

* [x] `POST: /teams` - create a team. <br>
* [x] `POST: /teams/:teamName/members` - add members to the team. <br>
* [x] `GET: /teams` - show teams. <br> <br>

<BR>

### 2️⃣ `branch: step-2-projects` <br>
🏠 **Architecture**: Layered Architecure <BR>

* [x] `POST: /projects/drafts` - create project draft (only project name). <br>
* [x] `POST: /projects` - create full project (project with features📊). <br>
* [x] `GET: /projects` - show draft projects <br>

<BR>

### 3️⃣ `branch: step-3-refactor` <br> 
🏠 **Architecture**: Hexagonal Architecure <BR>

Refactor to hexagonal architecture. Removed unnesesary Dto objects. Test cleanup.

<BR>
  
### 4️⃣ `branch: step-4-projects` <br> 
🏠 **Architecture**: Hexagonal Architecure <BR>

* [ ] `GET: /projects/:id` - show project (project not project draft)<br>
* [ ] `PUT: /projects/:id` - change/update project <br>
* [ ] `PATCH: /projects/:id/started` - start team when team assigned <br>
* [ ] `PATCH: /projects/:id/ended` - close project when features are done <br><br>

<BR>

### 5️⃣ `branch: step-5-zoo-of-microservices` <br>
🏠 **Architecture**: Hexagonal Architecture (modularization on package level) <BR>
Backing-Services from [Twelve-Factor-App](https://12factor.net/) methodology.

Services from our zoo:<BR>
🦓 **user-autorization-service** - authentication gateway that protects back-end resources. There is two kinds of resources protected and unprotected. First one requires user-level authentication and second one is just read-only such as listing of offers/products. <BR><BR>
🐼 **edge-service** - gives possibility to expose unified REST API from all of ours backend services. To be able to do this, the Edge Service matches a request route’s URL fragment from a front-end application to a back-end microservice through a reverse proxy to retrieve the remote REST API response. <BR><BR>
🐰 **discovery-service** - Edge-service matches a request route’s URL fragment from a front-end application to a back-end microservice through a reverse proxy to retrieve the remote REST API response. <BR><BR>
🐿 **centralized-configuration-server** - Spring Cloud application that centralizes external configurations using various methodologies of [building twelve-factor applications](https://12factor.net/config). <BR><BR>

<BR>

### #️⃣ `branch: will-be-more` <br>
- monitoring, grafana, actuator 

<BR><BR>
  
## Technologies used: 
- kotlin with spring 
- groovy (spock) for tests
- gradle to build project
  
#### Materials
* [Prawie trywialna aplikacja do zarządzania projektami (PL)](http://braintelligence.pl/prawie-trywialna-aplikacja-do-zarzadzania-projektami) - opis tego projektu we wpisie.
* [Strategic Tools from Domain-Driven-Design (ENG)](http://www.braintelligence.pl/the-nature-of-domain-driven-design/)
* [ ddd-workshop-project-manager ](https://github.com/mkopylec/project-manager)
* [ design patterns for humans ](https://github.com/kamranahmedse/design-patterns-for-humans)
* [ ddd-laeven ](https://github.com/BottegaIT/ddd-leaven-v2)
* [ awsome-ddd ](https://github.com/heynickc/awesome-ddd)
* [Twelve-Factor-App - methodology for building software-as-a-service](https://12factor.net/)
