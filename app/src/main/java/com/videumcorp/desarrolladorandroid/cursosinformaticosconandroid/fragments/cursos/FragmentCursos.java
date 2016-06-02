package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.fragments.cursos;

/**
 * Created by David on 24/05/2016.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.appspot.cursosprogramacioncu.proxyEndpointCurso.ProxyEndpointCurso;
import com.appspot.cursosprogramacioncu.proxyEndpointCurso.model.CursoCollection;

import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.R;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils.App;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils.Indicador;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils.Respuesta;

import java.io.IOException;
import static com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils.App.getApp;

import static com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils.Constantes.LISTANDO;
import static com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils.Utileria.busca;
import static com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils.Utileria.muestraTexto;
import static com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils.Utileria.procesaError;
import static com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils.Utileria.setIndicadorActivo;
import static com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils.Utileria.texto;
public class FragmentCursos extends Fragment
        implements LoaderManager.LoaderCallbacks<Respuesta<CursoCollection>> {
    private static final String TAG = FragmentCursos.class.getName();
    private String mensaje;
    @Nullable private AdapterCursos adapter;
    @Nullable private Indicador indicador;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable @Override public View onCreateView(LayoutInflater inflater,
                                                 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_cursos, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        indicador = (Indicador) busca(view, R.id.indicador);
        adapter = new AdapterCursos();
        final RecyclerView listado = (RecyclerView) busca(view, R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(getActivity()));
        listado.setAdapter(adapter);
    }
    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        muestraMensajeError(mensaje);
        getLoaderManager().initLoader(0, null, this);
    }
    @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_maestro, menu);
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_actualizar:
                clicEnActualizar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override public Loader<Respuesta<CursoCollection>> onCreateLoader(int id,
                                                                       Bundle args) {
        setIndicadorActivo(indicador, true);
        final App app = getApp(getActivity());
        return new AsyncTaskLoader<Respuesta<CursoCollection>>(app) {
            @Override protected void onStartLoading() {
                forceLoad();
            }
            @Override public Respuesta<CursoCollection> loadInBackground() {
                try {
                    final ProxyEndpointCurso.List list =
                            app.getProxyEndpointConocidos().list();
                    final CursoCollection lista = list.execute();
                    return new Respuesta<>(lista, null);
                } catch (IOException e) {
                    return new Respuesta<>(null, e);
                }
            }
        };
    }
    @Override
    public void onLoadFinished(Loader<Respuesta<CursoCollection>> loader,
                               Respuesta<CursoCollection> data) {
        setIndicadorActivo(indicador, false);
        final Exception exception = data.getException();
        if (exception != null) {
            muestraError(exception);
        } else if (adapter != null) {
            adapter.setLista(data.getResultado().getItems());
        }
    }
    @Override
    public void onLoaderReset(Loader<Respuesta<CursoCollection>> loader) {
    }
    private void clicEnActualizar() {
        getLoaderManager().restartLoader(0, null, this);
    }

    private void muestraError(Exception exception) {
        final String mensaje = procesaError(TAG, LISTANDO, exception);
        muestraMensajeError(mensaje);
    }
    private void muestraMensajeError(String mensaje) {
        this.mensaje = mensaje;
        if (isAdded()) {
            muestraTexto(getView(), R.id.error, texto(mensaje));
        }
    }
}

