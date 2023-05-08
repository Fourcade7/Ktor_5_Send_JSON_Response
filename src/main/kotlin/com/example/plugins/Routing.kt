package com.example.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    routing {
        get("/") {
            //call.respondText("STATUS CODE", status = HttpStatusCode.BadGateway)
            call.respond(User(email = "gale.ramsey@example.com", password = "quot"))
        }
    }
}

@Serializable
class User constructor(
    val email:String,
    val password:String
)
