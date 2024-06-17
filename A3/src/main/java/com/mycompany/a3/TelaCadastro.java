
package com.mycompany.a3;
import com.mycompany.a3.DAO.UsuarioDAO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author evert
 */
public class TelaCadastro extends javax.swing.JFrame {
    
    public TelaCadastro() {
        initComponents();
    }
    
    

        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mostrarsenha = new javax.swing.JCheckBox();
        adm = new javax.swing.JCheckBox();
        txtconfsenha = new javax.swing.JPasswordField();
        txtsenha = new javax.swing.JPasswordField();
        cadastrobotao = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 40, 37, 16);

        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtnome);
        txtnome.setBounds(50, 60, 120, 22);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("E-mail");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 40, 37, 20);
        getContentPane().add(txtemail);
        txtemail.setBounds(260, 60, 90, 22);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuário");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 100, 50, 16);

        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtusuario);
        txtusuario.setBounds(260, 120, 90, 22);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Senha");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 100, 37, 16);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirmar Senha");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 160, 89, 16);

        mostrarsenha.setForeground(new java.awt.Color(255, 255, 255));
        mostrarsenha.setText("Mostrar Senha");
        mostrarsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarsenhaActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarsenha);
        mostrarsenha.setBounds(50, 210, 99, 20);

        adm.setForeground(new java.awt.Color(255, 255, 255));
        adm.setText("Administrador");
        adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admActionPerformed(evt);
            }
        });
        getContentPane().add(adm);
        adm.setBounds(250, 180, 99, 20);

        txtconfsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfsenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtconfsenha);
        txtconfsenha.setBounds(50, 180, 120, 22);
        getContentPane().add(txtsenha);
        txtsenha.setBounds(50, 120, 120, 22);

        cadastrobotao.setText("Cadastrar");
        cadastrobotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrobotaoActionPerformed(evt);
            }
        });
        getContentPane().add(cadastrobotao);
        cadastrobotao.setBounds(130, 300, 80, 23);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(340, 300, 72, 23);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\evert\\Downloads\\fundo.jpeg")); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 530, 390);

        setSize(new java.awt.Dimension(546, 395));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomeActionPerformed

    private void mostrarsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarsenhaActionPerformed
        if (mostrarsenha.isSelected()) {
            txtsenha.setEchoChar((char) 0); 
            } else {
            txtsenha.setEchoChar('*'); }
        if (mostrarsenha.isSelected()) {
                txtconfsenha.setEchoChar((char) 0); 
            } else {
                txtconfsenha.setEchoChar('*'); } 
                }//GEN-LAST:event_mostrarsenhaActionPerformed

    private void txtconfsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfsenhaActionPerformed
    }//GEN-LAST:event_txtconfsenhaActionPerformed

    private void cadastrobotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrobotaoActionPerformed
        String nome = txtnome.getText();
        String email = txtemail.getText();
        String usuario = txtusuario.getText();
        String senha = new String(txtsenha.getPassword());
        String confirmSenha = new String(txtconfsenha.getPassword());
        boolean isAdmin = adm.isSelected();
        
        if (!senha.equals(confirmSenha)) {
            JOptionPane.showMessageDialog(this, "As senhas não coincidem!");
            return;}
        
        if (nome.isEmpty() || email.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
            return;
        }
        
         if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "E-mail inválido!");
            return;
        }
         
         
         
         try {
            UsuarioDAO.cadastrarUsuario(nome, email, usuario, senha, isAdmin);
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + ex.getMessage());
        }
    
    }//GEN-LAST:event_cadastrobotaoActionPerformed
        
    private void admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
    dispose(); // Fecha a tela de cadastro
    Login Login = new Login(); // Cria uma instância da tela de login
    Login.setVisible(true); // Exibe a tela de login
            }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed


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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adm;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton cadastrobotao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JCheckBox mostrarsenha;
    private javax.swing.JPasswordField txtconfsenha;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnome;
    private javax.swing.JPasswordField txtsenha;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
