package untitled;

import java.awt.*;
import java.awt.image.BufferedImage;
import untitled.FiltrosPontuais;
import untitled.aumentoTonalidade;
import untitled.Converter;

public class Main {
    public static void main(String[] args)  {
        BufferedImage imagem = ManipulaImagem.abrirImagem("image.jpg");

        ManipulaImagem.exibirImagem(imagem,aumentoTonalidade.mudarY(imagem,50) );

        ManipulaImagem.salvarImagem(imagem, "jpg", "img.png");
    }

    private static BufferedImage filtroNegativo(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int h = 0; h < height; h++) {
            for(int w = 0; w < width; w++) {
                Color cor = new Color(img.getRGB(w, h));
                Color novaCor = new Color(255 - cor.getRed(), 255 - cor.getGreen() ,255 - cor.getBlue());
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imgSaida;
    }
}