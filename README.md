# 🎯 Kotlin Öğrenme Yolculuğum

> Android geliştirme için Kotlin öğrenme sürecimi belgelediğim repo

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9-purple?style=flat&logo=kotlin)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-Studio-green?style=flat&logo=android-studio)](https://developer.android.com/studio)

## 📖 İçindekiler

- [Hakkında](#hakkında)
- [Öğrenilen Konular](#öğrenilen-konular)
- [Kod Örnekleri](#kod-örnekleri)
  

## 🎓 Hakkında

Bu proje, Kotlin programlama dilinin temel ve ileri seviye özelliklerini öğrenmek amacıyla oluşturulmuştur. Her commit yeni bir öğrenme adımını temsil eder.

## ✅ Öğrenilen Konular

### 1. Lambda Fonksiyonları
Fonksiyonları değişkenlere atama ve kısa yazım şekli
```kotlin
val yazdir = {metin: String -> println(metin)}
val carpma: (Int, Int) -> Int = {a, b -> a * b}
```

### 2. High-Order Functions
Koleksiyonlar üzerinde işlem yapan fonksiyonlar

#### Filter
```kotlin
val kucukler = liste.filter { it < 7 }
```

#### Map
```kotlin
val kareler = liste.map { it * it }
```

#### Zincirleme Kullanım
```kotlin
liste.filter { it < 7 }.map { it * it }.forEach { println(it) }
```

### 3. Scope Functions
Nesne kapsamında güvenli işlemler

#### let - Null Safety
```kotlin
deger?.let { println(it) }
val sonuc = deger?.let { it + 1 } ?: 0
```

#### also - Yan İşlemler
```kotlin
liste.filter { it.yas > 30 }.also { 
    it.forEach { println(it.enstruman) } 
}
```

### 4. Data Class
```kotlin
data class Sanatci(
    val isim: String, 
    val yas: Int, 
    val enstruman: String
)
```

## 💻 Kod Örnekleri

### Gerçek Hayat Örneği: Sanatçı Filtreleme
```kotlin
val sanatcilar = listOf(
    Sanatci("Atıl", 35, "Gitar"),
    Sanatci("Beyza", 23, "Keman"),
    Sanatci("Gökhan", 40, "Klarnet")
)

// 30 yaşından büyük sanatçıların enstrümanları
val enstrumanlar = sanatcilar
    .filter { it.yas > 30 }
    .map { it.enstruman }
// Sonuç: [Gitar, Klarnet]

// 25 yaşından küçük olanların isimleri
val gencler = sanatcilar
    .filter { it.yas < 25 }
    .map { it.isim }
// Sonuç: [Beyza]
```


## 📚 Kaynaklar

- [Kotlin Dokümantasyonu](https://kotlinlang.org/docs/home.html)
- [Android Developers](https://developer.android.com/kotlin)
- [Kotlin Koans](https://play.kotlinlang.org/koans)




**Son Güncelleme:** Aralık 2024
