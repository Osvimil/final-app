package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.R;

/**
 * Created by oswaldosaldivar on 24/05/16.
 */
public class CursosPremium extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.cursos_premium, container, false);
        return view;
    }
}
