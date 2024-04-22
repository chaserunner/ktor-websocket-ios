import SwiftUI
import shared

struct ContentView: View {
	let client = TestClient()

	var body: some View {
        Button("send request") {
            client.sendRequest { _ in
                print("completed")
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
