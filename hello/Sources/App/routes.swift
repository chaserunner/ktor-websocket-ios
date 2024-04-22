import Vapor

func routes(_ app: Application) throws {
    app.get { req async in
        "It works!"
    }

    app.get("hello") { req async -> String in
        "Hello, world!"
    }

    app.webSocket("echo") { req, ws in
        // Connected WebSocket.
        print(ws)
        ws.onText { ws, text in
            ws.send(text)
        }
    }

    app.webSocket("giant") { req, ws in
        // Connected WebSocket.
        print(ws)
        ws.onText { ws, text in
            ws.send(giant_board)
        }
    }
}

