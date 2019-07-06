package simpleakinator;

import java.util.Scanner;

public class GameHost {
    
    private MapeadorArvore mapArv;
    private BTree data;
    private Scanner usuario;
    
    public GameHost() {
        try {
            this.mapArv = new MapeadorArvore();
        } catch (Exception e){
            System.out.println(e);
        }
        try { 
            data = this.mapArv.get(); 
        } catch (Exception e) { 
            data = new BTree(); 
        }
        this.usuario = new Scanner(System.in);
    }

    public void play() {
        System.out.println("BEM VINDO AO AKINATOR (simplificado)!");
        System.out.println("Nesse jogo voce pensará em alguma coisa, qualquer coisa, e eu tentarei adivinhar, com perguntas de sim ou não, preparado(a)?");
        System.out.println("============================================================================================================================");
        System.out.println(" ");
        System.out.println("S. sim");
        System.out.println("N. nao");
        System.out.print("> ");
        processarPrimeiraPergunta(usuario.nextLine());
        mapArv.put(data);
    }
    
    private void processarPrimeiraPergunta(String resposta){
        switch(resposta.toLowerCase()){
            case "s"  : System.out.println("Ótimo, vamos começar.");
                        jogar(data.getRaiz(), data.getRaiz());
                        break;
            case "sim": System.out.println("Ótimo, vamos começar.");
                        jogar(data.getRaiz(), data.getRaiz());
                        break;
            case "n"  : System.out.print("Tudo bem... eu espero.");
                        espera();
                        System.out.println("Pensou?");
                        System.out.print("> ");
                        processarPrimeiraPergunta(usuario.nextLine());
                        break;
            case "nao": System.out.print("Tudo bem... eu espero.");
                        espera();
                        System.out.println("Pensou?");
                        System.out.print("> ");
                        processarPrimeiraPergunta(usuario.nextLine());
                        break;
            default:    System.out.println("Foi mal, não entendi, nao se esqueça: S para sim e N para não.");
                        System.out.print("> ");
                        processarPrimeiraPergunta(usuario.nextLine());
                        break;
        }
    }
    
    private void espera(){
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.print(".");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.print(".");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.print(".");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        System.out.print(".");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
    }

    private void jogar(Node nodeAtual, Node nodeAnterior) {
        if(nodeAtual == null) {
            System.out.println("Parece que voce me pegou, não consegui adivinhar o que voce pensou, o que era? (entre apenas um nome, tipo 'baleia' ou 'carro')");
            System.out.print("> ");
            String nomeDoNovoElemento = usuario.nextLine();
            System.out.println("Aaata, me diz uma característica de " + nomeDoNovoElemento + " que o(a) diferencia de todas as perguntas que eu fiz. (por exemplo: 'é aquatico', 'toca guitarra')");
            System.out.print("> ");
            String caracteristicaDoNovoElemento = usuario.nextLine();
            System.out.println("Beleza, perai que eu vou salvar isso rapidinho.");
            data.inserir(nodeAnterior, new Node("pergunta", caracteristicaDoNovoElemento + "?", null, null), new Node("elemento", nomeDoNovoElemento, null, null));
            System.out.println("Beleza, anotado, quer jogar denovo?");
            System.out.print("> ");
            processarPerguntaFinal(usuario.nextLine().toLowerCase());
        } else if(nodeAtual.getType().equals("pergunta")){
            System.out.println(nodeAtual.getConteudo());
            System.out.print("> ");
            processarPergunta(usuario.nextLine().toLowerCase(), nodeAtual);
        } else if(nodeAtual.getType().equals("elemento")) {
            System.out.println("ACERTEI! quer jogar denovo?");
            System.out.print("> ");
            processarPerguntaFinal(usuario.nextLine().toLowerCase());
        }
       
    }
    
    private void processarPerguntaFinal(String resposta){
        switch(resposta){
            case "s"  : System.out.println("Denovo então!");
                        mapArv.put(data);
                        jogar(data.getRaiz(), data.getRaiz());
                        break;
            case "sim": System.out.println("Denovo então!");
                        mapArv.put(data);
                        jogar(data.getRaiz(), data.getRaiz());
                        break;
            case "n"  : System.out.println("Até a proxima então, obrigado por jogar!");
                        break;
            case "nao": System.out.println("Até a proxima então, obrigado por jogar!");
                        break;
            default:    System.out.println("Foi mal, não entendi, nao se esqueça: S para sim e N para não.");
                        System.out.print("> ");
                        processarPerguntaFinal(usuario.nextLine().toLowerCase());
                        break;
        }
    }
    
    private void processarPergunta(String resposta, Node nodeAtual){
        switch(resposta){
            case "s"  : jogar(nodeAtual.getDir(), nodeAtual);
                        break;
            case "sim": jogar(nodeAtual.getDir(), nodeAtual);
                        break;
            case "n"  : jogar(nodeAtual.getEsq(), nodeAtual);
                        break;
            case "nao": jogar(nodeAtual.getEsq(), nodeAtual);
                        break;
            default:    System.out.println("Foi mal, não entendi, nao se esqueça: S para sim e N para não.");
                        System.out.print("> ");
                        processarPergunta(usuario.nextLine().toLowerCase(), nodeAtual);
                        break;
        }
    }
        
    
}
