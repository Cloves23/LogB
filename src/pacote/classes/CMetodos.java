/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote.classes;

//import javax.swing.JOptionPane;

import javax.swing.JOptionPane;
import pacote.telas.Analises;

//import org.w3c.dom.ranges.RangeException;


/**
 *
 * @author Merky
 */
public class CMetodos {
    
    String r1ac, r1bc, r1c,  r2, r3, r4, r5, r6, r7, r8;
    
    //CMetodos(){};

    public String getR1ac() {
        return r1ac;
    }

    public String getR1bc() {
        return r1bc;
    }

    public String getR1c() {
        return r1c;
    }

    public String getR2() {
        return r2;
    }

    public String getR3() {
        return r3;
    }
    public String getR4() {
        return r4;
    }
    public String getR5() {
        return r5;
    }
    public String getR6() {
        return r6;
    }
    public String getR7() {
        return r7;
    }
    public String getR8() {
        return r8;
    }
    /*
    //Pesquisa se uma palavra existe no texto
		palavra = "Hello World Java".matches(".*Java.*");
		System.out.println(palavra);
    
    */
    
    
    
        
     
    //Metodo para retornar o valor da chave da suposição
    //=====================================================================================================
    public String retornaChave(int localC, String a, String ch){// localC- indice da chave
                                                                // string a - suposição
                                                                // ch - tamanho da chave
        char aux1;
        String aux;
          int cha, cont;
          if(a.matches("→") || a.matches("↔")|| a.matches("⇔")|| a.matches("}") || a.matches(">")){
              
                cha = Integer.parseInt(ch);
               cont = localC;
              
               aux1  = a.charAt(cont); aux = Character.toString(aux1);
               while(cha>1){
                   
                  
                    aux  = aux+ a.charAt(cont+1);
                    cont++;
                    cha--;
                  
              }
              return aux;  
          }
          else{
              return "";
          }
        
    }
    
