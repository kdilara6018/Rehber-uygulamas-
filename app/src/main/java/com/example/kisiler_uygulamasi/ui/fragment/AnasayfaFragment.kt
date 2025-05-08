package com.example.kisiler_uygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisiler_uygulamasi.R
import com.example.kisiler_uygulamasi.data.entity.Kisiler
import com.example.kisiler_uygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisiler_uygulamasi.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var adapter: KisilerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())
        
        // Örnek veri
        val kisilerListesi = listOf(
            Kisiler(1, "Dilara", "1111"),
            Kisiler(2, "Ahmet", "2222"),
            Kisiler(3, "Mehmet", "3333")
        )
        
        adapter = KisilerAdapter(kisilerListesi)
        binding.kisilerRv.adapter = adapter
        
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    ara(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    ara(newText)
                }
                return true
            }
        })

        return binding.root
    }

    private fun ara(aramakelimesi: String) {
        Log.e("kisi ara", aramakelimesi)
    }
}