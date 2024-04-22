package com.example.ktorwebsocketsample

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.WebSockets

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun getHttpClient(): HttpClient {
    return HttpClient() {
        install(WebSockets)
    }
}
