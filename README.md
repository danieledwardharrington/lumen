# Lumen

Lumen is a daily mental health check-in app for Android. It sits somewhere between a journal and a therapist — a quiet, intentional moment each day to check in with yourself, track your emotional patterns over time, and surface insights that help you understand what's actually going on beneath the surface.

You select how you're feeling, answer two AI-generated follow-up questions tailored to your mood and focus areas, and receive a brief reflection on what you shared. Over time, Lumen surfaces weekly insights — an AI-generated summary of your emotional arc for the week, detected patterns, and a running timeline you can look back on.

A few principles shape every decision in this project. One check-in per day, intentional and uneditable, preserving an honest record. Local-first by default, with optional encrypted cloud backup. No content stored by the AI provider. No account required.

---

## Screenshots

*Screenshots coming soon.*

---

## Tech Stack

- **Language & UI** — Kotlin, Jetpack Compose, Material 3
- **Architecture** — Multi-module MVVM, Hilt, unidirectional data flow
- **Storage** — Room, SQLCipher, Android Keystore
- **AI** — Firebase AI / Google Gemini
- **Backend** — Firebase Authentication, Firestore, Cloud Functions, WorkManager
- **Serialization** — kotlinx-serialization
- **Visualization** — Vico (mood trend chart)
- **Security** — AndroidX Biometric, AndroidX Security Crypto
- **In-App Purchases** — Google Play Billing
- **Export** — iText7 (PDF), JSON (backup/restore)
- **Fonts** — Fraunces, DM Sans
- **Testing** — JUnit, MockK, Room Testing, Compose UI Test

---

## License

MIT License

Copyright (c) 2026 Lumen

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
