# Tugas Pengujian Otomatis Web dengan Gradle, Cucumber, Selenium, dan Junit
## Tujuan Tugas
Tugas ini bertujuan untuk menyediakan kerangka kerja pengujian otomatis untuk aplikasi web menggunakan Gradle sebagai sistem build, Cucumber untuk mendefinisikan skenario pengujian dengan sintaks Gherkin, Selenium untuk berinteraksi dengan antarmuka pengguna web, dan JUnit untuk eksekusi dan laporan pengujian.  
Page object model akan digunakan untuk menjaga agar kode pengujian tetap terstruktur.
## Penyiapan dan konfigurasi
- Konfigurasi gradle
- Struktur proyek
 "src/test/java/stepDefs" - Untuk kode pengujian isinya kelas Page Object Model dan definisi langkah cucumber
 "src/test/resources/" - Untuk skenario cucumber format gherkin
 "reports" - Untuk hasil report pengetesan
- 
- Membuat TestRunner dan membuat laporan nya di "html:reports/test-report.html"
## Fitur yang di test
- Login = Test positif login dan negatif gagal login
- Register = Test positif registrasi dan negatif gagal registrasi
- cart = Test positif menambah item ke cart dan menghapus item di cart
- boundary = Test boundary register ketika mencoba registrasi sementara data usernya sudah ada
## Menjalankan pengujian
- ./gradlew test
- Menjalankan TestRunner