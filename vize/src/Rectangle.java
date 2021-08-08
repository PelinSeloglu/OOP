/**
 *
 * @author PelinSeloglu
 */
public class Rectangle implements Shape {
    
    private final double width, height;
    
    public Rectangle(double height,double width) {
        this.width = width;
        this.height = height;
    }
    
     
    @Override
    public double alanHesapla() {
        return width * height;
    }
    
    @Override
    public double cevreHesapla(){
        return 2 * (width + height);
    }
    
    @Override
    public String toString(){
        return "Rectangle, height = " + height + ", width = " + width;
    } 
    
}
