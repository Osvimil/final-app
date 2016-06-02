package com.appspot.cursosprogramacioncu.backend;
/**
 * Created by David on 23/05/2016.
 */

import com.googlecode.objectify.ObjectifyService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * Detecta cuando la aplicación web se levanta o se dá de baja. En la api de
 * servlets 2.5 hay que registrar esta clase en web.xml
 */
public class ListenerBackend implements ServletContextListener {
    /** Se invoca cuando el servidor se levanta. */
    @Override public void contextInitialized(ServletContextEvent sce) {
        // Registra las entity en objectify.
        ObjectifyService.register(Curso.class);
        ObjectifyService.register(CursoPremium.class);
        ObjectifyService.register(Pdf.class);
    }
    /** Se invoca cuando el servidor se dá de baja. */
    @Override public void contextDestroyed(ServletContextEvent sce) {}
}


