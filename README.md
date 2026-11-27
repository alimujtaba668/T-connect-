# T-Connect Android starter

This is the first Android Studio starter project for the T-Connect UI.

## Important status
- This project contains a working Compose starter screen only.
- It is **not yet connected to Telegram/TDLib** and is **not an installable APK**.
- The Continue button is deliberately a demo action. Do not enter a real phone number.
- A real TDLib client requires compiling and packaging TDLib's native Android libraries/JNI bindings, implementing its asynchronous authorization states, and configuring your own Telegram API `api_id` and `api_hash`.

## Open the project
1. Install Android Studio on a computer.
2. Choose **Open** and select this `TConnect` folder.
3. Allow Gradle sync to finish.
4. Run on an Android emulator or connected test device.

## TDLib integration roadmap
1. Register your own Telegram application at https://my.telegram.org and keep the `api_hash` private.
2. Build TDLib for Android with its official build instructions and JNI enabled.
3. Add the generated Java bindings and native `.so` libraries for supported Android ABIs to this project.
4. Implement TDLib's authorization state flow: parameters -> phone number -> code (and password/email steps when Telegram requests them).
5. Handle TDLib updates asynchronously and build chats/messages UI.
6. Test with your own account and follow Telegram's API terms and rate limits.

Official docs:
- https://core.telegram.org/tdlib
- https://core.telegram.org/tdlib/getting-started
- https://core.telegram.org/tdlib/Java_Interface
- https://core.telegram.org/api

Never share your Telegram login code, 2-step verification password, `api_hash`, or session/database files with anyone.
