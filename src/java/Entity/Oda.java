/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/*
beyan
*/
public class Oda {
    private Long oda_id;
    private long oda_no;
    private String oda_tipi;
    private String durum;

    public Oda() {
    }

    public Oda(Long oda_id, long oda_no, String oda_tipi, String durum) {
        this.oda_id = oda_id;
        this.oda_no = oda_no;
        this.oda_tipi = oda_tipi;
        this.durum = durum;
    }
    
    public Long getOda_id() {
        return oda_id;
    }

    public void setOda_id(Long oda_id) {
        this.oda_id = oda_id;
    }

    public long getOda_no() {
        return oda_no;
    }

    public void setOda_no(long oda_no) {
        this.oda_no = oda_no;
    }

    public String getOda_tipi() {
        return oda_tipi;
    }

    public void setOda_tipi(String oda_tipi) {
        this.oda_tipi = oda_tipi;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.oda_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oda other = (Oda) obj;
        if (!Objects.equals(this.oda_id, other.oda_id)) {
            return false;
        }
        return true;
    }

    
    
}
/*
  <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h:form id="oda-table">
                        <h:dataTable  styleClass="table table-striped table-hover" value="#{odaController.odalist}" var="oda">
                            <h:column>
                                <f:facet name="header" >  ODA_ID  </f:facet>
                                    #{oda.oda_id}
                            </h:column>
                            <h:column>
                                <f:facet name="header" >  ODA_NO </f:facet>
                                    #{oda.oda_no}
                            </h:column>
                            <h:column>
                                <f:facet name="header" >  ODA_TIPI </f:facet>
                                    #{oda.oda_tipi}
                            </h:column>
                            <h:column>
                                <f:facet name="header" > DURUM </f:facet>
                                <h:commandLink action="#{odaController.updateForm(oda)}" value=" #{oda.durum}">
                                    <f:ajax execute="@this" render="oda-form"/>
                                </h:commandLink>
                            </h:column>
                            <h:column>
                                <f:facet name="header" > DELETE </f:facet>

                                <h:commandButton onclick="$('.modal').modal('show')" styleClass="btn btn-sm btn-danger" action="#{odaController.deleteConfirm(oda)}" value="Delete">
                                    <f:ajax execute="@this" render="delete-modal"/>
                                </h:commandButton>
                                 
                            </h:column>
                        </h:dataTable>
                    </h:form>

                </div>
                <div class="col-md-6">
                    <h:form id="oda-form">
                        <div class="form-group">
                           
                            <lable for="inputno">Oda No :</lable>
                            <h:inputText  styleClass="form-control" value="#{odaController.oda.oda_no}"/>
                      
                            <lable for="inputtip">Oda tipi :</lable>
                            <h:inputText styleClass="form-control" value="#{odaController.oda.oda_tipi}"/>
                            
                            <h:inputHidden value="#{odaController.oda.durum}"/>
                            <lable for="inputdurum">Durum :</lable>
                            <h:inputText styleClass="form-control" value="#{odaController.oda.durum}"/>
                        </div>
                        <div class="form-group">
                            <div class="btn-group">
                                <h:commandButton rendered="#{odaController.oda.durum !=null}" styleClass="btn btn-info" value="update" action="#{odaController.update}"> 
                                    <f:ajax execute="oda-form" render="oda-form oda-table"/>
                                </h:commandButton>`
                                <h:commandButton rendered="#{odaController.oda.durum ==null}" styleClass="btn btn-primary" value="Create" action="#{odaController.create}">
                                    <f:ajax execute="oda-form" render="oda-form oda-table"/>
                                </h:commandButton>
                                <h:commandButton  rendered="#{odaController.oda.durum !=null}" styleClass="btn btn-secondary" value="Clear Form" action="#{odaController.clearForm}">
                                 <f:ajax execute="oda-form" render="oda-form oda-table"/>

                                </h:commandButton>

                            </div>
                        </div>
                    </h:form>

                </div>
            </div>
            <div class= "modal" tabindex= "-1" role= "dialog" >
                <div class= "modal-dialog" role= "document" > 
                    <h:panelGroup layout="blok" class="modal-content" id="delete-modal">
                        <div class= "modal-header" >
                            <h5 class= "modal-title" > Delete Confirmation</h5>
                            <button type= "button" class= "close" data-dismiss= "modal" aria-label= "Close" > 
                                <span aria-hidden= "true" > &times; </span> 
                            </button>
                        </div> 
                        <div class= "modal-body" >
                            <p>
                                Are you sure to delete oda object?<br/>                               
                                   <b>Oda_id :</b>#{odaController.oda.oda_id}<br/>
                                   <b>Oda_no :</b>#{odaController.oda.oda_no}<br/>
                                   <b>Oda_tipi :</b>#{odaController.oda.oda_tipi}<br/>
                                   <b>durum  :</b>#{odaController.oda.durum}<br/>                        
                            </p>
                        </div> 
                        <div class= "modal-footer" > 
                            <h:form>
                                <h:commandButton  onclick="$('.modal').modal('hide')" action="#{odaController.delete}" value="Confirm" styleClass="btn btn-danger">
                                <f:ajax execute="@this" render="oda-table oda-form"/>
                            </h:commandButton>
                            <button type= "button" class= "btn btn-secondary" data-dismiss= "modal" > Close </button> 
                           </h:form>
                        </div> 
                        </h:panelGroup>
                    </div>
                </div> 
            </div> 
        
*/
