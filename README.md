## pinappDemo API Challenge
<br>
<br>

---

### Overview

The pinappDemo microservice is developed using Java Spring Boot.  
This REST API is documented in Swagger and deployed on AWS.  
The project code is available on GitHub.  
The API provides endpoints for managing client data, calculating key performance indicators, and retrieving client information.  

<br>

---

### Features

Microservice: Developed in Java Spring Boot
API Documentation: Available through Swagger
Deployment: Hosted on AWS 
Code Repository: GitHub Repository

<br>

---

### API Endpoints

<br>

**1. Create Client**  
   
URL: pinappdemo.foxtrotpotato.com/api/clientes/creacliente  
Method: POST  
Description: Create a new client record.  

Request Body:  
```
json  
{  
  "clientId": 0,  
  "firstName": "Bobba",  
  "lastName": "Fett",  
  "age": 30,  
  "birthday": "2024-08-24"  
}  
  ```

Response:  
```  
json  
{  
  "clientId": 17,  
  "firstName": "Bobba",  
  "lastName": "Fett",  
  "age": 30,  
  "birthday": "2024-08-24"  
}  
```
<br>

**2. Retrieve Clients**  

URL: /api/clientes/listclientes  
Method: GET  
Description: Retrieve a list of all clients along with their data and possible estimated date of death.  

Response:  
```  
json  
...  
  {  
    "clientId": 17,  
    "firstName": "Bobba",  
    "lastName": "Fett",  
    "age": 30,  
    "birthday": "2024-08-24",  
    "deathDate": "2094-08-24"  
  },  
...  
```  
  
**3. KPI Calculation**  

URL: /api/clientes/kpi  
Method: GET  
Description: Retrieve the average age and standard deviation of ages for all clients.  

Response:  
```
json  
{  
  "averageAge": 40.142857142857146,  
  "standardDeviation": 22.16450554653654  
}  
```
<br>
<br>

---

Swagger UI  
Explore and interact with the API using Swagger UI. Access it at: https://pinappdemo.foxtrotpotato.com/swagger-ui/index.html#/Clientes  

<br>
<br>

---

 Microservices challenge:  

> * Microservice developed in JAVA Spring boot  
> * APIRest documented in Swagger  
> * Deployed in AWS or any other CLOUD + code uploaded to GITHUB  
> * POST Inbound Endpoint /creacliente  
>    - Name  
>    - Last Name  
>    - Age  
>    - Birthday  
> * GET Outbound port /kpideclientes  
>    - Average age of all clients  
>    - Standard deviation between ages of all clients  
> * GET Outbound port /listclientes  
>    - List of all people with all their data + possible estimate date of death  

//

Desafío a resolver de microServicios:  
> * Microservicio desarrollado en JAVA Spring boot  
> * APIRest documentada en Swagger  
> * Deployado en AWS o algún CLOUD + códigosubido en GITHUB  
> * Endpoint de Entrada POST/creacliente  
>   - Nombre  
>   - Apellido  
>   - Edad  
>   - Fecha de nacimiento  
> * Endpoint de salida GET /kpideclientes  
>   - Promedio edad entre todos los clientes  
>   - Desviación estándar entre las edades de todos los clientes  
> * Endpoint de salida GET /listclientes  
>   - Lista de personas con todos los datos + fecha probable de muerte de cada una  
