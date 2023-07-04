package de.gamewithfire.onjoinmotd.listeners;

import de.gamewithfire.onjoinmotd.OnJoinMotd;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Listener Class for PlayerLoginEvent.
 * Responsible for sending Motd
 */
public class OnPlayerJoined implements Listener {
  private final FileConfiguration config;

  public OnPlayerJoined(OnJoinMotd plugin) {
    this.config = plugin.getConfig();
  }

  /**
   * PlayerJoinEvent Listener.
   */
  @EventHandler(priority = EventPriority.NORMAL)
  public void onPlayerJoinEvent(PlayerJoinEvent event) {
    String motd = (String) config.get("motd");

    if (motd != null) {
      event.getPlayer().sendMessage(Component.text(motd, NamedTextColor.GOLD));
    }
  }
}
