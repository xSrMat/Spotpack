package Spotpack;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class DiscordRP {
   private boolean running = true;
   private long created = 0L;

   public void start() {
      this.created = System.currentTimeMillis();
      DiscordEventHandlers handlers = (new DiscordEventHandlers.Builder()).setReadyEventHandler(new ReadyCallback() {
         public void apply(DiscordUser user) {
            System.out.println("Websome " + user.username + "#" + user.discriminator + ".");
            DiscordRP.this.update("Playing Minecraft 1.8.9", "");
         }
      }).build();
      DiscordRPC.discordInitialize("875766706985926698", handlers, true);
      (new Thread("Discord RPC Callback") {
         public void run() {
            while(DiscordRP.this.running) {
               DiscordRPC.discordRunCallbacks();
            }

         }
      }).start();
   }

   public void shutdown() {
      this.running = false;
      DiscordRPC.discordShutdown();
   }

   public void update(String firstLine, String secondLine) {
      DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
      b.setBigImage("large", "Spotpack");
      b.setDetails(firstLine);
      b.setStartTimestamps(this.created);
      DiscordRPC.discordUpdatePresence(b.build());
   }
}
