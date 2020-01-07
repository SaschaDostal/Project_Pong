package de.hft.ip1.group_3;

public class Scaling {
    public static int sizeX = 700;
    public static int sizeY = 700;
    
    public static int playerBarRecX = sizeX/100;
    public static int playerBarRecY = sizeY/10;
    public static int playerBarPos1X = 0;
    public static int playerBarPos1Y = sizeY/2 - playerBarRecY/2;
    
    public static int playerBarPos2X = sizeX - playerBarRecX;
    public static int playerBarPos2Y = sizeY/2 - playerBarRecY/2;
    
    public static int wallRecX = sizeX;
    public static int wallRecY = sizeY/100;
    public static int wallPos1X = 0;
    public static int wallPos1Y = 0;
    
    public static int wallPos2X = 0;
    public static int wallPos2Y = sizeY - wallRecY;
    
    public static int ballRecX = sizeY/100;
    public static int ballRecY = sizeY/100;
    public static int ballPosX = sizeX/2 - ballRecX/2;
    public static int ballPosY = sizeY/2 - ballRecY/2;
}
