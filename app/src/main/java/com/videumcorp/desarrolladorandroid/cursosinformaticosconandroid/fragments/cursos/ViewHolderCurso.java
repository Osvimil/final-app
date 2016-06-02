package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.cursos;

/**
 * Created by David on 24/05/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.Curso;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.R;


/** Controla la interfaz gráfica que muestra un model en una lista. */
public class ViewHolderCurso extends RecyclerView.ViewHolder
        implements View.OnClickListener {
    public static ViewHolderCurso creaViewHolder(ViewGroup viewGroup) {
        final LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        final View view =
                inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        return new ViewHolderCurso(view);
    }

    @NonNull
    private final TextView text1;
    @Nullable
    private Curso model;
    int i=0;
    public ViewHolderCurso(@NonNull View view) {
        super(view);
        text1 = (TextView) itemView.findViewById(android.R.id.text1);
        text1.setTypeface(null, Typeface.BOLD);
        text1.setOnClickListener(this);
    }

    public void setModel(@Nullable Curso model,int num) {
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
            intent.setData(Uri.parse(model.getLink()));
            context.startActivity(intent);

        }
    }


}
