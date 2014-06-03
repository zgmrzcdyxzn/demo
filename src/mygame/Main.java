package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);
    /** Uses Texture from jme3-test-data library! */
    ParticleEmitter fireEffect = new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 30);
    Material fireMat = new Material(assetManager, "Common/MatDefs/Misc/Particle.j3md");
    //fireMat.setTexture("Texture", assetManager.loadTexture("Effects/Explosion/flame.png"));
    fireEffect.setMaterial(fireMat);
    fireEffect.setImagesX(2); fireEffect.setImagesY(2); // 2x2 texture animation
    fireEffect.setEndColor( new ColorRGBA(1f, 0f, 0f, 1f) );   // red
    fireEffect.setStartColor( new ColorRGBA(1f, 1f, 0f, 0.5f) ); // yellow
    fireEffect.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 2, 0));
    fireEffect.setStartSize(0.6f);
    fireEffect.setEndSize(0.1f);
    fireEffect.setGravity(0f,0f,0f);
    fireEffect.setLowLife(0.5f);
    fireEffect.setHighLife(3f);
    fireEffect.getParticleInfluencer().setVelocityVariation(0.3f);
    rootNode.attachChild(fireEffect);

        rootNode.attachChild(geom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
