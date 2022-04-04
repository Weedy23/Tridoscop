import javax.swing.*;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class screen extends javax.swing.JFrame {
        public screen() {
            initComponents();
        }

        public int width = 500;
        public int height = 500;


        @SuppressWarnings("unchecked")
        private void initComponents() {

            drawTriangleButton = new javax.swing.JButton();
            screen = new javax.swing.JPanel();
            draw = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            drawTriangleButton.setText("draw Triangle");
            drawTriangleButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    drawTriangleButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout screenLayout = new javax.swing.GroupLayout(screen);
            screen.setLayout(screenLayout);
            screenLayout.setHorizontalGroup(
                    screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, width, Short.MAX_VALUE)
            );
            screenLayout.setVerticalGroup(
                    screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, height, Short.MAX_VALUE)
            );

            draw.setText("draw");
            draw.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    drawActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(screen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(drawTriangleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(draw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(screen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(draw)
                                                    .addGap(5, 5, 5)
                                                    .addComponent(drawTriangleButton)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addContainerGap())
            );

            draw.setBounds(height - 90, 0, 80, 20);
            drawTriangleButton.setBounds(height - 90, 25, 80, 20);
            SpinnerNumberModel model = new SpinnerNumberModel(50, 1, Short.MAX_VALUE, 1);
            spinner = new JSpinner(model);
            spinner.setValue(50);
            spinner.setBounds(height - 90, 0,  80, 30);
            screen.add(spinner);
            spinner.setVisible(true);
            radius = new JLabel();
            radius.setBounds(height - 140, 4, 80, 20);
            radius.setText("Radius:");
            screen.add(radius);
            model = new SpinnerNumberModel(6, 1, Short.MAX_VALUE, 1);
            spinner2 = new JSpinner(model);
            spinner2.setValue(6);
            spinner2.setBounds(height - 90, 25,  80, 30);
            screen.add(spinner2);
            nCount = new JLabel();
            nCount.setBounds(height - 140, 28, 80, 20);
            nCount.setText("nCount:");
            screen.add(nCount);
            pack();
        }

        private void drawTriangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawTriangleButtonActionPerformed
            drawRandTriangle();
        }

        private void drawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawActionPerformed
            draw();
        }

        public static void main(String args[]) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new screen().setVisible(true);
                }
            });
        }

        private int n = 10;
        public int r = 50;
        public int j = 0;

        public void drawRandTriangle() {
            Graphics g = screen.getGraphics();
            Random rand = new Random(j);

            int k = 0;
            Polygon[] poly = new Polygon[n];
            poly[k] = new Polygon();
            double[] lenk = new double[3];
            lenk[0] = 0;
            lenk[2] =  2*Math.PI/n;
            lenk[1] = rand.nextDouble()*lenk[2];
            j++;
            double[] radius = new double[3];
            radius[0] = rand.nextDouble()*r;
            j++;
            radius[2] = rand.nextDouble()*r;
            j++;
            radius[1] = (r*Math.cos(lenk[2]/2))/(Math.cos(lenk[2]/2 - lenk[1]));
            Color color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
            g.setColor(color);
            for (int i = 0; i < 3; i ++) {
                int x = (int) (xc + radius[i]*Math.cos(lenk[i]));
                int y = (int) (yc - radius[i]*Math.sin(lenk[i]));
                poly[k].addPoint(x, y);
            }
            g.fillPolygon(poly[k]);
            k++;

            for (int i = 1; i < n; i++) {
                poly[k] = new Polygon();
                double[] lenkN = new double[3];
                if (i%2 == 0) {
                    lenkN[0] = i*lenk[2];
                    lenkN[1] = lenkN[0] + lenk[1];
                    lenkN[2] = lenkN[0] + lenk[2];
                } else {
                    lenkN[2] = i*lenk[2];
                    lenkN[0] = lenkN[2] + lenk[2];
                    lenkN[1] = lenkN[0] - lenk[1];

                }
                for (int z = 0; z < 3; z ++) {
                    int x = (int) (xc + radius[z]*Math.cos(lenkN[z]));
                    int y = (int) (yc - radius[z]*Math.sin(lenkN[z]));
                    poly[k].addPoint(x, y);
                }
                g.fillPolygon(poly[k]);
                k++;
            }
        }

        public int xc = (width - 100)/2;
        public int yc = height/2;

        public void draw() {
            try {
                spinner.commitEdit();
            } catch ( java.text.ParseException e ) { }
            r = (Integer) spinner.getValue();
            try {
                spinner2.commitEdit();
            } catch ( java.text.ParseException e ) { }
            n = (Integer) spinner2.getValue();
            Graphics g = screen.getGraphics();
            double a1 = 2*Math.PI/n;
            double x1, x2, y1, y2;
            for (int i = 0; i < n; i++) {
                x1 = xc + r*Math.cos(a1*i);
                y1 = yc + r*Math.sin(a1*i);
                x2 = xc + r*Math.cos(a1*i + a1);
                y2 = yc + r*Math.sin(a1*i + a1);
                g.drawLine(xc, yc, (int) x1, (int) y1);
                g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            }
        }
    private javax.swing.JButton draw;
    private javax.swing.JButton drawTriangleButton;
    private javax.swing.JPanel screen;
    private javax.swing.JSpinner spinner;
    private javax.swing.JLabel radius;
    private javax.swing.JSpinner spinner2;
    private javax.swing.JLabel nCount;

}
