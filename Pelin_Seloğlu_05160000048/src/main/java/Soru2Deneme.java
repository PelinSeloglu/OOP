
import java.util.Random;
import java.util.Scanner;
interface Algoritma{ //algoritma interface'i
    public void sort(int [] a, int b, int c); //ortak sort metodu

}

class BS implements Algoritma{//bubble sort
    @Override
    public void sort(int [] a, int b, int c){
        for (int i = 0; i < b; i++){ 
            for (int j = 0; j < b-i-1; j++){ 
                if (a[j] > a[j+1]) {   
                    int temp = a[j]; 
                    a[j] = a[j+1]; 
                    a[j+1] = temp; 
                }
            }    
        }
    }  
}

class QS implements Algoritma{//quick sort
    
    int partition(int arr[], int low, int high){ 
        int pivot = arr[high];  
        int i = (low-1);  
        for (int j=low; j<high; j++) { 
            if (arr[j] < pivot){ 
                i++; 
                
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
    
    @Override
    public void sort(int [] a, int low, int high){
        if (low < high) { 
            int pi = partition(a, low, high); 
            sort(a, low, pi-1); 
            sort(a, pi+1, high); 
        }     
    } 
}

class IS implements Algoritma{//insertion sort
    @Override
    public void sort(int [] a, int b, int c){
        int i, key, j; 
        for (i = 1; i < b; i++) { 
            key = a[i]; 
            j = i - 1; 
            while (j >= 0 && a[j] > key) { 
                a[j + 1] = a[j]; 
                j = j - 1; 
            }
            a[j + 1] = key; 
        } 
    }    
}

class algoritmaType{ //factory design pattern için tip belirleme
    public Algoritma getType (String a){
        if(a == null){
            return null;
        }
        else if(a.equals("Bubble Sort")){
            return new BS();
        }
        else if(a.equals("Quick Sort")){
            return new QS();
        }
        else if(a.equals("Insertion Sort")){
            return new IS();
        }
        return null;
    }
}

public class Soru2Deneme {
    public static void print(int [] a){ //liste print metodu
        int n = a.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(a[i] + " "); 
        System.out.println("");
    }
    
    public static void main(String[] args) {
        
        Random r = new Random();
        int max = 100;
        int veri[] = new int [100];
        
        for(int i = 0; i < veri.length; i++){//random 100 elemanlı liste
            veri[i] = r.nextInt(max);   
        }
        //veri listesinin clone'larının oluşturulması

        algoritmaType at = new algoritmaType();
        boolean check = true;
        Scanner inScan = new Scanner(System.in);
        while(check){
            
            System.out.println("Sıralama metotları: 1 -> BubbleSort, 2 -> Quick Sort, 3 -> Insertion Sort");
            System.out.println("İstediğiniz metodun numarasını giriniz: ");
            String giris = inScan.nextLine();
        
            if("1".equals(giris)){
                int [] bs_veri = veri.clone();
                Algoritma bs = at.getType("Bubble Sort");
                System.out.println("Bubble sort işleminden önce veri listesi: ");
                print(bs_veri);
                System.out.println("Bubble sort ile sıralama işleminden sonra veri listesi: ");
                long bs_start = System.nanoTime();
                bs.sort(bs_veri, bs_veri.length-1, 0);
                long bs_end = System.nanoTime();
                print(bs_veri);
                System.out.println("Bubble sort için harcanan süre: " + (bs_end - bs_start));
            }
            
            else if("2".equals(giris)){
                int [] qs_veri = veri.clone();
                Algoritma qs = at.getType("Quick Sort");
                System.out.println("Quick sort işleminden önce veri listesi: ");
                print(qs_veri);
                System.out.println("Quick sort ile sıralama işlemi:");
                long qs_start = System.nanoTime();
                qs.sort(qs_veri, 0, qs_veri.length-1);
                long qs_end = System.nanoTime();
                print(qs_veri);
                System.out.println("Quick sort için harcanan süre: " + (qs_end - qs_start));
            }
            
            else if("3".equals(giris)){
                int [] is_veri = veri.clone();  
                Algoritma is = at.getType("Insertion Sort");
                System.out.println("Insertion sort işleminden önce veri listesi: ");
                print(is_veri);
                System.out.println("Insertion sort ile sıralama işleminden sonra veri listesi: ");
                long is_start = System.nanoTime();
                is.sort(is_veri, is_veri.length, 0);
                long is_end = System.nanoTime();
                print(is_veri);
                System.out.println("Insertion sort için harcanan süre: " + (is_end - is_start));
            }
            
            System.out.println("Tekrar denemek ister misiniz? (e/h)");
            String cevap = inScan.nextLine();
            
            if(cevap.equals("e")){
                continue;
            }
            else{
                break;
            }
        }    
    }    
}
