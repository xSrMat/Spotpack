package Spotpack.utils.fontRenderer;

import java.awt.Color;
import java.util.Locale;

import Spotpack.gui.MinecraftInterface;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class FixedFontRenderer implements MinecraftInterface {
   private static final int[] colorCodes = new int[]{0, 170, 43520, 43690, 11141120, 11141290, 16755200, 11184810, 5592405, 5592575, 5635925, 5636095, 16733525, 16733695, 16777045, 16777215, 42, 10752, 10794, 2752512, 2752554, 2763264, 2763306, 1381653, 1381695, 1392405, 1392447, 4134165, 4134207, 4144917, 4144959};
   private static ResourceLocation font = new ResourceLocation("Spotpack/ascii.png");

   public static void drawStringWithShadow(String text, float x, float y, float size, int color) {
      drawString(text, x + size / 8.0F, y + size / 8.0F, size, (new Color(color, true)).darker().darker().darker().darker().getRGB());
      drawString(text, x, y, size, color);
   }

   public static void drawString(String text, float x, float y, float size, int color) {
      float red = (float)(color >> 16 & 255) / 255.0F;
      float green = (float)(color >> 8 & 255) / 255.0F;
      float blue = (float)(color & 255) / 255.0F;
      float alpha = (float)(color >> 24 & 255) / 255.0F;
      GlStateManager.pushMatrix();
      GlStateManager.scale(size / 8.0F, size / 8.0F, size / 8.0F);
      GlStateManager.color(red, green, blue, alpha);
      if (y % 0.5F == 0.0F) {
         y += mc.gameSettings.ofFastRender ? 0.0F : 0.1F;
      }

      x /= size / 8.0F;
      y /= size / 8.0F;
      float offset = 0.0F;

      for(int i = 0; i < text.length(); ++i) {
         int characterIndex = text.charAt(i);
         if (characterIndex == 167 && i + 1 < text.length()) {
            int l = "0123456789abcdefklmnor".indexOf(text.toLowerCase(Locale.ENGLISH).charAt(i + 1));
            if (l < 16) {
               if (l < 0 || l > 15) {
                  l = 15;
               }

               int i2 = colorCodes[l];
               red = (float)((i2 >> 16) / 255);
               green = (float)((i2 >> 8 & 255) / 255);
               blue = (float)((i2 & 255) / 255);
               GlStateManager.color(red, green, blue, alpha);
            }

            ++i;
         } else {
            mc.getTextureManager().bindTexture(font);
            GlStateManager.enableTexture2D();
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.alphaFunc(516, 0.0F);
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            Gui.drawModalRectWithCustomSizedTexture(x + offset, y, (float)(characterIndex % 16 * 8), (float)(characterIndex / 16 * 8), 7.9F, 7.9F, 128.0F, 128.0F);
            offset += mc.fontRendererObj.getCharWidthNoUnicode((char)characterIndex);
         }
      }

      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.popMatrix();
   }

   public static void drawImage(ResourceLocation image, double x, double y, double imageX, double imageY, double renderWidth, double renderHeight, double width, double height, double imageWidth, double imageHeight) {
      GlStateManager.enableAlpha();
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.alphaFunc(516, 0.0F);
      mc.getTextureManager().bindTexture(image);
      double f = 1.0D / width;
      double f2 = 1.0D / height;
      Tessellator tessellator = Tessellator.getInstance();
      WorldRenderer worldrenderer = tessellator.getWorldRenderer();
      worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
      worldrenderer.pos(x, y + imageHeight, 0.0D).tex(imageX * f, (imageY + renderHeight) * f2).endVertex();
      worldrenderer.pos(x + imageWidth, y + imageHeight, 0.0D).tex((imageX + renderWidth) * f, (imageY + renderHeight) * f2).endVertex();
      worldrenderer.pos(x + imageWidth, y, 0.0D).tex((imageX + renderWidth) * f, imageY * f).endVertex();
      worldrenderer.pos(x, y, 0.0D).tex(imageX * f, imageY * f2).endVertex();
      tessellator.draw();
      GlStateManager.disableBlend();
      GlStateManager.disableAlpha();
   }

   public static float getStringWidth(String text, float size) {
      float width = 0.0F;

      for(int i = 0; i < text.length(); ++i) {
         int characterIndex = text.charAt(i);
         if (characterIndex == 167 && i + 1 < text.length()) {
            ++i;
         } else {
            width += mc.fontRendererObj.getCharWidthNoUnicode((char)characterIndex) * size / 8.0F;
         }
      }

      return width;
   }
}
