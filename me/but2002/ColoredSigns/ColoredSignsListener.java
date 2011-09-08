package me.but2002.ColoredSigns;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.SignChangeEvent;

public class ColoredSignsListener extends BlockListener{
	
	ColoredSigns plugin;
	public ColoredSignsListener(ColoredSigns instance){
		plugin = instance;
	}
	
	public void onSignChange(SignChangeEvent event) {
		
		if(!permissionsCheck(event.getPlayer(), "ColoredSigns.use"))
			return;
		
		String[] text = event.getLines();
		for(int i = 0; i < text.length; i++){
			text[i] = text[i].replaceAll("&", "¤");
			text[i] = text[i].replaceAll("¤¤", "&");
			event.setLine(i, text[i]);
		}
	}//end onSignChange()
	
	public boolean permissionsCheck(Player player, String node){		
		if( plugin.permissionHandler == null ){
			if( player.isOp() )
				return true;
		}
		
		else{
			if( plugin.permissionHandler.has(player, node) )
				return true;
		}

		return false;
	}//end permissionsTester()

}//end ColoredSignsListener
