package com.tevolvers.simulation

import com.tevolvers.scenarios.{GetUsages}
import io.gatling.core.Predef._

import scala.concurrent.duration._

class SimulationGetUsages extends Simulation {

  val simulation =new GetUsages


  val userConstantPersecond = sys.env.getOrElse("GATLING_NR_USERS_CONSTANT_PERSECOND", "200").toInt
  val durationAddinguserRampMinute= sys.env.getOrElse("GATLING_DURATION_ADDING_USER_RAMP_MINUTE", "20").toInt seconds
  val durationAddinguserConstantMinute = sys.env.getOrElse("GATLING_DURATION_ADDING_USER_CONSTANT_MINUTE", "5").toInt seconds


  setUp(
    simulation.scenarioDefinition
      .inject(
          nothingFor(5),
          atOnceUsers(5),
          rampUsers(500).during(100)
      )
  )


}
