package cmdexe.Nassef;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Enabled");
//        Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
        getCommand("vanish").setExecutor(new VanishCommand());
    }
}
