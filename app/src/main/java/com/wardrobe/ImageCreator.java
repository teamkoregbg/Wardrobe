package com.wardrobe;


import java.io.File;
import java.io.IOException;

/**
 * Created by Jonathan Köre on 2018-03-26.
 */

public class ImageCreator {

    static File createImageFile(File storageDir, String fileName) throws IOException {
        // Create an image file name
        String imageFileName = "JPEG_" + fileName + "_";
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        return image;
    }
}
