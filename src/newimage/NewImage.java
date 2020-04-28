/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newimage;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author vitor
 */
public class NewImage {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         int w,h;
         BufferedImage original = ImageIO.read(new File("google.jpg"));
         w=original.getWidth();
         h=original.getHeight();
         BufferedImage processada = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
         int[] pixels= new int[h*w*3];
         WritableRaster raster = processada.getRaster();
         original.getRaster().getPixels(0, 0,w , h, pixels);
         int limiar =70;
          for(int i=0;i<pixels.length;i+=3){
             int ml=(pixels[i]+pixels[i+1]+pixels[i+2])/3;
              if(ml<limiar){
                  pixels[i]=0;
                  pixels[i+1]=0;
                  pixels[i+2]=0;
                  
              }else{
                  pixels[i]=255;
                  pixels[i+1]=255;
                  pixels[i+2]=255;
              }
                  
          }
          
          raster.setPixels(0, 0, w, h, pixels);
        ImageIO.write(processada, "jpg", new File("blackWhite.jpg"));
    }
    
}
