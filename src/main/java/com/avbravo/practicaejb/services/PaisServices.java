/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.practicaejb.services;

import com.avbravo.jmoordbutils.JsfUtil;
import com.avbravo.practicaejb.entity.Pais;
import com.avbravo.practicaejb.repository.PaisRepository;

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
public class PaisServices {

    @Inject
    PaisRepository repository;

    List<Pais> paisList = new ArrayList<>();

    public List<Pais> complete(String query) {
        List<Pais> suggestions = new ArrayList<>();
        try {
            suggestions = repository.complete(query);
        } catch (Exception e) {
            JsfUtil.errorMessage("complete() " + e.getLocalizedMessage());
        }

        return suggestions;
    }

    public List<Pais> getPaisList() {
        try {
            paisList = repository.findAll(new Document("pais", 1));
        } catch (Exception e) {
            JsfUtil.errorMessage("getPaisList() " + e.getLocalizedMessage());
        }
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    // <editor-fold defaultstate="collapsed" desc="isDeleted(Pais pais)">
    public Boolean isDeleted(Pais pais) {
        Boolean found = false;
        try {
            Document doc = new Document("pais.cedula", pais.getIdpais());
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
    public Pais findById(String id) {
        Pais pais = new Pais();
        try {

            pais.setIdpais(id);
            Optional<Pais> optional = repository.findById(pais);
            if (optional.isPresent()) {
                return optional.get();
            }
        } catch (Exception e) {
            JsfUtil.errorMessage("findById() " + e.getLocalizedMessage());
        }

        return pais;
    }
    // </editor-fo
}
