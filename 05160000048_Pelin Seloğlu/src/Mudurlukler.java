import java.util.*;
/**
 *
 * @author PelinSeloglu
 */
public class Mudurlukler extends FirmaBilesen {
    
    private String mudurlukAdı;
    private List<FirmaBilesen> firmaArray ; 
    
    
    public Mudurlukler(String mudurlukAdı){
        this.mudurlukAdı = mudurlukAdı;
        this.firmaArray = new ArrayList<FirmaBilesen>(); 
    }
    
    public void addArray(FirmaBilesen nesne){
         firmaArray.add(nesne);
    }
    
   
    public int maliyet(){
        int top_maliyet = 0;
        //firmaArray.forEach(nesne -> {
        //System.out.println(nesne.maliyet());
        
        //});
        top_maliyet = firmaArray.stream().map(nesne -> nesne.maliyet()).reduce(top_maliyet, Integer::sum);
        return top_maliyet;
    }
}
