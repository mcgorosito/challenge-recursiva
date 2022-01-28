## Challenge Recursiva

Este es la resolución de un challenge para la empresa Recursiva. Consiste en crear un programa que lea una planilla .csv con el formato "Nombre, Edad, Equipo, Estado Civil, Estudios alcanzados" separados por un punto y coma (;) y que imprima la siguiente información:

1. Cantidad total de personas registradas.
2. El promedio de edad de los socios de Racing.
3. Un listado con las 100 primeras personas casadas, con estudios
Universitarios, ordenadas de menor a mayor según su edad. Por
cada persona, mostrar: nombre, edad y equipo.
4. Un listado con los 5 nombres más comunes entre los hinchas de River.
5. Un listado, ordenado de mayor a menor según la cantidad de
socios, que enumere, junto con cada equipo, el promedio de edad
de sus socios, la menor edad registrada y la mayor edad registrada.
## Build

El proyecto usa mvn, por lo que para compilarlo, debemos utilizar el siguiente comando en la consola:

```bash
mvn clean package install
```

## Ejecución
Para ejecutar el programa, tenemos que ejecutar el siguiente comando en la consola:

```bash
java -jar target/challenge-recursiva-1.0-SNAPSHOT.jar "path-al-archivo"
```
Esto hará que nos imprima por consola el resultado.

## Testing

El proyecto cuenta con una clase de test ChallengeRecursivaTest.java, que testea la funcionalidad de cada cálculo sobre la lista de socios. Corren con JUnit o también se corren al compilar en Maven.

## Posibles optimizaciones

Al ser un mini challenge, se dejaron de lado muchas cuestiones que podrían escribirse de manera más óptima. Numeramos algunas:
- El proyecto asume que el output que nos dan tiene siempre el mismo formato. Podría agregarse un manejo de excepciones o agregar mensajes de error para facilitar el debugging. El enunciado dejaba abierta esta cuestión.
- En el cálculo del promedio, mayor y menor edad por equipos se utilizan tres mapas que, por enunciado, tendrán las mismas keys. Esos tres valores podrían reducirse a un solo objeto que contenga toda la información que necesito sobre ese equipo en particular.
- En el cálculo del promedio, mayor y menor edad por equipos se itera por la lista de socios dos veces. Es posible que exista una manera más óptima de obtener estos datos iterando sobre la mismuna sola vez, teniendo una variable donde me guardo la menor edad que encontré hasta ahora, otra donde me guardo la mayor edad que encontré hasta ahora, una donde me guardo la suma de las edades y una cuarta donde tengo cuántos socios de ese equipo de fútbol hay. Al final, se calcula el promedio con esos dos últimos datos y con eso estaría resuelto el problema.
- El proyecto imprime todos los resultados por consola. En general, el output no es demasiado largo porque suele estar acotado por cantidad de socios (cien socios, cinco hinchas de river, etc.) por lo que puede visualizarse completo, pero en caso de que existan muchos equipos diferentes de fútbol, el último cálculo puede hacerse demasiado largo y que se vea recortado. Para evitar esto, se podría guardar en un archivo. Hay muchas librerías que permiten escribir sobre archivos, como FileWriter o PrintWriter. 
- Faltan varios casos bordes de testing.