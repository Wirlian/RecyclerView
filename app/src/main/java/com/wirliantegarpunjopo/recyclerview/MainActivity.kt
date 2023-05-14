package com.wirliantegarpunjopo.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wirliantegarpunjopo.recyclerview.adapter.AdapterTeamBola
import com.wirliantegarpunjopo.recyclerview.databinding.ActivityMainBinding
import com.wirliantegarpunjopo.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain(nama = "Thibaut Courtois",R.drawable.courtois, posisi = "Penjaga Gawang", tinggi = "2.00 m", tempatlahir = "Bree (Belgia)", tgllahir = "11 Mei 1992"))
        listPemain.add(Pemain(nama = "Karim Benzema",R.drawable.benzema, posisi = "Penyerang", tinggi = "1.85 m", tempatlahir = "Lyon (Perancis)", tgllahir = "19 Desember 1987"))
        listPemain.add(Pemain(nama = "Marcelo Vieira da Silva",R.drawable.marcello, posisi = "Belakang", tinggi = "1,74 m", tempatlahir = "Rio de Janeiro (Brasil)", tgllahir = "12 Mei 1988"))
        listPemain.add(Pemain(nama = "Sergio Ramos García",R.drawable.ramos, posisi = "Belakang", tinggi = "1,84 m", tempatlahir = "Camas (Sevilla)", tgllahir = "30 Maret 1986"))
        listPemain.add(Pemain(nama = "Zinedine Yazid Zidane",R.drawable.zidan, posisi = "Pelatih", tinggi = "1,85 m", tempatlahir = "Marseille (Prancis)", tgllahir = "23 Juni 1972"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                TODO("Not yet implemented")
            }

        })
    }

}