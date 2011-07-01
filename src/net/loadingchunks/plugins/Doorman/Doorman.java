
package net.loadingchunks.plugins.Doorman;

import java.io.File;
import java.util.HashMap;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.util.config.Configuration;

/**
 * GuardWolf Ban System plugin for Bukkit
 *
 * @author Cue
 */
public class Doorman extends JavaPlugin {
	public final HashMap<String, String> dmConfig = new HashMap<String, String>();
	private final DWPlayerListener playerListener = new DWPlayerListener(this);

    public void onDisable() {
        System.out.println("[DOORMAN] Disabled.");
    }

    public void onEnable() {        
        // Register events
        
        PluginManager pm = getServer().getPluginManager();
        
        pm.registerEvent(Event.Type.PLAYER_KICK, playerListener, Priority.Lowest, this);
        
        // Get the config.
        
        System.out.println("Loading config file plugins/Doorman/config.yml...");
        Configuration _config = new Configuration(new File("plugins/Doorman/config.yml"));
        
        _config.load();
        
        System.out.println("Loaded Doorman Config Successfully!");
        
        dmConfig.put("msg_fly", (_config.getString("dm.msg.fly") != null) ? _config.getString("dm.msg.fly") : "Flying is not enabled on this server");
        dmConfig.put("msg_long", (_config.getString("dm.msg.slowlogin") != null) ? _config.getString("dm.msg.slowlogin") : "Took too long to log in");
        dmConfig.put("msg_outdated_server", (_config.getString("dm.msg.outdated.server") != null) ? _config.getString("dm.msg.outdated.server") : "Outdated server!");
        dmConfig.put("msg_outdated_client", (_config.getString("dm.msg.outdated.client") != null) ? _config.getString("dm.msg.outdated.client") : "Outdated client!");
        dmConfig.put("msg_protocol", (_config.getString("dm.msg.protocol_error") != null) ? _config.getString("dm.msg.protocol_error") : "Protocol error!");
        
        System.out.println("Doorman Config saved to memory.");

        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }
}
