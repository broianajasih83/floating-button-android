# 🚀 Cara Otomatis Bikin APK Gratis Lewat GitHub Actions

Karena komputer Anda tidak memiliki Android Studio, kita bisa menggunakan **GitHub** untuk merakit (compile) file APK-nya secara otomatis di server cloud mereka secara **gratis dan tanpa install apa-apa**.

---

### 📋 Langkah-langkah

1. **Buat Akun / Login ke GitHub**: Buka [github.com](https://github.com/) dan buat akun jika belum punya.
2. **Buat Repository Baru**:
   - Klik tombol **`+`** di pojok kanan atas, lalu pilih **New repository**.
   - Beri nama repository (misal: `floating-home`).
   - Pilih **Public**.
   - Klik **Create repository**.
3. **Upload Folder Project**:
   - Masuk ke repository yang baru dibuat.
   - Klik tulisan **"uploading an existing file"**.
   - Tarik dan upload seluruh isi folder **`floating-home`** (pastikan file `.github`, `app`, `build.gradle.kts`, dll ikut terupload).
   - Klik **Commit changes**.
4. **Tunggu Proses Build Otomatis**:
   - Setelah di-upload, klik tab **Actions** di bagian atas repository GitHub Anda.
   - Anda akan melihat proses workflow dengan nama *"Build Android APK"* sedang berjalan.
   - Tunggu sekitar 2 - 3 menit sampai ikonnya berubah menjadi **hijau (centang)**.
5. **Download APK**:
   - Klik pada proses build yang sudah hijau tersebut.
   - Scroll ke bagian bawah halaman (bagian **Artifacts**).
   - Klik **`floating-home-debug-apk`** untuk mendownload file `.zip` berisi file APK (`app-debug.apk`).
   - Ekstrak file zip tersebut, lalu pindahkan file APK ke HP Itel Anda.

---

## ⚙️ Cara Pakai di HP Itel
1. Install file `app-debug.apk` yang sudah di-download.
2. Buka aplikasi **Floating Home**.
3. Ketuk tombol **Izinkan Tampil di Atas Aplikasi Lain** (Beri izin *Overlay*).
4. Ketuk tombol **Aktifkan Layanan Aksesibilitas** (Cari aplikasi *Floating Home*, lalu aktifkan).
5. Ketuk **Mulai Floating Button**.
6. Selesai! Tombol Home melayang bebas iklan kini aktif di layar HP Anda.
