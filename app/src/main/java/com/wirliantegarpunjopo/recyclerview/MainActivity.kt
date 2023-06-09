package com.wirliantegarpunjopo.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txttempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }


                }.show()

            }

        })
    }

}