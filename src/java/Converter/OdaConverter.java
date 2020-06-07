/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Dao.OdaDAO;
import Entity.Oda;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="odaConverter")
public class OdaConverter implements Converter{
    
    private OdaDAO odadao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getOdadao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Oda oda=(Oda) value;        
        return oda.getOda_id().toString();
    }

    public OdaDAO getOdadao() {
        if(this.odadao==null)
            this.odadao=new OdaDAO();
        return odadao;
    }
    
    
}
