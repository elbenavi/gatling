package com.tevolvers.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetAuth {

  val scenarioDefinition =
    scenario("Post Auth")
      .exec(
        http("Post Auth Token")
          .post("https://back.enerbit.qa/auth/token/")
          .formParam("username","pruebasqaeb488@gmail.com")
          .formParam("password", "algoocurrio7")
          .asJson
          .check(
            status is 200
          )
      )
}
