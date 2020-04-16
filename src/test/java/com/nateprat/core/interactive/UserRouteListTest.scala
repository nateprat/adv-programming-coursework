package com.nateprat.core.interactive

import com.nateprat.model.{Route, Stage}
import org.scalatest.funsuite.AnyFunSuite

class UserRouteListTest extends AnyFunSuite {

  private var underTest = new UserRouteList("")

  test("addRouteTest") {
    underTest = new UserRouteList("")
    val route ="Route"
    val comment = "Empty Stages"
    underTest.addRoute(route, comment)
    assert(1 == underTest.getRouteCommentMap().size)
    assert(comment.equals(underTest.getCommentForRoute("Route")))
  }

  test("addRouteNoCommentTest") {
    underTest = new UserRouteList("")
    val route = "Route"
    underTest.addRoute(route)
    assert(1 == underTest.getRouteCommentMap().size)
    assert("".equals(underTest.getCommentForRoute("Route")))
  }

  test("getRouteCommentMapTest") {
    underTest = new UserRouteList("")
    val route1 = "Route"
    val route2 = "Route2"
    underTest.addRoute(route1, "Route1")
    underTest.addRoute(route2, "Route2")
    assert(2 == underTest.getRouteCommentMap().size)
    assert(underTest.getRouteCommentMap().keySet.contains(route1))
    assert(underTest.getRouteCommentMap().keySet.contains(route2))
    assert("Route1".equals(underTest.getRouteCommentMap()(route1)))
    assert("Route2".equals(underTest.getRouteCommentMap()(route2)))
  }

  test("getCommentForRouteTest") {
    underTest = new UserRouteList("")
    val route1 = "Route"
    val route2 = "Route2"
    underTest.addRoute(route1, "Route1")
    underTest.addRoute(route2, "Route2")
    assert(2 == underTest.getRouteCommentMap().size)
    assert("Route1".equals(underTest.getCommentForRoute("Route")))
    assert("Route2".equals(underTest.getCommentForRoute("Route2")))
  }

}
