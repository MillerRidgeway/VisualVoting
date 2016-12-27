/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author stu340407
 */
public class Main extends javax.swing.JFrame {

    public static boolean comboColor;
    public boolean animate = false;
    public Integer year = 0;
    public int aniYear;
    public double scaleFactor = 1;
    public double scale;
    public double startX = 0;
    public double startY = 0;
    public String state;
    
    public ArrayList<State> states = new ArrayList<>();
    public ArrayList<State> selStates = new ArrayList<>();
    public static String[] allStates = {"AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL",
        "GA", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA",
        "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE",
        "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI",
        "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
        "WY"};
    public static String[] allYears = {"1960", "1964", "1968", "1972", "1976", "1980", "1984", "1988",
        "1992", "1996", "2000", "2004", "2008", "2012"};

    public Main() {
        initComponents();

        for (String stateName : allStates) {
            State s = State.loadState(stateName);
            System.out.println("Loading: " + stateName);
            s.getVotes(stateName, year);
            states.add(s);
        }
        for (int j = 0; j<allStates.length; j++) {
            for(int i  = 0; i<allYears.length; i++)
            {
                states.get(j).getVotes(allStates[j],i);
            } 
        }
       
        selStates = states;
        setScale();
        clock.start();
        view2.repaint();
    }
    
