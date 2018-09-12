package io.radanalytics.operator.foo

import io.fabric8.kubernetes.api.model.ConfigMap
import io.fabric8.kubernetes.client.KubernetesClient
import io.radanalytics.operator.common._
import io.radanalytics.operator.resource.HasDataHelper
import org.slf4j.{Logger, LoggerFactory}

@Operator(forKind = classOf[Foo], prefix = "radanalytics.io")
class FooOperator extends AbstractOperator[Foo] {
  val log: Logger = LoggerFactory.getLogger(classOf[Foo].getName)

  @Override
  def onAdd(foo: Foo) = {
    log.info(s"created foo with name ${foo.name} and someParameter = ${foo.someParameter}")
  }

  @Override
  def onDelete(foo: Foo) = {
    log.info(s"deleted foo with name ${foo.name} and someParameter = ${foo.someParameter}")
  }
}


class Foo(var name: String, var someParameter: String) extends EntityInfo {
  def this() = this("", "")
  def getName = name
  def setName(name: String) = this.name = name
  def getSomeParameter = someParameter
  def setSomeParameter(someParameter: String) = this.someParameter = someParameter
}