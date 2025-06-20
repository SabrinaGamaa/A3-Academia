/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Treino;
import repositorio.TreinoRepositorio;
import servicos.EditarTreino;
import servicos.ListarTreinoPorId;
import servicos.ListarTreinos;
import servicos.ModeloTabela;

/**
 *
 * @author Sabrina Gama
 */
public class TelaEditarTreino extends javax.swing.JFrame {
    ModeloTabela modeloTabela = new ModeloTabela();
    ListarTreinos listarTreinos = new ListarTreinos();
    
    /**
     * Creates new form TelaCadastrarAluno
     */
    public TelaEditarTreino() {
        initComponents();
        
        tabelaTreinos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int linhaSelecionada = tabelaTreinos.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    int colunas = tabelaTreinos.getColumnCount();
                    
                    String[] dadosLinha = new String[colunas];
                    
                    for (int i = 0; i < colunas; i ++){
                        String dados = tabelaTreinos.getValueAt(linhaSelecionada, i).toString();
                        dadosLinha[i] = (dados != null) ? dados : "";
                    }
                    
                    txtIdTreino.setText(dadosLinha[0]);
                    
                    txtIdAluno.setText(dadosLinha[1]);

                    txtTipoTreino.setText(dadosLinha[3]);

                    txtDataInicio.setText(dadosLinha[4]);

                    String[] duracaoStr = dadosLinha[5].split(" ");
                    String duracao = duracaoStr[0];
                    txtDuracao.setText(duracao);
 
                    txtDescricao.setText(dadosLinha[6]);
                }
            }
        });    
        
        
        DefaultTableModel modelo = modeloTabela.TelaV(tabelaTreinos);
        listarTreinos.listar(modelo);
      
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtIdTreino = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIdAluno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTipoTreino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();
        txtDataInicio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        editarTreino = new javax.swing.JButton();
        btnVoltarInicial = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaTreinos = new javax.swing.JTable();
        btnInicial = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCadastrarAluno = new javax.swing.JMenuItem();
        menuEditarAluno = new javax.swing.JMenuItem();
        menuDeletarAluno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCadastrarTreino = new javax.swing.JMenuItem();
        menuDeletarTreino = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuVisualizarAlunos = new javax.swing.JMenuItem();
        menuVisualizarTreinos = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WORKOUT TREINOS");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(940, 630));

        jLabel2.setFont(new java.awt.Font("SimSun", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("==== EDITAR TREINO ====");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Treino do Aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 15))); // NOI18N

        txtIdTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("ID treino");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("ID Aluno");

        txtIdAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Tipo de Treino");

        txtTipoTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Duração (em Minutos)");

        txtDuracao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtDataInicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Data de Inicio do Treino");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Descrição");

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIdTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar))
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTipoTreino, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtIdAluno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                    .addComponent(jLabel4)
                    .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipoTreino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editarTreino.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        editarTreino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        editarTreino.setText("EDITAR");
        editarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarTreinoActionPerformed(evt);
            }
        });

        btnVoltarInicial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVoltarInicial.setText("VOLTAR");
        btnVoltarInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarInicialActionPerformed(evt);
            }
        });

        tabelaTreinos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        tabelaTreinos.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Aluno ID", "Nome", "Tipo de Treino", "Data Inicio", "Duração", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                Long.class, Long.class, String.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaTreinos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaTreinos.setMinimumSize(new java.awt.Dimension(0, 0));
        tabelaTreinos.setShowGrid(false);
        tabelaTreinos.setShowHorizontalLines(true);
        jScrollPane3.setViewportView(tabelaTreinos);
        if (tabelaTreinos.getColumnModel().getColumnCount() > 0) {
            tabelaTreinos.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabelaTreinos.getColumnModel().getColumn(0).setMaxWidth(80);
            tabelaTreinos.getColumnModel().getColumn(1).setPreferredWidth(60);
            tabelaTreinos.getColumnModel().getColumn(1).setMaxWidth(80);
            tabelaTreinos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelaTreinos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabelaTreinos.getColumnModel().getColumn(5).setPreferredWidth(80);
            tabelaTreinos.getColumnModel().getColumn(5).setMaxWidth(120);
            tabelaTreinos.getColumnModel().getColumn(6).setMinWidth(150);
        }

        btnInicial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnInicial.setText("INICIO");
        btnInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnVoltarInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(editarTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarTreino)
                    .addComponent(btnVoltarInicial)
                    .addComponent(btnInicial))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jMenu1.setText("Aluno");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuCadastrarAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuCadastrarAluno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuCadastrarAluno.setText("Cadastrar Aluno");
        menuCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarAlunoActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadastrarAluno);

        menuEditarAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuEditarAluno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuEditarAluno.setText("Editar Aluno");
        menuEditarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarAlunoActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditarAluno);

        menuDeletarAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuDeletarAluno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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
        menuCadastrarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarTreinoActionPerformed(evt);
            }
        });
        jMenu2.add(menuCadastrarTreino);

        menuDeletarTreino.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        menuDeletarTreino.setText("Deletar Treino");
        menuDeletarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeletarTreinoActionPerformed(evt);
            }
        });
        jMenu2.add(menuDeletarTreino);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Visualizar");

        menuVisualizarAlunos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        menuVisualizarAlunos.setText("Visualizar Alunos");
        menuVisualizarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVisualizarAlunosActionPerformed(evt);
            }
        });
        jMenu3.add(menuVisualizarAlunos);

        menuVisualizarTreinos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        menuVisualizarTreinos.setText("Visualizar Treinos");
        menuVisualizarTreinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVisualizarTreinosActionPerformed(evt);
            }
        });
        jMenu3.add(menuVisualizarTreinos);

        jMenuBar1.add(jMenu3);

        jMenu7.setText("Inicio");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem4.setText("Inicio");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem4);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            DefaultTableModel modelo = modeloTabela.TelaV(tabelaTreinos);
            Treino treino = new ListarTreinoPorId().listarTreino(modelo, txtIdTreino);

            long idAlunoAtual = treino.getAlunoId();
            txtIdAluno.setText(String.valueOf(idAlunoAtual));
            txtIdAluno.setEnabled(true);

            txtDescricao.setText(treino.getDescricao());
            txtDescricao.setEnabled(true);

            txtTipoTreino.setText(treino.getTipoTreino());
            txtTipoTreino.setEnabled(true);

            String dur = String.valueOf(treino.getDuracao().toMinutes());
            txtDuracao.setText(dur);
            txtDuracao.setEnabled(true);

            LocalDateTime data = treino.getDataInicio();
            String dataStr= data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            txtDataInicio.setText(dataStr);
            txtDataInicio.setEnabled(true);
            
            listarTreinos.listar(modelo);
                      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    
    private void editarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarTreinoActionPerformed
        String idTreino = txtIdTreino.getText();
        String idAluno = txtIdAluno.getText();
        String descricao = txtDescricao.getText();
        String duracao = txtDuracao.getText();
        String tipoTreino = txtTipoTreino.getText();
        String dataInicio = txtDataInicio.getText();

        if (idTreino.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID do treino é obrigatório!");
            return;
        }
        try {
            EditarTreino.editarTreinoPorId(idAluno, tipoTreino, descricao, duracao, dataInicio, idTreino);
            Treino treino = new TreinoRepositorio().buscarTreinoPorId(Long.parseLong(idTreino));
            JOptionPane.showMessageDialog(this, "Treino ID " + treino.getId() + " editado com sucesso!");   
            
            DefaultTableModel modelo = modeloTabela.TelaV(tabelaTreinos);
            listarTreinos.listar(modelo);
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao editar treino: " + e.getMessage());
        }
    }//GEN-LAST:event_editarTreinoActionPerformed

    private void btnVoltarInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarInicialActionPerformed
        DefaultTableModel modelo = modeloTabela.TelaV(tabelaTreinos);
        listarTreinos.listar(modelo);
    }//GEN-LAST:event_btnVoltarInicialActionPerformed

    private void menuCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarAlunoActionPerformed
        new TelaCadastrarAluno().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_menuCadastrarAlunoActionPerformed

    private void menuEditarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarAlunoActionPerformed
        new TelaEditarAluno().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_menuEditarAlunoActionPerformed

    private void menuDeletarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeletarAlunoActionPerformed
        new TelaExcluirAluno().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuDeletarAlunoActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void menuCadastrarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarTreinoActionPerformed
        new TelaCadastrarTreino().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_menuCadastrarTreinoActionPerformed

    private void menuVisualizarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVisualizarAlunosActionPerformed
        new TelaVisualizarAlunos().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuVisualizarAlunosActionPerformed

    private void menuVisualizarTreinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVisualizarTreinosActionPerformed
        new TelaVisualizarTreinos().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuVisualizarTreinosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new TelaInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menuDeletarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeletarTreinoActionPerformed
        new TelaExcluirTreino().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuDeletarTreinoActionPerformed

    private void btnInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicialActionPerformed
        new TelaInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInicialActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEditarTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditarTreino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInicial;
    private javax.swing.JButton btnVoltarInicial;
    private javax.swing.JButton editarTreino;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem menuCadastrarAluno;
    private javax.swing.JMenuItem menuCadastrarTreino;
    private javax.swing.JMenuItem menuDeletarAluno;
    private javax.swing.JMenuItem menuDeletarTreino;
    private javax.swing.JMenuItem menuEditarAluno;
    private javax.swing.JMenuItem menuVisualizarAlunos;
    private javax.swing.JMenuItem menuVisualizarTreinos;
    private javax.swing.JTable tabelaTreinos;
    private javax.swing.JTextField txtDataInicio;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtIdAluno;
    private javax.swing.JTextField txtIdTreino;
    private javax.swing.JTextField txtTipoTreino;
    // End of variables declaration//GEN-END:variables
}
