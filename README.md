# spring-boot-scala

## About
This is an example project on how to set up a [Spring Boot](https://projects.spring.io/spring-boot/) microservice using [Scala](https://www.scala-lang.org/) and [SBT](http://www.scala-sbt.org/).
Furthermore, some adjustments are made to the project configuration so that the project is easily exportable to
different formats like a [Docker](https://www.docker.com/) image, zip, rpm, deb, zip, msi or dmg.
The awesome [sbt-native-packager](http://sbt-native-packager.readthedocs.io/en/stable/) plugin is used for that.

The idea behind this project is simply to show the few specialities in syntax when using the Java-centric Spring
framework with Scala, especially in regard of annotations and dependency injection.

Also you don't have to be afraid to mix Scala and Java code which is shown by sharing the service instance with two
controllers, one implemented in Scala, the other in Java.

Just browse the code, it's only a few files and lines. :)

## Prerequisites
The project was developed with the following versions but other version might also work.
* Java 8
* SBT 0.13.15

Additionally, for the containerization features you need
* Docker 17.06.0-ce
* docker-compose 1.14.0

## The service
The application will boot up a Spring Boot application, exposing two request handlers under the path `http://localhost:8080/test` and
`http://localhost:8080/testjava`.

A configuration instance of type *MyServiceConfiguration* is created and a configuration key is loaded from the file
*application.yml* and injected into the configuration instance by Spring. This configuration instance is provided to the
service instance of class *MyService*.

The service provides one method that simply returns a simple string and the value loaded from the configuration.

The request handlers are defined in the Scala class *MyServiceController* and the Java class *MyServiceJavaController*.
The instances receive the service instance via dependency injection. They call the service in their request handlers and
return a string composed of a greeting message and the service call result (another String as mentioned above).

## Running
There are different ways on how to execute the application.

* For quick testing, you can simply call `sbt run` on the command line. On the first time, this will download all
required dependencies. Then the main class of the application is executed and the Spring Boot application is started.
This way of running the application is only recommended for development purposes since the whole application is started
in the same JVM that SBT is running in, which you would not want to happen in a production environment.
* In order to compile the project, package it and let SBT generate a startup-script, execute `sbt universal:stage`.
In the folder *target/universal/stage* you find the result. You have a *lib* folder containing all dependencies and a
*bin* folder that contains the automatically generated startup-scripts.
Execute `bin/springbootscala` on Linux and Mac or `bin/springbootscala.bat` on Windows.

## Containerization
You can easily create a Docker image from the project by calling `sbt docker:publishLocal`. This will create a Docker
image based on *openjdk:8-jre-alpine* image. The image is extended by adding all dependencies and the startup-scripts. Run the command
`docker images` and you will see the image being available.

In order to start a container based on that image and expose port 8080 of the container to your local machine, simply
execute `docker-compose up` in the project folder. There is a *docker-compose.yml* for that purpose.

## Further ideas
* Definately check the *sbt-native-packager* plugin for other options how you can export the application.