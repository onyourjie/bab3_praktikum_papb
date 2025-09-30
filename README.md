# Praktikum Bab 3 - Jetpack Compose State Management

## Deskripsi Singkat
Aplikasi ini dibuat menggunakan **Jetpack Compose** dan menampilkan tiga fitur utama yang mengimplementasikan **state**:

1. **CounterAppSection**  
   - Menggunakan state `count` untuk menyimpan nilai counter.  
   - Tombol `+` menambah nilai counter, tombol `−` mengurangi nilai counter (tidak bisa kurang dari 0).  
   - State akan otomatis memperbarui tampilan setiap kali berubah.

2. **ColorToggleAppSection**  
   - Menggunakan state `isRed` untuk menyimpan kondisi warna.  
   - Saat kotak diklik, nilai state `isRed` akan berubah (`true`/`false`) sehingga warna berganti antara **Merah** dan **Hijau**.  

3. **InteractiveProfileAppSection**  
   - Menggunakan state `isFollowed` untuk menyimpan status mengikuti akun.  
   - Saat tombol `Follow/Unfollow` ditekan, state berubah dan langsung memengaruhi teks tombol, warna, serta keterangan status profil.  
   - Selain itu, jumlah followers juga ikut berubah dinamis berdasarkan nilai state.  

---

## Analisis Singkat
Mengapa **UI dengan Compose lebih sederhana dibandingkan XML tradisional** untuk kasus ini?

1. **Deklaratif, bukan Imperatif**  
   - Di Compose, kita cukup mendeklarasikan “bagaimana UI seharusnya terlihat berdasarkan state saat ini.”  
   - Tidak perlu menulis `findViewById`, `setText`, atau memanggil `notifyDataSetChanged`. UI otomatis mengikuti perubahan state.

2. **State Terintegrasi dengan UI**  
   - Dengan `remember { mutableStateOf(...) }`, data langsung terhubung ke tampilan.  
   - Pada XML tradisional, perubahan data biasanya harus dihubungkan dengan ViewModel/LiveData lalu di-update secara manual.

3. **Kode Lebih Ringkas dan Mudah Dibaca**  
   - Semua UI dan logika bisa ditulis dalam satu file Kotlin.  
   - XML butuh file terpisah untuk layout + file Kotlin/Java untuk logika, sehingga lebih verbose.  

4. **Preview Real-Time**  
   - Compose memungkinkan preview langsung dari setiap komponen UI tanpa harus menjalankan aplikasi penuh, sehingga proses desain lebih cepat.  

---
