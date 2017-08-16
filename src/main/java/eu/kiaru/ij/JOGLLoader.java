package eu.kiaru.ij;

import java.util.concurrent.ExecutionException;

import net.imagej.ImageJ;

public class JOGLLoader {
	
	private static boolean NativesHaveBeenLoaded=false;	

	private static final String groovyScriptLoadJOGL_GL2 = 
		"import com.jogamp.newt.NewtFactory \n"+
		"import com.jogamp.newt.opengl.GLWindow \n"+
		"import com.jogamp.opengl.GL \n"+
		"import com.jogamp.opengl.GL2 \n"+
		"import com.jogamp.opengl.GLAutoDrawable \n"+
		"import com.jogamp.opengl.GLCapabilities \n"+
		"import com.jogamp.opengl.GLProfile \n"+
		"glProfile = GLProfile.get(GLProfile.GL2) \n"+
		"glCapabilities = new GLCapabilities(glProfile) \n";
	
	public static void LoadNatives_GL2() {
		if (!NativesHaveBeenLoaded) {
			//Natives have not been loaded...
			//Groovy script hack!
			// -> this execution manages to load correclty JOGL natives
			try {    			
		        (new ImageJ()).script().run("foo.groovy", groovyScriptLoadJOGL_GL2, true).get();
		        NativesHaveBeenLoaded=true;
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// End of script execution, natives have been loaded
		} else {
			// Natives have already been loaded
		}
	}
}
