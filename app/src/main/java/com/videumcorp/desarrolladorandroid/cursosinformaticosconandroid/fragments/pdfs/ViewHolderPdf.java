package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.pdfs;

/**
 * Created by David on 25/05/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.Pdf;

import java.text.NumberFormat;
import java.util.Locale;


/** Controla la interfaz gráfica que muestra un model en una lista. */
public class ViewHolderPdf extends RecyclerView.ViewHolder
        implements View.OnClickListener {
    private static final NumberFormat fmtMoneda = NumberFormat
            .getCurrencyInstance(Locale.getDefault());
    public static ViewHolderPdf creaViewHolder(ViewGroup viewGroup) {
        final LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        final View view =
                inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        return new ViewHolderPdf(view);
    }

    @NonNull
    private final TextView text1;
    @Nullable
    private Pdf model;
    public ViewHolderPdf(@NonNull View view) {
        super(view);
        text1 = (TextView) itemView.findViewById(android.R.id.text1);
        text1.setOnClickListener(this);
    }

    public void setModel(@Nullable Pdf model,int num) {
        this.model = model;
        text1.setText(model == null ? "" : model.getNombre());
        if(num%2==0)
            text1.setBackgroundColor(Color.parseColor("#9ccc65"));
        else
            text1.setBackgroundColor(Color.parseColor("#ffee58"));
    }

    @Override
    public void onClick(View v) {
        if (model != null) {

            final Context context = text1.getContext();
            /*String parameter=text1.getText().toString().trim();
            parameter=parameter.replaceAll("\\+", "%2B");
            parameter=parameter.replace("#","%23");
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/#q=Cursos+de+"+parameter));
            context.startActivity(browserIntent);
            */


            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(model.getLink().replace("dl=0","dl=1")));
            context.startActivity(intent);

        }
    }


}
