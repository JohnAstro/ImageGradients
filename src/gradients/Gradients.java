/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gradients;

import java.awt.image.BufferedImage;

/**
 *
 * @author jonat
 */
public class Gradients {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedImage inImage   = ImageIo.readImage("utb.jpg");
       
       BufferedImage grayImage = ImageIo.toGray(inImage);
       ImageIo.writeImage(grayImage, "jpg", "grayed.jpg");  
       
        byte[][] grayInput  = ImageIo.getGrayByteImageArray2DFromBufferedImage(grayImage);
        
        // Calculate and weite Basic gradient-01 image
        Gradient obj = new Gradient();
        
        byte[][] basicGradientOutput1 = obj.calc_basic1(grayInput);
        
        BufferedImage basicOutput1 = ImageIo.setGrayByteImageArray2DToBufferedImage(basicGradientOutput1);
        ImageIo.writeImage(basicOutput1, "jpg", "UTB_Basicgradient01.jpg");
        
        
        // Calculate and write Basic gradient-02 image
        byte[][] basicGradientOutput2 = obj.calc_basic1(grayInput);
        
        BufferedImage basicOutput2 = ImageIo.setGrayByteImageArray2DToBufferedImage(basicGradientOutput2);
        ImageIo.writeImage(basicOutput2, "jpg", "UTB_Basicgradient02.jpg");
        
        
        // Calculate and write Robert gradient image
        byte[][] robertGradientOutput = obj.calc_robert(grayInput);
        
        BufferedImage robertOutput = ImageIo.setGrayByteImageArray2DToBufferedImage(robertGradientOutput);
        ImageIo.writeImage(robertOutput, "jpg", "UTB_Robertgradient.jpg");
        
        
        // Calculate and write Sobel gradient image
        byte[][] sobelGradientOutput = obj.calc_sobel(grayInput);
        
        BufferedImage sobelOutput = ImageIo.setGrayByteImageArray2DToBufferedImage(sobelGradientOutput);
        ImageIo.writeImage(sobelOutput, "jpg", "UTB_Sobelgradient.jpg");
        
        
        // Calculate and write Prewitt gradient image
        byte[][] prewittGradientOutput = obj.calc_prewitt(grayInput);
        
        BufferedImage prewittOutput = ImageIo.setGrayByteImageArray2DToBufferedImage(prewittGradientOutput);
        ImageIo.writeImage(prewittOutput, "jpg", "UTB_Prewittgradient.jpg");
    }
    
}
