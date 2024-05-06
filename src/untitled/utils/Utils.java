package untitled.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Utils {
    public static int validaLimitesRGB(int banda, int valor) {
        banda += valor;
        if (banda > 255) banda = 255;
        else if (banda < 0) banda = 0;
        return banda;
    }

    public static int validaLimitesRGB(int banda, float valor) {
        float resultado = banda * valor;
        if (resultado > 255) resultado = 255;
        else if (resultado < 0) resultado = 0;
        return (int) resultado;
    }
    public static boolean validatamlhomatriz(int valor) {
        return valor % 2 != 0;
    }

    public static BufferedImage criarImagemVazia(BufferedImage img) {
        return new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
    }

    public static boolean verificaPixelBordas(int h, int w, int height, int width,int tamlholimte) {
        return h < tamlholimte || w < tamlholimte || h >= height - tamlholimte || w >= width - tamlholimte;
    }

    public static int[] obterVizinhanca(BufferedImage imagemEntrada, int w, int h,int tamKernel) {

        if (!validatamlhomatriz(tamKernel)) {
            throw new IllegalArgumentException("O tamanho do kernel deve ser um número ímpar entre 3, 5, 7 ...");
        }

        int[] vizinhanca = new int[tamKernel*tamKernel];
        int count = 0;
        int metadeKernel = tamKernel / 2;

        for (int i = -metadeKernel; i <= metadeKernel; i++) {
            for (int j = -metadeKernel; j <= metadeKernel; j++) {

                Color cor = new Color(imagemEntrada.getRGB(w + j, h + i));
                int valorPixel = cor.getRed();
                vizinhanca[count++] = valorPixel;
            }
        }
        return vizinhanca;
    }
    public static int[] obterVizinhanca(BufferedImage imagemEntrada, int w, int h,int[] Kernel,int tamKernel) {



        int[] vizinhanca = new int[tamKernel*tamKernel];
        int count = 0;
        int metadeKernel = tamKernel / 2;

        for (int i = -metadeKernel; i <= metadeKernel; i++) {
            for (int j = -metadeKernel; j <= metadeKernel; j++) {

                Color cor = new Color(imagemEntrada.getRGB(w + j, h + i));
                int valorPixel = cor.getRed();
                int peso = Kernel[count]; // Peso correspondente ao valor atual do kernel
                vizinhanca[count] = validaLimitesRGB(valorPixel,peso);
                count++;
            }
        }
        return vizinhanca;
    }
}