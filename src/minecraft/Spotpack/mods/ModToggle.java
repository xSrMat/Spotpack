package Spotpack.mods;

import Spotpack.FileManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import net.minecraft.client.Minecraft;

public class ModToggle {
   private static final Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
   private static Minecraft mc = Minecraft.getMinecraft();

   public static File getFolder(Mod mod) {
      File file = new File("Spotpack");
      file.mkdirs();
      return file;
   }

   public static void saveEnabled(Mod... mods) throws IOException {
      Mod[] var4 = mods;
      int var3 = mods.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Mod mod = var4[var2];
         System.out.println("Saving mod: " + mod.getClass().getSimpleName().split("Mod")[1]);
         File file = new File(new File(mc.mcDataDir, "Folder" + File.separator + File.separator + "Mods" + File.separator + mod.getClass().getSimpleName().replace("Mod", "").replaceAll("\\d+", "")), "enabled.json");
         file.getParentFile().mkdirs();
         file.createNewFile();
         boolean isEnabled = mod.isEnabled;
         FileWriter writer = new FileWriter(file);
         writer.write(gson.toJson(isEnabled));
         writer.close();
      }

   }

   public static void loadEnabled(Mod... mods) throws FileNotFoundException {
      Mod[] var4 = mods;
      int var3 = mods.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Mod mod = var4[var2];
         File file = new File(new File(mc.mcDataDir, "Folder" + File.separator + File.separator + "Mods" + File.separator + mod.getClass().getSimpleName().replace("Mod", "").replaceAll("\\d+", "")), "enabled.json");
         mod.isEnabled = (Boolean)gson.fromJson(new FileReader(file), Boolean.TYPE);
      }

   }

   public static void saveDoubleToFile(Mod mod, Double b) {
      FileManager.writeJsonToFile(new File(getFolder(mod), "Double.json"), b);
   }

   public static Double loadDoubleFromFile(Mod mod) {
      Double b = (Double)FileManager.readFromJson(new File(getFolder(mod), "Double.json"), Double.class);
      if (b == null) {
         b = 1.0D;
         saveDoubleToFile(mod, b);
      }

      return b;
   }
}
