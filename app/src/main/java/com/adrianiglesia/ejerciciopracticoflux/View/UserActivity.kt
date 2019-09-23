package com.adrianiglesia.ejerciciopracticoflux.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianiglesia.ejerciciopracticoflux.Model.User
import com.adrianiglesia.ejerciciopracticoflux.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val user:User = intent.getParcelableExtra("USER")

        val picasso = Picasso.get()
        picasso.load(user.picture.large)
            .into(user_image)

        user_first_name.text = user.name.first.capitalize()
        user_last_name.text = user.name.last.capitalize()
        tv_nat.text = user.nat
        tv_date.text = user.dob.date
        user_mail.text = user.email
    }
}
