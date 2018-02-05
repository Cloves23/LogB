/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author Merky
 */

import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import pacote.classes.CMetodos;
import pacote.telas.Analises;


public class Teste {
    
    ArrayList<String> arrayObjetivos = new ArrayList<String> ();
    ArrayList<String> arraySuposicao = new ArrayList<String> ();
    ArrayList<String> arrayInformGeral = new ArrayList<String> ();
    String s, s1,o, o1,r;
    String analisador, protocolo,emissor,receptor;
    JList<String> l;
    int tam = 0;
    
    String sup1,sup2,res,obj;
    
    
    CMetodos m = new CMetodos();
       
       boolean r1a; 
       
       int tamOb = arrayObjetivos.size();
       int tamS = arraySuposicao.size();
       
       
       
       
       String getResultado(int i, int u, int o){
           
           String ii = Integer.toString(u+1);
           String iii = Integer.toString(o+1);
                   
       
           return "Objetivo: "+Integer.toString(i+1)+": "+ii + "e"+ iii;
       
       }
       
       
    
    void teste(){
        
        
        
            CMetodos m = new CMetodos();
       
             
       
             int tamOb = arrayObjetivos.size();
             int tamS = arraySuposicao.size();
             
        while(tam<tamOb){
            obj = arrayObjetivos.get(tam);
            for(int a = 0; a<tamS;a++){
                for(int s = a+1; s<tamS;s++){
                   r1a = m.regra1a(arraySuposicao.get(a),arraySuposicao.get(s)); //"p◄{x}k", "p⊨(q↔kp)"
                  // JOptionPane.showMessageDialog(null, r1a);
                   if(r1a == true){

                       res = m.getR1ac();
                       if(res.equals(obj)){

                           r = getResultado(tam,arraySuposicao.indexOf(arraySuposicao.get(a)), arraySuposicao.indexOf(arraySuposicao.get(s)));
                           JOptionPane.showMessageDialog(null, r);
                           tam++;}
                       else
                       {
                           //obj = arrayObjetivos.get(tam);
                           for(int b = 0; b<tamS;b++){
                                for(int i = b+1; i<tamS;i++){
                                   r1a = m.regra1b(arraySuposicao.get(b),arraySuposicao.get(i)); //"p◄{x}k", "p⊨(q↔kp)"
                                  // JOptionPane.showMessageDialog(null, r1a);
                                   if(r1a == true){

                                       res = m.getR1ac();
                                       if(res.equals(obj)){

                                           r = getResultado(tam,arraySuposicao.indexOf(arraySuposicao.get(b)), arraySuposicao.indexOf(arraySuposicao.get(i)) );
                                           JOptionPane.showMessageDialog(null, r);
                                           tam++;}
                                       else
                                       {

                                          // obj = arrayObjetivos.get(tam);
                                           for(int c = 0; c<tamS;c++){
                                                for(int u = c+1; u<tamS;u++){
                                                   r1a = m.regra1c(arraySuposicao.get(c),arraySuposicao.get(u)); //"p◄{x}k", "p⊨(q↔kp)"
                                                  // JOptionPane.showMessageDialog(null, r1a);
                                                   if(r1a == true){

                                                       res = m.getR1ac();
                                                       if(res.equals(obj)){

                                                           r = getResultado(tam,arraySuposicao.indexOf(arraySuposicao.get(c)), arraySuposicao.indexOf(arraySuposicao.get(u)) );
                                                           JOptionPane.showMessageDialog(null, r);
                                                           tam++;}
                                                       else
                                                       {

                                                           //obj = arrayObjetivos.get(tam);
                                                            for(int d = 0; d<tamS;d++){
                                                                for(int j = d+1; j<tamS;j++){
                                                                   r1a = m.regra2(arraySuposicao.get(d),arraySuposicao.get(j)); //"p◄{x}k", "p⊨(q↔kp)"
                                                                  // JOptionPane.showMessageDialog(null, r1a);
                                                                   if(r1a == true){

                                                                       res = m.getR1ac();
                                                                       if(res.equals(obj)){

                                                                           r = getResultado(tam,arraySuposicao.indexOf(arraySuposicao.get(d)), arraySuposicao.indexOf(arraySuposicao.get(j)) );
                                                                           JOptionPane.showMessageDialog(null,  r);
                                                                           tam++;}
                                                                       else
                                                                       {

                                                                          // obj = arrayObjetivos.get(tam);
                                                                           
                                                                            for(int f = 0; f<tamS;f++){
                                                                                for(int l = f+1; l<tamS;l++){
                                                                                   r1a = m.regra3(arraySuposicao.get(f),arraySuposicao.get(l)); //"p◄{x}k", "p⊨(q↔kp)"
                                                                                  // JOptionPane.showMessageDialog(null, r1a);
                                                                                   if(r1a == true){

                                                                                       res = m.getR1ac();
                                                                                       if(res.equals(obj)){

                                                                                           r = getResultado(tam,arraySuposicao.indexOf(arraySuposicao.get(f)), arraySuposicao.indexOf(arraySuposicao.get(l)));
                                                                                           JOptionPane.showMessageDialog(null,  r);
                                                                                           tam++;}
                                                                                       else
                                                                                       {


                                                                                       }
                                                                                   } 
                                                                               }  
                                                                                
                                                                            }


                                                                        }
                                                                    } 
                                                                } 
                                                            }

                                                        }
                                                    } 
                                                }
                                            }


                                        }
                                    } 
                                }
                            }

                        }
                    }
                   
                }
            }  

        }
    }
                    




    public static void main(String args[]) {

        
        
            Teste t = new Teste();
            
            t.arrayObjetivos.add("P⊨Q⊢x");
            t.arrayObjetivos.add("P⊨q⊨x");
            
            
            t.arraySuposicao.add("P⊨(Q↔kP)");
            t.arraySuposicao.add("P◄{x}k");
            t.arraySuposicao.add("P⊨→kQ");
            t.arraySuposicao.add("P◄{x}k-1");
            t.arraySuposicao.add("P⊨Q↔yP");
            t.arraySuposicao.add("P◄<x>y");
            t.teste();
   
    
    }

}