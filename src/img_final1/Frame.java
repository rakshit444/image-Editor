package img_final1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Frame extends JFrame
  implements ActionListener
{
  drawingArea da;
  JFileChooser jfc;
  JMenuBar mb;
  JMenu file;
  JMenu edit;
  JMenu filters;
  JMenu help;
  JMenuItem open;
  JMenuItem save;
  JMenuItem saveAs;
  JMenuItem exit;
  JMenuItem undo;
  JMenuItem redo;
  JMenuItem crop;
  JMenu rotation;
  JMenuItem zoom;
  JMenuItem edge;
  JMenuItem zoomIn;
  JMenuItem zoomOut;
  JMenuItem resize;
  JMenuItem addText;
  JMenuItem leftRotation;
  JMenuItem rightRotation;
  JMenuItem black_white;
  JMenuItem brightness;
  JMenuItem grayScale;
  JMenuItem blurr;
  JMenuItem sharpen;
  JMenuItem dragged;
  JMenuItem about;
  JButton open1;
  JButton save1;
  JButton undo1;
  JButton redo1;
  JButton crop1;
  JButton zoom1;
  JButton rect;
  JButton line;
  JButton circle;
  JButton roundRect;
  JButton oval;
  JButton brush;
  JButton pallet;
  String s1;

  Frame()
  {
    Container c = getContentPane();
    this.da = new drawingArea();

    c.add(this.da, "Center");

    JToolBar p = new JToolBar();
    this.open1 = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/open.png")).getScaledInstance(25, 25, 4)));
    this.open1.setToolTipText("Open Image");
    this.save1 = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/save.png")).getScaledInstance(25, 25, 4)));
    this.save1.setToolTipText("Save Image");
    this.undo1 = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/Undo.png")).getScaledInstance(25, 25, 4)));
    this.undo1.setToolTipText("Undo");
    this.redo1 = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/redo.png")).getScaledInstance(25, 25, 4)));
    this.redo1.setToolTipText("Redo");
    this.crop1 = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/crop.png")).getScaledInstance(25, 25, 4)));
    this.crop1.setToolTipText("Crop");
    this.zoom1 = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/zoom.png")).getScaledInstance(25, 25, 4)));
    p.add(this.open1);
    p.add(this.save1);
    p.addSeparator();
    p.add(this.undo1);
    p.add(this.redo1);
    p.addSeparator();
    p.add(this.crop1);
    p.add(this.zoom1);
    add(p, "North");
    p.setVisible(true);
    JToolBar jtb = new JToolBar(null, 1);
    this.rect = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/rectangle.png")).getScaledInstance(25, 25, 4)));
    this.rect.setToolTipText("Rectangle");
    this.line = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/line.png")).getScaledInstance(25, 25, 4)));
    this.line.setToolTipText("line");
    this.circle = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/circle.png")).getScaledInstance(25, 25, 4)));
    this.circle.setToolTipText("Circle");
    this.roundRect = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/roundrect.png")).getScaledInstance(25, 25, 4)));
    this.roundRect.setToolTipText("Round Rectangle");
    this.oval = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/ellipse.png")).getScaledInstance(25, 25, 4)));
    this.oval.setToolTipText("Oval");
    this.brush = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/bucket.png")).getScaledInstance(25, 25, 4)));
    this.brush.setToolTipText("Bucket fill");
    this.pallet = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img_final1/pics/palette.png")).getScaledInstance(25, 25, 4)));
    this.pallet.setToolTipText("Color Pallet");

    jtb.add(this.rect);
    jtb.add(this.line);
    jtb.add(this.circle);
    jtb.add(this.roundRect);
    jtb.add(this.oval);
    jtb.add(this.brush);
    jtb.add(this.pallet);
    add(jtb, "West");
    jtb.setVisible(true);
    this.file = new JMenu("File");
    this.edit = new JMenu("Edit");
    this.filters = new JMenu("Filters");
    this.help = new JMenu("Help");
    this.mb = new JMenuBar();
    this.open = new JMenuItem("Open");
    this.open.setMnemonic(79);
    this.file.add(this.open);
    this.save = new JMenuItem("Save");
    this.save.setMnemonic(83);
    this.file.add(this.save);
    this.saveAs = new JMenuItem("Save As");
    this.open.setMnemonic(65);
    this.file.add(this.saveAs);
    this.exit = new JMenuItem("Exit");
    this.exit.setMnemonic(88);
    this.file.add(this.exit);
    this.undo = new JMenuItem("Undo");
    this.undo.setMnemonic(85);
    this.edit.add(this.undo);
    this.redo = new JMenuItem("Redo");
    this.redo.setMnemonic(82);
    this.edit.add(this.redo);
    this.crop = new JMenuItem("Crop");
    this.crop.setMnemonic(67);
    this.edit.add(this.crop);

    this.rotation = new JMenu("Rotation");
    this.edit.add(this.rotation);
    this.leftRotation = new JMenuItem("Left Rotation");
    this.rotation.add(this.leftRotation);
    this.rightRotation = new JMenuItem("Right Rotation");
    this.rotation.add(this.rightRotation);
    this.zoom = new JMenuItem("Zoom");
    this.edit.add(this.zoom);
    this.resize = new JMenuItem("Resize");
    this.resize.setMnemonic(82);
    this.edit.add(this.resize);
    this.addText = new JMenuItem("Add Text");
    this.edit.add(this.addText);
    this.black_white = new JMenuItem("Black&White");
    this.filters.add(this.black_white);
    this.edge = new JMenuItem("Edge detection");
    this.filters.add(this.edge);
    this.sharpen = new JMenuItem("Sharpen");
    this.filters.add(this.sharpen);
    this.blurr = new JMenuItem("blurr");
    this.filters.add(this.blurr);
    this.grayScale = new JMenuItem("Gray Scale");
    this.filters.add(this.grayScale);
    this.brightness = new JMenuItem("Brightness");
    this.filters.add(this.brightness);
    this.about = new JMenuItem("About");
    this.help.add(this.about);
    this.mb.add(this.file);
    this.mb.add(this.edit);
    this.mb.add(this.filters);
    setJMenuBar(this.mb);
    this.open.addActionListener(this);
    this.open1.addActionListener(this);
    this.brightness.addActionListener(this);
    this.resize.addActionListener(this);
    this.rightRotation.addActionListener(this);
    this.leftRotation.addActionListener(this);
    this.undo1.addActionListener(this);
    this.redo1.addActionListener(this);
    this.addText.addActionListener(this);
    this.crop.addActionListener(this);
    this.undo.addActionListener(this);
    this.redo.addActionListener(this);
    this.sharpen.addActionListener(this);
    this.blurr.addActionListener(this);
    this.grayScale.addActionListener(this);
    this.black_white.addActionListener(this);
    this.zoom.addActionListener(this);
    this.about.addActionListener(this);
    this.crop1.addActionListener(this);
    this.zoom1.addActionListener(this);
    this.saveAs.addActionListener(this);
    this.save.addActionListener(this);
    this.save1.addActionListener(this);
    this.exit.addActionListener(this);
    this.rect.addActionListener(this);
    this.line.addActionListener(this);
    this.circle.addActionListener(this);
    this.oval.addActionListener(this);
    this.roundRect.addActionListener(this);
    this.brush.addActionListener(this);
    this.pallet.addActionListener(this);
    this.edge.addActionListener(this);
    this.jfc = new JFileChooser();
    FileNameExtensionFilter ext = new FileNameExtensionFilter("Image files", new String[] { "jpg", "gif", "bmp", "png" });
    this.jfc.setFileFilter(ext);
    this.jfc.setMultiSelectionEnabled(false);
    setTitle("Image Editor");

    setVisible(true);
    setDefaultCloseOperation(3);
    setExtendedState(getExtendedState() | 0x6);
  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == this.open) {
      this.da.intialize();
      int v = this.jfc.showOpenDialog(this);
      if (v == 0) {
        String fName = this.jfc.getSelectedFile().toString();
        this.da.openingImage(fName);
        this.da.repaint();
        validate();
      }
    }
    else
    {
      int v;
      if (e.getSource() == this.open1) {
        this.da.intialize();
        v = this.jfc.showOpenDialog(this);
        if (v == 0) {
          String fName = this.jfc.getSelectedFile().toString();
          this.da.openingImage(fName);
          this.da.repaint();
          validate();
        }
      } else if (e.getSource() == this.brightness) {
        ImageBrightness s = new ImageBrightness();
      }
      else if (e.getSource() == this.resize) {
        ImageResize imageResize = new ImageResize();
        this.da.repaint();
      }
      else if (e.getSource() == this.rightRotation) {
        this.da.makeImageRightRotate();
      }
      else if (e.getSource() == this.undo1) {
        Image_Stack.deleteImage();
        this.da.repaint();
      }
      else if (e.getSource() == this.redo1) {
        Image_Stack.redo();
        this.da.repaint();
      }
      else if (e.getSource() == this.leftRotation) {
        this.da.makeImageLeftRotate();
      }
      else if (e.getSource() == this.addText) {
        new AddingText();
      }
      else if (e.getSource() == this.about) {
        new About();
      }
      else if (e.getSource() == this.crop) {
        this.da.bi3 = Image_Stack.getImage();
        this.da.imgCrop = true;
        this.da.imgclip = true;
      }
      else if (e.getSource() == this.undo) {
        Image_Stack.deleteImage();
        this.da.repaint();
      }
      else if (e.getSource() == this.redo) {
        Image_Stack.redo();
        this.da.repaint();
      }
      else if (e.getSource() == this.sharpen) {
        this.da.sharpen();
      }
      else if (e.getSource() == this.blurr)
      {
        this.da.blurring();
      }
      else if (e.getSource() == this.grayScale) {
        this.da.makeImageGray();
      }
      else if (e.getSource() == this.black_white) {
        this.da.blackNDwhite();
      }
      else if (e.getSource() == this.zoom) {
        this.da.zoom();
      }
      else if (e.getSource() == this.crop1) {
        this.da.bi3 = Image_Stack.getImage();
        this.da.imgCrop = true;
        this.da.imgclip = true;
      }
      else if (e.getSource() == this.rect) {
        this.da.bi3 = Image_Stack.getImage();
        this.da.rect = true;
        this.da.rect1 = true;
      }
      else if (e.getSource() == this.line) {
        this.da.bi3 = Image_Stack.getImage();
        this.da.line = true;
        this.da.line1 = true;
      }
      else if (e.getSource() == this.oval) {
        this.da.bi3 = Image_Stack.getImage();
        this.da.oval = true;
        this.da.oval1 = true;
      }
      else if (e.getSource() == this.roundRect)
      {
        this.da.bi3 = Image_Stack.getImage();
        this.da.roundRect = true;
        this.da.roundRect1 = true;
      }
      else if (e.getSource() == this.circle)
      {
        this.da.bi3 = Image_Stack.getImage();
        this.da.circle = true;
        this.da.circle1 = true;
      }
      else if (e.getSource() == this.brush)
      {
        this.da.bi3 = Image_Stack.getImage();
        this.da.point1 = true;
        this.da.fill();
      }
      else if (e.getSource() == this.save1) {
        if (!this.da.saveAs) {
          try {
            showSave();
          } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        else {
          try
          {
            this.da.save(this.s1);
          } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      }
      else if (e.getSource() == this.save) {
        if (!this.da.saveAs) {
          try {
            showSave();
          } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        else {
          try
          {
            this.da.save(this.s1);
          } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
          }
        }

      }
      else if (e.getSource() == this.zoom1) {
        this.da.zoom();
      }
    }
    if (e.getSource() == this.pallet) {
      JColorChooser c1 = new JColorChooser();
      this.da.color1 = JColorChooser.showDialog(this, "Color chooser", Color.GRAY);
    }
    else if (e.getSource() == this.saveAs) {
      try {
        showSave();
      } catch (IOException ex) {
        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    else if (e.getSource() == this.exit) {
      System.exit(0);
    }
    else if (e.getSource() == this.edge) {
      this.da.edge = true;
      this.da.edge_detection();
    }
  }

  public void showSave() throws IOException { int d = this.jfc.showSaveDialog(this);
    if (d == 0) {
      this.s1 = this.jfc.getSelectedFile().toString();
      this.da.saveAs = true;
      this.da.save(this.s1);
    }
  }

  class ImageResize extends JFrame
    implements ActionListener
  {
    JButton ok;
    JTextArea tb1;
    JTextArea tb2;

    ImageResize()
    {
      setTitle("Image Resize");
      JPanel p1 = new JPanel();
      JPanel p2 = new JPanel();
      this.ok = new JButton("ok");
      this.ok.addActionListener(this);
      p1.add(new JLabel("Enter the new Coordinates"));
      this.tb1 = new JTextArea(1, 4);
      this.tb2 = new JTextArea(1, 4);
      p2.add(new JLabel("x"));
      p2.add(this.tb1);
      p2.add(new JLabel("y"));
      p2.add(this.tb2);
      p2.add(this.ok, "After");
      add(p1, "North");
      add(p2);
      setSize(300, 100);
      setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == this.ok) {
        int x3 = Integer.parseInt(this.tb1.getText());
        int y3 = Integer.parseInt(this.tb2.getText());
        Frame.this.da.resize(x3, y3);
        dispose();
      }
    }
  }

  public class ImageBrightness extends JFrame
    implements ChangeListener
  {
    JSlider jsl;

    ImageBrightness()
    {
      Container co = getContentPane();
      setTitle("Image Brightness");
      setSize(400, 200);
      this.jsl = new JSlider(-10, 10);
      this.jsl.setEnabled(true);
      this.jsl.addChangeListener(this);
      co.add(this.jsl, "Center");
      setVisible(true);
      pack();
    }

    public void stateChanged(ChangeEvent e) {
      Frame.this.da.v = (this.jsl.getValue() / 10.0F);
      Frame.this.da.imgBrightness = true;
      Frame.this.da.filter();
      Frame.this.da.repaint();
    }
  }

  class AddingText extends JFrame
    implements ActionListener
  {
    JPanel p1;
    JTextArea ta;
    JComboBox size;
    JComboBox style;
    JButton ok;
    JButton color;
    Color newColor;

    AddingText()
    {
      setTitle("Add text to image");
      setSize(400, 200);
      this.ok = new JButton("OK");
      this.color = new JButton("Color");
      this.ok.addActionListener(this);
      this.color.addActionListener(this);
      this.ta = new JTextArea(1, 10);
      this.ta.setLineWrap(true);
      this.size = new JComboBox();
      this.style = new JComboBox();
      this.p1 = new JPanel();
      this.p1.setLayout(new GridLayout(4, 1));
      this.p1.add(new JLabel("Text Area"));
      this.p1.add(this.ta);
      this.p1.add(new JLabel("Text Size"));
      this.p1.add(this.size);
      this.p1.add(new JLabel("Text Style"));
      this.p1.add(this.style);
      this.p1.add(this.color);
      this.p1.add(this.ok);
      add(this.p1, "Center");
      this.p1.setVisible(true);
      puttingElements();
      setVisible(true);
    }

    public void puttingElements()
    {
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      String[] fonts = ge.getAvailableFontFamilyNames();
      for (String f : fonts)
        this.style.addItem(f);
      for (int i = 5; i < 50; i++)
        this.size.addItem(Integer.valueOf(i));
    }

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.ok)
      {
        Frame.this.da.imgaddText = true;
        String text = this.ta.getText();
        int size1 = Integer.parseInt(this.size.getSelectedItem().toString());
        String font = this.style.getSelectedItem().toString();
        Frame.this.da.setText(text, font, size1, this.newColor);
        dispose();
      }
      else if (e.getSource() == this.color) {
        JColorChooser c1 = new JColorChooser();
        this.newColor = JColorChooser.showDialog(this, "Color chooser", Color.GRAY);
      }
    }
  }

  class About extends JFrame
    implements ActionListener
  {
    JLabel l1;
    String s1 = "<html>This Project is created by Rakshit Jain, june 2015</html>";

    About() {
      this.l1 = new JLabel("About the Application");
      this.l1.setText(this.s1);
      setTitle("About");
      add(this.l1);
      Dimension t1 = Toolkit.getDefaultToolkit().getScreenSize();
      setSize(240, 240);
      setLocation(t1.width / 2 - getSize().width / 2, t1.height / 2 - getSize().height / 2);
      setVisible(true);
      setEnabled(true);
    }

    public void actionPerformed(ActionEvent e) {
      throw new UnsupportedOperationException("Not supported yet.");
    }
  }

  class round extends JFrame
    implements ActionListener
  {
    JButton ok;
    JPanel jtb2;
    JTextArea ta1;
    JTextArea ta2;

    round()
    {
      this.jtb2 = new JPanel();
      this.ta1 = new JTextArea(1, 3);
      this.jtb2.add(new JLabel("Arc Width"));
      this.jtb2.add(this.ta1);
      this.ta2 = new JTextArea(1, 3);
      this.jtb2.add(new JLabel("Arc Length"));
      this.jtb2.add(this.ta2);
      this.ok = new JButton("OK");
      this.jtb2.add(this.ok);
      this.ok.addActionListener(this);
      this.jtb2.setVisible(false);
      add(this.jtb2, "Center");
      setSize(200, 100);
      setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == this.ok) {
        Frame.this.da.ah = Integer.parseInt(this.ta1.getText());
        Frame.this.da.al = Integer.parseInt(this.ta2.getText());
        dispose();
      }
      throw new UnsupportedOperationException("Not supported yet.");
    }
  }
}