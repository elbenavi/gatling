package com.tevolvers.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetUsages {

  val scenarioDefinition =
    scenario("Get usages")
      .exec(
        http("Get usages")
          .get("https://back.enerbit.qa/usages/usages/8c27f2ae-53b3-11ed-a7bd-c6e1db968f5d?since=2022-05-01T00%3A00%3A00.000-05%3A00&until=2022-10-24T10%3A56%3A29.349-05%3A00&period_number=1&period_str=month_start&page=1&size=50")
          .header("authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMzQzMzk5MC0wNmFlLTExZWQtYjg1Yi1hMjU2NWExZjQ0MmQiLCJuYW1lIjoicHJ1ZWJhc3FhZWI0ODhAZ21haWwuY29tIiwic2NvcGVzIjpbXSwiZXhwIjoxNjY2OTg5NDUxfQ.l3zFr9h3WMIqdglcwO2ABgEACjFTek0q5-tPLDrKjdI")
          .asJson
          .check(
            status is 200
          )
      )
}
