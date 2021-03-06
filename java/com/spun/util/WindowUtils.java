package com.spun.util;

import javax.swing.*;
import java.awt.Dimension;

public class WindowUtils
{
  /***********************************************************************/
  public static void centerWindow(java.awt.Window window)
  {
    Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    Dimension w = window.getSize();
    int dx = (int) w.getWidth();
    int dy = (int) w.getHeight();
    int x = (int) ((d.getWidth() - dx) / 2);
    int y = (int) ((d.getHeight() - dy) / 2);
    MySystem.variable(" size (" + x + "," + y + "," + dx + "," + dy + ")");
    window.setBounds(x, y, dx, dy + 1);
  }
  /***********************************************************************/
  public static void testPanel(JPanel panel)
  {
    JFrame test = new JFrame("Testing Frame");
    test.getContentPane().add(panel);
    testFrame(test,true);
    while(true){}
  }
  /***********************************************************************/
  public static void testFrame(JFrame frame)
  {
    testFrame(frame, true);
  }
  /***********************************************************************/
  public static void copyToClipBoard(String code)
  {
    copyToClipBoard(code, true);
  }
  public static void copyToClipBoard(String code, boolean displayMessage)
  {
    java.awt.datatransfer.StringSelection selection = new java.awt.datatransfer.StringSelection(code);
    java.awt.Frame frame = new java.awt.Frame();
    frame.getToolkit().getSystemClipboard().setContents(selection, selection);
    if (displayMessage)
    {
      JOptionPane.showMessageDialog(null, "Code copied to Clipboard", "Finished", JOptionPane.INFORMATION_MESSAGE);
    }
    frame.dispose();
  }
  /***********************************************************************/
  public static void testFrame(JFrame frame, boolean closeOnExit)
  {
    frame.pack();
    if (closeOnExit)
    {
      frame.addWindowListener(new FrameCloser());
    }
    WindowUtils.centerWindow(frame);
    frame.setVisible(true);
  }
  /***********************************************************************/
}