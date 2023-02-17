# RockPaperScissorsApi

## Getting started
Welcome. This brief document is meant to guide you step by step to get the rock-paper-scissors API REST running, so that the Front-end part can function properly.

Lets get started!

### Get and install Java JDK

Download the Java JDK from https://jdk.java.net/. Choose the one that suits you better acording to your machine, and make sure it is versión 11 or higher. Once the download is complete, extract it in a folder. 

If order to execute java commands from anywhere in the system's folder structure when using a terminal, it is required to create ***JAVA_HOME*** user variable and add it to the ***PATH*** system variable. This step is system dependant, so we wont get into any details of how to do so.

### Get and install Apache Maven

Download the Apache Maven tool from https://maven.apache.org/download.cgi. Choose your system version needed. Once the download's process ends, extract it in a located folder. 

Same with Java JDK, we need to add it to certain system variables in order to execute maven from anywhere besides it's actual location. Check how to create ***M2_HOME*** user variable and add it to the ***PATH*** system variable.

I.e. here's a tutorial on how to configure both (Java and Maven) on Mac OS: https://www.digitalocean.com/community/tutorials/install-maven-mac-os

### Download or clone the repository

Download the project's code by clicking in ***Code*** >> ***Download ZIP***

Unzip the project in the desired folder, i.e. C:\Dev\rock-paper-scissors-api\

Or you can just clone the repository:
```shell
cd C:\Dev\rock-paper-scissors-api\
```
```shell
git clone https://github.com/C4rl3s/rock-paper-scissors-api.git
```

### Run the app

Now that we have downloaded our API REST project, lets run it. First of all we need to download all of the software dependencies the project has. The dependencies are managed by Maven, and are defined in a XML file called ***pom.xml*** (Project Object Model). Let's do it by typing:
```shell
mvn clean install
```

This command will have Maven download and install the project's dependencies, will execute the JUnit tests (if there are) and also will compile the project with the Java Compiler. All that's left to do is run it, by typing:
```shell
mvn spring-boot-run
```
After this, our Rock, Paper, Scissors API REST should be running and waiting for any HTTP request at port 8080.

### Run tests

In order to test the endpoints exposed and the services, there's a few simple ***unitary and integration tests*** implemented in the project.

Although they are executed when we do ***mvn clean install*** command, to specifically run them, just type:
```shell
mvn clean test
```
