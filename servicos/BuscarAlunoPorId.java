package servicos;

import java.awt.Component;
import java.time.format.DateTimeFormatter;
import modelos.Aluno;
import repositorio.AlunoRepositorio;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BuscarAlunoPorId {    
    public void buscarAlunoId(Component Tela, DefaultTableModel modelo, JTextField txtBuscarAlunoId){
        modelo.setRowCount(0); // Limpa linhas antigas
        
        String idStr = txtBuscarAlunoId.getText();           
        
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(Tela, "Nenhum ID digitado. ");
            return;
        } 
        
        try {
            Long id = Long.parseLong(idStr.trim());
            Aluno aluno = new AlunoRepositorio().listarAlunoPorId(id);
            
            if (aluno == null) {
                JOptionPane.showMessageDialog(Tela, "Nenhum aluno com ID " + id + " encontrado.");
            } else {
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
            
                     
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Tela, "ID inválido. Por favor, digite apenas números.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Tela, "Erro ao carregar aluno: " + e.getMessage());
            
        }
        
    }

}
