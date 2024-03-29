# Pong

Project work in the subject Software Project 1. This application is a Java implementation of the game Pong.

## Preview
![Alt text](./preview/preview_0.PNG)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
See [deployment](#deployment) for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

#### Java
```
Linux:
>=jdk8-openjdk package
>=jre8-openjdk package
>=maven 3.6 package

Windows:
https://www.java.com/en/download/
https://howtodoinjava.com/maven/how-to-install-maven-on-windows/
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
```

### Installing

A step by step series of examples that tell you how to get a development env running

Cloning the repository

```
git clone https://gitlab.rz.hft-stuttgart.de/IP1/WS19_20/group-3-pong.git
git lfs pull
```

Importing project

```
Open IDE of your choice
File->Import->Existing Maven Project
Enjoy!
```

Look at the current Version

```
mvn package
cd target/
java -jar de.hft.group-3-pong-0.0.X.jar
```

## Deployment

```
mvn package
cd target/
java -jar de.hft.group-3-pong-0.0.X.jar
```

### Alternative with IDE (eclipse)
```
Run->Run As->Maven install
repodir/target/de.hft.group-3-pong-0.0.X.jar
```

### Game Controls

Player 1: UP - 'W', DOWN - 'S'

Player 2: UP - 'UP-Arrow', DOWN - 'DOWN-Arrow'

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Eclipse](https://www.eclipse.org/) - Java IDE
* [Java](https://www.java.com/en/) - Programming language

## Authors

* **Sascha Dostal** - [SaschaDostal](https://gitlab.rz.hft-stuttgart.de/91dosa1bif)
* **Alexander Hötzel** - [AlexanderHötzel](https://gitlab.rz.hft-stuttgart.de/91hoal1bif)
* **Felix Körner** - [FelixKörner](https://gitlab.rz.hft-stuttgart.de/91kofe1bif)
* **Benjamin Taut** - [BenjaminTaut](https://gitlab.rz.hft-stuttgart.de/91tabe1bif)

See also the list of [contributors](https://gitlab.rz.hft-stuttgart.de/IP1/WS19_20/group-3-pong/-/graphs/master) who participated in this project.