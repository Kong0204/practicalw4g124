package com.example.practicalw4g124

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.practicalw4g124.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val myName:MyName = MyName("Andrina")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //put everything into this binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //so now i no longer need this code
//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            addNickName(it)
//        }
        binding.myName = myName
        binding.doneButton.setOnClickListener{
            addNickName(it)
        }

        //so now i no longer need this code
//        findViewById<TextView>(R.id.nickname_text).setOnClickListener{
//            updateNickname(it)
//        }
        binding.nicknameText.setOnClickListener{
            updateNickName(it)
        }
    }


    private fun addNickName(view: View){
        //after use binding, i no longer need this code
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_edit)

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            //THIS IS A MUST
            invalidateAll()

            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }



        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }

    private fun updateNickName(view:View){

//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val doneButton = findViewById<Button>(R.id.done_button)

        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        binding.nicknameEdit.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit,0)

    }




}