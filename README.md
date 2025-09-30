# Praktikum BAB 3 - State Management dalam Jetpack Compose

## Deskripsi Aplikasi
Aplikasi ini mendemonstrasikan implementasi state management dalam Jetpack Compose melalui tiga komponen interaktif:
1. **Counter App** - Aplikasi penghitung dengan tombol plus dan minus
2. **Color Toggle App** - Aplikasi toggle warna merah/hijau
3. **Interactive Profile App** - Aplikasi profil dengan fitur follow/unfollow

## Implementasi State di Aplikasi

### 1. Counter App State
```kotlin
var count by remember { mutableStateOf(0) }
```
- Menggunakan `remember { mutableStateOf(0) }` untuk menyimpan nilai counter
- State diperbaharui dengan `count++` dan `count--`
- Implementasi validasi untuk mencegah nilai negatif: `if (count > 0) count--`
- UI secara otomatis ter-recompose ketika nilai `count` berubah

### 2. Color Toggle State
```kotlin
var isRed by remember { mutableStateOf(true) }
```
- Boolean state untuk menentukan warna (true = merah, false = hijau)
- Toggle dilakukan dengan `isRed = !isRed` pada click listener
- Warna Box dan teks berubah secara reaktif berdasarkan state

### 3. Profile Follow State
```kotlin
var isFollowed by remember { mutableStateOf(false) }
```
- Boolean state untuk status follow/unfollow
- Mempengaruhi:
  - Teks tombol ("Follow" atau "Unfollow")
  - Warna tombol
  - Pesan status
  - Jumlah followers (100 atau 101)

## Konsep State Management yang Diimplementasikan

### Remember dan MutableState
- `remember` memastikan state bertahan selama recomposition
- `mutableStateOf` membuat state yang dapat diubah dan memicu recomposition
- Delegation property `by` menyederhanakan akses ke value

### Reactive UI
- Setiap perubahan state otomatis memicu recomposition
- UI selalu sinkron dengan state terkini
- Tidak perlu manual update view seperti pada XML tradisional

### State Hoisting
- State didefinisikan di level composable yang tepat
- Setiap komponen mengelola state-nya sendiri
- State tidak di-share antar komponen untuk mempertahankan enkapsulasi

## Analisis: Jetpack Compose vs XML Tradisional

### Keunggulan Jetpack Compose untuk Kasus Ini:

#### 1. **Declarative Programming**
- **Compose**: UI dideklarasikan sebagai fungsi dari state
  ```kotlin
  Text(text = count.toString()) // Otomatis update ketika count berubah
  ```
- **XML**: Memerlukan manual update melalui findViewById dan setText
  ```kotlin
  textView.text = count.toString() // Harus dipanggil setiap kali update
  ```

#### 2. **State Management yang Sederhana**
- **Compose**: State terintegrasi langsung dengan UI
  ```kotlin
  var count by remember { mutableStateOf(0) }
  Button(onClick = { count++ }) // Langsung update UI
  ```
- **XML**: Memerlukan manual binding dan update
  ```kotlin
  private var count = 0
  button.setOnClickListener { 
      count++
      updateUI() // Harus manual call update
  }
  ```

#### 3. **Reactive Updates**
- **Compose**: Automatic recomposition - UI update otomatis ketika state berubah
- **XML**: Manual updates - developer harus eksplisit update setiap view

#### 4. **Less Boilerplate Code**
- **Compose**: 
  - Tidak perlu findViewById
  - Tidak perlu manual listener setup
  - State dan UI logic dalam satu tempat
- **XML**: 
  - Memerlukan binding views
  - Setup listeners terpisah
  - Logic tersebar di multiple files

#### 5. **Type Safety**
- **Compose**: Compile-time checking untuk UI components
- **XML**: Runtime errors untuk referensi view yang salah

#### 6. **Easier State Synchronization**
- **Compose**: State otomatis tersinkronisasi dengan UI
- **XML**: Mudah terjadi inconsistency antara state dan UI

### Contoh Perbandingan Konkret:

**Toggle Warna di Compose:**
```kotlin
var isRed by remember { mutableStateOf(true) }
Box(
    modifier = Modifier
        .background(if (isRed) Color.Red else Color.Green)
        .clickable { isRed = !isRed }
)
```

**Toggle Warna di XML Tradisional:**
```kotlin
// XML Layout
<View android:id="@+id/colorBox" />

// Activity/Fragment
private var isRed = true
private lateinit var colorBox: View

override fun onCreate() {
    colorBox = findViewById(R.id.colorBox)
    updateColor()
    colorBox.setOnClickListener {
        isRed = !isRed
        updateColor()
    }
}

private fun updateColor() {
    colorBox.setBackgroundColor(
        if (isRed) Color.RED else Color.GREEN
    )
}
```
