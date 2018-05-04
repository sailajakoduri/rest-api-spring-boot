# rest-api-spring-boot

This project is all about movie ticke management with the operations add movie ticket, get movie ticket by ID, get all movie tickets , delete movie ticket and update the movie ticket.

PreRequisite: Postman plugin in chrome browser to test the rest api STS as IDE

Instructions To setup the API: Install STS(Spring Tool Suite) or add STS plugin in existig Eclipse. Unzip the MovieTicketBookingManagementApp folder and import this project into STS.

Build & Deploy: MovieTicketBookingManagementAppApplication is my spring boot application. HSQL is being used as Embedded database for storing the movie ticket. Either run MovieTicketBookingManagementAppApplication as java application or spring boot app

Junit Test cases: MovieTicktBookingControllerTest is the junit class testing the create and get movie ticket. Run this class as junit to execute the test cases.

Test Execution: Below are URL's along with http method to execute the Rest API in PostMan:

Create Movie Ticket: http://localhost:8080/api/movieTickets/create Http method: POST Sample JSON Object to create	: { "passengerName": "NK", "bookingDate": "2018-04-26T04:41:16.275+0000", "sourceStation": "IRVING", "destStation": "FRISCO", "email": "NK@gmail.com" }

Get Movie Ticket: http://localhost:8080/api/movieTickets/movieTicket/1 Http method: GET

Retrive all Movie Tickets: http://localhost:8080/api/movieTickets/movieTicket/all Http method: GET

Update Movie Ticket: http://localhost:8080/api/movieTickets/movieTicket/1/sck.1@gmal.com Http method: PUT

Delete Movie Ticket: http://localhost:8080/api/movieTickets/movieTicket/1 Http method: DELETE
