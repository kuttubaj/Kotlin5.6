package com.example.kotlin56.ui.fragment.insert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.kotlin56.R
import com.example.kotlin56.data.local.room.model.Photo
import com.example.kotlin56.databinding.FragmentSecondBinding
import com.example.kotlin56.ui.viewModels.ViewModel

class SecondFragment : Fragment() {

    private var _biding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _biding!!
    private val viewModel by activityViewModels<ViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _biding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createPhoto()
        updatePhoto()
        editPhoto()
        deletePhoto()
        setupListeners()
    }

    private fun deletePhoto() = with(binding) {
        btnDelete.setOnClickListener {
            val photoId = 19
            val title = editTextTitle.text.toString().trim()
            val body = editTextInput.text.toString().trim()
            val updatedPhoto = com.example.kotlin56.data.local.room.model.Photo(
                userId = 2,
                id = photoId,
                title = title,
                body = body
            )
            viewModel.deletePhoto(
                photoId = photoId,
                photo = updatedPhoto,
                onSuccess = { photo ->
                    viewModel.addData(photo)
                    Toast.makeText(requireActivity(), photo.toString(), Toast.LENGTH_SHORT).show()
                }

            ) { message ->
                Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun editPhoto() = with(binding) {
        btnPatch.setOnClickListener {
            val photoId = 19
            val title = editTextTitle.text.toString().trim()
            val body = editTextInput.text.toString().trim()
            val updatePhoto = Photo(
                userId = 2,
                id = photoId,
                title = title,
                body = body
            )
            viewModel.editPhoto(
                title = title,
                onSuccess = { photo ->
                    Toast.makeText(requireActivity(), photo.toString(), Toast.LENGTH_SHORT).show()
                }

            ) { message ->
                Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun updatePhoto() = with(binding) {
        btnPut.setOnClickListener {
            val photoId = 19
            val title = editTextTitle.text.toString().trim()
            val body = editTextInput.text.toString().trim()
            val updatePhoto = Photo(
                userId = 2,
                id = photoId,
                title = title,
                body = body
            )
            viewModel.updatePhoto(
                photoId = photoId,
                photo = updatePhoto,
                onSuccess = { photo ->
                    Toast.makeText(requireActivity(), photo.toString(), Toast.LENGTH_SHORT).show()
                }

            ) { message ->
                Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun createPhoto() = with(binding) {
        btnPost.setOnClickListener {
            val title = editTextTitle.text.toString().trim()
            val body = editTextInput.text.toString().trim()
            val newPhoto = Photo(
                userId = 10,
                id = 101,
                title = title,
                body = body
            )
            viewModel.createPhoto(
                photo = newPhoto,
                onSuccess = { photo ->
                    viewModel.addData(
                        com.example.kotlin56.data.remote.models.Photo(
                            body = photo.body,
                            title = photo.title,
                            userId = photo.userId
                        )
                    )
                    Toast.makeText(requireActivity(), photo.toString(), Toast.LENGTH_SHORT).show()
                }

            ) { message ->
                Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _biding = null
    }
}