package com.adrianiglesia.ejerciciopracticoflux.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianiglesia.ejerciciopracticoflux.Model.User
import com.adrianiglesia.ejerciciopracticoflux.R
import com.adrianiglesia.ejerciciopracticoflux.ViewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UsersAdapter.OnItemClickListener{

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()


        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.isLoading.observe(this, Observer<Boolean> {
            it?.let{showLoading(it)}
        })

        viewModel.apiError.observe(this, Observer<Throwable> {
            it?.let { showMessage(false) }
        })

        viewModel.getUsers().observe(this, Observer<List<User>>{ users ->
            if(users.isNotEmpty()){
                recycler_users.visibility = View.VISIBLE
                recycler_users.adapter = UsersAdapter(users, this)
                showMessage(true)
            }else{
                showMessage(false)
            }
        })
    }

    override fun onItemClicked(user: User) {
            var intent = Intent(this, UserActivity::class.java)
            intent.putExtra("USER",user)
            startActivity(intent)
    }


    private fun setUpRecyclerView() {
        recycler_users.layoutManager = LinearLayoutManager(this)
        recycler_users.hasFixedSize()
    }


    private fun showMessage(isOk:Boolean){
        if(isOk)
            Toast.makeText(this, "Exito", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

    private fun showLoading(loading:Boolean){
        when {
            loading -> loading_main.visibility = View.VISIBLE
            else -> loading_main.visibility = View.GONE
        }
    }

}
