package io.radanalytics.operator.foo

import io.fabric8.kubernetes.client.KubernetesClient
import io.radanalytics.operator.common._
import io.fabric8.kubernetes.api.model.ConfigMap
import io.radanalytics.operator.resource.HasDataHelper
import org.slf4j.{Logger, LoggerFactory}

@Operator(forKind = "foo", prefix = "radanalytics.io", infoClass = classOf[FooInfo])
class IspnOperator extends AbstractOperator[FooInfo] {
  val log: Logger = LoggerFactory.getLogger(classOf[FooInfo].getName)

  @Override
  def onAdd(foo: FooInfo)= {
    log.info(s"created foo with name ${foo.name} and someParameter = ${foo.someParameter}")
  }

  @Override
  def onDelete(foo: FooInfo) = {
    log.info(s"deleted foo with name ${foo.name} and someParameter = ${foo.someParameter}")
  }
}


class FooInfo(var name: String, var someParameter: String) extends EntityInfo {
  def this() = this("", "")
  def getName = name
  def setName(name: String) = this.name = name
  def getSomeParameter = someParameter
  def setSomeParameter(someParameter: String) = this.someParameter = someParameter
}