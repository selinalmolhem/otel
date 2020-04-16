/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Dao.lokantaDao;
import Entity.Lokanta;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Sally mulhem
 */
@FacesConverter(value="Lokantaconverter")
public class Lokantaconverter implements Converter {
   private lokantaDao lokantadao;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getLokantadao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Lokanta l = (Lokanta) value;
        return l.getMenu_id().toString();
    }

    public lokantaDao getLokantadao() {
        if(this.lokantadao==null)
            this.lokantadao=new lokantaDao();
        return lokantadao;
    }
    
}
