package net.kotlinproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)

        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiService::class.java)
        api.fetchAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body()!!)
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                binding.textViewList1.setText("No Network Connection")
            }
        })
        return binding.root

    }
    private fun showData(users: List<User>?) {
        recyclerView.apply {
            try{
                layoutManager = LinearLayoutManager(activity)
                adapter = users?.let { UsersAdapter(it) }
            }catch(e:NullPointerException){
                e.printStackTrace()
            }

        }
    }

}
