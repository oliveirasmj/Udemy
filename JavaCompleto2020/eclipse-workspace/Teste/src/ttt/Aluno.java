package ttt;
/**
 * 
 * @author Acer
 */
public class Aluno {
    
    private String nomeAluno;
    private int numeroAluno;
    private String estatutoAluno;
    
    /**
     * 
     * @param nomeAluno
     * @param numeroAluno 
     */
    public Aluno(String nomeAluno, int numeroAluno) {
        this.nomeAluno = nomeAluno;
        this.numeroAluno = numeroAluno;
        estatutoAluno = "ordinario";
    }
    
    /**
     * 
     * @return 
     */
    public String getNomeAluno() {
        return nomeAluno;
    }

    public int getNumeroAluno() {
        return numeroAluno;
    }

    public String getEstatutoAluno() {
        return estatutoAluno;
    }
    
    /**
     * 
     * @param nomeAluno 
     */
    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setNumeroAluno(int numeroAluno) {
        this.numeroAluno = numeroAluno;
    }

    public void setEstatutoAluno(String estatutoAluno) {
        this.estatutoAluno = estatutoAluno;
    }
    
    
    
}
