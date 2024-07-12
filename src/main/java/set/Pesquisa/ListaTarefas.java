package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas(){
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefaParaRemover =t;
                    break;
                }
            }
            tarefaSet.remove(tarefaParaRemover);
        }else {
            System.out.println("o conjunto está vazio");
        }

        if (tarefaParaRemover == null){
            System.out.println("Tarefa não encontrada");
        }
    }

    public void exibirTarefa(){
        if(!tarefaSet.isEmpty()){
            System.out.println(tarefaSet);
        }else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public int contarTarefa(){
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa t : tarefaSet){
            if (t.isConcluida()){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obtertarefasPendentes(){
        Set<Tarefa> tarefasNaoConcluidas = new HashSet<>();
        for (Tarefa t : tarefaSet){
            if (!t.isConcluida()){
                tarefasNaoConcluidas.add(t);
            }
        }
        return tarefasNaoConcluidas;
    }

    public void marcarTarefaConcluida(String descricao){
        for (Tarefa t : tarefaSet){
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                t.setConcluida(true);
            }
        }
    }

    public void marcarTarefaPendente(String descricao){
        Tarefa tarefaParaMarcarComoPendente = null;
        for (Tarefa t : tarefaSet){
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                tarefaParaMarcarComoPendente = t;
                break;
            }
        }

        if (tarefaParaMarcarComoPendente != null){
            if (tarefaParaMarcarComoPendente.isConcluida()){
                tarefaParaMarcarComoPendente.setConcluida(false);
            }
        }else {
            System.out.println("Tarefa não encontrada na lista.");
        }
    }

    public void limparListaTarefas(){
        if (tarefaSet.isEmpty()){
            System.out.println("A lista já está vazia!");
        }else {
            tarefaSet.clear();
        }
    }

    public static void main(String[] args) {
        //Criando uma instânciada classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();

        //Adicionando tarefas a lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercicios fisicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        //Exibindo as tarefas na lista
        listaTarefas.exibirTarefa();

        //removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercicios fisicos");
        listaTarefas.exibirTarefa();

        //Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefa());

        //Obtendo tarefas pendentes
        System.out.println(listaTarefas.obtertarefasPendentes());

        //Marcando tarefas como concluidas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        //Obtendo tarefas concluidas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        //Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar java");
        listaTarefas.exibirTarefa();

        //Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefa();



    }



}
