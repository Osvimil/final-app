package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.R;


public class CursosBasicos extends Fragment {

    public  CursosBasicos(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.cursos_basicos, container, false);
        String[] menuItems = {"PYTHON","RUBY","GO","C++","C#","JAVA","JAVASCRIPT","PHP","CSS3","HTML5","F#","MONGODB","SQL SERVER","ANGULARJS"};
        ListView listview = (ListView)view.findViewById(R.id.lista_basico);

        ArrayAdapter<String> array = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listview.setAdapter(array);


        return view;






    }



}
