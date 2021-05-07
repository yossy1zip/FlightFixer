package com.yiorno.flightfixer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class checkFlying {

    public void checkFlying() {

        for (Player player : Bukkit.getOnlinePlayers()) {

            Boolean isStaff = player.hasPermission("mofucraft.staff");
            Boolean isFlight = player.hasPermission("mofucraft.member.flight.now");
            Boolean isAlloewdFlight = player.getAllowFlight();

            if ((isStaff == false) && (isFlight == false) && (isAlloewdFlight == true)){

                player.setAllowFlight(false);
                getLogger().info(player + "の飛行状態を修正しました");

                for (Player staff : Bukkit.getOnlinePlayers()) {

                    Boolean isStaff2 = staff.hasPermission("mofucraft.staff");

                    if (isStaff == true){

                        player.sendMessage(ChatColor.GRAY + "" + player + "の飛行状態を修正しました");

                    }

                }

            }

        }
    }

}
