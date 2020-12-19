package com.example.huisdoktersgent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.huisdoktersgent.databinding.FragmentDokterDetailBinding
import com.example.huisdoktersgent.repos.RepositoryUtils
import com.example.huisdoktersgent.viewmodels.DokterDetailViewModel
import com.example.huisdoktersgent.viewmodels.DokterDetailViewmodelFactory

class DokterDetailFragment: Fragment() {

    val arguments: DokterDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDokterDetailBinding.inflate(inflater, container, false)
        val factory = DokterDetailViewmodelFactory(RepositoryUtils.createDokterRepository(requireContext()))
        val viewModel = ViewModelProvider(this, factory).get(DokterDetailViewModel::class.java)

        viewModel.updateDokter(arguments.dokterId)

        viewModel.dokter.observe(viewLifecycleOwner, Observer {
            binding.dokter = it
        })

        return  binding.root
    }
}