package ru.netology.graphics.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.File;
import java.net.URL;

public class TextGraphicsConverterImpl{
    /**
     * Конвертация изображения, переданного как урл, в текстовую графику.
     *
     * @param url урл изображения
     * @return текст, представляющий собой текстовую графику переданного изображения
     * @throws IOException
     * @throws BadImageSizeException Если соотношение сторон изображения слишком большое
     */
    public String convert(String url) throws IOException, BadImageSizeException {
        //скачиваем картинку из интернета
        BufferedImage img = ImageIO.read(new URL(url));
        int Width = img.getWidth();
        int Height = img.getHeight();
        int newWidth = Width;
        int newHeight = Height;
        Image scaledImage = img.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH);
        BufferedImage bwImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D graphics = bwImg.createGraphics();
        graphics.drawImage(scaledImage, 0, 0, null);
        //ImageIO.write(bwImg, "png", new File("out.png"));
        WritableRaster bwRaster = bwImg.getRaster();
        //int color = bwRaster.getPixel(w, h, new int[3])[0];
        TextColorSchemaImpl schema = new TextColorSchemaImpl();
        char[][] tmp = new char[newHeight][newWidth];
        for (int h = 0; h < newHeight; h++) {
            for (int w = 0; w < Width; w++) {
                int color = bwRaster.getPixel(w, h, new int[3])[0];
                char c = schema.convert(color);
                tmp[h][w] = c;
            }
        }

        for (int h = 0; h < newHeight; h++) {
            for (int w = 0; w < Width; w++) {
                System.out.print(tmp[h][w]);
            }
            System.out.println("");
        }

       // Image scaledImage = img.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH);
       // BufferedImage bwImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
       // Graphics2D graphics = bwImg.createGraphics();
       // graphics.drawImage(scaledImage, 0, 0, null);
        // вас моменте сохранив промежуточную картинку в файл через:
        //ImageIO.write(imageObject, "png", new File("out.png"));

       // WritableRaster bwRaster = bwImg.getRaster();
        return "text image";
    }

}

