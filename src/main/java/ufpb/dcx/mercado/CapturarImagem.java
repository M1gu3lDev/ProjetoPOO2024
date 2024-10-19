package ufpb.dcx.mercado;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;

public class CapturarImagem {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);  // Carrega a biblioteca nativa do OpenCV
    }

    public static String capturarImagemDaCamera(String caminhoArquivo) {
        VideoCapture camera = new VideoCapture(0);  // 0 significa a câmera padrão

        if (!camera.isOpened()) {
            System.out.println("Erro ao acessar a câmera!");
            return null;
        }

        Mat frame = new Mat();
        if (camera.read(frame)) {
            Imgcodecs.imwrite(caminhoArquivo, frame);  // Salva a imagem capturada
            System.out.println("Imagem capturada!");
        } else {
            System.out.println("Falha ao capturar imagem.");
        }

        camera.release();  // Libera a câmera após a captura
        return caminhoArquivo;
    }
}
