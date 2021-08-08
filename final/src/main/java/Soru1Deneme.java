import java.io.*; 
import java.util.Arrays;

//buffer clasının yapılması
class Buffers {
    int matrix1Satir;
    int matrix2Sütün;
    public int [][] sonucMatrix;

    Buffers(int matrix1Satir, int matrix2Sütün){ //bufferın sonuçmatrix oluşturma constructor'ı 
        this.matrix1Satir = matrix1Satir;
        this.matrix2Sütün = matrix2Sütün;
        this.sonucMatrix = new int [matrix1Satir][matrix2Sütün];
    }

    // ilgili iş parçasının sonucunu matrisin ilgili kısmına koyar put() metodu 
    public synchronized void put(int [] a, int b){//kısmi satırdan gelen değerleri teker teker yerlerine yazması gerekmekte. 
        for(int m = 0; m<a.length; m++){   
            sonucMatrix[b][m] = a[m];
        } 
        
    }

    public void print(){ //sonuçMatrix'in yazdırılma methodu
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){    
        }
        for (int i = 0; i < matrix1Satir; i++){
            for(int j = 0; j < matrix2Sütün; j++){
                System.out.print(sonucMatrix[i][j]+ "\t");
            }
            System.out.println("");   
        } 
    }
}

//thread
class MultiplyWorker extends Thread{
    Buffers buffer;
    int matrix1satir [];
    int matrix2 [][];
    int i; 
    
    
    MultiplyWorker(Buffers buffer, int matrix1satir [], int matrix2 [][], int i){
        this.buffer = buffer;
        this.matrix1satir = matrix1satir;
        this.matrix2 = matrix2;
        this.i = i;
    }

    @Override
    public void run(){//bufferin put() metodunu kullanmalı 
        int toplam = 0; int sayac = 0;
        int ikinciM [][]= new int [matrix2[0].length][matrix2.length];//ilk matrisle çarpabilmek
        int kismiSatir [] = new int [ikinciM.length];                 //için matris düzeltildi
        int ct1; int ct2 = 0;                                               
        for(ct1 = 0; ct1<matrix2[0].length; ct1++) {
            for (int[] n : matrix2) {
                ikinciM[ct1][ct2++] = n[ct1];
            }
            ct2 = 0;
        }
        for(int[] n:ikinciM){//çarpma işleminden sonra oluşacak yeni değerler geçici bir satıra yazıldı.
            for (int k = 0; k < matrix1satir.length; k++){
                toplam += n[k]*matrix1satir[k];    
            }
            kismiSatir[sayac++] = toplam;
            toplam = 0;
        }
        buffer.put(kismiSatir, i);//en son satır olacak üstüne işlem kodu gelecek 
    }     
}

public class Soru1Deneme{ 
    //matrix file okuma, ve matrix oluşturma metodu
    public static int [][] MatrixRead(File file) throws FileNotFoundException, IOException{ 
        int mat_row = 0;
        
        BufferedReader br = new BufferedReader(new FileReader(file));//matrixin okunması
        StringBuilder data = new StringBuilder();
        String line1 = br.readLine();
        
        while (line1 != null) { 
            data.append(line1).append("\n"); 
            line1 = br.readLine();
            mat_row++; // matrixin satır sayısının belirlenmesi
        }
        
        String fileAsString1 = data.toString();
        String temp [] = fileAsString1.split("\n");
        int mat1_col = (temp[0].length()+1) / 2; //matrixin sütun sayısı 

        int matrix [][] = new int [mat_row][mat1_col];
        for (int i = 0; i < mat_row; i++){ //matrixin değerlerinin atılması
            String temp_mat1[] = temp[i].split(" ");
            for (int j = 0; j < mat1_col; j++){
                matrix[i][j] = Integer.parseInt(temp_mat1[j]);
            }
        }
        return matrix;
    }
    
    //soru1 main metodu
    public static void main(String args[]) throws FileNotFoundException, IOException{  
        
        File file1 = new File("matrix1.txt");
        File file2 = new File("matrix2.txt");
        
        int matrix1 [][] = MatrixRead(file1);
        int matrix2 [][] = MatrixRead(file2);
        
        Buffers Matrix = new Buffers(matrix1.length, matrix2[0].length);
        
        for(int i = 0; i < matrix1.length; i++){
            new MultiplyWorker(Matrix, matrix1[i], matrix2, i).start();
        }
        Matrix.print();    
    }  
}  



