package com.example.ktorwebsocketsample

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.websocket.Frame
import io.ktor.websocket.WebSocketSession
import io.ktor.websocket.readBytes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class TestClient {

    private val client: HttpClient = getHttpClient()
    private var session: WebSocketSession? = null
    private var sessionHandlerJob: Job? = null

    suspend fun sendRequest() {
        session = client.webSocketSession("ws://localhost:8080/giant") {
            header(HttpHeaders.SecWebSocketProtocol, "protobuf")
        }
        session?.maxFrameSize = 1048576 * 2 * 2
        with(CoroutineScope(coroutineContext)) {
            sessionHandlerJob = launch(Dispatchers.IO) {
                session?.incoming?.consumeEach { frame ->
                    session?.incoming?.consumeEach { frame ->
                        if (frame is Frame.Text) {
                            print("message received")
                            print(frame.readBytes().toString())
                        }
                    }
                }
            }
        }
        session?.send(Frame.Text("Hello, world!"))
    }
}
