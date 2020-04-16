package com.nateprat.core.action
import com.nateprat.core.interactive.UserRouteList
import com.nateprat.core.map.RouteMapToRouteList
import com.nateprat.model.{Route, RouteMap}
import com.nateprat.system.prompts.{AppStrings, UserPrompt}
import com.nateprat.system.user.Menu
import com.nateprat.utils.{ListAndSelectRouteUtil, UserInput}

object CreateUserListAction extends Action[Unit] {

  override def identifier(): String = "L"

  override def desc(): String = String.format(descString, "Create Personalised Route Lists")

  override def act(map: RouteMap): Unit = {
    val rList = RouteMapToRouteList.map(map)
    println(AppStrings.creatingRouteList)
    UserPrompt.loading()
    val listName = UserInput.userInputWithPrompt("Enter Route List Name")
    Menu.userLists.addOne(collectRoutes(new UserRouteList(listName), rList))
  }

  private def collectRoutes(userList: UserRouteList, rList:List[Route]): UserRouteList = {
    var stopping = false
    while (!stopping) {
      val cont = UserInput.userInputWithPrompt(userList.toString + "\nPress Enter to add a Route and Comment, Press 'Q' to finish")
      if (!cont.equals("q")) {
        val route = ListAndSelectRouteUtil.run(rList)
        val comment = UserInput.userInputWithPrompt(AppStrings.routeComment)
        userList.addRoute(route.name_, comment)
      } else {
        stopping = true
      }
    }
    userList
  }

}
