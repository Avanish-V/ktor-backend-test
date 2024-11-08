package com.example

import com.example.Repositories.Categories.ServiceCategoryImpl
import com.example.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    val database = MongoClientConnection.connectDB()

    val serviceCategoryImpl = ServiceCategoryImpl(database)

    configureRouting(
        categoryRepository =  serviceCategoryImpl,

    )
}
