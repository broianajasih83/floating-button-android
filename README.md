# 📱 Floating Home Button (AssistiveTouch Android)

Aplikasi Android murni berbasis **Kotlin** untuk menggantikan tombol fisik Home/Back/Recent yang rusak. 
- **100% Tanpa Iklan**
- **Ringan & Bersih** (tidak ada pelacak/analytics)
- **Tanpa Izin Berlebih** (hanya butuh *Overlay* dan *Accessibility Service* untuk fungsi navigasi).

---

## 🛠️ Cara Build APK Sendiri (Gratis & Cepat)
Jika Anda ingin mengubahnya menjadi file APK siap install:
1. Buka folder proyek ini di **Android Studio**.
2. Klik **Build** -> **Build Bundle(s) / APK(s)** -> **Build APK(s)**.
3. Ambil file APK di `app/build/outputs/apk/debug/app-debug.apk`.

Atau jika ingin dicompile via Command Line (jika sudah install Gradle):
```bash
cd floating-home
./gradlew assembleDebug
```
File APK akan berada di `app/build/outputs/apk/debug/app-debug.apk`.

---

## ⚙️ Cara Menggunakan di HP:
1. Install dan buka aplikasi **Floating Home**.
2. Klik tombol **1. Izinkan Tampil di Atas Aplikasi Lain** (Beri izin *Display over other apps*).
3. Klik tombol **2. Aktifkan Layanan Aksesibilitas** (Cari **Floating Home** di menu Aksesibilitas HP Anda, lalu Aktifkan).
4. Klik tombol **3. Mulai Floating Button**.
5. Tombol melayang (ikon kompas) akan muncul di layar. Ketuk tombol tersebut untuk membuka menu:
   - 🏠 **HOME**: Kembali ke layar utama.
   - 🔙 **BACK**: Tombol kembali.
   - 🔲 **RECENT**: Melihat aplikasi terakhir (Recent Apps).
