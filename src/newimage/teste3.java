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
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class teste3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         int w,h;
         Scanner input = new Scanner(System.in);
         BufferedImage original = ImageIO.read(new File("google.jpg"));
         w=original.getWidth();
         h=original.getHeight();
         BufferedImage processada = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
         int[] pixels= new int[h*w*3];
         WritableRaster raster = processada.getRaster();
         original.getRaster().getPixels(0, 0,w , h, pixels);
         
         System.out.println("Type the percentage of image brightness: ");
         int percent = input.nextInt();
         
          for(int i=0;i<pixels.length;i+=3){
             int mp = (pixels[i]+pixels[i+1]+pixels[i+2])/3;
             int limiar = (mp*percent)/100;
             
             if(limiar + mp >= 255) {
                  pixels[i]=255;
                  pixels[i+1]=255;
                  pixels[i+2]=255;
             } else {
                  pixels[i]=limiar;
                  pixels[i+1]=limiar;
                  pixels[i+2]=limiar;
             }
          }
          
          raster.setPixels(0, 0, w, h, pixels);
          ImageIO.write(processada, "jpg", new File("whitePercent.jpg"));
    }  
}
