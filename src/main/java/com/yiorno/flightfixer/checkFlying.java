package com.yiorno.flightfixer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class checkFlying {

    public void checkFlying() {

        for (Player player : Bukkit.getOnlinePlayers()) {

            Boolean isStaff = player.hasPermission("mofucraft.staff");
            Boolean isMoFlight = player.hasPermission("mofucraft.member.flight.now");
            Boolean isFlight = player.getAllowFlight();

            //スタッフ
            if(isStaff){
                return;
            }

            //フライトを購入しているプレイヤー
            if(isMoFlight){
                player.setAllowFlight(true);
                return;
            }

            //飛べないプレイヤー
            if(!isFlight){
                return;
            }

            //スタッフではなく、フライトを購入しておらず、飛べるプレイヤー
            player.setAllowFlight(false);
            getLogger().info(player + "の飛行状態を修正しました");

            for (Player staff : Bukkit.getOnlinePlayers()) {

                if (isStaff){

                    player.sendMessage(ChatColor.GRAY + "" + player + "の飛行状態を修正しました");

                }

            }

        }
    }

}
