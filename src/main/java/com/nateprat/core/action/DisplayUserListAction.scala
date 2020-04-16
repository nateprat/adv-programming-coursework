package com.nateprat.core.action
import com.nateprat.model.RouteMap
import com.nateprat.system.user.Menu

object DisplayUserListAction extends Action[Unit] {

  override def identifier(): String = "E"

  override def desc(): String = String.format(descString, "Display User Lists")

  override def act(map: RouteMap): Unit = {
    val userList = Menu.userLists.toList
    userList.foreach(println)
  }

}
