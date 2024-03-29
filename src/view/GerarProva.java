/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import controller.ControlProva;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Prova;
import model.bean.Questao;
import model.bean.QuestaoProva;
import model.bean.Usuario;

/**
 *
 * @author mmano
 */
public class GerarProva extends javax.swing.JFrame {

    /**
     * Creates new form Conteudo
     */
    public GerarProva() {
        initComponents();
        Usuario user = Usuario.getInstance();
        DefaultTableModel modelo = (DefaultTableModel) tableProvas.getModel();
        tableProvas.setRowSorter(new TableRowSorter(modelo));
        int id = user.getId();
        readJTableAssuntosForId(id);
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
        jLabel1 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProvas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerar Prova");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return-icon.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 2, 40, 60));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 394, 424));

        tableProvas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome da Prova"
            }
        ));
        tableProvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProvasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProvas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 167, 509, 91));

        jLabel3.setText("Selecione o pacote de Prova: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 142, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-pdf.png"))); // NOI18N
        jButton1.setText("Gerar Prova em PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 264, 195, 52));

        jButton2.setText("Adicionar um novo pacote de Prova");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 264, -1, 40));

        jButton3.setText("Remover Pacote de Prova");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 356, 203, 40));

        jButton4.setText("Apagar questões do Pacote");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 310, 203, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-prova.png"))); // NOI18N
        jLabel2.setText("Gerar Prova");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 52, 509, 34));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ControlProva cProva = new ControlProva();
        Usuario user = Usuario.getInstance();
        DefaultTableModel modelo = (DefaultTableModel) tableProvas.getModel();
        int fk_usuario = user.getId();
        String nome_prova = JOptionPane.showInputDialog("Digite o nome da Prova");
        cProva.criarPacoteProva(nome_prova, fk_usuario);
        modelo.setNumRows(0);
        int id = user.getId();
        readJTableAssuntosForId(id);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableProvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProvasMouseClicked
        ControlProva cProva = new ControlProva();
        Integer id = (int) tableProvas.getValueAt(tableProvas.getSelectedRow(), 0);
        int [] array_ids = new int[100];
        int cont = 0;
            
        
        for(QuestaoProva qp : cProva.listarQuestaoProvaByFkProva(id)) {
            
            array_ids[cont] = qp.getFk_questao();   
            cont++;
           
        }
        
        
        
    }//GEN-LAST:event_tableProvasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Integer id_prova = (int) tableProvas.getValueAt(tableProvas.getSelectedRow(), 0);
        String nome_prova = (String) tableProvas.getValueAt(tableProvas.getSelectedRow(), 1);
        ControlProva cProva = new ControlProva();
        
      

        int num_questao = 1;
        if(tableProvas.getSelectedRow() != -1) {
            
            String filename = File.separator+"tmp";
            JFileChooser fc = new JFileChooser(new File(filename));
    
            // Mostra a dialog de save file
            fc.setDialogTitle("Salvar como");
            int retorno = fc.showSaveDialog(this);
            
            if(retorno == JFileChooser.APPROVE_OPTION) {
                File setFile = fc.getSelectedFile();
                Document doc = new Document();
     
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(setFile + ".pdf"));
                doc.open();
                doc.add(new Paragraph(nome_prova + "\n"));
                doc.add(new Paragraph("\n"));

            } catch (FileNotFoundException | DocumentException ex) {
                JOptionPane.showMessageDialog(null, "Houve algum erro. Log: " + ex);

            } 
            
            
             JOptionPane.showMessageDialog(null, "Gerando PDF...");
            for(Questao quest : cProva.listarQuestaoDaProvaById(id_prova)) {
                try {
                    doc.add(new Paragraph(num_questao + ") " + quest.getEnunciado()));
                    doc.add(new Paragraph(quest.getResposta_a()));
                    doc.add(new Paragraph(quest.getResposta_b()));
                    doc.add(new Paragraph(quest.getResposta_c()));
                    doc.add(new Paragraph(quest.getResposta_d()));
                    doc.add(new Paragraph("\n"));
                    doc.add(new Paragraph("\n"));
                    num_questao++;
                    
                } catch (DocumentException error) {
                    JOptionPane.showMessageDialog(null, "Houve algum erro. Log: " + error);
                    
                }      
            }
            doc.close();
            try {
                Desktop.getDesktop().open(new File(setFile + ".pdf"));
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Houve algum erro ao abrir o arquivo: " + ex);
                
            }
            
            
             } else {
                JOptionPane.showMessageDialog(null, "Cancelando Operação");
           
             }
  
           } 
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(tableProvas.getSelectedRow() != -1) {
            int id = (int) tableProvas.getValueAt(tableProvas.getSelectedRow(), 0);
            Usuario user = Usuario.getInstance();
            ControlProva cProva = new ControlProva();
            cProva.apagarProva(id);
            DefaultTableModel modelo = (DefaultTableModel) tableProvas.getModel();
            modelo.setNumRows(0); 
            int id_user = user.getId();
            readJTableAssuntosForId(id_user);
            
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um prova para apagar.");
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(tableProvas.getSelectedRow() != -1) {
            ControlProva cProva = new ControlProva();
            Usuario user = Usuario.getInstance();
            int id = (int) tableProvas.getValueAt(tableProvas.getSelectedRow(), 0);
            JOptionPane.showMessageDialog(null, id);
            cProva.apagarQuestoes(id);
            
        } else {
            JOptionPane.showMessageDialog(null, "Selecione alguma questão");
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        
    }//GEN-LAST:event_jLabel1KeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Prof Prof = new Prof();
        Prof.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(GerarProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerarProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerarProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerarProva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerarProva().setVisible(true);
            }
        });
    }
    
    
     public void readJTableAssuntosForId(int id) {
        DefaultTableModel modelo = (DefaultTableModel) tableProvas.getModel();
        
        ControlProva cProva = new ControlProva(); 
        
        for(Prova p: cProva.listarProvasPorUsuario(id)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome_prova()
            }); 
    }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProvas;
    // End of variables declaration//GEN-END:variables

}
