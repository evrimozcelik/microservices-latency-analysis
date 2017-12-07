# microservices-latency-analysis

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

In this code I investigated the effect of latency after splitting the monolith application into Microservices. The sample application com.mycompany.services was developed with Spring Cloud and can be deployed to Kubernetes as monolith or microservices.
