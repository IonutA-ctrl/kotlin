package net.kotlinproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.kotlinproject.databinding.FragmentSettingsBinding
import net.kotlinproject.viewmodel.DemoViewModel

class SettingsFragment : Fragment()  {

    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentSettingsBinding.inflate(layoutInflater)
        binding.resultTextView = DemoViewModel() // Injecting the view model into the layout file
        return binding.root
    }
}
