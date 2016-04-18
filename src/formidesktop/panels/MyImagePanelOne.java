/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formidesktop.panels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author jcapiz
 */
public class MyImagePanelOne extends JPanel{
    
    private BufferedImage image;
    
    public MyImagePanelOne(){
       try {                
          image = ImageIO.read(new File("imgs/upiita_logo_blk.png"));
       } catch (IOException ex) {
           ex.printStackTrace();
            // handle exception...
       }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }
}
