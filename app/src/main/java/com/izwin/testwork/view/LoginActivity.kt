package com.izwin.testwork.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.izwin.testwork.R
import com.izwin.testwork.model.ResponseModel
import com.izwin.testwork.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    fun onSignUpBtnClick(view: View){

        val pass = pass_edit_text.text.toString()
        val login = login_edit_text.text.toString()

        runBlocking {
            viewModel.getResponse(login, pass).enqueue(object  : Callback<ResponseModel> {
                override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {

                    if (!response.body()?.success.equals("false")){
                        viewModel.setCurrentUser(response.body()?.response?.token ?: "null token")

                        val intent = Intent(this@LoginActivity , MainScreenActivity::class.java)
                        startActivity(intent)

                    }
                    else{
                        Toast.makeText(this@LoginActivity, "Error!", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

                }

            })
        }


    }

    override fun onResume() {
        super.onResume()
        pass_edit_text.text.clear()
        login_edit_text.text.clear()
    }
}