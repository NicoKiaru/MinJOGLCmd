package eu.kiaru.ij;

import static com.jogamp.opengl.GL.GL_COLOR_BUFFER_BIT;
import static com.jogamp.opengl.GL.GL_DEPTH_BUFFER_BIT;
import static com.jogamp.opengl.GL.GL_RENDERER;
import static com.jogamp.opengl.GL.GL_VENDOR;
import static com.jogamp.opengl.GL.GL_VERSION;

import com.jogamp.newt.Display;
import com.jogamp.newt.NewtFactory;
import com.jogamp.newt.Screen;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;

public class JOGLWindowTest { //implements GLEventListener {

	int SIZE_X=300;
	int SIZE_Y=300;
	final public static int SCREEN_IDX=0;
	
    GLWindow glWindow;
	
	public JOGLWindowTest() {

        Display display = NewtFactory.createDisplay(null);
        Screen screen = NewtFactory.createScreen(display, SCREEN_IDX);
        GLProfile glProfile = GLProfile.get(GLProfile.GL2);
        
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        glWindow = GLWindow.create(screen, glCapabilities);
        assert glWindow != null;
        glWindow.setUndecorated(false);
        glWindow.setAlwaysOnTop(false);
        glWindow.setFullscreen(false);
        glWindow.setPointerVisible(true);
        glWindow.confinePointer(false);
        glWindow.setTitle("JOGLWindowTest");
        glWindow.setSize(SIZE_X, SIZE_Y);
        glWindow.setVisible(true);
        //glWindow.addGLEventListener(this);
	}
	
	//@Override
    public final void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL().getGL2();
        // Nothing particular in this test
    }

	//@Override
	public void display(GLAutoDrawable drawable) {
        GL2 gl2 = drawable.getGL().getGL2();
		// TODO Auto-generated method stub
		gl2.glViewport(0, 0, SIZE_X, SIZE_Y);
        // Clear color buffer with a random color each time display is called
        gl2.glClearColor((float)java.lang.Math.random(), (float)java.lang.Math.random(), (float)java.lang.Math.random(), 1f);
        gl2.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}

	//@Override
	public void dispose(GLAutoDrawable drawable) {
        GL gl = drawable.getGL().getGL2();
        assert end(gl);
	}

    //@Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL().getGL2();
        SIZE_X=width;
        SIZE_Y=height;
        gl.glViewport(0, 0, SIZE_X, SIZE_Y);
    }

    protected boolean begin(GL gl) {
        GL2 gl2 = (GL2) gl;
        boolean validated = true;
        System.out.println("Vendor " + gl2.glGetString(GL_VENDOR));
        System.out.println("Renderer " + gl2.glGetString(GL_RENDERER));
        System.out.println("Version " + gl2.glGetString(GL_VERSION));
        return validated;
    }
    
    protected boolean end(GL gl) {
        GL2 gl2 = (GL2) gl;
        return true;
    }
    
}
