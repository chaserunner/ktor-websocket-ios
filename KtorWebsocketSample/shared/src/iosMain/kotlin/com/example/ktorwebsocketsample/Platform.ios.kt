package com.example.ktorwebsocketsample

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.websocket.WebSockets
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun getHttpClient(): HttpClient {
    return HttpClient(Darwin) {
        install(WebSockets) {
            maxFrameSize = 2_000_000_000
        }
    }
}
