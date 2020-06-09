/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.musteriDao;
import Entity.Musteri;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="musteriConverter")
public class MusteriConverter1 implements Converter{
    
    private musteriDao musteridao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMusteridao().find(Long.valueOf(value));
    }
    

    @Override
    public String getAsString(FacesContext context, UIComponent arg1, Object value) {
        Musteri m=(Musteri) value;
        return m.getMusteri_id().toString();
    }

    public musteriDao getMusteridao() {
        if(this.musteridao==null)
            this.musteridao=new musteriDao();
        return musteridao;
    }
    
    
}
