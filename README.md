# Microservices Latency Analysis

Microservices is a new architectural style to develop autonomous and distributed services and each service does one thing and does it well. Microservices provide lightweight protocols (like REST, Message Queue) and communicate with each other over those protocols and are very resilient for changing loads and failures. Microservices is often confused with SOA where SOA's main focus is on providing coarse grained services on the other hand Microservices' focus is on developing autonomous and distributed services and providing fine grained services.

Microservices introduce many advantages such as:
- Applications become simple and easy to implement, consume and maintain
- Applications can be developed by autonomous teams by using suitable platform (Java, .Net, Node.js, etc) and technology (NoSQL, Relational Database, etc)
- Release cycles can be decided independently by the team
- Releases can be more frequent which helps to provide end user demands in a short period of time
- Applications can be scaled easily

On the other hand as a nature of distributed environment there are some challenges that need to be addressed carefully:
- There should be mature DevOps practice in the organization
- Runtime environments should be provisioned very quickly
- Automation is required in test, build and deployment
- Applications should be designed to work in distributed environments
- Applications should be resilient for changing loads and failures
- Applications and data should be refactored into Microservices properly
- Remote calls will introduce latency and slow response times

With this code you can build a simulation environment to investigate the effect of latency after splitting the monolith application into Microservices. The sample application com.mycompany.services was developed with Spring Cloud and can be deployed to Kubernetes as a monolith application or microservices. The application exposes 2 services ServiceA and ServiceB with the same interface. To simulate CPU consumption, both services calculate a fibonacci based on input parameter and ServiceA additionally calls ServiceB after the calculation. Both services return a response message and the size of the message can again be set in the input parameter.

## Prerequisite

Create a Kubernetes cluster with either [Minikube](https://kubernetes.io/docs/getting-started-guides/minikube) for local testing, or with [IBM Bluemix Container Service](https://github.com/IBM/container-journey-template) to deploy in cloud.

You will need to create your Kubernetes cluster first and make sure it is fully deployed in your Bluemix account.

Please follow the steps below to install the sample application into your Bluemix Kubernetes cluster.

## Steps
1. [Prepare Bluemix Kubernetes cluster](#1-prepare-bluemix-kubernetes-cluster)  
2. [Create the Docker Image](#2-create-the-docker-image)  
2.1 [Build com.mycompany.services Project using Maven](#21-build-project-using-maven)  
2.2 [Build and Push Docker Images](#22-build-docker-image-for-app)
3 [Deploy the Application](#3-deploy-the-app)  
3.1 [Deploy the Application as Monolith](#31-deploy-the-app-as-monolith)
3.1 [Deploy the Application as Microservices](#32-deploy-the-app-as-microservices)

# 1. Prepare Bluemix Kubernetes cluster
Follow the instructions in [Getting Started] (https://console.bluemix.net/containers-kubernetes/home/registryGettingStarted) to setup required tools and Bluemix Kubernetes cluster.

# 2. Create the Docker Image

## 2.1 Build com.mycompany.services project using Maven
First build the java project with Maven and then build the Docker image using the provided **Dockerfile** in the project folder.

```bash
Go to com.mycompany.services
$ mvn package
```

## 2.2 Build Docker image for the application
Docker image can be pushed into the Bluemix Container Registry or DockerHub. The example below builds the docker image to be put into the Bluemix Container Registry, please replace the <namespace> with the name of your namespace.

```bash
$ docker build -t registry.eu-gb.bluemix.net/<namespace>/com.mycompany.services .
$ docker push registry.eu-gb.bluemix.net/<namespace>/com.mycompany.services
```

# 3. Deploy the Application
The application can be deployed as monolith or microservices with the use of JVM parameter spring active profile.

## 3.1 Deploy the Application as Monolith
Default spring profile works as monolith application.


## 3.1 Deploy the Application as Monolith
In order to make the application work as monolith application, please run it with no spring active profile parameter. The following yaml file takes care of this.

```bash
$ kubectl create -f monolith-deployment.yaml
```

## 3.2 Deploy the Application as Microservices
In order to make the application work as Microservices application, please run it with "Microservices" spring active profile parameter (-Dspring.profiles.active=microservices). The following yaml file takes care of this.

```bash
$ kubectl create -f microserviceA-deployment.yaml
$ kubectl create -f microserviceB-deployment.yaml
```
