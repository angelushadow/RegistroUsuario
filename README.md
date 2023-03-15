

# Registro Usuario

Spring Boot - Spring Security - API de creación de usuario generando Token JWT persistiendo en base de datos H2 y utilizando autenticación Token Bearer en los metodos de actualización, eliminación y consulta de usuario. 

## Description

![Diagrama de la API](https://github.com/angelushadow/RegistroUsuario/blob/main/Diagrama.png)

El proyecto esta desarrollado cumpliendo los siguientes requerimientos:
	
Request:

*	Ese endpoint recibe un usuario con los campos "name", "email", "password", más un listado de objetos "phones" con los campos "number", "cityCode", "countryCode".
	*	Todos los campos son obligatorios.
	*	El campo email cuenta con validacion por expresión regular configurable desde el archivo application.properties
	*	El campo email no puede ser duplicado.
	*	El campo password cuenta con validacion por expresión regular configurable desde el archivo application.properties
		*	una letra minuscula, un digito de 0-9, un caracter especial y una longitud de minimo 6 a 20 caracteres.


Response:

*	Formato de mensajes de respuesta de error: {"mensaje": "mensaje de error"}.
*	token de acceso de la API (JWT).

## Getting Started

### Dependencies

*	Jjwt 0.9.1
*	Spring Security
*	Apache Maven 3.8.5
*	java 8
*	JPA H2	
*	Swagger 2.9.2
*	Spring Boot 2.7.9
*	Lombok 1.18.26
*	mapstruct 1.4.2.Final

### Installing


1.	Realizar el clone del repositorio y ejecutar el comando mvn install para la descarga de las dependencias
	```sh
	mvn clean install -DSkipTests
	```
			
	
2.	Ejecutar proyecto 	
	```sh
	mvnw spring-boot:run
	```	
				
3.	Ir al navegador de preferencia e ingresar http://localhost:8080/api/swagger-ui.html	


### Testing

En tu navegador url http://localhost:8080/api/v2/api-docs para verificar documentacion Swagger.
importar esta documentacion con la herramienta Postman para generar los endpoints, ver https://www.baeldung.com/swagger-apis-in-postman para mas información.



* POST /api/new/user 

Request:
	{
		"name": "John Doe",
		"email": "john.doe@gmail.com",
		"password": "Hunter2+",
		"phones": [
			{
				"number": "1234567",
				"cityCode": "1",
				"countryCode": "57"
			}
		]
	}
	
Response:
	{
		"id": 1,
		"name": "John Doe",
		"email": "john.doe@gmail.com",
		"password": "Hunter2+",
		"created": "2023-03-10T11:30:46.050+00:00",
		"modified": "2023-03-10T11:30:46.050+00:00",
		"lastLogin": "2023-03-10T11:30:46.050+00:00",
		"token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJtaWNrZXlKV1QiLCJzdWIiOiJKdWFuIFJvZHJpZ3VleiIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdfQ.izcBOjd6MZKDVCxuReNpJHfxwRv5BXw4S8poB-bbuWCnD--b8QQtLSDSDkDYIDW4HoVfJ20Un3pUWpy90RHLhg",
		"isActive": true,
		"phones": [
			{
				"id": 2,
				"number": "1234567",
				"cityCode": "1",
				"countryCode": "57"
			}
		]
	}

* GET /api/user/1 Authorization Bearer

	Response:
	{
		"id": 1,
		"name": "John Doe",
		"email": "john.doe@gmail.com",
		"password": "Hunter2+",
		"created": "2023-03-10T11:30:46.050+00:00",
		"modified": "2023-03-10T11:30:46.050+00:00",
		"lastLogin": "2023-03-10T11:30:46.050+00:00",
		"token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJtaWNrZXlKV1QiLCJzdWIiOiJKdWFuIFJvZHJpZ3VleiIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdfQ.izcBOjd6MZKDVCxuReNpJHfxwRv5BXw4S8poB-bbuWCnD--b8QQtLSDSDkDYIDW4HoVfJ20Un3pUWpy90RHLhg",
		"isActive": true,
		"phones": [
			{
				"id": 2,
				"number": "1234567",
				"cityCode": "1",
				"countryCode": "57"
			}
		]
	}
	
* PUT /api/user/ Authorization Bearer

	Response:
		HttpStatus.NO_CONTENT
		
	* DELETE /api/user/1 Authorization Bearer

	Response:
		HttpStatus.NO_CONTENT
		
		
		
		
	
		
		

			
			
			
## Contact

John Ocampo - [@Linkedin](https://www.linkedin.com/in/john-bayron-ocampo-fonnegra/) - angelushadow@gmail.com

<p align="right">(<a href="#readme-top">back to top</a>)</p>