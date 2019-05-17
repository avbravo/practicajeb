/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.practicaejb.services;

import com.avbravo.jmoordbutils.JsfUtil;
import com.avbravo.practicaejb.entity.Persona;
import com.avbravo.practicaejb.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.bson.Document;

/**
 *
 * @authoravbravo
 */
@Stateless
public class PersonaServices {

    @Inject
    PersonaRepository repository;

    List<Persona> personaList = new ArrayList<>();

    public List<Persona> complete(String query) {
        List<Persona> suggestions = new ArrayList<>();
        try {
            suggestions = repository.complete(query);
        } catch (Exception e) {
            JsfUtil.errorMessage("complete() " + e.getLocalizedMessage());
        }

        return suggestions;
    }

    public List<Persona> getPersonaList() {
        try {
            personaList = repository.findAll(new Document("persona", 1));
        } catch (Exception e) {
            JsfUtil.errorMessage("getPersonaList() " + e.getLocalizedMessage());
        }
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    // <editor-fold defaultstate="collapsed" desc="isDeleted(Persona persona)">
    public Boolean isDeleted(Persona persona) {
        Boolean found = false;
        try {
            Document doc = new Document("persona.cedula", persona.getCedula());
//            Integer count = ventasRepository.count(doc);
//            if (count > 0) {
//                return false;
//            }

        } catch (Exception e) {
            JsfUtil.errorMessage("isDeleted() " + e.getLocalizedMessage());
        }
        return true;
    }  // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="findById(String id)">
    public Persona findById(String id) {
        Persona persona = new Persona();
        try {

            persona.setCedula(id);
            Optional<Persona> optional = repository.findById(persona);
            if (optional.isPresent()) {
                return optional.get();
            }
        } catch (Exception e) {
            JsfUtil.errorMessage("findById() " + e.getLocalizedMessage());
        }

        return persona;
    }
    // </editor-fo
}
