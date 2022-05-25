import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*Resources: https://blog.csdn.net/shehun11/article/details/39583375,
* https://stackoverflow.com/questions/20346661/java-fade-in-and-out-of-images,
* https://coderanch.com/t/337511/java/removing-scrollpane
* ************************************************************
* First we show up A picture, than change the element RGBa of those pixel one by one and save to A
* because jScrollPane is using image's memory address
* until A transfer to B and click
* we swap A and B and do it again*/

class CrossDisslove extends JFrame{
    private int Height = 0, Width = 0, MinWidth = 0, MinHeight;
    private static String outImageStr = "", inImageStr = "";
    private BufferedImage outImage, inImage;
    private JFrame jf;
    private double k = 0.0;
    private boolean statement = true;
    private boolean outHeightIsLarger = true, outWidthIsLager = true, outTotalLarger = true;

    public static void main(String[] args) {
        int i = 1;
        ArrayList<Integer> index = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] path = new String[0];
        String str = "./resources/images/";
        File file = null;
        file = new File(str);
        path = file.list();
        System.out.println("Please select outImage");
        for (String paths : path){
            if (paths.contains(".jpg") || paths.contains(".png")){
                System.out.println(i + ". " + paths);
                index.add(i-1);
                i++;
            }
        }
        try {
            int SelectedFile = Integer.parseInt(br.readLine());
            outImageStr = str + path[index.get(SelectedFile - 1)];
            System.out.println("Selected " + path[index.get(SelectedFile-1)]);
            System.out.println("Please select inImage");
            SelectedFile = Integer.parseInt(br.readLine());
            inImageStr = str + path[index.get(SelectedFile - 1)];
        }catch (Exception e){
            e.printStackTrace();
        }


        new CrossDisslove();
    }
    private void check(){
        int outImageHeight = outImage.getHeight(), inImageHeight = inImage.getHeight();
        int outImageWidth = outImage.getWidth(), inImageWidth = inImage.getWidth();

        if (outImageHeight > inImageHeight){
            Height = outImageHeight;
            MinHeight = inImageHeight;
            outHeightIsLarger = true;
        }
        else if (inImageHeight > outImageHeight){
            Height = inImageHeight;
            MinHeight = outImageHeight;
            outHeightIsLarger = false;
        }
        else {
            Height = inImageHeight;
            MinHeight = outImageHeight;
        }
        if (outImageWidth > inImageWidth){
            Width = outImageWidth;
            MinWidth = inImageWidth;
            outWidthIsLager = true;
        }
        else if (inImageHeight > outImageHeight){
            Width = inImageWidth;
            MinWidth = outImageWidth;
            outWidthIsLager = false;
        }
        else {
            Width = inImageWidth;
            MinWidth = outImageWidth;
        }
        if (outWidthIsLager && outHeightIsLarger) outTotalLarger = true;
        else outTotalLarger = false;
        System.out.println("width lager = " + outWidthIsLager
                + " height = " + outHeightIsLarger + ", total = " + outTotalLarger + ", outheight = " + outImageHeight + "\n" +
                "outwidth = " + outImageWidth + ", inheight = " + inImageHeight + "\n" +
                "inwidth = " + inImageWidth);
    }

    private void reNewPicture(JScrollPane jScrollPane){
        if (k >= 0.4){
            statement = !statement;//flip A to B then B to A
            if (statement){
                try {
                    outImage = ImageIO.read(new File(
                            outImageStr));
                    inImage = ImageIO.read(new File(
                            inImageStr));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    inImage = ImageIO.read(new File(
                            outImageStr));
                    outImage = ImageIO.read(new File(
                            inImageStr));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            check();
            jScrollPane.setViewportView(new JLabel(new ImageIcon(outImage)));
            jf.getContentPane().revalidate();//recatch data of panel
//            JScrollBar jScrollBar = jScrollPane.getVerticalScrollBar();
//            jScrollBar.setPreferredSize(new Dimension(Width, Height));
            jScrollPane.updateUI();
            k = 0.0;
        }
        else{
            //System.out.println(k);
            DissolvePicture();
            jScrollPane.updateUI();
        }
    }


    private void DissolvePicture(){
        int greenIn = 0, redIn = 0, blueIn = 0;
        int greenOut = 0, redOut = 0, blueOut = 0;
//        BufferedImage temp = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_BGR);
//        if (outTotalLarger) temp = outImage;
//        else temp = inImage;
        Color white = new Color(255, 255, 255);

        for (int i = inImage.getMinX(); i < MinWidth; i++) {
            for (int j = inImage.getMinY(); j < MinHeight; j++) {
                //temp.setRGB(i, j, (int) (((1.0-k)*outImage.getRGB(i, j))+k*inImage.getRGB(i, j)));

                Color colorOut = new Color(outImage.getRGB(i, j));
                Color colorIn = new Color(inImage.getRGB(i, j));

                greenIn = colorIn.getGreen();redIn = colorIn.getRed();blueIn = colorIn.getBlue();
                greenOut = colorOut.getGreen();redOut = colorOut.getRed();blueOut = colorOut.getBlue();

                Color colortemp = new Color(
                        (int)((1.0-k)*redOut + k*redIn), (int)((1.0-k)*greenOut + k*greenIn), (int)((1.0-k)*blueOut + k*blueIn));
                outImage.setRGB(i, j, colortemp.getRGB());
            }
        }
        for (int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                if (i > MinWidth || j > MinHeight){
                    if (outTotalLarger){
                        Color colorOut = new Color(outImage.getRGB(i, j));
                        greenOut = colorOut.getGreen();redOut = colorOut.getRed();blueOut = colorOut.getBlue();
                        greenIn = white.getGreen();redIn = white.getRed();blueIn = white.getBlue();

                        Color colortemp = new Color(
                                (int)((1.0-k)*redOut + k*redIn), (int)((1.0-k)*greenOut + k*greenIn), (int)((1.0-k)*blueOut + k*blueIn));
                        outImage.setRGB(i, j, colortemp.getRGB());
                    }
                    else {
                        Color colorIn = new Color(inImage.getRGB(i, j));
                        greenIn = colorIn.getGreen();redIn = colorIn.getRed();blueIn = colorIn.getBlue();
                        greenOut = white.getGreen();redOut = white.getRed();blueOut = white.getBlue();

                        Color colortemp = new Color(
                                (int)((1.0-k)*redOut + k*redIn), (int)((1.0-k)*greenOut + k*greenIn), (int)((1.0-k)*blueOut + k*blueIn));
                        inImage.setRGB(i, j, colortemp.getRGB());
                    }
                }
            }
        }
        k += 0.01;
    }

    CrossDisslove(){
        try {
            outImage = ImageIO.read(new File(
                    outImageStr));
            inImage = ImageIO.read(new File(
                    inImageStr));
        }catch (IOException io){
            io.printStackTrace();
        }
        check();

        jf = new JFrame("pic");
        JScrollPane jScrollPane = new JScrollPane(new JLabel(new ImageIcon(outImage)));

        jf.getContentPane().add(jScrollPane);jf.pack();
        //jf.setSize(Width, Height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);jf.setLocationRelativeTo(null);jf.setVisible(true);
        JScrollBar jScrollBar = jScrollPane.getVerticalScrollBar();
        jScrollBar.setPreferredSize(new Dimension(Width, Height));
        //************************************************************
        final Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reNewPicture(jScrollPane);
                if (k >= 0.4) {
                    System.out.println("Timer had been paused");
                    ((Timer)e.getSource()).stop();
                }
            }
        });
        jScrollPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timer.start();
            }
        });
    }
}
