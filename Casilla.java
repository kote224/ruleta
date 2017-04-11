import java.awt.*;
import java.util.*;
import java.applet.*;
import java.util.List;
import java.util.ArrayList;
public class Casilla extends Rectangle{
	int valor;
	Color color;							
    public Casilla(int posx, int posy,int width, int height,int v, Color color) {		//le pasas la posicion de x,y,width,height, el valor y el color en el metodo constructor
    	super(posx,posy,width,height);
    	valor=v;
    	this.color = color; 					//creas una atributo de color y en la clase RULETA, le pasas el color
    }
    public void dibujar(Graphics g,int i,int j,int rojos[], int negros[]){
    	
    	g.setColor(color);
    	for(int cont=0;cont<rojos.length;cont++)
    		if(valor==rojos[cont]){
    			g.setColor(Color.red);
    			g.fillRect(x,y,width,height);
    		}
    	for(int cont=0;cont<negros.length;cont++)
    		if(valor==negros[cont]){
    			g.setColor(Color.black);
    			g.fillRect(x,y,width,height);
    		}
    	g.setColor(Color.white);			
    	g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
    	g.drawString(" "+valor,i*70+45,j*70+50);
    	g.setColor(Color.yellow);				//en vez de poner el color que quieres pasarle, pones el atributo con el color correspondiente
    	g.drawRect(x,y,width,height);
    	
    }
    
    
}