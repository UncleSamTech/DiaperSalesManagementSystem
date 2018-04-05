/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package o_osoftwaresuite;

import framescroller.Positioning1;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author SAMUEL
 */
public class O_OStaffZone extends javax.swing.JFrame {

    /**
     * Creates new form O_OStaffZone
     */
    public O_OStaffZone() {
        initComponents();
        initConnection();
        enableScroller();
        getSystemDate();
        managerDispPanel.setVisible(false);
        distributionPanel.setVisible(false);
        loadingLabel.setVisible(false);
        newLocTField.setVisible(false);
        addLocButton.setVisible(false);
        
        invButton.setVisible(false);
        invTField.setVisible(false);
        resultPanel.setVisible(false);
        invPanel.setVisible(false);
        

    }

	
	

    Statement state;
    DriverManager dManager;
    ResultSet rSet;
    Connection connection;
    final String DATABASE = "jdbc:mysql://localhost:3306/o_odb";
    final String USER_NAME = "root";
    final String PASS_WORD = "";

   
    




private void retrCustDetails(){
        try {
            state = connection.createStatement();
            final String RETR_CUS = "Select fullName, customerType, phone , customer_id from customertable";
            System.out.println(RETR_CUS);
            rSet  = state.executeQuery(RETR_CUS);
            if(rSet.next()){
                 JOptionPane.showMessageDialog(this, "Retreival was Sucessful", "Success Alert", JOptionPane.INFORMATION_MESSAGE);
                custDetTable.setModel(DbUtils.resultSetToTableModel(rSet));
               
            }
            else{JOptionPane.showMessageDialog(this, "Unable to retreive info", "Error Alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage()) ;
}

}	
double dbBal = 0.00;
private double genLedBal(String cName){
        
        try {
            state =  connection.createStatement();
            final String RETR_LAST_BAL = "Select ledgBal from totalsales where customer_id = " + "'" + cName + "'" + "order by id desc";
            System.out.println(RETR_LAST_BAL);
            rSet = state.executeQuery(RETR_LAST_BAL);
            if(rSet.next()){
                dbBal =  rSet.getDouble("ledgBal");
            }
else{JOptionPane.showMessageDialog(this, "Unable to retreive Balance..", "Error Alert", JOptionPane.ERROR_MESSAGE);}
        }
            catch(SQLException ex){JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());}
return dbBal;}




 private String retrCustId(String name){
        try {
            state =  connection.createStatement();
            final String RETR = "Select customer_id from customertable where fullName = " + "'" + name + "'";
            System.out.println(RETR);
            rSet  =  state.executeQuery(RETR);
            if(rSet.next()){
                JOptionPane.showMessageDialog(this, "Retreival successful");
                retrId = (String)rSet.getObject("customer_id");
            }   } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage(), "Error Alert", JOptionPane.ERROR_MESSAGE);
            
        }
   
