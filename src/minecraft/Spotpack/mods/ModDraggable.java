package Spotpack.mods;

import java.io.File;

import Spotpack.FileManager;
import Spotpack.gui.hud.IRenderer;
import Spotpack.gui.hud.ScreenPosition;

public abstract class ModDraggable extends Mod implements IRenderer {
   protected ScreenPosition pos = this.loadPositionFromFile();

   public ScreenPosition load() {
      return this.pos;
   }

   public void save(ScreenPosition pos) {
      this.pos = pos;
      this.savePositionToFile();
   }

   private File getFolder() {
      File folder = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
      folder.mkdirs();
      return folder;
   }

   private void savePositionToFile() {
      FileManager.writeJsonToFile(new File(this.getFolder(), "pos.json"), this.pos);
   }

   private ScreenPosition loadPositionFromFile() {
      ScreenPosition loaded = (ScreenPosition)FileManager.readFromJson(new File(this.getFolder(), "pos.json"), ScreenPosition.class);
      if (loaded == null) {
         loaded = ScreenPosition.fromRelativePosition(0.5D, 0.5D);
         this.pos = loaded;
         this.savePositionToFile();
      }

      return loaded;
   }

   public final int getLineOffselt(ScreenPosition pos, int lineNum) {
      return pos.getAbsoluteY() + this.getLineOffset(lineNum);
   }

   private int getLineOffset(int lineNum) {
      return (this.font.FONT_HEIGHT + 3) * lineNum;
   }
}
