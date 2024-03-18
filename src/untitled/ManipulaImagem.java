package untitled;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ManipulaImagem {
    public static BufferedImage abrirImagem(String path)  {
        try {
            return ImageIO.read(new File(path));
        } catch(IOException e) {
            System.out.println("Erro ao carregar imagem.");
            throw new RuntimeException(e);
        }
    }

    public static void exibirImagem(BufferedImage... imagens) {
        JFrame jframe = new JFrame("Processamento de imagens");
        jframe.getContentPane().setLayout(new FlowLayout());
        for(BufferedImage img : imagens) {
            JLabel jlabel = new JLabel(new ImageIcon(img));
            jframe.getContentPane().add(jlabel);
        }

        jframe.pack();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void salvarImagem(BufferedImage imagem, String formato, String path) {
        try {
            ImageIO.write(imagem, formato, new File(path));
        } catch (IOException e) {
            System.out.println("Erro a salvar imagem.");
            throw new RuntimeException(e);
        }
    }
}
