/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.awt.Color;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelos.Aluno;
import repositorio.AlunoRepositorio;

/**
 *
 * @author Sabrina Gama
 */
public class TelaVisualizarAlunos extends javax.swing.JFrame {
    
    public void carregarAlunos (DefaultTableModel modelo) {
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
            JOptionPane.showMessageDialog(this, "Erro ao carregar alunos: " + e.getMessage());
            }
        
    }
    
    
    public void ListarAlunosPorNome(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpa linhas antigas
        try {
            String nome = txtListarAlunoNome.getText();           
            List<Aluno> alunos = new AlunoRepositorio().listarAlunoPorNome(nome.toLowerCase());
            
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum nome digitado. ");
            }
            
            if (alunos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome não encontrado no banco de dados.");
            }
            
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
            
                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar aluno: " + e.getMessage());
        }
        
    }
    
    
    public void buscarAlunoId(DefaultTableModel modelo){
        modelo.setRowCount(0); // Limpa linhas antigas
        try {
            String id = txtBuscarAlunoId.getText();           
            Aluno aluno = new AlunoRepositorio().listarAlunoPorId(Long.parseLong(id));
            
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum ID digitado. ");
            }           

            modelo.addRow(new Object[] {
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                aluno.getIdade(),
                aluno.getTelefone(),
                aluno.getEmail()
            });
            
            
                     
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "ID não encontrado no banco de dados.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar aluno: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    
    public final DefaultTableModel TelaV(JTable tabelaAlunos) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaAlunos.getModel();
        tabelaAlunos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        tabelaAlunos.setBackground(new Color(245, 245, 245));
        tabelaAlunos.setForeground(Color.DARK_GRAY);
        tabelaAlunos.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tabelaAlunos.setRowHeight(28);
        tabelaAlunos.setGridColor(Color.LIGHT_GRAY);
        tabelaAlunos.setSelectionBackground(new Color(200, 230, 255));
        
        return modelo;
    }
    
    
    /**
     * Creates new form TelaVisualizarAlunos
     */
    public TelaVisualizarAlunos() {      
        initComponents();
        DefaultTableModel modelo = TelaV(tabelaAlunos);
        
        carregarAlunos(modelo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtListarAlunoNome = new javax.swing.JTextField();
        btnListarAlunoNome = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscarAlunoId = new javax.swing.JTextField();
        btnBurcarAlunoId = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAlunos = new JTable();
        btnVoltarInicial = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCadastrarAluno = new javax.swing.JMenuItem();
        menuEditarAluno = new javax.swing.JMenuItem();
        menuDeletarAluno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCadastrarTreino = new javax.swing.JMenuItem();
        menuEditarTreino = new javax.swing.JMenuItem();
        menuDeletarTreino = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuVisualizarAlunos = new javax.swing.JMenuItem();
        menuVisualizarTreinos = new javax.swing.JMenuItem();
        menuInicio = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Academia");
        setAlwaysOnTop(true);
        setBackground(new Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(940, 630));
        setSize(new java.awt.Dimension(0, 0));

        jLabel2.setFont(new Font("SimSun", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("ACADEMIA TOP ONE");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Aluno Por Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 15))); // NOI18N
        jPanel3.setToolTipText("");

        jLabel5.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nome:");

        txtListarAlunoNome.setFont(new Font("Tahoma", 0, 14)); // NOI18N

        btnListarAlunoNome.setBackground(new Color(238, 238, 238));
        btnListarAlunoNome.setFont(new Font("Arial", 0, 14)); // NOI18N
        btnListarAlunoNome.setText("PESQUISAR");
        btnListarAlunoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAlunoNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtListarAlunoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnListarAlunoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtListarAlunoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListarAlunoNome)
                .addGap(12, 12, 12))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Aluno Por ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 15))); // NOI18N
        jPanel6.setToolTipText("");

        jLabel7.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ID Aluno");

        txtBuscarAlunoId.setFont(new Font("Tahoma", 0, 14)); // NOI18N

        btnBurcarAlunoId.setBackground(new Color(238, 238, 238));
        btnBurcarAlunoId.setFont(new Font("Arial", 0, 14)); // NOI18N
        btnBurcarAlunoId.setText("PESQUISAR");
        btnBurcarAlunoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBurcarAlunoIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarAlunoId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnBurcarAlunoId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarAlunoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBurcarAlunoId)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tabelaAlunos.setFont(new Font("Segoe UI Semibold", 1, 14)); // NOI18N
        tabelaAlunos.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Data Nasc", "Idade", "Telefone", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                Long.class, String.class, String.class, String.class, Integer.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaAlunos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaAlunos.setMinimumSize(new java.awt.Dimension(0, 0));
        tabelaAlunos.setShowGrid(false);
        tabelaAlunos.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tabelaAlunos);
        if (tabelaAlunos.getColumnModel().getColumnCount() > 0) {
            tabelaAlunos.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabelaAlunos.getColumnModel().getColumn(0).setMaxWidth(80);
            tabelaAlunos.getColumnModel().getColumn(1).setMinWidth(120);
            tabelaAlunos.getColumnModel().getColumn(2).setMinWidth(120);
            tabelaAlunos.getColumnModel().getColumn(4).setPreferredWidth(60);
            tabelaAlunos.getColumnModel().getColumn(4).setMaxWidth(80);
            tabelaAlunos.getColumnModel().getColumn(6).setMinWidth(100);
        }

        btnVoltarInicial.setFont(new Font("Arial", 1, 14)); // NOI18N
        btnVoltarInicial.setText("VOLTAR");
        btnVoltarInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarInicialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltarInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVoltarInicial)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("Aluno");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuCadastrarAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuCadastrarAluno.setFont(new Font("Arial", 0, 12)); // NOI18N
        menuCadastrarAluno.setText("Cadastrar Aluno");
        jMenu1.add(menuCadastrarAluno);

        menuEditarAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuEditarAluno.setFont(new Font("Arial", 0, 12)); // NOI18N
        menuEditarAluno.setText("Editar Aluno");
        jMenu1.add(menuEditarAluno);

        menuDeletarAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuDeletarAluno.setFont(new Font("Arial", 0, 12)); // NOI18N
        menuDeletarAluno.setText("Deletar Aluno");
        menuDeletarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeletarAlunoActionPerformed(evt);
            }
        });
        jMenu1.add(menuDeletarAluno);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Treino");

        menuCadastrarTreino.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuCadastrarTreino.setText("Cadastrar Treino");
        jMenu2.add(menuCadastrarTreino);

        menuEditarTreino.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        menuEditarTreino.setText("Editar Treino");
        jMenu2.add(menuEditarTreino);

        menuDeletarTreino.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        menuDeletarTreino.setText("Deletar Treino");
        jMenu2.add(menuDeletarTreino);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Visualizar");

        menuVisualizarAlunos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        menuVisualizarAlunos.setText("Visualizar Alunos");
        jMenu3.add(menuVisualizarAlunos);

        menuVisualizarTreinos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        menuVisualizarTreinos.setText("Visualizar Treinos");
        jMenu3.add(menuVisualizarTreinos);

        jMenuBar1.add(jMenu3);

        menuInicio.setText("Inicio");
        jMenuBar1.add(menuInicio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuDeletarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeletarAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuDeletarAlunoActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void btnListarAlunoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAlunoNomeActionPerformed
        DefaultTableModel modelo = TelaV(tabelaAlunos);   
        ListarAlunosPorNome(modelo);
        
    }//GEN-LAST:event_btnListarAlunoNomeActionPerformed

    private void btnBurcarAlunoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBurcarAlunoIdActionPerformed
        DefaultTableModel modelo = TelaV(tabelaAlunos);   
        buscarAlunoId(modelo);
    }//GEN-LAST:event_btnBurcarAlunoIdActionPerformed

    private void btnVoltarInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarInicialActionPerformed
        DefaultTableModel modelo = TelaV(tabelaAlunos);      
        carregarAlunos(modelo);

    }//GEN-LAST:event_btnVoltarInicialActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaVisualizarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVisualizarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVisualizarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVisualizarAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVisualizarAlunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBurcarAlunoId;
    private javax.swing.JButton btnListarAlunoNome;
    private javax.swing.JButton btnVoltarInicial;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuCadastrarAluno;
    private javax.swing.JMenuItem menuCadastrarTreino;
    private javax.swing.JMenuItem menuDeletarAluno;
    private javax.swing.JMenuItem menuDeletarTreino;
    private javax.swing.JMenuItem menuEditarAluno;
    private javax.swing.JMenuItem menuEditarTreino;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuVisualizarAlunos;
    private javax.swing.JMenuItem menuVisualizarTreinos;
    private JTable tabelaAlunos;
    private javax.swing.JTextField txtBuscarAlunoId;
    private javax.swing.JTextField txtListarAlunoNome;
    // End of variables declaration//GEN-END:variables
}
