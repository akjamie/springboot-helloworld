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
- k8s deployment config
```
---
apiVersion: v1
kind: Namespace
metadata:
  name: k8s-test
---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: helloworld-deployment
  namespace: k8s-test
  labels:
    app: hello-world
spec:
  replicas: 3
  selector:
    matchLabels:
      app: hello-world
  template:
    metadata:
      labels:
        app: hello-world
    spec:
      containers:
        - name: hello-world
          image: gcr.io/steady-grid-281506/helloworld:1.0.0
          ports:
            - containerPort: 8080

---
apiVersion: v1
kind: Service
metadata:
  name: hello-world-lb
  namespace: k8s-test
  labels:
    app: hello-world
spec:
  type: LoadBalancer
  ports:
    - port: 10000
      targetPort: 8080
  selector:
    app: hello-world
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
1.https://estl.tech/configuring-https-to-a-web-service-on-google-kubernetes-engine-2d71849520d 
