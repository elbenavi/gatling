package com.tevolvers.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

class GetPokemonName {

  val pokemonFeeder=csv("data/pokemons2.csv").circular

  val scenarioDefinition =
    scenario("Pokemon api get by name")
      .feed(pokemonFeeder)
      .exec(
        http("Get pokemon by name")
          .get("https://pokeapi.co/api/v2/pokemon/${name}")
          .asJson
          .check(
            status is 200,
            bodyString.saveAs("body")
          )
      )
      .exec(session=>{
        scala.tools.nsc.io.File("target/gatling/pokemonabilities.csv").appendAll(session("body").as[String] + "\n")
        session
      })
}
