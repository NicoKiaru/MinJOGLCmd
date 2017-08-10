/*
 * To the extent possible under law, the ImageJ developers have waived
 * all copyright and related or neighboring rights to this tutorial code.
 *
 * See the CC0 1.0 Universal license for details:
 *     http://creativecommons.org/publicdomain/zero/1.0/
 */

package eu.kiaru.ij;

import net.imagej.ImageJ;
import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.ui.UIService;

/**
 * This plugin show a minimal example for using JOGL dependency in an IJ Command.
 * It currently creates an error because of a conflict with the Java-8 update site.
 * It doesn't work within an update sites because the natives can't be found.
 * Where the problem exactly lies and how this should be solved ? 
 * <p>
 * I don't know!
 * </p>
 */
@Plugin(type = Command.class, menuPath = "Plugins>MinJOGLIJCommand")
public class MinJOGLIJCommand implements Command {
    //
    // Parameters here
    //

    @Parameter
    private UIService uiService;

    @Override
    public void run() {
        uiService.show("Running MinJOGLIJCommand");
        // Creates a new JOGL window
        new JOGLWindowTest();
        uiService.show("A new JOGL window has appeared. It should change color randomly upon image resizing. Try it!");
    }
    
    /**
     * This main function serves for development purposes.
     * It allows you to run the plugin immediately out of
     * your integrated development environment (IDE).
     *
     * @param args whatever, it's ignored
     * @throws Exception
     */
    public static void main(final String... args) throws Exception {
        // create the ImageJ application context with all available services
        final ImageJ ij = new ImageJ();
        ij.ui().showUI();
        ij.command().run(MinJOGLIJCommand.class, true);
    }

}
