package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.R;


public class Registrate extends Fragment {
    FloatingActionButton floatingActionButton0,floatingActionButton1,floatingActionButton2,floatingActionButton3,
            floatingActionButton4,floatingActionButton5,floatingActionButton6,floatingActionButton7,floatingActionButton8;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_registrate, container, false);
        floatingActionButton0 = (FloatingActionButton)view.findViewById(R.id.fab);
        floatingActionButton1 = (FloatingActionButton)view.findViewById(R.id.fab1);
        floatingActionButton2 = (FloatingActionButton)view.findViewById(R.id.fab2);
        floatingActionButton3 = (FloatingActionButton)view.findViewById(R.id.fab3);
        floatingActionButton4 = (FloatingActionButton)view.findViewById(R.id.fab4);
        floatingActionButton5 = (FloatingActionButton)view.findViewById(R.id.fab5);
        floatingActionButton6 = (FloatingActionButton)view.findViewById(R.id.fab6);
        floatingActionButton7 = (FloatingActionButton)view.findViewById(R.id.fab7);
        floatingActionButton8 = (FloatingActionButton)view.findViewById(R.id.fab8);

        floatingActionButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "CURSO DE RUBY", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });
        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "CURSO DE VISUAL STUDIO", Snackbar.LENGTH_LONG).setAction("Action", null).show();


            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "CURSO DE JAVA", Snackbar.LENGTH_LONG).setAction("Action", null).show();


            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "CURSO DE HTML5", Snackbar.LENGTH_LONG).setAction("Action", null).show();


            }
        });
        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "CURSO DE JS", Snackbar.LENGTH_LONG).setAction("Action", null).show();


            }
        });
        floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "CURSO DE CSS3", Snackbar.LENGTH_LONG).setAction("Action", null).show();


            }
        });
        floatingActionButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "CURSO DE SQL", Snackbar.LENGTH_LONG).setAction("Action", null).show();


            }
        });
        floatingActionButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "CURSO DE PHP", Snackbar.LENGTH_LONG).setAction("Action", null).show();


            }
        });
        floatingActionButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "CURSO DE PYTHON", Snackbar.LENGTH_LONG).setAction("Action", null).show();


            }
        });

        return view;
    }


    }


