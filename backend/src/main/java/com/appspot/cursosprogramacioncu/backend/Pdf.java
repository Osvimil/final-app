package com.appspot.cursosprogramacioncu.backend;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by David on 30/05/2016.
 */
@Entity
public class Pdf {
    @Id
    Long id;

    @Index
    String nombre;

    String link;
    public Pdf(){}
    public Pdf(String id, String nombre,String link) {
        this.id = id == null ? null : Key.valueOf(id).getId();
        this.nombre = nombre;
        this.link=link;
    }


    public String getId() {
        return id == null ? null : Key.create(Curso.class, id).toWebSafeString();
        //Para incluir en busqueda
    }
    public void setId(String id) {
        this.id = id == null ? null : Key.valueOf(id).getId();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
