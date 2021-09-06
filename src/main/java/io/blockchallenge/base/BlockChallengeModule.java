package io.blockchallenge.base;


import org.bukkit.plugin.Plugin;

import java.io.File;

public abstract class BlockChallengeModule {

    protected final Plugin plugin;
    protected final String moduleName;
    protected final File moduleFolder;

    public BlockChallengeModule(Plugin plugin, String moduleName) {
        this.plugin = plugin;
        this.moduleName = moduleName;
        this.moduleFolder = new File(plugin.getDataFolder(), moduleName);
        createModuleFolder();
    }

    private void createModuleFolder() {
        if(!moduleFolder.exists() && moduleFolder.isDirectory()) {
            moduleFolder.mkdirs();
        }
    }

    public void onLoad() {
        createModuleFolder();
    }

    public abstract void onUnload();

}
