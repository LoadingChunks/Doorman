package net.loadingchunks.plugins.Doorman;

import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerListener;

public class DWPlayerListener extends PlayerListener {
	private final Doorman plugin;
	
	public DWPlayerListener(Doorman plugin)
	{
		this.plugin = plugin;
	}
	
	public void onPlayerKick(PlayerKickEvent p)
	{
		if(p.getReason().equalsIgnoreCase("Flying is not enabled on this server") && this.plugin.dmConfig.get("msg_flying") != null)
		{
			p.setReason(this.plugin.dmConfig.get("msg_flying"));
			System.out.println("Telling them to stop flying...");
			return;
		}

		if(p.getReason().equalsIgnoreCase("Took too long to log in") && this.plugin.dmConfig.get("msg_long") != null)
		{
			p.setReason(this.plugin.dmConfig.get("msg_long"));
			System.out.println("That's a long login you've got there...");
			return;
		}
		
		if(p.getReason().equalsIgnoreCase("Outdated server!") && this.plugin.dmConfig.get("msg_outdated_server") != null)
		{
			p.setReason(this.plugin.dmConfig.get("msg_outdated_server"));
			System.out.println("lol outdated server.");
			return;
		}
		
		if(p.getReason().equalsIgnoreCase("Outdated client!") && this.plugin.dmConfig.get("msg_outdated_client") != null)
		{
			p.setReason(this.plugin.dmConfig.get("msg_outdated_client"));
			return;
		}
	}
}
