package servicos;

import java.time.format.DateTimeFormatter;
import modelos.Aluno;
import repositorio.AlunoRepositorio;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BuscarAlunoPorId {    
    public Aluno buscarAlunoId(DefaultTableModel modelo, JTextField txtBuscarAlunoId){
        modelo.setRowCount(0); // Limpa linhas antigas
        
        String idStr = txtBuscarAlunoId.getText();           
        
        if (idStr.isEmpty()) {
            throw new IllegalArgumentException("Nenhum ID digitado. ");
        } 
        
        try {
            Long id = Long.parseLong(idStr.trim());
            Aluno aluno = new AlunoRepositorio().listarAlunoPorId(id);
            
            if (aluno == null) {
                throw new IllegalArgumentException("Nenhum aluno com ID " + id + " encontrado.");
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
            
            return aluno;
                     
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID do aluno inválido. Por favor, digite apenas números.");    
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar aluno: " + e.getMessage());
            
        }
        
    }

}
