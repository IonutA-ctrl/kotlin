package net.kotlinproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_row.view.*
import net.kotlinproject.R
import net.kotlinproject.data.User
import net.kotlinproject.databinding.UserRowBinding


class UsersAdapter(private val users: List<User>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    private lateinit var binding: UserRowBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = UserRowBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding.root)

    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var user = users[position]
        binding.firstName.setText(user.name)
        binding.lastName.setText(user.username)
        binding.email.setText(user.email)

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
