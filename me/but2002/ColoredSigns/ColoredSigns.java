package me.but2002.ColoredSigns;
import java.util.logging.Logger;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class ColoredSigns extends JavaPlugin
{
	private final ColoredSignsListener signListener = new ColoredSignsListener(this);
	Logger log = Logger.getLogger("Minecraft");
	PermissionHandler permissionHandler;
	String version = "2.0";
	
	public void onEnable(){ 
		setupPermissions();
		getServer().getPluginManager().registerEvent(Event.Type.SIGN_CHANGE, this.signListener, Event.Priority.Monitor, this); 
		log.info("ColoredSigns version " + version + " (by but2002 and insanj) has been enabled!");
	}

	public void onDisable(){
		log.info("ColoredSigns version " + version + " (by but2002 and insanj) has been disabled.");
	}
	
	private void setupPermissions() {
		if(permissionHandler != null) 
			return;

		Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");

		if (permissionsPlugin == null) {
			log.warning("ColoredSigns didn't find a permissions setup, and is defaulting to OP-only.");
			return;
		}

		permissionHandler = ((Permissions) permissionsPlugin).getHandler();
		log.info("ColoredSigns found a permissions system, and will use " + ((Permissions)permissionsPlugin).getDescription().getFullName() + "!");
	}//end setupPermissions()

}//end ColoredSings