        return retrId;
    }
   
   String retrId = "";
    
    
    
    private void initConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE, USER_NAME, PASS_WORD);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Unable to establish connection" + ex);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, "Unable to establish connection as a result of " + exc);
        } finally {
            JOptionPane.showMessageDialog(this, "Connection Established");
        }
    }

    int finalValue = 0;
    int enteredValue = 0;
    int receivedValue = 0;

    private int topQty(String prodType, String loc) {
        try {
            enteredValue = Integer.parseInt(qtyRecTField.getText());

            state = connection.createStatement();
            final String RETR_LAST_QTY = "select qty_in_stock from pamp_warehouse where prod_type = " + "'" + prodType + "'" + "and location = " + "'" + loc + "'" + "order by id Desc ";
            rSet = state.executeQuery(RETR_LAST_QTY);
            if (rSet.next()) {
                receivedValue = rSet.getInt("qty_in_stock");
                finalValue = enteredValue + receivedValue;

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }

        return finalValue;
    }

    private void enableScroller() {
        Positioning1 positioning1 = new Positioning1(this);
        positioning1.setShouldDoMove(true);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        staffTab = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        prodTypeCombo = new javax.swing.JComboBox();
        wareHousePanel = new javax.swing.JPanel();
        qtyRecTField = new javax.swing.JTextField();
        prodUnitPriceTField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        prodRetrCombo = new javax.swing.JComboBox();
        distributionPanel = new javax.swing.JPanel();
        qtyRemDist = new javax.swing.JLabel();
        unitPriceDist = new javax.swing.JLabel();
        locDistrCombo = new javax.swing.JComboBox();
        qtyDistrTField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        amtEquivTField = new javax.swing.JTextField();
        loadingLabel = new javax.swing.JLabel();
        distrCashBalance = new javax.swing.JTextField();
        newLocTField = new javax.swing.JTextField();
        addLocButton = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        invPanel = new javax.swing.JPanel();
        searchTField = new javax.swing.JTextField();
        searchCombo = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        resultPanel = new javax.swing.JPanel();
        qtyLeftInv = new javax.swing.JTextField();
        prodUnitInv = new javax.swing.JTextField();
        cashEquiInv = new javax.swing.JTextField();
        invCombo = new javax.swing.JComboBox();
        invTField = new javax.swing.JTextField();
        invButton = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        userTab = new javax.swing.JTabbedPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        userCreateCombo = new javax.swing.JComboBox();
        userCreatePanel = new javax.swing.JPanel();
        nameTField = new javax.swing.JTextField();
        userNameTField = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        passWordTField = new javax.swing.JPasswordField();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        deletionCombo = new javax.swing.JComboBox();
        deletionPanel = new javax.swing.JPanel();
        deletionTField = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        userViewCombo = new javax.swing.JComboBox();
        jScrollPane10 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        retrViewDistrCombo = new javax.swing.JComboBox();
        jScrollPane12 = new javax.swing.JScrollPane();
        retrTable = new javax.swing.JTable();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        cusSearchPanel = new javax.swing.JPanel();
        customerSearchTField = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        customerResultTable = new javax.swing.JTable();
        cusSeleCombo = new javax.swing.JComboBox();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        describeDisplayLabel = new javax.swing.JLabel();
        ledgBalLabel = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        totolSalesTable = new javax.swing.JTable();
        phoneLabel = new javax.swing.JLabel();
        cusTypeLabel = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        dashBoardPanel = new javax.swing.JPanel();
        managerDispPanel = new javax.swing.JPanel();
        totAmtLabelMan = new javax.swing.JLabel();
        totAmtChargedDash = new javax.swing.JLabel();
        totAccruedDisc = new javax.swing.JTextField();
        totAmtOfCashReceived = new javax.swing.JLabel();
        totLedgBal = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        reportCustomerLabel = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        custRetrComb = new javax.swing.JComboBox();
        jScrollPane16 = new javax.swing.JScrollPane();
        custDetTable = new javax.swing.JTable();
        jScrollPane18 = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        distrIDTField = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        systemDate = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(102, 0, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pix/icons/o_o loggo.JPG"))); // NOI18N
        jLabel2.setText("GENERAL ENTERPRISE II");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pix/gnome_panel_force_quit.png"))); // NOI18N
        jLabel3.setToolTipText("ClosingApplication");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pix/navigate-down-icon.png"))); // NOI18N
        jLabel4.setToolTipText("minimizingApplication");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        staffTab.setForeground(new java.awt.Color(102, 0, 0));
        staffTab.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pix/icons/detail item.jpg"))); // NOI18N
        jLabel5.setText("REGISTER NEW ITEM");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "stockUp Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        prodTypeCombo.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        prodTypeCombo.setForeground(new java.awt.Color(102, 0, 0));
        prodTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Product Type---", "CARRY PACK NEW BORN(12 * 10)", "CARRY PACK MINI(10 * 10)", "CARRY PACK MEDIUM(9 * 10)", "CARRY PACK MAXI(8 * 10)", "CARRY PACK JNR(7 * 10)", "ECO PACK NEW BORN(52 * 4)", "ECO PACK MINI(42 * 4)", "ECO PACK MEDIUM(38 * 4)", "ECO  PACK MAXI(34 * 4)", "ECO PACK JNR(30 * 4)", "JUMBO PACK NEW BORN(105 * 3)", "JUMBO PACK MINI(100 * 3)", "JUMBO PACK MEDIUM(92 * 3)", "JUMBO PACK MAXI(84 * 3)", "JUMBO PACK JNR(74 * 3)" }));
        prodTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodTypeComboActionPerformed(evt);
            }
        });

        wareHousePanel.setBackground(new java.awt.Color(255, 255, 255));
        wareHousePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Warehouse Panel[*highly sensitive]", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        qtyRecTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Quantity Received[*strictly numbers]", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        prodUnitPriceTField.setForeground(new java.awt.Color(102, 0, 0));
        prodUnitPriceTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Product Unit Price[*strictly numbers]", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        prodUnitPriceTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodUnitPriceTFieldActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 0));
        jButton1.setText("STOCK UP    >    >    >    >    >");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wareHousePanelLayout = new javax.swing.GroupLayout(wareHousePanel);
        wareHousePanel.setLayout(wareHousePanelLayout);
        wareHousePanelLayout.setHorizontalGroup(
            wareHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wareHousePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
            .addGroup(wareHousePanelLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(wareHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(prodUnitPriceTField, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyRecTField, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        wareHousePanelLayout.setVerticalGroup(
            wareHousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wareHousePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qtyRecTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(prodUnitPriceTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(prodTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(wareHousePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(prodTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wareHousePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 0));
        jButton2.setText("NEXT   >   >   >   >");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 0));
        jButton3.setText("<   <   <   <   BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 673, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton3)
                        .addContainerGap(125, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(28, 28, 28))))
        );

        jScrollPane1.setViewportView(jPanel2);

        staffTab.addTab("STOCK UP GOODS", jScrollPane1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Traditional Arabic", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pix/icons/distributepix.gif"))); // NOI18N
        jLabel6.setText("DISTRIBUTE GOODS TO BRANCHES");

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 0, 0));
        jButton5.setText("NEXT   >    >    >    >");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(102, 0, 0));
        jButton7.setText("<    <    <    <    BACK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        prodRetrCombo.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        prodRetrCombo.setForeground(new java.awt.Color(102, 0, 0));
        prodRetrCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Product---", "CARRY PACK NEW BORN(12 * 10)", "CARRY PACK MINI(10 * 10)", "CARRY PACK MEDIUM(9 * 10)", "CARRY PACK MAXI(8 * 10)", "CARRY PACK JNR(7 * 10)", "ECO PACK NEW BORN(52 * 4)", "ECO PACK MINI(42 * 4)", "ECO PACK MEDIUM(38 * 4)", "ECO  PACK MAXI(34 * 4)", "ECO PACK JNR(30 * 4)", "JUMBO PACK NEW BORN(105 * 3)", "JUMBO PACK MINI(100 * 3)", "JUMBO PACK MEDIUM(92 * 3)", "JUMBO PACK MAXI(84 * 3)", "JUMBO PACK JNR(74 * 3)" }));
        prodRetrCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodRetrComboActionPerformed(evt);
            }
        });

        distributionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "distributionPanel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        distributionPanel.setOpaque(false);

        qtyRemDist.setBackground(new java.awt.Color(255, 255, 255));
        qtyRemDist.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        qtyRemDist.setForeground(new java.awt.Color(102, 0, 0));
        qtyRemDist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        qtyRemDist.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qty Remaining", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        qtyRemDist.setOpaque(true);

        unitPriceDist.setBackground(new java.awt.Color(255, 255, 255));
        unitPriceDist.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        unitPriceDist.setForeground(new java.awt.Color(102, 0, 0));
        unitPriceDist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unitPriceDist.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unit Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N
        unitPriceDist.setOpaque(true);

        locDistrCombo.setEditable(true);
        locDistrCombo.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        locDistrCombo.setForeground(new java.awt.Color(102, 0, 0));
        locDistrCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Targetted Distribution Point---", "Katsina Branch", "Funtua Branch", "Jibia Branch", "Add More" }));
        locDistrCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locDistrComboActionPerformed(evt);
            }
        });

        qtyDistrTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Qty", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        qtyDistrTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyDistrTFieldActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 0, 0));
        jButton4.setText("DISTRIBUTE   >   >");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(102, 0, 0));
        jButton8.setText("|   |   C   L   E   A   R   |   |");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        amtEquivTField.setEditable(false);
        amtEquivTField.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        amtEquivTField.setForeground(new java.awt.Color(102, 0, 0));
        amtEquivTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AmtEquivalent", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N
        amtEquivTField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amtEquivTFieldMouseClicked(evt);
            }
        });

        loadingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pix/loading36.gif"))); // NOI18N

        distrCashBalance.setEditable(false);
        distrCashBalance.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        distrCashBalance.setForeground(new java.awt.Color(102, 0, 0));
        distrCashBalance.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Goods Cash Balance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N
        distrCashBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distrCashBalanceActionPerformed(evt);
            }
        });

        newLocTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add New Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N
        newLocTField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newLocTFieldMouseEntered(evt);
            }
        });

        addLocButton.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        addLocButton.setForeground(new java.awt.Color(102, 0, 0));
        addLocButton.setText("ADD >   >   >");
        addLocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLocButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout distributionPanelLayout = new javax.swing.GroupLayout(distributionPanel);
        distributionPanel.setLayout(distributionPanelLayout);
        distributionPanelLayout.setHorizontalGroup(
            distributionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, distributionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(distributionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(distrCashBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addGroup(distributionPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addLocButton)))
                .addGroup(distributionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(distributionPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(qtyRemDist, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(unitPriceDist, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(distributionPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(newLocTField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(distributionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(distributionPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(locDistrCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(qtyDistrTField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(amtEquivTField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(distributionPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton8)
                        .addGap(38, 38, 38)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(loadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        distributionPanelLayout.setVerticalGroup(
            distributionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(distributionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(distributionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(qtyRemDist, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(distrCashBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitPriceDist, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(distributionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(qtyDistrTField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(amtEquivTField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(locDistrCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(distributionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton4)
                    .addComponent(loadingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newLocTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLocButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(102, 0, 0));
        jButton10.setText("NEXT   >   >   >   >");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(102, 0, 0));
        jButton11.setText("<   <   <   <   B   A  C   K");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(354, 354, 354)
                                .addComponent(prodRetrCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2450, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(distributionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(182, 182, 182))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prodRetrCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(distributionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 580, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addGap(379, 379, 379)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel3);

        staffTab.addTab("DISTRIBUTION DASHBOARD", jScrollPane2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        invPanel.setBackground(new java.awt.Color(255, 255, 255));
        invPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "searchPanel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        searchTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "enter text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        searchCombo.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        searchCombo.setForeground(new java.awt.Color(102, 0, 0));
        searchCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Search Criteria---", "Search By Product Id", "Search By Product Name" }));
        searchCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(102, 0, 0));
        jButton6.setText("Search ?  ?  ?");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout invPanelLayout = new javax.swing.GroupLayout(invPanel);
        invPanel.setLayout(invPanelLayout);
        invPanelLayout.setHorizontalGroup(
            invPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(invPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(invPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTField, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        invPanelLayout.setVerticalGroup(
            invPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invPanelLayout.createSequentialGroup()
                .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(searchTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap())
        );

        resultPanel.setBackground(new java.awt.Color(255, 255, 255));
        resultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "searchResultPanel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        qtyLeftInv.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qty Left", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        prodUnitInv.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        prodUnitInv.setForeground(new java.awt.Color(102, 0, 0));
        prodUnitInv.setText(".");
        prodUnitInv.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Unit Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        cashEquiInv.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        cashEquiInv.setText(".");
        cashEquiInv.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cash Equivalent", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cashEquiInv, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(qtyLeftInv)
                    .addComponent(prodUnitInv))
                .addGap(90, 90, 90))
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(qtyLeftInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(prodUnitInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(cashEquiInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        invCombo.setEditable(true);
        invCombo.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        invCombo.setForeground(new java.awt.Color(102, 0, 0));
        invCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Inventory Search Location---", "WareHouse", "Katsina Branch", "Funtua Branch", "Jibia Branch", "Add More Location" }));
        invCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invComboActionPerformed(evt);
            }
        });

        invTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        invButton.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        invButton.setForeground(new java.awt.Color(102, 0, 0));
        invButton.setText("ADD >  >  >");
        invButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invButtonActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(102, 0, 0));
        jButton12.setText("NEXT   >   >   >   >");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(102, 0, 0));
        jButton13.setText("<   <   <   <   B   A   C   K");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(invPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(resultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(invCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(invTField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(invButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2396, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12)
                .addGap(167, 167, 167))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invButton))
                        .addGap(40, 40, 40)
                        .addComponent(resultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(invPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addContainerGap(556, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel4);

        staffTab.addTab("INVENTORY", jScrollPane3);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        userTab.setForeground(new java.awt.Color(102, 0, 0));
        userTab.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setForeground(new java.awt.Color(102, 0, 0));
        jPanel8.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N

        userCreateCombo.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        userCreateCombo.setForeground(new java.awt.Color(102, 0, 0));
        userCreateCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Type of User---", "Staff User", "Manager User" }));
        userCreateCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userCreateComboActionPerformed(evt);
            }
        });

        userCreatePanel.setBackground(new java.awt.Color(255, 255, 255));
        userCreatePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "userCreation Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        nameTField.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        nameTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        userNameTField.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        userNameTField.setForeground(new java.awt.Color(102, 0, 0));
        userNameTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter UserName", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        jButton16.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        jButton16.setForeground(new java.awt.Color(102, 0, 0));
        jButton16.setText("CREATE USER   >   >   >   >");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        passWordTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter PassWord", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        javax.swing.GroupLayout userCreatePanelLayout = new javax.swing.GroupLayout(userCreatePanel);
        userCreatePanel.setLayout(userCreatePanelLayout);
        userCreatePanelLayout.setHorizontalGroup(
            userCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userCreatePanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(userCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameTField)
                    .addComponent(userNameTField)
                    .addComponent(passWordTField, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userCreatePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton16)
                .addGap(96, 96, 96))
        );
        userCreatePanelLayout.setVerticalGroup(
            userCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userCreatePanelLayout.createSequentialGroup()
                .addComponent(nameTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userNameTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passWordTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton16))
        );

        jButton20.setText("NEXT >  >   >  >");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("<   <   <   <  B   A   C   K");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(userCreateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(userCreatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(284, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton20)
                .addGap(93, 93, 93))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(userCreateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userCreatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton20)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jButton21)
                        .addGap(125, 125, 125))))
        );

        jScrollPane7.setViewportView(jPanel8);

        userTab.addTab("CREATE USERS", jScrollPane7);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        deletionCombo.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        deletionCombo.setForeground(new java.awt.Color(102, 0, 0));
        deletionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Type of User---", "Remove Staff User", "Remove Manager User" }));
        deletionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletionComboActionPerformed(evt);
            }
        });

        deletionPanel.setBackground(new java.awt.Color(255, 255, 255));
        deletionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "deletionPanel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        deletionTField.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        deletionTField.setForeground(new java.awt.Color(102, 0, 0));
        deletionTField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deletionTField.setText(".");
        deletionTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        jButton17.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(102, 0, 0));
        jButton17.setText("<><> REMOVE <><>");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletionPanelLayout = new javax.swing.GroupLayout(deletionPanel);
        deletionPanel.setLayout(deletionPanelLayout);
        deletionPanelLayout.setHorizontalGroup(
            deletionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletionPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(deletionTField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton17)
                .addGap(60, 60, 60))
        );
        deletionPanelLayout.setVerticalGroup(
            deletionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletionPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(deletionTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton17)
                .addGap(26, 26, 26))
        );

        jButton22.setText("NEXT   >   >   >   >");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText("<   <   <   B   A   C   K");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(deletionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(deletionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton22)
                .addGap(60, 60, 60))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(deletionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(deletionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22)
                    .addComponent(jButton23))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jScrollPane8.setViewportView(jPanel9);

        userTab.addTab("REMOVE USERS", jScrollPane8);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        userViewCombo.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        userViewCombo.setForeground(new java.awt.Color(102, 0, 0));
        userViewCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Type of User---", "View All Users", "View All Staff Users", "View All Manager Users" }));
        userViewCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userViewComboActionPerformed(evt);
            }
        });

        userTable.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        userTable.setForeground(new java.awt.Color(102, 0, 0));
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "UserName", "PassWord"
            }
        ));
        jScrollPane10.setViewportView(userTable);

        jButton24.setText("NEXT   >   >   >   >");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("<   <   <   B   A   C   K");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(userViewCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(214, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton24)
                .addGap(42, 42, 42))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(userViewCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24)
                    .addComponent(jButton25))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jScrollPane9.setViewportView(jPanel10);

        userTab.addTab("VIEW ALL USERS", jScrollPane9);

        jButton18.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(102, 0, 0));
        jButton18.setText("NEXT   >   >   >   >");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(102, 0, 0));
        jButton19.setText("<   <   <   <   B   A   C   K");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(userTab, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton18)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(userTab, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton19))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel7);

        staffTab.addTab("CONTROL PANEL", jScrollPane6);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setForeground(new java.awt.Color(102, 0, 0));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "retreivalPanel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel12.setForeground(new java.awt.Color(102, 0, 0));

        retrViewDistrCombo.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        retrViewDistrCombo.setForeground(new java.awt.Color(102, 0, 0));
        retrViewDistrCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Retreival Criteria---", "Retreive Todays Distribution", "Retreive Old Distribution" }));
        retrViewDistrCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrViewDistrComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(retrViewDistrCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(retrViewDistrCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        retrTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product Distributed", "Unit Price", "Qty Distributed", "Amount Equivalent", "Date", "Targetted Location"
            }
        ));
        jScrollPane12.setViewportView(retrTable);

        jButton29.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        jButton29.setForeground(new java.awt.Color(102, 0, 0));
        jButton29.setText("NEXT   >   >   >");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        jButton30.setForeground(new java.awt.Color(102, 0, 0));
        jButton30.setText("<   <   <   B   A   C  K");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton30)
                        .addGap(991, 991, 991)
                        .addComponent(jButton29)))
                .addContainerGap(2200, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton29)
                    .addComponent(jButton30))
                .addContainerGap(518, Short.MAX_VALUE))
        );

        jScrollPane11.setViewportView(jPanel11);

        staffTab.addTab("VIEW DISTRIBUTED ITEMS", jScrollPane11);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        cusSearchPanel.setBackground(new java.awt.Color(255, 255, 255));
        cusSearchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "searchPanel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        customerSearchTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Text", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        jButton9.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        jButton9.setForeground(new java.awt.Color(102, 0, 0));
        jButton9.setText("Search ?  ?   ?");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cusSearchPanelLayout = new javax.swing.GroupLayout(cusSearchPanel);
        cusSearchPanel.setLayout(cusSearchPanelLayout);
        cusSearchPanelLayout.setHorizontalGroup(
            cusSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cusSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerSearchTField, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(cusSearchPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cusSearchPanelLayout.setVerticalGroup(
            cusSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cusSearchPanelLayout.createSequentialGroup()
                .addComponent(customerSearchTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        customerResultTable.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        customerResultTable.setForeground(new java.awt.Color(102, 0, 0));
        customerResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Sold", "Unit Price", "Quantity", "Amount Equivalent", "Sales Point", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerResultTable.setRowMargin(0);
        jScrollPane5.setViewportView(customerResultTable);

        cusSeleCombo.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        cusSeleCombo.setForeground(new java.awt.Color(102, 0, 0));
        cusSeleCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Search Criteria---", "Search By Customer Id", "Search Todays Transaction", "Search All" }));
        cusSeleCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusSeleComboActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(102, 0, 0));
        jButton14.setText("NEXT   >   >   >   >");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(102, 0, 0));
        jButton15.setText("<   <   <   <   B   A   C   K");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton26.setText("VIEW TOTAL");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("SEARCH DISPLAY FOR : ");

        describeDisplayLabel.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        describeDisplayLabel.setForeground(new java.awt.Color(102, 0, 0));

        ledgBalLabel.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        ledgBalLabel.setForeground(new java.awt.Color(102, 0, 0));
        ledgBalLabel.setToolTipText("");
        ledgBalLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Click Here for Curr Ledg Bal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        ledgBalLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ledgBalLabelMouseClicked(evt);
            }
        });

        totolSalesTable.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        totolSalesTable.setForeground(new java.awt.Color(102, 0, 0));
        totolSalesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Total Sales", "Amount Received", "Ledger Balance", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(totolSalesTable);

        phoneLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Phone ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        cusTypeLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(cusSeleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(describeDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ledgBalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cusTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(563, 563, 563)
                        .addComponent(jButton26))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(981, 981, 981)
                                .addComponent(jButton14))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cusSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(29, 38, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(describeDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(ledgBalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cusTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(cusSeleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(jButton26)
                        .addGap(93, 93, 93)
                        .addComponent(jButton14)
                        .addContainerGap(163, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cusSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton15)
                        .addGap(154, 154, 154))))
        );

        jScrollPane4.setViewportView(jPanel5);

        staffTab.addTab("CUSTOMER PORTAL", jScrollPane4);

        dashBoardPanel.setBackground(new java.awt.Color(255, 255, 255));
        dashBoardPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ManagerDashBoard[*highly classified]", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        managerDispPanel.setBackground(new java.awt.Color(255, 255, 255));

        totAmtLabelMan.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        totAmtLabelMan.setForeground(new java.awt.Color(102, 0, 0));
        totAmtLabelMan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Amount Equivalent", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        totAmtChargedDash.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        totAmtChargedDash.setForeground(new java.awt.Color(102, 0, 0));
        totAmtChargedDash.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Amount Charged", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        totAccruedDisc.setEditable(false);
        totAccruedDisc.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        totAccruedDisc.setForeground(new java.awt.Color(102, 0, 0));
        totAccruedDisc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Accrued Discount", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        totAmtOfCashReceived.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        totAmtOfCashReceived.setForeground(new java.awt.Color(102, 0, 0));
        totAmtOfCashReceived.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Cash Received", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        totLedgBal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Balance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N
        totLedgBal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totLedgBalActionPerformed(evt);
            }
        });

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pix/icons/1rightarrow.png"))); // NOI18N
        jButton27.setText("PRINT");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Report of : ");

        reportCustomerLabel.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        reportCustomerLabel.setForeground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout managerDispPanelLayout = new javax.swing.GroupLayout(managerDispPanel);
        managerDispPanel.setLayout(managerDispPanelLayout);
        managerDispPanelLayout.setHorizontalGroup(
            managerDispPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managerDispPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(managerDispPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(managerDispPanelLayout.createSequentialGroup()
                        .addGroup(managerDispPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totLedgBal, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totAmtOfCashReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totAccruedDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totAmtChargedDash, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totAmtLabelMan, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(managerDispPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reportCustomerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        managerDispPanelLayout.setVerticalGroup(
            managerDispPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managerDispPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(managerDispPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportCustomerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(managerDispPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managerDispPanelLayout.createSequentialGroup()
                        .addComponent(totAmtLabelMan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totAmtChargedDash, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(totAccruedDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(totAmtOfCashReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(totLedgBal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton31.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        jButton31.setForeground(new java.awt.Color(102, 0, 0));
        jButton31.setText("<   <   <   B   A   C   K");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashBoardPanelLayout = new javax.swing.GroupLayout(dashBoardPanel);
        dashBoardPanel.setLayout(dashBoardPanelLayout);
        dashBoardPanelLayout.setHorizontalGroup(
            dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardPanelLayout.createSequentialGroup()
                .addGroup(dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashBoardPanelLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(managerDispPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dashBoardPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton31)))
                .addContainerGap(637, Short.MAX_VALUE))
        );
        dashBoardPanelLayout.setVerticalGroup(
            dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(managerDispPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton31)
                .addContainerGap(370, Short.MAX_VALUE))
        );

        jScrollPane13.setViewportView(dashBoardPanel);

        staffTab.addTab("DASHBOARD", jScrollPane13);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setForeground(new java.awt.Color(102, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        custRetrComb.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        custRetrComb.setForeground(new java.awt.Color(102, 0, 0));
        custRetrComb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select Retreival Criteria---", "Retreive All" }));
        custRetrComb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custRetrCombActionPerformed(evt);
            }
        });

        custDetTable.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        custDetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Full Name", "Distributor Type", "Phone", "Customer ID"
            }
        ));
        jScrollPane16.setViewportView(custDetTable);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(custRetrComb, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custRetrComb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jScrollPane17.setViewportView(jPanel14);

        jTabbedPane1.addTab("VIEW ALL DISTRIBUTORS", jScrollPane17);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        distrIDTField.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        distrIDTField.setForeground(new java.awt.Color(102, 0, 0));
        distrIDTField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Distributors ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 1, 13), new java.awt.Color(102, 0, 0))); // NOI18N

        jButton28.setFont(new java.awt.Font("Traditional Arabic", 1, 13)); // NOI18N
        jButton28.setForeground(new java.awt.Color(102, 0, 0));
        jButton28.setText("REMOVE  >  >  >");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(distrIDTField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(472, Short.MAX_VALUE)
                .addComponent(jButton28)
                .addGap(415, 415, 415))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(distrIDTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButton28)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        jScrollPane18.setViewportView(jPanel15);

        jTabbedPane1.addTab("REMOVE DISTRIBUTOR", jScrollPane18);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jScrollPane15.setViewportView(jPanel13);

        staffTab.addTab("DISTRIBUTOR PANEL", jScrollPane15);

        systemDate.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        systemDate.setForeground(new java.awt.Color(102, 0, 0));
        systemDate.setText(".");

        welcomeLabel.setText(".");

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Current Date : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(systemDate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(staffTab, javax.swing.GroupLayout.PREFERRED_SIZE, 1340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(systemDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(welcomeLabel))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(staffTab, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        int x = JOptionPane.showConfirmDialog(this, "Do you really want to close app", "Confirmation Prompt", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            O_OAuthenticate.main(new String[]{});
        } else if (x == JOptionPane.NO_OPTION) {
            this.setVisible(true);
        } else {
            this.setVisible(true);
        }           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setExtendedState(ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1 - 1);
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
    String mainId = " ";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (prodUnitPriceTField.getText().equals("") || qtyRecTField.getText().equals("") || prodTypeCombo.getSelectedItem().equals("---Select Product Type---")) {
            JOptionPane.showMessageDialog(this, "Missing Parameters, Please Fill Up", "Ommision Alert", JOptionPane.WARNING_MESSAGE);
        } else if (prodUnitPriceTField.getText().equals("") & qtyRecTField.getText().equals("") & prodTypeCombo.getSelectedItem().equals("---Select Product Type---")) {
            JOptionPane.showMessageDialog(this, "Empty Parameters, Please Fill Up", "Error Alert", JOptionPane.ERROR_MESSAGE);
        } else {
            int x = JOptionPane.showConfirmDialog(this, "You are about to stock up data warehouse with " + qtyRecTField.getText() + " packs of " + prodTypeCombo.getSelectedItem() + "Click Yes to Confirm or No to Cancel", "Confirmation Dialog", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.NO_OPTION) {
                qtyRecTField.setText("");
                prodTypeCombo.getSelectedItem().equals("---Select Product Type---");
                prodUnitPriceTField.setText("");
            } else {
                stockUpWareHouse(getSystemDate(), "WareHouse", (String) prodTypeCombo.getSelectedItem(), topQty((String) prodTypeCombo.getSelectedItem(), "Warehouse"), Double.parseDouble(prodUnitPriceTField.getText()), genId(), genAmtEquivalent((String) prodTypeCombo.getSelectedItem(), "WareHouse"));
            }
        }
//regNewItem("",prodDescrTField.getText(),  Integer.parseInt(qtyRecTField.getText()), 0, Double.parseDouble(prodUnitPriceTField.getText()), 0.00, 0.00, 0.00, 0.00, 0.00, getSystemDate(), "", (String)prodTypeCombo.getSelectedItem());}// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    double unitPrice = 0.00;
    int qtyStock = 0;
    double amtEqui = 0;
    double finalAmtEqui = 0.00;

    private double genAmtEquivalent(String prodType, String loc) {
        try {
            state = connection.createStatement();
            unitPrice = Double.parseDouble(prodUnitPriceTField.getText());
            qtyStock = Integer.parseInt(qtyRecTField.getText());

            amtEqui = unitPrice * qtyStock;
            final String RETR_OLD_BAL = "Select amt_equivalent from pamp_warehouse where prod_type = " + "'" + prodType + "'" + "and location = " + "'" + loc + "'" + "order by id desc";
            System.out.println(RETR_OLD_BAL);
            rSet = state.executeQuery(RETR_OLD_BAL);
            if (rSet.next()) {
                finalAmtEqui = rSet.getDouble("amt_equivalent") + amtEqui;
            }

        } catch (SQLException ex) {
            Logger.getLogger(O_OStaffZone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return finalAmtEqui;
    }

    private String DistId() {
        String prodId = "";
        try {

            String prodName = (String) prodRetrCombo.getSelectedItem();
            mainId = prodName.substring(3);
            prodId = mainId + "01" + qtyDistrTField.getText(0, 2);

        } catch (BadLocationException ex) {
            Logger.getLogger(O_OStaffZone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prodId;
    }

    private String genId() {
        String prodId = "";
        try {

            String prodName = (String) prodTypeCombo.getSelectedItem();
            mainId = prodName.substring(3);
            prodId = mainId + "01" + qtyRecTField.getText(0, 2);

        } catch (BadLocationException ex) {
            Logger.getLogger(O_OStaffZone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prodId;
    }

    private void stockUpWareHouse(String date, String location, String prodType, int qtyAvail, double unitPrice, String prodId, double amtequi) {
        try {
            state = connection.createStatement();
            final String STOCK_UP = "Insert into pamp_warehouse(date,location,prod_type,qty_in_stock,unit_price,prod_id, amt_equivalent)values(" + "'" + date + "'," + "'" + location + "'," + "'" + prodType + "'," + "" + qtyAvail + "," + "" + unitPrice + "," + "'" + prodId + "'," + "" + amtequi + "" + ")";
            System.out.println(STOCK_UP);
            state.execute(STOCK_UP);
            JOptionPane.showMessageDialog(this, "New Item with ID : " + genId() + "has being added to data warehouse");
            prodUnitPriceTField.setText("");
            qtyRecTField.setText("");
            prodTypeCombo.setSelectedItem("---Select Product Type---");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
    }


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() - 1);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void prodUnitPriceTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodUnitPriceTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodUnitPriceTFieldActionPerformed
    final String loc = "WareHouse";

    private void retrProdInfo(String prodName) {
        try {
            state = connection.createStatement();
            final String RETR_PRDO_DETAILS = "Select qty_in_stock,unit_price, amt_equivalent from pamp_warehouse where prod_type = " + "'" + prodName + "'" + "and location = " + "'" + loc + "'" + "order by id desc";
            System.out.println(RETR_PRDO_DETAILS);
            rSet = state.executeQuery(RETR_PRDO_DETAILS);
            if (rSet.next()) {
                distributionPanel.setVisible(true);

                qtyRemDist.setText((Integer.toString(rSet.getInt("qty_in_stock"))));
                unitPriceDist.setText(Double.toString(rSet.getDouble("unit_price")));
                distrCashBalance.setText(Double.toString(rSet.getDouble("amt_equivalent")));

            } else {
                distributionPanel.setVisible(false);
                JOptionPane.showMessageDialog(this, "Item selected hasn't being stocked up..please do stock up", "Error Alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage(), "Error Alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void prodRetrComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodRetrComboActionPerformed
        if (prodRetrCombo.getSelectedItem().equals("---Select Product---")) {
            JOptionPane.showMessageDialog(this, "No Product Selected Yet", "Warning Message", JOptionPane.WARNING_MESSAGE);
            distributionPanel.setVisible(false);
        } else {
            retrProdInfo((String) prodRetrCombo.getSelectedItem());

        }// TODO add your handling code here:
    }//GEN-LAST:event_prodRetrComboActionPerformed

    private void prodTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodTypeComboActionPerformed
        if (prodTypeCombo.getSelectedItem().equals("---Select Product Type---")) {
            JOptionPane.showMessageDialog(this, "No valid selection made", "Error Alert", JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "You can now stock up : " + prodTypeCombo.getSelectedItem());
            wareHousePanel.setVisible(true);
        }// TODO add your handling code here:
    }//GEN-LAST:event_prodTypeComboActionPerformed
    double cashBalance = 0.00;
    double finalBalance = 0.00;

    private double genCashBalance() {
        amtEqui = Double.parseDouble(amtEquivTField.getText());
        cashBalance = Double.parseDouble(distrCashBalance.getText());
        if (amtEqui > cashBalance) {
            JOptionPane.showMessageDialog(this, "Cash Equivalent for distribution to " + locDistrCombo.getSelectedItem() + " detected is higher than cash balance...review your entry", "Error Alert", JOptionPane.ERROR_MESSAGE);
        } else if (amtEqui == cashBalance) {
            JOptionPane.showMessageDialog(this, "Match in cash equivalent detected for distribution to " + locDistrCombo.getSelectedItem() + "Please stock up as soon as possible", "Warning Message", JOptionPane.WARNING_MESSAGE);
            finalBalance = cashBalance - amtEqui;
            distrCashBalance.setText(Double.toString(finalBalance));
        } else {
            finalBalance = cashBalance - amtEqui;
            distrCashBalance.setText(Double.toString(finalBalance));
        }

        return finalBalance;
    }

    private void clearAl() {
        qtyRemDist.setText("");
        unitPriceDist.setText("");
        locDistrCombo.setSelectedItem("---Select Targetted Distribution Point---");
        qtyDistrTField.setText("");
        amtEquivTField.setText("");
        distrCashBalance.setText("");
    }
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
//        prodRetrCombo.setSelectedItem("---Select Product---"); 
        clearAl();// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void upDateAmtRem(double amtEqu, int qty, String loc, String prodType) {
        try {
            qty = Integer.parseInt(qtyRemDist.getText());
            amtEqu = Double.parseDouble(distrCashBalance.getText());
            state = connection.createStatement();
            final String UPDATE_AMT = String.format("Update pamp_warehouse set qty_in_stock = %s, amt_equivalent = %s where location = '%s' and prod_type = '%s' order by id desc", qty, amtEqu, loc, prodType);
            JOptionPane.showMessageDialog(this, "Update was sucessful");
            System.out.println(UPDATE_AMT);
            state.execute(UPDATE_AMT);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "update unsuccessful" + ex.getMessage());
        }

    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (prodRetrCombo.getSelectedItem().equals("") || distrCashBalance.getText().equals("") || qtyRemDist.getText().equals("") || unitPriceDist.getText().equals("") || locDistrCombo.getSelectedItem().equals("---Select Targetted Distribution Point---") || qtyDistrTField.getText().equals("") || amtEquivTField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Some fields are blank..fill up", "Ommision Alert", JOptionPane.WARNING_MESSAGE);
        } else if (prodRetrCombo.getSelectedItem().equals("") & distrCashBalance.getText().equals("") & qtyRemDist.getText().equals("") & unitPriceDist.getText().equals("") & locDistrCombo.getSelectedItem().equals("---Select Targetted Distribution Point---") & qtyDistrTField.getText().equals("") & amtEquivTField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All fields are blank..fill up", "Error Alert", JOptionPane.ERROR_MESSAGE);
        } else {
            int x = JOptionPane.showConfirmDialog(this, " You are about to distribute " + qtyDistrTField.getText() + " packs of " + prodRetrCombo.getSelectedItem() + " to " + locDistrCombo.getSelectedItem() + " Click YES to Deliver or NO to Cancel ", " Confirmation Prompt ", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION) {
                loadingLabel.setVisible(true);
                upDateAmtRem(Double.parseDouble(distrCashBalance.getText()), Integer.parseInt(qtyRemDist.getText()), "WareHouse", (String) prodRetrCombo.getSelectedItem());
                distributeGoods(getSystemDate(), (String) locDistrCombo.getSelectedItem(), (String) prodRetrCombo.getSelectedItem(), Integer.parseInt(qtyDistrTField.getText()), Double.parseDouble(unitPriceDist.getText()), DistId(), genDistrAmtEquivalent());

                loadingLabel.setVisible(false);
            } else if (x == JOptionPane.NO_OPTION) {
                this.setVisible(true);
                clearAl();
            } else {
                this.setVisible(true);
                clearAl();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void qtyDistrTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyDistrTFieldActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_qtyDistrTFieldActionPerformed

    private void distrCashBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distrCashBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distrCashBalanceActionPerformed

    private void amtEquivTFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amtEquivTFieldMouseClicked
        int x = JOptionPane.showConfirmDialog(this, "You just entered " + qtyDistrTField.getText() + " packs of " + prodRetrCombo.getSelectedItem() + " for distribution..Click Yes to Confirm or No to Cancel ", "Confirmation Message", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.NO_OPTION) {
            clearAl();
        } else {
            genDistrAmtEquivalent();
            genQtyRemDist();
            genCashBalance();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_amtEquivTFieldMouseClicked

    private void locDistrComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locDistrComboActionPerformed
        if (locDistrCombo.getSelectedItem().equals("Add More")) {
            newLocTField.setVisible(true);
            addLocButton.setVisible(true);
        } else {
            newLocTField.setVisible(false);
            addLocButton.setVisible(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_locDistrComboActionPerformed

    private void newLocTFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newLocTFieldMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_newLocTFieldMouseEntered

    private void addLocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLocButtonActionPerformed
        locDistrCombo.addItem(newLocTField.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_addLocButtonActionPerformed

    private void invComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invComboActionPerformed
        if (invCombo.getSelectedItem().equals("---Select Inventory Search Location---")) {
            invPanel.setVisible(false);
            resultPanel.setVisible(false);
            invTField.setVisible(false);
            invButton.setVisible(false);
            JOptionPane.showMessageDialog(this, "No valid selection made yet");
        } else if (invCombo.getSelectedItem().equals("Add More Location")) {
            invTField.setVisible(true);
            invButton.setVisible(true);
            invPanel.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Inventory Location is : " + invCombo.getSelectedItem());
            invPanel.setVisible(true);

            invTField.setVisible(false);
            invButton.setVisible(false);
        }// TODO add your handling code here:
    }//GEN-LAST:event_invComboActionPerformed

    private void invButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invButtonActionPerformed
        invCombo.addItem(invTField.getText());
        JOptionPane.showMessageDialog(this, "New location added sucessfully : ");
// TODO add your handling code here:
    }//GEN-LAST:event_invButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        if (searchCombo.getSelectedItem().equals("Search By Product Id")) {
            if (searchTField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "no value supplied yet");
            } else {

                searchByProdId(searchTField.getText(), (String) invCombo.getSelectedItem());
            }
        } else if (searchCombo.getSelectedItem().equals("Search By Product Name")) {
            if (searchTField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "no value supplied yet");
            } else {
                searchByProdName(searchTField.getText(), (String) invCombo.getSelectedItem());
            }
        } else {
            JOptionPane.showMessageDialog(this, "error as a result of invalid selection");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void searchComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboActionPerformed
        if (searchCombo.getSelectedItem().equals("---Select Search Criteria---")) {
            JOptionPane.showMessageDialog(this, "No search criteria selected");
            resultPanel.setVisible(false);
        } else if (searchCombo.getSelectedItem().equals("Search By Product Id")) {

            JOptionPane.showMessageDialog(this, "Selection is product search by Id");
        } else if (searchCombo.getSelectedItem().equals("Search By Product Name")) {
            JOptionPane.showMessageDialog(this, "Selection is product search by Name");
        }// TODO add your handling code here:
    }//GEN-LAST:event_searchComboActionPerformed

    private void retreiveByCusIDOnly(String cId) {
        try {
            state = connection.createStatement();
            final String RETR_C_NAME = "Select fullName, customerType, phone from customertable where customer_id = " + "'" + cId + "'";
            System.out.println(RETR_C_NAME);

            rSet = state.executeQuery(RETR_C_NAME);

            if (rSet.next()) {
                cusTypeLabel.setText((String) rSet.getObject("customerType"));
                phoneLabel.setText((String) rSet.getObject("phone"));
                describeDisplayLabel.setText((String) rSet.getObject("fullName"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getLocalizedMessage());
        }
    }

    private void retrCusIDTbl2(String cid) {

        try {
            state = connection.createStatement();
            final String RETR_C_SALES = "Select amtRec,ledgBal,totalSales, date from totalsales where customer_id = " + "'" + cid + "'";
            System.out.println(RETR_C_SALES);
            rSet = state.executeQuery(RETR_C_SALES);
            if (rSet.next()) {

                totolSalesTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful", "Success Alert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Wrong");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error As a result of : " + ex.getMessage());
        }
    }

    double totInvAmt = 0.00;
    double totTotSales = 0.00;

    private double getTotalInvForCus(String cId) {
        try {
            state = connection.createStatement();
            final String GET_INV = "Select sum(invoiceAmount) from dailySales where customer_id = " + "'" + cId + "'";
            rSet = state.executeQuery(GET_INV);
            if (rSet.next()) {
                totInvAmt = rSet.getDouble("sum(invoiceAmount)");
                totAmtLabelMan.setText(Double.toString(totInvAmt));
            } else {
                JOptionPane.showMessageDialog(this, "Wrong");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
        return totInvAmt;
    }
    
    
        private double getTotalInvForDate(String date) {
        try {
            state = connection.createStatement();
            final String GET_INV = "Select sum(invoiceAmount) from dailySales where date = " + "'" + date + "'";
            rSet = state.executeQuery(GET_INV);
            if (rSet.next()) {
                totInvAmt = rSet.getDouble("sum(invoiceAmount)");
                totAmtLabelMan.setText(Double.toString(totInvAmt));
            } else {
                JOptionPane.showMessageDialog(this, "Wrong");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
        return totInvAmt;
    }

        
        private double getTotalInvForAll() {
        try {
            state = connection.createStatement();
            final String GET_INV = "Select sum(invoiceAmount) from dailySales ";
            rSet = state.executeQuery(GET_INV);
            if (rSet.next()) {
                totInvAmt = rSet.getDouble("sum(invoiceAmount)");
                totAmtLabelMan.setText(Double.toString(totInvAmt));
            } else {
                JOptionPane.showMessageDialog(this, "Wrong");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
        return totInvAmt;
    }

    double indCustAccruedBal = 0.00;


    private double genTotBalonDate(){
    indCustAccruedBal = getTotalInvForDate(customerSearchTField.getText()) - getTotaSalesForDate(customerSearchTField.getText());
    totAccruedDisc.setText(Double.toString(indCustAccruedBal));
        return indCustAccruedBal;
    }
    private double genTotBalonAll(){
    indCustAccruedBal = getTotalInvForAll() - getTotaSalesForAll();
    totAccruedDisc.setText(Double.toString(indCustAccruedBal));
        return indCustAccruedBal;
    }
    
    
    
    
    
    private double genTotBalOnCust() {
        indCustAccruedBal = getTotalInvForCus(customerSearchTField.getText()) - getTotaSalesForCust(customerSearchTField.getText());
        totAccruedDisc.setText(Double.toString(indCustAccruedBal));
        return indCustAccruedBal;
    }

    private double getTotaSalesForCust(String cID) {
        try {
            state = connection.createStatement();
            final String GET_SALES = "Select sum(totalSales) from totalsales where customer_id = " + "'" + cID + "'";
            System.out.println(GET_SALES);
            rSet = state.executeQuery(GET_SALES);
            if (rSet.next()) {
                totTotSales = rSet.getDouble("sum(totalSales)");
                totAmtChargedDash.setText(Double.toString(totTotSales));
            } else {
                JOptionPane.showMessageDialog(this, "Wrong");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error As a result of : " + ex.getMessage());
        }
        return totTotSales;
    }
    
     private double getTotaSalesForDate(String date) {
        try {
            state = connection.createStatement();
            final String GET_SALES = "Select sum(totalSales) from totalsales where customer_id = " + "'" + date + "'";
            System.out.println(GET_SALES);
            rSet = state.executeQuery(GET_SALES);
            if (rSet.next()) {
                totTotSales = rSet.getDouble("sum(totalSales)");
                totAmtChargedDash.setText(Double.toString(totTotSales));
            } else {
                JOptionPane.showMessageDialog(this, "Wrong");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error As a result of : " + ex.getMessage());
        }
        return totTotSales;
    }
     
      private double getTotaSalesForAll() {
        try {
            state = connection.createStatement();
            final String GET_SALES = "Select sum(totalSales) from totalsales " ;
            System.out.println(GET_SALES);
            rSet = state.executeQuery(GET_SALES);
            if (rSet.next()) {
                totTotSales = rSet.getDouble("sum(totalSales)");
                totAmtChargedDash.setText(Double.toString(totTotSales));
            } else {
                JOptionPane.showMessageDialog(this, "Wrong");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error As a result of : " + ex.getMessage());
        }
        return totTotSales;
    }


    
    private void retrCusIdTab1(String cid) {
        try {
            state = connection.createStatement();
            final String RETR_C_DAILY = "Select itemSold, unitPrice, qtySold, invoiceAmount, location , date from dailysales where customer_id = " + "'" + cid + "'";
            System.out.println(RETR_C_DAILY);
            rSet = state.executeQuery(RETR_C_DAILY);
            if (rSet.next()) {
                customerResultTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful", "Success Alert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Wrong");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error As a result of : " + ex.getMessage());
        }
    }

    private void retrByDateTb1(String date) {
        try {
            state = connection.createStatement();
            final String RETR_DAIL_SALES = "Select itemSold, unitPrice, qtySold, invoiceAmount, location , date from dailysales where date = " + "'" + date + "'";
            System.out.println(RETR_DAIL_SALES);
            if (rSet.next()) {
                customerResultTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful", "Success Alert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Wrong");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }

    }

    private void retreiveByDate(String date) {
        try {
            state = connection.createStatement();

            final String RETR_C_SALES = "Select amtRec,ledgBal,totalSales, date from totalsales where date = " + "'" + date + "'";

            System.out.println(RETR_C_SALES);

// rSet = state.executeQuery(RETR_C_NAME);
            rSet = state.executeQuery(RETR_C_SALES);

            if (rSet.next()) {

                totolSalesTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful", "Success Alert", JOptionPane.INFORMATION_MESSAGE);
                describeDisplayLabel.setText("TODAYS SALES");
                phoneLabel.setText("null");
                cusTypeLabel.setText("null");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getLocalizedMessage());
        }
    }

    private void retreiveByAll() {
        try {
            state = connection.createStatement();

            final String RETR_C_SALES = "Select amtRec,ledgBal,totalSales, date from totalsales  ";

            System.out.println(RETR_C_SALES);

            rSet = state.executeQuery(RETR_C_SALES);

            if (rSet.next()) {

                totolSalesTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful", "Success Alert", JOptionPane.INFORMATION_MESSAGE);

                describeDisplayLabel.setText("ALL SALES");
                phoneLabel.setText("null");
                cusTypeLabel.setText("null");
                ledgBalLabel.setText("null");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getLocalizedMessage());
        }
    }

    private void retreiveByAllTb1() {
        try {
            state = connection.createStatement();
            final String RETR_DAIL_SALES = "Select itemSold, unitPrice, qtySold, invoiceAmount, location , date from dailysales ";
            System.out.println(RETR_DAIL_SALES);
            rSet = state.executeQuery(RETR_DAIL_SALES);
            if (rSet.next()) {
                customerResultTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful", "Success Alert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Wrong");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getLocalizedMessage());
        }
    }

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() - 1);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() - 1);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if (userCreateCombo.getSelectedItem().equals("Staff User")) {
            if (nameTField.getText().equals("") & userNameTField.getText().equals("") & passWordTField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Missing Parameters", "Error Alert", JOptionPane.ERROR_MESSAGE);
            } else if (nameTField.getText().equals("") || userNameTField.getText().equals("") || passWordTField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Missing Parameters", "Error Alert", JOptionPane.ERROR_MESSAGE);
            } else {
                createStaffUser(nameTField.getText(), userNameTField.getText(), passWordTField.getText());
                JOptionPane.showMessageDialog(this, "");
            }
        } else if (userCreateCombo.getSelectedItem().equals("Manager User")) {
            if (nameTField.getText().equals("") & userNameTField.getText().equals("") & passWordTField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Missing Parameters", "Error Alert", JOptionPane.ERROR_MESSAGE);
            } else if (nameTField.getText().equals("") || userNameTField.getText().equals("") || passWordTField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Missing Parameters", "Error Alert", JOptionPane.ERROR_MESSAGE);
            } else {
                createMangerUser(nameTField.getText(), userNameTField.getText(), passWordTField.getText());

            }
        } else {
            JOptionPane.showMessageDialog(this, "Error Alert..No criteria selected", "Error Alert", JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here
    }//GEN-LAST:event_jButton16ActionPerformed

    private void userCreateComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userCreateComboActionPerformed
        if (userCreateCombo.getSelectedItem().equals("---Select Type of User---")) {
            userCreatePanel.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "You are about to create a " + userCreateCombo.getSelectedItem());
            userCreatePanel.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_userCreateComboActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (deletionCombo.getSelectedItem().equals("Remove Staff User")) {
            if (deletionTField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Missing Parameter..Deletion can't be done", "Error Alert", JOptionPane.ERROR_MESSAGE);

            } else {
                deleteStaffUser(deletionTField.getText());
            }
        } else if (deletionCombo.getSelectedItem().equals("Remove Manager User")) {
            if (deletionTField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Missing Parameter..Deletion can't be done", "Error Alert", JOptionPane.ERROR_MESSAGE);

            } else {
                deleteManagerUser(deletionTField.getText());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid selection made...", "Error Alert", JOptionPane.ERROR_MESSAGE);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void deletionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletionComboActionPerformed
        if (deletionCombo.getSelectedItem().equals("---Select Type of User--")) {
            JOptionPane.showMessageDialog(this, "No valid criteria supplied yet");
            deletionPanel.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "User Type Selected for Deletion is  : " + deletionCombo.getSelectedItem());
            deletionPanel.setVisible(true);
        }// TODO add your handling code here:
    }//GEN-LAST:event_deletionComboActionPerformed

    private void userViewComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userViewComboActionPerformed
        if (userViewCombo.getSelectedItem().equals("---Select Type of User---")) {
            JOptionPane.showMessageDialog(this, "Unable to retreive...No valid selection made", "Error Alert", JOptionPane.ERROR_MESSAGE);
            userTable.setVisible(false);
        } else if (userViewCombo.getSelectedItem().equals("View All Staff Users")) {
            retrAllStaffUser();
        } else if (userViewCombo.getSelectedItem().equals("View All Manager Users")) {
            retrAllManagerUser();
        } else if (userViewCombo.getSelectedItem().equals("View All Users")) {
            retrAllManagerUser();
            retrAllStaffUser();
        } else {
            JOptionPane.showMessageDialog(this, "No valid selection made yet");
        }// TODO add your handling code here:
    }//GEN-LAST:event_userViewComboActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() - 1);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if (userTab.getSelectedIndex() < userTab.getComponents().length - 1) {
            userTab.setSelectedIndex(userTab.getSelectedIndex() - 1 + 1);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if (userTab.getSelectedIndex() < userTab.getComponents().length - 1) {
            userTab.setSelectedIndex(userTab.getSelectedIndex() + 1);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        if (userTab.getSelectedIndex() < userTab.getComponents().length - 1) {
            userTab.setSelectedIndex(userTab.getSelectedIndex() - 1);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if (userTab.getSelectedIndex() < userTab.getComponents().length - 1) {
            userTab.setSelectedIndex(userTab.getSelectedIndex() + 1);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        if (userTab.getSelectedIndex() < userTab.getComponents().length - 1) {
            userTab.setSelectedIndex(userTab.getSelectedIndex() - 1);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        if (userTab.getSelectedIndex() < userTab.getComponents().length - 1) {
            userTab.setSelectedIndex(userTab.getSelectedIndex() + 1 - 1);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void retrViewDistrComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrViewDistrComboActionPerformed
        if (retrViewDistrCombo.getSelectedItem().equals("---Select Retreival Criteria---")) {
            JOptionPane.showMessageDialog(this, "No Valid selection made yet", "Error Alert", JOptionPane.ERROR_MESSAGE);
        } else if (retrViewDistrCombo.getSelectedItem().equals("Retreive Todays Distribution")) {
            retrRecentDistr("WareHouse", getSystemDate());
        } else if (retrViewDistrCombo.getSelectedItem().equals("Retreive Old Distribution")) {
            retrOlderDistr("WareHouse", getSystemDate());
        } else {
            JOptionPane.showMessageDialog(this, "Invalid selection", "Error Alert", JOptionPane.ERROR_MESSAGE);
        }// TODO add your handling code here:
    }//GEN-LAST:event_retrViewDistrComboActionPerformed
    double sumTotSales = 0.00;

    private double sumTotAmtRecCustId(String cId) {
        try {
            state = connection.createStatement();
            final String GET_SUM = "Select sum(amtRec) from totalsales where customer_id   = " + "'" + cId + "'";
            System.out.println(GET_SUM);
            rSet = state.executeQuery(GET_SUM);
            if (rSet.next()) {
                sumTotSales = rSet.getDouble("sum(amtRec)");
                totAmtOfCashReceived.setText(Double.toString(sumTotSales));
            } else {
                JOptionPane.showMessageDialog(this, "error");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error As a result of : " + ex.getMessage());
        }

        return sumTotSales;
    }
   
   
    private double sumTotAmtRecAll() {
        try {
            state = connection.createStatement();
            final String GET_SUM = "Select sum(amtRec) from totalsales ";
            System.out.println(GET_SUM);
            rSet = state.executeQuery(GET_SUM);
            if (rSet.next()) {
                sumTotSales = rSet.getDouble("sum(amtRec)");
                totAmtOfCashReceived.setText(Double.toString(sumTotSales));
            } else {
                JOptionPane.showMessageDialog(this, "error");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error As a result of : " + ex.getMessage());
        }

        return sumTotSales;
    }
   
    
    private double sumTotAmtRecDate(String date) {
        try {
            state = connection.createStatement();
            final String GET_SUM = "Select sum(amtRec) from totalsales where date   = " + "'" + date + "'";
            System.out.println(GET_SUM);
            rSet = state.executeQuery(GET_SUM);
            if (rSet.next()) {
                sumTotSales = rSet.getDouble("sum(amtRec)");
                totAmtOfCashReceived.setText(Double.toString(sumTotSales));
            } else {
                JOptionPane.showMessageDialog(this, "error");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error As a result of : " + ex.getMessage());
        }

        return sumTotSales;
    }
   
    
    private void totLedgBalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totLedgBalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totLedgBalActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
printComponenet();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void ledgBalLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ledgBalLabelMouseClicked
        ledgBalLabel.setText(Double.toString(genLedBal(retrCustId(describeDisplayLabel.getText()))));        // TODO add your handling code here:
    }//GEN-LAST:event_ledgBalLabelMouseClicked
final String pass = "obi123456?";String acess;
String check;
    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        check =  JOptionPane.showInputDialog(this, "Enter Acess Password", acess);
        
         
         if (check.equals(pass) & cusSeleCombo.getSelectedItem().equals("Search By Customer Id"))  {
            if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
                staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1);
            }
            managerDispPanel.setVisible(true);
            reportCustomerLabel.setText(describeDisplayLabel.getText());
            getTotalInvForCus(customerSearchTField.getText());
            getTotaSalesForCust(customerSearchTField.getText());
            genTotBalOnCust();
            totLedgBal.setText(ledgBalLabel.getText());

            sumTotAmtRecCustId(customerSearchTField.getText());

        }

        else if (check.equals(pass) & cusSeleCombo.getSelectedItem().equals("Search All"))  {

            if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
                staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1);
            }
            managerDispPanel.setVisible(true);
            reportCustomerLabel.setText(describeDisplayLabel.getText());
            getTotaSalesForAll();
            getTotalInvForAll();
            sumTotAmtRecAll();
            genTotBalonAll();
        }
        else if (check.equals(pass) & cusSeleCombo.getSelectedItem().equals("Search Todays Transaction"))  {

            if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
                staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1);
            }
            managerDispPanel.setVisible(true);
            reportCustomerLabel.setText(describeDisplayLabel.getText());
            getTotaSalesForDate(getSystemDate());
            getTotalInvForDate(getSystemDate());
            sumTotAmtRecDate(getSystemDate());
            genTotBalonDate();
        }
        else {
            managerDispPanel.setVisible(false);
            JOptionPane.showMessageDialog(this, "Access Denied...You are not allowed to view this", "Security Check Alert", JOptionPane.ERROR_MESSAGE);
        }
         
     

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void cusSeleComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusSeleComboActionPerformed
        if (cusSeleCombo.getSelectedItem().equals("---Select Search Criteria---")) {
            JOptionPane.showMessageDialog(this, "no valid selection made yet");
            cusSearchPanel.setVisible(false);
            customerResultTable.setVisible(false);
        } else {
            cusSearchPanel.setVisible(true);
            JOptionPane.showMessageDialog(this, "Search criteria selected is  : " + cusSeleCombo.getSelectedItem());
            customerResultTable.setVisible(true);
        }// TODO add your handling code here:
    }//GEN-LAST:event_cusSeleComboActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        if (cusSeleCombo.getSelectedItem().equals("Search By Customer Id")) {
            if (customerSearchTField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "No search value supplied yet", "Error alert", JOptionPane.ERROR_MESSAGE);
            } else {
                retreiveByCusIDOnly(customerSearchTField.getText());
                retrCusIDTbl2(customerSearchTField.getText());
                retrCusIdTab1(customerSearchTField.getText());

            }
        } else if (cusSeleCombo.getSelectedItem().equals("Search Todays Transaction")) {

            
            retreiveByDate(getSystemDate());
            retrByDateTb1(getSystemDate());
            ledgBalLabel.setText("Null");
        } else if (cusSeleCombo.getSelectedItem().equals("Search All")) {
            
            retreiveByAll();
            retreiveByAllTb1();
            ledgBalLabel.setText("Null");
        } else {
            JOptionPane.showMessageDialog(this, "Error in retreival..Invalid criteria", "Error Alert", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() - 1);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() - 1);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex() + 1 );
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        if (staffTab.getSelectedIndex() < staffTab.getComponents().length - 1) {
            staffTab.setSelectedIndex(staffTab.getSelectedIndex()  - 1);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed

    private void custRetrCombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custRetrCombActionPerformed
if(custRetrComb.getSelectedItem().equals("---Select Retreival Criteria---")){
JOptionPane.showMessageDialog(this, "Unable to retreive..no valid selection made yet", "Error Alert", JOptionPane.ERROR_MESSAGE);}
else{retrCustDetails();}// TODO add your handling code here:
    }//GEN-LAST:event_custRetrCombActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
if(distrIDTField.getText().equals("")){JOptionPane.showMessageDialog(this, "Unable to delete no customer id detected", "Error Alert", JOptionPane.ERROR_MESSAGE);
}
else{removeUser(distrIDTField.getText());
distrIDTField.setText("");}// TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

private void removeUser(String cid){
        try {
            state = connection.createStatement();
            final String REM_USER = "Delete from customertable where customer_id  = " + "'" + cid + "'";
            System.out.println(REM_USER);
           state.execute(REM_USER);
           
                JOptionPane.showMessageDialog(this, "Deletion succesful");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getLocalizedMessage(), "Error Alert", JOptionPane.ERROR_MESSAGE);
            
        }
}
    
    
        public void printComponenet(){

  PrinterJob pj = PrinterJob.getPrinterJob();
  pj.setJobName("");

  pj.setPrintable (new Printable() {    
    public int print(Graphics pg, PageFormat pf, int pageNum){
      if (pageNum > 0){
      return Printable.NO_SUCH_PAGE;
      }

      Graphics2D g2 = (Graphics2D) pg;
      g2.translate(pf.getImageableX(), pf.getImageableY());
      managerDispPanel.paint(g2);
      return Printable.PAGE_EXISTS;
    }
  });
  if (pj.printDialog() == false)
  return;

  try {
        pj.print();
  } catch (PrinterException ex) {
       JOptionPane.showMessageDialog(this, "Unable to print as a result of : " + ex.getLocalizedMessage());
  }
}

    
    private void retrRecentDistr(String loc, String date) {
        try {
            state = connection.createStatement();
            final String RETR_DATA = "Select prod_type, unit_price, qty_in_stock,amt_equivalent, date,location from pamp_warehouse where location != " + "'" + loc + "'" + "and date = " + "'" + date + "'";
            System.out.println(RETR_DATA);
            rSet = state.executeQuery(RETR_DATA);
            if (rSet.next()) {

                retrTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful");
            } else {
                JOptionPane.showMessageDialog(this, "Record not found", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
    }

    private void retrOlderDistr(String loc, String date) {
        try {
            state = connection.createStatement();
            final String RETR_DATA = "Select prod_type, unit_price, qty_in_stock,amt_equivalent, date,location from pamp_warehouse where location != " + "'" + loc + "'" + "and date != " + "'" + date + "'" ;
            System.out.println(RETR_DATA);
            rSet = state.executeQuery(RETR_DATA);
            if (rSet.next()) {

                retrTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful");
            } else {
                JOptionPane.showMessageDialog(this, "Record not found", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
    }

    private void retrAllStaffUser() {
        try {
            state = connection.createStatement();
            final String RETR_ALL_STAFF = "Select branch_name, user_name, password from staff_login order by id asc";
            System.out.println(RETR_ALL_STAFF);
            rSet = state.executeQuery(RETR_ALL_STAFF);
            if (rSet.next()) {
                userTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful");
            } else {
                JOptionPane.showMessageDialog(this, "Reocrd not found", "Error Alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of:  " + ex.getMessage(), "Error Alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void retrAllManagerUser() {
        try {
            state = connection.createStatement();
            final String RETR_ALL_STAFF = "Select manager_name, user_name, password from manager_login order by id asc";
            System.out.println(RETR_ALL_STAFF);
            rSet = state.executeQuery(RETR_ALL_STAFF);
            if (rSet.next()) {
                userTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful");
            } else {
                JOptionPane.showMessageDialog(this, "Reocrd not found", "Error Alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of:  " + ex.getMessage(), "Error Alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteStaffUser(String name) {
        try {
            state = connection.createStatement();
            final String DELETE_USER = "Delete  from staff_login where branch_name = " + "'" + name + "'";
            System.out.println(DELETE_USER);
            state.execute(DELETE_USER);
            JOptionPane.showMessageDialog(this, "Deletion was sucessful", "Sucess Alert", JOptionPane.INFORMATION_MESSAGE);
            deletionTField.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of :" + ex.getMessage());
        }
    }

    private void deleteManagerUser(String name) {
        try {
            state = connection.createStatement();
            final String DELETE_USER = "Delete from manager_login where manager_name = " + "'" + name + "'";
            System.out.println(DELETE_USER);
            state.execute(DELETE_USER);
            JOptionPane.showMessageDialog(this, "Deletion was sucessful", "Sucess Alert", JOptionPane.INFORMATION_MESSAGE);
            deletionTField.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of :" + ex.getMessage());
        }
    }

    private void createStaffUser(String name, String uName, String pWord) {
        try {
            state = connection.createStatement();
            final String CREATE_USER = "Insert into staff_login(branch_name,user_name,password)values(" + "'" + name + "'," + "'" + uName + "'," + "'" + pWord + "'" + ")";
            System.out.println(CREATE_USER);
            state.execute(CREATE_USER);
            JOptionPane.showMessageDialog(this, " UserCreation Sucessful....UserName :  " + userNameTField.getText() + " and PassWord :  " + passWordTField.getText(), "Sucess Alert", JOptionPane.INFORMATION_MESSAGE);
            userNameTField.setText("");
            passWordTField.setText("");
            nameTField.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
    }

    private void createMangerUser(String name, String uName, String pWord) {
        try {
            state = connection.createStatement();
            final String CREATE_USER = "Insert into manager_login(manager_name,user_name,password)values(" + "'" + name + "'," + "'" + uName + "'," + "'" + pWord + "'" + ")";
            System.out.println(CREATE_USER);
            state.execute(CREATE_USER);
            JOptionPane.showMessageDialog(this, "UserCreation Sucessful....UserName :  " + userNameTField.getText() + "  and PassWord :  " + passWordTField.getText(), "Sucess Alert", JOptionPane.INFORMATION_MESSAGE);
            userNameTField.setText("");
            passWordTField.setText("");
            nameTField.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
    }
    DefaultTableModel def;

    private void retrSalesByCname(String cName) {
        try {
            def = (DefaultTableModel) customerResultTable.getModel();
            state = connection.createStatement();
            final String RETR_DATA = "Select customerName, customerType, itemSold, unitPrice, qtySold, invoiceAmount, amtReceived,totalSales,ledgBal, prodId, location, date from sales_table where customerName = " + "'" + cName + "'" + "order by id asc";
            System.out.println(RETR_DATA);
            rSet = state.executeQuery(RETR_DATA);
            if (rSet.next()) {
                customerResultTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect value supplied...check and try again", "Error Alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
    }

    private void retrSalesByInvNo(int cName) {
        try {
            def = (DefaultTableModel) customerResultTable.getModel();
            state = connection.createStatement();
            final String RETR_DATA = "Select customerName, customerType, itemSold, unitPrice, qtySold, invoiceAmount, amtReceived,totalSales,ledgBal, prodId, location, date from sales_table where invoiceNo = " + " " + cName + " " + " order by id desc";
            System.out.println(RETR_DATA);
            rSet = state.executeQuery(RETR_DATA);
            if (rSet.next()) {
                customerResultTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect value supplied...check and try again", "Error Alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
    }

    private void retrSalesByItemType(String cName) {
        try {
            def = (DefaultTableModel) customerResultTable.getModel();
            state = connection.createStatement();
            final String RETR_DATA = "Select customerName, customerType, itemSold, unitPrice, qtySold, invoiceAmount, amtReceived,totalSales,ledgBal, prodId, location, date from sales_table where itemSold = " + "'" + cName + "'" + "order by id asc";
            System.out.println(RETR_DATA);
            rSet = state.executeQuery(RETR_DATA);
            if (rSet.next()) {
                customerResultTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect value supplied...check and try again", "Error Alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
    }

    private void retrSalesByCType(String cName) {
        try {
            def = (DefaultTableModel) customerResultTable.getModel();
            state = connection.createStatement();
            final String RETR_DATA = "Select customerName, customerType, itemSold, unitPrice, qtySold, invoiceAmount, amtReceived,totalSales,ledgBal, prodId, location, date from sales_table where customerType = " + "'" + cName + "'" + "order by id asc";
            System.out.println(RETR_DATA);
            rSet = state.executeQuery(RETR_DATA);
            if (rSet.next()) {
                customerResultTable.setModel(DbUtils.resultSetToTableModel(rSet));
                JOptionPane.showMessageDialog(this, "Retreival was Sucessful");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect value supplied...check and try again", "Error Alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage());
        }
    }

    private void searchByProdId(String pId, String pLocation) {
        try {
            state = connection.createStatement();
            final String SEARCH = "Select qty_in_stock, unit_price, amt_equivalent from pamp_warehouse where prod_id =  " + "'" + pId + "'" + "and location = " + "'" + pLocation + "'" + "order by id desc";

            System.out.println(SEARCH);
            rSet = state.executeQuery(SEARCH);
            if (rSet.next()) {
                JOptionPane.showMessageDialog(this, "Record Found");
                resultPanel.setVisible(true);
                qtyLeftInv.setText(Integer.toString(rSet.getInt("qty_in_stock")));
                prodUnitInv.setText(Double.toString(rSet.getDouble("unit_price")));
                cashEquiInv.setText(Double.toString(rSet.getDouble("amt_equivalent")));

            } else {
                JOptionPane.showMessageDialog(this, "Record not found", "Error Alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage(), "Error Alert", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void searchByProdName(String pName, String pLocation) {
        try {
            state = connection.createStatement();
            final String SEARCH = "Select qty_in_stock, unit_price, amt_equivalent from pamp_warehouse where prod_type =  " + "'" + pName + "'" + "and location = " + "'" + pLocation + "'" + "order by id desc";

            System.out.println(SEARCH);
            rSet = state.executeQuery(SEARCH);
            if (rSet.next()) {
                JOptionPane.showMessageDialog(this, "Record Found");
                resultPanel.setVisible(true);
                qtyLeftInv.setText(Integer.toString(rSet.getInt("qty_in_stock")));
                prodUnitInv.setText(Double.toString(rSet.getDouble("unit_price")));
                cashEquiInv.setText(Double.toString(rSet.getDouble("amt_equivalent")));

            } else {
                JOptionPane.showMessageDialog(this, "Record not found", "Error Alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage(), "Error Alert", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void distributeGoods(String date, String loc, String prodType, int qty_stock, double unitPrice, String prodId, double amtEquiv) {
        try {
            state = connection.createStatement();
            final String DISTR_GOODS = "Insert into pamp_warehouse(date,location,prod_type,qty_in_stock,unit_price,prod_id,amt_equivalent)Values(" + "'" + date + "'," + "'" + loc + "'," + "'" + prodType + "'," + "" + qty_stock + "," + "" + unitPrice + "," + "'" + prodId + "'," + "" + amtEquiv + "" + ")";
            System.out.println(DISTR_GOODS);
            state.execute(DISTR_GOODS);
            JOptionPane.showMessageDialog(this, "You have sucessfully sent " + qtyDistrTField.getText() + " packs of " + prodRetrCombo.getSelectedItem() + " to " + locDistrCombo.getSelectedItem() + " worth " + amtEquivTField.getText() + " naira only ", "Success Alert", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + ex.getMessage(), "Error Alert", JOptionPane.ERROR_MESSAGE);

        }

    }
    int oldQty = 0;
    int newQty = 0;
    int finalQty = 0;

    private double genDistrAmtEquivalent() {
        try {
            unitPrice = Double.parseDouble(unitPriceDist.getText());
            newQty = Integer.parseInt(qtyDistrTField.getText());
            finalAmtEqui = unitPrice * newQty;
            amtEquivTField.setText(Double.toString(finalAmtEqui));
        } catch (NumberFormatException nux) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + nux.getMessage());
        }
        return finalAmtEqui;
    }

    private int genQtyRemDist() {
        try {
            oldQty = Integer.parseInt(qtyRemDist.getText());
            newQty = Integer.parseInt(qtyDistrTField.getText());
            if (newQty > oldQty) {
                JOptionPane.showMessageDialog(this, "Quantity Entered for Distribution is more than available stock..Reduce amount ", "Error Alert", JOptionPane.ERROR_MESSAGE);
                amtEquivTField.setText("");
            } else if (newQty == oldQty) {
                JOptionPane.showMessageDialog(this, "Note that the quantity entered will exhaust the stock..Make sure u fill up", "Warning Message", JOptionPane.WARNING_MESSAGE);
                finalQty = oldQty - newQty;
                qtyRemDist.setText(Integer.toString(finalQty));
            } else {
                finalQty = oldQty - newQty;
                qtyRemDist.setText(Integer.toString(finalQty));
            }
        } catch (NumberFormatException nux) {
            JOptionPane.showMessageDialog(this, "Error as a result of : " + nux.getMessage(), "Error Alert", JOptionPane.ERROR_MESSAGE);
        }

        return finalQty;
    }

    private String getSystemDate() {
        String finalDate;
        int day;
        int month;
        int year;
        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DATE);
        month = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);
        finalDate = String.format(" %s/ %s/ %s", day, month, year);
        systemDate.setText(finalDate);
        return finalDate;
    }

    /**
     * private void regNewItem(String cName, String item_description, int
     * qty_rem, int qty_sold, double unit_price, double coms_giv, double
     * coms_earned, double perc_givn, double perc_earned, double cash_price,
     * String date, String transacId, String prodName){ try { state =
     * connection.createStatement(); final String STOCK_UP = "Insert into
     * transaction_table(customer_name,item_description,qty_remaining,qty_sold,unit_price,commision_given,commision_earned,percentage_given,percentage_earned,cash_price,date,customer_id,prodName)VALUES("
     * + "'" + cName + "'," + "'" + item_description + "'," + "" + qty_rem + ","
     * + "" + qty_sold + "," + "" + unit_price + "," + "" + coms_giv + "," + ""
     * + coms_earned + "," + "" + perc_givn + "," + "" + perc_earned + "," + ""
     * + cash_price + "," + "'" + date + "'," + "'" + transacId + "'," + "'" +
     * prodName + "'" + ")"; state.execute(STOCK_UP);
     * prodUnitPriceTField.setText(""); qtyRecTField.setText("");
     * //prodDescrTField.setText(""); prodTypeCombo.setSelectedItem("---Select
     * Product Type---"); JOptionPane.showMessageDialog(this, "The new product
     * has being successfully added to datawarehouse", "Sucess Alert",
     * JOptionPane.INFORMATION_MESSAGE); } catch (SQLException ex) {
     * JOptionPane.showMessageDialog(this, "Error as a result of : " +
     * ex.getMessage(), "Error Alert", JOptionPane.ERROR_MESSAGE);
     *
     * }
     * }*
     */
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
            java.util.logging.Logger.getLogger(O_OStaffZone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(O_OStaffZone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(O_OStaffZone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(O_OStaffZone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new O_OStaffZone().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLocButton;
    private javax.swing.JTextField amtEquivTField;
    private javax.swing.JTextField cashEquiInv;
    private javax.swing.JPanel cusSearchPanel;
    private javax.swing.JComboBox cusSeleCombo;
    private javax.swing.JLabel cusTypeLabel;
    private javax.swing.JTable custDetTable;
    private javax.swing.JComboBox custRetrComb;
    private javax.swing.JTable customerResultTable;
    private javax.swing.JTextField customerSearchTField;
    private javax.swing.JPanel dashBoardPanel;
    private javax.swing.JComboBox deletionCombo;
    private javax.swing.JPanel deletionPanel;
    private javax.swing.JTextField deletionTField;
    private javax.swing.JLabel describeDisplayLabel;
    private javax.swing.JTextField distrCashBalance;
    private javax.swing.JTextField distrIDTField;
    private javax.swing.JPanel distributionPanel;
    private javax.swing.JButton invButton;
    private javax.swing.JComboBox invCombo;
    private javax.swing.JPanel invPanel;
    private javax.swing.JTextField invTField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel ledgBalLabel;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JComboBox locDistrCombo;
    private javax.swing.JPanel managerDispPanel;
    private javax.swing.JTextField nameTField;
    private javax.swing.JTextField newLocTField;
    private javax.swing.JPasswordField passWordTField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JComboBox prodRetrCombo;
    private javax.swing.JComboBox prodTypeCombo;
    private javax.swing.JTextField prodUnitInv;
    private javax.swing.JTextField prodUnitPriceTField;
    private javax.swing.JTextField qtyDistrTField;
    private javax.swing.JTextField qtyLeftInv;
    private javax.swing.JTextField qtyRecTField;
    private javax.swing.JLabel qtyRemDist;
    private javax.swing.JLabel reportCustomerLabel;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JTable retrTable;
    private javax.swing.JComboBox retrViewDistrCombo;
    private javax.swing.JComboBox searchCombo;
    private javax.swing.JTextField searchTField;
    private javax.swing.JTabbedPane staffTab;
    public javax.swing.JLabel systemDate;
    public javax.swing.JTextField totAccruedDisc;
    public javax.swing.JLabel totAmtChargedDash;
    public javax.swing.JLabel totAmtLabelMan;
    public javax.swing.JLabel totAmtOfCashReceived;
    public javax.swing.JTextField totLedgBal;
    private javax.swing.JTable totolSalesTable;
    private javax.swing.JLabel unitPriceDist;
    private javax.swing.JComboBox userCreateCombo;
    private javax.swing.JPanel userCreatePanel;
    private javax.swing.JTextField userNameTField;
    private javax.swing.JTabbedPane userTab;
    private javax.swing.JTable userTable;
    private javax.swing.JComboBox userViewCombo;
    private javax.swing.JPanel wareHousePanel;
    public javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
