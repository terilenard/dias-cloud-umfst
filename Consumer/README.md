# Log Consumer Application

The Consumer implementation is based on the example from [Bosch IoT Example Consumer](https://github.com/bosch-io/iot-hub-examples) and the [Bosch implementation example](https://github.com/junh-ki/dias_kuksa/tree/master/utils/cloud/maven.consumer.hono). The current consumer reads telemetry from Bosch IoT Hub under the form of a log messages and further saves it into InfluxDB.

## Build and Package

To build and package the application as a runnable JAR file run:

~~~
mvn clean package -DskipTests
~~~

Docker:

~~~
git clone https://github.com/terilenard/dias-cloud-umfst.git

cd dias-cloud-umfst/Consumer

docker build -t hono-log-consumer .

docker run -p 8081:8081 -t hono-influxdb-connector --hono.client.tlsEnabled=true --hono.client.username=messaging@t6906174622fXXXXX7d1fefc53459 --hono.client.password=1234 --tenant.id=t6906174622ff488ba9b97d1fefXXXX --device.id=1234 --export.ip=influxdb:8086
~~~

## Run Example Consumer Application

The example consumer application needs a few parameters set to run. Please make sure the following are set correctly:

* hono.client.username: The username for the IoT Hub messaging endpoint 

* hono.client.password: The password for the IoT Hub messaging endpoint

* tenant.id: The tenant ID 

* server.url: The target InfluxDB URL address (Default: http://localhost:8086)

* device.id: Id of a device registerd into IoT Hub, from which the telemetry comes

All the information needed for setting these parameters can be found in the 'Credentials' information of a IoT Hub service subscription information.

To start the example consumer application (Linux & Mac), run:

~~~
java -jar target/maven.consumer.hono-0.0.1-SNAPSHOT.jar --hono.client.tlsEnabled=true --hono.client.username=messaging@<tenant_id> --hono.client.password=<password> --tenant.id=<tenant_id> --device.id=<deviceId> --export.ip=localhost:8086
~~~

The consumer application is ready as soon as 'Consumer ready' is printed on the console. The startup can take up to 10 seconds.
