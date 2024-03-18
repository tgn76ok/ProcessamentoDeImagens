package untitled;

import java.awt.*;
import java.awt.image.BufferedImage;

public class aumentoTonalidade {
    static BufferedImage mudarBandaR(BufferedImage img, float valor) {
        int width = img.getWidth();
        int height = img.getHeight();
        int Vermelho =0 ;

        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));

                int result =(int)  Math.min((cor.getRed()+valor), 255);
                int resultnew = Math.max(result, 0);
                System.out.println(resultnew);


                Color novaCor = new Color(resultnew, cor.getGreen() ,cor.getBlue());
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    static BufferedImage mudarBandaG(BufferedImage img, float valor) {
        int width = img.getWidth();
        int height = img.getHeight();
        int Vermelho =0 ;

        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));

                int result =(int)  Math.min((cor.getGreen()+valor), 255);
                int resultnew = Math.max(result, 0);
                System.out.println(resultnew);


                Color novaCor = new Color(cor.getRed(), resultnew ,cor.getBlue());
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    static BufferedImage mudarBandaB(BufferedImage img, float valor) {
        int width = img.getWidth();
        int height = img.getHeight();
        int Vermelho =0 ;

        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));

                int result =(int)  Math.min((cor.getBlue()+valor), 255);
                int resultnew = Math.max(result, 0);
                System.out.println(resultnew);


                Color novaCor = new Color(cor.getRed(), cor.getGreen() ,resultnew);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }
    static BufferedImage mudarBandas(BufferedImage img, float valor) {
        int width = img.getWidth();
        int height = img.getHeight();
        int Vermelho =0 ;

        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));

                int result =(int)  Math.min((cor.getBlue()+valor), 255);
                int resultBlue = Math.max(result, 0);

                int resultGreen =(int)  Math.min((cor.getGreen()+valor), 255);
                int resultnewGreen = Math.max(resultGreen, 0);

                int resultRed =(int)  Math.min((cor.getRed()+valor), 255);
                int resultnewRed= Math.max(resultRed, 0);



                Color novaCor = new Color(resultnewRed, resultnewGreen ,resultBlue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

}
