package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.cursos;

/**
 * Created by David on 24/05/2016.
 */
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.Curso;
import java.util.ArrayList;
import java.util.List;
/** Despliega un listado de conocidos. */
public class AdapterCursos extends RecyclerView.Adapter<ViewHolderCurso> {
    @Nullable private List<Curso> lista = new ArrayList<>();
    public void setLista(@Nullable List<Curso> lista) {
        this.lista = lista;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolderCurso onCreateViewHolder(ViewGroup viewGroup, int tipo) {
        return ViewHolderCurso.creaViewHolder(viewGroup);
    }
    @Override
    public void onBindViewHolder(ViewHolderCurso viewHolderCurso, int i) {
        viewHolderCurso.setModel(lista == null ? null : lista.get(i),i);

    }
    @Override public int getItemCount() {
        return lista == null ? 0 : lista.size();
    }
}

