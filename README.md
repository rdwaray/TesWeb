# Tugas Pengujian Otomatis Web dengan Gradle, Cucumber, Selenium, dan Junit
## Tujuan Tugas
Tugas ini bertujuan untuk menyediakan kerangka kerja pengujian otomatis untuk aplikasi web menggunakan Gradle sebagai sistem build, Cucumber untuk mendefinisikan skenario pengujian dengan sintaks Gherkin, Selenium untuk berinteraksi dengan antarmuka pengguna web, dan JUnit untuk eksekusi dan laporan pengujian.  
Page object model akan digunakan untuk menjaga agar kode pengujian tetap terstruktur.
## Penyiapan dan konfigurasi
- Website test yang digunakan https://www.demoblaze.com
- Konfigurasi gradle
- Membuat TestRunner dan membuat laporan nya di "html:reports/test-report.html"
- Struktur proyek
  "src/test/java/stepDefs" - Untuk kode pengujian isinya kelas Page Object Model dan definisi langkah cucumber
  "src/test/resources/" - Untuk skenario cucumber format gherkin
  "reports" - Untuk hasil report pengetesan
## Fitur yang di test
- Login = Test positif login dan negatif gagal login
- Register = Test positif registrasi dan negatif gagal registrasi
- cart = Test positif menambah item ke cart dan menghapus item di cart
- boundary = Test boundary register ketika mencoba registrasi sementara data usernya sudah ada
## Menjalankan pengujian
- ./gradlew test
- Menjalankan TestRunner
## Hasil test
- Test Gradlew
  ![Screenshot of Testgradlew](https://github.com/rdwaray/TesWeb/raw/master/screenshoot/1%20Testgradlew.png)
- Test Runner
  ![Screenshot of Testrunner](https://github.com/rdwaray/TesWeb/blob/master/screenshoot/2%20Testrunner.png)
- Hasil report HTML
  ![Screenshot of Testrunner](https://github.com/rdwaray/TesWeb/blob/master/screenshoot/3%20hasil%20report%20html.png)

## Hal yang perlu diperbaiki
- Membuat kelas baseTest untuk mengelola setup dan teardown (untuk @before dan @after)
- Karena @before dan @after saya di deklarasikan di setiap stepdeps maka jika pengetesan dimulai akan membuka beberapa browser
![Screenshot of masalah](https://github.com/rdwaray/TesWeb/blob/master/screenshoot/4%20Masalah.png)
