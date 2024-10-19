package ufpb.dcx.mercado;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class LeitorCodigoDeBarras {

    public static String lerCodigoDeBarras(String caminhoImagem) {
        try {
            BufferedImage imagem = ImageIO.read(new File(caminhoImagem));
            LuminanceSource fonteLuminosa = new BufferedImageLuminanceSource(imagem);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(fonteLuminosa));

            Result resultado = new MultiFormatReader().decode(bitmap);
            return resultado.getText();  // Retorna o código de barras lido
        } catch (Exception e) {
            System.out.println("Erro ao ler código de barras: " + e.getMessage());
            return null;
        }
    }
}
