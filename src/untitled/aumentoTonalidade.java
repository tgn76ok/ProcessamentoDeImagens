package untitled;

import java.awt.*;
import java.awt.image.BufferedImage;

public class aumentoTonalidade {
    static BufferedImage mudarBandaR(BufferedImage img, float valor) {
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));

                int newred = validarCor((int) valor, cor.getRed());

                Color novaCor = new Color(newred, cor.getGreen() ,cor.getBlue());
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    static int validarCor(int valor, int cor) {
        cor += valor;

        if(cor >255)
            return 255;
        else if (cor < 0)
            return 0;
        return cor;
    }
    static int validarCor(int cor) {

        if(cor >255)
            return  255;
        else if (cor < 0)
            return cor * -1;
        return cor;
    }
    static BufferedImage mudarBandaG(BufferedImage img, float valor) {
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));

                int newgree = validarCor((int) valor, cor.getGreen());

                Color novaCor = new Color(cor.getRed(), newgree ,cor.getBlue());
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    static BufferedImage mudarBandaB(BufferedImage img, float valor) {
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));

                int newblue = validarCor((int) valor, cor.getBlue());


                Color novaCor = new Color(cor.getRed(), cor.getGreen() ,newblue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }
    static BufferedImage mudarTodasBandas(BufferedImage img, float valor) {
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));



                int resultBlue = validarCor((int) valor, cor.getBlue());
                int resultnewGreen = validarCor((int) valor, cor.getGreen());
                int resultnewRed = validarCor((int) valor, cor.getRed());



                Color novaCor = new Color(resultnewRed, resultnewGreen ,resultBlue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }

    static BufferedImage mudarAditivoY( BufferedImage img,float valor) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        double[][][] matriz = Converter.rbgParaYIQmatriz(img);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j][0] = matriz[i][j][0]+valor;

            }
        }
        return Converter.converterRGB(matriz, imgSaida);

    }
    static BufferedImage mudarMultY( BufferedImage img,float valor) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        double[][][] matriz = Converter.rbgParaYIQmatriz(img);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j][0] = matriz[i][j][0]*valor;

            }
        }
        return  Converter.converterRGB(matriz, imgSaida);

    }
}
