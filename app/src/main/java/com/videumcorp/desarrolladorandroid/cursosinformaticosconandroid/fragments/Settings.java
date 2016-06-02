package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.R;

/**
 * Created by oswaldosaldivar on 30/05/16.
 */
public class Settings extends android.support.v4.app.Fragment {
    DatePicker datePicker;
    TextView textView;
    Button boton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.activity_settings, container, false);
        datePicker = (DatePicker)view.findViewById(R.id.datepicker);
        textView = (TextView)view.findViewById(R.id.texto);
        boton = (Button)view.findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText(String.valueOf(datePicker.getDayOfMonth()+"-"+
                                String.valueOf(datePicker.getMonth()+"-"+
                                                String.valueOf(datePicker.getYear())
                                )
                ));

            }
        });

        return view;
    }


}