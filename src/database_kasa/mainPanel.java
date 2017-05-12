/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_kasa;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

/**
 *
 * @author Kevin
 */
public class mainPanel extends javax.swing.JFrame {

    /**
     * Creates new form mainPanel
     */
    @SuppressWarnings("empty-statement")
    public mainPanel() {
       
        try {
            UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Arial", Font.PLAIN, 16));
            
            //Connects to SQL database
            String driver="com.mysql.jdbc.Driver";
            String url= "jdbc:mysql://triton.towson.edu:3360/aalmal5db";
            String username ="aalmal5";
            String password="Cosc*4q8j";
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(mainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection(url,username,password);
            
            updateCB();
            
            
            
            
            initComponents(); 
        } catch (SQLException ex) {
            Logger.getLogger(mainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }
  private void updateCB(){
      //Updates the comboboxes
            try{           
            
			Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Owner";
            ResultSet rs = stmt.executeQuery(query); 
            
            ArrayList<String> namesCB1 = new ArrayList<String>();

            while (rs.next())
            {
            	 String name = rs.getString("name");
            	 namesCB1.add(name);	
            }
            
            ownerCB = new String[namesCB1.size()];
            
            //copies the arrayList into the Array
            for(int i = 0; i<namesCB1.size(); i++){
            ownerCB[i] = namesCB1.get(i);
            }
                 }catch(SQLException ex){	System.out.println(ex);
  	        }
		
		

		
		///////// Tenant ///////
		
        try{           
       Statement stmt = conn.createStatement();
       String query = "SELECT * FROM Tenant";
       ResultSet rs = stmt.executeQuery(query); 
       ArrayList<String> tenantCB1 = new ArrayList<String>();
       while (rs.next())
       {
       	 String name = rs.getString("name");
       	 tenantCB1.add(name);	
       }
       
       tenantCB = new String[tenantCB1.size()];
       
       //copies the arrayList into the Array
       for(int i = 0; i<tenantCB1.size(); i++){
    	   tenantCB[i] = tenantCB1.get(i);
       }
            }catch(Exception ex){	System.out.println(ex);
	        }
	
	
	/////////////
        
        
        
        
        
        
///////// property ///////
		
        try{           
       Statement stmt = conn.createStatement();
       String query = "SELECT * FROM Property";
       ResultSet rs = stmt.executeQuery(query); 
       ArrayList<String> propertyCB1 = new ArrayList<String>();
       while (rs.next())
       {
       	 String name = rs.getString("propertyID");
       	propertyCB1.add(name);	
       }
       
       propertyCB = new String[propertyCB1.size()];
       
       //copies the arrayList into the Array
       for(int i = 0; i<propertyCB1.size(); i++){
    	   propertyCB[i] = propertyCB1.get(i);
       }
            }catch(Exception ex){	System.out.println(ex);
	        }
	
	
	/////////////
        
///////// Repair ///////
		
        try{           
       Statement stmt = conn.createStatement();
       String query = "SELECT * FROM Repair";
       ResultSet rs = stmt.executeQuery(query); 
       ArrayList<String> repairCB1 = new ArrayList<String>();
       while (rs.next())
       {
       	 String name = rs.getString("repairID");
       	repairCB1.add(name);	
       }
       
       repairCB = new String[repairCB1.size()];
       
       //copies the arrayList into the Array
       for(int i = 0; i<repairCB1.size(); i++){
    	   repairCB[i] = repairCB1.get(i);
       }
            }catch(Exception ex){	System.out.println(ex);
	        }
	
	
	/////////////
        
        
        
        
        
        
///////// Store ///////
		
        try{           
       Statement stmt = conn.createStatement();
       String query = "SELECT * FROM Store";
       ResultSet rs = stmt.executeQuery(query); 
       ArrayList<String> storeCB1 = new ArrayList<String>();
       while (rs.next())
       {
       	 String name = rs.getString("store_name");
       	String address = rs.getString("store_address");
       	storeCB1.add(name + "; " + address);	
       }
       
       storeCB = new String[storeCB1.size()+1];
       storeCB[0] = null;
       //copies the arrayList into the Array
       for(int i = 0; i<storeCB1.size(); i++){
    	   storeCB[i+1] = storeCB1.get(i);
       }
            }catch(Exception ex){	System.out.println(ex);
	        }
	
	
	/////////////
        
        
       
        
        
        
        
///////// County ///////
		
        try{           
       Statement stmt = conn.createStatement();
       String query = "SELECT * FROM County";
       ResultSet rs = stmt.executeQuery(query); 
       ArrayList<String> countyCB1 = new ArrayList<String>();
       while (rs.next())
       {
    	   String name = rs.getString("countyID");
       	countyCB1.add(name);	
       }
       
       countyCB = new String[countyCB1.size()];
       countyCBNull = new String[countyCB1.size()+1];
       countyCBNull[0] = "";
       
       //copies the arrayList into the Array
       for(int i = 0; i<countyCB1.size(); i++){
    	   countyCB[i] = countyCB1.get(i);
    	   countyCBNull[i+1] = countyCB1.get(i);
       }
       
       //prints out the array
            }catch(Exception ex){	System.out.println(ex);
	        }
	
	
	/////////////
        
        
        
        
        
///////// repairCompany ///////
		
        try{           
       Statement stmt = conn.createStatement();
       String query = "SELECT * FROM RepairCompany";
       ResultSet rs = stmt.executeQuery(query); 
       ArrayList<String> repairCompanyCB1 = new ArrayList<String>();
       while (rs.next())
       {
       	 String name = rs.getString("RepairCompany");
       	repairCompanyCB1.add(name);	
       }
       
       repairCompanyCB = new String[repairCompanyCB1.size()];
       
       //copies the arrayList into the Array
       for(int i = 0; i<repairCompanyCB1.size(); i++){
    	   repairCompanyCB[i] = repairCompanyCB1.get(i);
       }
            }catch(Exception ex){	System.out.println(ex);
	        }
	
	
	///////////// 
        
        
        
        
///////// Repair ///////
		
        try{           
       Statement stmt = conn.createStatement();
       String query = "SELECT * FROM Repair";
       ResultSet rs = stmt.executeQuery(query); 
       ArrayList<String> repairCB1 = new ArrayList<String>();
       while (rs.next())
       {
       	 String name = rs.getString("property_propertyId");
       	String date	 = rs.getString("repair_date");
       	repairCB1.add(name + "; " +date);	
       }
       
       repairCB = new String[repairCB1.size()];
       
       //copies the arrayList into the Array
       for(int i = 0; i<repairCB1.size(); i++){
    	   repairCB[i] = repairCB1.get(i);
       }
            }catch(Exception ex){	System.out.println(ex);
	        }
        ////////
        
///////// payment ///////
		
        try{           
       Statement stmt = conn.createStatement();
       String query = "SELECT * FROM RentPayment";
       ResultSet rs = stmt.executeQuery(query); 
       ArrayList<String> payCB1 = new ArrayList<String>();
       while (rs.next())
       {
       	String name = rs.getString("tenant_tenantID");
       	String dateM	 = rs.getString("tenant_payment_month");
       	String dateY	 = rs.getString("tenant_payment_year");
       	payCB1.add(name + "; " + dateM + "/" + dateY);	
       }
       rentPayLen = payCB1.size();
       payCB = new String[payCB1.size()];
       
       //copies the arrayList into the Array
       for(int i = 0; i<payCB1.size(); i++){
    	   payCB[i] = payCB1.get(i);
       }
       
            }catch(Exception ex){	System.out.println(ex);
	        }
        

        ////////
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jDialog4 = new javax.swing.JDialog();
        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanelMain = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPaneInput = new javax.swing.JTabbedPane();
        jPanelInOwner = new javax.swing.JPanel();
        jTextInOwnerName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextInOwnerEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextInOwnerPhoneNum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonOwnerAdd = new javax.swing.JButton();
        jButtonOwnerClear = new javax.swing.JButton();
        jPanelInOwnerGroup = new javax.swing.JPanel();
        jButtonClear = new javax.swing.JButton();
        jButtonOGAdd = new javax.swing.JButton();
        jCBInOGOwner = new javax.swing.JComboBox<>();
        jCBInOGGroup = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanelInPayment = new javax.swing.JPanel();
        jButtonPayAdd = new javax.swing.JButton();
        jButtonPayClear = new javax.swing.JButton();
        jCBInPayTenant = new javax.swing.JComboBox<>();
        jCBInPayProperty = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextInPayTenant = new javax.swing.JTextField();
        jTextInPayOwner = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jCBInPayTM = new javax.swing.JComboBox<>();
        jCBInPayTY = new javax.swing.JComboBox<>();
        jCBInPayOM = new javax.swing.JComboBox<>();
        jCBInPayOY = new javax.swing.JComboBox<>();
        jPanelInRepair = new javax.swing.JPanel();
        jButtonRepairAdd = new javax.swing.JButton();
        jButtonRepairClear = new javax.swing.JButton();
        jCBInRepairProperty = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jTextInRepairDateM = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextInRepairDateD = new javax.swing.JTextField();
        jTextInRepairDateY = new javax.swing.JTextField();
        jCBInRepairRC = new javax.swing.JComboBox<>();
        jCBInRepairStore = new javax.swing.JComboBox<>();
        jLabelRC = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextInRepairMCost = new javax.swing.JTextField();
        jTextInRepairRCost = new javax.swing.JTextField();
        jTextInRepairman = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextInMDate = new javax.swing.JTextField();
        jPanelInStores = new javax.swing.JPanel();
        jButtonStoreAdd = new javax.swing.JButton();
        jButtonStoreClear = new javax.swing.JButton();
        jTextInStoreName = new javax.swing.JTextField();
        jTextInStoreAddress = new javax.swing.JTextField();
        jTextInStorePhone = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanelInRepairCompany = new javax.swing.JPanel();
        jButtonRCAdd = new javax.swing.JButton();
        jButtonRCClear = new javax.swing.JButton();
        jTextInRCName = new javax.swing.JTextField();
        jTextInRCPhone = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanelInProperty = new javax.swing.JPanel();
        jButtonPropAdd = new javax.swing.JButton();
        jButtonPropClear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelInProp = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jCBInPropertyOwner = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextInPropertySize = new javax.swing.JTextField();
        jCBInPropertyYear = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextInPropertyAddress = new javax.swing.JTextField();
        jTextInPropertyZip = new javax.swing.JTextField();
        jTextInPropertyCity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCBInPropertyCounty = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jCBInPropertyBed = new javax.swing.JComboBox<>();
        jCBInPropertyBath = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCBInPropertyType = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jTextInPropertyVar1 = new javax.swing.JTextField();
        jTextInPropertyVar2 = new javax.swing.JTextField();
        jTextInPropertyVar3 = new javax.swing.JTextField();
        propertyVar1 = new javax.swing.JLabel();
        propertyVar2 = new javax.swing.JLabel();
        propertyVar3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jCBInPropertyRS = new javax.swing.JComboBox<>();
        propertyVar4 = new javax.swing.JLabel();
        jTextInPropertyVar4 = new javax.swing.JTextField();
        propertyVar5 = new javax.swing.JLabel();
        jTextInPropertyVar5 = new javax.swing.JTextField();
        propertyVar6 = new javax.swing.JLabel();
        jTextInPropertyVar6 = new javax.swing.JTextField();
        jPanelInTenant = new javax.swing.JPanel();
        jButtonTenantAdd = new javax.swing.JButton();
        jButtonTenantClear = new javax.swing.JButton();
        jTextInTenantName = new javax.swing.JTextField();
        jTextInTenantEmail = new javax.swing.JTextField();
        jTextInTenantPhone = new javax.swing.JTextField();
        jCBInTenantProperty = new javax.swing.JComboBox<>();
        jCBInTenantDependents = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabeTlPN = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jCBInTenantDateMS = new javax.swing.JComboBox<>();
        jCBInTenantDateYS = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jCBInTenantDateME = new javax.swing.JComboBox<>();
        jCBInTenantDateYE = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelOutTenant = new javax.swing.JPanel();
        jCBOutTenantName = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jButtonOutTenantLoad = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTAOutTenantInfo = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTAOutTenantPay = new javax.swing.JTextArea();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanelOutProp = new javax.swing.JPanel();
        jCBOutProp = new javax.swing.JComboBox<>();
        jButtonOutPropLoad = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAOutPropInfo = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTAOutPropRepair = new javax.swing.JTextArea();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanelOutRepair = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jCBOutRepair = new javax.swing.JComboBox<>();
        jButtonOutRepair = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTAOutRepair = new javax.swing.JTextArea();
        jLabel59 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jCBOutOwner = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jButtonOutOwner = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAOutOwnerInfo = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTAOutOwnerPay = new javax.swing.JTextArea();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jCBOutPayM = new javax.swing.JComboBox<>();
        jCBOutPayY = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jButtonOutPay = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTAOutPayPaid = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTAOutPayNP = new javax.swing.JTextArea();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextOutSearchSize = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTAOutSearch = new javax.swing.JTextArea();
        jCBOutSearchYear = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jCBOutSearchCounty = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jCBOutSearchBed = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jCBOutSearchBath = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jCBOutSearchType = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextOutSearchRent = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Email");

        jLabel3.setText("Phone Number");

        jButtonOwnerAdd.setText("Add");
        jButtonOwnerAdd.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonOwnerAdd.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonOwnerAdd.setPreferredSize(null);
        jButtonOwnerAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOwnerAddActionPerformed(evt);
            }
        });

        jButtonOwnerClear.setText("Clear");
        jButtonOwnerClear.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonOwnerClear.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonOwnerClear.setPreferredSize(null);
        jButtonOwnerClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOwnerClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInOwnerLayout = new javax.swing.GroupLayout(jPanelInOwner);
        jPanelInOwner.setLayout(jPanelInOwnerLayout);
        jPanelInOwnerLayout.setHorizontalGroup(
            jPanelInOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInOwnerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelInOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextInOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextInOwnerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextInOwnerPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(441, 441, 441))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInOwnerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOwnerAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButtonOwnerClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );
        jPanelInOwnerLayout.setVerticalGroup(
            jPanelInOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInOwnerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jTextInOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jTextInOwnerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jTextInOwnerPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addGroup(jPanelInOwnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOwnerClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOwnerAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPaneInput.addTab("Owner", jPanelInOwner);

        jButtonClear.setText("Clear");
        jButtonClear.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonClear.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonClear.setPreferredSize(null);

        jButtonOGAdd.setText("Add");
        jButtonOGAdd.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonOGAdd.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonOGAdd.setPreferredSize(null);
        jButtonOGAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOGAddActionPerformed(evt);
            }
        });

        jCBInOGOwner.setModel(new javax.swing.DefaultComboBoxModel(ownerCB));

        jCBInOGGroup.setModel(new javax.swing.DefaultComboBoxModel(ownerCB));

        jLabel4.setText("Add owner");

        jLabel5.setText("To Group:");

        javax.swing.GroupLayout jPanelInOwnerGroupLayout = new javax.swing.GroupLayout(jPanelInOwnerGroup);
        jPanelInOwnerGroup.setLayout(jPanelInOwnerGroupLayout);
        jPanelInOwnerGroupLayout.setHorizontalGroup(
            jPanelInOwnerGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInOwnerGroupLayout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(jButtonOGAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
            .addGroup(jPanelInOwnerGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInOwnerGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBInOGGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInOGOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInOwnerGroupLayout.setVerticalGroup(
            jPanelInOwnerGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInOwnerGroupLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(jCBInOGOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jCBInOGGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300)
                .addGroup(jPanelInOwnerGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOGAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPaneInput.addTab("Owner Group", jPanelInOwnerGroup);

        jButtonPayAdd.setText("Add");
        jButtonPayAdd.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonPayAdd.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonPayAdd.setPreferredSize(null);
        jButtonPayAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPayAddActionPerformed(evt);
            }
        });

        jButtonPayClear.setText("Clear");
        jButtonPayClear.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonPayClear.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonPayClear.setPreferredSize(null);
        jButtonPayClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPayClearActionPerformed(evt);
            }
        });

        jCBInPayTenant.setModel(new javax.swing.DefaultComboBoxModel(tenantCB));

        jCBInPayProperty.setModel(new javax.swing.DefaultComboBoxModel(propertyCB));

        jLabel21.setText("Tenant");

        jLabel24.setText("Property");

        jLabel25.setText("Tenant Payment Amount");

        jLabel26.setText("Owner Payment Amount");

        jCBInPayTM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jCBInPayTY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));

        jCBInPayOM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jCBInPayOY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));

        javax.swing.GroupLayout jPanelInPaymentLayout = new javax.swing.GroupLayout(jPanelInPayment);
        jPanelInPayment.setLayout(jPanelInPaymentLayout);
        jPanelInPaymentLayout.setHorizontalGroup(
            jPanelInPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInPaymentLayout.createSequentialGroup()
                        .addGroup(jPanelInPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCBInPayTenant, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBInPayProperty, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelInPaymentLayout.createSequentialGroup()
                                .addGap(0, 229, Short.MAX_VALUE)
                                .addComponent(jButtonPayAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56)
                        .addComponent(jButtonPayClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238))
                    .addGroup(jPanelInPaymentLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelInPaymentLayout.createSequentialGroup()
                        .addGroup(jPanelInPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextInPayOwner)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextInPayTenant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelInPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBInPayTM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBInPayOM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelInPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBInPayTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBInPayOY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(133, 133, 133))))
        );
        jPanelInPaymentLayout.setVerticalGroup(
            jPanelInPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInPaymentLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel21)
                .addGap(1, 1, 1)
                .addComponent(jCBInPayTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel24)
                .addGap(0, 0, 0)
                .addComponent(jCBInPayProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel25)
                .addGap(0, 0, 0)
                .addGroup(jPanelInPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextInPayTenant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInPayTM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInPayTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel26)
                .addGap(1, 1, 1)
                .addGroup(jPanelInPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextInPayOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInPayOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInPayOY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                .addGroup(jPanelInPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPayClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPayAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPaneInput.addTab("Payment", jPanelInPayment);

        jButtonRepairAdd.setText("Add");
        jButtonRepairAdd.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonRepairAdd.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonRepairAdd.setPreferredSize(null);
        jButtonRepairAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepairAddActionPerformed(evt);
            }
        });

        jButtonRepairClear.setText("Clear");
        jButtonRepairClear.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonRepairClear.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonRepairClear.setPreferredSize(null);
        jButtonRepairClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepairClearActionPerformed(evt);
            }
        });

        jCBInRepairProperty.setModel(new javax.swing.DefaultComboBoxModel(propertyCB));

        jLabel32.setText("Property");

        jLabel33.setText("Repair Date(MM DD YYYY)");

        jCBInRepairRC.setModel(new javax.swing.DefaultComboBoxModel(repairCompanyCB));

        jCBInRepairStore.setModel(new javax.swing.DefaultComboBoxModel(storeCB));

        jLabelRC.setText("Repair Company");

        jLabel35.setText("Material Source");

        jLabel36.setText("Material Cost");

        jLabel37.setText("Repairman Name");

        jLabel38.setText("Repair Cost");

        jLabel54.setText("Purchase Date");

        javax.swing.GroupLayout jPanelInRepairLayout = new javax.swing.GroupLayout(jPanelInRepair);
        jPanelInRepair.setLayout(jPanelInRepairLayout);
        jPanelInRepairLayout.setHorizontalGroup(
            jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInRepairLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInRepairLayout.createSequentialGroup()
                        .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCBInRepairProperty, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelInRepairLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonRepairAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56)
                        .addComponent(jButtonRepairClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238))
                    .addGroup(jPanelInRepairLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelInRepairLayout.createSequentialGroup()
                        .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addGroup(jPanelInRepairLayout.createSequentialGroup()
                                .addComponent(jTextInRepairDateM, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextInRepairDateD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextInRepairDateY, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelInRepairLayout.createSequentialGroup()
                                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBInRepairRC, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelRC)
                                    .addComponent(jLabel37)
                                    .addComponent(jTextInRepairman, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38)
                                    .addComponent(jTextInRepairRCost, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(155, 155, 155)
                                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel35)
                                    .addComponent(jCBInRepairStore, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextInMDate, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextInRepairMCost, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 64, Short.MAX_VALUE))))
        );
        jPanelInRepairLayout.setVerticalGroup(
            jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInRepairLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel32)
                .addGap(2, 2, 2)
                .addComponent(jCBInRepairProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextInRepairDateM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextInRepairDateD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextInRepairDateY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRC)
                    .addComponent(jLabel35))
                .addGap(0, 0, 0)
                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBInRepairRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInRepairStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextInRepairMCost)
                    .addComponent(jTextInRepairman))
                .addGap(26, 26, 26)
                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel54))
                .addGap(1, 1, 1)
                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextInRepairRCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextInMDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(jPanelInRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRepairClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRepairAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPaneInput.addTab("Repair", jPanelInRepair);

        jButtonStoreAdd.setText("Add");
        jButtonStoreAdd.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonStoreAdd.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonStoreAdd.setPreferredSize(null);
        jButtonStoreAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStoreAddActionPerformed(evt);
            }
        });

        jButtonStoreClear.setText("Clear");
        jButtonStoreClear.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonStoreClear.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonStoreClear.setPreferredSize(null);
        jButtonStoreClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStoreClearActionPerformed(evt);
            }
        });

        jLabel29.setText("Store Name");

        jLabel30.setText("Store Address");

        jLabel31.setText("Store Phone Number");

        javax.swing.GroupLayout jPanelInStoresLayout = new javax.swing.GroupLayout(jPanelInStores);
        jPanelInStores.setLayout(jPanelInStoresLayout);
        jPanelInStoresLayout.setHorizontalGroup(
            jPanelInStoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInStoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInStoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInStoresLayout.createSequentialGroup()
                        .addGroup(jPanelInStoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextInStoreAddress, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInStoresLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                                .addComponent(jButtonStoreAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56)
                        .addComponent(jButtonStoreClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238))
                    .addGroup(jPanelInStoresLayout.createSequentialGroup()
                        .addGroup(jPanelInStoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextInStoreName, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextInStorePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelInStoresLayout.createSequentialGroup()
                        .addGroup(jPanelInStoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelInStoresLayout.setVerticalGroup(
            jPanelInStoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInStoresLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel29)
                .addGap(1, 1, 1)
                .addComponent(jTextInStoreName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextInStoreAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel31)
                .addGap(1, 1, 1)
                .addComponent(jTextInStorePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                .addGroup(jPanelInStoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStoreClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonStoreAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPaneInput.addTab("Store", jPanelInStores);

        jButtonRCAdd.setText("Add");
        jButtonRCAdd.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonRCAdd.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonRCAdd.setPreferredSize(null);
        jButtonRCAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRCAddActionPerformed(evt);
            }
        });

        jButtonRCClear.setText("Clear");
        jButtonRCClear.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonRCClear.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonRCClear.setPreferredSize(null);
        jButtonRCClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRCClearActionPerformed(evt);
            }
        });

        jLabel27.setText("Company Name");

        jLabel28.setText("Phone Number");

        javax.swing.GroupLayout jPanelInRepairCompanyLayout = new javax.swing.GroupLayout(jPanelInRepairCompany);
        jPanelInRepairCompany.setLayout(jPanelInRepairCompanyLayout);
        jPanelInRepairCompanyLayout.setHorizontalGroup(
            jPanelInRepairCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInRepairCompanyLayout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(jButtonRCAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButtonRCClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
            .addGroup(jPanelInRepairCompanyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInRepairCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextInRCName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextInRCPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInRepairCompanyLayout.setVerticalGroup(
            jPanelInRepairCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInRepairCompanyLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel27)
                .addGap(1, 1, 1)
                .addComponent(jTextInRCName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel28)
                .addGap(0, 0, 0)
                .addComponent(jTextInRCPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addGroup(jPanelInRepairCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRCClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRCAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPaneInput.addTab("Repair Company", jPanelInRepairCompany);

        jButtonPropAdd.setText("Add");
        jButtonPropAdd.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonPropAdd.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonPropAdd.setPreferredSize(null);
        jButtonPropAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPropAddActionPerformed(evt);
            }
        });

        jButtonPropClear.setText("Clear");
        jButtonPropClear.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonPropClear.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonPropClear.setPreferredSize(null);
        jButtonPropClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPropClearActionPerformed(evt);
            }
        });

        jLabel6.setText("Address");

        jLabel8.setText("Address");

        jCBInPropertyOwner.setModel(new javax.swing.DefaultComboBoxModel(ownerCB));

        jLabel9.setText("Owner");

        jCBInPropertyYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));

        jLabel10.setText("Size");

        jLabel11.setText("Year Built");

        jLabel12.setText("City");

        jLabel13.setText("Zip");

        jCBInPropertyCounty.setModel(new javax.swing.DefaultComboBoxModel(countyCB));

        jLabel14.setText("County");

        jCBInPropertyBed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7+", " " }));

        jCBInPropertyBath.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7+" }));

        jLabel15.setText("Bathroom");

        jLabel16.setText("Bedroom");

        jCBInPropertyType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Condo", "Townhouse", "Single Family" }));
        jCBInPropertyType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBInPropertyTypeActionPerformed(evt);
            }
        });

        jLabel17.setText("Property Type");

        propertyVar1.setText("Choose a Property Type");

        jLabel18.setText("Rental/Sale");

        jCBInPropertyRS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rental", "Sale" }));
        jCBInPropertyRS.setPreferredSize(new java.awt.Dimension(170, 26));
        jCBInPropertyRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBInPropertyRSActionPerformed(evt);
            }
        });

        propertyVar4.setText("Choose Rental or Sale");

        javax.swing.GroupLayout jPanelInPropLayout = new javax.swing.GroupLayout(jPanelInProp);
        jPanelInProp.setLayout(jPanelInPropLayout);
        jPanelInPropLayout.setHorizontalGroup(
            jPanelInPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInPropLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextInPropertyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelInPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8)
                        .addComponent(jCBInPropertyOwner, 0, 220, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addComponent(jCBInPropertyYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextInPropertySize, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jTextInPropertyCity)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(jCBInPropertyCounty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextInPropertyZip, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(propertyVar1)
                    .addComponent(propertyVar2)
                    .addComponent(propertyVar3)
                    .addGroup(jPanelInPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextInPropertyVar3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextInPropertyVar2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextInPropertyVar1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCBInPropertyType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInPropLayout.createSequentialGroup()
                            .addGroup(jPanelInPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCBInPropertyBed, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addGap(34, 34, 34)
                            .addGroup(jPanelInPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(jCBInPropertyBath, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel18)
                    .addComponent(propertyVar4)
                    .addComponent(propertyVar5)
                    .addComponent(propertyVar6)
                    .addGroup(jPanelInPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextInPropertyVar6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextInPropertyVar5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextInPropertyVar4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCBInPropertyRS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanelInPropLayout.setVerticalGroup(
            jPanelInPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInPropLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextInPropertyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(0, 0, 0)
                .addComponent(jTextInPropertyCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel13)
                .addGap(0, 0, 0)
                .addComponent(jTextInPropertyZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addGap(0, 0, 0)
                .addComponent(jCBInPropertyOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(3, 3, 3)
                .addComponent(jTextInPropertySize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(2, 2, 2)
                .addComponent(jCBInPropertyYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addGap(0, 0, 0)
                .addComponent(jCBInPropertyCounty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanelInPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(0, 0, 0)
                .addGroup(jPanelInPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBInPropertyBed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInPropertyBath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jLabel17)
                .addGap(2, 2, 2)
                .addComponent(jCBInPropertyType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(propertyVar1)
                .addGap(0, 0, 0)
                .addComponent(jTextInPropertyVar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(propertyVar2)
                .addGap(0, 0, 0)
                .addComponent(jTextInPropertyVar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(propertyVar3)
                .addGap(0, 0, 0)
                .addComponent(jTextInPropertyVar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel18)
                .addGap(1, 1, 1)
                .addComponent(jCBInPropertyRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(propertyVar4)
                .addGap(0, 0, 0)
                .addComponent(jTextInPropertyVar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(propertyVar5)
                .addGap(0, 0, 0)
                .addComponent(jTextInPropertyVar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(propertyVar6)
                .addGap(0, 0, 0)
                .addComponent(jTextInPropertyVar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanelInProp);

        javax.swing.GroupLayout jPanelInPropertyLayout = new javax.swing.GroupLayout(jPanelInProperty);
        jPanelInProperty.setLayout(jPanelInPropertyLayout);
        jPanelInPropertyLayout.setHorizontalGroup(
            jPanelInPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInPropertyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButtonPropClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
            .addGroup(jPanelInPropertyLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanelInPropertyLayout.setVerticalGroup(
            jPanelInPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInPropertyLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelInPropertyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPropClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPaneInput.addTab("Property", jPanelInProperty);

        jButtonTenantAdd.setText("Add");
        jButtonTenantAdd.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonTenantAdd.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonTenantAdd.setPreferredSize(null);
        jButtonTenantAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTenantAddActionPerformed(evt);
            }
        });

        jButtonTenantClear.setText("Clear");
        jButtonTenantClear.setMaximumSize(new java.awt.Dimension(70, 29));
        jButtonTenantClear.setMinimumSize(new java.awt.Dimension(70, 29));
        jButtonTenantClear.setPreferredSize(null);
        jButtonTenantClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTenantClearActionPerformed(evt);
            }
        });

        jCBInTenantProperty.setModel(new javax.swing.DefaultComboBoxModel(propertyCB));

        jCBInTenantDependents.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8+" }));

        jLabel19.setText("Name");

        jLabel20.setText("Email");

        jLabeTlPN.setText("Phone Number");

        jLabel22.setText("Number of Dependents");

        jLabel23.setText("Property");

        jCBInTenantDateMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jCBInTenantDateYS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));

        jLabel42.setText("Rent Start Date");

        jLabel43.setText("Rent End Date");

        jCBInTenantDateME.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jCBInTenantDateYE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        javax.swing.GroupLayout jPanelInTenantLayout = new javax.swing.GroupLayout(jPanelInTenant);
        jPanelInTenant.setLayout(jPanelInTenantLayout);
        jPanelInTenantLayout.setHorizontalGroup(
            jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInTenantLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonTenantAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButtonTenantClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
            .addGroup(jPanelInTenantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBInTenantDependents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextInTenantPhone, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextInTenantEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addComponent(jLabel20)
                    .addComponent(jLabeTlPN)
                    .addComponent(jLabel22)
                    .addGroup(jPanelInTenantLayout.createSequentialGroup()
                        .addGroup(jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextInTenantName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(146, 146, 146)
                        .addGroup(jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jCBInTenantProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelInTenantLayout.createSequentialGroup()
                        .addComponent(jCBInTenantDateMS, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jCBInTenantDateYS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel42)
                    .addGroup(jPanelInTenantLayout.createSequentialGroup()
                        .addComponent(jCBInTenantDateME, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jCBInTenantDateYE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel43))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanelInTenantLayout.setVerticalGroup(
            jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInTenantLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel23))
                .addGap(0, 0, 0)
                .addGroup(jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextInTenantName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInTenantProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel20)
                .addGap(1, 1, 1)
                .addComponent(jTextInTenantEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabeTlPN)
                .addGap(0, 0, 0)
                .addComponent(jTextInTenantPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel22)
                .addGap(0, 0, 0)
                .addComponent(jCBInTenantDependents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel42)
                .addGap(1, 1, 1)
                .addGroup(jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBInTenantDateMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInTenantDateYS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel43)
                .addGap(1, 1, 1)
                .addGroup(jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBInTenantDateME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBInTenantDateYE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelInTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTenantClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTenantAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPaneInput.addTab("Tenant", jPanelInTenant);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneInput)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneInput)
        );

        jPanelMain.addTab("Insert Data", jPanel1);

        jCBOutTenantName.setModel(new javax.swing.DefaultComboBoxModel(tenantCB));

        jLabel39.setText("Select Tenant");

        jButtonOutTenantLoad.setText("Load");
        jButtonOutTenantLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutTenantLoadActionPerformed(evt);
            }
        });

        jTAOutTenantInfo.setEditable(false);
        jTAOutTenantInfo.setColumns(20);
        jTAOutTenantInfo.setRows(5);
        jScrollPane4.setViewportView(jTAOutTenantInfo);

        jTAOutTenantPay.setEditable(false);
        jTAOutTenantPay.setColumns(20);
        jTAOutTenantPay.setRows(5);
        jScrollPane5.setViewportView(jTAOutTenantPay);

        jLabel55.setText("Tenant Info");

        jLabel56.setText("Rent Payment History");

        javax.swing.GroupLayout jPanelOutTenantLayout = new javax.swing.GroupLayout(jPanelOutTenant);
        jPanelOutTenant.setLayout(jPanelOutTenantLayout);
        jPanelOutTenantLayout.setHorizontalGroup(
            jPanelOutTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutTenantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOutTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addGroup(jPanelOutTenantLayout.createSequentialGroup()
                        .addGroup(jPanelOutTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBOutTenantName, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addGap(75, 75, 75)
                        .addGroup(jPanelOutTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addComponent(jButtonOutTenantLoad)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanelOutTenantLayout.setVerticalGroup(
            jPanelOutTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutTenantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(0, 0, 0)
                .addGroup(jPanelOutTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBOutTenantName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOutTenantLoad))
                .addGap(44, 44, 44)
                .addGroup(jPanelOutTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addGap(1, 1, 1)
                .addGroup(jPanelOutTenantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Tenant Info", jPanelOutTenant);

        jCBOutProp.setModel(new javax.swing.DefaultComboBoxModel(propertyCB));

        jButtonOutPropLoad.setText("Load");
        jButtonOutPropLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutPropLoadActionPerformed(evt);
            }
        });

        jLabel34.setText("Select Property");

        jTAOutPropInfo.setEditable(false);
        jTAOutPropInfo.setColumns(20);
        jTAOutPropInfo.setRows(5);
        jScrollPane3.setViewportView(jTAOutPropInfo);

        jTAOutPropRepair.setEditable(false);
        jTAOutPropRepair.setColumns(20);
        jTAOutPropRepair.setRows(5);
        jScrollPane6.setViewportView(jTAOutPropRepair);

        jLabel57.setText("Property Info");

        jLabel58.setText("Repair History");

        javax.swing.GroupLayout jPanelOutPropLayout = new javax.swing.GroupLayout(jPanelOutProp);
        jPanelOutProp.setLayout(jPanelOutPropLayout);
        jPanelOutPropLayout.setHorizontalGroup(
            jPanelOutPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutPropLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOutPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addGroup(jPanelOutPropLayout.createSequentialGroup()
                        .addGroup(jPanelOutPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addComponent(jCBOutProp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanelOutPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOutPropLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jButtonOutPropLoad))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOutPropLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanelOutPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel57))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanelOutPropLayout.setVerticalGroup(
            jPanelOutPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutPropLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addGap(0, 0, 0)
                .addGroup(jPanelOutPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBOutProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOutPropLoad))
                .addGap(44, 44, 44)
                .addGroup(jPanelOutPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58))
                .addGap(1, 1, 1)
                .addGroup(jPanelOutPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Property Info", jPanelOutProp);

        jLabel40.setText("Select Repair Record");

        jCBOutRepair.setModel(new javax.swing.DefaultComboBoxModel(repairCB));

        jButtonOutRepair.setText("Load");
        jButtonOutRepair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutRepairActionPerformed(evt);
            }
        });

        jTAOutRepair.setEditable(false);
        jTAOutRepair.setColumns(20);
        jTAOutRepair.setRows(5);
        jScrollPane7.setViewportView(jTAOutRepair);

        jLabel59.setText("Repair Info");

        javax.swing.GroupLayout jPanelOutRepairLayout = new javax.swing.GroupLayout(jPanelOutRepair);
        jPanelOutRepair.setLayout(jPanelOutRepairLayout);
        jPanelOutRepairLayout.setHorizontalGroup(
            jPanelOutRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutRepairLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOutRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addGroup(jPanelOutRepairLayout.createSequentialGroup()
                        .addGroup(jPanelOutRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                            .addComponent(jCBOutRepair, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(83, 83, 83)
                        .addComponent(jButtonOutRepair))
                    .addComponent(jLabel59))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanelOutRepairLayout.setVerticalGroup(
            jPanelOutRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutRepairLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addGap(0, 0, 0)
                .addGroup(jPanelOutRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBOutRepair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOutRepair))
                .addGap(45, 45, 45)
                .addComponent(jLabel59)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Repair Info", jPanelOutRepair);

        jCBOutOwner.setModel(new javax.swing.DefaultComboBoxModel(ownerCB));

        jLabel41.setText("Select Owner");

        jButtonOutOwner.setText("Load");
        jButtonOutOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutOwnerActionPerformed(evt);
            }
        });

        jTAOutOwnerInfo.setEditable(false);
        jTAOutOwnerInfo.setColumns(20);
        jTAOutOwnerInfo.setRows(5);
        jScrollPane1.setViewportView(jTAOutOwnerInfo);

        jTAOutOwnerPay.setEditable(false);
        jTAOutOwnerPay.setColumns(20);
        jTAOutOwnerPay.setRows(5);
        jScrollPane8.setViewportView(jTAOutOwnerPay);

        jLabel60.setText("Owner Info");

        jLabel61.setText("Members of Group");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCBOutOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(jButtonOutOwner)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel61)
                        .addGap(116, 116, 116))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBOutOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOutOwner))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Owner Info", jPanel3);

        jCBOutPayM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jCBOutPayY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));

        jLabel44.setText("Select Payment Month");

        jButtonOutPay.setText("Load");
        jButtonOutPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutPayActionPerformed(evt);
            }
        });

        jTAOutPayPaid.setEditable(false);
        jTAOutPayPaid.setColumns(20);
        jTAOutPayPaid.setRows(5);
        jScrollPane9.setViewportView(jTAOutPayPaid);

        jTAOutPayNP.setEditable(false);
        jTAOutPayNP.setColumns(20);
        jTAOutPayNP.setRows(5);
        jScrollPane10.setViewportView(jTAOutPayNP);

        jLabel45.setText("Paid");

        jLabel46.setText("Not Paid");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jCBOutPayM, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jCBOutPayY, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addGap(113, 113, 113)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jButtonOutPay)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBOutPayM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBOutPayY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOutPay))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Payment", jPanel4);

        jTAOutSearch.setColumns(20);
        jTAOutSearch.setRows(5);
        jScrollPane11.setViewportView(jTAOutSearch);

        jCBOutSearchYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));

        jLabel47.setText("County");

        jCBOutSearchCounty.setModel(new javax.swing.DefaultComboBoxModel(countyCBNull));

        jLabel48.setText("Bedroom");

        jCBOutSearchBed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7+", " " }));

        jLabel49.setText("Bathroom");

        jCBOutSearchBath.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7+" }));

        jLabel50.setText("Property Type");

        jCBOutSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Condo", "Townhouse", "Single Family" }));

        jLabel51.setText("Minimum Size");

        jLabel52.setText("Year Built");

        jLabel53.setText("Max Rent");

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabel62.setText("Matched Properties");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBOutSearchCounty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBOutSearchYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel50)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCBOutSearchType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBOutSearchBed, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel48))
                                    .addGap(34, 34, 34)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel49)
                                        .addComponent(jCBOutSearchBath, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel51)
                            .addComponent(jTextOutSearchSize, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)
                            .addComponent(jTextOutSearchRent, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(jButtonSearch))
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addGap(49, 49, 49))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel62))
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextOutSearchSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel52)
                        .addGap(1, 1, 1)
                        .addComponent(jCBOutSearchYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel47)
                        .addGap(0, 0, 0)
                        .addComponent(jCBOutSearchCounty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel48))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBOutSearchBed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBOutSearchBath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel50)
                        .addGap(2, 2, 2)
                        .addComponent(jCBOutSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel53)
                        .addGap(0, 0, 0)
                        .addComponent(jTextOutSearchRent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButtonSearch))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Property Search", jPanel5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanelMain.addTab("Read Data", jPanel2);

        getContentPane().add(jPanelMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPropAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPropAddActionPerformed
        // Add property button
        
        String propName = jTextInPropertyAddress.getText();
        String propCity = jTextInPropertyCity.getText();
        String propZip = jTextInPropertyZip.getText();
        int ownerID = jCBInPropertyOwner.getSelectedIndex();
        int size = Integer.parseInt(jTextInPropertySize.getText().toString());
        int year = jCBInPropertyYear.getSelectedIndex() + 1917;
        String county = jCBInPropertyCounty.getSelectedItem().toString();
        int bedNum = jCBInPropertyBed.getSelectedIndex();
        int bathNum = jCBInPropertyBath.getSelectedIndex();
        
        //Inserts data into property table
        String query = "INSERT into Property VALUES(\"" + propName + "\", \"" + propCity
                +"\", \"" + propZip+ "\", " + ownerID +", " + size + ", " + year
                +", \""+ county + "\", " + bedNum +", " + bathNum +");";
        try{           
            Statement stmt = conn.createStatement();
            stmt.execute(query); 
                 }catch(Exception ex){	System.out.println(ex);
     	        }

        System.out.println(query);
        int type =  jCBInPropertyType.getSelectedIndex();
        String var1 = jTextInPropertyVar1.getText();
        String var2 = jTextInPropertyVar2.getText();
        String var3 = jTextInPropertyVar3.getText();
        
        //Inserts data into condo , townhouse, single family tables
        if (type ==0){
            query = "INSERT into Condo VALUES(\"" + propName + "\", \"" + var1 + "\");";
            System.out.println(query);
        }
        if (type == 1){
            query = "INSERT into TownHouse VALUES(\"" + propName + "\", \"" + var1
                    + "\", \"" + var2+ "\", \"" + var3+ "\");";
            System.out.println(query);
        }
        if (type == 2){
            query = "INSERT into SingleFamilyHouse VALUES(\"" + propName + "\", \"" + var1
                    + "\", \"" + var2 + "\");";
            System.out.println(query);
            try{           
                Statement stmt = conn.createStatement();
                stmt.execute(query); 
                     }catch(Exception ex){	System.out.println(ex);
         	        }

        }
        int rS =  jCBInPropertyRS.getSelectedIndex();
        String var4 = jTextInPropertyVar4.getText();
        String var5 = jTextInPropertyVar5.getText();
        String var6 = jTextInPropertyVar6.getText();
        
        //Inserts data into rental or sale
        if (rS == 0){
            query = "INSERT into Rental VALUES(\"" + propName + "\", \"" + var4
                    + "\", \"" + var5+ "\", \"" + var6+ "\");";
            System.out.println(query);
        }
        if (rS == 1){
            query = "INSERT into Sale VALUES(\"" + propName + "\", \"" + var4
                    + "\", \"" + var5+ "\", \"" + var6+ "\");";
            System.out.println(query);
        }
        try{           
            Statement stmt = conn.createStatement();
            stmt.execute(query); 
                 }catch(Exception ex){	System.out.println(ex);
     	        }

    }//GEN-LAST:event_jButtonPropAddActionPerformed

    private void jButtonStoreAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStoreAddActionPerformed
        // Add Store Button
    	int len = storeCB.length;
        String storeName = jTextInStoreName.getText();
        String storeAddress = jTextInStoreAddress.getText();
        String storePhone = jTextInStorePhone.getText();
        String query = "INSERT into Store VALUES("+len+ ", \"" + storeName + "\", \"" + storeAddress
                    + "\", \"" + storePhone + "\");";
        try{           
            Statement stmt = conn.createStatement();
            stmt.execute(query); 
            jButtonStoreClearActionPerformed(null);
                 }catch(Exception ex){	System.out.println(ex);
     	        }

        System.out.println(query);
        
    }//GEN-LAST:event_jButtonStoreAddActionPerformed

    private void jButtonPayAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPayAddActionPerformed
        // Add payment button
       // Add payment button
        
        int tenantId = jCBInPayTenant.getSelectedIndex();
        String propName = jCBInPayProperty.getSelectedItem().toString();
        String tenantName = jCBInPayTenant.getSelectedItem().toString();
        int tenantPay = Integer.parseInt(jTextInPayTenant.getText());
        int ownerPay = Integer.parseInt(jTextInPayOwner.getText());
        int tMonth = jCBInPayTM.getSelectedIndex()+1;
        int oMonth = jCBInPayOM.getSelectedIndex()+1;
        int tYear =  jCBInPayTY.getSelectedIndex()+2010;
        int oYear =  jCBInPayOY.getSelectedIndex()+2010;
        
        String query = "INSERT into RentPayment VALUES(" +rentPayLen + ", " + tenantId +
                ", " + tenantPay + ", " + tMonth + ", " + tYear + ", " +
                ownerPay + ", " + oMonth + ", " + oYear + ", \"" + propName + "\");";
        System.out.println(query);
        try{           
            Statement stmt = conn.createStatement();
            stmt.execute(query); 
            updateCB();
            jButtonPayClearActionPerformed(null);
                 }catch(SQLException ex){	System.out.println(ex);
     	        }
    }//GEN-LAST:event_jButtonPayAddActionPerformed

    private void jButtonTenantAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTenantAddActionPerformed
        //Add tenant button
        int tenantId = (tenantCB.length);
        String tenantName = jTextInTenantName.getText();
        String tenantEmail = jTextInTenantEmail.getText();
        String tenantPhone = jTextInTenantPhone.getText();
        int tenantDep = jCBInTenantDependents.getSelectedIndex();
        String propertyID = jCBInTenantProperty.getSelectedItem().toString();
        int startM = jCBInTenantDateMS.getSelectedIndex() + 1;
        int startY = jCBInTenantDateYS.getSelectedIndex() + 2010;
        int endM = jCBInTenantDateME.getSelectedIndex() + 1;
        int endY = jCBInTenantDateYE.getSelectedIndex() + 2010;
        
        String query = "INSERT into Tenant VALUES(" +tenantId + ", \"" + tenantName +
                "\", \"" + tenantEmail + "\", \"" + tenantPhone + "\", " +
                tenantDep + ", \"" + propertyID + "\", " + startM + ", " + startY +
                ", " + endM+ ", " + endY+ ");";
        try{           
            Statement stmt = conn.createStatement();
            stmt.execute(query); 
            updateCB();
            new AddSuccess().setVisible(true);
            jButtonTenantClearActionPerformed(null);
                 }catch(Exception ex){	System.out.println(ex);
     	        }

        System.out.println(query);
    }//GEN-LAST:event_jButtonTenantAddActionPerformed

    private void jButtonOGAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOGAddActionPerformed
        // Add owner to group button
        int ownerAddId = (jCBInOGOwner.getSelectedIndex());
        int ownerGroupId = (jCBInOGGroup.getSelectedIndex());
        String query = "INSERT into Ownergroup VALUES(" +ownerAddId + ", " + ownerGroupId+");";
        System.out.println(query);
        try{           
            Statement stmt = conn.createStatement();
            stmt.execute(query); 
            updateCB();
            new AddSuccess().setVisible(true);
                 }catch(Exception ex){	System.out.println(ex);
     	        }
        
    }//GEN-LAST:event_jButtonOGAddActionPerformed

    private void jButtonOwnerAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOwnerAddActionPerformed
        // Add owner button
         String ownerId = Integer.toString(ownerCB.length);
        String ownerName = jTextInOwnerName.getText();
        String ownerPhone = jTextInOwnerPhoneNum.getText();
        String ownerEmail = jTextInOwnerEmail.getText();
        String query = "INSERT into Owner VALUES(" +ownerId + ", \"" + ownerName +
                "\", \"" + ownerEmail + "\", \"" + ownerPhone + "\");";
         try{           
            Statement stmt = conn.createStatement();
            stmt.execute(query); 
            updateCB();
            new AddSuccess().setVisible(true);
            jButtonOwnerClearActionPerformed(null); 
                 }catch(SQLException ex){	System.out.println(ex);
     	        }
        
        System.out.println(query);

        
    }//GEN-LAST:event_jButtonOwnerAddActionPerformed

    private void jCBInPropertyRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBInPropertyRSActionPerformed
        // Changes the labels based on what type of property is selected(condo, touwnhouse, SFH)
        int type =  jCBInPropertyRS.getSelectedIndex();
        jTextInPropertyVar4.setText("");
        jTextInPropertyVar5.setText("");
        jTextInPropertyVar6.setText("");
        if (type == 0){ //rental
            propertyVar4.setText("Price");
            propertyVar5.setText("Max Tenants");
            propertyVar6.setText("Fee in %");
        }
        else if (type == 1){ //sale
            propertyVar4.setText("Sale Date");
            propertyVar5.setText("Sale Price");
            propertyVar6.setText("Fee in %");
        }
    }//GEN-LAST:event_jCBInPropertyRSActionPerformed

    private void jButtonRCAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRCAddActionPerformed
        // Adds repair company
        int rCId = (repairCompanyCB.length);
        String rCName = jTextInRCName.getText();
        String rCPhone = jTextInRCPhone.getText();
        
        String query = "INSERT into RepairCompany VALUES(" +rCId + ", \"" + rCName +
                "\", \"" + rCPhone + "\");";
        try{           
            Statement stmt = conn.createStatement();
            stmt.execute(query); 
            updateCB();
            jButtonRCClearActionPerformed(null);
            new AddSuccess().setVisible(true);
                 }catch(SQLException ex){	System.out.println(ex);
     	        }
       

        System.out.println(query);
    }//GEN-LAST:event_jButtonRCAddActionPerformed

    private void jCBInPropertyTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBInPropertyTypeActionPerformed
        //  // Changes the labels based on what type of property is selected(rental sale)
        int type =  jCBInPropertyType.getSelectedIndex();
       jTextInPropertyVar1.setText("");
       jTextInPropertyVar2.setText("");
       jTextInPropertyVar3.setText("");
       if (type == 0){ //condo
        propertyVar1.setText("Condo Number");
        propertyVar2.setText("NA");
        propertyVar3.setText("NA");
       }
       else if (type == 1){ //townhouse
        propertyVar1.setText("End Unit? (enter yes/no)");
        propertyVar2.setText("Number of Floors");
        propertyVar3.setText("Garage Size");
       }
       else if (type == 2){ //SFH
        propertyVar1.setText("Garage size");
        propertyVar2.setText("Number of Floors");
        propertyVar3.setText("NA");
       }
    }//GEN-LAST:event_jCBInPropertyTypeActionPerformed

    private void jButtonRepairAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepairAddActionPerformed
         // add repair records button
        int repairId = repairCB.length;
        String propName = jCBInRepairProperty.getSelectedItem().toString();
        int month = Integer.parseInt(jTextInRepairDateM.getText());
        int day = Integer.parseInt(jTextInRepairDateD.getText());
        int year = Integer.parseInt(jTextInRepairDateY.getText());
        String rDate = month + "-" + day + "-" + year;
        int repairCompany = jCBInRepairRC.getSelectedIndex();
        String repairmanName = jTextInRepairman.getText();
        int store = jCBInRepairStore.getSelectedIndex()-1;
        String mDate =jTextInMDate.getText();
        float rCost = Float.parseFloat(jTextInRepairRCost.getText());
        float mCost = 0;
        if(!jTextInRepairMCost.getText().isEmpty()){
                mCost = Float.parseFloat(jTextInRepairMCost.getText());
        }
        String query = "INSERT into Repair VALUES(" +repairId + ", \"" + propName +
                "\", " +rCost +", \"" + rDate + "\", " + repairCompany + ", \"" 
                + repairmanName +"\", " + mCost + ", \"" +mDate + "\"";
        if (store >= 0){
            query+= ", "+store + ");";
        }
        else{query+=", "+ null + ");";} 
        try{           
            Statement stmt = conn.createStatement();
            stmt.execute(query); 
            updateCB();
            new AddSuccess().setVisible(true);
            jButtonRepairClearActionPerformed(null);
                 }catch(Exception ex){	System.out.println(ex);
     	        }
        System.out.println(query);

        
    }//GEN-LAST:event_jButtonRepairAddActionPerformed

    private void jButtonOwnerClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOwnerClearActionPerformed
        // TODO add your handling code here:
        jTextInOwnerName.setText(null);
        jTextInOwnerPhoneNum.setText(null);
        jTextInOwnerEmail.setText(null);
    }//GEN-LAST:event_jButtonOwnerClearActionPerformed

    private void jButtonPayClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPayClearActionPerformed
        // TODO add your handling code here:
        jTextInPayTenant.setText(null);
        jTextInPayOwner.setText(null);
    }//GEN-LAST:event_jButtonPayClearActionPerformed

    private void jButtonRepairClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepairClearActionPerformed
        // TODO add your handling code here:
        jTextInRepairDateM.setText(null);
        jTextInRepairDateD.setText(null);
        jTextInRepairDateY.setText(null);
        jTextInRepairman.setText(null);
        jTextInRepairRCost.setText(null);
        jTextInRepairMCost.setText(null);
    }//GEN-LAST:event_jButtonRepairClearActionPerformed

    private void jButtonStoreClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStoreClearActionPerformed
        // TODO add your handling code here:
        jTextInStoreName.setText(null);
        jTextInStoreAddress.setText(null);
        jTextInStorePhone.setText(null);
    }//GEN-LAST:event_jButtonStoreClearActionPerformed

    private void jButtonPropClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPropClearActionPerformed
        // TODO add your handling code here:
        jTextInPropertyAddress.setText("");
        jTextInPropertyCity.setText("");
        jTextInPropertyZip.setText("");
        jCBInPropertyOwner.setSelectedIndex(0);
        jTextInPropertySize.setText("");
        jCBInPropertyYear.setSelectedIndex(0);
        jCBInPropertyCounty.setSelectedIndex(0);
        jCBInPropertyBed.setSelectedIndex(0);
        jCBInPropertyBath.setSelectedIndex(0);
        jTextInPropertyVar1.setText("");
        jTextInPropertyVar2.setText("");
        jTextInPropertyVar3.setText("");
        jTextInPropertyVar4.setText("");
        jTextInPropertyVar5.setText("");
        jTextInPropertyVar6.setText("");
    }//GEN-LAST:event_jButtonPropClearActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // Loads rental properties that match the search criteria
        int size=0;
        String county = "";
        int price =Integer.MAX_VALUE;
        if (!jTextOutSearchSize.getText().isEmpty()){
            size = Integer.parseInt(jTextOutSearchSize.getText());
        }
        int year = jCBOutSearchYear.getSelectedIndex() + 1917;
        county = jCBOutSearchCounty.getSelectedItem().toString();
        int bedNum = jCBOutSearchBed.getSelectedIndex();
        int bathNum = jCBOutSearchBath.getSelectedIndex();
        if (!jTextOutSearchRent.getText().isEmpty()){
            price = Integer.parseInt(jTextOutSearchRent.getText());
        }
        int type = jCBOutSearchType.getSelectedIndex();
        String query = "Select propertyID"
        + " FROM Property p, Rental r"
        + " Where "
        + " p.size >= " + size
        + " AND p.year >=" + year
        + " AND p.number_of_bedrooms >="+ bedNum
        + " AND p.number_of_bathrooms >="+ bathNum
        + " AND r.rental_price <" + price
        + " AND p.propertyID = r.Property_propertyID";
        if(county != ""){
            query = query + " AND p.County_countryID = \"" + county +"\"";
        }

        switch (type) {
            case 0 : query+=" And p.propertyID IN (Select Property_propertyID from Condo)";
            break;

            case 1 : query+=" And p.propertyID IN (Select Property_propertyID from Townhouse)";
            break;

            case 2 : query+=" And p.propertyID IN (Select Property_propertyID from SingleFamilyHouse)";
            break;
        }
        query+=";";
        jTAOutSearch.setText("");
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                jTAOutSearch.append(rs.getString("propertyID")+ "\n");

            }
        }catch(Exception ex){	System.out.println(ex);
        }

    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonOutPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutPayActionPerformed
        // Loads tenants who paid rent and those who didnt
        
        int month = jCBOutPayM.getSelectedIndex()+1;
        int year  = jCBOutPayY.getSelectedIndex()+2010;
        int absoluteDate = year*12+month;
        String query = "Select name"
        + " From Tenant"
        + " Where"
        + " tenantID IN"
        + " (Select Tenant_tenantID FROM RentPayment where"
        + " Tenant_payment_month = " + month
        + " AND Tenant_payment_year = " + year+")"
        + " AND Month_start_rent+ Year_start_rent * 12 <= " +absoluteDate
        + " AND Month_end_rent+ Year_end_rent * 12 >= " + absoluteDate +";";
        jTAOutPayPaid.setText("");
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                jTAOutPayPaid.append(rs.getString("name")+"\n");

            }
        }catch(Exception ex){	System.out.println(ex);
        }

        query = "Select name"
        + " From Tenant"
        + " Where"
        + " tenantID NOT IN"
        + " (Select Tenant_tenantID FROM RentPayment where "
        + " Tenant_payment_month = " + month
        + " AND Tenant_payment_year= " + year+")"
        + " AND Month_start_rent+ Year_start_rent * 12 < " +absoluteDate
        + " AND Month_end_rent+ Year_end_rent * 12 > " + absoluteDate +";";
        jTAOutPayNP.setText("");
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                jTAOutPayNP.append(rs.getString("name")+"\n");

            }
        }catch(Exception ex){	System.out.println(ex);
        }

    }//GEN-LAST:event_jButtonOutPayActionPerformed

    private void jButtonOutOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutOwnerActionPerformed
        // Loads owner information
        int ownerId = jCBOutOwner.getSelectedIndex();
        String ownerName = jCBOutOwner.getSelectedItem().toString();
        String ownerInfo = "Info";

        String query = "Select * from Owner where ownerID = " +ownerId+";";
        jTAOutOwnerPay.setText(query);
        String name = "";
        String email = "";
        String phone = "";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                name = rs.getString("name");
                email = rs.getString("email");
                phone = rs.getString("phone");
            }
            jTAOutOwnerInfo.setText(name + " email:" + email + " phone:" + phone);

        }catch(SQLException ex){	
            System.out.println(ex);
        }
        query = "Select * from Ownergroup g, Owner o where g.groupID = " +ownerId+" And g.ownerID = o.ownerID;";
        name ="";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                name += rs.getString("name")+"\n";

            }
            jTAOutOwnerPay.setText(name);

        }catch(Exception ex){	System.out.println(ex);
        }
    }//GEN-LAST:event_jButtonOutOwnerActionPerformed

    private void jButtonOutRepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutRepairActionPerformed
        // Loads repair information
        int repairId = jCBOutRepair.getSelectedIndex();
        String repair = jCBOutRepair.getSelectedItem().toString();
        String repairInfo = "Info";
        String query = "Select * FROM Repair WHERE repairID = " + repairId + ";";
        String address = "";
        String rcost = "";
        String rdate = "";
        String repairC = "";
        String repairman = "";
        String mcost = "";
        String mdate = "";
        String store = "";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                address = rs.getString("Property_propertyID");
                repairC = rs.getString("repair_company");
                repairman = rs.getString("repairman_name");
                rcost = rs.getString("repair_cost");
                mcost = rs.getString("materical_cost");
                rdate = rs.getString("repair_date");
                mdate = rs.getString("materical_purchase_date");
                store = storeCB[Integer.parseInt(rs.getString("store_purchased"))];

            }
        }catch(Exception ex){	System.out.println(ex);
        }
        jTAOutRepair.setText(address + "\n repaired by " + repairman + " from " + repairC+ " on\n"
            + rdate + "\n Cost: " + rcost+"\n Materials:" + mcost + " bought " + mdate
            + " at\n" + store);
    }//GEN-LAST:event_jButtonOutRepairActionPerformed

    private void jButtonOutPropLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutPropLoadActionPerformed
        // Loads property Information
        String propName = jCBOutProp.getSelectedItem().toString();
        String query  = "Select * from Property where propertyID = \"" +propName+"\";";
        String address = "";
        String size = "";
        String city = "";
        String zip = "";
        String county = "";
        String bathNo = "";
        String bedNo = "";
        String year = "";

        jTAOutTenantPay.setText("");
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                address = rs.getString("propertyID");
                city = rs.getString("City");
                zip = rs.getString("zip code");
                year = rs.getString("year");
                county = rs.getString("County_countryID");
                size = rs.getString("size");

            }

        }catch(Exception ex){	System.out.println(ex);
        }
        String propInfo = address + ", " + city + ", " + zip +"\n"
        + "built in " + year + "\nin " + county+ "\nsize " + size;
        jTAOutPropInfo.setText(propInfo);
        query  = "Select * from Repair where Property_propertyID = \"" +propName+"\";";
        jTAOutPropRepair.setText("");
        String cost = "";
        String date = "";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {

                float rcost = Float.parseFloat(rs.getString("repair_cost"));
                float mcost = Float.parseFloat(rs.getString("materical_cost"));
                cost = Float.toString(rcost + mcost);
                date = rs.getString("repair_date");
                jTAOutPropRepair.append("on " + date+ " $" + cost+"\n");

            }
        }catch(Exception ex){	System.out.println(ex);
        }

    }//GEN-LAST:event_jButtonOutPropLoadActionPerformed

    private void jButtonOutTenantLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutTenantLoadActionPerformed
        // Loads tenant information
        int tenantId = jCBOutTenantName.getSelectedIndex();

        String query = "Select * from Tenant where tenantId = " +tenantId+";";
        String name = "";
        String phone = "";
        String email = "";
        String prop = "";
        String months = "";
        String years = "";
        String monthe = "";
        String yeare = "";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                name = rs.getString("name");
                email = rs.getString("email");
                phone = rs.getString("phone");
                prop = rs.getString("propertyID");
                months = rs.getString("Month_start_rent");
                years = rs.getString("Year_start_rent");
                monthe = rs.getString("Month_end_rent");
                yeare = rs.getString("Year_end_rent");
            }
            jTAOutTenantInfo.setText(name + "\n email: " + email + "\n phone: " + phone +"\n renting: " + prop+
                "\n from " + months+ "/" + years
                +"\n to " +monthe + "/"+ yeare);

        }catch(Exception ex){	System.out.println(ex);
        }
        query = "Select * from RentPayment where Tenant_tenantId = " +tenantId+";";
        String pay = "";
        String month = "";
        String year = "";
        jTAOutTenantPay.setText("");
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                pay = rs.getString("tenant_payment_amount");
                month = rs.getString("tenant_payment_month");
                year = rs.getString("tenant_payment_year");
                jTAOutTenantPay.append(month + "/"+ year +" amount: $" + pay +"\n");
            }
        }catch(Exception ex){	System.out.println(ex);
        }
    }//GEN-LAST:event_jButtonOutTenantLoadActionPerformed

    private void jButtonRCClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRCClearActionPerformed
        // TODO add your handling code here:
       jTextInRCName.setText("");
       jTextInRCPhone.setText("");
    }//GEN-LAST:event_jButtonRCClearActionPerformed

    private void jButtonTenantClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTenantClearActionPerformed
        // TODO add your handling code here:
        jTextInTenantName.setText("");
        jTextInTenantEmail.setText("");
        jTextInTenantPhone.setText("");
       
    }//GEN-LAST:event_jButtonTenantClearActionPerformed

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
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new mainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonOGAdd;
    private javax.swing.JButton jButtonOutOwner;
    private javax.swing.JButton jButtonOutPay;
    private javax.swing.JButton jButtonOutPropLoad;
    private javax.swing.JButton jButtonOutRepair;
    private javax.swing.JButton jButtonOutTenantLoad;
    private javax.swing.JButton jButtonOwnerAdd;
    private javax.swing.JButton jButtonOwnerClear;
    private javax.swing.JButton jButtonPayAdd;
    private javax.swing.JButton jButtonPayClear;
    private javax.swing.JButton jButtonPropAdd;
    private javax.swing.JButton jButtonPropClear;
    private javax.swing.JButton jButtonRCAdd;
    private javax.swing.JButton jButtonRCClear;
    private javax.swing.JButton jButtonRepairAdd;
    private javax.swing.JButton jButtonRepairClear;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonStoreAdd;
    private javax.swing.JButton jButtonStoreClear;
    private javax.swing.JButton jButtonTenantAdd;
    private javax.swing.JButton jButtonTenantClear;
    private javax.swing.JComboBox<String> jCBInOGGroup;
    private javax.swing.JComboBox<String> jCBInOGOwner;
    private javax.swing.JComboBox<String> jCBInPayOM;
    private javax.swing.JComboBox<String> jCBInPayOY;
    private javax.swing.JComboBox<String> jCBInPayProperty;
    private javax.swing.JComboBox<String> jCBInPayTM;
    private javax.swing.JComboBox<String> jCBInPayTY;
    private javax.swing.JComboBox<String> jCBInPayTenant;
    private javax.swing.JComboBox<String> jCBInPropertyBath;
    private javax.swing.JComboBox<String> jCBInPropertyBed;
    private javax.swing.JComboBox<String> jCBInPropertyCounty;
    private javax.swing.JComboBox<String> jCBInPropertyOwner;
    private javax.swing.JComboBox<String> jCBInPropertyRS;
    private javax.swing.JComboBox<String> jCBInPropertyType;
    private javax.swing.JComboBox<String> jCBInPropertyYear;
    private javax.swing.JComboBox<String> jCBInRepairProperty;
    private javax.swing.JComboBox<String> jCBInRepairRC;
    private javax.swing.JComboBox<String> jCBInRepairStore;
    private javax.swing.JComboBox<String> jCBInTenantDateME;
    private javax.swing.JComboBox<String> jCBInTenantDateMS;
    private javax.swing.JComboBox<String> jCBInTenantDateYE;
    private javax.swing.JComboBox<String> jCBInTenantDateYS;
    private javax.swing.JComboBox<String> jCBInTenantDependents;
    private javax.swing.JComboBox<String> jCBInTenantProperty;
    private javax.swing.JComboBox<String> jCBOutOwner;
    private javax.swing.JComboBox<String> jCBOutPayM;
    private javax.swing.JComboBox<String> jCBOutPayY;
    private javax.swing.JComboBox<String> jCBOutProp;
    private javax.swing.JComboBox<String> jCBOutRepair;
    private javax.swing.JComboBox<String> jCBOutSearchBath;
    private javax.swing.JComboBox<String> jCBOutSearchBed;
    private javax.swing.JComboBox<String> jCBOutSearchCounty;
    private javax.swing.JComboBox<String> jCBOutSearchType;
    private javax.swing.JComboBox<String> jCBOutSearchYear;
    private javax.swing.JComboBox<String> jCBOutTenantName;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JLabel jLabeTlPN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelRC;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JTabbedPane jPaneInput;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelInOwner;
    private javax.swing.JPanel jPanelInOwnerGroup;
    private javax.swing.JPanel jPanelInPayment;
    private javax.swing.JPanel jPanelInProp;
    private javax.swing.JPanel jPanelInProperty;
    private javax.swing.JPanel jPanelInRepair;
    private javax.swing.JPanel jPanelInRepairCompany;
    private javax.swing.JPanel jPanelInStores;
    private javax.swing.JPanel jPanelInTenant;
    private javax.swing.JTabbedPane jPanelMain;
    private javax.swing.JPanel jPanelOutProp;
    private javax.swing.JPanel jPanelOutRepair;
    private javax.swing.JPanel jPanelOutTenant;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTAOutOwnerInfo;
    private javax.swing.JTextArea jTAOutOwnerPay;
    private javax.swing.JTextArea jTAOutPayNP;
    private javax.swing.JTextArea jTAOutPayPaid;
    private javax.swing.JTextArea jTAOutPropInfo;
    private javax.swing.JTextArea jTAOutPropRepair;
    private javax.swing.JTextArea jTAOutRepair;
    private javax.swing.JTextArea jTAOutSearch;
    private javax.swing.JTextArea jTAOutTenantInfo;
    private javax.swing.JTextArea jTAOutTenantPay;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextInMDate;
    private javax.swing.JTextField jTextInOwnerEmail;
    private javax.swing.JTextField jTextInOwnerName;
    private javax.swing.JTextField jTextInOwnerPhoneNum;
    private javax.swing.JTextField jTextInPayOwner;
    private javax.swing.JTextField jTextInPayTenant;
    private javax.swing.JTextField jTextInPropertyAddress;
    private javax.swing.JTextField jTextInPropertyCity;
    private javax.swing.JTextField jTextInPropertySize;
    private javax.swing.JTextField jTextInPropertyVar1;
    private javax.swing.JTextField jTextInPropertyVar2;
    private javax.swing.JTextField jTextInPropertyVar3;
    private javax.swing.JTextField jTextInPropertyVar4;
    private javax.swing.JTextField jTextInPropertyVar5;
    private javax.swing.JTextField jTextInPropertyVar6;
    private javax.swing.JTextField jTextInPropertyZip;
    private javax.swing.JTextField jTextInRCName;
    private javax.swing.JTextField jTextInRCPhone;
    private javax.swing.JTextField jTextInRepairDateD;
    private javax.swing.JTextField jTextInRepairDateM;
    private javax.swing.JTextField jTextInRepairDateY;
    private javax.swing.JTextField jTextInRepairMCost;
    private javax.swing.JTextField jTextInRepairRCost;
    private javax.swing.JTextField jTextInRepairman;
    private javax.swing.JTextField jTextInStoreAddress;
    private javax.swing.JTextField jTextInStoreName;
    private javax.swing.JTextField jTextInStorePhone;
    private javax.swing.JTextField jTextInTenantEmail;
    private javax.swing.JTextField jTextInTenantName;
    private javax.swing.JTextField jTextInTenantPhone;
    private javax.swing.JTextField jTextOutSearchRent;
    private javax.swing.JTextField jTextOutSearchSize;
    private javax.swing.JLabel propertyVar1;
    private javax.swing.JLabel propertyVar2;
    private javax.swing.JLabel propertyVar3;
    private javax.swing.JLabel propertyVar4;
    private javax.swing.JLabel propertyVar5;
    private javax.swing.JLabel propertyVar6;
    // End of variables declaration//GEN-END:variables
    private String[] tenantCB;
    private String[] propertyCB;
    private String[] ownerCB;
    private String[] repairCB;
    private String[] repairCompanyCB;
    private String[] storeCB;
    private String[] countyCB;
    private String[] countyCBNull;
    private String[] payCB;
    public Connection conn;
    int rentPayLen;
}
