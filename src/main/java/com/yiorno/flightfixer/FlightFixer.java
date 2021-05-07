package com.yiorno.flightfixer;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class FlightFixer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("フライ修正が起動しました");
        //getServer().getPluginManager().registerEvents(this, this);

        BukkitScheduler scheduler = getServer().getScheduler();
        ((BukkitScheduler) scheduler).scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                checkFlying c = new checkFlying();
                c.checkFlying();
            }
        }, 0L, 20L);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
