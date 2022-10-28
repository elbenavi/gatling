package com.tevolvers.simulation

import com.tevolvers.scenarios.{GetAuth}
import io.gatling.core.Predef._

import scala.concurrent.duration._

class SimulationGetAuthToken extends Simulation {

  val simulation =new GetAuth


  val userConstantPersecond = sys.env.getOrElse("GATLING_NR_USERS_CONSTANT_PERSECOND", "1").toInt
  val durationAddinguserRampMinute= sys.env.getOrElse("GATLING_DURATION_ADDING_USER_RAMP_MINUTE", "1").toInt seconds
  val durationAddinguserConstantMinute = sys.env.getOrElse("GATLING_DURATION_ADDING_USER_CONSTANT_MINUTE", "1").toInt seconds


  setUp(
    simulation.scenarioDefinition
      .inject(
        nothingFor(1 seconds),
        rampUsersPerSec(1) to userConstantPersecond during durationAddinguserRampMinute,
        constantUsersPerSec(userConstantPersecond) during durationAddinguserConstantMinute
      )
  )


}
