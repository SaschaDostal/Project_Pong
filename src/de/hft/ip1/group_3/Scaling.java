package de.hft.ip1.group_3;

public class Scaling {
    public static int sizeX = 1000;
    public static int sizeY = (int)(0.7 * sizeX);

    public static int playerBarRecX = sizeX / 100;
    public static int playerBarRecY = sizeY / 10;
    public static int playerBarPos1X = 0 + sizeX/40;
    public static int playerBarPos1Y = sizeY / 2 - playerBarRecY / 2;

    public static int playerBarPos2X = sizeX - sizeX/40 - playerBarRecX;
    public static int playerBarPos2Y = sizeY / 2 - playerBarRecY / 2;

    public static int wallRecX = sizeX;
    public static int wallRecY = sizeY / 100;
    public static int wallPos1X = 0;
    public static int wallPos1Y = 0;

    public static int wallPos2X = 0;
    public static int wallPos2Y = sizeY - wallRecY;
 
    public static int wallRec1X = sizeY / 100; 
    public static int wallRec1Y = sizeY;   
    
    public static int wallPos3X = 0;
    public static int wallPos3Y = 0;   
    
    public static int wallPos4X = sizeX - wallRec1X;
    public static int wallPos4Y = 0;  
    
    public static int ballRecX = sizeY / 25;
    public static int ballRecY = sizeY / 25;
    public static int ballPosX = sizeX / 2 - ballRecX / 2;
    public static int ballPosY = sizeY / 2 - ballRecY / 2;
  
    public static int maxValid = Scaling.sizeY - Scaling.wallRecY;
    public static int minValid = Scaling.wallRecY;
}
