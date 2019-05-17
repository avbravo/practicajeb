/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.avbravo.practicaejb.converter;


  import com.avbravo.jmoordbutils.JsfUtil;
import com.avbravo.practicaejb.entity.Persona;
import com.avbravo.practicaejb.repository.PersonaRepository;
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
public class PersonaConverter implements Converter {

    @Inject
    PersonaRepository personaRepository;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Persona persona = new Persona();
        try{
            if(!s.equals("null")){
               Persona b = new Persona();
               b.setCedula(s);
               Optional<Persona> optional = personaRepository.findById(b);
               if (optional.isPresent()) {
               persona= optional.get();  
               }   
             }
          } catch (Exception e) {
             JsfUtil.errorMessage("getAsObject()" + e.getLocalizedMessage());
          }
          return persona;
      }


    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String r = "";
        try {
            if (o instanceof Persona) {
                Persona persona = (Persona) o;
                r = String.valueOf(persona.getCedula());
            }else if (o instanceof String) {
               r = (String) o;
            }
        } catch (Exception e) {
            JsfUtil.errorMessage("getAsString()" + e.getLocalizedMessage());
        }
        return r;
        }



}
