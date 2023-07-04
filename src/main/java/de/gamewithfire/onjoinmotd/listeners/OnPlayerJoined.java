package de.gamewithfire.onjoinmotd.listeners;

import de.gamewithfire.onjoinmotd.OnJoinMotd;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Listener Class for PlayerLoginEvent.
 * Responsible for sending Motd
 */
public class OnPlayerJoined implements Listener {
  private final FileConfiguration config;

  public OnPlayerJoined(OnJoinMotd plugin) {
    this.config = plugin.getConfig();
  }

  @EventHandler(priority = EventPriority.NORMAL)
  public void onPlayerLoginEvent(PlayerLoginEvent event) {
    event.getPlayer().sendMessage(NamedTextColor.GOLD + (String) config.get("motd"));
  }
}
