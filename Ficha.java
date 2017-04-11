import java.awt.*;
import java.util.*;
import java.applet.*;
import java.util.List;
import java.util.ArrayList;
public class Ficha extends Rectangle{
	Image imagen;
	int valor=0;
    public Ficha(int posx, int posy,int width, int height,Image img,int v) {	
    	super(posx,posy,width,height);    
    	imagen=img;
    	valor=v;
    	}
    public void dibujar(Graphics g,Applet a){
    	g.drawImage(imagen,x,y,width,height,a);
    }
    
    public void actualizar(int posx, int posy){
    	x=posx-30;
    	y=posy-30;
    }
}