package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.cursos.premium;

/**
 * Created by David on 25/05/2016.
 */
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.CursoPremium;

import java.util.ArrayList;
import java.util.List;
public class AdapterCursosPremium extends RecyclerView.Adapter<ViewHolderCursoPremium> {
    @Nullable
    private List<CursoPremium> lista = new ArrayList<>();

    public void setLista(@Nullable List<CursoPremium> lista) {
        this.lista = lista;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderCursoPremium onCreateViewHolder(ViewGroup viewGroup, int tipo) {
        return ViewHolderCursoPremium.creaViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(ViewHolderCursoPremium viewHolderCurso, int i) {
        viewHolderCurso.setModel(lista == null ? null : lista.get(i),i);

    }

    @Override
    public int getItemCount() {
        return lista == null ? 0 : lista.size();
    }
}