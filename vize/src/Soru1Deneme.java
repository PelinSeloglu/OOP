import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Soru1Deneme {

    public static void main(String[] args) throws FileNotFoundException {
        
        Shape[] shapes = new Shape[5];
        File text = new File("girdi.txt");
    
        Scanner scnr = new Scanner(text);
        int index = 0;
        
        while(scnr.hasNextLine()){
            //metin satır satır okunur, okunan metindeki her bir satır " " ile ayrılır ve 
            //tempSplit e atılır
            
            String line = scnr.nextLine();
            String[] tempSplit = line.split(" ");
               
            for (int i=0; i < tempSplit.length; i++)
            {   //tempSplit in ilk indexi shape in tipini belirler, diğer indexler de 
                //shape in sahip olduğu değerleri verir
                switch (tempSplit[i]) {
                    case "Circle" : { 
                        Shape temp = new Circle(Double.parseDouble(tempSplit[i+1]));
                        shapes[index] = temp;
                        break;
                        
                    }
                    case "Rectangle" : {
                        Shape temp1 = new Rectangle(Double.parseDouble(tempSplit[i+1]),Double.parseDouble(tempSplit[i+2]));
                        shapes[index] = temp1;
                        break;
                       
                    }
                    case "DikUcgen" : { 
                        Shape temp2 = new DikUcgen(Double.parseDouble(tempSplit[i+1]),Double.parseDouble(tempSplit[i+2]));
                        shapes[index] = temp2;
                        break;
                        
                    }
                    default : {
                    }
                }   
            }
            index++;   
        }
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Çevre uzunluğu toplamı= " + shape.cevreHesapla() + ", Alanı = " + shape.alanHesapla());
            //print sırasında shape in dik üçgen olma durumuna göre tangent metodu çağırılır 
            if (shape.getClass() == DikUcgen.class) {
                ((DikUcgen) shape).tangentValues();
            }
        }
    }    
}

