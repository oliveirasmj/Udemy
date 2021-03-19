package ttt;

public class Teste {

    public static void main(String[] args) {
        Turma t = new Turma();
        t.novoAluno("Mike", 83816);
        t.novoAluno("Carlos", 83816);
        t.novoAluno("Pedro", 83817);
        /*t.listaAlunosFE();
        t.removerAluno(83816);
        t.listaAlunosFE();*/
        
        t.listaAlunosNomeF("Mike");
    }
    
}
