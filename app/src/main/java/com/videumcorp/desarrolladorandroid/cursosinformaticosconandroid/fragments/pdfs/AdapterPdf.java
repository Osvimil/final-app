package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.pdfs;

/**
 * Created by David on 25/05/2016.
 */
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.Pdf;

import java.util.ArrayList;
import java.util.List;

public class AdapterPdf extends RecyclerView.Adapter<ViewHolderPdf> {
    @Nullable
    private List<Pdf> lista = new ArrayList<>();

    public void setLista(@Nullable List<Pdf> lista) {
        this.lista = lista;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderPdf onCreateViewHolder(ViewGroup viewGroup, int tipo) {
        return ViewHolderPdf.creaViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(ViewHolderPdf viewHolderCurso, int i) {
        viewHolderCurso.setModel(lista == null ? null : lista.get(i),i);

    }

    @Override
    public int getItemCount() {
        return lista == null ? 0 : lista.size();
    }
}