/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sabrina Gama
 */
public class ModeloTabela {
    public DefaultTableModel TelaV(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);

        tabela.setBackground(new Color(245, 245, 245));
        tabela.setForeground(Color.DARK_GRAY);
        tabela.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tabela.setRowHeight(28);
        tabela.setGridColor(Color.LIGHT_GRAY);
        tabela.setSelectionBackground(new Color(200, 230, 255));
        
        return modelo;
    }
}
