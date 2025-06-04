package servicos;

import java.awt.Component;
import java.time.format.DateTimeFormatter;
import modelos.Aluno;
import repositorio.AlunoRepositorio;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarAlunos {

    public void carregarAlunos (Component Tela, DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpa linhas antigas
        try {
            AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
            List<Aluno> alunos = alunoRepositorio.listarAluno();            

            for (Aluno aluno : alunos) {
                modelo.addRow(new Object[]{
                    aluno.getId(),
                    aluno.getNome(),
                    aluno.getCpf(),
                    aluno.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    aluno.getIdade(),
                    aluno.getTelefone(),
                    aluno.getEmail()
                });
        }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(Tela, "Erro ao carregar alunos: " + e.getMessage());
            }
        
    }

}
