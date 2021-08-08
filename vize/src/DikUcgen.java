/**
 *
 * @author PelinSeloglu
 */
public class DikUcgen implements Shape{
    private final double  a, b, c;
    
    public DikUcgen(double a, double b){
        this.a = a;
        this.b = b;
        this.c = Math.sqrt((a*a)+(b*b));       
    }
    
    
    @Override
    public double alanHesapla() {
        return (a * b) / 2;
    }
    
    @Override
    public double cevreHesapla(){
        return a + b + c;
    }
    
    public void tangentValues(){
        double tangent1 = a/b;
        double tangent2 = b/a;
        System.out.println("Birinci tangent = " + tangent1);
        System.out.println("İkinci tangent = " + tangent2);
    }
    
    @Override
    public String toString(){
        return "Dik üçgen, a = " + a + ", b = " + b + ", c = " + c ;
    } 
}
