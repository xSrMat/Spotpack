package Spotpack.mods;

import java.util.ArrayList;

import Spotpack.gui.hud.HUDManager;
import Spotpack.mods.impl.ModArmorStatus;
import Spotpack.mods.impl.ModCps;
import Spotpack.mods.impl.ModFPS;
import Spotpack.mods.impl.ModKeystrokes;
import Spotpack.mods.impl.ModPosition;
import Spotpack.mods.impl.ModPotionStatus;

public class ModInstances {
   public static ArrayList<Mod> mods = new ArrayList();
   private static ModFPS modFPS;
   private static ModPotionStatus modPotionStatus;
   private static ModCps modCps;
   private static ModPosition modPosition;
   private static ModKeystrokes modKeystrokes;
   private static ModArmorStatus modArmorStatus;

   public static void register(HUDManager api) {
      modFPS = new ModFPS();
      api.register(modFPS);
      mods.add(modFPS);
      modPotionStatus = new ModPotionStatus();
      api.register(modPotionStatus);
      mods.add(modPotionStatus);
      modCps = new ModCps();
      api.register(modCps);
      mods.add(modCps);
      modPosition = new ModPosition();
      api.register(modPosition);
      mods.add(modPosition);
      modKeystrokes = new ModKeystrokes();
      api.register(modKeystrokes);
      mods.add(modKeystrokes);
      modArmorStatus = new ModArmorStatus();
      api.register(modArmorStatus);
      mods.add(modArmorStatus);
   }

   public static ModFPS getModFPS() {
      return modFPS;
   }

   public static ModPotionStatus getModPotionStatus() {
      return modPotionStatus;
   }

   public static ModCps getModCps() {
      return modCps;
   }

   public static ModPosition getModPosition() {
      return modPosition;
   }

   public static ModKeystrokes getModKeystrokes() {
      return modKeystrokes;
   }

   public static ModArmorStatus getModArmorStatus() {
      return modArmorStatus;
   }
}
