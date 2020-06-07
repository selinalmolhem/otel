
package Entity;


public class Rezervasyon {
    
    private Long rezervasyon_id;
    
    private String giris_tarihi;
    private String cikis_tarihi;
    
    private Musteri musteri;
    
    private Oda oda;

    public Rezervasyon() {
    }

    public Rezervasyon(Long rezervasyon_id,  String giris_tarihi,  String cikis_tarihi) {
        this.rezervasyon_id = rezervasyon_id;
        this.giris_tarihi = giris_tarihi;
        this.cikis_tarihi = cikis_tarihi;
    }

    public Long getRezervasyon_id() {
        return rezervasyon_id;
    }

    public void setRezervasyon_id(Long rezervasyon_id) {
        this.rezervasyon_id = rezervasyon_id;
    }

    public String getGiris_tarihi() {
        return giris_tarihi;
    }

    public void setGiris_tarihi(String giris_tarihi) {
        this.giris_tarihi = giris_tarihi;
    }

    public String getCikis_tarihi() {
        return cikis_tarihi;
    }

    public void setCikis_tarihi(String cikis_tarihi) {
        this.cikis_tarihi = cikis_tarihi;
    }
   
    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Oda getOda() {
        return oda;
    }

    public void setOda(Oda oda) {
        this.oda = oda;
    }

    

    @Override
    public String toString() {
        return "rezervasyon{" + "rezervasyon_id=" + rezervasyon_id + ", giris_tarihi=" + giris_tarihi + ", cikis_tarihi=" + cikis_tarihi + '}';
    }
    
    
    
    
}
