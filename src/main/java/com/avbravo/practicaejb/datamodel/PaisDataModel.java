/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.practicaejb.datamodel;

import com.avbravo.practicaejb.entity.Pais;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author avbravo
 */
public class PaisDataModel extends ListDataModel<Pais> implements SelectableDataModel<Pais>{

    public PaisDataModel() {
    }
    public PaisDataModel(List<Pais>data) {
        super(data);
    }

    @Override
    public Pais  getRowData(String rowKey) {
        List<Pais> paisList = (List<Pais>) getWrappedData();
        for (Pais pais : paisList) {
             if (pais.getIdpais().equals(rowKey)) {
                 return pais;
             }
        }
        return null;
     }
     @Override
     public Object getRowKey(Pais pais) {
         return pais.getIdpais();
     }


}
