package com.appspot.cursosprogramacioncu.backend;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;

/**
 * Created by David on 25/05/2016.
 */
@Entity
public class CursoPremium extends Curso {

    private int costo;

    public CursoPremium(){

    }
    public CursoPremium(String id, String nombre,String descripcion,int costo) {
        super(id,nombre,descripcion);

        this.costo=costo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
