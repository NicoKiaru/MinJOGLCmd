This is an example Maven project implementing an ImageJ command, with a JOGL dependency.

This plugin show a minimal example for using JOGL dependency in an IJ Command.
It currently creates an error because of a conflict with the Java-8 update site.
It doesn't work within an update sites because the natives can't be found.
Where the problem exactly lies and how this should be solved ? 
* I don't know!

GAV used in the project : 

		<dependency>
      		<groupId>org.jogamp.gluegen</groupId>
      		<artifactId>gluegen-rt-main</artifactId>
    	</dependency>
    	<dependency>
      		<groupId>org.jogamp.jogl</groupId>
      		<artifactId>jogl-all-main</artifactId>
    	</dependency>
