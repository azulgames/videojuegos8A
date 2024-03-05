package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    public Spatial spatial_var = null;
    public Spatial sol_spatial = null;
    public Spatial luna_spatial = null;
    public Spatial tierra_spatial = null;
    public Spatial marte_spatial = null;
    public Spatial jupiter_spatial = null;
    public Spatial neptuno_spatial = null;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        

    
    
        Node padre_cubo = new Node("padre_cubo");
        Box b = new Box(1, 1, 1);
        
        Sphere sphere = new Sphere(32, 32, 1);
        Geometry sol_geom = new Geometry("sol_geom", sphere);
        
        Sphere luna_sphere = new Sphere(32, 32, 0.5f); 
        Geometry luna_geom = new Geometry("luna_geom", luna_sphere);

        Sphere tierra_sphere = new Sphere(32, 32, 0.8f); 
        Geometry tierra_geom = new Geometry("tierra_geom", tierra_sphere);

        Sphere marte_sphere = new Sphere(32, 32, 0.6f); 
        Geometry marte_geom = new Geometry("marte_geom", marte_sphere);

        Sphere jupiter_sphere = new Sphere(32, 32, 1.2f);
        Geometry jupiter_geom = new Geometry("jupiter_geom", jupiter_sphere);

        Sphere neptuno_sphere = new Sphere(32, 32, 0.9f);
        Geometry neptuno_geom = new Geometry("neptuno_geom", neptuno_sphere);

        
        
        Material mat_yellow = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_yellow.setTexture("ColorMap", assetManager.loadTexture("Textures/sol_texture.jpg"));
    
        Material mat_gray = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_gray.setTexture("ColorMap", assetManager.loadTexture("Textures/luna_texture.jpg"));

        Material mat_blue = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_blue.setTexture("ColorMap", assetManager.loadTexture("Textures/tierra_texture.jpg"));

        Material mat_red = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_red.setTexture("ColorMap", assetManager.loadTexture("Textures/marte_texture.jpg"));

        Material mat_brown = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_brown.setTexture("ColorMap", assetManager.loadTexture("Textures/jupiter_texture.jpg"));

        Material mat_cyan = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_cyan.setTexture("ColorMap", assetManager.loadTexture("Textures/neptuno_texture.jpg"));
        
        sol_geom.setMaterial(mat_yellow);
        luna_geom.setMaterial(mat_gray);
        tierra_geom.setMaterial(mat_blue);
        marte_geom.setMaterial(mat_red);
        jupiter_geom.setMaterial(mat_brown);
        neptuno_geom.setMaterial(mat_cyan);
        
        padre_cubo.attachChild(luna_geom);
        padre_cubo.attachChild(sol_geom);
        padre_cubo.attachChild(tierra_geom);
        padre_cubo.attachChild(marte_geom);
        padre_cubo.attachChild(jupiter_geom);
        padre_cubo.attachChild(neptuno_geom);
        
        
        luna_geom.move(4, 1, 0);
        luna_geom.scale(0.3f);  
        
        tierra_geom.move(6,0,3);
        
        marte_geom.scale(0.6f);
        marte_geom.move(7,0,5);
        
        jupiter_geom.scale(1.0f);
        jupiter_geom.move(9,1,6);
        
        neptuno_geom.scale(0.9f);
        neptuno_geom.move(13,0,8);
        
        rootNode.attachChild(padre_cubo);
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        if(spatial_var == null){
            spatial_var = rootNode.getChild("padre_cubo");
            sol_spatial = rootNode.getChild("sol_geom");
            luna_spatial = rootNode.getChild("luna_geom");
            tierra_spatial = rootNode.getChild("tierra_geom");
            marte_spatial = rootNode.getChild("marte_geom");
            jupiter_spatial = rootNode.getChild("jupiter_geom");
            neptuno_spatial = rootNode.getChild("neptuno_geom");
        }
        
        spatial_var.rotate(0, tpf/7, 0);
        
        sol_spatial.rotate(0, -(tpf/3), 0);
        luna_spatial.rotate(0, tpf*0.8f, 0);
        tierra_spatial.rotate(0,tpf,0);
        marte_spatial.rotate(0, tpf/2, 0);
        neptuno_spatial.rotate(0, tpf/5, 0);
        jupiter_spatial.rotate(0, tpf*2, 0);
        
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        
    }
}