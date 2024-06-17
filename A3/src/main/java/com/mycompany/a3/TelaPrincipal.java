package com.mycompany.a3;

import com.mycompany.a3.DatabaseConnection;
import com.mycompany.a3.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;


public class TelaPrincipal extends javax.swing.JFrame {

       private Usuario usuarioLogado;
    
    public TelaPrincipal(Usuario usuario) {
        initComponents(); // Inicializa os componentes da tela
        this.usuarioLogado = usuario;
        if (!usuarioLogado.isAdmin()) {
            btnAdicionar.setEnabled(false);
            btnDeletar.setEnabled(false);
            btnDash.setEnabled(false); 
        }
        carregarPDFs();
    }

     private void carregarPDFs() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pdf_metadata")) {
            ResultSet rs = stmt.executeQuery();
            DefaultListModel<String> model = new DefaultListModel<>();
            while (rs.next()) {
                String nome = rs.getString("nome");
                model.addElement(nome);
            }
            JlistPDFs.setModel(model); // Define o modelo na JList
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar PDFs: " + ex.getMessage());
        }
}

private void adicionarPDF(File arquivoPDF) {
        try (Connection conn = DatabaseConnection.getConnection();
             FileInputStream fis = new FileInputStream(arquivoPDF);
             PreparedStatement stmt1 = conn.prepareStatement("INSERT INTO pdf_metadata (nome, visibilidade) VALUES (?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO pdf_arquivos (id, pdf_blob) VALUES (?, ?)")) {

            stmt1.setString(1, arquivoPDF.getName());
            stmt1.setString(2, usuarioLogado.isAdmin() ? "ADMIN" : "COMUM");
            int rowsInserted = stmt1.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = stmt1.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    stmt2.setInt(1, id);
                    stmt2.setBinaryStream(2, fis, (int) arquivoPDF.length());
                    stmt2.executeUpdate();
                    JOptionPane.showMessageDialog(this, "PDF adicionado com sucesso!");
                    carregarPDFs(); // Atualiza a lista de PDFs após adicionar
                }
            }
        } catch (SQLException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar PDF: " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao ler arquivo PDF: " + ex.getMessage());
        }
    }

    private void deletarPDF(int idPDF) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM pdf_metadata WHERE id = ?")) {

            stmt.setInt(1, idPDF);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "PDF deletado com sucesso!");
                carregarPDFs(); // Atualiza a lista de PDFs após deletar
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar PDF: " + ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdicionar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JlistPDFs = new javax.swing.JList<>();
        btnDash = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar);
        btnAdicionar.setBounds(290, 80, 81, 23);

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(290, 140, 72, 23);

        JlistPDFs.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        JlistPDFs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlistPDFsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JlistPDFs);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(33, 46, 187, 210);

        btnDash.setText("DashBoard");
        btnDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashActionPerformed(evt);
            }
        });
        getContentPane().add(btnDash);
        btnDash.setBounds(290, 200, 100, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\evert\\Downloads\\fundo.jpeg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 440, 340);

        setSize(new java.awt.Dimension(448, 346));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            adicionarPDF(file);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
                int index = JlistPDFs.getSelectedIndex();
        if (index != -1) {
            DefaultListModel<String> model = (DefaultListModel<String>) JlistPDFs.getModel();
            String nomePDF = model.get(index);
            int idPDF = obterIdPDF(nomePDF);
            if (idPDF != -1) {
                deletarPDF(idPDF);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um PDF para deletar.");
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void JlistPDFsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlistPDFsMouseClicked
                if (evt.getClickCount() == 2) { // Verifica se foi um duplo clique
            int index = JlistPDFs.getSelectedIndex();
            if (index != -1) {
                DefaultListModel<String> model = (DefaultListModel<String>) JlistPDFs.getModel();
                String nomePDF = model.get(index);
                abrirPDF(nomePDF);
            }
        }
    }//GEN-LAST:event_JlistPDFsMouseClicked

    private void btnDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashActionPerformed
        // Abre a TelaDash apenas se o usuário for administrador
    if (usuarioLogado.isAdmin()) {
        SwingUtilities.invokeLater(() -> {
            TelaDash telaDash = new TelaDash();
            telaDash.setVisible(true);
        });
    }
    }//GEN-LAST:event_btnDashActionPerformed

    private void abrirPDF(String nomePDF) {
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT pdf_arquivos.pdf_blob " +
                 "FROM pdf_metadata INNER JOIN pdf_arquivos ON pdf_metadata.id = pdf_arquivos.id " +
                 "WHERE pdf_metadata.nome = ?")) {

        stmt.setString(1, nomePDF);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            byte[] pdfBytes = rs.getBytes("pdf_blob");
            File tempFile = File.createTempFile("temp", ".pdf");
            FileUtils.writeByteArrayToFile(tempFile, pdfBytes); // Escreve os bytes do PDF no arquivo temporário

            // Verifica se o sistema suporta a operação de abrir arquivo
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (tempFile.exists()) {
                    desktop.open(tempFile); // Abre o arquivo PDF com o aplicativo padrão associado
                } else {
                    JOptionPane.showMessageDialog(this, "Arquivo PDF temporário não encontrado.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Abertura de arquivo não suportada neste sistema.");
            }
        }
    } catch (SQLException | IOException | IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao abrir PDF: " + ex.getMessage());
    }
}
    
    private int obterIdPDF(String nomePDF) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT id FROM pdf_metadata WHERE nome = ?")) {

            stmt.setString(1, nomePDF);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao obter ID do PDF: " + ex.getMessage());
        }
        return -1;
    }

    
    
    
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Usuario usuario = new Usuario(); // Suponha que você tenha um usuário válido aqui
            usuario.setId(1);
            usuario.setNome("João");
            new TelaPrincipal(usuario).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JlistPDFs;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnDash;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
