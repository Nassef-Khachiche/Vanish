package cmdexe.Nassef;

import org.bukkit.plugin.java.JavaPlugin;

public final class plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Enabled");

        getCommand("heal").setExecutor(new VanishCommand());
    }
}
