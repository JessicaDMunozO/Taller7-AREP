# Taller 7 - AREP
Para este taller se busca construir una aplicación web segura por medio del uso de certificados, con un servicio de login básico. Esto se consiguió por medio del comando de `keytool` 
para generar las llaves y el certificado. La aplicación permite un acceso seguro desde el browser y se probó el acceso a los servicios con dos instancias de *EC2* de *AWS* que estuvieran 
en comunicación. Se busca garantizar la autenticación, autorización e integridad.

## Empezando
Las siguientes instrucciones permiten que obtenga una copia del proyecto en funcionamiento.

### Prerrequisitos
1. Debe tener Maven y JDK para compilar y ejecutar el proyecto.
2. Verificar disponibilidad de puertos.
3. Tener conexión a internet.

### Instalación
Ahora bien, para obtener el proyecto y ejecutarlo, debe ser descargado en formato zip o puede ser clonado desde el repositorio de GitHub. Con el proyecto en su máquina, en dos terminales 
diferentes, debe acceder al directorio que contiene el proyecto. Luego, ejecute el comando `mvn clean install`. En una de las terminales ejecute el comando 
`java -cp "target/classes;target/dependency/*" co.edu.escuelaing.arem.ase.app.HelloWorld` y en la otra el comando 
`java -cp "target/classes;target/dependency/*" co.edu.escuelaing.arem.ase.app.UserLogin`.

**Nota**

Si tiene Mac o Linux cambie el ; por :

## Despliegue
Con el proyecto corriendo debe abrir en un navegador la siguiente dirección: https://localhost:5000/response.html allí podrá observar el formulario para hacer el login.

**Nota**

Dado que se definió una conexión segura por medio de las llaves y el certificado, es necesario que el protocolo sea *https*.

## Diseño
Se tiene la clase *HelloWorld* que crea el servidor web, allí se configura el servidor para que utilice *https* por medio del método *secure*. Además se usa la clase *SecureUrlReader*
para realizar la conexión segura al servicio que valida las credenciales para el login, teniendo el usuario y la contraseña ingresados en el formulario creado. 

Ahora, la clase *UserLogin* también fue configurada para usar *https* y se encarga de evaluar la autenticación. Para esto se crea un HashMap que guarda los nombres de usuario y las
contraseñas cifradas con el algoritmo `SHA-256` por medio de la clase *Cypher*. Se verifica si el usuario existe y si la contraseña es correcta, de acuerdo a la validación retorna un 
mensaje con el resultado de la autenticación.

Para escalar la arquitectura de seguridad para incorporar nuevos servicios, se podría centralizar la lógica de seguridad en un componente, para evitar que en cada servicio
se realice la misma configuración. Como lo que está sucediendo actualmente de que tanto la clase *HelloWorld* como la clase *UserLogin* llaman al método *secure* realizando
las mismas configuraciones.

## Evaluación
Con la dirección https://localhost:5000/response.html se puede observar el formulario del login.

![image](https://github.com/JessicaDMunozO/Taller7-AREP/assets/123814482/484f1d02-b3c9-460e-90de-232548632c21)

Si se ingresa un usuario que no existe se observa un mensaje de "Invalid username"

![image](https://github.com/JessicaDMunozO/Taller7-AREP/assets/123814482/7276c909-7a14-4794-b022-d5bc9019f5a2)

Si se ingresa un usuario existente pero con contraseña incorrecta, se observa el mensaje "Invalid password"

![image](https://github.com/JessicaDMunozO/Taller7-AREP/assets/123814482/37733d00-0717-4879-9fa8-aa89d205f4e1)

Y si se ingresa un usuario y contraseña correctos, se muestra el mensaje "Login successful"

![image](https://github.com/JessicaDMunozO/Taller7-AREP/assets/123814482/c2ff5274-0a18-4444-8da5-232d96548e32)

## Despliegue en AWS
https://youtu.be/9q8OGuJwrY0

## Construido con
Maven - Gestión de dependencias

AWS - Despliegue

## Versiones
Git - Control de versiones

## Autor
Jessica Daniela Muñoz Ossa




