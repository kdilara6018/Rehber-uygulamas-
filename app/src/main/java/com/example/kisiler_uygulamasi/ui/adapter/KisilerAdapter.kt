package com.example.kisiler_uygulamasi.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisiler_uygulamasi.data.entity.Kisiler
import com.example.kisiler_uygulamasi.databinding.CardTasarimBinding
import com.example.kisiler_uygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var kisilerListesi: List<Kisiler>) : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim

        t.textViewKisiAd.text = kisi.kisi_ad
        t.textViewKisiTel.text = kisi.kisi_tel

        t.cardViewKisi.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener {
            // Silme işlemi burada yapılacak
            Snackbar.make(it,"${kisi} silinsin mi", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){

                }.show()
        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }
    fun sil(kisi_id:Int){
        Log.e("Kisi sil ",kisi_id.toString())
    }

    //override fun onResume(){
      //  super.onResume()
        //Log.e("kisi anasayfaya","dönüldü")
    //}
   
}