package net.kotlinproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.kotlinproject.activity.ListViewModel
import net.kotlinproject.CountryRecyclerViewAdapter
import net.kotlinproject.model.CountryModel
import net.kotlinproject.databinding.FragmentListBinding

class ListFragment : Fragment() {
    lateinit var countryRecyclerView: RecyclerView
    lateinit var mainActivityViewModel: ListViewModel

    private lateinit var binding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        countryRecyclerView = binding.recyclerView
        mainActivityViewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        mainActivityViewModel.getCountriesFromAPIAndStore()

        mainActivityViewModel.getAllCountryList()
            ?.observe(this, Observer<List<CountryModel>> { countryList ->
                Log.e(HomeFragment::class.java.simpleName, countryList.toString())
                setUpCountryRecyclerView(countryList!!)
            })
        return binding.root


    }
    fun setUpCountryRecyclerView(countries : List<CountryModel>)
    {
        val countryRecyclerViewAdapter = context?.let { CountryRecyclerViewAdapter(it, countries) }
        countryRecyclerView.adapter = countryRecyclerViewAdapter
        countryRecyclerView.layoutManager = LinearLayoutManager(activity)
        countryRecyclerView.setHasFixedSize(true)
    }

}
