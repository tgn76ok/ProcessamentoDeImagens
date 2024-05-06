package untitled;

import untitled.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class OperacoesLocais {
    public static BufferedImage media(BufferedImage imagemEntrada, int tamKernel){
        int width = imagemEntrada.getWidth();
        int height = imagemEntrada.getHeight();
        BufferedImage imagemSaida = Utils.criarImagemVazia(imagemEntrada);
        if (!Utils.validatamlhomatriz(tamKernel)) {
            throw new IllegalArgumentException("O tamanho do kernel deve ser um número ímpar entre 3, 5, 7 ...");
        }
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (Utils.verificaPixelBordas(h, w, height, width,tamKernel/2)) {
                    int rgb = imagemEntrada.getRGB(w,h);
                    imagemSaida.setRGB(w,h,rgb);
                    continue;
                }

                int[] vizinhanca = Utils.obterVizinhanca(imagemEntrada, w, h,tamKernel);
                int media = Arrays.stream(vizinhanca).sum() / (tamKernel*tamKernel); //TODO
                Color novaCor = new Color(media, media, media);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }
    public static BufferedImage media(BufferedImage imagemEntrada, int[] Kernel){
        int width = imagemEntrada.getWidth();
        int height = imagemEntrada.getHeight();
        BufferedImage imagemSaida = Utils.criarImagemVazia(imagemEntrada);

        int tam = (int) Math.sqrt(Kernel.length);

        if (!Utils.validatamlhomatriz(tam)) {
            throw new IllegalArgumentException("O tamanho do kernel deve ser um número ímpar entre 3, 5, 7 ...");
        }
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (Utils.verificaPixelBordas(h, w, height, width,tam/2)) {
                    int rgb = imagemEntrada.getRGB(w,h);
                    imagemSaida.setRGB(w,h,rgb);
                    continue;
                }

                int[] vizinhanca = Utils.obterVizinhanca(imagemEntrada, w, h,Kernel, tam);
                int media = Arrays.stream(vizinhanca).sum() / (tam*tam); //TODO
                Color novaCor = new Color(media, media, media);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage mediana (BufferedImage imagemEntrada,int tamKernel){
        int width = imagemEntrada.getWidth();
        int height = imagemEntrada.getHeight();
        BufferedImage imagemSaida = Utils.criarImagemVazia(imagemEntrada);

        if (!Utils.validatamlhomatriz(tamKernel)) {
            throw new IllegalArgumentException("O tamanho do kernel deve ser um número ímpar entre 3, 5, 7 ...");
        }
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (Utils.verificaPixelBordas(h, w, height, width,tamKernel/2)) {
                    int rgb = imagemEntrada.getRGB(w,h);
                    imagemSaida.setRGB(w,h,rgb);

                    continue;
                }
                int[] vizinhanca = Utils.obterVizinhanca(imagemEntrada, w, h,tamKernel);
                Arrays.sort(vizinhanca);
                System.out.println(vizinhanca[0]);
                int mediana = vizinhanca[tamKernel/2]; //TODO

                Color novaCor = new Color(mediana, mediana, mediana);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage mediana (BufferedImage imagemEntrada,int[] Kernel){
        int width = imagemEntrada.getWidth();
        int height = imagemEntrada.getHeight();

        BufferedImage imagemSaida = Utils.criarImagemVazia(imagemEntrada);
        int tam = (int) Math.sqrt(Kernel.length);

        if (!Utils.validatamlhomatriz(tam)) {
            throw new IllegalArgumentException("O tamanho do kernel deve ser um número ímpar entre 3, 5, 7 ...");
        }

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (Utils.verificaPixelBordas(h, w, height, width,tam/2)) {
                    int rgb = imagemEntrada.getRGB(w,h);
                    imagemSaida.setRGB(w,h,rgb);

                    continue;
                }
                int[] vizinhanca = Utils.obterVizinhanca(imagemEntrada, w, h,Kernel,tam);
                Arrays.sort(vizinhanca);
                int mediana = vizinhanca[tam/2]; //TODO

                Color novaCor = new Color(mediana, mediana, mediana);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

}