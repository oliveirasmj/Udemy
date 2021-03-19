package ttt;

import java.util.ArrayList;
import java.util.Iterator;

public class Turma {

    private ArrayList<Aluno> alunos;
    //private Aluno[] alunoss;

    public Turma() {
        alunos = new ArrayList<>();
    }

    public void novoAluno(String nome, int mecanografico) {
        Aluno a = new Aluno(nome, mecanografico);
        alunos.add(a);
    }

    public void listaAlunosFE() {
        for (Aluno a : alunos) {
            System.out.println(a.getNomeAluno() + " - " + a.getNumeroAluno() + " - " + a.getEstatutoAluno());
        }
    }

    public void removerAluno(int mecanografico) {
        // com iterator remove todos mesmo sendo iguais
        Iterator<Aluno> it = alunos.iterator();
        while (it.hasNext()) {
            Aluno a = it.next();
            if (a.getNumeroAluno() == mecanografico) {
                it.remove();
            }
        }
        /*for (Aluno a : alunos) {
            if (a.getNumeroAluno() == mecanografico) {
                alunos.remove(a);
                break;
            }
        }*/
    }

    public void listaAlunosNome(String nome) {
        int contador = 0;
        for (Aluno a : alunos) {
            if (a.getNomeAluno().equals(nome)) {
                System.out.println(a.getNomeAluno() + " - " + a.getNumeroAluno() + " - " + a.getEstatutoAluno());
                contador += 1;
            }
        }
        if (contador == 0) {
            System.out.println("Não existe nenhum nome indicado");
        }
    }

    public void listaAlunosNomeF(String nome) {
        int contador = 0;
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNomeAluno().equals(nome)) {
                System.out.println(i + " - " + alunos.get(i).getNomeAluno() + " - " + alunos.get(i).getNumeroAluno() + " - " + alunos.get(i).getEstatutoAluno());
                contador += 1;
            }
        }
        if (contador == 0) {
            System.out.println("Não existe nenhum nome indicado");
        }
    }

    public void procuraAluno(int nMec) {
        int contador = 0;
        for (Aluno a : alunos) {
            if (a.getNumeroAluno() == nMec) {
                System.out.println(a.getNomeAluno() + " - " + a.getNumeroAluno() + " - " + a.getEstatutoAluno());
                contador += 1;
            }
        }
        if (contador == 0) {
            System.out.println("Não existe nenhum aluno com esse numero indicado");
        }
    }

    public void procuraAlunoI(int nMec) {
        int contador = 0;
        Iterator<Aluno> it = alunos.iterator();
        while (it.hasNext()) {
            Aluno a = it.next();
            if (a.getNumeroAluno() == nMec) {
                System.out.println(a.getNomeAluno() + " - " + a.getNumeroAluno() + " - " + a.getEstatutoAluno());
                contador += 1;
            }
        }
        if (contador == 0) {
            System.out.println("Não existe nenhum aluno com esse numero indicado");
        }
    }

    public void removerAlunoI(int nMec) {
        // com iterator remove todos mesmo sendo iguais
        Iterator<Aluno> it = alunos.iterator();
        while (it.hasNext()) {
            Aluno a = it.next();
            if (a.getNumeroAluno() == nMec) {
                it.remove();
            }
        }
    }
    
    public void listaAlunosI(int nMec) {
        // com iterator remove todos mesmo sendo iguais
        Iterator<Aluno> it = alunos.iterator();
        while (it.hasNext()) {
            Aluno a = it.next();
            System.out.println(a.getNomeAluno() + " - " + a.getNumeroAluno() + " - " + a.getEstatutoAluno());
        }
    }
    
    public void listaAlunosNomeI (String nome) {
        // com iterator remove todos mesmo sendo iguais
        Iterator<Aluno> it = alunos.iterator();
        while (it.hasNext()) {
            Aluno a = it.next();
            if (a.getNomeAluno().contains(nome.toLowerCase())) {
                System.out.println(a.getNomeAluno() + " - " + a.getNumeroAluno() + " - " + a.getEstatutoAluno());
            }
            /*
                String texto = "Hoje o Sol está forte";
		String procurarPor = "sol";
		System.out.println(texto.toLowerCase().contains(procurarPor.toLowerCase()));
            */
        }
    }
}
