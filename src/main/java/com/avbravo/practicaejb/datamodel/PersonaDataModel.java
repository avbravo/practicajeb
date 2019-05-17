/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.practicaejb.datamodel;

import com.avbravo.practicaejb.entity.Persona;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author avbravo
 */
public class PersonaDataModel extends ListDataModel<Persona> implements SelectableDataModel<Persona>{

    public PersonaDataModel() {
    }
    public PersonaDataModel(List<Persona>data) {
        super(data);
    }

    @Override
    public Persona  getRowData(String rowKey) {
        List<Persona> personaList = (List<Persona>) getWrappedData();
        for (Persona persona : personaList) {
             if (persona.getCedula().equals(rowKey)) {
                 return persona;
             }
        }
        return null;
     }
     @Override
     public Object getRowKey(Persona persona) {
         return persona.getCedula();
     }


}
