package view;

import java.awt.Color;
import javax.swing.JLabel;
import model.SelectDB;

public class Showing extends javax.swing.JFrame {

    SelectDB sdb = SelectDB.getInstance();

    public Showing() {
        initComponents();
//        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan1 = new javax.swing.JPanel();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();
        img4 = new javax.swing.JLabel();
        pan2 = new javax.swing.JPanel();
        img5 = new javax.swing.JLabel();
        img6 = new javax.swing.JLabel();
        img7 = new javax.swing.JLabel();
        img8 = new javax.swing.JLabel();
        pan3 = new javax.swing.JPanel();
        img9 = new javax.swing.JLabel();
        img10 = new javax.swing.JLabel();
        img11 = new javax.swing.JLabel();
        img12 = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        list1 = new java.awt.List();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        keyWord = new javax.swing.JTextField();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan1.setBackground(new java.awt.Color(204, 51, 0));
        pan1.setLayout(new java.awt.GridLayout(1, 0));

        img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                img1MouseEntered(evt);
            }
        });
        pan1.add(img1);
        pan1.add(img2);
        pan1.add(img3);
        pan1.add(img4);

        getContentPane().add(pan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 150));

        pan2.setBackground(new java.awt.Color(153, 102, 255));
        pan2.setLayout(new java.awt.GridLayout(1, 0));
        pan2.add(img5);
        pan2.add(img6);
        pan2.add(img7);
        pan2.add(img8);

        getContentPane().add(pan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 620, 150));

        pan3.setBackground(new java.awt.Color(51, 51, 255));
        pan3.setLayout(new java.awt.GridLayout(1, 0));
        pan3.add(img9);
        pan3.add(img10);
        pan3.add(img11);

        img12.setBackground(new java.awt.Color(51, 255, 51));
        pan3.add(img12);

        getContentPane().add(pan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 620, 160));

        show.setBackground(new java.awt.Color(255, 204, 51));
        show.setText("show");
        show.setOpaque(true);
        getContentPane().add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 660, 640));
        getContentPane().add(list1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 200, 180));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 90, 40));

        keyWord.setBackground(new java.awt.Color(0, 0, 0));
        keyWord.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        keyWord.setForeground(new java.awt.Color(255, 153, 255));
        keyWord.setText("Write class that image belong it");
        keyWord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                keyWordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                keyWordFocusLost(evt);
            }
        });
        keyWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyWordMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyWordMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyWordMouseReleased(evt);
            }
        });
        keyWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyWordKeyReleased(evt);
            }
        });
        jPanel1.add(keyWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 40));

        previous.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        previous.setText("<<<");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });
        jPanel1.add(previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, 40));

        next.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        next.setText(">>>");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        jPanel1.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 100, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Exe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 60, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 300, 90));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Save");
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 100, 40));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setText("Select *");
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 300, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keyWordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keyWordFocusGained
        if (keyWord.getForeground().getRGB() == -26113) {
            keyWord.setText("");
            keyWord.setForeground(Color.white);
        }
    }//GEN-LAST:event_keyWordFocusGained

    private void keyWordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyWordMouseExited

    }//GEN-LAST:event_keyWordMouseExited

    private void keyWordMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyWordMouseReleased

    }//GEN-LAST:event_keyWordMouseReleased

    private void keyWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyWordMouseClicked

    }//GEN-LAST:event_keyWordMouseClicked

    private void keyWordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keyWordFocusLost
        if (keyWord.getText().equals("")) {
            keyWord.setForeground(new Color(-26113));
            keyWord.setText("Write class that image belong it");
        }
    }//GEN-LAST:event_keyWordFocusLost

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        sdb.nextImgSection();
    }//GEN-LAST:event_nextActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        sdb.previousImgSection();
    }//GEN-LAST:event_previousActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JLabel labs[] = {img1, img2, img3, img4, img5, img6, img7, img8, img9, img2, img2, img2, img2};
        sdb.getImages(labs);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void keyWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyWordKeyReleased
        sdb.getALLKeyWords(keyWord.getText().trim(), list1);
    }//GEN-LAST:event_keyWordKeyReleased

    private void img1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img1MouseEntered
        //        System.out.println(show.getWidth());
        //        System.out.println(show.getHeight());
        sdb.getImage(img1,show);
    }//GEN-LAST:event_img1MouseEntered

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
            java.util.logging.Logger.getLogger(Showing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Showing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Showing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Showing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Showing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img10;
    private javax.swing.JLabel img11;
    private javax.swing.JLabel img12;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel img4;
    private javax.swing.JLabel img5;
    private javax.swing.JLabel img6;
    private javax.swing.JLabel img7;
    private javax.swing.JLabel img8;
    private javax.swing.JLabel img9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField keyWord;
    private java.awt.List list1;
    public static javax.swing.JButton next;
    private javax.swing.JPanel pan1;
    private javax.swing.JPanel pan2;
    private javax.swing.JPanel pan3;
    public static javax.swing.JButton previous;
    private javax.swing.JLabel show;
    // End of variables declaration//GEN-END:variables
}
