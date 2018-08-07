package io.radanalytics.operator.ispn

import io.fabric8.kubernetes.client.KubernetesClient
import io.radanalytics.operator.common._
import io.fabric8.kubernetes.api.model.ConfigMap
import io.radanalytics.operator.resource.HasDataHelper

case class IspnInfo(var name: String, foo: String) extends EntityInfo {
  def getName = name
  def setName(name: String) = this.name = name
}

@Operator(forKind = "ispn", prefix = "radanalytics.io")
class IspnOperator(ns: String, isOpenshift: Boolean, client: KubernetesClient) extends AbstractOperator[IspnInfo](ns, isOpenshift, client) {

  @Override
  def onAdd(ispn: IspnInfo, isOpenshift: Boolean): Unit = {

  }

  @Override
  def onDelete(ispn: IspnInfo, isOpenshift: Boolean): Unit = {

  }

  @Override
  def onModify(ispn: IspnInfo, isOpenshift: Boolean): Unit = {

  }

  @Override
  def isSupported(cm: ConfigMap): Boolean = {
    true
  }

  @Override
  def convert(cm: ConfigMap): IspnInfo = HasDataHelper.parseCM(classOf[IspnInfo], cm)

}
