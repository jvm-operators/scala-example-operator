# scala-example-operator

## Usage
```
# build the project
sbt clean assembly

# assuming Kubernetes is up and running, run the operator
java -jar ./target/scala-*/foo-operator-assembly-*.jar
```

then in another terminal

```
# create resource foo
kubectl create -f examples/foo.yaml

# delete resource foo
kubectl delete cm my-foo
```

You should be able to see
![alt text](https://github.com/jvm-operators/scala-example-operator/raw/master/foo-operator.png "Terminal dump")
