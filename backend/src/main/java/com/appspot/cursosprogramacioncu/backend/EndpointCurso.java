/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.appspot.cursosprogramacioncu.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.Key;
import java.util.List;
import javax.inject.Named;
import static com.appspot.cursosprogramacioncu.backend.Constantes.NOMBRE;
import static com.googlecode.objectify.ObjectifyService.ofy;
/** An endpoint class we are exposing */
@Api(
  name = "proxyEndpointCurso",
  version = "v2",
  namespace = @ApiNamespace(
    ownerDomain = "cursosprogramacioncu.appspot.com",
    ownerName = "cursosprogramacioncu.appspot.com",
    packagePath=""
  )
)
public class EndpointCurso {

    /**
     * Devuelve una lista con todos los cursos registrados. Usa el método GET
     * de HTTP.
     * @return una lista con todos los cursos registrados.
     */
    @ApiMethod(name = "list") public List<Curso> list() {
        return ofy().load().type(Curso.class).order(NOMBRE).list();
    }

    /**
     * Devuelve una lista con todos los cursos registrados. Usa el método GET
     * de HTTP.
     * @return una lista con todos los cursos registrados.
     */
    @ApiMethod(name = "listPremium") public List<CursoPremium> listPremium() {
        return ofy().load().type(CursoPremium.class).order(NOMBRE).list();
    }
    /**
     * Devuelve una lista con todos los PDF'S registrados. Usa el método GET
     * de HTTP.
     * @return una lista con todos los PDF'S registrados.
     */
    @ApiMethod(name = "listPdf") public List<Pdf> listPdf() {
        return ofy().load().type(Pdf.class).order(NOMBRE).list();
    }
    /**
     * Agrega un nuevo curso. Usa el método POST de HTTP.
     * @param model datos capturados en la interfaz gráfica.
     */
    @ApiMethod(name = "insertCurso",path = "insert_Curso") public void insertCurso(Curso model) {
        ofy().save().entity(model).now();
    }


    @ApiMethod(name = "insertPremium",path = "insert_CursoPremium") public void insertPremium(CursoPremium model) {
        ofy().save().entity(model).now();
    }

    @ApiMethod(name = "insertPdf",path = "insert_Pdf") public void insertPdf(Pdf model) {
        ofy().save().entity(model).now();
    }

}
