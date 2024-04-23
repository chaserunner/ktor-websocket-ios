import SwiftUI
import shared

struct ContentView: View {
	let client = TestClient()

	var body: some View {
        VStack {
            Button("send echo request") {
                client.sendEchoRequest { _ in  }
            }

            Button("send giant response request") {
                client.sendGiantRequest { _ in  }
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
