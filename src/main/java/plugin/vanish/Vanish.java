package plugin.vanish;

import com.google.common.graph.Network;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Vanish extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Vanish plugin enabled.");
    }

    List<Player> vanishedPlayers = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission()) {
            if (cmd.getName().equalsIgnoreCase("vanish")) {
                if (vanishedPlayers.contains(player)) {
                    vanishedPlayers.remove(player);
                    for (Player target : Bukkit.getOnlinePlayers()) {
                        target.showPlayer(player);
                    }
                    player.sendMessage(ChatColor.BOLD + "Vanished");
                } else {
                    vanishedPlayers.add(player);
                    for (Player target : Bukkit.getOnlinePlayers()) {
                        target.hidePlayer(player);
                    }
                    player.sendMessage(ChatColor.BOLD + "Unvanished");
                }
            }
            }
        }
        return false;
    }
}
