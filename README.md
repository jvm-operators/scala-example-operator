# scala-example-operator

## Code

```scala
@Operator(forKind = "foo", prefix = "radanalytics.io", infoClass = classOf[FooInfo])
class FooOperator extends AbstractOperator[FooInfo] {
  val log: Logger = LoggerFactory.getLogger(classOf[FooInfo].getName)

  @Override
  def onAdd(foo: FooInfo) = {
    log.info(s"created foo with name ${foo.name} and someParameter = ${foo.someParameter}")
  }

  @Override
  def onDelete(foo: FooInfo) = {
    log.info(s"deleted foo with name ${foo.name} and someParameter = ${foo.someParameter}")
  }
}
```
Check the full source code of the [operator](https://github.com/jvm-operators/scala-example-operator/blob/master/src/main/scala/io/radanalytics/operator/foo/FooOperator.scala)

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
