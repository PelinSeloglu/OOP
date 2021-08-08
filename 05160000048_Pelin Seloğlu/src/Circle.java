/**
 *
 * @author PelinSeloglu
 */
public class Circle implements Shape {
    
    private final double radius;
    final double pi = Math.PI;
    
    public Circle(double radius) {
        this.radius = radius;
    }
        
    @Override
    public double cevreHesapla(){
        return 2 * pi * radius;
    }
        
    @Override
    public double alanHesapla(){
        return pi * Math.pow(radius, 2);
    }
    
    @Override
    public String toString(){
        return "Circle, radius = "+radius;
    } 
    
}
