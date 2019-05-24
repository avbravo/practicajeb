/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.practicaejb.converter;


  import com.avbravo.jmoordbutils.JsfUtil;
import com.avbravo.practicaejb.entity.Pais;
import com.avbravo.practicaejb.repository.PaisRepository;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped
public class PaisConverter implements Converter {

    @Inject
    PaisRepository paisRepository;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Pais pais = new Pais();
        try{
            if(!s.equals("null")){
               Pais b = new Pais();
               b.setIdpais(s);
               Optional<Pais> optional = paisRepository.findById(b);
               if (optional.isPresent()) {
               pais= optional.get();  
               }   
             }
          } catch (Exception e) {
             JsfUtil.errorMessage("getAsObject()" + e.getLocalizedMessage());
          }
          return pais;
      }


    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String r = "";
        try {
            if (o instanceof Pais) {
                Pais pais = (Pais) o;
                r = String.valueOf(pais.getIdpais());
            }else if (o instanceof String) {
               r = (String) o;
            }
        } catch (Exception e) {
            JsfUtil.errorMessage("getAsString()" + e.getLocalizedMessage());
        }
        return r;
        }



}
