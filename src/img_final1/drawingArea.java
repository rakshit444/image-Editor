package img_final1;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class drawingArea extends Canvas
  implements MouseListener, KeyListener, MouseMotionListener
{
  Image img;
  MediaTracker mt;
  BufferedImage bimg1;
  BufferedImage bimg2;
  BufferedImage bi3;
  boolean imgLoaded;
  boolean imgRotated;
  boolean imgResized;
  boolean imgCrop;
  boolean imgBrightness;
  boolean imgBlack_White;
  boolean imgSharpen;
  boolean imgZoom;
  boolean imgaddText;
  boolean imgBlurr;
  boolean imgGrayScale;
  boolean undo;
  boolean redo;
  boolean clip;
  boolean imgDragged;
  boolean saveAs;
  boolean save;
  boolean rect;
  boolean line;
  boolean circle;
  boolean roundRect;
  boolean oval;
  boolean rect1;
  boolean line1;
  boolean circle1;
  boolean roundRect1;
  boolean oval1;
  boolean edge;
  boolean imgDragged1;
  boolean imgclip;
  boolean c;
  boolean d1;
  boolean drag;
  boolean point;
  boolean point1;
  Dimension d;
  int midx;
  int midy;
  int x;
  int y;
  int x2;
  int y2;
  int x3;
  int y3;
  int x4;
  int y4;
  int x5 = 0;
  int y5 = 0;
  int x6;
  int y6;
  int x7;
  int y7;
  int xp;
  int yp;
  int w1;
  int h1;
  int al;
  int ah;
  double r;
  private Shape s1;
  private Shape s2;
  private Shape s3;
  private Shape s4;
  Robot robot;
  int[] a = new int[3];
  float v;
  String font;
  String text;
  Color colorText;
  Color color1;
  Rectangle rect2;
  int fontSize;

  public drawingArea()
  {
    addMouseListener(this);
    addKeyListener(this);
    addMouseMotionListener(this);
    try {
      this.robot = new Robot();
    } catch (AWTException ex) {
      Logger.getLogger(drawingArea.class.getName()).log(Level.SEVERE, null, ex);
    }
    this.d = Toolkit.getDefaultToolkit().getScreenSize();
    this.midx = ((int)(this.d.getWidth() / 2.0D));
    this.midy = ((int)(this.d.getHeight() / 2.0D));
  }

  public void mouseDragged(MouseEvent e)
  {
    if (this.imgDragged) {
      this.x5 = (e.getX() - this.x);
      this.y5 = (e.getY() - this.y);

      imgDragging();
    }

    if (this.imgCrop) {
      this.imgDragged1 = true;
    }
    if ((this.rect) || (this.line) || (this.circle) || (this.oval) || (this.roundRect) || (this.imgCrop)) {
      this.x6 = (e.getX() - this.x);
      this.y6 = (e.getY() - this.y);
      this.r = Math.sqrt((this.x7 - this.x6) * (this.x7 - this.x6) + (this.y7 - this.y6) * (this.y7 - this.y6));
    }

    if (this.point) {
      this.x6 = (e.getX() - this.x);
      this.y6 = (e.getY() - this.y);
      point();
    }
    if (this.line) {
      line();
    }
    if ((this.rect) || (this.circle) || (this.oval) || (this.roundRect) || (this.imgCrop))
      if (((this.x6 > this.x7 ? 1 : 0) & (this.y6 > this.y7 ? 1 : 0)) != 0) {
        this.xp = this.x7;
        this.yp = this.y7;
        this.w1 = (this.x6 - this.x7);
        this.h1 = (this.y6 - this.y7);
        if (this.rect) {
          Rectangle();
        }
        else if (this.oval) {
          oval();
        }
        else if (this.roundRect)
          roundRect1();
        else if (this.imgCrop) {
          endPoint(2, 2);
        }
        if (this.circle) {
          circle();
        }
      }
      else if (((this.x6 < this.x7 ? 1 : 0) & (this.y6 < this.y7 ? 1 : 0)) != 0) {
        this.xp = this.x6;
        this.yp = this.y6;
        this.w1 = (this.x7 - this.x6);
        this.h1 = (this.y7 - this.y6);

        if (this.rect) {
          Rectangle();
        }
        else if (this.oval) {
          oval();
        }
        else if (this.roundRect)
          roundRect1();
        else if (this.imgCrop) {
          endPoint(2, 2);
        }
        if (this.circle) {
          circle();
        }
      }
      else if (((this.x6 > this.x7 ? 1 : 0) & (this.y6 < this.y7 ? 1 : 0)) != 0) {
        this.xp = this.x7;
        this.yp = this.y6;
        this.w1 = (this.x6 - this.x7);
        this.h1 = (this.y7 - this.y6);
        if (this.rect) {
          Rectangle();
        }
        else if (this.oval) {
          oval();
        }
        else if (this.roundRect)
          roundRect1();
        else if (this.imgCrop) {
          endPoint(2, 2);
        }
        if (this.circle) {
          circle();
        }
      }
      else if (((this.x6 < this.x7 ? 1 : 0) & (this.y6 > this.y7 ? 1 : 0)) != 0) {
        this.xp = this.x6;
        this.yp = this.y7;
        this.w1 = (this.x7 - this.x6);
        this.h1 = (this.y6 - this.y7);
        if (this.rect) {
          Rectangle();
        }
        else if (this.oval) {
          oval();
        }
        else if (this.roundRect)
          roundRect1();
        else if (this.imgCrop) {
          endPoint(2, 2);
        }
        if (this.circle)
          circle();
      }
  }

  public void mouseClicked(MouseEvent e)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void mousePressed(MouseEvent e)
  {
    if ((this.imgCrop) || (this.rect) || (this.line) || (this.circle) || (this.oval) || (this.roundRect)) {
      this.x7 = (e.getX() - this.x);
      this.y7 = (e.getY() - this.y);
      startPoint(this.x7, this.y7);
    }

    if (this.imgaddText) {
      puttingTextToImage(e.getX() - this.x, e.getY() - this.y, Image_Stack.getImage());
    }

    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void mouseReleased(MouseEvent e)
  {
    this.drag = false;
    if (this.imgCrop) {
      this.imgDragged1 = false;
      this.imgCrop = false;
      endPoint(e.getX() - this.x, e.getY() - this.y);
    }
    if (this.rect) {
      this.rect = false;
      Rectangle();
    }
    if (this.line) {
      this.line = false;
      line();
    }
    if (this.oval) {
      this.oval = false;
      oval();
    }
    if (this.roundRect) {
      this.roundRect = false;
      roundRect1();
    }
    if (this.circle) {
      this.circle = false;
      circle();
    }

    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void mouseEntered(MouseEvent e)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void mouseExited(MouseEvent e)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void keyTyped(KeyEvent e)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void keyPressed(KeyEvent e)
  {
    if (this.imgaddText == true) {
      if (e.getKeyCode() == 27) {
        this.imgaddText = false;
        this.text = "";
        this.font = "";
        this.fontSize = 0;
      }

      throw new UnsupportedOperationException("Not supported yet.");
    }
  }

  public void keyReleased(KeyEvent e) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  public void imgDragging() {
    BufferedImage bi1 = new BufferedImage(Image_Stack.getImage().getWidth(), Image_Stack.getImage().getHeight(), 2);
    Graphics2D gi = bi1.createGraphics();
    gi.drawImage(Image_Stack.getImage(), 0, 0, null);
    Image_Stack.putImage(bi1);
    gi.dispose();
    repaint();
  }

  public void Rectangle()
  {
    this.s1 = new Rectangle2D.Double(this.xp, this.yp, this.w1, this.h1);
    BufferedImage bi = new BufferedImage(this.bi3.getWidth(), this.bi3.getHeight(), 2);
    Graphics2D g = bi.createGraphics();
    g.drawImage(this.bi3, 0, 0, null);
    g.setColor(this.color1);
    g.draw(this.s1);

    Image_Stack.putImage(bi);
    g.dispose();
    repaint();
  }

  public void fill() {
    BufferedImage bi = new BufferedImage(this.bi3.getWidth(), this.bi3.getHeight(), 2);
    Graphics2D g = bi.createGraphics();
    g.drawImage(this.bi3, 0, 0, null);
    g.setColor(this.color1);
    g.fill(this.s1);
    Image_Stack.putImage(bi);
    g.dispose();
    repaint();
  }
  public void line() {
    this.s1 = new Line2D.Double(this.x7, this.y7, this.x6, this.y6);
    BufferedImage bi = new BufferedImage(this.bi3.getWidth(), this.bi3.getHeight(), 2);
    Graphics2D g = bi.createGraphics();
    g.drawImage(this.bi3, 0, 0, null);
    g.setColor(this.color1);
    g.draw(this.s1);
    Image_Stack.putImage(bi);
    g.dispose();
    repaint();
  }
  public void point() {
    this.s1 = ((Shape)new Point2D.Double(this.x6, this.y6));
    BufferedImage bi = new BufferedImage(this.bi3.getWidth(), this.bi3.getHeight(), 2);
    Graphics2D g = bi.createGraphics();
    g.drawImage(this.bi3, 0, 0, null);
    g.drawOval(this.x6, this.y6, this.midx, this.midx);
    g.draw(this.s1);
    Image_Stack.putImage(bi);
    g.dispose();
    repaint();
  }

  public void oval() {
    this.s1 = new Ellipse2D.Double(this.xp, this.yp, this.w1, this.h1);
    BufferedImage bi = new BufferedImage(this.bi3.getWidth(), this.bi3.getHeight(), 2);
    Graphics2D g = bi.createGraphics();
    g.drawImage(this.bi3, 0, 0, null);
    g.setColor(this.color1);
    g.draw(this.s1);
    Image_Stack.putImage(bi);
    g.dispose();
    repaint();
  }
  public void circle() {
    this.s1 = new Ellipse2D.Double(this.xp, this.yp, this.r, this.r);
    BufferedImage bi = new BufferedImage(this.bi3.getWidth(), this.bi3.getHeight(), 2);
    Graphics2D g = bi.createGraphics();
    g.drawImage(this.bi3, 0, 0, null);
    g.setColor(this.color1);
    g.draw(this.s1);
    Image_Stack.putImage(bi);
    g.dispose();
    repaint();
  }
  public void roundRect1() {
    this.s1 = new RoundRectangle2D.Double(this.xp, this.yp, this.w1, this.h1, 7.0D, 7.0D);
    BufferedImage bi = new BufferedImage(this.bi3.getWidth(), this.bi3.getHeight(), 2);
    Graphics2D g = (Graphics2D)bi.getGraphics();
    g.drawImage(this.bi3, 0, 0, null);
    g.setColor(this.color1);
    g.draw(this.s1);
    Image_Stack.putImage(bi);
    g.dispose();
    repaint();
  }

  public void paint(Graphics g)
  {
    Graphics2D g2D = (Graphics2D)g;
    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    if (this.imgLoaded)
    {
      if ((this.edge) || (this.point1) || (this.point) || (this.d1) || (this.c) || (this.imgclip) || (this.roundRect1) || (this.circle1) || (this.line1) || (this.rect1) || (this.roundRect) || (this.oval1) || (this.oval) || (this.circle) || (this.line) || (this.rect) || (this.imgDragged) || (this.clip) || (this.redo) || (this.undo) || (this.imgRotated) || (this.imgResized) || (this.imgZoom) || (this.imgCrop) || (this.imgBlack_White) || (this.imgGrayScale) || (this.imgBlurr) || (this.imgSharpen) || (this.imgBrightness) || (this.imgaddText)) {
        this.x = (this.midx - Image_Stack.getImage().getWidth() / 2);
        this.y = (this.midy - Image_Stack.getImage().getHeight() / 2);
        g2D.translate(this.x, this.y);
        g2D.drawImage(Image_Stack.getImage(), this.x5, this.y5, null);
        if ((this.circle) || (this.rect) || (this.line) || (this.roundRect) || (this.oval) || (this.imgDragged1)) {
          Image_Stack.deleteImage();
        }

        g2D.dispose();
      }
      else {
        this.x = (this.midx - this.bimg1.getWidth() / 2);
        this.y = (this.midy - this.bimg1.getHeight() / 2);
        g2D.translate(this.x, this.y);
        g2D.drawImage(this.bimg1, this.x5, this.y5, null);
        if ((this.rect) || (this.line) || (this.circle) || (this.oval) || (this.roundRect) || (this.imgDragged1)) {
          Image_Stack.deleteImage();
        }
        g2D.dispose();
      }
    }
  }

  public void setText(String text1, String font1, int size, Color color1)
  {
    this.font = font1;
    this.text = text1;
    this.fontSize = size;
    if (color1 == null)
      color1 = new Color(0, 0, 0);
    else
      this.colorText = color1; 
  }

  public void puttingTextToImage(int x1, int y1, BufferedImage image1) { this.x2 = x1;
    this.y2 = y1;
    BufferedImage bi1 = new BufferedImage(image1.getWidth(), image1.getHeight(), 2);
    Graphics2D g1 = bi1.createGraphics();
    g1.setFont(new Font(this.font, 1, this.fontSize));
    g1.setPaint(this.colorText);
    g1.drawImage(image1, 0, 0, null);
    g1.drawString(this.text, x1, y1);
    Image_Stack.putImage(bi1);
    g1.dispose();
    repaint();
  }

  public void startPoint(int startX, int startY)
  {
    this.x3 = startX;
    this.y3 = startY;
  }

  public void endPoint(int endX, int endY) {
    this.x4 = endX;
    this.y4 = endY;
    this.rect2 = new Rectangle(this.x7, this.y7, this.x6, this.y6);

    BufferedImage bi2 = new BufferedImage(this.bi3.getWidth(), this.bi3.getHeight(), 2);
    BufferedImage bi4 = cropImg(bi2, this.rect2);
    Graphics2D g = bi2.createGraphics();
    if (!this.imgDragged1)
    {
      g.clipRect(this.xp, this.yp, this.w1, this.h1);
    }

    g.drawImage(this.bi3, 0, 0, null);
    float[] dash1 = { 10.0F };
    BasicStroke dashed = new BasicStroke(1.0F, 0, 0, 10.0F, dash1, 0.0F);

    g.setStroke(dashed);
    if (this.imgDragged1) {
      g.drawRect(this.xp, this.yp, this.w1, this.h1);
      Image_Stack.putImage(bi2);
    }
    else {
      Image_Stack.putImage(bi4);
    }g.dispose();
    repaint();
  }

  private BufferedImage cropImg(BufferedImage src, Rectangle rect) {
    BufferedImage dest = src.getSubimage(0, 0, rect.width, rect.height);
    return dest;
  }

  public void sharpen()
  {
    float[] sharp = { 0.0F, -1.0F, 0.0F, -1.0F, 5.0F, -1.0F, 0.0F, -1.0F, 0.0F };

    BufferedImageOp y = new ConvolveOp(new Kernel(3, 3, sharp), 1, null);
    BufferedImage bi3 = new BufferedImage(this.bimg1.getWidth(), this.bimg1.getHeight(), 2);
    y.filter(this.bimg1, bi3);
    Image_Stack.putImage(bi3);
    this.imgSharpen = true;
    repaint();
  }

  public void edge_detection()
  {
    float[] sharp = { 0.0F, -1.0F, 0.0F, -1.0F, 4.0F, -1.0F, 0.0F, -1.0F, 0.0F };

    BufferedImageOp y = new ConvolveOp(new Kernel(3, 3, sharp), 1, null);
    BufferedImage bi3 = new BufferedImage(this.bimg1.getWidth(), this.bimg1.getHeight(), 1);
    y.filter(this.bimg1, bi3);
    Image_Stack.putImage(bi3);
    this.imgSharpen = true;
    repaint();
  }

  public void blurring()
  {
    float[] blurr = { 0.1111111F, 0.1111111F, 0.1111111F, 0.1111111F, 0.1111111F, 0.1111111F, 0.1111111F, 0.1111111F, 0.1111111F };

    BufferedImageOp y = new ConvolveOp(new Kernel(3, 3, blurr), 1, null);
    BufferedImage bi1 = new BufferedImage(this.bimg1.getWidth(), this.bimg1.getHeight(), 2);
    y.filter(this.bimg1, bi1);
    Image_Stack.putImage(bi1);
    this.imgBlurr = true;
    repaint();
  }

  public void filter()
  {
    float[] ImageBrightness1 = { 0.0F, 1.0F, 0.0F, -1.0F, this.v, 1.0F, 0.0F, 0.0F, 0.0F };
    BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, ImageBrightness1), 1, null);
    BufferedImage bi = new BufferedImage(this.bimg1.getWidth(), this.bimg1.getHeight(), 2);
    op.filter(this.bimg1, bi);
    Image_Stack.putImage(bi);
  }

  public void makeImageGray()
  {
    BufferedImage bi1 = Image_Stack.getImage();
    BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(), 10);
    Graphics2D g = bi2.createGraphics();
    g.drawImage(this.bimg1, 0, 0, null);
    g.dispose();
    Image_Stack.putImage(bi2);
    this.imgGrayScale = true;
    repaint();
  }

  public void blackNDwhite()
  {
    BufferedImage bi1 = Image_Stack.getImage();
    BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(), 12);
    Graphics2D g = bi2.createGraphics();
    g.drawImage(bi1, 0, 0, null);
    g.dispose();
    Image_Stack.putImage(bi2);
    this.imgBlack_White = true;
    repaint();
  }

  public void makeImageRightRotate()
  {
    BufferedImage bi1 = Image_Stack.getImage();
    BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(), 2);
    Graphics2D g = bi2.createGraphics();
    double degree = 90.0D;
    g.rotate(Math.toRadians(degree), bi1.getWidth() / 2, bi1.getHeight() / 2);
    g.drawImage(bi1, 0, 0, null);
    g.dispose();
    Image_Stack.putImage(bi2);
    this.imgRotated = true;
    repaint();
  }

  public void zoom()
  {
    BufferedImage before = Image_Stack.getImage();
    int newW = 2 * before.getWidth();
    int newH = 2 * before.getHeight();
    BufferedImage after = new BufferedImage(newW, newH, 2);
    Graphics2D g2d = after.createGraphics();
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2d.drawImage(before, 0, 0, newW, newH, 0, 0, before.getWidth(), before.getHeight(), this);
    g2d.dispose();
    Image_Stack.putImage(after);
    this.imgZoom = true;
    repaint();
  }

  public void resize(int newW, int newH)
  {
    BufferedImage before = Image_Stack.getImage();
    int w = before.getWidth();
    int h = before.getHeight();
    BufferedImage after = new BufferedImage(newW, newH, 2);
    Graphics2D g2d = after.createGraphics();
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2d.drawImage(before, 0, 0, newW, newH, 0, 0, w, h, this);
    g2d.dispose();
    Image_Stack.putImage(after);
    this.imgResized = true;
    repaint();
  }

  public void makeImageLeftRotate()
  {
    BufferedImage bi1 = Image_Stack.getImage();

    BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(), 2);
    Graphics2D g = bi2.createGraphics();
    double degree = -90.0D;
    g.rotate(Math.toRadians(degree), bi1.getWidth() / 2, bi1.getHeight() / 2);
    g.drawImage(bi1, 0, 0, null);
    g.dispose();
    Image_Stack.putImage(bi2);
    this.imgRotated = true;
    repaint();
  }

  public void save(String file)
    throws IOException
  {
    String fext = file.substring(file.lastIndexOf('.') + 1);
    if ((this.imgclip) || (this.imgRotated) || (this.imgResized) || (this.imgZoom) || (this.imgCrop) || (this.imgBlack_White) || (this.imgGrayScale) || (this.imgBlurr) || (this.imgSharpen) || (this.imgBrightness) || (this.imgaddText))
    {
      ImageIO.write(Image_Stack.getImage(), fext, new File(file));
      System.out.println("file not found");
    }
  }

  public void openingImage(String name)
  {
    this.mt = new MediaTracker(this);
    this.img = Toolkit.getDefaultToolkit().getImage(name);
    this.mt.addImage(this.img, 0);
    try {
      this.mt.waitForID(0);
    } catch (InterruptedException ex) {
      Logger.getLogger(drawingArea.class.getName()).log(Level.SEVERE, null, ex);
    }
    int w2 = this.img.getWidth(null);
    int h2 = this.img.getHeight(null);
    this.bimg1 = new BufferedImage(w2, h2, 2);
    Graphics2D g1 = this.bimg1.createGraphics();
    g1.drawImage(this.img, 0, 0, null);
    g1.dispose();
    this.bimg2 = new BufferedImage(w2, h2, 2);
    Image_Stack.putImage(this.bimg1);
    this.imgLoaded = true;
  }

  public void intialize()
  {
    this.undo = false;
    this.redo = false;
    this.imgLoaded = false;
    this.imgRotated = false;
    this.imgResized = false;
    this.imgZoom = false;
    this.imgCrop = false;
    this.imgBlack_White = false;
    this.imgGrayScale = false;
    this.imgBlurr = false;
    this.imgSharpen = false;
    this.imgBrightness = false;
    this.imgaddText = false;
    this.clip = false;
    this.imgDragged = false;
    this.saveAs = false;
    this.save = false;
    this.rect = false;
    this.line = false;
    this.circle = false;
    this.oval = false;
    this.roundRect = false;
    this.imgDragged = false;
    this.imgDragged1 = false;
    this.rect1 = false;
    this.roundRect1 = false;
    this.oval1 = false;
    this.line1 = false;
    this.imgclip = false;
    this.c = false;
    this.d1 = false;
    this.drag = false;
    this.point = false;
    this.point1 = false;
    this.edge = false;
  }

  public void mouseMoved(MouseEvent e)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}