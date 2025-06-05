package servicos;

import java.time.format.DateTimeFormatter;
import modelos.Aluno;
import repositorio.AlunoRepositorio;

import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ListarAlunoPorNome {

    public void listarAlunosPorNome(DefaultTableModel modelo, JTextField txtListarAlunoNome) {
        modelo.setRowCount(0); // Limpa linhas antigas
        
        String nome = txtListarAlunoNome.getText();           
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nenhum nome digitado. ");
        }
        
        try {
            List<Aluno> alunos = new AlunoRepositorio().listarAlunoPorNome(nome.toLowerCase().trim());
            
            if (alunos.isEmpty()) {
                throw new IllegalArgumentException("Nome " + nome + " não encontrado no banco de dados.");
            } else {
                for (Aluno aluno : alunos) {
                    modelo.addRow(new Object[] {
                        aluno.getId(),
                        aluno.getNome(),
                        aluno.getCpf(),
                        aluno.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        aluno.getIdade(),
                        aluno.getTelefone(),
                        aluno.getEmail()
                    });
                }
            }
            
                     
        } catch (IllegalAccessError e) {
            throw e;
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao carregar aluno: " + e.getMessage());
        }
        
    }

}
