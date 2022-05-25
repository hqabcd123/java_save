import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CrossDissolve extends JPanel {
    JScrollPane jScrollPane = new JScrollPane();
    JFileChooser jFileChooser = new JFileChooser(".");
    BufferedImage inImage, outImage;
    char PictureNum = 0;
    public static void main(String[] args) {
        CrossDissolve crossDissolve = new CrossDissolve();
        crossDissolve.setLayout(new GridLayout(2, 1));
        JFrame jf = new JFrame("Picture");

        jf.getContentPane().add(crossDissolve);
        jf.setSize(1280, 720);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    CrossDissolve(){
        add(buildMenu());
        add(jScrollPane);
    }
    JMenuBar buildMenu(){
        JMenuBar mbar = new JMenuBar();
        JMenu menu = new JMenu("File (F)");
        menu.setMnemonic(KeyEvent.VK_F);
        mbar.add(Box.createRigidArea(new Dimension(100, 25)));
        mbar.add(menu);

        JMenuItem item = new JMenuItem("Open (O)", KeyEvent.VK_O);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readFile();
            }
        });
        menu.add(item);
        return mbar;
    }
    void readFile(){
        int state = jFileChooser.showOpenDialog(this);
        if (state == JFileChooser.APPROVE_OPTION){
            File file = jFileChooser.getSelectedFile();
            try {
                outImage = ImageIO.read(file);
            }catch (IOException io){
                io.printStackTrace();
            }
            PictureNum++;
        }
    }
}
