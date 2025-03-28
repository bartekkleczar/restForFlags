package org.example

import org.jetbrains.exposed.sql.Database
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {

    Database.connect(
        "jdbc:sqlite:src\\main\\resources\\countriesdb.db",
        driver = "org.sqlite.JDBC"
    )

    transaction {
        SchemaUtils.create(CountriesTable)
    }

    embeddedServer(Netty, port = 8080) {
        install(StatusPages) {
            exception<Throwable> { call, cause ->
                call.respond(HttpStatusCode.InternalServerError, mapOf("error" to (cause.message ?: "Unknown error")))
            }
        }

        install(ContentNegotiation) {
            json()
        }

        routing {
            route("/"){
                get {
                    call.respond("Endpoint / works!")
                }
            }
            route("/countries") {
                get {
                    call.respond("Endpoint /countries works!")
                }
                get("/filter") {
                    val params = call.request.queryParameters
                    val countriesRepository = CountriesRepository()

                    val countries = countriesRepository.findCountriesByFilters(
                        red = params["red"]?.toIntOrNull() ?: 0,
                        green = params["green"]?.toIntOrNull() ?: 0,
                        blue = params["blue"]?.toIntOrNull() ?: 0,
                        yellow = params["yellow"]?.toIntOrNull() ?: 0,
                        orange = params["orange"]?.toIntOrNull() ?: 0,
                        white = params["white"]?.toIntOrNull() ?: 0,
                        black = params["black"]?.toIntOrNull() ?: 0,
                        horizontal = params["horizontal"]?.toIntOrNull() ?: 0,
                        vertical = params["vertical"]?.toIntOrNull() ?: 0,
                        diagonal = params["diagonal"]?.toIntOrNull() ?: 0,
                        centered = params["centered"]?.toIntOrNull() ?: 0,
                        triangleHorizontal = params["triangleHorizontal"]?.toIntOrNull() ?: 0,
                        other = params["other"]?.toIntOrNull() ?: 0,
                        circleSign = params["circle_sign"]?.toIntOrNull() ?: 0,
                        crescentSign = params["crescent_sign"]?.toIntOrNull() ?: 0,
                        crossSign = params["cross_sign"]?.toIntOrNull() ?: 0,
                        starSign = params["star_sign"]?.toIntOrNull() ?: 0,
                        sunSign = params["sun_sign"]?.toIntOrNull() ?: 0,
                        otherSign = params["other_sign"]?.toIntOrNull() ?: 0,
                        noSigns = params["no_signs"]?.toIntOrNull() ?: 0
                    )

                    call.respond(countries)
                }
                //println("Route /countries registered")
                /*get("/by-flag-colors") {
                    //println("Route /countries/by-flag-colors registered")
                    val red = call.request.queryParameters["red"]?.toIntOrNull() ?: 0
                    val green = call.request.queryParameters["green"]?.toIntOrNull() ?: 0
                    val blue = call.request.queryParameters["blue"]?.toIntOrNull() ?: 0
                    val yellow = call.request.queryParameters["yellow"]?.toIntOrNull() ?: 0
                    val orange = call.request.queryParameters["orange"]?.toIntOrNull() ?: 0
                    val white = call.request.queryParameters["white"]?.toIntOrNull() ?: 0
                    val black = call.request.queryParameters["black"]?.toIntOrNull() ?: 0

                    val countriesRepository = CountriesRepository()

                    val countries = countriesRepository.findCountriesByFlagColors(
                        red, green, blue, yellow, orange, white, black
                    )

                    println(countries)
                    call.respond(countries)
                }

                get("/by-flag-layout") {
                    val horizontal = call.request.queryParameters["horizontal"]?.toIntOrNull() ?: 0
                    val vertical = call.request.queryParameters["vertical"]?.toIntOrNull() ?: 0
                    val diagonal = call.request.queryParameters["diagonal"]?.toIntOrNull() ?: 0
                    val centered = call.request.queryParameters["centered"]?.toIntOrNull() ?: 0
                    val triangleHorizontal = call.request.queryParameters["triangleHorizontal"]?.toIntOrNull() ?: 0
                    val other = call.request.queryParameters["other"]?.toIntOrNull() ?: 0

                    val countriesRepository = CountriesRepository()
                    val countries = countriesRepository.findCountriesByFlagLayout(
                        horizontal, vertical, diagonal, centered, triangleHorizontal, other
                    )
                    println(countries)
                    call.respond(countries)
                }

                get("/by-flag-symbols") {
                    val circleSign = call.request.queryParameters["circle_sign"]?.toIntOrNull() ?: 0
                    val crescentSign = call.request.queryParameters["crescent_sign"]?.toIntOrNull() ?: 0
                    val crossSign = call.request.queryParameters["cross_sign"]?.toIntOrNull() ?: 0
                    val starSign = call.request.queryParameters["star_sign"]?.toIntOrNull() ?: 0
                    val sunSign = call.request.queryParameters["sun_sign"]?.toIntOrNull() ?: 0
                    val otherSign = call.request.queryParameters["other_sign"]?.toIntOrNull() ?: 0
                    val noSigns = call.request.queryParameters["no_signs"]?.toIntOrNull() ?: 0

                    val countriesRepository = CountriesRepository()
                    val countries = countriesRepository.findCountriesByFlagSymbols(
                        circleSign, crescentSign, crossSign, starSign, sunSign, otherSign, noSigns
                    )
                    println(countries)
                    call.respond(countries)
                }*/
            }
        }
    }.start(wait = true)
}
