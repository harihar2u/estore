package com.online.estore.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mediaType;

    @NonNull
    @Lob
    @Column(name = "bytes", columnDefinition = "BLOB")
    private byte[] bytes;

    public Image(String filename) {
        getImageAsBytes(filename);
    }

    @Transient
    public byte[] getImageAsBytes(String filename) {
        try {
            // InputStream for the image.
            File file = new File(filename);
            BufferedImage image = ImageIO.read(file);
            mediaType = new MimetypesFileTypeMap().getContentType(file);
            String format = mediaType.substring(mediaType.indexOf("/") + 1);
            //Write the image to the OutputStream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, format, baos);
            baos.flush();
            //Initialise the byte array object with the image that was written to the OutputStream
            bytes = baos.toByteArray();
            baos.close();

            return bytes;
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
        }
        return null;
    }

    @Transient
    public String encodeBase64String(byte[] imageInByte) {
      return  null;
    }

    @Transient
    public String encodeBase64String() {
        return encodeBase64String(bytes);
    }

}
