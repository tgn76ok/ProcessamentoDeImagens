package untitled;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FiltrosPontuais {

    public static BufferedImage bandaR(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                Color novaCor = new Color (cor.getRed(), 0 ,0);
                imgSaida.setRGB(w, h, novaCor.getRGB()); //desenhando os pixels da imagem
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaG(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                Color novaCor = new Color (0, cor.getGreen() ,0);
                imgSaida.setRGB(w, h, novaCor.getRGB()); //desenhando os pixels da imagem
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaB(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                Color novaCor = new Color (0, 0 ,cor.getBlue());
                imgSaida.setRGB(w, h, novaCor.getRGB()); //desenhando os pixels da imagem
            }
        }
        return imgSaida;
    }
    public static BufferedImage FiltroCinzaParaBandaB(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                Color novaCor = new Color (cor.getBlue(), cor.getBlue() ,cor.getBlue());
                imgSaida.setRGB(w, h, novaCor.getRGB()); //desenhando os pixels da imagem
            }
        }
        return imgSaida;
    }
    public static BufferedImage FiltroCinzaParaBandaR(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                Color novaCor = new Color (cor.getRed(), cor.getRed() ,cor.getRed());
                imgSaida.setRGB(w, h, novaCor.getRGB()); //desenhando os pixels da imagem
            }
        }
        return imgSaida;
    }
    public static BufferedImage FiltroCinzaParaBandaG(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                Color novaCor = new Color (cor.getGreen(), cor.getGreen() ,cor.getGreen());
                imgSaida.setRGB(w, h, novaCor.getRGB()); //desenhando os pixels da imagem
            }
        }
        return imgSaida;
    }
    public static BufferedImage FiltroCinzaParaMedia(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);


        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int red = cor.getRed();
                int media = (green+blue+red)/3;
                Color novaCor = new Color (media, media ,media);

                imgSaida.setRGB(w, h, novaCor.getRGB()); //desenhando os pixels da imagem
            }
        }
        return imgSaida;
    }
    public static BufferedImage FiltroLimiarizacao(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);

        BufferedImage imgnewSaida = FiltrosPontuais.FiltroCinzaParaMedia(imgEntrada);
        Color novaCor = new Color(0, 0 ,0);


        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgnewSaida.getRGB(w, h));
                if (cor.getRed() <170){
                    novaCor = new Color (255, 255 ,255);
                    System.out.println(cor.getBlue());
                    System.out.println(cor.getRed());
                    System.out.println("+=======================");

                }else{
                    novaCor = new Color (0, 0 ,0);

                }
                //desenhando os pixels da imagem
                imgnewSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgnewSaida;
    }

}