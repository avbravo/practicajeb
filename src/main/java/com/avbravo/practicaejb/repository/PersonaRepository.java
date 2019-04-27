/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.practicaejb.repository;

import com.avbravo.jmoordb.mongodb.repository.Repository;
import com.avbravo.practicaejb.entity.Persona;

import javax.ejb.Stateless;

/**
 *
 * @author avbravo
 */
@Stateless
public class PersonaRepository extends Repository<Persona> {

    public PersonaRepository() {
        super(Persona.class, "practica", "persona");
    }
    
}
