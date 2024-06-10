package Spotpack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class Roundedutil {
   static final Minecraft mc = Minecraft.getMinecraft();
   static final FontRenderer fr;

   static {
      fr = mc.fontRendererObj;
   }

   public static void enableGL2D() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void disableGL2D() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static void drawSmoothRoundedRect(float x, float y, float x1, float y1, float radius, int color) {
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      x = (float)((double)x * 2.0D);
      y = (float)((double)y * 2.0D);
      x1 = (float)((double)x1 * 2.0D);
      y1 = (float)((double)y1 * 2.0D);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      setColor(color);
      GL11.glEnable(2848);
      GL11.glBegin(9);

      int i;
      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      GL11.glEnd();
      GL11.glBegin(2);

      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glLineWidth(1.0F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void drawRoundedRect(float x, float y, float x1, float y1, float radius, int color) {
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      x = (float)((double)x * 2.0D);
      y = (float)((double)y * 2.0D);
      x1 = (float)((double)x1 * 2.0D);
      y1 = (float)((double)y1 * 2.0D);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      setColor(color);
      GL11.glEnable(2848);
      GL11.glBegin(9);

      int i;
      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glEnable(3042);
      GL11.glPopAttrib();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void drawRoundedOutline(float x, float y, float x1, float y1, float radius, float lineWidth, int color) {
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      x = (float)((double)x * 2.0D);
      y = (float)((double)y * 2.0D);
      x1 = (float)((double)x1 * 2.0D);
      y1 = (float)((double)y1 * 2.0D);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      setColor(color);
      GL11.glEnable(2848);
      GL11.glLineWidth(lineWidth);
      GL11.glBegin(2);

      int i;
      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glLineWidth(1.0F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void drawSelectRoundedRect(float x, float y, float x1, float y1, float radius1, float radius2, float radius3, float radius4, int color) {
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      x = (float)((double)x * 2.0D);
      y = (float)((double)y * 2.0D);
      x1 = (float)((double)x1 * 2.0D);
      y1 = (float)((double)y1 * 2.0D);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      setColor(color);
      GL11.glEnable(2848);
      GL11.glBegin(9);

      int i;
      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x + radius1) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius1 * -1.0D, (double)(y + radius1) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius1 * -1.0D);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x + radius2) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius2 * -1.0D, (double)(y1 - radius2) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius2 * -1.0D);
      }

      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x1 - radius3) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius3, (double)(y1 - radius3) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius3);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x1 - radius4) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius4, (double)(y + radius4) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius4);
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glLineWidth(1.0F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void drawSelectRoundedOutline(float x, float y, float x1, float y1, float radius1, float radius2, float radius3, float radius4, float lineWidth, int color) {
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      x = (float)((double)x * 2.0D);
      y = (float)((double)y * 2.0D);
      x1 = (float)((double)x1 * 2.0D);
      y1 = (float)((double)y1 * 2.0D);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      setColor(color);
      GL11.glEnable(2848);
      GL11.glLineWidth(lineWidth);
      GL11.glBegin(2);

      int i;
      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x + radius1) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius1 * -1.0D, (double)(y + radius1) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius1 * -1.0D);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x + radius2) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius2 * -1.0D, (double)(y1 - radius2) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius2 * -1.0D);
      }

      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x1 - radius3) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius3, (double)(y1 - radius3) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius3);
      }

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x1 - radius4) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius4, (double)(y + radius4) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius4);
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glLineWidth(1.0F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void setColor(int color) {
      float a = (float)(color >> 24 & 255) / 255.0F;
      float r = (float)(color >> 16 & 255) / 255.0F;
      float g = (float)(color >> 8 & 255) / 255.0F;
      float b = (float)(color & 255) / 255.0F;
      GL11.glColor4f(r, g, b, a);
   }

   public static void drawRoundedGradientRectCorner(float x, float y, float x1, float y1, float radius, int color, int color2, int color3, int color4) {
      setColor(-1);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      x = (float)((double)x * 2.0D);
      y = (float)((double)y * 2.0D);
      x1 = (float)((double)x1 * 2.0D);
      y1 = (float)((double)y1 * 2.0D);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      setColor(color);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glBegin(9);

      int i;
      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      setColor(color2);

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      setColor(color3);

      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      setColor(color4);

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
      setColor(-1);
   }

   public static void drawRoundedGradientOutlineCorner(float x, float y, float x1, float y1, float width, float radius, int color, int color2, int color3, int color4) {
      setColor(-1);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      x = (float)((double)x * 2.0D);
      y = (float)((double)y * 2.0D);
      x1 = (float)((double)x1 * 2.0D);
      y1 = (float)((double)y1 * 2.0D);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      setColor(color);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glLineWidth(width);
      GL11.glBegin(2);

      int i;
      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      setColor(color2);

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x + radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius * -1.0D);
      }

      setColor(color3);

      for(i = 0; i <= 90; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y1 - radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      setColor(color4);

      for(i = 90; i <= 180; i += 3) {
         GL11.glVertex2d((double)(x1 - radius) + Math.sin((double)i * 3.141592653589793D / 180.0D) * (double)radius, (double)(y + radius) + Math.cos((double)i * 3.141592653589793D / 180.0D) * (double)radius);
      }

      GL11.glEnd();
      GL11.glLineWidth(1.0F);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
      setColor(-1);
   }

   public static void drawImage(ResourceLocation image, float x, float y, float width, float height, float alpha) {
      GL11.glPushMatrix();
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
      mc.getTextureManager().bindTexture(image);
      Gui.drawModalRectWithCustomSizedTexture((float)((int)x), (float)((int)y), 0.0F, 0.0F, (float)((int)width), (float)((int)height), width, height);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void drawImage(ResourceLocation image, int x, int y, float width, float height, float alpha) {
      GL11.glPushMatrix();
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
      mc.getTextureManager().bindTexture(image);
      Gui.drawModalRectWithCustomSizedTexture((float)x, (float)y, 0.0F, 0.0F, (float)((int)width), (float)((int)height), width, height);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void drawImage(ResourceLocation image, float x, float y, float width, float height) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      mc.getTextureManager().bindTexture(image);
      Gui.drawModalRectWithCustomSizedTexture((float)((int)x), (float)((int)y), 0.0F, 0.0F, (float)((int)width), (float)((int)height), width, height);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }
}
