package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils;

/**
 * Created by David on 24/05/2016.
 */

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.appspot.cursosprogramacioncu.proxyEndpointCurso.ProxyEndpointCurso;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.R;

import java.io.IOException;

public class App extends Application {
    @NonNull public static App getApp(@NonNull Context context) {
        return (App) context.getApplicationContext();
    }
    @Nullable private ProxyEndpointCurso proxyEndpointCursos;
    @NonNull public ProxyEndpointCurso getProxyEndpointConocidos() {
        if (proxyEndpointCursos == null) {
            proxyEndpointCursos = creaProxyEndpointCursos();
        }
        return proxyEndpointCursos;
    }
    @NonNull private ProxyEndpointCurso creaProxyEndpointCursos() {
        final JacksonFactory jacksonFactory = new JacksonFactory();
        final HttpTransport httpTransport = AndroidHttp.newCompatibleTransport();
        final HttpRequestInitializer httpRequestInitializer =
                new HttpRequestInitializer() {
                    @Override public void initialize(HttpRequest solicitudHttp)
                            throws IOException {
                    }
                };
        final ProxyEndpointCurso.Builder builder =
                new ProxyEndpointCurso.Builder(httpTransport, jacksonFactory,
                        httpRequestInitializer);
        builder.setApplicationName(getString(R.string.app_name));
        @SuppressWarnings("ConstantConditions")
        final String url = Constantes.SERVIDOR_LOCAL ? Constantes.URL_LOCAL : Constantes.URL_REMOTA;builder.setRootUrl(url + "/_ah/api/");
        // Solo se usa GZip al conectarse al servidor remoto.
        builder.setGoogleClientRequestInitializer(
                new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> request)
                            throws IOException {
                        if (Constantes.SERVIDOR_LOCAL) {
                            request.setDisableGZipContent(true);
                        }
                    }
                });
        return builder.build();
    }
}
