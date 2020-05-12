package net.kotlinproject

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.kotlinproject.model.CountryModel
import net.kotlinproject.databinding.SingleCountryModelLayoutBinding


class CountryRecyclerViewAdapter(_context : Context, _countryList:List<CountryModel>) : RecyclerView.Adapter<CountryRecyclerViewAdapter.CountryViewHolder>() {


    val countryList = _countryList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val binding = SingleCountryModelLayoutBinding.inflate(inflater)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder:CountryViewHolder, position: Int) = holder.bind(countryList[position])


    inner class CountryViewHolder(private val binding: SingleCountryModelLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(item: CountryModel) {

                binding.item = item
                binding.executePendingBindings()

        }
    }

}