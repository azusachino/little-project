package cn.az.project.muxin.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Map;

/**
 * @author az
 * @date 2020/4/10
 */
@Slf4j
public class QrCodeUtil {

    private QrCodeUtil() {
    }

    private static final String FORMAT_PNG = ".png";

    public static void createQrCode(String filePath, String content) {
        final int width = 300, height = 300;
        Map<EncodeHintType, Object> map =
                Map.of(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8,
                        EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M,
                        EncodeHintType.MARGIN, 2);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, map);
            Path path = new File(filePath).toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, FORMAT_PNG, path);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    public String getContentFromQrCode(@NonNull String filePath) {
        MultiFormatReader formatReader = new MultiFormatReader();
        File file = new File(filePath);
        BufferedImage bufferedImage;

        try {
            bufferedImage = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
            Map<DecodeHintType,?> map = Map.of(DecodeHintType.CHARACTER_SET, StandardCharsets.UTF_8);
            return formatReader.decode(binaryBitmap, map).toString();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
    }
}
