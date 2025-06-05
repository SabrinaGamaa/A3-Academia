package servicos;

import modelos.Treino;
import repositorio.TreinoRepositorio;

import java.time.Duration;
import java.time.LocalDateTime;
import modelos.Aluno;
import repositorio.AlunoRepositorio;


public class CadastrarTreino {
    public static void cadastrarTreino(String alunoIdStr, String tipoTreinoStr, String descricaoStr, String duracaoStr){
        try {            
            
                Long alunoId = null;
                if (alunoIdStr == null) {
                    throw new IllegalArgumentException("ID Aluno é obrigatorio!");
                } else {
                    try {
                        alunoId = Long.parseLong(alunoIdStr.trim());
                    } catch (NumberFormatException e){
                        throw new IllegalArgumentException("ID do aluno inválido. Por favor, insira um número inteiro.");
                    }
                }
                
                Aluno aluno = new AlunoRepositorio().listarAlunoPorId(alunoId);
                if (aluno == null) {
                    throw new IllegalArgumentException("Aluno com ID " + alunoId + " não encontrado!");
                }
            
                String tipoTreino = tipoTreinoStr != null ? tipoTreinoStr.trim() : "";
                if (tipoTreino.isEmpty()) {
                    throw new IllegalArgumentException("Tipo de Treino é obrigatorio!");
                    
                }

                String descricao = descricaoStr != null ? descricaoStr.trim() : "";
                if (descricao.isEmpty()){
                    throw new IllegalArgumentException("Descrição é obrigatorio!");
                }
                
               Duration duracao;
                try {
                    int minutos = Integer.parseInt(duracaoStr.trim());
                    if (minutos <= 0){
                        throw new IllegalArgumentException("Duração deve ser maior que 0 minutos");
                    }
                    duracao = Duration.ofMinutes(minutos);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Duração invalida. Digite um numero inteiro");
                }
                
                LocalDateTime data = LocalDateTime.now();
                

                TreinoRepositorio TreinoRepositorio = new TreinoRepositorio();
                TreinoRepositorio.criarTabelaTreino();

                Treino treino = new Treino(null, tipoTreino, descricao, duracao, data, alunoId);
                TreinoRepositorio.inserir(treino);

        
            } catch (IllegalArgumentException e){
                throw e;
            }
            catch (Exception e) {
                throw new RuntimeException("Erro ao cadastrar aluno. " + e.getMessage());
            }
    }
}
