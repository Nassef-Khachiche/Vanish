package cmdexe.Nassef;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class VanishCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        List<Player> vanishedPlayers = new ArrayList<>();
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Plugin plugin = (Plugin) sender;
                if (player.isOp()) {
                    // will unvanish after typing again
                    if (cmd.getName().equalsIgnoreCase("vanish")) {
                        if (vanishedPlayers.contains(player)) {
                            vanishedPlayers.remove(player);
                            for (Player target : Bukkit.getOnlinePlayers()) {
                                target.showPlayer(plugin,player);
                            }
                            player.sendMessage(ChatColor.BOLD + "Vanished!");
                        } else {
                            vanishedPlayers.add(player);
                            for (Player target : Bukkit.getOnlinePlayers()) {
                                target.hidePlayer(plugin, player);
                            }
                            player.sendMessage(ChatColor.BOLD + "Unvanished!");
                        }
                    }
                }
            }
    return false;
    }
}
