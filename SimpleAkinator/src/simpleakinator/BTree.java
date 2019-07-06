package simpleakinator;

import java.io.Serializable;

/** 
 * A classe BTree é uma arvore de grau 2 que contem elementos e perguntas que, ao caminhar pela arvore, levam aos elementos;
 * Sempre antes de chegar a um elemento, há um Node com uma pergunta chave (é o elemento?), exemplo:
 *      é uma pessoa? -(sim)-> é o de lucca? -(sim)-> Node contendo o de lucca
 * Isso permite um comportamento como: 
 *      é uma pessoa? -(sim)-> é o de lucca? -(nao)-> é mulher? -(sim)-> é cantora? -(sim)-> é a ivete sangalo? -(sim)-> Node contendo a ivete sangalo
**/
public class BTree implements Serializable{
    private Node raiz;
    
    public BTree(){
        geraArvoreInicial();
    }
    
    public Node getRaiz(){
        return this.raiz;
    }
    
    
//  Insere um novo elemento a partir de um ponto de inserção, com um Node contendo sua caracteristica, outro contendo sua pergunta chave (é elemento?), e outro contendo o elemento em si
    public void inserir(Node pontoDeInsersao, Node caracteristica, Node conteudo){
        Node aux = new Node("pergunta", "É o(a)/um(a) " + conteudo.getConteudo() + "?", conteudo, null);
        caracteristica.setDir(aux);
        pontoDeInsersao.setEsq(caracteristica);
    }
    
    
//  Cria uma árvore inicial com alguns poucos elementos
    public void geraArvoreInicial(){
        this.raiz = new Node("pergunta", "é uma pessoa?", null, null);
        Node ePessoa = new Node("pergunta", "é homem?", null, null);
        Node nEPessoa = new Node("pergunta", "é um animal?", null, null);
        raiz.setDir(ePessoa);
        raiz.setEsq(nEPessoa);
        Node eHomem = new Node("pergunta", "toca nos beatles?", null, null);
        ePessoa.setDir(eHomem);
        Node tocaNosBeatles = new Node("pergunta", "é o John Lenon?", new Node("elemento", "John Lenon", null, null), null);
        eHomem.setDir(tocaNosBeatles);
        Node eAnimal = new Node("pergunta", "é aquatico?", null, null);
        nEPessoa.setDir(eAnimal);
        Node eAquatico = new Node("pergunta", "é um golfinho?", new Node("elemento", "golfinho", null, null), null);
        eAnimal.setDir(eAquatico);
    }
}
