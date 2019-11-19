package com.back.whp.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import static com.back.whp.constants.DataConstants.IMG_PATH;
import static com.back.whp.constants.DataConstants.ROUTER_PATH;

public class QrCode {
    private static final QRCodeWriter QR_CODE_WRITER = new QRCodeWriter();

    /**
     * 生成二维码字节数组.
     */
    private static byte[] generateQrCode(String text, String format, int width, int height) {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            BitMatrix bitMatrix = QR_CODE_WRITER.encode(text, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToStream(bitMatrix, format, os);
            return os.toByteArray();
        } catch (WriterException e) {
            throw new RuntimeException(String.format("fail to generate qr code:text[%s]", text), e);
        } catch (IOException e) {
            throw new RuntimeException(String.format("fail to writeToStream when generating qr code: text[%s]", text), e);
        }
    }

    /**
     * 保存二维码图片到文件系统.
     */
    private static void generateQrCodeAndSave(String text, String format, int width, int height, String path) {
        try {
            BitMatrix bitMatrix = QR_CODE_WRITER.encode(text, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToPath(bitMatrix, format, Paths.get(path));
        } catch (WriterException e) {
            throw new RuntimeException(String.format("fail to generate qr code:text[%s]", text), e);
        } catch (IOException e) {
            throw new RuntimeException(String.format("fail to writeToStream when generating qr code: text[%s]", text), e);
        }
    }

    public static String generateQrCode(String text) {
        generateQrCodeAndSave(text, "png", 350, 350, IMG_PATH + text + ".png");

        return ROUTER_PATH + text + ".png";
    }

//    public static void main(String[] args) {
//        generateQrCodeAndSave("This is my first QR Code", "png", 350, 350, "./MyQRCode.png");
//        generateQrCodeAndSave("This is my first QR Code", "png", 350, 350, "/Users/xiufeng/Desktop/二维码/MyQRCode.png");
//    }
}
