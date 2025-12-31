package com.beyzaatilgan.ortaileriseviyekotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        println("-----Lambda-----")
        // fonksiyonların yazımının kısa hali.
        val yazdigimiYazdirLambda = {verilenString: String -> println(verilenString)}
        yazdigimiYazdirLambda("yazdir test")

        val carpmaIslemiLambda = {a: Int, b: Int -> a*b}
        val sonuc = carpmaIslemiLambda(3,4)
        println(sonuc)

        val carpmaIslemiLambdaIki : (Int,Int) -> Int = {a,b -> a*b}
        println(carpmaIslemiLambdaIki(5,7))

        println("----High Order Functions-----")
        //filter
         val benimListem = arrayListOf(1,2,3,4,5,6,7,8,9)
         val kucukSayilarListesi  = benimListem.filter { num -> num<7 } // val kucukSayilarListesiIki = benimListem.filter{it<7}

         for (numara in kucukSayilarListesi){
             println(numara)
         }

        //map: bir şeyi başka bir forma dönüştürmek için kullanılır. kare alma vs. normal for döngüsüne göre daha hızlı.
        val karesiAlinmisSayilar = benimListem.map { it * it }
        for(numara in karesiAlinmisSayilar){
            println(numara)
        }

        //map ve filter birarada
        val mapFilterBirarada = benimListem.filter { it < 7 }.map { it * it }
        mapFilterBirarada.forEach { println(it) }


        val sanatci1 = Sanatci("Atıl",35,"Gitar")
        val sanatci2 = Sanatci("Beyza",23,"Keman")
        val sanatci3 = Sanatci("Gökhan",40,"Klarnet")
        val sanatcilar = arrayListOf<Sanatci>(sanatci1,sanatci2,sanatci3)
        val otuzdanBüyükSanatcilarinEnstrumanlari = sanatcilar.filter { it.yas > 30 }.map { it.enstruman }
        otuzdanBüyükSanatcilarinEnstrumanlari.forEach { println(it) }
        val yirmibesYasindanKucukOlanlarinIsimleri = sanatcilar.filter { it.yas < 25 }.map { it.isim }
        yirmibesYasindanKucukOlanlarinIsimleri.forEach { println(it) }

        //scope fonksiyonları
        println("------scope fonksiyonları-----")

        val benimInteger : Int? = null
        benimInteger?.let {
            println(it)
        }// let fonksiyonu benimInteger değerinin sadece null olmadığı durumda çalışır.

        val yeniInteger = benimInteger?.let { it + 1 }?: 0
        println(yeniInteger)// benimInteger değer null değilse bir ekler yeniInteger olur, null ise yeniInteger değer 0 olur.

        //also: bunu yap sonra bunu da yap gibi
        println("----also----")
        sanatcilar.filter { it.yas > 30 }.also { it.forEach{ println(it.enstruman) } }

    }
}