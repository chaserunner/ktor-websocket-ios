# ktor-websocket-ios
Demonstrates issue with darwin engine when frame size is too large.

# How to run?

1. Start server by running
 ```zsh
 swift run --package-path=hello
 ```

2. Open app project  by running
```
open KtorWebsocketSample/iosApp/iosApp.xcodeproj
```

3. Run on iOS simulator.


# Problem statement

Setting `maxFrameSize` should apply the value to [maximumMessageSize](https://developer.apple.com/documentation/foundation/urlsessionwebsockettask/3181203-maximummessagesize). Setting `maximumMessageSize` solves the problem when is called from native code. Kotlin counterpart doesn't have effect on the expected message size for some reason.

### Error example

<img src="error.png">