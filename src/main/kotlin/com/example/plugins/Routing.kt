package com.example.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import kotlinx.serialization.Serializable
import java.io.File

fun Application.configureRouting() {
    routing {
        get("/") {
            //call.respondText("STATUS CODE", status = HttpStatusCode.BadGateway)
            call.respond(User(email = "gale.ramsey@example.com", password = "quot"))
        }

        get("/filedownload") {
          val file=File("files/monkey.jpeg")
          call.response.header(
              HttpHeaders.ContentDisposition,
              ContentDisposition.Inline.withParameter(
                  ContentDisposition.Parameters.FileName,
                  "file1.jpeg"
              ).toString()
          )

          call.respondFile(file)
        }
        get("/filedownloadzip") {
            val file=File("files/ktor base.zip")
            call.response.header(
                HttpHeaders.ContentDisposition,
                ContentDisposition.Attachment.withParameter(
                    ContentDisposition.Parameters.FileName,
                    "filezip1.zip"
                ).toString()
            )

            call.respondFile(file)
        }
    }
}

@Serializable
class User constructor(
    val email:String,
    val password:String
)
