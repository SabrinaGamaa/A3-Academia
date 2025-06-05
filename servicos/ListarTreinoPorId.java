/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import java.time.format.DateTimeFormatter;
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
    public Treino listarTreino(DefaultTableModel modelo, JTextField txtIdTreino) {
        modelo.setRowCount(0); // Limpa linhas antigas

        String idTreinoStr = txtIdTreino.getText();
        if (idTreinoStr.isEmpty()) {
            throw new IllegalArgumentException("ID do treino é obrigatório!");
        }

        try {

            Long idTreino = Long.parseLong(idTreinoStr.trim());
            Treino treino = new TreinoRepositorio().buscarTreinoPorId(idTreino);

            if (treino == null) {
                throw new IllegalArgumentException("ID Treino" + idTreino + " não encontrado.");

            } else {
                Aluno aluno = new AlunoRepositorio().listarAlunoPorId(treino.getAlunoId());
                if (aluno == null) {
                    modelo.addRow(new Object[]{
                        treino.getId(),
                        treino.getAlunoId(),
                        "Aluno Desconhecido",
                        treino.getTipoTreino(),
                        treino.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        String.valueOf(treino.getDuracao().toMinutes() + " minutos"),
                        treino.getDescricao()
                    });
                } else {
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
                return treino;
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID Treino inválido. Por favor, digite apenas números.");
        } catch (IllegalArgumentException e)  {
            throw e;
        }catch (Exception e) {
            throw new IllegalArgumentException("Erro ao carregar treino: " + e.getMessage());
        }
    }
}
