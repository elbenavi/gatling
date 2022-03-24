package com.tevolvers.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetTodoList {

  val scenarioDefinition =
    scenario("todolist")
      .exec(
        http("Get todolist front")
          .get("http://todolist.tevolvers.com")
          .asJson
          .check(
            status is 200,
            bodyString.saveAs("body")
          )
      )
      .exec(session=>{
        scala.tools.nsc.io.File("target/gatling/todolistbody.csv").appendAll(session("body").as[String] + "\n")
        session
      })
}