    public Timer clock = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tick();
            view2.repaint();
        }
    });

    public void setScale() {
        Point h = selStates.get(0).high;
        Point l = selStates.get(0).low;
        for (State s : selStates) {
            h = s.high.max(h);
            l = s.low.min(l);
        }
        scale = (Math.min(1000 / (h.x - l.x), 600 / (h.y - l.y)));
        startX = l.x;
        startY = l.y;
    }

    public class MyPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (State s : selStates) {
                for (District d : s.districts) {
                    g.setColor(d.getColor(year));
                    g.fillPolygon(d.shape.toPolygon(scale, startX, startY));
                    yearLabel.setText("Year: " + allYears[year]);
                }

            }
        }
    }
    
    public void tick()
    {
        if(animate)
        {
           year = (year+1)%allYears.length;
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

        view = new MyPanel();
        view2 = new MyPanel()
        ;
        zoomLabel = new java.awt.Label();
        zInButton = new javax.swing.JButton();
        zOutButton = new javax.swing.JButton();
        panLabel = new javax.swing.JLabel();
        leftButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        partySelect = new javax.swing.JComboBox();
        stateBox = new javax.swing.JTextField();
        yearBox = new javax.swing.JTextField();
        goButton = new javax.swing.JButton();
        candidateLabel = new javax.swing.JLabel();
        animateButton = new javax.swing.JButton();
        yearLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));

        view.setMinimumSize(new java.awt.Dimension(1000, 600));

        javax.swing.GroupLayout viewLayout = new javax.swing.GroupLayout(view);
        view.setLayout(viewLayout);
        viewLayout.setHorizontalGroup(
            viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        viewLayout.setVerticalGroup(
            viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        view2.setBackground(new java.awt.Color(102, 255, 204));
        view2.setPreferredSize(new java.awt.Dimension(1000, 600));

        javax.swing.GroupLayout view2Layout = new javax.swing.GroupLayout(view2);
        view2.setLayout(view2Layout);
        view2Layout.setHorizontalGroup(
            view2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        view2Layout.setVerticalGroup(
            view2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        zoomLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        zoomLabel.setText("Zoom");

        zInButton.setBackground(new java.awt.Color(0, 51, 51));
        zInButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        zInButton.setText("+");
        zInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                zInButtonActionPerformed(evt);
            }
        });

        zOutButton.setBackground(new java.awt.Color(0, 51, 51));
        zOutButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        zOutButton.setText("-");
        zOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                zOutButtonActionPerformed(evt);
            }
        });

        panLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        panLabel.setText("Pan");

        leftButton.setText("Left");
        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        rightButton.setText("Right");
        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        upButton.setText("Up");
        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        downButton.setText("Down");
        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        partySelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Two Party", "Three Party" }));
        partySelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                partySelectActionPerformed(evt);
            }
        });

        stateBox.setText("States");
        stateBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                stateBoxActionPerformed(evt);
            }
        });

        yearBox.setText("Year");
        yearBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                yearBoxActionPerformed(evt);
            }
        });

        goButton.setText("Go");
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        animateButton.setText("Animate");
        animateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                animateButtonActionPerformed(evt);
            }
        });

        yearLabel.setText("Year");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(view2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zInButton)
                            .addComponent(zOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(142, 142, 142)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(panLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(133, 133, 133)
                                        .addComponent(partySelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(upButton)
                                            .addComponent(downButton))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rightButton)
                                            .addComponent(leftButton))
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(candidateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(stateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(goButton))))
                            .addComponent(animateButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(view2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(zoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(panLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(partySelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(goButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(zInButton))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rightButton)
                                .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(candidateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(upButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(zOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(340, 340, 340)
                        .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(downButton)
                                    .addComponent(leftButton)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(animateButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        candidateLabel.getAccessibleContext().setAccessibleName("candidateLabel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zInButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_zInButtonActionPerformed
        scale = scale * 1.1;
        view2.repaint();
    }//GEN-LAST:event_zInButtonActionPerformed

    private void zOutButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_zOutButtonActionPerformed
        scale = scale / 1.1;
        view2.repaint();
    }//GEN-LAST:event_zOutButtonActionPerformed

    private void rightButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        startX = startX + ((1000 / scale) * 0.05);
        view2.repaint();
    }//GEN-LAST:event_rightButtonActionPerformed

    private void downButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        startY = startY + ((1000 / scale) * 0.05);
        view2.repaint();
    }//GEN-LAST:event_downButtonActionPerformed

    private void partySelectActionPerformed(ActionEvent evt) {//GEN-FIRST:event_partySelectActionPerformed
        if (partySelect.getSelectedIndex() == 1) {
            comboColor = true;
        }
        else 
            comboColor = false;
        view2.repaint();
    }//GEN-LAST:event_partySelectActionPerformed

    private void upButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        startY = startY - ((1000 / scale) * 0.05);
        view2.repaint();
    }//GEN-LAST:event_upButtonActionPerformed

    private void leftButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        startX = startX - ((1000 / scale) * 0.05);
        view2.repaint();
    }//GEN-LAST:event_leftButtonActionPerformed

    private void yearBoxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_yearBoxActionPerformed
    }//GEN-LAST:event_yearBoxActionPerformed

    private void stateBoxActionPerformed(ActionEvent evt) {//GEN-FIRST:event_stateBoxActionPerformed
    }//GEN-LAST:event_stateBoxActionPerformed

    private void goButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        if(!stateBox.getText().equals("States")){
        state = stateBox.getText();
        selStates = new ArrayList<State>();
        String[] temp = state.split(",");
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < states.size(); j++) {
                if (temp[i].equals(states.get(j).name)) {
                    selStates.add(states.get(j));
                }
            }
        }
        setScale();
        }
        for (int i = 0; i < allYears.length; i++) {
            if (allYears[i].equals(yearBox.getText())) {
                year = i;
            }
        }
        
        view2.repaint();
        
    }//GEN-LAST:event_goButtonActionPerformed

    private void animateButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_animateButtonActionPerformed
        if(animate)
        {
            animate = false;
        }
        else
            animate = true;
    }//GEN-LAST:event_animateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton animateButton;
    private javax.swing.JLabel candidateLabel;
    private javax.swing.JButton downButton;
    private javax.swing.JButton goButton;
    private javax.swing.JButton leftButton;
    private javax.swing.JLabel panLabel;
    private javax.swing.JComboBox partySelect;
    private javax.swing.JButton rightButton;
    private javax.swing.JTextField stateBox;
    private javax.swing.JButton upButton;
    private JPanel view;
    private JPanel view2;
    private javax.swing.JTextField yearBox;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JButton zInButton;
    private javax.swing.JButton zOutButton;
    private java.awt.Label zoomLabel;
    // End of variables declaration//GEN-END:variables
}
