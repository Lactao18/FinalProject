/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkgfinal.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marc Louis A. Lactao
 */
public class Dashboard extends javax.swing.JFrame {
    public static ArrayList<Products> productList = new ArrayList<>();
    public static ArrayList<CustomerInfo> customerList = new ArrayList<>();
     
    private String name;
    private String email;
    private String password;
    
    public void removeProductsWithDeletedCategories() {
    DefaultTableModel model = (DefaultTableModel) prodtable.getModel();

    
    ArrayList<String> validCategories = new ArrayList<>();
    for (String c : ManageCategory.categoryList) {
        validCategories.add(c);
    }

    for (int i = model.getRowCount() - 1; i >= 0; i--) {
        String categoryInRow = model.getValueAt(i, 5).toString();
        boolean categoryExists = validCategories.stream()
                .anyMatch(c -> c.equalsIgnoreCase(categoryInRow));
        if (!categoryExists) {
            String codeToDelete = model.getValueAt(i, 0).toString();
            model.removeRow(i);
            productList.removeIf(p -> p.getCode().equalsIgnoreCase(codeToDelete));
        }
    }

    saveProductsToFile();
}

    
    
      public void updateProductTable() {
    DefaultTableModel model = (DefaultTableModel) prodtable.getModel();
    model.setRowCount(0);

    for (Products p : productList) {
        model.addRow(new Object[]{
            p.getCode(),
            p.getName(),
            p.getPrice(),
            p.getQuantity(),
            p.getStatus(),
            p.getCategory()
        });
    }
}
public void loadProductsToTable() {
    DefaultTableModel model = (DefaultTableModel) prodtable.getModel();
    model.setRowCount(0);

    for (Products p : productList) {
        model.addRow(new Object[] {
            p.getCode(),
            p.getName(),
            p.getPrice(),
            p.getQuantity(),
            p.getStatus(),
            p.getCategory()
        });
    }
}

    public Dashboard(String name, String email, String password) {
        initComponents();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    
    public Dashboard() {
        initComponents();
        loadProductsFromFile();
        loadProductsToTable();
        
    }
    
    public static void deductProductQuantity(String productCode, int quantityToDeduct) {
        for (Products p : productList) {
            if (p.getCode().equalsIgnoreCase(productCode)) {
                int newQuantity = p.getQuantity() - quantityToDeduct;
                if (newQuantity < 0) {
                    JOptionPane.showMessageDialog(null, "Not enough stock for " + p.getName(), "Stock Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Products updated = new Products(
                    p.getCode(),
                    p.getName(),
                    p.getPrice(),
                    newQuantity,
                    p.getStatus(),
                    p.getCategory()
                );
                productList.set(productList.indexOf(p), updated);
                saveProductsToFile();
                break;
            }
        }
    }
    
    public static void saveProductsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("products.txt"))) {
        for (Products p : productList) {
            writer.println(p.getCode() + "," +
                           p.getName() + "," +
                           p.getPrice() + "," +
                           p.getQuantity() + "," +
                           p.getStatus() + "," +
                           p.getCategory());
        }
        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }
    
    public static void loadProductsFromFile() {
        productList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String code = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    String status = parts[4];
                    String category = parts[5];
                    productList.add(new Products(code, name, price, quantity, status, category));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        prodtable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();
        UserButton = new javax.swing.JButton();
        ProductButton = new javax.swing.JButton();
        CustomerButton = new javax.swing.JButton();
        OrderButton = new javax.swing.JButton();
        ViewOrderButton = new javax.swing.JButton();
        CategoryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        UpdateProductButtton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        prodtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Product Name", "Price", "Quantity", "Status", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(prodtable);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        UserButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        UserButton.setText("USER");
        UserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserButtonActionPerformed(evt);
            }
        });

        ProductButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        ProductButton.setText("PRODUCT");
        ProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductButtonActionPerformed(evt);
            }
        });

        CustomerButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        CustomerButton.setText("CUSTOMER");
        CustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerButtonActionPerformed(evt);
            }
        });

        OrderButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        OrderButton.setText("ORDER");
        OrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderButtonActionPerformed(evt);
            }
        });

        ViewOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        ViewOrderButton.setText("VIEW ORDER HISTORY");
        ViewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewOrderButtonActionPerformed(evt);
            }
        });

        CategoryButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        CategoryButton.setText("CATEGORY");
        CategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CategoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserButton, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(CustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(OrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(ViewOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CustomerButton, OrderButton, ProductButton, UserButton, ViewOrderButton});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(UserButton)
                .addGap(37, 37, 37)
                .addComponent(ProductButton)
                .addGap(31, 31, 31)
                .addComponent(CategoryButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CustomerButton)
                .addGap(35, 35, 35)
                .addComponent(OrderButton)
                .addGap(27, 27, 27)
                .addComponent(ViewOrderButton)
                .addGap(80, 80, 80)
                .addComponent(ExitButton)
                .addGap(25, 25, 25))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inventory and Sales Management System");

        UpdateProductButtton.setBackground(new java.awt.Color(51, 51, 51));
        UpdateProductButtton.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        UpdateProductButtton.setForeground(new java.awt.Color(255, 255, 255));
        UpdateProductButtton.setText("Update Product");
        UpdateProductButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateProductButttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(UpdateProductButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(UpdateProductButtton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserButtonActionPerformed
        new UserLoggedInFrame(name, email, password).setVisible(true);
        this.dispose();
     
    }//GEN-LAST:event_UserButtonActionPerformed

    private void ProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductButtonActionPerformed
        new ProductFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProductButtonActionPerformed

    private void OrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderButtonActionPerformed
        new OrderFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_OrderButtonActionPerformed

    private void ViewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewOrderButtonActionPerformed
        new ViewOrderHistoryFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ViewOrderButtonActionPerformed

    private void CategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryButtonActionPerformed
        new ManageCategory(this).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CategoryButtonActionPerformed

    private void CustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerButtonActionPerformed
        new CustomerFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CustomerButtonActionPerformed

    private void UpdateProductButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateProductButttonActionPerformed
        int row = prodtable.getSelectedRow();
        if (row < 0) {
        JOptionPane.showMessageDialog(this, "Please select a row", "Try Again", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        Products selectedProduct = productList.get(row);
        
        new ProductFrame(selectedProduct, true).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_UpdateProductButttonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        new MainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        updateProductTable();
        removeProductsWithDeletedCategories();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CategoryButton;
    private javax.swing.JButton CustomerButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton OrderButton;
    private javax.swing.JButton ProductButton;
    private javax.swing.JButton UpdateProductButtton;
    private javax.swing.JButton UserButton;
    private javax.swing.JButton ViewOrderButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable prodtable;
    // End of variables declaration//GEN-END:variables
}
