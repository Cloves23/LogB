import java.io.FileWriter;  
import java.io.File;  
import java.io.IOException;  
import pacote.telas.Analises;
  
class Teste {  
    
    Analises a = new Analises();
    
    public static void main(String[] args) {  
        String textoQueSeraEscrito = "Texto que sera escrito.";  
          
        FileWriter arquivo;  
          
        try {  
            arquivo = new FileWriter(new File("/Documentos:Arquivo.txt"));  
            arquivo.write(textoQueSeraEscrito);  
            arquivo.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        
    }  
}  