package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.Alpha;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

import logico.Cilindro;
import logico.Cuadrado;
import logico.Esfera;
import logico.CentroEstudios;
import logico.Rectangulo;
import logico.Triangulo;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.util.concurrent.CyclicBarrier;
import java.awt.event.ActionEvent;

public class Prisma1 extends JDialog {


	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String [] args) {
		System.setProperty("sun.awt.noerasebackground", "true");
	Prisma1 dialog = new Prisma1();
	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	dialog.setVisible(true);
	

	}

	/**
	 * Create the dialog.
	 */
	public Prisma1() {
		setBounds(100,100,800,700);
	GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
	Canvas3D canvas3D = new Canvas3D(config);
	setLayout(new BorderLayout());
	add(canvas3D);
	SimpleUniverse universo = new SimpleUniverse(canvas3D);
	universo.getViewingPlatform().setNominalViewingTransform();
	BranchGroup escena = crearGrafoEscena();
	escena.compile();
	universo.addBranchGraph(escena);
	
		
	}
	//Este es el metodo que crea la figura
	public BranchGroup crearGrafoEscena() {
		//aqui se crea el objeto 
		BranchGroup objetoRaiz =  new BranchGroup();
		TransformGroup objetoGiro = new TransformGroup();
		objetoGiro.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objetoRaiz.addChild(objetoGiro);
		//aqui se crea el color de la figura
		Appearance AparienciaRoja = new Appearance();
		Color3f rojo = new Color3f(Color.RED);
		ColoringAttributes eso = new ColoringAttributes();
		eso.setColor(rojo);
		AparienciaRoja.setColoringAttributes(eso);
		
		logico.Prisma pris = CentroEstudios.getPrismaAhora();
		//dependiendo la instancia de la prisma se creara la figura
		if(pris instanceof Cuadrado) {
			float alt = pris.getAlto();
			float anch = pris.getBaseMedio();
			float pro = ((Cuadrado) pris).getProfundido();
			Box cuadr = new Box(alt,anch,pro,AparienciaRoja);
			objetoGiro.addChild(cuadr);
			
		}
		else if(pris instanceof Rectangulo) {
			float alt = pris.getAlto();
			float anch = pris.getBaseMedio();
			float pro = ((Rectangulo) pris).getProfundo();
			Box rect = new Box(alt,anch,pro,AparienciaRoja);
			objetoGiro.addChild(rect);
		}
		else if(pris instanceof Triangulo) {
			float alt = pris.getAlto();
			float base = pris.getBaseMedio();
			Cone tiangu = new Cone(alt,base,AparienciaRoja);
			objetoGiro.addChild(tiangu);
		}
		else if(pris instanceof Esfera) {
			float alt = pris.getAlto();
			Sphere esf = new Sphere(alt,AparienciaRoja);
			objetoGiro.addChild(esf);
		}
		else if(pris instanceof Cilindro) {
			float alt = pris.getAlto();
			float anch = pris.getBaseMedio();
			Cylinder cili = new Cylinder(alt,anch,AparienciaRoja);
			objetoGiro.addChild(cili);
		}
		//hacer que el objeto rote 
		Alpha rotacionAlpha = new Alpha(-1,1000);
		RotationInterpolator rotacion = new RotationInterpolator(rotacionAlpha, objetoGiro);
		rotacion.setSchedulingBounds(new BoundingSphere());
		
		objetoRaiz.addChild(rotacion);
		return objetoRaiz;
		
	}
}