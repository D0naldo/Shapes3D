/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java3DD;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.media.j3d.*;
import javax.media.j3d.BranchGroup;
import com.sun.j3d.utils.geometry.Sphere;
import java.awt.Color;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Material;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

/**
 *
 * @author leina
 */
public class Cubo_simple extends Applet {

    /**
     * @param args the command line arguments
     */
    public Cubo_simple() throws HeadlessException {
        super.setLayout(new BorderLayout());
        //definir configuracion se la pasas a canvas
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();

        //definir canvas y 
        Canvas3D ca = new Canvas3D(config);
        super.add("Center",ca);
        //defini universo
        SimpleUniverse su = new SimpleUniverse(ca);
        su.getViewingPlatform().setNominalViewingTransform();
        //definir elemento visible(escena)
        BranchGroup escena = new BranchGroup();
        // a mi universo agrego mi escena
        escena = cili();
        
        su.addBranchGraph(escena);
        
        

    }
    
    public  BranchGroup cubocolor(){
    BranchGroup micubo = new BranchGroup();
    micubo.addChild(new ColorCube(0.5));
    return micubo;
}
    public  BranchGroup cubocolor2(){
    BranchGroup root = new BranchGroup(); // agrupar 
    // crear el cubo
    ColorCube cb = new ColorCube(0.4);
    //Definir transformaciones y luego agruparlas y luego pasarlas al grupo de elelemnento visiblesvisibles 
    
    Transform3D rotar = new Transform3D();
    rotar.rotY(Math.toRadians(35));
    
    TransformGroup trnsform =new TransformGroup(rotar);//decirle que transformacion esta haciendo
        
        //estas se transformaciones se deven aplicar al cubo
        trnsform.addChild(cb);
        root.addChild(trnsform);
        root.compile();
    
    //root.addChild(new ColorCube(0.5));
    return root;
}
    
    public BranchGroup Sphera()
    {
        BranchGroup root = new BranchGroup();
        //definirle caracteristicas al objeto visible "as de luz" "textura" etc en un objeto se le conoce como apariencia
        Appearance apariencia = new Appearance();
        
        //Material del objeto en la apariencia
        Material material = new Material();
        material.setShininess(3.0f);
        apariencia.setMaterial(material);
        //crear el objeto y pasar la apariencia
        //Box caja = new Box(0.5f, 0.5f, 0.5f, apariencia);//el tamaño del cubo xD

        Sphere spp = new Sphere(0.7f, Sphere.GENERATE_NORMALS, 120,apariencia);
        
        //se crea la luz 0.0 
        Color3f colorluz = new Color3f(Color.CYAN);
        Vector3f dirluz =new Vector3f(-5f, -2.2f, -6.0f);//vect0r de direccion
        //se crea la luz a partir de sus definiciones, luz dirigida
        
        DirectionalLight direc = new  DirectionalLight(colorluz, dirluz);
         //Indicar que luz afecte al elemento la luz afecta a la caja
        direc.setInfluencingBounds(spp.getBounds());
        root.addChild(direc);//se agrega la luz
        
        Transform3D rotar = new Transform3D();
        rotar.rotX(Math.toRadians(35));
        TransformGroup transform = new TransformGroup(rotar);
        transform.addChild( spp);
        
        root.addChild(transform);
        root.compile();
        return root;
        
       
        
    }
    public BranchGroup conoo()
    {
        BranchGroup root = new BranchGroup();
        //definirle caracteristicas al objeto visible "as de luz" "textura" etc en un objeto se le conoce como apariencia
        Appearance apariencia = new Appearance();
        
        //Material del objeto en la apariencia
        Material material = new Material();
        material.setShininess(3.0f);
        apariencia.setMaterial(material);
        //crear el objeto y pasar la apariencia
        //Box caja = new Box(0.5f, 0.5f, 0.5f, apariencia);//el tamaño del cubo xD

        Cone spp = new Cone(0.5f, 1f,apariencia);
        
        //se crea la luz 0.0 
        Color3f colorluz = new Color3f(Color.CYAN);
        Vector3f dirluz =new Vector3f(1f, 1.2f, -6.0f);//vect0r de direccion
        //se crea la luz a partir de sus definiciones, luz dirigida
        
        DirectionalLight direc = new  DirectionalLight(colorluz, dirluz);
         //Indicar que luz afecte al elemento la luz afecta a la caja
        direc.setInfluencingBounds(spp.getBounds());
        root.addChild(direc);//se agrega la luz
        
        Transform3D rotar = new Transform3D();
        rotar.rotX(Math.toRadians(-20));
        TransformGroup transform = new TransformGroup(rotar);
        transform.addChild( spp);
        
        root.addChild(transform);
        root.compile();
        return root;
        
       
        
    }
    public BranchGroup cili()
    {
        BranchGroup root = new BranchGroup();
        //definirle caracteristicas al objeto visible "as de luz" "textura" etc en un objeto se le conoce como apariencia
        Appearance apariencia = new Appearance();
        
        //Material del objeto en la apariencia
        Material material = new Material();
        material.setShininess(3.0f);
        apariencia.setMaterial(material);
        //crear el objeto y pasar la apariencia
        //Box caja = new Box(0.5f, 0.5f, 0.5f, apariencia);//el tamaño del cubo xD

        Cylinder spp = new Cylinder(0.5f, 1f,apariencia);
        
        //se crea la luz 0.0 
        Color3f colorluz = new Color3f(Color.CYAN);
        Vector3f dirluz =new Vector3f(-5f, -2.2f, -6.0f);//vect0r de direccion
        //se crea la luz a partir de sus definiciones, luz dirigida
        
        DirectionalLight direc = new  DirectionalLight(colorluz, dirluz);
         //Indicar que luz afecte al elemento la luz afecta a la caja
        direc.setInfluencingBounds(spp.getBounds());
        root.addChild(direc);//se agrega la luz
        
        Transform3D rotar = new Transform3D();
        rotar.rotX(Math.toRadians(35));
        TransformGroup transform = new TransformGroup(rotar);
        transform.addChild( spp);
        
        root.addChild(transform);
        root.compile();
        return root;
        
       
        
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Cubo_simple r = new Cubo_simple();
        new MainFrame(r, 500, 600);  // crea frame

    }

}