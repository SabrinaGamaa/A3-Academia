/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import java.awt.Component;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Aluno;
import modelos.Treino;
import repositorio.AlunoRepositorio;
import repositorio.TreinoRepositorio;

/**
 *
 * @author Sabrina Gama
 */
public class ListarTreinos {
    public void listar(Component Tela, DefaultTableModel modelo){       
        modelo.setRowCount(0); // Limpa linhas antigas
        try {

            List<Treino> treinos = new TreinoRepositorio().listarTreinoAlunos();            
             
            for (Treino treino : treinos) {
                Aluno alunos = new AlunoRepositorio().listarAlunoPorId(treino.getAlunoId());
                if (alunos != null) {
                    modelo.addRow(new Object[] {
                        treino.getId(),
                        treino.getAlunoId(),
                        alunos.getNome(),
                        treino.getTipoTreino(),
                        treino.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        String.valueOf(treino.getDuracao().toMinutes() + " minutos"),
                        treino.getDescricao()
                    });
                }
                else {
                    modelo.addRow(new Object[] {
                        treino.getId(),
                        treino.getAlunoId(),
                        null,
                        treino.getTipoTreino(),
                        treino.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        String.valueOf(treino.getDuracao().toMinutes() + " minutos"),
                        treino.getDescricao()
                    });
                }
            }

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Tela, "Erro ao carregar treino: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