    //===========================================================================================================
     public boolean regra1a(String a, String b) {
        
          
         int ta = a.length(), tb = b.length();
         boolean i = a.equals(b);
         
            // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
       boolean b1 = false;
       boolean b2 = false;
       // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P |= ( Q <->k P ) , P <| {x}k ou b) P <| {x}k , P |= ( Q <->k P ). logo c = 1-->a e c=2-->b.

       int c = 0;
        String j = " ";
        
      // realizacao da comparacao
       
      try{
       if(a.charAt(1) == '⊨' && a.charAt(2)== '(' && a.charAt(4) == '↔'&& a.charAt(ta-1)== ')'){
           
           b1 = true;
           c = 1;
           
       }
       else if(a.charAt(1) == '◄' && a.charAt(2) == '{' && a.charAt(4) == '}'){

           b2 = true;
           c = 2;
           
       }
       else{

           b1 =  false;
       } 

      

       if(b.charAt(1) == '⊨' && b.charAt(2)== '(' && b.charAt(4) == '↔'&& b.charAt(tb-1)== ')'){

          
           b1 = true; 
           c = 2;
       }
       else if(b.charAt(1) == '◄' && b.charAt(2) == '{' && b.charAt(4) == '}'){

           b2 = true;
           c = 1;
       }  
       else{

              b2 = false;  
       } 
        }catch(StringIndexOutOfBoundsException e){
            return false;
        
        }
      
      // pegando as chaves
      
         
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if ( !i == true && b1 == b2 == true && a.charAt(0)==b.charAt(0) && a.charAt(ta-3)== b.charAt(tb-1) && c == 1){
           r1ac =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ Character.toString(a.charAt(3)) + "⊢" + Character.toString(b.charAt(tb-3));
           
           return true;}
       if (!i == true && b1 == b2 == true && a.charAt(0)==b.charAt(0) && a.charAt(ta-1)== b.charAt(tb-3) && c==2){
            r1ac = Character.toString(a.charAt(0))+ Character.toString(b.charAt(1))+  Character.toString(b.charAt(3)) + "⊢" +Character.toString(a.charAt(ta-3));
            return  true;}

       
       else{return false;}
      }catch(StringIndexOutOfBoundsException u){
           return false;
       }
     
     }
     
       //@Override
       public boolean regra1b(String a, String b) {

           int tsa = a.length();
           int tsb = b.length();
         boolean i = a.equals(b);
        //funcao para avaliar a semantica das duas suposicoes.
        
  
       // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
        boolean b1 = false ;
        boolean b2 = false;
       //se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P |= ->k Q e P <| {x}k-1 ou b) P <| {x}k-1 e P |= ->k Q. logo c = 1-->a e c=2-->b.

        int c = 0;

        // realizacao da comparacao
        
        try{
        if(a.charAt(1) == '⊨' && a.charAt(2) == '→' && a.charAt(0) != a.charAt(tsa-1)){ 

            b1 = true;
            c = 1;}
        
       else if(a.charAt(1) == '◄' && a.charAt(2) == '{' && a.charAt(4) == '}'&& a.charAt(tsa-2) == '-' &&  a.charAt(tsa-1) == '1' ){
                 
            b2 = true;
            c = 2;}
        
        else{ 

            b1 =  false;
        }

        if(b.charAt(1) == '⊨' && b.charAt(2) == '→' && b.charAt(0) != b.charAt(4)){ 
            
            b1 = true ;
            c = 2   ;}
        
        else if(b.charAt(1) == '◄' && b.charAt(2) == '{'&&  b.charAt(4) == '}' && b.charAt(tsb-2) == '-' &&  b.charAt(tsb-1) == '1' ){ 

            b2 = true;
            c = 1;}
        
        else{ 

            b2 = false;}

        }catch(StringIndexOutOfBoundsException t){
            return false;
        }
        
        // E por fim se os dois retornos forem 'True' quer dizer que as duas suposicoes satisfazem a regra
        try{
        if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0) && a.charAt(tsa-2) == b.charAt(tsb-3) && c == 1){
            r1bc = Character.toString(a.charAt(0))+Character.toString(a.charAt(1))+Character.toString(a.charAt(4))+"⊢"+Character.toString(b.charAt(3));
            return true; 
       }

        if (i == false && b1 == b2 == true && a.charAt(0)== b.charAt(0) && a.charAt(tsa-3) == b.charAt(tsb-2) && c == 2){
            r1bc = Character.toString(a.charAt(0))+Character.toString(b.charAt(1))+Character.toString(b.charAt(4))+"⊢"+Character.toString(a.charAt(3));
            return true;  
        }

        else{
            return false;  } 
        
       }catch(StringIndexOutOfBoundsException h){
            return false;
        }



       }          

       //@Override
       public boolean  regra1c(String a, String b) {
            int ts = a.length(), tsb = b.length();
     
            boolean i = a.equals(b);

              // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
             boolean b1 = true;
             boolean b2= true;
              // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P⊨Q↔yP e b)P◄<x>y ou a)P◄<x>y e b)P⊨Q↔yP. logo c = 1-->a e c=2-->b.

              int c = 0;
              //realizacao da comparacao
           
           
           try{
           if(a.charAt(1) == '⊨'  && a.charAt(3) == '⇔'&& a.charAt(0) == a.charAt(ts-1) && a.charAt(ts-2) == b.charAt(tsb-1)){

               b1 = true;
               c = 1;}

           else if(a.charAt(1) == '◄' && a.charAt(2) == '<'  && a.charAt(4) == '>'&& a.charAt(0) != a.charAt(ts-1)&& a.charAt(ts-1) == b.charAt(tsb-2)){
               b2 = true;
               c = 2;}

           else{ b1 =  false;}

           if(b.charAt(1) == '⊨' && b.charAt(3) == '⇔' && b.charAt(0) == b.charAt(tsb-1)&& b.charAt(tsb-2) == a.charAt(ts-1)){

               b1 = true;
               c = 2;}

           else if(b.charAt(1) == '◄' && b.charAt(2) == '<'  && b.charAt(4) == '>' && b.charAt(0) != b.charAt(tsb-1)&& b.charAt(tsb-1) == a.charAt(ts-2)){ 

               b2 = true;
               c = 1;}

           else{ b2 = false;}

           }catch(StringIndexOutOfBoundsException r){
               return false;
           }

          // E por fim se os dois retornos forem 'True' quer dizer que as duas suposicoes satisfazem a regra
           try{
           if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0) && c==1){
               r1c = Character.toString(a.charAt(0))+Character.toString(a.charAt(1))+Character.toString(a.charAt(2))+"⊢"+b.charAt(tsb-3);
               return true;
           }

          if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0) && c==2){
              r1c = Character.toString(a.charAt(0))+Character.toString(b.charAt(1))+Character.toString(b.charAt(2))+"⊢"+a.charAt(ts-3);
               return true;
                       
          }

          else{return false;}

           }catch(StringIndexOutOfBoundsException h){
               return false;
           }
            

       }

      // @Override
       public boolean regra2(String a, String b) {



           int ts = a.length(), tsb = b.length();
         boolean i = a.equals(b);//para mostrar que são suposições diferentes
        // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
        boolean b1 = false;
        boolean b2 = false;
        //se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P |= #(X) e P |= Q |~ X ou b) P |= Q |~ X e P |= #(X) . logo c = 1-->a e c=2-->b.

        int c = 0;

        // realizacao da comparacao
        try{
        if(a.charAt(1) == '⊨' && a.charAt(2) == '#' && a.charAt(3) == '(' &&  
                a.charAt(ts-1) == ')' && a.charAt(ts-2)== b.charAt(tsb-1)){
           
             
            b1 = true;
            c = 1;
        
        }

            
        else if(a.charAt(1) == '⊨' && a.charAt(ts-2) == '⊢'  && a.charAt(ts-1)== b.charAt(tsb-2)){
           
            b2 = true;
            c = 2;}

        else{b1 =  false;} 

            

        if(b.charAt(1) == '⊨' && b.charAt(2) == '#' && b.charAt(3) == '('  &&  
                b.charAt(5) == ')' && b.charAt(tsb-2)== a.charAt(ts-1) ){
            
            b1 = true;
            c = 2  ;
        } 

             
        else if(b.charAt(1) == '⊨' && b.charAt(3) == '⊢'  && b.charAt(tsb-1) == a.charAt(ts-2)){
            
           b2 = true;
           c = 1;
       } 

            
        else{b2 = false;} 

        }catch(StringIndexOutOfBoundsException r){
               return false;
           }
           

        
        // E por fim se os dois retornos forem 'True' quer dizer que as duas suposicoes satisfazem a regra
        try{
        if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0) && c==1){
           
            r2 = Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ Character.toString(b.charAt(2))+Character.toString(a.charAt(1))+ Character.toString(a.charAt(ts-2));
            return true;
        }

            

       if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0) && c==2){
           
           r2 = Character.toString(a.charAt(0))+ Character.toString(b.charAt(1))+ Character.toString(a.charAt(2))+Character.toString(b.charAt(1))+  Character.toString(b.charAt(tsb-2));
           return  true;
       }

            


       else{return false;}

       }catch(StringIndexOutOfBoundsException h){
               return false;
           }

       }

      // @Override
       public boolean regra3(String a, String b) {
        
           int ts = a.length(), tb = b.length();
            boolean i = a.equals(b);
            // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
            boolean b1 = true;
            boolean b2 = true;
            // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P⊨Q⇒x e P⊨Q⊨x ou b) P |= Q |= X e P |= Q => X. logo c = 1-->a e c=2-->b.

            int c = 0;
            
            // realizacao da comparacao
            try{
            if(a.charAt(1) == '⊨' && a.charAt(3) == '⇒' && a.charAt(ts-1) == b.charAt(tb-1) && a.charAt(0)!= a.charAt(2)){ 
                
                b1 = true;
                c = 1;}
            else if(a.charAt(1) == '⊨' && a.charAt(3) == '⊨' && a.charAt(ts-1) == b.charAt(tb-1) && 
                    a.charAt(0) != a.charAt(2)&& a.charAt(1)== a.charAt(3)){
                
                b2 = true;
                c = 2;}

            else{ b1 =  false;}

            if(b.charAt(1) == '⊨' && b.charAt(3) == '⇒' && b.charAt(tb-1) == a.charAt(ts-1)&& b.charAt(0)!= b.charAt(2)){ 
                
                b1 = true;
                c = 2 ;   }
            
            else if(b.charAt(1) == '⊨' && b.charAt(3) == '⊨' && b.charAt(tb-1) == a.charAt(ts-1)&&
                    b.charAt(0) != b.charAt(2)&& b.charAt(1)== b.charAt(3)){
                
                b2 = true;
                c = 1;}

            else{ b2 = false;}

            }catch(StringIndexOutOfBoundsException r){
               return false;
           }
            // E por fim se os dois retornos forem 'True' quer dizer que as duas suposicoes satisfazem a regra
            try{
            if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0) && c==1){
               
                r3 = Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ 
                        Character.toString(a.charAt(ts-1));
                return true;}

            if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0)&& c==2){
                
                r3 = Character.toString(a.charAt(0)) + Character.toString(b.charAt(1))+ 
                        Character.toString(a.charAt(ts-1));
                return true; 
            }

            else{return false;}

            }catch(StringIndexOutOfBoundsException h){
               return false;
           }

       }
       
       public boolean regra4a(String a, String b) {
        
           int ts = a.length(), tb = b.length();
           
            boolean i = a.equals(b);
           if(a.equals("0")  || b.equals("0")){
               return false;
           }else{
            
                try{
                if (!i == true && ts == 3 && ts == tb && a.charAt(0)== b.charAt(0) && a.charAt(1) == '⊨' && a.charAt(1) == b.charAt(1) ){

                    r4 = Character.toString(a.charAt(0)) + Character.toString(a.charAt(1))+ 
                             Character.toString('(')+ Character.toString(a.charAt(2))+ Character.toString(',')+
                            Character.toString(b.charAt(2))+ Character.toString(')');
                    return true;}

                else{return false;}

                }catch(StringIndexOutOfBoundsException h){
                   return false;
               }
            
           }

       }
       public boolean regra4b(String a, String b) {
         int ta = a.length(), tb = b.length();
        
       
         
            // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
       boolean b1 = false;
       boolean b2 = false;
       // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P |= ( Q <->k P ) , P <| {x}k ou b) P <| {x}k , P |= ( Q <->k P ). logo c = 1-->a e c=2-->b.

       int c = 0;
        
      // realizacao da comparacao
      try{
          if(!a.equals("0") && b.equals("0")){
           c = 1;
           if(ta == 7 && a.charAt(1) == '⊨'&&  a.charAt(2)== '(' && a.charAt(ta-1)== ')'&&
               a.charAt(ta-4) != a.charAt(ta-2)){
                b1 = true;
           }
            else{
               b1 = false;
            }
           
       }
       else if(a.equals("0") && !b.equals("0")){
           c = 2;
           
           if(tb == 7 && b.charAt(1) == '⊨'&&  b.charAt(2)== '(' && b.charAt(tb-1)== ')'&&
               b.charAt(tb-4) != b.charAt(tb-2)){

           
           b2 = true; 
           
            }
           else{
               b2 = false;
           }
           
       }
       else{
           
            if(ta == 7 && a.charAt(1) == '⊨'&&  a.charAt(2)== '(' && a.charAt(ta-1)== ')'&&
               a.charAt(ta-4) != a.charAt(ta-2)){
           
            
           
           b1 = true;}
            
            else if(tb == 7 && b.charAt(1) == '⊨'&&  b.charAt(2)== '(' && b.charAt(tb-1)== ')'&&
               b.charAt(tb-4) != b.charAt(tb-2)){

           
           b2 = true; 
           
            }
            else{
               b1 = false;
               b2 = false;
            }
       }
         
       
        }catch(StringIndexOutOfBoundsException e){
           return false;
        
        }
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if (b1  == true && c == 1){
           
           
           r4 =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ Character.toString(a.charAt(ta-4));
           
           return true;}
       if ( b2 == true && c==2){
          
            r4 =   Character.toString(b.charAt(0))+ Character.toString(b.charAt(1))+ Character.toString(b.charAt(tb-4));
            return  true;}

       
       else{return false;}
      }catch(StringIndexOutOfBoundsException u){
          return false;
        }
    
     }
       
       public boolean regra4c(String a, String b) {
         int ta = a.length(), tb = b.length();
        
       
         
            // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
       boolean b1 = false;
       boolean b2 = false;
       // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P|=Q(x,y). logo c = 1-->a e c=2-->b.

       int c = 0;
        
      // realizacao da comparacao
       
       try{
       if(!a.equals("0") && b.equals("0")){
           c = 1;
           if(ta == 9 && a.charAt(1) == '⊨' && a.charAt(1) == a.charAt(3)&&  a.charAt(4)== '(' && a.charAt(ta-1)== ')'&&
               a.charAt(ta-4) != a.charAt(ta-2)){
           
            
           
           b1 = true;
           

            }
            else{
               b1 = false;
            }
           
       }
       else if(a == "0" && b != "0"){
           c = 2;
           
           if(tb == 9 && b.charAt(1) == '⊨' && b.charAt(1) == b.charAt(3)&&  b.charAt(4)== '(' && b.charAt(tb-1)== ')'&&
               b.charAt(tb-4) != b.charAt(tb-2)){

           
           b2 = true; 
           
            }
           else{
               b2 = false;
           }
           
       }
       else{
           
            if(ta == 9 && a.charAt(1) == '⊨' && a.charAt(1) == a.charAt(3)&&  a.charAt(4)== '(' && a.charAt(ta-1)== ')'&&
               a.charAt(ta-4) != a.charAt(ta-2)){
           
            
           
           b1 = true;}
            
           if(tb == 9 && b.charAt(1) == '⊨' && b.charAt(1) == b.charAt(3)&&  b.charAt(4)== '(' && b.charAt(tb-1)== ')'&&
               b.charAt(tb-4) != b.charAt(tb-2)){

           
           b2 = true; 
           
            }
            else{
               b1 = false;
               b2 = false;
            }
       }
         
       
        }catch(StringIndexOutOfBoundsException e){
           return false;
        
        }
       //--------------------------------------------------------
      
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if (b1  == true && c == 1){
           
           
           r4 =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ Character.toString(a.charAt(2))+ Character.toString(a.charAt(3))+ 
                   Character.toString(a.charAt(ta-4)) ;
           
           return true;}
       if ( b2 == true && c==2){
          
            r4 =   Character.toString(b.charAt(0))+ Character.toString(b.charAt(1))+ Character.toString(b.charAt(2))+ Character.toString(b.charAt(3))+ 
                   Character.toString(b.charAt(tb-4));
            return  true;}

       
       else{return false;}
      }catch(StringIndexOutOfBoundsException u){
          return false;
        }
    
     }
    //@Override
    public boolean regra5(String a, String b) {
         int ta = a.length(), tb = b.length();
        
         
            // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
       boolean b1 = false;
       boolean b2 = false;
       // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P |= ( Q <->k P ) , P <| {x}k ou b) P <| {x}k , P |= ( Q <->k P ). logo c = 1-->a e c=2-->b.

       int c = 0;
        
      // realizacao da comparacao
       
       try{
       if(a != "0" && b == "0"){
           c = 1;
           if(a.charAt(1) == '⊨'&& a.charAt(3)== '⊢' && a.charAt(4)== '(' && a.charAt(ta-1)== ')'&&
               a.charAt(5) != a.charAt(ta-2)&& a.charAt(0) != a.charAt(2)){
           
            
           
           b1 = true;
           

            }
            else{
               b1 = false;
            }
           
       }
       else if(a == "0" && b != "0"){
           c = 2;
           
           if(b.charAt(1) == '⊨'&& b.charAt(3)== '⊢' && b.charAt(4)== '(' && b.charAt(tb-1)== ')'&&
               b.charAt(5) != b.charAt(tb-2)&& b.charAt(0) != b.charAt(2)){

           
           b2 = true; 
           
            }
           else{
               b2 = false;
           }
           
       }
       else{
           
            if(a.charAt(1) == '⊨'&& a.charAt(3)== '⊢' && a.charAt(4)== '(' && a.charAt(ta-1)== ')'&&
               a.charAt(5) != a.charAt(ta-2)&& a.charAt(0) != a.charAt(2)){
           
            
           
           b1 = true;}
            
           if(b.charAt(1) == '⊨'&& b.charAt(3)== '⊢' && b.charAt(4)== '(' && b.charAt(tb-1)== ')'&&
               b.charAt(5) != b.charAt(tb-2)&& b.charAt(0) != b.charAt(2)){

           
           b2 = true; 
           
            }
            else{
               b1 = false;
               b2 = false;
            }
       }
         
       
        }catch(StringIndexOutOfBoundsException e){
           return false;
        
        }
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if (b1  == true && c == 1){
           
           
           r5 =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ Character.toString(a.charAt(2))+
                   Character.toString(a.charAt(3))+ Character.toString(a.charAt(ta-4));
           
           return true;}
       if ( b2 == true && c==2){
           
            r5 =   Character.toString(b.charAt(0))+ Character.toString(b.charAt(1))+ Character.toString(b.charAt(2))+
                    Character.toString(b.charAt(3))+ Character.toString(b.charAt(tb-4));
            return  true;}

       
       else{return false;}
      }catch(StringIndexOutOfBoundsException u){
          return false;
        }
    
     }
    public boolean regra6a(String a, String b) {
         int ta = a.length(), tb = b.length();
        
       
         
            // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
       boolean b1 = false;
       boolean b2 = false;
       // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P |= ( Q <->k P ) , P <| {x}k ou b) P <| {x}k , P |= ( Q <->k P ). logo c = 1-->a e c=2-->b.

       int c = 0;
        
      // realizacao da comparacao
       
       try{
       if(a != "0" && b == "0"){
           c = 1;
           if(a.charAt(1) == '◄'&&  a.charAt(2)== '(' && a.charAt(ta-1)== ')'&&
               a.charAt(ta-4) != a.charAt(ta-2)){
           
            
           
           b1 = true;
           

            }
            else{
               b1 = false;
            }
           
       }
       else if(a == "0" && b != "0"){
           c = 2;
           
           if(b.charAt(1) == '◄'&&  b.charAt(2)== '(' && b.charAt(tb-1)== ')'&&
               b.charAt(tb-4) != b.charAt(tb-2)){

           
           b2 = true; 
           
            }
           else{
               b2 = false;
           }
           
       }
       else{
           
            if(a.charAt(1) == '◄'&&  a.charAt(2)== '(' && a.charAt(ta-1)== ')'&&
               a.charAt(ta-4) != a.charAt(ta-2)){
           
            
           
           b1 = true;}
            
           if(b.charAt(1) == '◄'&&  b.charAt(2)== '(' && b.charAt(tb-1)== ')'&&
               b.charAt(tb-4) != b.charAt(tb-2)){

           
           b2 = true; 
           
            }
            else{
               b1 = false;
               b2 = false;
            }
       }
         
       
        }catch(StringIndexOutOfBoundsException e){
           return false;
        
        }
       
      
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if (b1  == true && c == 1){
           
           
           r6 =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ Character.toString(a.charAt(ta-4));
           
           return true;}
       if ( b2 == true && c==2){
          
            r6 =   Character.toString(b.charAt(0))+ Character.toString(b.charAt(1))+ Character.toString(b.charAt(tb-4));
            return  true;}

       
       else{return false;}
      }catch(StringIndexOutOfBoundsException u){
          return false;
        }
    
     }
    
       public boolean regra6b(String a, String b) {
         int ta = a.length(), tb = b.length();
        
         
            // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
       boolean b1 = false;
       boolean b2 = false;
       // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P |= ( Q <->k P ) , P <| {x}k ou b) P <| {x}k , P |= ( Q <->k P ). logo c = 1-->a e c=2-->b.

       int c = 0;
        
      // realizacao da comparacao
       
       try{
       if(a != "0" && b == "0"){
           c = 1;
           if(a.charAt(1) == '◄'&& a.charAt(2)== '<' && a.charAt(ta-2)== '>' && a.charAt(ta-1)!= a.charAt(3)){
           
            
           
           b1 = true;
           

            }
            else{
               b1 = false;
            }
           
       }
       else if(a == "0" && b != "0"){
           c = 2;
           
           if(b.charAt(1) == '◄'&& b.charAt(2)== '<' && b.charAt(tb-2)== '>' && b.charAt(tb-1)!= b.charAt(3)){

           
           b2 = true; 
           
            }
           else{
               b2 = false;
           }
           
       }
       else{
           
            if(a.charAt(1) == '◄'&& a.charAt(2)== '<' && a.charAt(ta-2)== '>' && a.charAt(ta-1)!= a.charAt(3)){
           
            
           
           b1 = true;}
            
           if(b.charAt(1) == '◄'&& b.charAt(2)== '<' && b.charAt(tb-2)== '>' && b.charAt(tb-1)!= b.charAt(3)){

           
           b2 = true; 
           
            }
            else{
               b1 = false;
               b2 = false;
            }
       }
         
       
        }catch(StringIndexOutOfBoundsException e){
           return false;
        
        }
       
       
       
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if (b1  == true && c == 1){
           
          
           r6 =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ Character.toString(a.charAt(3));
           
           return true;}
       if ( b2 == true && c==2){
          
            r6 =   Character.toString(b.charAt(0))+ Character.toString(b.charAt(1))+ Character.toString(b.charAt(3));
            return  true;}

       
       else{return false;}
      }catch(StringIndexOutOfBoundsException u){
          return false;
        }
    
     }  
       
       public boolean regra6c(String a, String b) {
        
           int ts = a.length(), tb = b.length();
            boolean i = a.equals(b);
            // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
            boolean b1 = true;
            boolean b2 = true;
            // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a) p⊨q↔kp e b)p◄{x}k ou a)p◄{x}k e b)p⊨q↔kp . logo c = 1-->a e c=2-->b.

            int c = 0;
            
            // realizacao da comparacao
            try{
            if(a.charAt(1) == '⊨' && a.charAt(3) == '↔' && a.charAt(ts-1) == a.charAt(0) && a.charAt(0)!= a.charAt(2) && 
                    a.charAt(4)== b.charAt(tb-1)){ 
                
                b1 = true;
                c = 1;}
            else if(a.charAt(1) == '◄' && a.charAt(2) == '{' && a.charAt(4) == '}' && a.charAt(ts-1)== b.charAt(4)){
                
                b2 = true;
                c = 2;}

            else{ b1 =  false;}

            if(b.charAt(1) == '⊨' && b.charAt(3) == '↔' && b.charAt(tb-1) == b.charAt(0) && b.charAt(0)!= b.charAt(2) && 
                    b.charAt(4)== a.charAt(ts-1)){ 
                
                b1 = true;
                c = 2 ;   }
            
            else if(b.charAt(1) == '◄' && b.charAt(2) == '{' && b.charAt(4) == '}' && b.charAt(tb-1)== a.charAt(4)){
                
                b2 = true;
                c = 1;}

            else{ b2 = false;}

            }catch(StringIndexOutOfBoundsException r){
               return false;
          }
            // E por fim se os dois retornos forem 'True' quer dizer que as duas suposicoes satisfazem a regra
            try{
            if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0) && c==1){
               
                r6 = Character.toString(b.charAt(0))+ Character.toString(b.charAt(1))+ 
                        Character.toString(b.charAt(3));
                return true;}

            if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0)&& c==2){
                
                r6 = Character.toString(a.charAt(0)) + Character.toString(a.charAt(1))+ 
                        Character.toString(a.charAt(3));
                return true; 
            }

            else{return false;}

            }catch(StringIndexOutOfBoundsException h){
               return false;
           }

       }
       
       public boolean regra6d(String a, String b) {
        
           int ts = a.length(), tb = b.length();
           
            boolean i = a.equals(b);
            // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
            boolean b1 = true;
            boolean b2 = true;
            // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a) p⊨→kp e b)p◄{x}y ou a)p◄{x}y e b)p⊨→kp . logo c = 1-->a e c=2-->b.

            int c = 0;
            
            // realizacao da comparacao
            try{
            if(a.charAt(1) == '⊨' && a.charAt(2) == '→' && a.charAt(ts-1) == a.charAt(0) && 
                    a.charAt(3)== b.charAt(tb-1)){ 
               
                b1 = true;
                c = 1;}
            else if(a.charAt(1) == '◄' && a.charAt(2) == '{' && a.charAt(4) == '}' && a.charAt(ts-1)== b.charAt(3)){
               
                b2 = true;
                c = 2;}

            else{ b1 =  false;}

            if(b.charAt(1) == '⊨' && b.charAt(2) == '→' && b.charAt(tb-1) == b.charAt(0) && 
                    b.charAt(3)== a.charAt(ts-1)){ 
               
                b1 = true;
                c = 2 ;   }
            
            else if(b.charAt(1) == '◄' && b.charAt(2) == '{' && b.charAt(4) == '}' && b.charAt(tb-1)== a.charAt(3)){
                
                b2 = true;
                c = 1;}

            else{ b2 = false;}

            }catch(StringIndexOutOfBoundsException r){
               return false;
          }
            // E por fim se os dois retornos forem 'True' quer dizer que as duas suposicoes satisfazem a regra
            
           // JOptionPane.showMessageDialog(null,b1);
          // JOptionPane.showMessageDialog(null, b2);
            try{
            if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0) && c==1){
               
                r6 = Character.toString(b.charAt(0))+ Character.toString(b.charAt(1))+ 
                        Character.toString(b.charAt(3));
                return true;}

            if (!i == true && b1 == b2 == true && a.charAt(0)== b.charAt(0)&& c==2){
               
                r6 = Character.toString(a.charAt(0)) + Character.toString(a.charAt(1))+ 
                        Character.toString(a.charAt(3));
                return true; 
            }

            else{return false;}

            }catch(StringIndexOutOfBoundsException h){
               return false;
           }
            
       }
       
       public boolean regra7(String a) {
         int ta = a.length();
        
         
            // b1 e b2 avaliam a estrutura da suposição em relação os oeradores logicos e as variaveis, se b1 e b2 forem true, logo as duas suposições pertencem a regra.
       boolean b1 = false;
       boolean b2 = false;
       // se as duas suposições estiverem certas na estrutura, podem haver duas combinações de entrada: a)P |= ( Q <->k P ) , P <| {x}k ou b) P <| {x}k , P |= ( Q <->k P ). logo c = 1-->a e c=2-->b.

       int c = 0;
        
      // realizacao da comparacao
       
       try{
       if(a != "0"){
           c = 1;
           if(a.charAt(1) == '⊨'&& a.charAt(2)== '#' && a.charAt(ta-3)== '(' && a.charAt(ta-1)== ')'){
           JOptionPane.showMessageDialog(null, "entrou");
            
           
           b1 = true;
           

            }
            else{
               b1 = false;
            }
         
       }
       
        }catch(StringIndexOutOfBoundsException e){
           return false;
        
        }
       
       
       
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if (b1  == true ){
           
          
           r7 =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ Character.toString(a.charAt(2))+ Character.toString(a.charAt(3))+ Character.toString(a.charAt(ta-2))+","+"y"+ Character.toString(a.charAt(ta-1));
           
           return true;
       }else{return false;}
       
      }catch(StringIndexOutOfBoundsException u){
          return false;
        }
    
     }  
       
       public boolean regra8a(String a, String chave) {
         int ta = a.length();
        
         
       boolean b1 = false;
      
        
      // realizacao da comparacao
       
       try{
       if(a != "0"){
           
           if(a.charAt(1) == '⊨'&& a.charAt(0)!= a.charAt(ta-1) && a.charAt(0)!= a.charAt(2)
                   && a.charAt(ta-1)!= a.charAt(2)&& a.charAt(3) == '↔'){
           
            
           System.out.println("ENTROU 1");
           b1 = true;
           

            }
            else{
               b1 = false;
            }
           
       }
       
         
       
        }catch(StringIndexOutOfBoundsException e){
           return false;
        
        }
       
       
       
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if (b1  == true){
           
          
           r8 =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+  
                   Character.toString(a.charAt(ta-1))+Character.toString(a.charAt(3))+chave+
                   Character.toString(a.charAt(2));
           System.out.println("ENTROU B1");
           return true;}
      
       else{return false;}
       
      }catch(StringIndexOutOfBoundsException u){
          return false;
        }
    
     }  

       
       public boolean regra8b(String a, String chave) {
         int ta = a.length();
        
        boolean b1 = false;
      
      // realizacao da comparacao
       
       try{
       if(a != "0" ){
          
           if(a.charAt(1) == '⊨'&&a.charAt(3) == '⊨'
                   && a.charAt(0)!= a.charAt(4)&& a.charAt(0)!= a.charAt(2)&& a.charAt(0)!= a.charAt(ta-1)
                   && a.charAt(2)!= a.charAt(4)&& a.charAt(2)!= a.charAt(ta-1)
                   && a.charAt(4)!= a.charAt(ta-1) && a.charAt(5) == '↔'){
           
            
           
           b1 = true;
           

            }
            else{
               b1 = false;
            }
           
       }
     
       
        }catch(StringIndexOutOfBoundsException e){
           return false;
        
        }
       
       
       
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if (b1  == true ){
           
          
           r8 =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ 
                   Character.toString(a.charAt(2))+ Character.toString(a.charAt(3))+ 
                    Character.toString(a.charAt(ta-1))+Character.toString(a.charAt(5))+
                   chave +Character.toString(a.charAt(4));
           
           return true;}
      
       else{return false;}
      }catch(StringIndexOutOfBoundsException u){
          return false;
        }
    
     } 
       
       public boolean regra8c(String a, String chave) {
         int ta = a.length();
        
       boolean b1 = false;
      
      // realizacao da comparacao
       
       try{
       if(a != "0" ){
          
           if(a.charAt(1) == '⊨'
             && a.charAt(0)!= a.charAt(2)&& a.charAt(0)!= a.charAt(ta-1)&& 
                   a.charAt(2)!= a.charAt(ta-1)&&a.charAt(3) == '⇔'){
           
            
           
           b1 = true;
           

            }
            else{
               b1 = false;
            }
           
       }
      
        }catch(StringIndexOutOfBoundsException e){
           return false;
        
        }
       
       
       
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if (b1  == true ){
           
          
           r8 =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+
                   Character.toString(a.charAt(ta-1))+Character.toString(a.charAt(3))+
                   chave+Character.toString(a.charAt(2));
           
           return true;}
      

       
       else{return false;}
      }catch(StringIndexOutOfBoundsException u){
          return false;
        }
    
     }  
       
       public boolean regra8d(String a, String chave) {
         int ta = a.length();
        
        boolean b1 = false;
       
      // realizacao da comparacao
       
       try{
       if(a != "0"){
          
           if(a.charAt(1) == '⊨'&&a.charAt(3) == '⊨'
                   && a.charAt(0)!= a.charAt(4)&& a.charAt(0)!= a.charAt(2)&& a.charAt(0)!= a.charAt(ta-1)
                   && a.charAt(2)!= a.charAt(4)&& a.charAt(2)!= a.charAt(ta-1)
                   && a.charAt(4)!= a.charAt(ta-1)&& a.charAt(5) == '⇔'){
           
            
           
           b1 = true;
           

            }
            else{
               b1 = false;
            }
           
       }
      
       
        }catch(StringIndexOutOfBoundsException e){
           return false;
        
        }
       
       
       
       // E por fim se os dois retornos forem 'True' quer dizer que as duas suposições satisfazem a regra
       try{
       if (b1  == true ){
           
          
           r8 =   Character.toString(a.charAt(0))+ Character.toString(a.charAt(1))+ 
                   Character.toString(a.charAt(2))+ Character.toString(a.charAt(3))+ 
                    Character.toString(a.charAt(ta-1))+Character.toString(a.charAt(5))+
                   chave +Character.toString(a.charAt(4));
           
           return true;}
      

       
       else{return false;}
      }catch(StringIndexOutOfBoundsException u){
          return false;
        }
    
     }
       

       
       // boolean b = s.equals( String.valueOf(a.charAt(1) ) );

/**/

    /**
     *
     * @param args
     */
    
    /*
    public static void main(String args[]) {
        
         CMetodos  g = new CMetodos();
        // String i = Character.toString('0');
         boolean b = g.regra6d(  "p⊨→kp","p◄{x}k");
         JOptionPane.showMessageDialog(null, g.r6);
         JOptionPane.showMessageDialog(null, b);
       //"p⊨q⊨(x,y)"
       
    }*/
       }

      





