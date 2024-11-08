package com.example.Routes

import example.com.Repositories.Categories.CategoryModel
import com.example.Repositories.Categories.CategoryRepository
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory
import java.io.File
import java.sql.SQLException

fun Route.categoryRoute(categoryRepository: CategoryRepository) {

    val logger = LoggerFactory.getLogger("CategoryRoute")

    get {
        try {
            val categories = categoryRepository.getCategory()
            call.respond(HttpStatusCode.OK, categories)
        } catch (e: SQLException) {
            logger.error("Database error while retrieving categories", e)
            call.respond(HttpStatusCode.InternalServerError, "Database error occurred")
        } catch (e: Exception) {
            logger.error("Unexpected error while retrieving categories", e)
            call.respond(HttpStatusCode.InternalServerError, "Failed to retrieve categories")
        }
    }


}

