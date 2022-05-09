package com.example.catanfx.GamePieces;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;



public class HelpMenu extends JFrame {

    private JButton previousPageBtn;
    private JButton nextPageBtn;

    private BufferedImage page0, page1, page2, page3, page4, page5, page6, page7, page8, page9, page10, page11, page12, page13, page14, page15, page16, currentPage;

    {
        try {
            page0 = ImageIO.read(new File("src/main/resourcesAssets/Images/instructions.jpg"));
            page1 = ImageIO.read(new File("src/main/resourcesAssets/Images/0001.jpg"));
            page2 = ImageIO.read(new File("src/main/resourcesAssets/Images/0002.jpg"));
            page3 = ImageIO.read(new File("src/main/resourcesAssets/Images/0003.jpg"));
            page4 = ImageIO.read(new File("src/main/resourcesAssets/Images/0004.jpg"));
            page5 = ImageIO.read(new File("src/main/resourcesAssets/Images/0005.jpg"));
            page6 = ImageIO.read(new File("src/main/resourcesAssets/Images/0006.jpg"));
            page7 = ImageIO.read(new File("src/main/resourcesAssets/Images/0007.jpg"));
            page8 = ImageIO.read(new File("src/main/resourcesAssets/Images/0008.jpg"));
            page9 = ImageIO.read(new File("src/main/resourcesAssets/Images/0009.jpg"));
            page10 = ImageIO.read(new File("src/main/resourcesAssets/Images/0010.jpg"));
            page11 = ImageIO.read(new File("src/main/resourcesAssets/Images/0011.jpg"));
            page12 = ImageIO.read(new File("src/main/resourcesAssets/Images/0012.jpg"));
            page13 = ImageIO.read(new File("src/main/resourcesAssets/Images/0013.jpg"));
            page14 = ImageIO.read(new File("src/main/resourcesAssets/Images/0014.jpg"));
            page15 = ImageIO.read(new File("src/main/resourcesAssets/Images/0015.jpg"));
            page16 = ImageIO.read(new File("src/main/resourcesAssets/Images/0016.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentPage = page0;

    }

    public HelpMenu() {
        super("Help Menu");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        //set a background image
        setContentPane(new JLabel(new ImageIcon("src/main/resourcesAssets/Images/CoolPic.jpg")));
        setVisible(true);
        getContentPane().setBackground(new Color(245, 245, 220));
        JLabel page = new JLabel(new ImageIcon(page0));
        page.setBounds(0, 0, 800, 600);
        add(page);



        previousPageBtn = new JButton("Previous Page");
        previousPageBtn.setBackground(new Color(245, 245, 220));
        previousPageBtn.setFont(new Font("Architect's Daughter", Font.PLAIN, 11));
        previousPageBtn.setBounds(10, 550, 110, 30);
        previousPageBtn.setBorder(BorderFactory.createLineBorder(new Color(245, 245, 220)));
        previousPageBtn.addActionListener(new ActionListener() {
                                              public void actionPerformed(ActionEvent e) {
                                                  if (currentPage == page0) {
                                                      currentPage = page0;
                                                  } else if (currentPage == page1) {
                                                      currentPage = page0;}
                                                  else if (currentPage == page2) {
                                                      currentPage = page1;
                                                  } else if (currentPage == page3) {
                                                      currentPage = page2;
                                                  } else if (currentPage == page4) {
                                                      currentPage = page3;
                                                  } else if (currentPage == page5) {
                                                      currentPage = page4;
                                                  } else if (currentPage == page6) {
                                                      currentPage = page5;
                                                  } else if (currentPage == page7) {
                                                      currentPage = page6;
                                                  } else if (currentPage == page8) {
                                                      currentPage = page7;
                                                  } else if (currentPage == page9) {
                                                      currentPage = page8;
                                                  } else if (currentPage == page10) {
                                                      currentPage = page9;
                                                  } else if (currentPage == page11) {
                                                      currentPage = page10;
                                                  } else if (currentPage == page12) {
                                                      currentPage = page11;
                                                  } else if (currentPage == page13) {
                                                      currentPage = page12;
                                                  } else if (currentPage == page14) {
                                                      currentPage = page13;
                                                  } else if (currentPage == page15) {
                                                      currentPage = page14;
                                                  } else if (currentPage == page16) {
                                                      currentPage = page15;
                                                  }
                                                  page.setIcon(new ImageIcon(currentPage));

                                              }
                                          }
        );
        add(previousPageBtn);
        nextPageBtn = new JButton("Next Page");
        nextPageBtn.setBackground(new Color(245, 245, 220));
        nextPageBtn.setBounds(670, 550, 100, 30);
        nextPageBtn.setFont(new Font("Architect's Daughter", Font.PLAIN, 13));
        nextPageBtn.setBorder(BorderFactory.createLineBorder(new Color(245, 245, 220)));
        nextPageBtn.addActionListener(new ActionListener() {
                                          public void actionPerformed(ActionEvent e) {
                                              if (currentPage == page0) {
                                                  currentPage = page1;
                                              }  else if (currentPage == page1) {
                                                  currentPage = page2;}
                                              else if (currentPage == page2) {
                                                  currentPage = page3;
                                              } else if (currentPage == page3) {
                                                  currentPage = page4;
                                              } else if (currentPage == page4) {
                                                  currentPage = page5;
                                              } else if (currentPage == page5) {
                                                  currentPage = page6;
                                              } else if (currentPage == page6) {
                                                  currentPage = page7;
                                              } else if (currentPage == page7) {
                                                  currentPage = page8;
                                              } else if (currentPage == page8) {
                                                  currentPage = page9;
                                              } else if (currentPage == page9) {
                                                  currentPage = page10;
                                              } else if (currentPage == page10) {
                                                  currentPage = page11;
                                              } else if (currentPage == page11) {
                                                  currentPage = page12;
                                              } else if (currentPage == page12) {
                                                  currentPage = page13;
                                              } else if (currentPage == page13) {
                                                  currentPage = page14;
                                              } else if (currentPage == page14) {
                                                  currentPage = page15;
                                              } else if (currentPage == page15) {
                                                  currentPage = page16;
                                              }
                                              page.setIcon(new ImageIcon(currentPage));


                                          }
                                      }
        );

        add(nextPageBtn);
        setTitle("Help");
        setSize(800, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        add(page);
        add(nextPageBtn);
        add(previousPageBtn);
        setVisible(true);
    }
}