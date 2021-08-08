/**
 *
 * @author PelinSeloglu
 */
public class Soru2Deneme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Mudurlukler genel_mudurluk = new Mudurlukler("Genel Müdürlük");
        //mudurluk çalısanları
        genel_mudurluk.addArray(new Calisan("Ali", 5000));
        genel_mudurluk.addArray(new Calisan("Veli", 6000));
        
        Mudurlukler ege_bölge = new Mudurlukler("Ege Bölge Müdürlüğü");
        //ege_bölge müdürlüğü çalışanları
        ege_bölge.addArray(new Calisan("Ayşe", 4000));
        ege_bölge.addArray(new Calisan("Can", 3000));
        
        
        Mudurlukler izmir_il = new Mudurlukler("İzmir il müdürlüğü");
        //izmir bölge çalışanları
        izmir_il.addArray(new Calisan("Selim", 2000));
        izmir_il.addArray(new Calisan("Murat", 1500));
        izmir_il.addArray(new Calisan("Zeynep",2500));
        
        Mudurlukler akdeniz_bölge = new Mudurlukler("Akdeniz Bölge Müdürlüğü");
        //akdeniz bölgesi çalışanları
        akdeniz_bölge.addArray(new Calisan("Emre", 3000));
        akdeniz_bölge.addArray(new Calisan("Ahmet", 4000));
        
        
        Mudurlukler antalya_il = new Mudurlukler("Antalya il müdürlüğü");
        //Antalya çalışanları 
        antalya_il.addArray(new Calisan("Bahar", 2500));
        antalya_il.addArray(new Calisan("Sedat", 1500));
        antalya_il.addArray(new Calisan("Vedat", 2500));
        

        //antalya çalışanlarının akdeniz bölgesine dahil edilmesi
        akdeniz_bölge.addArray(antalya_il);
        
        //izmir çalışanlarının ege bölgesine dahil edilmesi
        ege_bölge.addArray(izmir_il);
        
        //ege ve akdeniz bölgelerinin genel müdürlüğe eklenmesi
        genel_mudurluk.addArray(ege_bölge);
        genel_mudurluk.addArray(akdeniz_bölge);
        
        System.out.println("Ege bölgesi maliyetleri:" + ege_bölge.maliyet());
        
        System.out.println("Akdeniz bölgesi maliyetleri:" + akdeniz_bölge.maliyet());
        
        System.out.println("Genel müdürlük maliyetleri:" + genel_mudurluk.maliyet());
        
    }
    
}
