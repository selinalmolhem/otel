/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Dao.personelDao;
import Entity.Personel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Sally mulhem
 */
 @FacesConverter(value="Personelconverter")
public class Personelconverter implements Converter{
private personelDao personeldao;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getPersoneldao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Personel p=(Personel)value;
        return p.getPersonel_id().toString();
    }

    public personelDao getPersoneldao() {
        if(this.personeldao==null)
            this.personeldao=new personelDao();
        return personeldao;
    }
   
}
