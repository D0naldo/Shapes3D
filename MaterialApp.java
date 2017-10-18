/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java3DD;

/**
 *
 * @author edwin
 */

import java.applet.Applet;
import java.awt.BorderLayout;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class MaterialApp extends Applet {

  TransformGroup createTG(float x, float y, float z) {
    Vector3f position = new Vector3f(x, y, z);
    Transform3D translate = new Transform3D();
    translate.set(position);
    TransformGroup trans1 = new TransformGroup(translate);
    return trans1;
  }

  Appearance createMatAppear(Color3f dColor, Color3f sColor, float shine) {

    Appearance appear = new Appearance();
    Material material = new Material();
    material.setDiffuseColor(dColor);
    material.setSpecularColor(sColor);
    material.setShininess(shine);
    appear.setMaterial(material);

    return appear;
  }

  public MaterialApp() {
    setLayout(new BorderLayout());
    Canvas3D c = new Canvas3D(null);
    add("Center", c);

    Color3f white = new Color3f(1.0f, 1.0f, 1.0f);
    Color3f blue = new Color3f(0.0f, 0.0f, 1.0f);

    BranchGroup scene = new BranchGroup();

    TransformGroup trans11 = createTG(-0.7f, 0.7f, -0.5f);
    scene.addChild(trans11);
    trans11.addChild(new Sphere(0.3f, Sphere.GENERATE_NORMALS, 60,
        createMatAppear(blue, white, 0.0f)));

    TransformGroup trans12 = createTG(0.0f, 0.7f, -0.5f);
    scene.addChild(trans12);
    trans12.addChild(new Sphere(0.3f, Sphere.GENERATE_NORMALS, 60,
        createMatAppear(blue, white, 1.0f)));

    TransformGroup trans13 = createTG(0.7f, 0.7f, -0.5f);
    scene.addChild(trans13);
    trans13.addChild(new Sphere(0.3f, Sphere.GENERATE_NORMALS, 60,
        createMatAppear(blue, white, 2.0f)));

    TransformGroup trans21 = createTG(-0.7f, 0.0f, -0.5f);
    scene.addChild(trans21);
    trans21.addChild(new Sphere(0.3f, Sphere.GENERATE_NORMALS, 60,
        createMatAppear(blue, white, 5.0f)));

    TransformGroup trans22 = createTG(0.0f, 0.0f, -0.5f);
    scene.addChild(trans22);
    trans22.addChild(new Sphere(0.3f, Sphere.GENERATE_NORMALS, 60,
        createMatAppear(blue, white, 10.0f)));

    TransformGroup trans23 = createTG(0.7f, 0.0f, -0.5f);
    scene.addChild(trans23);
    trans23.addChild(new Sphere(0.3f, Sphere.GENERATE_NORMALS, 60,
        createMatAppear(blue, white, 20.0f)));

    TransformGroup trans31 = createTG(-0.7f, -0.7f, -0.5f);
    scene.addChild(trans31);
    trans31.addChild(new Sphere(0.3f, Sphere.GENERATE_NORMALS, 60,
        createMatAppear(blue, white, 50.0f)));

    TransformGroup trans32 = createTG(0.0f, -0.7f, -0.5f);
    scene.addChild(trans32);
    trans32.addChild(new Sphere(0.3f, Sphere.GENERATE_NORMALS, 60,
        createMatAppear(blue, white, 100.0f)));

    TransformGroup trans33 = createTG(0.7f, -0.7f, -0.5f);
    scene.addChild(trans33);
    trans33.addChild(new Sphere(0.3f, Sphere.GENERATE_NORMALS, 60,
        createMatAppear(blue, white, 1000.0f)));

    AmbientLight lightA = new AmbientLight();
    lightA.setInfluencingBounds(new BoundingSphere());
    scene.addChild(lightA);

    DirectionalLight lightD1 = new DirectionalLight();
    lightD1.setInfluencingBounds(new BoundingSphere());
    Vector3f direction = new Vector3f(-1.0f, -1.0f, -1.0f);
    direction.normalize();
    lightD1.setDirection(direction);
    lightD1.setColor(new Color3f(1.0f, 1.0f, 1.0f));
    scene.addChild(lightD1);

    Background background = new Background();
    background.setApplicationBounds(new BoundingSphere());
    background.setColor(1.0f, 1.0f, 1.0f);
    scene.addChild(background);

    SimpleUniverse u = new SimpleUniverse(c);

    // This will move the ViewPlatform back a bit so the
    // objects in the scene can be viewed.
    u.getViewingPlatform().setNominalViewingTransform();

    // setLocalEyeViewing
    u.getViewer().getView().setLocalEyeLightingEnable(true);

    u.addBranchGraph(scene);
  }

  public static void main(String argv[]) {
    new MainFrame(new MaterialApp(), 256, 256);
  }
}



         
