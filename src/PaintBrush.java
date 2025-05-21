import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PaintBrush extends JFrame implements ActionListener {


    Color currColor;
    ColorPalette colorPalette;
    DrawingSpace drawingSpace;

    int islem = 0;
    int prevIslem = 0;

    public PaintBrush() {
        setSize(800, 600);


        JPanel ust = new JPanel();
        ust.setLayout(new BorderLayout());
        JPanel alt = new JPanel();
        alt.setLayout(new BorderLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currColor = Color.black;
        colorPalette = new ColorPalette();
        colorPalette.setBackground(Color.white);
        drawingSpace = new DrawingSpace();
        colorPalette.setPreferredSize(new Dimension(100, 50));


        JPanel button = new JPanel();
        button.setLayout(new FlowLayout());
        button.setBackground(Color.white);

        JButton diktortgen = new JButton("Dikdörtgen Çiz");
        JButton oval = new JButton("Oval Çiz");
        JButton kalem = new JButton("Kalemle Çiz");
        JButton tasi = new JButton("Taşı");


        button.add(diktortgen);
        button.add(oval);
        button.add(kalem);
        button.add(tasi);

        diktortgen.setPreferredSize(new Dimension(150,50));
        kalem.setPreferredSize(new Dimension(150,50));
        oval.setPreferredSize(new Dimension(150,50));
        tasi.setPreferredSize(new Dimension(150,50));


        oval.setBackground(Color.LIGHT_GRAY);
        kalem.setBackground(Color.LIGHT_GRAY);
        tasi.setBackground(Color.LIGHT_GRAY);
        diktortgen.setBackground(Color.LIGHT_GRAY);

        ust.add(colorPalette, BorderLayout.NORTH);
        ust.add(button, BorderLayout.SOUTH);
        alt.add(drawingSpace, BorderLayout.CENTER);

        add(ust, BorderLayout.NORTH);
        add(alt, BorderLayout.CENTER);


        diktortgen.addActionListener(this);
        oval.addActionListener(this);
        kalem.addActionListener(this);
        tasi.addActionListener(this);


        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String komut = e.getActionCommand();
        if (komut.equals("Dikdörtgen Çiz")) {
            islem = 1;

        } else if (komut.equals("Oval Çiz")) {
            islem = 2;
        } else if (komut.equals("Kalemle Çiz")) {
            islem = 3;
        } else if (komut.equals("Taşı")) {
            islem = 4;
        }


    }


    public void setColor(Color color) {
        currColor = color;
    }

    //******************************************************************************************************************
    class ColorPalette extends JPanel implements MouseInputListener {
        JPanel blue,red,green,yellow,orange,magenta,black=null;


        public ColorPalette() {
            setLayout(new FlowLayout());

            blue=new JPanel();
            blue.setPreferredSize(new Dimension(100,50));
            blue.setBackground(Color.blue);
            add(blue);

            red=new JPanel();
            red.setPreferredSize(new Dimension(100,50));
            red.setBackground(Color.red);
            add(red);

            green=new JPanel();
            green.setPreferredSize(new Dimension(100,50));
            green.setBackground(new Color(27, 140, 27));
            add(green);

            yellow=new JPanel();
            yellow.setPreferredSize(new Dimension(100,50));
            yellow.setBackground(Color.yellow);
            add(yellow);

            orange=new JPanel();
            orange.setPreferredSize(new Dimension(100,50));
            orange.setBackground(new Color(227, 108, 38));
            add(orange);

            magenta=new JPanel();
            magenta.setPreferredSize(new Dimension(100,50));
            magenta.setBackground(new Color(117, 36, 175));
            add(magenta);

            black=new JPanel();
            black.setPreferredSize(new Dimension(100,50));
            black.setBackground(Color.black);
            add(black);


            addMouseListener(this);
            addMouseMotionListener(this);
            setVisible(true);

        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {

            if (islem != 4) {
                if (e.getX()>=blue.getX()&&e.getX()<=blue.getX()+blue.getWidth()&&
                        e.getY()>=blue.getY()&&e.getY()<=blue.getY()+ blue.getHeight()) {
                    setColor(Color.blue);
                } else if (e.getX()>=red.getX()&&e.getX()<=red.getX()+red.getWidth()&&
                        e.getY()>=red.getY()&&e.getY()<=red.getY()+ red.getHeight()) {
                    setColor(Color.red);
                } else if (e.getX()>=green.getX()&&e.getX()<=green.getX()+green.getWidth()&&
                        e.getY()>=green.getY()&&e.getY()<=green.getY()+ green.getHeight()) {
                    setColor(new Color(27, 140, 27));
                } else if (e.getX()>=yellow.getX()&&e.getX()<=yellow.getX()+yellow.getWidth()&&
                        e.getY()>=yellow.getY()&&e.getY()<=yellow.getY()+ yellow.getHeight()) {
                    setColor(Color.yellow);
                } else if (e.getX()>=orange.getX()&&e.getX()<=orange.getX()+orange.getWidth()&&
                        e.getY()>=orange.getY()&&e.getY()<=orange.getY()+ orange.getHeight()) {
                    setColor(new Color(227, 108, 38));
                } else if (e.getX()>=magenta.getX()&&e.getX()<=magenta.getX()+magenta.getWidth()&&
                        e.getY()>=magenta.getY()&&e.getY()<=magenta.getY()+ magenta.getHeight()) {
                    setColor(new Color(117, 36, 175));
                } else if (e.getX()>=black.getX()&&e.getX()<=black.getX()+black.getWidth()&&
                        e.getY()>=black.getY()&&e.getY()<=black.getY()+ black.getHeight()) {
                    setColor(Color.black);
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {}

        @Override
        public void mouseMoved(MouseEvent e) {}
    }

    //******************************************************************************************************************
    class DrawingSpace extends JPanel implements MouseInputListener {
        boolean dragged = false;
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

        int wideR,heightR,wideO,heightO;
        int xR,yR,xO,yO;
        double a,b,cX,cY,x,y;


        ArrayList<Paintings> points = new ArrayList<>();

        Paintings shape;

        public DrawingSpace() {

            setBackground(Color.white);
            setSize(800, 600);
            setLayout(new BorderLayout());

            addMouseListener(this);
            addMouseMotionListener(this);



            setVisible(true);

        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {

            x1 = e.getX();
            y1 = e.getY();


            if(islem ==4) {



                for(int i=points.size()-1;i>=0;i--) {

                    if (points.get(i) != null) {

                        if (points.get(i).getShape().equals("Rectangle")) {
                            if (e.getX() >= Math.min(points.get(i).x1, points.get(i).x2) && e.getX() <=  Math.min(points.get(i).x1, points.get(i).x2) + Math.abs(points.get(i).x1 - points.get(i).x2) &&
                                    e.getY() >= Math.min(points.get(i).y1, points.get(i).y2) && e.getY() <= Math.min(points.get(i).y1, points.get(i).y2) + Math.abs(points.get(i).y1 - points.get(i).y2)) {
                                shape = points.get(i);
                                xR = Math.abs(e.getX() - points.get(i).x1);
                                yR = Math.abs(e.getY() - points.get(i).y1);
                                wideR = Math.abs(points.get(i).x1 - points.get(i).x2);
                                heightR = Math.abs(points.get(i).y1 - points.get(i).y2);
                                points.remove(points.get(i));
                                points.add(shape);
                                dragged = true;
                                break;
                            } else dragged = false;

                        } else if (points.get(i).getShape().equals("Oval")) {

                            wideO = Math.abs(points.get(i).x1-points.get(i).x2);
                            a = wideO / 2;
                            cX = Math.min(points.get(i).x1,points.get(i).x2)+a;

                            heightO = Math.abs(points.get(i).y1-points.get(i).y2);
                            b = heightO / 2;
                            cY = Math.min(points.get(i).y1,points.get(i).y2) + b;


                             x = e.getX() - cX;
                             y = e.getY() - cY;
                            if ((Math.pow(x,2) / Math.pow(a,2)) + (Math.pow(y,2) / Math.pow(b,2))<=1) {
                                shape = points.get(i);
                                xO = Math.abs(e.getX() - points.get(i).x1);
                                yO = Math.abs(e.getY() - points.get(i).y1);
                                points.remove(points.get(i));
                                points.add(shape);
                                dragged = true;
                                break;
                            } else dragged = false;
                        }
                    }
                }




            }

            else
            {
                dragged = true;
                points.add(new Paintings(currColor, prevIslem, islem, x1, y1, x2, y2));

            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();


            if (islem == 4 && shape != null) {
                shape = null;

            }

            dragged = false;
            prevIslem = islem;





        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {
            if (dragged) {

                x2 = e.getX();
                y2 = e.getY();



                if (islem == 3) {
                    if(!points.isEmpty()) {
                        Paintings pencil = points.get(points.size() - 1);
                        points.get(points.size() - 1).setX1(x2);
                        points.get(points.size() - 1).setY1(y2);
                        points.get(points.size() - 1).setX2(e.getX());
                        points.get(points.size() - 1).setY2(e.getY());

                        repaint();
                        points.add(new Paintings(currColor, prevIslem, islem, pencil.x2, pencil.y2, x2, y2));


                    }

                } else if (islem == 1 || islem == 2) {
                    if(!points.isEmpty()) {
                        points.get(points.size() - 1).setX2(e.getX());
                        points.get(points.size() - 1).setY2(e.getY());
                        repaint();
                    }
                } else if(islem == 4){

                    if(shape!=null){
                        if(shape.getShape().equals("Rectangle")) {
                            shape.setX1(e.getX() - xR);
                            shape.setY1(e.getY() - yR);

                            shape.setX2(wideR+shape.x1);
                            shape.setY2(heightR+shape.y1);

                            repaint();
                        }
                        else if(shape.getShape().equals("Oval")){
                            shape.setX1(e.getX() - xO);
                            shape.setY1(e.getY() - yO);

                            shape.setX2(wideO+shape.x1);
                            shape.setY2(heightO+shape.y1);


                            repaint();
                        }

                    }
                    else {
                        repaint();}



                }

            }

        }



        @Override
        public void mouseMoved(MouseEvent e) {}


        public void paint(Graphics g) {
            super.paint(g);


            for (int i = 0; i < points.size(); i++) {

                if (!points.isEmpty() && points.get(i)!=null) {
                    if (points.get(i).getShape().equals("Rectangle")) {
                        g.setColor(points.get(i).color);
                        g.fillRect(Math.min(points.get(i).x1, points.get(i).x2), Math.min(points.get(i).y1, points.get(i).y2), Math.abs(points.get(i).x1 - points.get(i).x2), Math.abs(points.get(i).y1 - points.get(i).y2));
                    } else if (points.get(i).getShape().equals("Oval")) {
                        g.setColor(points.get(i).color);
                        g.fillOval(Math.min(points.get(i).x1, points.get(i).x2), Math.min(points.get(i).y1, points.get(i).y2), Math.abs(points.get(i).x2-points.get(i).x1), Math.abs(points.get(i).y2-points.get(i).y1));
                    } else if (points.get(i).getShape().equals("Pencil")) {
                        if (points.get(i).islem==3) {
                            Graphics2D g2d = (Graphics2D) g;
                            g.setColor(points.get(i).color);
                            g2d.setStroke(new BasicStroke(3));
                            g.drawLine(points.get(i ).x1, points.get(i).y1, points.get(i).x2, points.get(i).y2);



                        }

                    }
                }


            }

            Graphics2D g2d = (Graphics2D) g;
            g.setColor(Color.BLUE);
            g2d.setStroke(new BasicStroke(8));
            g.drawLine(0,0,this.getWidth(),0);
        }

    }
//**********************************************************************************************************************
    class Paintings {
        int islem;
        int prevIslem, x1, x2, y1, y2;
        Color color;

        public void setX1(int x1) {
            this.x1 = x1;
        }

        public void setX2(int x2) {
            this.x2 = x2;
        }

        public void setY1(int y1) {
            this.y1 = y1;
        }

        public void setY2(int y2) {
            this.y2 = y2;
        }

        public Paintings(Color color, int prevIslem, int islem, int x1, int y1, int x2, int y2) {

            this.color = color;
            this.prevIslem = prevIslem;
            this.islem = islem;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        public String getShape() {
            if (islem == 1) {
                return "Rectangle";
            } else if (islem == 2) {
                return "Oval";
            } else if (islem == 3) {
                return "Pencil";
            } else if(islem == 4){
                return "Taşı";
            }
            else return "";
        }

    }
        public static void main(String[] args) {

            new PaintBrush();
        }

    }

