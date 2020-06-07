
package Entity;

import java.sql.Date;


public class Odeme {
    private Long odeme_id;
    private Date tarih;
    private String odeme_tipi;
    private int fiyat;
    
    private Musteri musteri;

    public Odeme() {
    }

    public Odeme(Long odeme_id, Date tarih, String odeme_tipi, int fiyat) {
        this.odeme_id = odeme_id;
        this.tarih = tarih;
        this.odeme_tipi = odeme_tipi;
        this.fiyat = fiyat;
    }

    public Long getOdeme_id() {
        return odeme_id;
    }

    public void setOdeme_id(Long odeme_id) {
        this.odeme_id = odeme_id;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getOdeme_tipi() {
        return odeme_tipi;
    }

    public void setOdeme_tipi(String odeme_tipi) {
        this.odeme_tipi = odeme_tipi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    
    @Override
    public String toString() {
        return "Odeme{" + "odeme_id=" + odeme_id + ", tarih=" + tarih + ", odeme_tipi=" + odeme_tipi + ", fiyat=" + fiyat + '}';
    }
    
    
    
    
    
}
       