package Spotpack.gui.hud;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.Sets;

import Spotpack.event.EventManager;
import Spotpack.event.EventTarget;
import Spotpack.event.impl.RenderEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;

public class HUDManager {
   private static HUDManager instance = null;
   private Set<IRenderer> registeredRenderers = Sets.newHashSet();
   private Minecraft mc = Minecraft.getMinecraft();

   private HUDManager() {
   }

   public static HUDManager getInstance() {
      if (instance != null) {
         return instance;
      } else {
         instance = new HUDManager();
         EventManager.register(instance);
         return instance;
      }
   }

   public void register(IRenderer... renderers) {
      IRenderer[] var5 = renderers;
      int var4 = renderers.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         IRenderer renderer = var5[var3];
         this.registeredRenderers.add(renderer);
      }

   }

   public void unregister(IRenderer... renderers) {
      IRenderer[] var5 = renderers;
      int var4 = renderers.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         IRenderer renderer = var5[var3];
         this.registeredRenderers.remove(renderer);
      }

   }

   public Collection<IRenderer> getRegisteredRenderers() {
      return Sets.newHashSet(this.registeredRenderers);
   }

   public void displayConfigScreen() {
      this.mc.displayGuiScreen(new HUDConfigScreen(this));
   }

   @EventTarget()
   public void onRender(RenderEvent e) {
      if (this.mc.currentScreen == null || this.mc.currentScreen instanceof GuiChat) {
         if (this.mc.gameSettings.showDebugProfilerChart) {
            return;
         }

         Iterator var3 = this.registeredRenderers.iterator();

         while(var3.hasNext()) {
            IRenderer renderer = (IRenderer)var3.next();
            this.callRenderer(renderer);
         }
      }

   }

   private void callRenderer(IRenderer renderer) {
      if (renderer.isEnabled()) {
         ScreenPosition pos = renderer.load();
         if (pos == null) {
            pos = ScreenPosition.fromRelativePosition(0.5D, 0.5D);
         }

         renderer.render(pos);
      }
   }
}
