package Spotpack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import Spotpack.event.EventManager;
import Spotpack.event.EventTarget;
import Spotpack.event.impl.ClientTickEvent;
import Spotpack.gui.hud.HUDManager;
import Spotpack.mods.Mod;
import Spotpack.mods.ModInstances;
import Spotpack.mods.ModToggle;
import net.minecraft.client.Minecraft;

public class Client {
   public List<Mod> mods;
   public static final File DEFAULT_DIRECTORY = new File(System.getProperty("user.home"), "Lehan Client");
   public static final File CONFIG;
   public static final Client INSTANCE = new Client();
   private FileManager fileManager;
   public static final File ACCOUNT;
   private DiscordRP discordRP = new DiscordRP();
   Minecraft mc;
   private HUDManager hudManager;

   static {
      CONFIG = new File(DEFAULT_DIRECTORY, "config.json");
      ACCOUNT = new File(DEFAULT_DIRECTORY, "account.txt");
      if (!DEFAULT_DIRECTORY.exists()) {
         DEFAULT_DIRECTORY.mkdirs();
      }

   }

   public static final Client getInstance() {
      return INSTANCE;
   }

   public void init() {
      this.discordRP.start();
      EventManager.register(this);
   }

   public void start() {
      this.hudManager = HUDManager.getInstance();
      ModInstances.register(this.hudManager);
      this.mods = ModInstances.mods;

      try {
         Iterator var2 = this.mods.iterator();

         while(var2.hasNext()) {
            Mod mod = (Mod)var2.next();
            ModToggle.loadEnabled(mod);
         }
      } catch (FileNotFoundException var3) {
         var3.printStackTrace();
      }

   }

   public void shutdown() {
      this.discordRP.shutdown();

      try {
         Iterator var2 = this.mods.iterator();

         while(var2.hasNext()) {
            Mod mod = (Mod)var2.next();
            ModToggle.saveEnabled(mod);
         }
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public DiscordRP getDiscordRP() {
      return this.discordRP;
   }

   /*@EventTarget
   public void onTick(ClientTickEvent e) {
      if (Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
         this.hudManager.displayConfigScreen();
      }

   }*/
}
