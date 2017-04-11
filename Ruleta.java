import java.awt.*;
import java.applet.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
public class Ruleta extends Applet{
	Graphics noseve;
	Image imagen;
	Image ficha[];
	Casilla casilla[][];
	Ficha fichas[];
	Ficha activo;
	List <Ficha> valores;
	ArrayList<Integer> numeros = new ArrayList<Integer>();
	int rojos[]={1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
	int negros[]={2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
	int valoresFichas[]={1,5,10,25,50,100,500,1000,5000,10000};
	java.util.List <Integer> lRojos;
	Button boton;
	int r;
    public void init() {
    	imagen = createImage(700, 900);
    	noseve = imagen.getGraphics();
    	//imagenes de fichas
    	ficha = new Image[10];	
    	for(int i=1; i<11; i++)
    		ficha[i-1] = getImage(getCodeBase(), "fichas/ficha" + i+ ".png");
    	fichas = new Ficha[10];
    	for(int i=0; i<10; i++)
    		fichas[i]=new Ficha(600,i*70+30,60,60,ficha[i],1);										//Le pasas los valores de las fichas
    	
    		
    	//las casillas
     	casilla = new Casilla[3][12];
     	lRojos = new java.util.ArrayList<Integer>();
     	for(int cont=0;cont<rojos.length;cont++)
     		lRojos.add(new Integer(rojos[cont]));
     	for(int i=0; i<3; i++)
    		for(int j=0; j<12; j++)
    			casilla[i][j]= new Casilla(i*70+40,j*70+30,70,70,((j*3)+i)+1,Color.black);				//Aqui le pasas x,y,valor y color
    	valores= new ArrayList<Ficha>();														//Valores al soltar el raton
    	this.setLayout(new BorderLayout());
    	
    	boton = new Button("PULSAME COOO");
    	add(boton,BorderLayout.NORTH);
    	
     }
    public void paint(Graphics g){
    	noseve.setColor(Color.green);
    	noseve.fillRect(0, 0, 700, 900);
    	
    	for(int i=0; i<3; i++)
    		for(int j=0; j<12; j++)
    			casilla[i][j].dibujar(noseve,i,j,rojos,negros);
    	for(int i=0; i<10; i++)
    		fichas[i].dibujar(noseve,this);
    	noseve.drawString(""+r,300,300);
    	g.drawImage(imagen, 0, 0, this);
    }
    public void update(Graphics g){
    	paint(g);										//evitar el parpadeo de la imagen pintando g y poniendo noseve en g
    }
    public boolean mouseDrag(Event ev,int x,int y){		//Al hacer drag, mueve solo la ficha ACTIVA
		if(activo!=null){
	    	activo.actualizar(x,y);						//al meter el puntero de la ficha,  llama a actualizar con el valor de esa ficha
	    	repaint();
		}
    	return true;
    }
    public boolean mouseDown(Event ev, int x, int y){
    	for(int i=0;i<fichas.length;i++)		
			if(fichas[i].contains(x,y)){			//si al clicar en una de las fichas, indica que es ESA FICHA
				activo=fichas[i];					//activo tiene como puntero la ficha que has clicado
				
				repaint();
			}
		return true;
    }   
    public boolean mouseUp(Event ev, int x, int y){
    	//for(int r=0;r<fichas.length;r++)
    		for(int i=0; i<3; i++)
    			for(int j=0; j<12; j++)
					if(activo.intersects(casilla[i][j])){
							numeros.add(((j*3)+i)+1);								//saber en que casilla esta la ficha y la guarda en la lista NÚMEROS 
							System.out.print(numeros);
							break;
					}
		activo=null;
    	return true;
    }
    
    public boolean action(Event ev, Object obj){
    	if(ev.target instanceof Button){
    		for(int cont=0;cont<1000;cont++){
    			r=(int)(Math.random()*36);
    			
    			repaint();
    		}
    	for(int comp=0;comp< numeros.size();comp++)
    				if(numeros.get(comp)==r)
    					System.out.print("HAS GANAO COOOOOOO");
    		return true;
    	}
    
    	return false;
    }
}