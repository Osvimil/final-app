package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.MainActivity;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.R;


public class AcercaDe extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_acerca_de, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Inbox");

        Button buttonChangeText = (Button) view.findViewById(R.id.buttonFragmentInbox);

         final TextView textViewInboxFragment = (TextView) view.findViewById(R.id.textViewInboxFragment);

        buttonChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewInboxFragment.setText("El objetivo de esta aplicación es mostrar cursos disponibles" +
                        "con los que cuenta nuestra APP desarrollada, todo es con el fin de que el usuario" +
                        "pueda seleccionar el curso que más le convenga de manera gratuita y, si se logea en nuestra" +
                        "APP será capaz de visualizar más cursos y/o cursos avanzados");
                textViewInboxFragment.setTextColor(getResources().getColor(R.color.md_white_1000));

            }
        });

        return view;
    }

}
