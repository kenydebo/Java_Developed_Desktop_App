package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.Toolkit;
import gui.AgentMainFrame_1;

public class MainFrame extends javax.swing.JFrame {

    // Fields and Properties
    // Used to cascade frames
    private int previousLocationX = 0;
    private int previousLocationY = 0;
    private Point cascadePoint = new Point(0,0);
    private int cascadeOffset = 20;
    int openeNew;
    AgentMainFrame_1 agentFrame ;
    PackageMainFrame packageFrame;
    CustomerFrame customerFrame;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        agentFrame = new AgentMainFrame_1();
        jDesktopPaneMain.add(agentFrame);
        packageFrame = new PackageMainFrame();
        jDesktopPaneMain.add(packageFrame);
        customerFrame = new CustomerFrame();
        jDesktopPaneMain.add(customerFrame);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneMain = new javax.swing.JDesktopPane();
        jMenuBarMain = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuTools = new javax.swing.JMenu();
        jMenuItemAgentTool = new javax.swing.JMenuItem();
        jMenuItemPackageTool = new javax.swing.JMenuItem();
        jMenuItemCustomer = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Travel Experts Maintenance Tool");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/icon.png")));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jDesktopPaneMain.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jDesktopPaneMain.setMinimumSize(new java.awt.Dimension(1200, 900));

        javax.swing.GroupLayout jDesktopPaneMainLayout = new javax.swing.GroupLayout(jDesktopPaneMain);
        jDesktopPaneMain.setLayout(jDesktopPaneMainLayout);
        jDesktopPaneMainLayout.setHorizontalGroup(
            jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        jDesktopPaneMainLayout.setVerticalGroup(
            jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );

        jMenuFile.setText("Application");
        jMenuFile.setActionCommand("");
        jMenuFile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBarMain.add(jMenuFile);

        jMenuTools.setText("Maintenance");
        jMenuTools.setToolTipText("");
        jMenuTools.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItemAgentTool.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemAgentTool.setText("Agent Tool");
        jMenuItemAgentTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgentToolActionPerformed(evt);
            }
        });
        jMenuTools.add(jMenuItemAgentTool);

        jMenuItemPackageTool.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemPackageTool.setText("Package Tool");
        jMenuItemPackageTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPackageToolActionPerformed(evt);
            }
        });
        jMenuTools.add(jMenuItemPackageTool);

        jMenuItemCustomer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCustomer.setText("Customer Tool");
        jMenuItemCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCustomerActionPerformed(evt);
            }
        });
        jMenuTools.add(jMenuItemCustomer);

        jMenuBarMain.add(jMenuTools);

        jMenuHelp.setText("Help");
        jMenuHelp.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemAbout);

        jMenuBarMain.add(jMenuHelp);

        setJMenuBar(jMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        // End the application
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemAgentToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgentToolActionPerformed
        
        //if (AgentMainFrame_1 == null)
        //{
            // Open new AgentMainFrame
            if(agentFrame.isClosed())
            {

                agentFrame = new AgentMainFrame_1();

                jDesktopPaneMain.add(agentFrame);

                cascadePoint.x += cascadeOffset;
                cascadePoint.y += cascadeOffset;
                agentFrame.setLocation(cascadePoint.x, cascadePoint.y);
                if (cascadePoint.x == 200)
                {
                    cascadePoint.x = 0;
                    cascadePoint.y = 0;
                }   
            }
            agentFrame.moveToFront(); 

            agentFrame.setVisible(true);
        //}
        
    }//GEN-LAST:event_jMenuItemAgentToolActionPerformed

    private void jMenuItemPackageToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPackageToolActionPerformed
        // Open new PackageMainFrame
        if(packageFrame.isClosed())
        {
            packageFrame = new PackageMainFrame();
            jDesktopPaneMain.add(packageFrame);

            cascadePoint.x += cascadeOffset;
            cascadePoint.y += cascadeOffset;
            packageFrame.setLocation(cascadePoint.x, cascadePoint.y);
        }
        packageFrame.moveToFront(); 
    
        packageFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItemPackageToolActionPerformed

    private void jMenuItemCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCustomerActionPerformed
     
        if(customerFrame.isClosed())
        {
            customerFrame = new CustomerFrame();
            jDesktopPaneMain.add(customerFrame);
            cascadePoint.x += cascadeOffset;
            cascadePoint.y += cascadeOffset;
            customerFrame.setLocation(cascadePoint.x,cascadePoint.y);
        }
        customerFrame.moveToFront();
        customerFrame.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemCustomerActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        // Create and display dialog object 
        AboutDialog ppDialog = new AboutDialog(null,true);
        ppDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPaneMain;
    private javax.swing.JMenuBar jMenuBarMain;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemAgentTool;
    private javax.swing.JMenuItem jMenuItemCustomer;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemPackageTool;
    private javax.swing.JMenu jMenuTools;
    // End of variables declaration//GEN-END:variables

    
}
