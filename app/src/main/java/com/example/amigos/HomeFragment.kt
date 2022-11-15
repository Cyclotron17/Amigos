package com.example.amigos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.amigos.R.id
import com.example.amigos.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment

        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)

        view.findViewById<Button>(R.id.formbtn).setOnClickListener{
            Log.d("btnSetup", "Selected")
            val intent = Intent (getActivity(),quizForm::class.java)
            getActivity()?.startActivity(intent)

        }
        view.findViewById<ImageView>(R.id.diary).setOnClickListener {
            Log.d("btnDiary","SELEcted")
            val intent = Intent (getActivity(),todo::class.java)
            getActivity()?.startActivity(intent)
        }


        // Return the fragment view/layout
        return view
    }





}