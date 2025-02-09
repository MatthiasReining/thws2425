## Project Setup

### Git clone

    git clone git@github.com:MatthiasReining/thws-cnej2425.git

### Preconditions

    mvn: 3.9.6
    java: Java HotSpot(TM) 64-Bit Server VM Oracle GraalVM 21.0.2+13.1 (build 21.0.2+13-LTS-jvmci-23.1-b30, mixed mode, sharing)

    Wildfly: ..\srv\wildfly-34.0.1.Final (installed)

**Project init**

Initial setup via mvn archetype

    mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:generate -DarchetypeArtifactId="jakartaee10-minimal" -DarchetypeGroupId="org.eclipse.starter" -DarchetypeVersion="1.1.0" -DgroupId="de.thws.appserver" -DartifactId="demo"

## Deploy

### Server start

    srv\wildfly-34.0.1.Final\bin\standalone.bat

### via CLI

In general (for all App servers): Ship / copy the _war_ file to the deployment directory.

    mvn clean package -DskipTests && copy target\demo.war ..\..\srv\wildfly-34.0.1.Final\standalone\deployments\. /Y

Undeploy by removing the file from the _deployments_ directory.

### Wildfly Plugin

With _Wildfly_ you can also use mvn

    mvn org.wildfly.plugins:wildfly-maven-plugin:deploy

    mvn org.wildfly.plugins:wildfly-maven-plugin:undeploy

(or setup within pom.xml)

### IDE Plugin

VSC: https://marketplace.visualstudio.com/items?itemName=redhat.vscode-server-connector

Also useful for debug mode and hot code replacement

### Test

    curl http://localhost:8080/demo/hello

## Exmples

- http://localhost:8080/demo/post2.html
- http://localhost:8080/demo/first
- http://localhost:8080/demo/redirect
- http://localhost:8080/demo/forward
- http://localhost:8080/demo/contenttype
- http://localhost:8080/demo/status?targetStatus=204

### From Wildfly

see https://github.com/wildfly/quickstart

## Dockerize

    docker build -t thws/demo .
    docker run -p 8080:8080 thws/demo

## SOAP WS

http://localhost:8080/demo/StudentService?wsdl

Testable via SOAP UI
