package com.example.feruz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.feruz.databinding.ActivityMessagesBinding
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class MessagesActivitty : AppCompatActivity() {

    private lateinit var binding: ActivityMessagesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseAuth.getInstance().currentUser?.let { user ->
            binding.uaerName.text = user.displayName
            binding.userEmail.text = user.email


            Picasso.get()
                .load(user.photoUrl)
                .placeholder(R.drawable.dprofil).into(binding.profilImage)



        }
        binding.logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
        }
    }
    private fun updateUI(user:FirebaseAuth){

    }
}