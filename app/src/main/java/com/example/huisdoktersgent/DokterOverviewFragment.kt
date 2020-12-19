package com.example.huisdoktersgent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.huisdoktersgent.adapters.DokterAdapter
import com.example.huisdoktersgent.adapters.DokterClickListener
import com.example.huisdoktersgent.data.local.DokterAndFields
import com.example.huisdoktersgent.databinding.FragmentDokterOverviewBinding
import com.example.huisdoktersgent.models.Record
import com.example.huisdoktersgent.repos.RepositoryUtils
import com.example.huisdoktersgent.utils.Status
import com.example.huisdoktersgent.viewmodels.DokterOverviewViewModel
import com.example.huisdoktersgent.viewmodels.DokterOverviewViewModelFactory

class DokterOverviewFragment:Fragment(), DokterClickListener {

    private val loadingDialogFragment by lazy { LoadingFragment() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDokterOverviewBinding.inflate(inflater, container, false)
        val factory = DokterOverviewViewModelFactory(RepositoryUtils.createDokterRepository(requireContext()))
        val viewModel = ViewModelProvider(this, factory).get(DokterOverviewViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = DokterAdapter(this)
        binding.adapter = adapter

        viewModel.dokters.observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCES -> {
                        showProgress(false)
                        adapter.submitList(resource.data)
                    }
                    Status.LOADING -> {
                        showProgress(true)
                    }
                    Status.ERROR -> {
                        showProgress(false)
                    }
                }
            }
        })

        return binding.root
    }

    private fun showProgress(b: Boolean) {
        if (b) {
            if (!loadingDialogFragment.isAdded) {
                loadingDialogFragment.show(requireActivity().supportFragmentManager, "loader")
            }
        } else {
            if (loadingDialogFragment.isAdded) {
                loadingDialogFragment.dismissAllowingStateLoss()
            }
        }
    }

    override fun onDokterClicked(dokter: DokterAndFields) {
        val directions = DokterOverviewFragmentDirections.actionDokterOverviewFragmentToDokterDetailFragment(dokter.dokter.recordid)
        findNavController().navigate(directions)
    }
}