Sample project - hello world, which used for test GCP AppEngine standard environment deployment

**AppEngine build maven plugin**  
```
    <!-- add for GCP appengine build -->
    <plugin>
        <groupId>com.google.cloud.tools</groupId>
        <artifactId>appengine-maven-plugin</artifactId>
        <version>${appengine-maven-plugin.version}</version>
        <configuration>
            <version>2</version>
            <projectId>steady-grid-281506</projectId>
        </configuration>
    </plugin>
```
**AppEngine project config file**  
```
runtime: java11
instance_class: F1
service: hello-world
```
**Usefull Commands**  
 - mvn package appengine:deploy  
 deploy application to GCP AppEngine, support more args, like -Dapp.deploy.projectId=PROJECT_ID, these also can be configured
 in pom.xml  
 - gcloud app services list  
 list all the service you've deployed
 - gcloud app services delete [SERVICES...] [--version=VERSION]
 delete service, also support delete against concrete version of given service.

**Others**  
1.AppEngine support traffic splitting across multiple version for the service you deployed, for instance,
there are two version for your application hello-world, v1 and v2, you can set 90% of all http request traffic route to v1, 
and leave 10% to the newer version v2.  
2.Please refer to [official docs](https://cloud.google.com/appengine/docs/the-appengine-environments) to know the pros/cons
of the standard and flexible environments before you decide which kind of environment to go with.  

**Referred articles/blogs**  
1.https://stackoverflow.com/questions/58493850/cannot-process-application-with-runtime-java8-google-appengine-deployment-err  
2.https://cloud.google.com/appengine/docs/standard/java/tools/uploadinganapp#deploying_an_app  
