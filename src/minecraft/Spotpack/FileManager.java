package Spotpack;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class FileManager {
   private static Gson gson = new Gson();
   private static File ROOT_DIR = new File("Spotpack");
   public static File MODS_DIR;

   static {
      MODS_DIR = new File(ROOT_DIR, "Mods");
   }

   public static void init() {
      if (!ROOT_DIR.exists()) {
         ROOT_DIR.mkdirs();
      }

      if (!MODS_DIR.exists()) {
         MODS_DIR.mkdirs();
      }

   }

   public static Gson getGson() {
      return gson;
   }

   public static File getRootDirectory() {
      return ROOT_DIR;
   }

   public static File getModsDirectory() {
      return MODS_DIR;
   }

   public static boolean writeJsonToFile(File file, Object obj) {
      try {
         if (!file.exists()) {
            file.createNewFile();
         }

         FileOutputStream outputStream = new FileOutputStream(file);
         outputStream.write(gson.toJson(obj).getBytes());
         outputStream.flush();
         outputStream.close();
         return true;
      } catch (IOException var3) {
         var3.printStackTrace();
         return false;
      }
   }

   public static <T> T readFromJson(File file, Class<T> c) {
      try {
         FileInputStream inputStream = new FileInputStream(file);
         InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
         BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
         StringBuilder builder = new StringBuilder();

         String line;
         while((line = bufferedReader.readLine()) != null) {
            builder.append(line);
         }

         bufferedReader.close();
         inputStreamReader.close();
         inputStream.close();
         return gson.fromJson(builder.toString(), c);
      } catch (IOException var7) {
         var7.printStackTrace();
         return null;
      }
   }

   public static <T> T readFromJson(File file, Type type) {
      try {
         FileInputStream inputStream = new FileInputStream(file);
         InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
         BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
         StringBuilder builder = new StringBuilder();

         String line;
         while((line = bufferedReader.readLine()) != null) {
            builder.append(line);
         }

         bufferedReader.close();
         inputStreamReader.close();
         inputStream.close();
         return gson.fromJson(builder.toString(), type);
      } catch (IOException var7) {
         var7.printStackTrace();
         return null;
      }
   }
}
