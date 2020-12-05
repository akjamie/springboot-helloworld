Sample project - hello world, which used for test GCP k8s deployment
## Configs
- maven configs - use jib plugin for docker image build
```
<plugin>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>${jib.version}</version>
    <configuration>
        <from>
            <image>openjdk:alpine</image>
        </from>
        <to>
            <image>gcr.io/steady-grid-281506/${artifactId}:${project.version}</image>
        </to>
        <container>
            <creationTime>USE_CURRENT_TIMESTAMP</creationTime>
        </container>
        <allowInsecureRegistries>true</allowInsecureRegistries>
    </configuration>
</plugin>
```

## Useful Commands 
- gcloud container clusters get-credentials cluster-1 --zone asia-northeast2-a --project steady-grid-281506  
get credentials of k8s cluster on GCP  
- kubectl apply -f hello-world-k8s-deployment.yml  
create resource and deployment  
- gcloud container clusters list  
list all the clusters under current project  
- gcloud container node-pools list --zone asia-northeast2-a --cluster cluster-1  
show the node pool of given cluster, in K8S, the nodes in cluster are managed under instance group  

## FAQ
1. Get below errors when run "mvn clean package jib:build"
{"errors":[{"code":"UNAUTHORIZED","message":"You don't have the needed permissions to perform this operation, and you may have invalid credentials. To authenticate your request, follow the steps in: https://cloud.google.com/container-registry/docs/advanced-authentication"}]}
>not configured the GCP Registry's credentials, let's ignore this issue and check-in codes directly, will run the build 
command in Google Cloud Shell.

**Referred articles/blogs**  
1.https://stackoverflow.com/questions/58493850/cannot-process-application-with-runtime-java8-google-appengine-deployment-err  
2.https://cloud.google.com/appengine/docs/standard/java/tools/uploadinganapp#deploying_an_app  
