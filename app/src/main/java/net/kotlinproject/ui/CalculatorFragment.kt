package net.kotlinproject.ui


import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calculator.*
import net.kotlinproject.databinding.FragmentCalculatorBinding
import net.kotlinproject.viewmodel.DemoViewModel


class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentCalculatorBinding.inflate(layoutInflater)
        binding.calcExpression = DemoViewModel()
        return binding.root
    }

}
