package net.lessqq.amidstforge;

import java.lang.reflect.Field;
import java.util.prefs.Preferences;

import javax.swing.SwingUtilities;

import amidst.Amidst;
import amidst.AmidstMetaData;
import amidst.AmidstSettings;
import amidst.Application;
import amidst.PerApplicationInjector;
import amidst.ResourceLoader;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = AmidstForgeMod.MOD_ID)
public class UIEventHandler {

  private GuiButton amidstButton;
  private Application application;

  @SubscribeEvent
  public void initGui(InitGuiEvent.Post evt) {
    GuiScreen gui = evt.getGui();
    if (gui instanceof GuiOptions) {
      int maxy = 0;
      for (GuiButton b : evt.getButtonList()) {
        maxy = b.y > maxy ? b.y : maxy;
      }
      amidstButton = new GuiButton(Integer.MIN_VALUE, 2, 2, 98, 20, I18n.format("amidstforge.ui.button.label"));
      evt.getButtonList().add(amidstButton);
    }
  }

  @SubscribeEvent
  public void postEvent(GuiScreenEvent.ActionPerformedEvent.Post evt) {
    if (evt.getGui() instanceof GuiOptions && evt.getButton() == amidstButton) {
      startAmidst();
    }
  }

  public synchronized void startAmidst() {
    if (application != null) {
      Object mainWindow = getMainWindow(application);
      if (mainWindow != null)
        return;
      application = null;
    }

    SwingUtilities.invokeLater(() -> {
      try {
        PerApplicationInjector injector = new PerApplicationInjector(new IntegratedMinecraftInstance(),
            AmidstMetaData.from(ResourceLoader.getProperties("/amidst/metadata.properties"),
                ResourceLoader.getImage("/amidst/icon/amidst-16x16.png"),
                ResourceLoader.getImage("/amidst/icon/amidst-32x32.png"),
                ResourceLoader.getImage("/amidst/icon/amidst-48x48.png"),
                ResourceLoader.getImage("/amidst/icon/amidst-64x64.png"),
                ResourceLoader.getImage("/amidst/icon/amidst-128x128.png"),
                ResourceLoader.getImage("/amidst/icon/amidst-256x256.png")),
            new AmidstSettings(Preferences.userNodeForPackage(Amidst.class)));
        application = injector.getApplication();
        application.run();
      } catch (Exception e) {
        throw new RuntimeException("failed to launch AMIDST", e);
      }
    });

  }

  private Object getMainWindow(Application app) {
    Field field;
    Object mainWindow;
    try {
      field = Application.class.getDeclaredField("mainWindow");
      field.setAccessible(true);
      mainWindow = field.get(app);
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
      throw new RuntimeException("Failed to check for Amidst instance", e);
    }
    return mainWindow;
  }

}