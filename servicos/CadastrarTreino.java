package servicos;

import modelos.Treino;
import repositorio.TreinoRepositorio;

import java.time.Duration;
import java.time.LocalDateTime;


public class CadastrarTreino {
    public static void cadastrarTreino(String alunoIdStr, String tipoTreino, String descricao, String duracaoStr){
        TreinoRepositorio TreinoRepositorio = new TreinoRepositorio();
        TreinoRepositorio.criarTabelaTreino();

        Long alunoId = Long.parseLong(alunoIdStr);
        
        Duration duracao = Duration.ofMinutes(Integer.parseInt(duracaoStr));

        LocalDateTime data = LocalDateTime.now();


        Treino treino = new Treino(null, tipoTreino, descricao, duracao, data, alunoId);
        TreinoRepositorio.inserir(treino);
    }


}
