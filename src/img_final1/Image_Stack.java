package img_final1;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Image_Stack
{
  public static ArrayList<BufferedImage> images = new ArrayList();
  public static ArrayList<BufferedImage> images2 = new ArrayList();

  public static BufferedImage getImage()
  {
    int count = images.size();
    if (count > 0) {
      return (BufferedImage)images.get(count - 1);
    }

    return null;
  }

  public static void putImage(BufferedImage b) {
    images.add(b);
  }
  public static void deleteImage() {
    int count = images.size();
    if (count > 1) {
      BufferedImage bi4 = (BufferedImage)images.remove(count - 1);
      images2.add(bi4);
    }
  }

  public static void redo() { int i = images2.size();
    images.add(images2.get(i - 1)); }

  public static void clear() {
    images.clear();
  }
}