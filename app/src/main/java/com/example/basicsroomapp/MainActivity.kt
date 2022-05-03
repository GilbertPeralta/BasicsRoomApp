package com.example.basicsroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicsroomapp.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainViewModel.saveUser(User(
//            "user3",
//            "name3",
//            1.73,
//            63.3,
//            "3@email.com",
//            "333333"
//
//        ))

        mainViewModel.getUsers()
        //si es un fragment
        //es con viewLifecycleOwner en lugar de this
        mainViewModel.savedUsers.observe(this) {usersList ->
            if(!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("thesearetheusers", user.user_name)
                }
            }else{
                Log.d("thesearetheusers", "null or empty")
            }
        }
    }
}