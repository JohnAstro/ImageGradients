/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gradients;

/**
 *
 * @author jonat
 */
public class Gradient {
    public void handleBorder(byte[][] input, byte[][]output, int hmask, int vmask) {
        int h = input.length;
        int w = input[0].length;
        //top rows
        for (int i = 0; i < hmask; i++) {
            for (int j = 0; j < w; j++) {
                output[i][j] = input[i][j];
            }
        }
        //bottom rows
        for (int i = h - hmask; i < h; i++) {
            for (int j = 0; j < w; j++) {
                output[i][j] = input[i][j];
            }
        }
        //left columns
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < vmask; j++) {
                output[i][j] = input[i][j];
            }
        }
        //right columns
        for (int i = 0; i < h; i++) {
            for (int j = w - vmask; j < w; j++) {
                output[i][j] = input[i][j];
            }
        }
    }
    public void handleBorder2(byte[][] input, byte[][]output, int hmask, int vmask) {
        int h = input.length;
        int w = input[0].length;
        //top rows
        for (int i = 0; i < hmask; i++) {
            for (int j = 0; j < w; j++) {
                output[i][j] = (byte) 0;
            }
        }
        //bottom rows
        for (int i = h - hmask; i < h; i++) {
            for (int j = 0; j < w; j++) {
                output[i][j] = (byte) 0;
            }
        }
        //left columns
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < vmask; j++) {
                output[i][j] = (byte) 0;
            }
        }
        //right columns
        for (int i = 0; i < h; i++) {
            for (int j = w - vmask; j < w; j++) {
                output[i][j] = (byte) 0;
            }
        }
    }
    
    public byte[][] calc_robert(byte[][]input) {

        // Decide border handling regions
        int h = (int) Math.floor((3 / 2));
        int v = (int) Math.floor((3 / 2));

        byte[][] output = new byte[input.length][input[0].length];
        
        // Handle borders:
        //handleBorder(input, output, h, v);
        handleBorder2(input, output, h, v);
        
        float gradient_value = 0;
        for (int i = h; i < output.length - v; i++) {
            for (int j = h; j < output[0].length - v; j++) {
                
                gradient_value = (float) (Math.abs((input[i][j] & 0xFF) - (input[i+1][j+1] & 0xFF)) +
                                    Math.abs((input[i+1][j] & 0xFF) - (input[i][j+1] & 0xFF)));
                
                output[i][j] = (byte) ImageIo.clip(gradient_value);
            }
        }
        return output;
    }
    
    public byte[][] calc_basic1(byte[][]input) {

        // Decide border handling regions
        int h = (int) Math.floor((3 / 2));
        int v = (int) Math.floor((3 / 2));

        byte[][] output = new byte[input.length][input[0].length];
        
        // Handle borders:
        //handleBorder(input, output, h, v);
        handleBorder2(input, output, h, v);
        
        float gradient_value = 0;
        for (int i = h; i < output.length - v; i++) {
            for (int j = h; j < output[0].length - v; j++) {
                
                gradient_value = (float) (Math.sqrt(((input[i][j] & 0xFF) - (input[i+1][j] & 0xFF)) * ((input[i][j] & 0xFF) - (input[i+1][j] & 0xFF))) +
                                    Math.sqrt(((input[i][j] & 0xFF) - (input[i][j+1] & 0xFF)) * ((input[i][j] & 0xFF) - (input[i][j+1] & 0xFF))));
                
                output[i][j] = (byte) ImageIo.clip(gradient_value);
            }
        }
        return output;
    }
    
    public byte[][] calc_basic2(byte[][]input) {

        // Decide border handling regions
        int h = (int) Math.floor((3 / 2));
        int v = (int) Math.floor((3 / 2));

        byte[][] output = new byte[input.length][input[0].length];
        
        // Handle borders:
        //handleBorder(input, output, h, v);
        handleBorder2(input, output, h, v);
        
        float gradient_value = 0;
        for (int i = h; i < output.length - v; i++) {
            for (int j = h; j < output[0].length - v; j++) {
                
                gradient_value = (float) (Math.abs((input[i][j] & 0xFF) - (input[i+1][j] & 0xFF)) +
                                    Math.abs((input[i][j] & 0xFF) - (input[i][j+1] & 0xFF)));
                
                output[i][j] = (byte) ImageIo.clip(gradient_value);
            }
        }
        return output;
    }
    
    public byte[][] calc_sobel(byte[][]input) {

        // Decide border handling regions
        int h = (int) Math.floor((3 / 2));
        int v = (int) Math.floor((3 / 2));

        byte[][] output = new byte[input.length][input[0].length];
        
        // Handle borders:
        //handleBorder(input, output, h, v);
        handleBorder2(input, output, h, v);
        
        float gradient_value = 0;
        for (int i = h; i < output.length - v; i++) {
            for (int j = h; j < output[0].length - v; j++) {
                
                gradient_value = (float) (Math.abs(-(input[i-1][j-1] & 0xFF) - 2*(input[i-1][j] & 0xFF) - (input[i-1][j+1] & 0xFF) + 
                                                    (input[i+1][j-1] & 0xFF) + 2*(input[i+1][j] & 0xFF) + (input[i+1][j+1] & 0xFF)) +
                                        Math.abs(-(input[i-1][j-1] & 0xFF) - 2*(input[i][j-1] & 0xFF) - (input[i+1][j-1] & 0xFF) + 
                                                  (input[i-1][j+1] & 0xFF) + 2*(input[i][j+1] & 0xFF) + (input[i+1][j+1] & 0xFF)));
                
                output[i][j] = (byte) ImageIo.clip(gradient_value);
            }
        }
        return output;
    }
    
    public byte[][] calc_prewitt(byte[][]input) {

        // Decide border handling regions
        int h = (int) Math.floor((3 / 2));
        int v = (int) Math.floor((3 / 2));

        byte[][] output = new byte[input.length][input[0].length];
        
        // Handle borders:
        //handleBorder(input, output, h, v);
        handleBorder2(input, output, h, v);
        
        float gradient_value = 0;
        for (int i = h; i < output.length - v; i++) {
            for (int j = h; j < output[0].length - v; j++) {
                
                gradient_value = (float) (Math.abs(-(input[i-1][j-1] & 0xFF) - (input[i-1][j] & 0xFF) - (input[i-1][j+1] & 0xFF) + 
                                                    (input[i+1][j-1] & 0xFF) + (input[i+1][j] & 0xFF) + (input[i+1][j+1] & 0xFF)) +
                                        Math.abs(-(input[i-1][j-1] & 0xFF) - (input[i][j-1] & 0xFF) - (input[i+1][j-1] & 0xFF) + 
                                                  (input[i-1][j+1] & 0xFF) + (input[i][j+1] & 0xFF) + (input[i+1][j+1] & 0xFF)));
                
                output[i][j] = (byte) ImageIo.clip(gradient_value);
            }
        }
        return output;
    }
}
