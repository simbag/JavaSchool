package com.sbt.javaschool.classloaders.Browser;


import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {

        try {
            PluginManager pluginManager = new PluginManager("src\\com\\sbt\\javaschool\\classloaders\\Browser\\Plugins");
            Plugin plugin1 = pluginManager.load("Plugin1", "PluginClass");
            Plugin plugin2 = pluginManager.load("Plugin2", "PluginClass");

            plugin1.printPluginName();
            plugin2.printPluginName();

            System.out.println("Изменили модель делегирования");

            plugin1 = pluginManager.loadPlugins("Plugin1", "PluginClass");
            plugin2 = pluginManager.loadPlugins("Plugin2", "PluginClass");

            plugin1.printPluginName();
            plugin2.printPluginName();

        } catch (ClassNotFoundException | MalformedURLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
