package simpleakinator;

import java.io.Serializable;

/**
 * Classe Node são os nós e folhas da árvore binária, elas possuem tipo (que pode ser pergunta (galho) ou elemento (folha)) 
 * e conteudo, que pode ser o elemento ou a pergunta, além dos Nodes esquerda e direita.
 * 
 */
public class Node implements Serializable{
    private String type;
    private String conteudo;
    private Node esq;
    private Node dir;
    
    public Node(String type) {
        this.type = type;
    }
    
    public Node(String type, String conteudo, Node dir, Node esq) {
        this.type = type;
        this.conteudo = conteudo;
        this.dir = dir;
        this.esq = esq;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Node getEsq() {
        return esq;
    }

    public void setEsq(Node esq) {
        this.esq = esq;
    }

    public Node getDir() {
        return dir;
    }

    public void setDir(Node dir) {
        this.dir = dir;
    }
    
    
}
