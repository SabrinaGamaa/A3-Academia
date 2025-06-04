/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import java.awt.Component;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelos.Aluno;
import modelos.Treino;
import repositorio.AlunoRepositorio;
import repositorio.TreinoRepositorio;

/**
 *
 * @author Sabrina Gama
 */
public class ListarTreinoPorId {
    public void listarTreino(Component Tela, DefaultTableModel modelo, JTextField txtIdTreino) {
        modelo.setRowCount(0); // Limpa linhas antigas

        String idTreinoStr = txtIdTreino.getText();
        if (idTreinoStr.isEmpty()) {
            JOptionPane.showMessageDialog(Tela, "ID do treino é obrigatório!");
            return;
        }

        try {

            Long idTreino = Long.parseLong(idTreinoStr.trim());
            Treino treino = new TreinoRepositorio().buscarTreinoPorId(idTreino);

            if (treino == null) {
                JOptionPane.showMessageDialog(Tela, "ID Treino" + idTreino + " não encontrado.");

            } else {
                Aluno aluno = new AlunoRepositorio().listarAlunoPorId(treino.getAlunoId());
                modelo.addRow(new Object[]{
                    treino.getId(),
                    treino.getAlunoId(),
                    aluno.getNome(),
                    treino.getTipoTreino(),
                    treino.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                    String.valueOf(treino.getDuracao().toMinutes() + " minutos"),
                    treino.getDescricao()
                });
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Tela, "ID Treino inválido. Por favor, digite apenas números.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Tela, "Erro ao carregar treino: " + e.getMessage());
        }
    }
}
