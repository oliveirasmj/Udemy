package diversos.imutabilidade;

public final class ComImutabilidade {

	private final String linha;

    public ComImutabilidade(String linha) {
        this.linha = linha;
    }
    
//    private ComImutabilidade(String linha) {
//        this.linha = linha;
//    }

    public String getLinha() {
        return linha;
    }
    
//    public static ComImutabilidade make() {
//        return new ComImutabilidade("");
//    }
}

/*
1 - A classe deve ser declarada como final (para que as classes filhas não possam ser criadas)
2 - Os membros de dados da classe devem ser declarados como privados (para que o acesso direto não seja permitido)
3 - Os membros de dados da classe devem ser declarados como finais (para que não possamos alterar seu valor após a criação do objeto)
4 - Um construtor parametrizado deve inicializar todos os campos realizando uma cópia profunda (para que os membros de dados não possam ser modificados com referência de objeto)
5 - Fornecer pelo menos um construtor(unico método mutável que deve existir)
6 - A cópia profunda de objetos deve ser realizada nos métodos getter (para retornar uma cópia em vez de retornar a referência do objeto real)
7 - Sem setters (para não ter a opção de alterar o valor da variável de instância)
8 - Caso haja composição devem ter acesso exclusivo pela sua classe com cópias defensivas
 */