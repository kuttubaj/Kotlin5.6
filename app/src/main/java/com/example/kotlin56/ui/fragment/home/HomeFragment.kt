package com.example.kotlin56.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin56.R
import com.example.kotlin56.databinding.FragmentHomeBinding
import com.example.kotlin56.ui.adapters.PhotoAdapter
import com.example.kotlin56.ui.viewModels.ViewModel


class HomeFragment : Fragment() {
    private var _binding:FragmentHomeBinding? = null
    private val binding:FragmentHomeBinding get() = _binding!!
    private val adapter = PhotoAdapter()
    private val  viewModel by activityViewModels<ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        initialize()
        adapter.setPhoto(viewModel.fetchData())
    }

    private fun initialize() {
        binding.rvPhotos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPhotos.adapter = adapter

    }

    private fun setupListeners() {
        binding.arrow.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}