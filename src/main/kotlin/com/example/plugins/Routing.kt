package com.example.plugins

import com.example.Repositories.Categories.CategoryRepository
import com.example.Routes.categoryRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*


fun Application.configureRouting(
    categoryRepository: CategoryRepository,

    ) {

    routing {

        categoryRoute(categoryRepository)

    }

}

