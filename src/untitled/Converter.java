package untitled;

import java.awt.*;
import java.awt.image.BufferedImage;
import untitled.aumentoTonalidade;

public class Converter {
    static BufferedImage rbgParaYIQ(BufferedImage img) {
        int Ycolor,Icolor,Qcolor;
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));

                int newgree =  cor.getGreen();
                int newblue = cor.getBlue();
                int newred =  cor.getRed();

                 Ycolor = (int)(0.299 * newred + 0.587 * newgree + 0.114 * newblue);
                 Icolor = (int)(0.596 * newred - 0.274 * newgree - 0.322 * newblue);
                 Qcolor = (int)(0.211 * newred - 0.523 * newgree + 0.312 * newblue);
                System.out.println(Ycolor+ "-y");
                System.out.println(Icolor+ "-i");
                System.out.println(Qcolor+ "-q");
                System.out.println("-------------------------------");
                Ycolor = aumentoTonalidade.validarCor(Ycolor);
                Icolor =aumentoTonalidade.validarCor(Icolor);
                Qcolor = aumentoTonalidade.validarCor(Qcolor);


                Color novaCor = new Color(Ycolor, Icolor ,Qcolor);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }
    static double[][][] rbgParaYIQmatriz(BufferedImage img) {
        int Ycolor,Icolor,Qcolor;
        int width = img.getWidth();
        int height = img.getHeight();
        double matriz[][][] = new double[width][height][3];
        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));

                int newgree =  cor.getGreen();
                int newblue = cor.getBlue();
                int newred =  cor.getRed();

                Ycolor = (int)(0.299 * newred + 0.587 * newgree + 0.114 * newblue);
                Icolor = (int)(0.596 * newred - 0.274 * newgree - 0.322 * newblue);
                Qcolor = (int)(0.211 * newred - 0.523 * newgree + 0.312 * newblue);
                System.out.println(Ycolor+ "-y");
                System.out.println(Icolor+ "-i");
                System.out.println(matriz[w][h][0]+ "-q");
                System.out.println("-------------------------------");



                matriz[w][h][0] = Ycolor;
                matriz[w][h][1] = Icolor;
                matriz[w][h][2] = Qcolor;
            }
        }

        return matriz;
    }
    static BufferedImage negativoY( BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            double[][][] matriz = rbgParaYIQmatriz(img);

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j][0] = 255 - matriz[i][j][0];

                }
            }
            BufferedImage img2Saida =  converterRGB(matriz, imgSaida);

        return img2Saida;
    }
    static BufferedImage converterRGB(double[][][] matrizYIQ ,BufferedImage img) {

        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {



                    int r = (int) (1 * matrizYIQ[i][j][0] + 0.956 * matrizYIQ[i][j][1] + 0.621 * matrizYIQ[i][j][2]);
                    int g = (int) (1 * matrizYIQ[i][j][0] - 0.272 * matrizYIQ[i][j][1] - 0.647 * matrizYIQ[i][j][2]);
                    int b = (int) (1 * matrizYIQ[i][j][0] - 1.106 * matrizYIQ[i][j][1] + 1.703 * matrizYIQ[i][j][2]);

                    //Red
                    int resultBlue = aumentoTonalidade.validarCor(r);
                    int resultnewGreen = aumentoTonalidade.validarCor(g);
                    int resultnewRed = aumentoTonalidade.validarCor(b);
                    Color color = new Color(resultBlue, resultnewGreen, resultnewRed);
                    imgSaida.setRGB(i, j, color.getRGB());

                }
            }

        return imgSaida;
    }
}

