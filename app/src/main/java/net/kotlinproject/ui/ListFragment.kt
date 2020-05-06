package net.kotlinproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*
import net.kotlinproject.adapter.UsersAdapter
import net.kotlinproject.data.User
import net.kotlinproject.databinding.FragmentListBinding
import net.kotlinproject.utils.ApiService
import net.kotlinproject.utils.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import soumyajitdas.com.roomviewmodelkotlinsample.Activity.MainActivityViewModel
import soumyajitdas.com.roomviewmodelkotlinsample.CountryRecyclerViewAdapter
import soumyajitdas.com.roomviewmodelkotlinsample.Model.CountryModel

class ListFragment : Fragment() {
    lateinit var countryRecyclerView: RecyclerView
    lateinit var mainActivityViewModel: MainActivityViewModel

    private lateinit var binding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        countryRecyclerView = binding.recyclerView
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
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
        val countryRecyclerViewAdapter = CountryRecyclerViewAdapter(context!!, countries)
        countryRecyclerView.adapter = countryRecyclerViewAdapter
        countryRecyclerView.layoutManager = GridLayoutManager(activity,2)
        countryRecyclerView.setHasFixedSize(true)
    }

}
