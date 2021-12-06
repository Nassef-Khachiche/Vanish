package cmdexe.Nassef;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishCommand implements CommandExecutor {

    List<Player> vanishedPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.isOp()) {
                    // will do the oppisite
                    if (cmd.getName().equalsIgnoreCase("vanish")) {
                        if (vanishedPlayers.contains(player)) {
                            for (Player target : Bukkit.getOnlinePlayers()) {
                                target.showPlayer(player);
                            }
                            player.sendMessage(ChatColor.BOLD + "You are no longer hidden.");
                            vanishedPlayers.remove(player);
                        } else {
                            for (Player target : Bukkit.getOnlinePlayers()) {
                                target.hidePlayer(player);
                            }
                            player.sendMessage(ChatColor.BOLD + "You are hidden from other players.");
                            vanishedPlayers.add(player);
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.DARK_AQUA + "This Command is only for people who are operator.");
                }
            }
    return false;
    }
}
