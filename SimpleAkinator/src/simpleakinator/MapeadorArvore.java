package simpleakinator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;

public class MapeadorArvore {
    private HashMap<String, BTree> cacheArvore = new HashMap<>();
    private final String filename = "arvre.nozes";

    public MapeadorArvore(){
        this.load();
    }

    public BTree get(){
        return cacheArvore.get(cacheArvore.keySet().toArray()[0]);
    }

    public void put(BTree arvore){
        if(cacheArvore.size() == 0){
            cacheArvore.put("Arvore de elementos", arvore);
        } else {
            cacheArvore.replace("Arvore de elementos", arvore);
        }
        persist();
    }

    public void persist(){
        try {
            FileOutputStream fOut = new FileOutputStream(filename); 
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(cacheArvore);

            oOut.flush();
            fOut.flush();

            oOut.close();
            fOut.close();

        } catch (FileNotFoundException ex){
            System.out.println(ex);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    public void load(){
        try {
            FileInputStream fIn = new FileInputStream(filename);
            ObjectInputStream oIn = new ObjectInputStream(fIn);

            this.cacheArvore = (HashMap) oIn.readObject();

            oIn.close();
            fIn.close();

        } catch (FileNotFoundException ex){
            System.out.println("Deve ser sua primeira vez jogando por que não achei nenhum dado... não tema, criarei dados iniciais pra voce!");
        this.persist();
        } catch (ClassNotFoundException | IOException ex){
            System.out.println("Deve ser sua primeira vez jogando por que não achei nenhum dado... não tema, criarei dados iniciais pra voce!");
        }
    }

    public Collection getList(){
        return this.cacheArvore.values();
}
    
}
