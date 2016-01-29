package img_final1;

import java.awt.AWTException;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Img_Final1
{
  public static void main(String[] args)
    throws AWTException
  {
    try
    {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
    }
    catch (ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException localClassNotFoundException1)
    {
    }
    Frame f1 = new Frame();
  }
}