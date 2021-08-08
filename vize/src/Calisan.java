/**
 *
 * @author PelinSeloglu
 */
public class Calisan extends FirmaBilesen{
    private String adSoyad;
    private int maas;
    
    
    public int maliyet(){
        return maas;
    }
    
    public Calisan(String adSoyad, int maas){
       this.adSoyad = adSoyad;
       this.maas = maas;
    }
   
   
}
