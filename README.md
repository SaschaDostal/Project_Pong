# Pong

Group-3 version of Pong

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
See [deployment](# Deployment) for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

#### Java
```
Linux:
>=openjdk-8-jre package
>=maven 3.6 package

Windows:
https://www.java.com/en/download/
https://howtodoinjava.com/maven/how-to-install-maven-on-windows/
```

### Installing

A step by step series of examples that tell you how to get a development env running

Cloning the repository

```
git clone https://gitlab.rz.hft-stuttgart.de/IP1/WS19_20/group-3-pong
```

Importing project

```
Open IDE of your choice
File->Import->Existing Maven Project
Enjoy!
```

Look at the current Version

```
mvn install
cd target/
java -jar de.hft.group-3-pong-0.0.X.jar
```

## Deployment

```
mvn install
cd target/
java -jar de.hft.group-3-pong-0.0.X.jar
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Sascha Dostal** - [SaschaDostal](https://gitlab.rz.hft-stuttgart.de/91dosa1bif)
* **Alexander Hötzel** - [AlexanderHötzel](https://gitlab.rz.hft-stuttgart.de/91hoal1bif)
* **Felix Körner** - [FelixKörner](https://gitlab.rz.hft-stuttgart.de/91kofe1bif)
* **Benjamin Taut** - [BenjaminTaut](https://gitlab.rz.hft-stuttgart.de/91tabe1bif)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.