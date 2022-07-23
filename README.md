Project:
---
```
Проект представляет собой интернет магазин состоящий из микросервисов, 
микросервисы общаются через микросервис Gateway.
Авторизация и регистрация пользователя происходит через микросервис auth-service?
который в последствии осуществляет контроль доступа пользователя к определенным микросервисам
Также настроено общение сервисов между собой с помощью WebClient
Стэк: 
Backend: Java, Spring Boot, Spring Security, Spring Data JPA, JDBC, Hibernate, 
         PostgreSQL, Redis, Test JUnit, lombok, flyway, Docker, WebClient, Swagger
Front: JavaScript, AngularJS, HTML, CSS

Главная страница доступна по адресу localhost:3000/front  
• Сборка и запуск каждого сервиса в Docker контейнере:

```
## Endpoints:

Все endpoints можно посмотреть через swagger по ссылке
после запуска соответствующего микросервиса:

core-service - http://localhost:8189/web-market-core/swagger-ui/index.html
auth-service - http://localhost:8189/web-market-auth/swagger-ui/index.html
cart-service - http://localhost:8189/web-market-cart/swagger-ui/index.html

Docker:
---
Для создания  и запуска каждого сервиса в Docker перейти в корневую директорию каждого сервиса,  
где лежит фаЙл docker-compose.yml и запустить команду:  
```  
docker-compose up -d  
```
Каждый сервис установиться в Docker и запустится